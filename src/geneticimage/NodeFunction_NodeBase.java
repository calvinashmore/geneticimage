/*
 * NodeFunction_NodeBase.java
 *
 * Created on September 27, 2005, 5:38 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package geneticimage;

import utils.estimates.Estimate;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class NodeFunction_NodeBase extends NodeFunction {
    
    private Node myNodes[];
    private Estimate matchEstimates[];
    
    // used only in the estimate function
    // this is the estimate of the return value of myNode
    
    /** Creates a new instance of NodeFunction_NodeBase */
    public NodeFunction_NodeBase() {this(null);}
    
    public NodeFunction_NodeBase(NodeFunctionFactory nff) {
        
        int n = getNumberSubnodes();
        myNodes = new Node[n];
        matchEstimates = new Estimate[n];
        
        try { 
            if(nff != null) {
                for(int i=0;i<n;i++)
                    myNodes[i] = nff.makeTree(getNodeContextClass(i), getNodeBaseClass(i), 2);
                    // 2 is arbitrary, but may limit the size of the tree.
            }
        } catch(Exception e) {throw new RuntimeException(""+this.getClass(),e);}
    }
    
    public void setup() {
        for(Node node : myNodes)
            node.setup();
    }
    
    public int getNumberSubnodes() {return 1;}
    
    public Node getNode(int i) {return myNodes[i];}
    public void setNode(int i, Node node) {myNodes[i] = node;}
    public Estimate getEstimate(int i) {return matchEstimates[i];}
    public void setEstimate(int i, Estimate estimate) {matchEstimates[i] = estimate;}
    
    public abstract Class getNodeContextClass(int i);
    public abstract Class getNodeBaseClass(int i);
    public abstract String getNodeInputName(int i);
}
