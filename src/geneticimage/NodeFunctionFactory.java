/*
 * NodeFunctionFactory.java
 *
 * Created on September 23, 2005, 11:21 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package geneticimage;

import utils.*;

import java.util.*;
import java.lang.reflect.*;


import functions.*;
import gen.functions.AllFn;

import utils.estimates.*;

/**
 *
 * @author gtg126z
 */
public class NodeFunctionFactory {
    
    //private static NodeFunctionFactory gNFF;
    //static NodeFunctionFactory getNFF() {return gNFF;}
    
    // ideally, would be able to do all of this at runtime, but oh well.
    // all node functions need a default constructor, I think
    private static List<NodeFunction> allFunctions;
    private static Map<Class, NodeFunction> allFunctionMap;
    //List<Class<? extends NodeFunction>> allFunctions;
    private Map<Class, List<Node>> allNodes;
    private Map<Integer, Node> allNodesByID;
    //private Map<Class, Node> contextDirectNodes;
    private static Map<Class, Context> contextTable;
    private Map<Node, Pair<Node,Estimate>> matchMap;
    private Random myRand;
    
    private Context getContext(Class contextClass) {
        
        Context context = contextTable.get(contextClass);
        if(context == null) {
            try {
                context = (Context)contextClass.newInstance();
            }
            catch (InstantiationException ex) {throw new RuntimeException("Problem with context??",ex);}
            catch (IllegalAccessException ex) {throw new RuntimeException("Problem with context??",ex);}
            
            contextTable.put(contextClass,context);
        }
        return context;
    }
    
    //private ImageManager imageManager;
    
    private int numberNodes;
    private int numberNBNodes;
    private int targetDepth;
    private float reuseProbability = .33f;
    
    static {
        allFunctions = new AllFunctions().getFunctions();
        allFunctionMap = new Hashtable();
        contextTable = new Hashtable();
        
        for(NodeFunction nf : allFunctions)
            allFunctionMap.put(nf.getClass(),nf);
    }
    
    public static List<NodeFunction> allFunctions() {
        return Collections.unmodifiableList(allFunctions);
    }
    
    //public Node getContextDirectNode(Class c) {
    //    return contextDirectNodes.get(c);
    //}
    
    public NodeFunctionFactory() {this(5);}
    
    /** Creates a new instance of NodeFunctionFactory */
    public NodeFunctionFactory(int targetDepth) {
        
        this.numberNodes = 0;
        this.numberNBNodes = 0;
        this.targetDepth = targetDepth;
        
        myRand = new Random();
        allNodes = new Hashtable();
        allNodesByID = new Hashtable();
        
        matchMap = new Hashtable();
        //contextDirectNodes = new Hashtable();
        
        // build context-direct nodes.
        //for(NodeFunction nf : allFunctions)
        //    if(nf.isContextDirect())
        //        contextDirectNodes.put(nf.getClass(), new Node(numberNodes++, /*pureBuild*/shallowBuild(nf.getClass())) );
    }
    
    public float getNFClassWeight(Class<? extends Context> contextClass, Class<? extends NodeFunction> nfClass) {
        
        if(contextClass == ContextNone.class) {
            if(nfClass.getName().contains("Constant"))
                return 1000;
            if(nfClass.getName().contains("PerlinParameters") && !nfClass.getName().contains("PerlinParameters1"))
                return 0;
            if(nfClass.getName().endsWith("1"))
                return 100;
        }
        
        /*
        // DEBUG!!!
        if(nfClass.getName().contains("Image"))
            return 0.7f;
        
        //if(nfClass.getName().contains("Geometric"))
        //    return 1.0f;
        
        //if(nfClass.getName().contains("CellAutomata"))
        //    return 20.0f;
        
        if(nfClass.getName().contains("Cell"))
            return 5.0f;
        
        if(nfClass.getName().contains("Buffer"))
            return 5.0f;
        
        if(nfClass.getName().contains("CFractal"))
            return 5.0f;
        
        if(nfClass.getName().contains("Lyapunov"))
            return 100;
        
        if(nfClass.getName().contains("Attractors"))
            return 100;
        
        if(nfClass.getName().contains("Quadtree"))
            return 100;
        if(nfClass.getName().contains("Curves"))
            return 10000;
        */
        
        return 1.0f;
    }
    
    public int getNumberNodes() {return numberNodes;}
    public int getNumberNBNodes() {return numberNBNodes;}
    
    public Node makeTree(Class baseContextClass, Class outputClass) {return makeTree(baseContextClass, outputClass, 0);}
    
