/*
 * VisualNodeView.java
 *
 * Created on April 13, 2006, 11:54 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui.equation;

import geneticimage.ui.Application;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import geneticimage.*;

/**
 *
 * @author Calvin Ashmore
 */
public class VisualNodeView extends JLayeredPane { //JPanel {
    
    private List<VisualNode> frames;
    private Map<Node, VisualNode> nodeMap;
    private static final Color bgColor = new Color(220,220,220);
    
    private Node root;
    private Node original;
    //private int maxDepth;
    //private int maxHeight;
    
    private int heightPadding = 30;
    private int widthPadding = 30;
    
    private VisualNodeViewPopupMenu popup;
    
    public VisualNodeView() {
        
        popup = new VisualNodeViewPopupMenu(this);
        
        setBackground(bgColor);
        setOpaque(true);
        
        MouseAdapter adapter = new MouseAdapter();
        addMouseListener(adapter);
        addMouseMotionListener(adapter);
    }
    
    public Dimension getPreferredSize() {return new Dimension(800,400);}
    public Dimension getMaximumSize() {return new Dimension(Short.MAX_VALUE,Short.MAX_VALUE);}
    //public Dimension getMinimumSize() {return new Dimension(400,400);}
    
    public void selectEquation(Node newRoot) {
        
        cancelCircleClick();
        
        if(frames != null)
        for(VisualNode frame : frames) {
            remove(frame);
        }
        
        this.root = newRoot.clone();
        original = newRoot;
        
        NodeBuilder builder = Application.getApplication().getBuilder();

        //frames = new VisualNode[5];
        frames = new ArrayList();
        nodeMap = new Hashtable();
        int i=0;
        for(Node node : builder.gatherNodes(root)) {
            
            VisualNode vn = new VisualNode(node);
            //vn.setBounds(50+i*20, 50+i*20, 200, 200);
            vn.setLocation(50+i*20, 50+i*20);
            frames.add(vn);
            add(vn);
            nodeMap.put(node,vn);
            vn.setVisible(true);
            
            i++;
        }
        
        nodeMap.get(root).setIsRoot(true);
        
        buildBounds(root,0,0);
        repaint();
    }
    
    public void paint(java.awt.Graphics g) {
        super.paint(g);
        
        if(root == null)
            return;
        
        for(VisualNode vn : frames) {
            //Node node = nodeMap.get(vn);
            Node node = vn.getBase();
            for(int i=0;i<node.getNumberInputs();i++)
                if(node.getInput(i) != null)
                    drawConnection(g,vn.getInputPoint(i), nodeMap.get(node.getInput(i)).getOutputPoint());
        }
        
        if(circleSelected) {
            int xpos = mouseX + getLocationOnScreen().x;
            int ypos = mouseY + getLocationOnScreen().y;
            drawConnection(g,new Point(xpos,ypos), selectedPoint);
            repaint();
        }
    }
    
    public void drawConnection(java.awt.Graphics g, Point point1, Point point2) {
        g.setColor(new Color(0,0,0));
        
        int screenX = getLocationOnScreen().x;
        int screenY = getLocationOnScreen().y;
        
        float dx = point1.x - point2.x;
        float dy = point1.y - point2.y;
        float mag = (float)Math.sqrt(dx*dx+dy*dy);
        if(mag != 0) {
            dx /= mag;
            dy /= mag;
        }
        
        int ix = (int)(1.2f*dx*CirclePanel.circleWidth/2);
        int iy = (int)(1.2f*dy*CirclePanel.circleWidth/2);
        
        Point point1a = new Point(
                point1.x - ix,
                point1.y - iy );
        
        Point point2a = new Point(
                point2.x + ix,
                point2.y + iy );
        
        g.drawLine(
                point1a.x - screenX, point1a.y - screenY,
                point2a.x - screenX, point2a.y - screenY
                );
    }
    
