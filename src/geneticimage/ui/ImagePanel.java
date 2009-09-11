/*
 * ImagePanel.java
 *
 * Created on April 23, 2006, 8:24 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import geneticimage.BuilderThread;
import geneticimage.RenderListener;
import geneticimage.Renderer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class ImagePanel extends JPanel implements RenderListener, MouseListener {
    
    private NodeStructure myStructure;
    public NodeStructure getStructure() {return myStructure;}
    public void setStructure(NodeStructure structure) {
        if(rendering)
            return;
        
        myStructure = structure;
        if(size == NodeStructure.smallImageSize)
            image = structure.getSmallImage();
        else
            image = null;
        repaint();
    }

    private boolean rendering;
    private BufferedImage image;
    private int renderLine;
    private int renderLineMax;
    private Renderer renderer;
    private BuilderThread baseBuilderThread;
    
    private int size;
    
    public boolean isRendering() {return rendering;}
    
    public int getImageSize() {return size;}
    public void setImageSize(int size) {this.size = size;}
    
    public Dimension getPreferredSize() { return new Dimension(size,size); }
    public Dimension getMaximumSize() { return new Dimension(size,size); }
    public Dimension getMinimumSize() { return new Dimension(size,size); }
    
    public void setImage(BufferedImage img) {
        this.image = img;
        //System.out.println("setImage called");
        
        if(size == NodeStructure.smallImageSize)
            myStructure.setSmallImage(img);
        repaint();
    }
    
    public BufferedImage getImage() {return image;}

    public void threadFinished() {
        rendering = false;
        renderer = null;
    }

    public void setLine(int line, int maxlines) {
        renderLine = line;
        renderLineMax = maxlines;
        repaint();
    }
    
    public void beginRender() {
        if(myStructure != null && !rendering) {
            renderer = myStructure.makeRenderer(size);
            renderer.addRenderListener(this);
            //renderer.setPriority(Thread.NORM_PRIORITY-1);
            renderer.setPriority(Thread.MIN_PRIORITY+1);
            renderer.start();
            rendering = true;
        }
    }
    
    public void stopRender() {
        if(baseBuilderThread != null) {
            baseBuilderThread.terminate();
        }
        if(renderer != null) {
            renderer.terminate();
        }
    }
    
    /** Creates a new instance of ImagePanel */
    public ImagePanel() {
        this(100);
    }
    
    public ImagePanel(int size) {
        myStructure = null;
        rendering = false;
        image = null;
        this.size = size;
        
        addMouseListener(this);
    }
    
    public void paint(Graphics g) {
        if(image != null) {
            
            int widthOffset = (size - image.getWidth(this))/2;
            int heightOffset = (size - image.getHeight(this))/2;
            
            g.drawImage(image, widthOffset, heightOffset, this);
            
        } else if(rendering) {
            g.setColor( Color.black );
            g.fillRect(0,0,getWidth(),getHeight());
            
            g.setColor( Color.white );
            g.drawString("rendering...",0,10);
            
            if(renderLineMax > 0) {
                int rectWidth = renderLine*(getWidth()-4)/renderLineMax;
                g.fillRect( 2, getHeight() - 2 - 5, rectWidth, 5 );
            }
        } else {
            g.setColor( Color.black );
            g.fillRect(0,0,getWidth(),getHeight());
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        if(myStructure != null)
            Application.getApplication().doSelect(myStructure);
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void setBuilderThread(BuilderThread bt) {
        if(baseBuilderThread != null) {
            baseBuilderThread.terminate();
        }
        baseBuilderThread = bt;
    }
}