    public Node makeTree(Class baseContextClass, Class outputClass, int depth) {
        // would also want some space limiting parameters in here...
        
        // *** first, seek already created nodes
        if(myRand.nextFloat() < reuseProbability) {
            List<Node> reuseNodes = allNodes.get(outputClass);
            if(reuseNodes != null)
                return reuseNodes.get(myRand.nextInt(reuseNodes.size()));
        }
        
        // *** seek an appropriate function
        NodeFunction nf = randomByOutput(baseContextClass, outputClass, depth>=targetDepth);
        
        // *** if we are in too deep, seek a terminal function
        if(     (numberNBNodes >= 2 && nf instanceof NodeFunction_NodeBase) ||
                (depth >= targetDepth && nf != null && nf.getInputClasses() != null)) {
            int check = 10 + (int)Math.sqrt(numberNodes) + 3*numberNBNodes;
            
            for(int i=0; i<check && nf != null && (nf.getInputClasses() != null || nf instanceof NodeFunction_NodeBase); i++)
                nf = randomByOutput(baseContextClass, outputClass, true);
            
        }
        
        if(nf == null)
            throw new RuntimeException("Cannot find builder with output: " + outputClass + " (" + depth +"/"+targetDepth+" deep)");
        
        //if(nf.isContextDirect())
        //    return contextDirectNodes.get(nf.getClass());
        
        if(nf instanceof NodeFunction_NodeBase) {
            numberNBNodes++;
        }
        
        // *** okay, we've found the nf we are looking for,
        // build a real one
        // the current nf is just a shallow copy
        nf = build(nf.getClass());
        
        Node node = newNode(nf, baseContextClass);
        
        // *** fill subchildren
        Class inputClasses[] = node.getInputClasses();
        if(inputClasses != null)
            for(int i=0; i<inputClasses.length; i++) {
                node.assignChild(i, makeTree(baseContextClass, inputClasses[i], depth+1));
            }
        
        // *** add to list of all nodes
        List<Node> coNodes = allNodes.get(outputClass);
        if(coNodes == null) {
            coNodes = new ArrayList();
            allNodes.put(outputClass, coNodes);
        }
        coNodes.add(node);
        
        allNodesByID.put(node.getID(), node);
            
        return node;
    }
    
    public NodeFunction randomByOutput(Class contextClass, Class outputClass, boolean seekTerminal) {
        
        Context context = getContext(contextClass);
                
        List<Class<? extends NodeFunction>> matches = new ArrayList();
        for(NodeFunction nf : allFunctions)
            if(nf.getReturnClass() == outputClass && 
               nf.isContextUsable(context) &&
                    (!seekTerminal || (nf.getInputClasses() == null && !(nf instanceof NodeFunction_NodeBase) )) )
                matches.add(nf.getClass());
        
        // if we are seeking a terminal, and there are no possible terminals, go ahead and
        // just select from all possible outputs
        if(matches.size() == 0 && seekTerminal)
            for(NodeFunction nf : allFunctions)
                if(nf.getReturnClass() == outputClass &&
                   nf.isContextUsable(context))
                    matches.add(nf.getClass());
            
        
        if(matches.size() == 0) {
            System.out.println("Cannot match output class " + outputClass.getName() + " in context " + contextClass.getName());
            return null;
        }
            
        // select from this list, using weights
        float weightTotal = 0;
        for(Class<? extends NodeFunction> nfc : matches)
            weightTotal += getNFClassWeight(contextClass,nfc);
        
        float target = myRand.nextFloat()*weightTotal;
        int index = 0;
        for(Class<? extends NodeFunction> nfc : matches) {
            target -= getNFClassWeight(contextClass,nfc);
            if(target < 0)
                break;
            index++;
        }
        
        return shallowBuild(matches.get(index));
    }
    
    public NodeFunction shallowBuild(Class<? extends NodeFunction> nfClass){
        
        try {
            return nfClass.newInstance();
        }
        catch(IllegalAccessException e) {}
        catch(InstantiationException e) {}
        
        NodeFunction nf = new AllFn().build(nfClass,null);
        if(nf != null)
            return nf;
        
        throw new RuntimeException("Failed to instantiate class: "+nfClass.getName());
    }
    
    public NodeFunction build(Class<? extends NodeFunction> nfClass){
        
        try {
            try{
                Constructor<? extends NodeFunction> c = nfClass.getConstructor(NodeFunctionFactory.class);
                return c.newInstance(this);
            } catch (NoSuchMethodException e) {}
            
            return nfClass.newInstance();
        }
        catch(IllegalAccessException e) {}
        catch(InstantiationException e) {}
        catch(InvocationTargetException e) {} 
        
        NodeFunction nf = new AllFn().build(nfClass,this);
        if(nf != null)
            return nf;
        
        throw new RuntimeException("Failed to instantiate class: "+nfClass.getName());
    }
    
