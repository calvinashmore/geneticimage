/*
 * BreedThread.java
 *
 * Created on June 3, 2006, 6:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage;

import java.util.List;
import java.util.Random;
import utils.Pair;

/**
 *
 * @author Calvin Ashmore
 */
public class BreedThread extends BuilderThread {
    
    private boolean logging;
    private Node result;
    private Node paramX, paramY;
    public void setLogging(boolean logging) {this.logging = logging;}
    
    private NodeBuilder builder;
    public BreedThread(NodeBuilder builder) {
        this.builder = builder;
    }
    
    public void setParameters(Node x, Node y) {paramX = x; paramY = y;}
    public Node getResult() {return result;}
    
    public void run() {
        result = breed(paramX, paramY);
        if(isTerminated())
            result = null;
        synchronized(this) {
            notify();
        }
    }
    
    public Node breed(Node x, Node y) {
        
        Node r = null;
        
        Random rand = new Random();
        
        if(logging)
            System.out.println("generating child");
        
        // randomly swap parents
        if(rand.nextBoolean()) {
            Node temp = x;
            x = y;
            y = temp;
        }
        
        // do some number of pre-swaps
        int preSwaps = rand.nextInt(13);
        for(int i=0;i<preSwaps;i++) {
            Pair<Node,Node> swaps = swapPair(x.clone(),y.clone());
            if(swaps == null)
                continue;
            
            x = swaps.getRight();
            y = swaps.getLeft();
        }
        
        boolean bred = false;
        while(!bred && !isTerminated()) {
            int option = rand.nextInt(5);
            
            switch(option) {
                case 0:
                    if(logging)
                        System.out.println("breed swap");
                    r = breedSwap(x.clone(), y.clone());
                    if(r != null) bred = true;
                    break;
                case 1:
                    if(logging)
                        System.out.println("breed join");
                    r = breedJoin(x.clone(), y.clone());
                    if(r != null) bred = true;
                    break;
                case 2:
                    if(logging)
                        System.out.println("breed branch new");
                    r = breedBranchNew(x.clone(), y.clone());
                    if(r != null) bred = true;
                    break;
                case 3:
                    if(logging)
                        System.out.println("breed swap new");
                    r = breedNewSwap(x.clone(), y.clone());
                    if(r != null) bred = true;
                    break;
                case 4:
                    if(logging)
                        System.out.println("breed connect roots");
                    r = connectRoots(x.clone(), y.clone());
                    if(r != null) bred = true;
                    break;
            }
            
            if(r != null && !builder.check(r)) {
                //System.err.println("In breed, check fails with option "+option);
                bred = false;
            }
        }
        return r;
    }
    
    
    public Node breedSwap(Node x, Node y) {
    
        Random rand = new Random();
        
        List<Node> xNodes = builder.gatherNodes(x);
        List<Node> yNodes = builder.gatherNodes(y);
        
        Node branch = null;
        Node replacement = null;
        boolean good = false;
        
        for(int i=0;i<100 && !good;i++) {
            
            branch = xNodes.get(rand.nextInt(xNodes.size()));
            Class branchClass = branch.getOutputType();
            
            for(int j=0;j<100 && !good;j++) {
                replacement = yNodes.get(rand.nextInt(yNodes.size()));
                if(replacement.getOutputType() == branchClass)
                    good = true;
            }
        }
        
        if(!good)
            return null;
        
        for(Node n : xNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == branch)
                    n.setInput(i, replacement);
        return x;
    }
    
    public Pair<Node,Node> swapPair(Node x, Node y) {
    
        Random rand = new Random();
        
        List<Node> xNodes = builder.gatherNodes(x);
        List<Node> yNodes = builder.gatherNodes(y);
        
        Node branch = null;
        Node replacement = null;
        boolean good = false;
        
        for(int i=0;i<100 && !good;i++) {
            
            branch = xNodes.get(rand.nextInt(xNodes.size()));
            Class branchClass = branch.getOutputType();
            
            for(int j=0;j<100 && !good;j++) {
                replacement = yNodes.get(rand.nextInt(yNodes.size()));
                if(replacement.getOutputType() == branchClass)
                    good = true;
            }
        }
        
        if(!good)
            return null;
        
        int xrefs=0;
        int yrefs=0;
        for(Node n : xNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == branch)
                    xrefs++;
        
        for(Node n : yNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == replacement)
                    yrefs++;
        
        for(Node n : xNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == branch) {
                    if(xrefs == 1)
                        n.setInput(i, replacement);
                    else if(rand.nextInt(2)==0)
                        n.setInput(i, replacement);
                }
        
        for(Node n : yNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == replacement) {
                    if(xrefs == 1)
                        n.setInput(i, branch);
                    else if(rand.nextInt(2)==0)
                        n.setInput(i, branch);
                }
        
        return new Pair(x,y);
    }
    
