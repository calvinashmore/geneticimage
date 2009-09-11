package geneticimage.ui.equation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

    
class CirclePanel extends JPanel {
    
    public static final int circleWidth = 10;
    protected static Color circleColor = new Color(80,80,80);
    protected static Color circleColor1 = new Color(20,20,80);
    protected static Color circleColor2 = new Color(0,0,240);
    protected static Color circleFill = new Color(200,200,200);
    protected static Color circleFill1 = new Color(150,150,150);
    protected static Color circleFill2 = new Color(120,120,250);

    private final VisualNode visualNode;
    private final boolean isOutput;
    private final int index;
    
    private boolean entered;

    boolean getIsOutput() {return isOutput;}
    int getIndex() {return index;}
    
    public CirclePanel(VisualNode visualNode, boolean isOutput, int index) {
        this.visualNode = visualNode;
        this.isOutput = isOutput;
        this.index = index;
        
        setOpaque(false);
        
        MouseInputAdapter adapter = new MouseInputAdapter() {
            public void mousePressed(MouseEvent e) {
                CirclePanel.this.visualNode.doCircleClick(CirclePanel.this);
            }
            
            public void mouseMoved(MouseEvent e) {
                //CirclePanel.this.visualNode.circleMouse(CirclePanel.this);
                ((VisualNodeView)CirclePanel.this.visualNode.getParent()).circleMouse(
                        getLocationOnScreen().x + e.getX(),
                        getLocationOnScreen().y + e.getY()
                        );
            }
            
            public void mouseEntered(MouseEvent e) {
                entered = true;
                repaint();
            }
            
            public void mouseExited(MouseEvent e) {
                entered = false;
                repaint();
            }
        };
        
        addMouseListener(adapter);
        addMouseMotionListener(adapter);
    }
    
    public Dimension getPreferredSize() { return new Dimension(circleWidth + 1, circleWidth + 1);  }
    public Dimension getMinimumSize() { return new Dimension(circleWidth + 1, circleWidth + 1);  }
    public Dimension getMaximumSize() { return new Dimension(circleWidth + 1, circleWidth + 1);  }
    public void paint(Graphics g) {
        if(!entered)
            g.setColor(circleColor);
        else {
            if( ((VisualNodeView)visualNode.getParent()).isConnectionOK(visualNode, isOutput, index) )
                g.setColor(circleColor2);
            else
                g.setColor(circleColor1);
        }
        g.drawOval(0,0,circleWidth,circleWidth);
        
        if(!entered)
            g.setColor(circleFill);
        else {
            if( ((VisualNodeView)visualNode.getParent()).isConnectionOK(visualNode, isOutput, index) )
                g.setColor(circleFill2);
            else
                g.setColor(circleFill1);
        }
        g.fillOval(2,2,circleWidth - 3,circleWidth - 3);
    }

}