    private void buildBounds(Node boundsRoot, int x0, int y0) {
        List<Node> currentNodes = new ArrayList();
        List<Node> visibleNodes = Application.getApplication().getBuilder().gatherNodes(boundsRoot);
        
        currentNodes.add(boundsRoot);
        
        int depth = 0;
        while(!currentNodes.isEmpty()) {
            List<Node> nextNodes = new ArrayList();
            
            for(Node node : currentNodes) {
                nodeMap.get(node).depth = depth;
                for(int i=0;i<node.getNumberInputs();i++)
                    nextNodes.add( node.getInput(i) );
            }
            
            depth++;
            currentNodes = nextNodes;
        }
        int maxDepth = depth;
        int maxHeight = 0;
        
        int heights[] = new int[maxDepth];
        int widths[] = new int[maxDepth];
        int netWidths[] = new int[maxDepth];
        
        //for(VisualNode vn : frames) {
        for(Node n : visibleNodes) {
            VisualNode vn = nodeMap.get(n);
            heights[vn.depth] += vn.getSize().height + heightPadding;
            widths[vn.depth] = Math.max(widths[vn.depth], vn.getSize().width);
        }
        
        for(int height : heights)
            if(maxHeight < height)
                maxHeight = height;
        
        for(int i=0;i<maxDepth;i++)
            for(int j=0;j<i;j++)
                netWidths[i] += widths[j];
        
        int currentHeights[] = new int[maxDepth];
        
        //for(VisualNode vn : frames) {
        for(Node n : visibleNodes) {
            VisualNode vn = nodeMap.get(n);
            vn.setLocation(
                    netWidths[vn.depth] + vn.depth*widthPadding + x0,
                    (maxHeight - heights[vn.depth])/2 + currentHeights[vn.depth] + y0
                    );
            currentHeights[vn.depth] += vn.getSize().height + heightPadding;
        }
    }
    
    private int popupX;
    private int popupY;
    public void createNewNode(NodeFunction nf) {
        nf = Application.getApplication().getBuilder().makeNFF(1).shallowBuild( nf.getClass() );
        Node node = new Node(0,nf,ContextXY.class);
        VisualNode vn = new VisualNode(node);
        
        frames.add(vn);
        add(vn);
        nodeMap.put(node,vn);
        vn.setVisible(true);
        vn.setLocation(popupX, popupY);
    }
    
