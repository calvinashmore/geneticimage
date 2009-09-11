/*
 * Node.java
 *
 * Created on September 20, 2005, 11:57 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package geneticimage;

import java.util.*;
import java.io.*;
import utils.linear.*;

/**
 *
 * @author gtg126z
 */
public class Node implements Serializable, Cloneable {
    
    private Context myContext;
    private Class contextClass;
    
    //private static int nextID = 0;
    
    private int id;
    public int getID() {return id;}
    public void setID(int id) {this.id = id;}
    
    public Class getContextClass() {return contextClass;}
    
    private List<Node> children;
    private NodeFunction function;
    
    private transient Object cacheOutput = null;
    
    public Node(int id, NodeFunction function, Class contextClass) {
        
        this.id = id;
        this.contextClass = contextClass;
        
        Class inputClasses[] = function.getInputClasses();
        if(inputClasses == null)
            children = new ArrayList(0);
        else {
            children = new ArrayList(inputClasses.length);
            
            for(int i=0;i<inputClasses.length;i++)
                children.add(null);
        }
        
        this.function = function;
    }
    
    public void setContextClass(Class contextClass) {
        this.contextClass = contextClass;
    }
    
    public Class getOutputType() {
        return function.getReturnClass();
    }
    
    public Class[] getInputClasses() {
        return function.getInputClasses();
    }
    
    public boolean assignChild(int index, Node child) {
        
        Class inputClasses[] = getInputClasses();
        
        if(inputClasses == null)
            return false;
        
        if(index >= inputClasses.length)
            return false;
        
        // allowing child to be null here
        // for sake of use in editor
        if(child != null && child.getOutputType() != inputClasses[index])
            return false;
        
        children.set(index,child);
        return true;
    }
    public List<Node> getChildren() {return Collections.unmodifiableList(children);}
    public boolean allChildrenAssigned() {
        for(Node child : children)
            if(child == null)
                return false;
        return true;
    }
    
    public NodeFunction getFunction() {return function;}
    
    synchronized public void setContext(Context c) {
        try {
            cacheOutput = null;
            if(myContext != c) {
                myContext = c;
                for(Node child : children)
                    child.setContext(c);
            }
        } catch(NullPointerException e) {
            synchronized(System.err) {
                System.err.println(function);
                System.err.println("inputs: ");
                for(int i=0;i<children.size();i++)
                    System.err.println("    "+children.get(i));
                e.printStackTrace(System.err);
            }
            //throw e;
            throw new RuntimeException();
        }
    }
    
    synchronized public Context getContext() {return myContext;}
    
    synchronized public Object evaluate() {
        
        if(cacheOutput != null)
            return cacheOutput;
        
        List inputs = new ArrayList();
        for(Node child : children)
            inputs.add(child.evaluate());
        
        try {
            cacheOutput = function.evaluate(inputs, myContext);
        } catch (ClassCastException e) {
            synchronized(System.err) {
                System.err.println(function);
                System.err.println("inputs: ");
                for(int i=0;i<children.size();i++)
                    System.err.println("    "+children.get(i).getFunction()+" ("+children.get(i).getOutputType()+") -> " + inputs.get(i));
                e.printStackTrace(System.err);
            }
            //throw e;
            throw new RuntimeException();
        } catch (NullPointerException e) {
            synchronized(System.err) {
                System.err.println(function);
                System.err.println("inputs: ");
                for(int i=0;i<children.size();i++)
                    System.err.println("    "+children.get(i).getFunction()+" ("+children.get(i).getOutputType()+") -> " + inputs.get(i));
                e.printStackTrace(System.err);
            }
            //throw e;
            throw new RuntimeException();
        }
        
        // invalidity corrections
        checkInvalid();
        
        return cacheOutput;
    }
    
    private void checkInvalid() {
        if(cacheOutput instanceof LDouble) {
            LDouble v = (LDouble)cacheOutput;
            if(Double.isInfinite(v.val) || Double.isNaN(v.val))
                v.val = 0;
        }
        else if(cacheOutput instanceof LVect2d) {
            LVect2d v = (LVect2d)cacheOutput;
            if(Double.isInfinite(v.x) || Double.isNaN(v.x))
                v.x = 0;
            if(Double.isInfinite(v.y) || Double.isNaN(v.y))
                v.y = 0;
        }
        else if(cacheOutput instanceof Complex) {
            Complex v = (Complex)cacheOutput;
            if(Double.isInfinite(v.x) || Double.isNaN(v.x))
                v.x = 0;
            if(Double.isInfinite(v.y) || Double.isNaN(v.y))
                v.y = 0;
        }
        else if(cacheOutput instanceof LVect3d) {
            LVect3d v = (LVect3d)cacheOutput;
            if(Double.isInfinite(v.x) || Double.isNaN(v.x))
                v.x = 0;
            if(Double.isInfinite(v.y) || Double.isNaN(v.y))
                v.y = 0;
            if(Double.isInfinite(v.z) || Double.isNaN(v.z))
                v.z = 0;
        }
        else if(cacheOutput instanceof Color) {
            Color v = (Color)cacheOutput;
            if(Double.isInfinite(v.r) || Double.isNaN(v.r))
                v.r = 0;
            if(Double.isInfinite(v.g) || Double.isNaN(v.g))
                v.g = 0;
            if(Double.isInfinite(v.b) || Double.isNaN(v.b))
                v.b = 0;
        }
        else if(cacheOutput instanceof Quaternion) {
            Quaternion v = (Quaternion)cacheOutput;
            if(Double.isInfinite(v.u) || Double.isNaN(v.u))
                v.u = 0;
            if(Double.isInfinite(v.i) || Double.isNaN(v.i))
                v.i = 0;
            if(Double.isInfinite(v.j) || Double.isNaN(v.j))
                v.j = 0;
            if(Double.isInfinite(v.k) || Double.isNaN(v.k))
                v.k = 0;
        }
    }
    
    
    // this sets up the node and makes it ready for evaluation
    private transient boolean isSetup;
    public void setup() {
        
        if(!isSetup) {
            function.setup();
            isSetup = true;
        }
        
        for(Node child : children)
            if(child != null)
                child.setup();
    }
    
