/*
 * NodeStructure.java
 *
 * Created on April 23, 2006, 11:27 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import geneticimage.Node;
import geneticimage.Renderer;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Calvin Ashmore
 */
public class NodeStructure implements java.io.Serializable {
    
    public static final int smallImageSize = 200;
    //public static final int ;
    
    private Node node;
    
    private double xCenter;
    private double yCenter;
    private double magnification;
    private double aspectRatio;
    // width / height
    // 2  -> 200 x 100 px
    // .5 -> 100 x 200 px
    
    private transient BufferedImage smallImage;
    
    /** Creates a new instance of NodeStructure */
    public NodeStructure(Node node) {
        this.node = node;
        xCenter = 0;
        yCenter = 0;
        magnification = 1;
        aspectRatio = 1;
    }
    
    public NodeStructure(NodeStructure base, Node newNode) {
        this.node = newNode;
        xCenter = base.xCenter;
        yCenter = base.yCenter;
        magnification = base.magnification;
        aspectRatio = base.aspectRatio;
    }
    
    public double getXCenter() {return xCenter;}
    public double getYCenter() {return yCenter;}
    public double getMagnification() {return magnification;}
    public double getAspectRatio() {return aspectRatio;}
    
    public Node getNode() {return node;}
    
    public void setCenter(double xCenter, double yCenter) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }
    
    public void setMagnification(double magnification) {
        if(magnification <= 0)
            throw new IllegalArgumentException("Attempting to set magnification to invalid value "+magnification);
        
        this.magnification = magnification;
    }
    
    public void setAspectRatio(double aspectRatio) {
        if(aspectRatio <= 0)
            throw new IllegalArgumentException("Attempting to set aspectRatio to invalid value "+aspectRatio);
        
        this.aspectRatio = aspectRatio;
    }
    
    public BufferedImage getSmallImage() {return smallImage;}
    public void setSmallImage(BufferedImage img) {this.smallImage = img;}
    
    public Renderer makeRenderer(int resolution) {
        Renderer renderer = new Renderer();
        renderer.setEvaluator(node);
        
        if(aspectRatio >= 1) {
            renderer.setWindow(
                    xCenter - magnification, xCenter + magnification,
                    yCenter - magnification/aspectRatio, yCenter + magnification/aspectRatio );

            renderer.setResolution( resolution, (int)(resolution/aspectRatio) );
        } else {
            renderer.setWindow(
                    xCenter - magnification*aspectRatio, xCenter + magnification*aspectRatio,
                    yCenter - magnification, yCenter + magnification );
            
            renderer.setResolution( (int)(resolution*aspectRatio), resolution );
        }
        
        return renderer;
    }
    
    public NodeStructure clone() {
        NodeStructure ns = new NodeStructure(node.clone());
        
        ns.xCenter = xCenter;
        ns.yCenter = yCenter;
        ns.magnification = magnification;
        ns.aspectRatio = aspectRatio;
        ns.smallImage = smallImage;

        return ns;
    }
}