    public void removeNode(VisualNode vn) {
        
        if(vn.getBase() == root) {
            JOptionPane.showMessageDialog(this,"Cannot remove root node!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        remove(vn);
        frames.remove(vn);
        nodeMap.remove(vn.getBase());
        
        for(VisualNode vn1 : frames) {
            Node node = vn1.getBase();
            for(int i=0;i<node.getNumberInputs();i++) {
                if(node.getInput(i) == vn.getBase())
                    node.setInput(i,null);
            }
        }
        repaint();
    }
    
    
    
    public void setRoot(VisualNode vn) {
        if(vn.getBase().getOutputType() == utils.linear.Color.class) {
            nodeMap.get(root).setIsRoot(false);
            root = vn.getBase();
            vn.setIsRoot(true);
        }
    }

    public void randomParams(VisualNode vn) {
        Application.getApplication().getBuilder().randomizeParameters( vn.getBase().getFunction() );
        vn.refresh();
    }

    private Node copiedNode = null;
    public void copyNode(VisualNode vn) {
        copiedNode = vn.getBase().clone();
    }
    
    public void pasteNode() {
        if(copiedNode == null)
            return;
        
        // add everything like in selectNode
        NodeBuilder builder = Application.getApplication().getBuilder();
        for(Node node : builder.gatherNodes((Node)copiedNode)) {
            
            VisualNode vn = new VisualNode(node);
            frames.add(vn);
            add(vn);
            nodeMap.put(node,vn);
            vn.setVisible(true);
        }
        
        buildBounds(copiedNode, mouseX, mouseY);
    }

    public void setupNode(VisualNode vn) {
        try{
            vn.getBase().setup();
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Setup failed!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        vn.refresh();
    }
    
    private Point selectedPoint;
    private boolean circleSelected;
    private boolean lastIsOutput;
    private VisualNode lastSelected;
    private int lastIndex;
    public void doCircleClick(VisualNode vn, boolean isOutput, int index, Point selectedPoint) {
        
        if(circleSelected) {
            
            if(!isConnectionOK(vn, isOutput, index))
                return;
            
            cancelCircleClick();
            
            VisualNode outputNode = isOutput ? vn : lastSelected;
            VisualNode inputNode = isOutput ? lastSelected : vn;
            if(isOutput) index = lastIndex;
            
            // do connection
            inputNode.getBase().setInput(index, outputNode.getBase());
            //System.out.println("did connect???");
            
        } else {
            circleSelected = true;
            this.selectedPoint = selectedPoint;
            lastIsOutput = isOutput;
            lastSelected = vn;
            lastIndex = index;
            repaint();
            //System.out.println("selected!");
        }
    }
    
    public boolean isConnectionOK(VisualNode vn, boolean isOutput, int index) {
        if(!circleSelected)
            return false;
        
        if(isOutput == lastIsOutput)
            return false;

        VisualNode outputNode = isOutput ? vn : lastSelected;
        VisualNode inputNode = isOutput ? lastSelected : vn;
        if(isOutput) index = lastIndex;

        if(outputNode.getBase().getOutputType() != inputNode.getBase().getInputType(index))
            return false;
        
        // recursivity test
        if(Application.getApplication().getBuilder().gatherNodes(outputNode.getBase()).contains(inputNode.getBase()))
            return false;
        
        return true;
    }
    
    public void cancelCircleClick() {
        if(circleSelected) {
            circleSelected = false;
            //System.out.println("unselected!");
        }
    }

    void circleMouse(int x, int y) {
        mouseX = x - getLocationOnScreen().x;
        mouseY = y - getLocationOnScreen().y;
    }

    void updateView() {
        
        for(Node n : nodeMap.keySet())
            for(int i=0;i<n.getNumberInputs();i++)
                if(n.getInput(i) == root) {
                        int r = JOptionPane.showConfirmDialog(this,
                                "Root node is the child of another node",
                                "Confirm",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if(r != JOptionPane.OK_OPTION)
                            return;
                    }
        
        List<Node> subNodes = Application.getApplication().getBuilder().gatherNodes(root);
        for(Node n : subNodes) {
            
            VisualNode vn = nodeMap.get(n);
            
            /*if(vn == null) {
                int foo = 1;
            }*/
            
            if(!vn.checkParameters()) {
                JOptionPane.showMessageDialog(this,
                        "Invalid parameter in "+n.getName(),
                        "Warning",JOptionPane.WARNING_MESSAGE);
                // translate over to it?
                return;
            }
            
            vn.updateParameters();
            
            for(int i=0;i<n.getNumberInputs();i++)
                if(n.getInput(i) == null) {
                    JOptionPane.showMessageDialog(this,
                            "Null input in "+n.getName(),
                            "Warning",JOptionPane.WARNING_MESSAGE);
                    // translate over to it?
                    return;
                }
        }
        
        // update our view
        selectEquation(root);
        // after selectEquation, original = root, and root changes to a copy
        Application.getApplication().updateSelect(original);
    }

    void resetView() {
        selectEquation(original);
    }
    
    private int mouseX;
    private int mouseY;
    class MouseAdapter
            extends MouseInputAdapter {
        
        int xDifference, yDifference;
        boolean dragging;
        
        public MouseAdapter() {
        }
        
        public void mouseMoved(MouseEvent e) {
            
            mouseX = e.getX();
            mouseY = e.getY();
        }
        
        public void mouseDragged(MouseEvent e) {
            if(frames == null)
                return;
                
            if (dragging) {
                for(VisualNode vn : frames)
                    vn.setLocation(e.getX()-xDifference + vn.getX(),
                        e.getY()-yDifference + vn.getY());
            }
            
            if(circleSelected) {
                selectedPoint.x += e.getX()-xDifference;
                selectedPoint.y += e.getY()-yDifference;
            }
            
            xDifference = e.getX();
            yDifference = e.getY();
            
            mouseX = e.getX();
            mouseY = e.getY();
            //repaint();
        }
        
        public void mousePressed(MouseEvent e) {
            if(e.isPopupTrigger()) {
                doContextMenu(e);
                return;
            } else {
            
                if(frames == null)
                    return;
                xDifference = e.getX();
                yDifference = e.getY();
                dragging = true;
            }
        }
        
        public void mouseClicked(MouseEvent e) {
            cancelCircleClick();
        }
        
        public void mouseReleased(MouseEvent e) {
            if(e.isPopupTrigger()) {
                doContextMenu(e);
                return;
            } else {
                if(frames == null)
                    return;
                dragging = false;
            }
        }
        
        public void doContextMenu(MouseEvent e) {
            popupX = e.getX();
            popupY = e.getY();
            if(frames != null)
                popup.show(VisualNodeView.this,e.getX(),e.getY());
        }

        /*public void mouseExited(MouseEvent e) {
            System.out.println("exit occured");
        }*/
    }
}