    /*
    public String toString() {
        
        return toString1("");
    }
    
    public String toString1(String space) {
        
        String r = space + getOutputType().getName() + " <= " + function.getClass().getName() + " (" + id + ")\n";
        
        if(function instanceof NodeFunction_NodeBase) {
            NodeFunction_NodeBase f1 = (NodeFunction_NodeBase)function;
            for(int i=0;i<f1.getNumberSubnodes();i++)
                r += "{\n" + f1.getNode(i).toString() + "}\n";
        }
        
        for(Node child : children)
            r += child.toString1(space + " ");
        
        return r;
    }*/
    
    public boolean isXDependent() {
        if(function instanceof functions.X || function instanceof functions.V2)
            return true;
        
        boolean satisfied = false;
        for(int i=0;i<children.size() && !satisfied;i++)
            satisfied = children.get(i).isXDependent();
        return satisfied;
    }
    
    public boolean isYDependent() {
        if(function instanceof functions.Y || function instanceof functions.V2)
            return true;
        
        boolean satisfied = false;
        for(int i=0;i<children.size() && !satisfied;i++)
            satisfied = children.get(i).isYDependent();
        return satisfied;
    }
    
    public Node clone() {
        
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeUnshared(this);
            byte data[] = bos.toByteArray();

            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bis);

            Node clone = (Node)ois.readObject();
            return clone;
        }
        catch(IOException e) {throw new RuntimeException(e);}
        catch(ClassNotFoundException e) {throw new RuntimeException(e);}
    }

    public String getName() {
        return function.getClass().getName();
    }

    public String getDescription() {
        return function.getDescription();
    }

    public int getNumberInputs() {
        if(function instanceof NodeFunction_NodeBase) {
            int r = ((NodeFunction_NodeBase)function).getNumberSubnodes();
            if(function.getInputClasses() != null)
                r += function.getInputClasses().length;
            return r;
        } else {
            if(function.getInputClasses() == null)
                return 0;
            return function.getInputClasses().length;
        }
    }

    public String getInputName(int i) {
        if(function instanceof NodeFunction_NodeBase) {
            if(i < ((NodeFunction_NodeBase)function).getNumberSubnodes()) {
                return ((NodeFunction_NodeBase)function).getNodeInputName(i);
            } else
                return function.getInputName(i - ((NodeFunction_NodeBase)function).getNumberSubnodes());
        }
        else return function.getInputName(i);
    }

    public Class getInputType(int i) {
        if(function instanceof NodeFunction_NodeBase) {
            if(i < ((NodeFunction_NodeBase)function).getNumberSubnodes()) {
                return ((NodeFunction_NodeBase)function).getNodeBaseClass(i);
            } else
                return function.getInputClasses()[i - ((NodeFunction_NodeBase)function).getNumberSubnodes()];
        }
        else return getInputClasses()[i];
    }
    
    public List<Node> getInputs() {
        List r = new ArrayList(getNumberInputs());
        for(int i=0;i<getNumberInputs();i++)
            r.add(getInput(i));
        return r;
    }

    public Node getInput(int i) {
        if(function instanceof NodeFunction_NodeBase) {
            if(i < ((NodeFunction_NodeBase)function).getNumberSubnodes()) {
                return ((NodeFunction_NodeBase)function).getNode(i);
            } else
                return children.get(i - ((NodeFunction_NodeBase)function).getNumberSubnodes());
        }
        else return children.get(i);
    }

    public void setInput(int i, Node node) {
        if(function instanceof NodeFunction_NodeBase) {
            if(i < ((NodeFunction_NodeBase)function).getNumberSubnodes()) {
                ((NodeFunction_NodeBase)function).setNode(i, (Node)node);
            } else
                assignChild(i - ((NodeFunction_NodeBase)function).getNumberSubnodes(),(Node)node);
        }
        else assignChild(i,(Node)node);
    }
    
    public Class getInputContext(int i, Class backupContext) {
        if(function instanceof NodeFunction_NodeBase)
            if(i < ((NodeFunction_NodeBase)function).getNumberSubnodes() )
                return ((NodeFunction_NodeBase)function).getNodeContextClass(i);
        return backupContext;
    }

    public int getNumberParameters() {
        return function.getNumberParameters();
    }

    public String getParameterName(int i) {
        return function.getParameterName(i);
    }

    public Class getParameterType(int i) {
        return function.getParameterType(i);
    }

    public Object getParameterValue(int i) {
        return function.getParameter(i);
    }

    public void setParameterValue(int i, Object value) {
        function.setParameter(i,value);
    }
}