    public Node newNode(NodeFunction nf, Class contextClass) {
        return new Node(numberNodes++, nf, contextClass);
    }
    
    public Node newNode(NodeFunction nf, Node substitute) {
        return new Node(numberNodes++, nf, substitute.getContextClass());
    }
    
    public Pair<Node, Estimate> match(Node base) {
        
        if(matchMap.get(base) != null)
            return matchMap.get(base);
        
        List<Estimate> estimates = new ArrayList();
        List<Node> children = new ArrayList();
        
        if(base.getFunction() instanceof NodeFunction_NodeBase) {
            NodeFunction_NodeBase f1 = (NodeFunction_NodeBase)base.getFunction();
            
            for(int i=0;i<f1.getNumberSubnodes();i++) {
                Node fbase = f1.getNode(i);
                Pair<Node, Estimate> fm = match(fbase);
                f1.setEstimate(i,fm.getRight());
                f1.setNode(i,fm.getLeft());
            }
        }
        
        int i=0;
        for(Node n : base.getChildren()) {
            if(n==null)
                System.exit(0);
            Pair<Node, Estimate> matchChild = match(n);
            
            estimates.add(matchChild.getRight());
            children.add(matchChild.getLeft());
        }
        
        Pair<Node, Estimate> m = NodeMatcher.match(this, base, estimates, children);
        if(m.getRight().isConstant()) {
            
            Estimate e = m.getRight();
            if(e instanceof Estimate_d) {
                
                double d = ((Estimate_d)e).getMaximum();
                //return new Pair<Node, Estimate>(new Node(-1, new Constant_d(d)), e);
                return new Pair<Node, Estimate>(newNode(new Constant_d(d),base), e);
                
            } else if(e instanceof Estimate_v2) {
                
                double x = ((Estimate_v2)e).getXMaximum();
                double y = ((Estimate_v2)e).getYMaximum();
                //return new Pair<Node, Estimate>(new Node(-1, new Constant_v2(x,y)), e);
                return new Pair<Node, Estimate>(newNode(new Constant_v2(x,y),base), e);
                
            } else if(e instanceof Estimate_v3) {
                
                double x = ((Estimate_v3)e).getXMaximum();
                double y = ((Estimate_v3)e).getYMaximum();
                double z = ((Estimate_v3)e).getZMaximum();
                //return new Pair<Node, Estimate>(new Node(-1, new Constant_v3(x,y,z)), e);
                return new Pair<Node, Estimate>(newNode(new Constant_v3(x,y,z),base), e);
                
            } else if(e instanceof Estimate_col) {
                
                double r = ((Estimate_col)e).getRMaximum();
                double g = ((Estimate_col)e).getGMaximum();
                double b = ((Estimate_col)e).getBMaximum();
                //return new Pair<Node, Estimate>(new Node(-1, new Constant_col(r,g,b)), e);
                return new Pair<Node, Estimate>(newNode(new Constant_col(r,g,b),base), e);
            }
        }
        
        matchMap.put(base, m);
        return m;
    }
    
    
    public List<NodeFunction> getOneToOneFunctions(Class type) {
        List<NodeFunction> r = new ArrayList();
        for(NodeFunction nf : allFunctions) {
            if(nf.getReturnClass() == type && nf.getInputClasses() != null &&
                    nf.getInputClasses().length == 1 && nf.getInputClasses()[0] == type &&
                    !(nf instanceof NodeFunction_NodeBase))
                r.add(nf);
        }
        return r;
    }
    
    public List<NodeFunction> getOneToBranchFunctions(Class type) {
        List<NodeFunction> r = new ArrayList();
        for(NodeFunction nf : allFunctions) {
            if(nf.getReturnClass() == type && nf.getInputClasses() != null &&
                    !(nf instanceof NodeFunction_NodeBase))
                for(Class c : nf.getInputClasses())
                    if(c == type && !r.contains(nf))
                        r.add(nf);
        }
        return r;
    }
    
    public List<NodeFunction> getOneToBranchFunctions(Class outtype, Class intype) {
        List<NodeFunction> r = new ArrayList();
        for(NodeFunction nf : allFunctions) {
            if(nf.getReturnClass() == outtype && nf.getInputClasses() != null &&
                    !(nf instanceof NodeFunction_NodeBase))
                for(Class c : nf.getInputClasses())
                    if(c == intype && !r.contains(nf))
                        r.add(nf);
        }
        return r;
    }
}
