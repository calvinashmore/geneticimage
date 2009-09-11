/*
 * MutateThread.java
 *
 * Created on June 3, 2006, 6:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.linear.Color;
import utils.linear.Complex;
import utils.linear.LVect2d;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class MutateThread extends BuilderThread {
    
    private boolean logging;
    private Node result;
    private Node param;
    public void setLogging(boolean logging) {this.logging = logging;}
    
    private NodeBuilder builder;
    public MutateThread(NodeBuilder builder) {
        this.builder = builder;
    }
    
    public void setParameter(Node x) {param = x;}
    public Node getResult() {return result;}
    
    public void run() {
        result = mutate(param);
        if(isTerminated())
            result = null;
        synchronized(this) {
            notify();
        }
    }
    
    
    public Node mutate(Node base) {
        Node r = null;
        
        Random rand = new Random();
        
        if(logging)
            System.out.println("generating mutant");
        
        boolean mutated = false;
        while(!mutated && !isTerminated()) {
            
            r = base.clone();
            int option = rand.nextInt(8);
            
            switch(option) {
                case 0:
                    if(logging)
                        System.out.println("mutate parameter");
                    mutated = mutateParameter(r);
                    break;
                case 1:
                    if(logging)
                        System.out.println("expand constant");
                    mutated = expandConstant(r);
                    break;
                case 2:
                    if(logging)
                        System.out.println("random replace");
                    mutated = randomReplace(r);
                    break;
                case 3:
                    if(logging)
                        System.out.println("mutate insert");
                    mutated = mutateInsert(r);
                    break;
                case 4:
                    if(logging)
                        System.out.println("mutate branch");
                    mutated = mutateBranch(r);
                    break;
                case 5:
                    if(logging)
                        System.out.println("mutate split");
                    mutated = mutateSplit(r);
                    break;
                case 6:
                    if(logging)
                        System.out.println("mutate bridge");
                    mutated = mutateBridge(r);
                    break;
                case 7:
                    if(logging)
                        System.out.println("mutate merge");
                    mutated = mutateMerge(r);
                    break;
            }
            
            if(r != null && !builder.check(r)) {
                // System.err.println("In mutate, check fails with option "+option);
                mutated = false;
            }
        }
        
        if(logging)
            System.out.println("finished generating mutant");
        
        // setup, now r is complete
        r.setup();
        
        return r;
    }
    
    public boolean mutateParameter(Node target) {
        List<Node> allNodes = builder.gatherNodes(target);
        List<Node> paramNodes = new ArrayList();
        
        for(Node n : allNodes)
            //if(n.getFunction().getParameters() != null)
            if(n.getNumberParameters() > 0)
                paramNodes.add(n);
        
        if(paramNodes.isEmpty())
            return false; 
        
        Random rand = new Random();
        
        NodeFunction nf = paramNodes.get( rand.nextInt(paramNodes.size()) ).getFunction();
        builder.randomizeParameters(nf);
        
        return true;
    }
    
    public boolean expandConstant(Node target) {
        List<Node> allNodes = builder.gatherNodes(target);
        List<Node> constNodes = new ArrayList();
        
        for(Node n : allNodes)
            if(n.getFunction().getClass().getName().contains("Constant"))
                constNodes.add(n);
        
        if(constNodes.isEmpty())
            return false;
        
        Random rand = new Random();
        
        Node constNode = constNodes.get(rand.nextInt(constNodes.size()));
        Class returnClass = constNode.getOutputType();
        
        Node replacement = builder.buildNode(returnClass, target.getContextClass(), false, true, 3, 10, 1);
        
        for(Node n : allNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == constNode)
                    n.setInput(i, replacement);
        
        return true;
    }
    
    public boolean randomReplace(Node target) {
        List<Node> allNodes = builder.gatherNodes(target);
        
        Random rand = new Random();
        
        Node replaceNode = allNodes.get(rand.nextInt(allNodes.size()));
        Class returnClass = replaceNode.getOutputType();
        
        Node replacement = builder.buildNode(returnClass, target.getContextClass(), false, false, 4, 20, 2);
        
        for(Node n : allNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == replaceNode)
                    n.setInput(i, replacement);
        
        return true;
    }
    
    public boolean mutateInsert(Node target) {
        
        List<Node> allNodes = builder.gatherNodes(target);
        Random rand = new Random();
        
        NodeFunctionFactory nff = builder.makeNFF(1);
        
        Node insertNode;
        boolean found = false;
        
        for(int i=0;i<100 && !found; i++) {
             insertNode = allNodes.get(rand.nextInt(allNodes.size()));
             List<NodeFunction> insertables = nff.getOneToOneFunctions(insertNode.getOutputType());
             if(insertables.size() == 0)
                 continue;
             
             NodeFunction insertNF = nff.build( insertables.get(rand.nextInt(insertables.size())).getClass() );
             Node inserted = new Node(0, insertNF, target.getContextClass());
             inserted.setInput(0, insertNode);
             
            for(Node n : allNodes)
                for(int j=0; j<n.getInputs().size(); j++)
                    if(n.getInputs().get(j) == insertNode)
                        n.setInput(j, inserted);
            return true;
        }
        if(!found)
            return false;
        
        // should be unreachable
        return false;
    }
    
    public boolean mutateBranch(Node target) {
        
        List<Node> allNodes = builder.gatherNodes(target);
        Random rand = new Random();
        
        NodeFunctionFactory nff = builder.makeNFF(1);
        
        Node insertNode;
        boolean found = false;
        
        for(int i=0;i<100 && !found; i++) {
             insertNode = allNodes.get(rand.nextInt(allNodes.size()));
             List<NodeFunction> insertables = nff.getOneToBranchFunctions(insertNode.getOutputType());
             if(insertables.size() == 0)
                 continue;
             
             NodeFunction insertNF = nff.build( insertables.get(rand.nextInt(insertables.size())).getClass() );
             Node inserted = new Node(0, insertNF, target.getContextClass());
             
             boolean hasInserted = false;
             for(int j = 0; j<inserted.getNumberInputs(); j++) {
                 
                 if(!hasInserted && inserted.getInputType(j) == insertNode.getOutputType()) {
                     inserted.setInput(j, insertNode);
                     hasInserted = true;
                 }
                 else
                     inserted.setInput(j, builder.buildNode(inserted.getInputType(j), 
                             inserted.getInputContext(j,insertNode.getContextClass()), false, false, 2, 10, 1));
             }
             
             if(!hasInserted)
                 continue;
             
            for(Node n : allNodes)
                for(int j=0; j<n.getInputs().size(); j++)
                    if(n.getInputs().get(j) == insertNode)
                        n.setInput(j, inserted);
            return true;
        }
        if(!found)
            return false;
        
        // should be unreachable
        return false;
    }
    
    public boolean mutateSplit(Node target) {
        List<Node> allNodes = builder.gatherNodes(target);
        
        Random rand = new Random();
        
        int childCount = 0;
        Node replaceNode = null;
        Class returnClass = null;
        
        for(int j=0;j<200 && childCount < 2;j++) {
            replaceNode = allNodes.get(rand.nextInt(allNodes.size()));
            returnClass = replaceNode.getOutputType();

            childCount = 0;

            for(Node n : allNodes)
                for(int i=0; i<n.getInputs().size(); i++)
                    if(n.getInputs().get(i) == replaceNode)
                        childCount++;
        }
        
        if(childCount < 2)
            return false;
        
        Node replacement = builder.buildNode(returnClass, target.getContextClass(), false, false, 4, 10, 2);

        for(Node n : allNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == replaceNode) {
                    // replace first occurrence.
                    // could be more random, but hey
            
                    n.setInput(i, replacement);
                    return true;
                }
        
        // unreachable
        return false;
    }
    
    public boolean mutateBridge(Node target) {
        
        List<Node> allNodes = builder.gatherNodes(target);
        
        Random rand = new Random();
        
        NodeFunctionFactory nff = builder.makeNFF(1);
        
        Node insertNode;
        boolean found = false;
        
        for(int i=0;i<100 && !found; i++) {
            insertNode = allNodes.get(rand.nextInt(allNodes.size())); // node to be replaced
            Node bridgeNode = null; // node that is replacing
            
            // make sure no circular referencing
            for(int j=0;j<100 && bridgeNode==null;j++) {
                bridgeNode =  allNodes.get(rand.nextInt(allNodes.size()));
                if(builder.gatherNodes(bridgeNode).contains(insertNode))
                    bridgeNode = null;
            }
            if(bridgeNode == null)
                continue;
            
            List<NodeFunction> insertables = nff.getOneToBranchFunctions(insertNode.getOutputType(), bridgeNode.getOutputType());
            
            if(insertables.size() == 0)
                continue;
            
            NodeFunction insertNF = nff.build( insertables.get(rand.nextInt(insertables.size())).getClass() );
            Node inserted = new Node(0, insertNF, target.getContextClass());
             
            boolean hasInserted = false;
            for(int j = 0; j<inserted.getNumberInputs(); j++) {
                 
                if(!hasInserted && inserted.getInputType(j) == insertNode.getOutputType()) {
                    inserted.setInput(j, bridgeNode);
                    hasInserted = true;
                }
                else
                    inserted.setInput(j, builder.buildNode(inserted.getInputType(j), 
                            inserted.getInputContext(j,insertNode.getContextClass()), false, false, 2, 10, 1));
            }
             
            if(!hasInserted)
                continue;
             
            for(Node n : allNodes)
                for(int j=0; j<n.getInputs().size(); j++)
                    if(n.getInputs().get(j) == insertNode)
                        n.setInput(j, inserted);
            return true;
        }
        
        return false;
    }

    public boolean mutateMerge(Node target) {
        
        List<Node> allNodes = builder.gatherNodes(target);
        Random rand = new Random();
        
        boolean found = false;
        
        for(int i=0;i<100 && !found; i++) {
            
            Node replaceNode = allNodes.get(rand.nextInt(allNodes.size())); // node to be replaced
            Node mergeNode = null; // node that is replacing
            
            // make sure no circular referencing
            for(int j=0;j<100 && mergeNode==null;j++) {
                mergeNode =  allNodes.get(rand.nextInt(allNodes.size()));
                if(builder.gatherNodes(mergeNode).contains(replaceNode) ||
                        replaceNode.getContextClass() != mergeNode.getContextClass() ||
                        replaceNode.getOutputType() != mergeNode.getOutputType() )
                    mergeNode = null;
            }
            if(mergeNode == null)
                continue;
            
            for(Node n : allNodes)
                for(int j=0; j<n.getInputs().size(); j++)
                    if(n.getInputs().get(j) == replaceNode)
                        n.setInput(j, mergeNode);
            return true;
        }
        return false;
    }
}
