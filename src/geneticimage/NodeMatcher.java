/*
 * NodeMatcher.java
 *
 * Created on February 26, 2006, 12:40 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage;

import gen.functions.VectSwitch;
import java.util.*;
import utils.*;
import utils.linear.*;
import utils.estimates.*;

import functions.*;

/**
 *
 * @author Calvin Ashmore
 */
public class NodeMatcher {
    
    
    static public Pair<Node, Estimate> match(NodeFunctionFactory nff, Node base, List<Estimate> estimates,  List<Node> children) {
        
        NodeFunction currentNF = base.getFunction();
        
        Estimate[] estArr;
        if(estimates.size() > 0) {
            estArr = new Estimate[estimates.size()];
            for(int i=0;i<estimates.size();i++)
                estArr[i] = estimates.get(i);
        }
        else estArr = null;
        
        Estimate newEst = null;
        try {
             newEst = currentNF.estimate(estArr);
        } catch (NullPointerException e) {
            System.err.println("NullPointerException while estimating");
            System.err.println("inputs: ");
            for(int i=0;i<estimates.size();i++) {
                System.err.println("    estimate: "+estArr[i] + " child: "+children.get(i).getFunction());
            }
            System.err.println("node parameters: ");
            for(int i=0;i<currentNF.getNumberParameters();i++) {
                System.err.println("    "+currentNF.getParameterName(i)+" : "+currentNF.getParameter(i));
            }
            throw e;
        } catch (ClassCastException e) {
            System.err.println("ClassCastException while estimating");
            System.err.println("inputs: ");
            for(int i=0;i<estimates.size();i++) {
                System.err.println("    estimate: "+estArr[i] + " child: "+children.get(i).getFunction());
            }
            System.err.println("node parameters: ");
            for(int i=0;i<currentNF.getNumberParameters();i++) {
                System.err.println("    "+currentNF.getParameterName(i)+" : "+currentNF.getParameter(i));
            }
            throw e;
        }
        
        //Estimate newEst = currentNF.estimate((Estimate[]) estimates.toArray());
        
        // early exit if our estimate is constant
        // this will be simplified quickly.
        if(newEst.isConstant())
            return new Pair<Node,Estimate>(base, newEst);
        
        /*
         *
        // do miscellaneous checking here:
        // want to find optimizations, ideally ones that reduce the size of the tree.
        // use brute-force if conditions, but it's okay because we're only doing this
        // once per image build
        
        if(currentNF instanceof Abs) {
            if( ((Estimate_d)estimates.get(0)).getMinimum() > 0 )
                return new Pair<Node,Estimate>(children.get(0), estimates.get(0));
        }
        
        if(currentNF instanceof Div) {
            if( children.get(0) == children.get(1) )
                return new Pair<Node,Estimate>(nff.newNode(new Constant_d(1),base), new Estimate_d(1,1));
        }
        
        if(currentNF.getClass().getName().startsWith("Sub")) {
            if( children.get(0) == children.get(1) )
                return new Pair<Node,Estimate>(nff.newNode(new Constant_d(0),base), new Estimate_d(0,0));
        }
        
        if(currentNF.getClass().getName().contains("Ghost") ||
           currentNF.getClass().getName().contains("Blur") ||
           currentNF.getClass().getName().contains("WarpT") ) {
            
            Estimate est = ((NodeFunction_NodeBase)currentNF).getEstimate(0);
            if( est.isConstant() ) {
                if(currentNF.getClass().getName().endsWith("_d"))
                    return new Pair<Node,Estimate>(nff.newNode(new Constant_d(((Estimate_d)est).getCValue()),base), est);
                if(currentNF.getClass().getName().endsWith("_v2"))
                    return new Pair<Node,Estimate>(nff.newNode(new Constant_v2(((Estimate_v2)est).getCValue()),base), est);
                if(currentNF.getClass().getName().endsWith("_v3"))
                    return new Pair<Node,Estimate>(nff.newNode(new Constant_v3(((Estimate_v3)est).getCValue()),base), est);
            }
        }
        
        if(currentNF instanceof Max || currentNF instanceof Min) {
            double leftMin = ((Estimate_d)estimates.get(0)).getMinimum();
            double leftMax = ((Estimate_d)estimates.get(0)).getMaximum();
            double rightMin = ((Estimate_d)estimates.get(1)).getMinimum();
            double rightMax = ((Estimate_d)estimates.get(1)).getMaximum();
            
            if(children.get(0) == children.get(1))
                return new Pair<Node,Estimate>(children.get(0), estimates.get(0));
            
            if(currentNF instanceof Max) {
                if(leftMin >= rightMax)
                    return new Pair<Node,Estimate>(children.get(0), estimates.get(0));
                else if(rightMin > leftMax)
                    return new Pair<Node,Estimate>(children.get(1), estimates.get(1));
            }
            else {
                if(leftMax <= rightMin)
                    return new Pair<Node,Estimate>(children.get(0), estimates.get(0));
                else if(rightMax < leftMin)
                    return new Pair<Node,Estimate>(children.get(1), estimates.get(1));
            }
        }
        
        if(currentNF instanceof Sqrt && children.get(0).getFunction() instanceof Square) {
            //Node n = new Node(numberNodes++, new Abs());
            Node n = nff.newNode(new Abs(),base);
            n.assignChild(0, children.get(0).getChildren().get(0));
            return new Pair<Node,Estimate>(n, newEst);
        }
        
        if(currentNF.getClass().getName().contains("Threshold") ||
           currentNF.getClass().getName().contains("Interpolate")) {
            
            if(children.get(1) == children.get(2))
                return new Pair<Node,Estimate>(children.get(1), estimates.get(1));
            
            if(estimates.get(0) instanceof Estimate_d) {
                double minval = ((Estimate_d)estimates.get(0)).getMinimum();
                double maxval = ((Estimate_d)estimates.get(0)).getMaximum();
                
                if(maxval <= 0)
                    return new Pair<Node,Estimate>(children.get(1), estimates.get(1));
                else if(minval >= 1)
                    return new Pair<Node,Estimate>(children.get(2), estimates.get(2));
            }
        }
        
        if( (currentNF instanceof V3_x || 
             currentNF instanceof V3_y ||
             currentNF instanceof V3_z) &&
                (children.get(0).getFunction() instanceof New_v3 || children.get(0).getFunction() instanceof V3) ) {
            
            if(children.get(0).getFunction() instanceof V3) {
                if(currentNF instanceof V3_x)
                    return new Pair<Node,Estimate>(nff.newNode(new X(),base), newEst);
                else if(currentNF instanceof V3_y)
                    return new Pair<Node,Estimate>(nff.newNode(new X(),base), newEst);
                else if(currentNF instanceof V3_z)
                    return new Pair<Node,Estimate>(nff.newNode(new Constant_d(0),base), new Estimate_d(0,0));
            } else
                if(currentNF instanceof V3_x)
                    return new Pair<Node,Estimate>(children.get(0).getChildren().get(0), newEst);
                else if(currentNF instanceof V3_y)
                    return new Pair<Node,Estimate>(children.get(0).getChildren().get(1), newEst);
                else if(currentNF instanceof V3_z)
                    return new Pair<Node,Estimate>(children.get(0).getChildren().get(2), newEst);
        }
        
        if( (currentNF instanceof V2_x || 
             currentNF instanceof V2_y) &&
                (children.get(0).getFunction() instanceof New_v2 || children.get(0).getFunction() instanceof V2) ) {
            
            if(children.get(0).getFunction() instanceof V2) {
                if(currentNF instanceof V2_x)
                    return new Pair<Node,Estimate>(nff.newNode(new X(),base), newEst);
                else if(currentNF instanceof V2_y)
                    return new Pair<Node,Estimate>(nff.newNode(new Y(),base), newEst);
            } else
                if(currentNF instanceof V2_x)
                    return new Pair<Node,Estimate>(children.get(0).getChildren().get(0), newEst);
                else if(currentNF instanceof V2_y)
                    return new Pair<Node,Estimate>(children.get(0).getChildren().get(1), newEst);
        }*/
        
        // can't find a suitable simplification
        // so just use current form
        //if(newNode == null)
        //Node newNode = new Node(base.getID(), base.getFunction());
        
        return new Pair<Node,Estimate>(base, newEst);
    }
    
}