    public Node breedJoin(Node x, Node y) {
    
        Random rand = new Random();
        
        List<Node> xNodes = builder.gatherNodes(x);
        List<Node> yNodes = builder.gatherNodes(y);
        
        Node branchX = null;
        Node branchY = null;
        //boolean good = false;
        
        NodeFunctionFactory nff = builder.makeNFF(1);
        
        for(int i=0;i<100;i++) {
            
            branchX = xNodes.get(rand.nextInt(xNodes.size()));
            branchY = yNodes.get(rand.nextInt(yNodes.size()));
            
            for(int j=0;j<100;j++) {
                NodeFunction insertNF = nff.randomByOutput(branchX.getContextClass(), branchX.getOutputType(), false);
                
                if(insertNF == null || insertNF.getInputClasses() == null)
                    continue;
                
                Node inserted = new Node(0, insertNF, branchX.getContextClass());
                
                boolean hasInsertedX = false;
                boolean hasInsertedY = false;
                for(int k = 0; k<inserted.getNumberInputs(); k++) {

                    if(!hasInsertedX && inserted.getInputType(k) == branchX.getOutputType()) {
                        inserted.setInput(k, branchX);
                        hasInsertedX = true;
                    } else if(!hasInsertedY && inserted.getInputType(k) == branchY.getOutputType()) {
                        inserted.setInput(k, branchY);
                        hasInsertedY = true;
                    }
                    else
                        inserted.setInput(k, builder.buildNode(inserted.getInputType(k),
                                inserted.getInputContext(k,branchX.getContextClass()), false, false, 2, 10, 1));
                }

                if(!hasInsertedX && !hasInsertedY)
                    continue;
                
                // ok so far!
                
                for(Node n : xNodes)
                    for(int k=0; k<n.getInputs().size(); k++)
                        if(n.getInputs().get(k) == branchX)
                            n.setInput(k, inserted);
                return x;
            }
        }
        
        return null;
    }
    
    public Node breedBranchNew(Node x, Node y) {
    
        Random rand = new Random();
        
        List<Node> xNodes = builder.gatherNodes(x);
        List<Node> yNodes = builder.gatherNodes(y);
        
        Node branchX = null;
        Node branchY = null;
        Node branchX1 = null;
        //boolean good = false;
        
        NodeFunctionFactory nff = builder.makeNFF(1);
        
        for(int i=0;i<100;i++) {
            
            branchX = xNodes.get(rand.nextInt(xNodes.size()));
            branchY = yNodes.get(rand.nextInt(yNodes.size()));
            
            for(int j=0;j<100;j++) {
                branchX1 = xNodes.get(rand.nextInt(xNodes.size()));
                if(builder.gatherNodes(branchX1).contains(branchX))
                    branchX1 = null;
            }
            if(branchX1 == null)
                continue;
            
            for(int j=0;j<100;j++) {
                NodeFunction insertNF = nff.randomByOutput(branchX.getContextClass(), branchX.getOutputType(), false);
                
                if(insertNF == null || insertNF.getInputClasses() == null)
                    continue;
                
                Node inserted = new Node(0, insertNF, branchX.getContextClass());
                
                boolean hasInsertedX = false;
                boolean hasInsertedY = false;
                for(int k = 0; k<inserted.getNumberInputs(); k++) {

                    if(!hasInsertedX && inserted.getInputType(k) == branchX1.getOutputType()) {
                        inserted.setInput(k, branchX1);
                        hasInsertedX = true;
                    } else if(!hasInsertedY && inserted.getInputType(k) == branchY.getOutputType()) {
                        inserted.setInput(k, branchY);
                        hasInsertedY = true;
                    }
                    else
                        inserted.setInput(k, builder.buildNode(inserted.getInputType(k),
                                inserted.getInputContext(k,branchX.getContextClass()), false, false, 2, 10, 1));
                }

                if(!hasInsertedX && !hasInsertedY)
                    continue;
                
                // ok so far!
                
                for(Node n : xNodes)
                    for(int k=0; k<n.getInputs().size(); k++)
                        if(n.getInputs().get(k) == branchX)
                            n.setInput(k, inserted);
                return x;
            }
        }
        
        return null;
    }
    
    public Node breedNewSwap(Node x, Node y) {
    
        Random rand = new Random();
        
        List<Node> xNodes = builder.gatherNodes(x);
        List<Node> yNodes = builder.gatherNodes(y);
        
        Node branchX = null;
        Node branchY = null;
        //boolean good = false;
        
        NodeFunctionFactory nff = builder.makeNFF(1);
        
        for(int i=0;i<100;i++) {
            
            branchX = xNodes.get(rand.nextInt(xNodes.size()));
            branchY = yNodes.get(rand.nextInt(yNodes.size()));
            
            for(int j=0;j<100;j++) {
                NodeFunction insertNF = nff.randomByOutput(branchX.getContextClass(), branchX.getOutputType(), false);
                
                if(insertNF == null || insertNF.getInputClasses() == null)
                    continue;
                
                Node inserted = new Node(0, insertNF, branchX.getContextClass());
                
                boolean hasInsertedY = false;
                for(int k = 0; k<inserted.getNumberInputs(); k++) {

                    if(!hasInsertedY && inserted.getInputType(k) == branchY.getOutputType()) {
                        inserted.setInput(k, branchY);
                        hasInsertedY = true;
                    }
                    else
                        inserted.setInput(k, builder.buildNode(inserted.getInputType(k),
                                inserted.getInputContext(k,branchX.getContextClass()), false, false, 2, 10, 1));
                }

                if(!hasInsertedY)
                    continue;
                
                // ok so far!
                
                for(Node n : xNodes)
                    for(int k=0; k<n.getInputs().size(); k++)
                        if(n.getInputs().get(k) == branchX)
                            n.setInput(k, inserted);
                return x;
            }
        }
        
        return null;
    }
    
    public Node connectRoots(Node x, Node y) {

        NodeFunctionFactory nff = builder.makeNFF(1);
        for(int j=0;j<300;j++) {
            NodeFunction insertNF = nff.randomByOutput(x.getContextClass(), x.getOutputType(), false);
            if(insertNF == null)
                continue;
            
            if(insertNF.getInputClasses().length != 2 ||
               insertNF.getInputClasses()[0] != x.getOutputType() ||
               insertNF.getInputClasses()[1] != y.getOutputType())
                continue;
            
            Node newRoot = new Node(0, insertNF, x.getContextClass());
            newRoot.setInput(0,x);
            newRoot.setInput(1,y);
            return newRoot;
        }
        return null;
    }
    
}
