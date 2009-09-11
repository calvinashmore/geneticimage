
/*
 * Mutator.java
 *
 * Created on October 11, 2005, 10:35 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package geneticimage;
import java.util.*;
import java.lang.reflect.*;
import utils.*;
import utils.estimates.Estimate;
import utils.linear.*;

/**
 *
 * @author gtg126z
 */
public class NodeBuilder {
    
    private boolean logging;
    public void setLogging(boolean log) {logging = log;}
    
    // builderNFF is only used for new instances of NFs
    private NodeFunctionFactory builderNFF = new NodeFunctionFactory();
    
    private ImageManager imageManager;
    public NodeFunctionFactory makeNFF(int depth) {
        NodeFunctionFactory nff = new NodeFunctionFactory(depth);
        //nff.setImageManager(imageManager);
        return nff;
    }
    
    public ImageManager getImageManager() {return imageManager;}
    
    /** Creates a new instance of Mutator */
    public NodeBuilder() {
        logging = false;
        imageManager = new ImageManager();
    }
    
    public Node buildStartingNode() {
        Node n = buildNode(utils.linear.Color.class, ContextXY.class, true, false, 4, 20, 2);
        n.setup();
        return n;
    }
    
    public Node buildNode(Class returnClass, Class contextClass, boolean xandy, boolean xory, int depth, int size, int nbsize) {
        
        NodeFunctionFactory nff;
        Node evaluator;
        boolean okay = false;
        
        do {
            nff = makeNFF(depth);
            evaluator = nff.makeTree(contextClass, returnClass);
            
            if(nff.getNumberNodes() > size || nff.getNumberNBNodes() > nbsize)
                continue;
            
            Pair<Node, Estimate> match = nff.match(evaluator);
            evaluator = match.getLeft();
            
            if(xandy && contextClass == ContextXY.class) {
                if(!evaluator.isXDependent() || !evaluator.isYDependent())
                    continue;
            } else if(xory && contextClass == ContextXY.class)
                if(!evaluator.isXDependent() && !evaluator.isYDependent())
                    continue;
            
            okay = true;
        
        } while(!okay);
        
        return evaluator;
    }
    
    public boolean check(Node node) {
        if(node == null) {
            return false;
        }
        for(Node node1 : node.getInputs())
            if(!check(node1))
                return false;
        return true;
    }
    
    
    public List<Node> gatherNodes(Node target) {
        List<Node> gathered = new ArrayList();
        
        gatherNodes(target, gathered);
        return gathered;
    }
    
    private void gatherNodes(Node target, List<Node> current) {
        
        if(target == null)
            return;
        
        if(current.contains(target))
            return;
        
        current.add(target);
        
        for(Node n : target.getInputs())
            gatherNodes(n, current);
        
        if(target.getFunction() instanceof NodeFunction_NodeBase) {
            NodeFunction_NodeBase f1 = (NodeFunction_NodeBase)target.getFunction();
            for(int i=0;i<f1.getNumberSubnodes();i++) {
                Node nb = f1.getNode(i);
                gatherNodes(nb, current);
            }
        }
    }
    
    public Object varyParameter(Object parameter) {
        Class type = parameter.getClass();
        if(type == Double.class) {
            double v = (Double)parameter;
            return v*(4*Math.random()-2);
        }
        else if(parameter instanceof double[]) {
            double[] v = (double[])parameter;
            double[] r = new double[v.length];
            for(int i=0;i<v.length;i++) {
                 r[i] = v[i]*(4*Math.random()-2);
            }
            return r;
        }
        else if(parameter instanceof double[][]) {
            double[][] v = (double[][])parameter;
            double[][] r = new double[v.length][v[0].length];
            for(int i=0;i<v.length;i++)
            for(int j=0;j<v[0].length;j++) {
                 r[i][j] = v[i][j]*(4*Math.random()-2);
            }
            return r;
        }
        else if(parameter instanceof double[][][]) {
            double[][][] v = (double[][][])parameter;
            double[][][] r = new double[v.length][v[0].length][v[0][0].length];
            for(int i=0;i<v.length;i++)
            for(int j=0;j<v[0].length;j++)
            for(int k=0;k<v[0][0].length;k++) {
                 r[i][j][k] = v[i][j][k]*(4*Math.random()-2);
            }
            return r;
        }
        else if(parameter instanceof LVect2d) {
            LVect2d v = (LVect2d)parameter;
            LVect2d r = new LVect2d();
            r.x = v.x*(4*Math.random()-2);
            r.y = v.y*(4*Math.random()-2);
            return r;
        }
        else if(parameter instanceof Complex) {
            Complex v = (Complex)parameter;
            Complex r = new Complex();
            r.x = v.x*(4*Math.random()-2);
            r.y = v.y*(4*Math.random()-2);
            return r;
        }
        else if(parameter instanceof LVect3d) {
            LVect3d v = (LVect3d)parameter;
            LVect3d r = new LVect3d();
            r.x = v.x*(4*Math.random()-2);
            r.y = v.y*(4*Math.random()-2);
            r.z = v.z*(4*Math.random()-2);
            return r;
        }
        else if(parameter instanceof Color) {
            Color v = (Color)parameter;
            Color r = new Color();
            r.r = v.r*(4*Math.random()-2);
            r.g = v.g*(4*Math.random()-2);
            r.b = v.b*(4*Math.random()-2);
            return r;
        }
        else if( Enum.class.isAssignableFrom(type) ) {
            Enum v = (Enum)parameter;
            try {
                //utils.linear.grid.GridScaleMethod.
                Method m = v.getClass().getMethod("values");
                Enum[] types = (Enum[])m.invoke(v);
                return types[new Random().nextInt(types.length)];
            } finally {
                return parameter;
            }
            
        }
        
        return parameter;
    }

    public void randomizeParameters(final NodeFunction nf) {
        int numberParams = nf.getNumberParameters();
        for(int i=0;i<numberParams;i++) {
            Object parameter = nf.getParameter(i);
            Object variedParameter = varyParameter(parameter);
            nf.setParameter(i,variedParameter);
            nf.setParametersChanged(true);
        }
    }
}
