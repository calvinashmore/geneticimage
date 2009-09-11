/*
 * Renderer.java
 *
 * Created on October 2, 2005, 4:09 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package geneticimage;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 *
 * @author Calvin Ashmore
 */
public class Renderer extends BuilderThread {
    
    private double xminimum;
    private double xmaximum;
    private double yminimum;
    private double ymaximum;
    
    private int xresolution;
    private int yresolution;
    
    private List<RenderListener> listeners;
    
    private Node evaluator;
    
    public Renderer() {
        xminimum = -1;
        xmaximum =  1;
        yminimum = -1;
        ymaximum =  1;
        
        xresolution = 500;
        yresolution = 500;
        
        listeners = new ArrayList();
    }
    
    public void addRenderListener(RenderListener listener) {
        listeners.add(listener);
    }
    
    public int getXResolution() {return xresolution;}
    public int getYResolution() {return yresolution;}
    
    public void setWindow(double xminimum, double xmaximum, double yminimum, double ymaximum) {
        this.xminimum = xminimum;
        this.xmaximum = xmaximum;
        this.yminimum = yminimum;
        this.ymaximum = ymaximum;
    }
    
    public void setResolution(int xresolution, int yresolution) {
        this.xresolution = xresolution;
        this.yresolution = yresolution;
    }
    
    public void setEvaluator(Node evaluator) {
        this.evaluator = evaluator;
    }
    
    /*
    private ColorGrid buildImage() {
        //terminated = false;
        //setTerminated(false);
        ColorGrid grid = new ColorGrid(xresolution,yresolution);
        
        for(int y=0; y<yresolution && !isTerminated(); y++) {
            for(int x=0; x<xresolution && !isTerminated(); x++) {

                float cx = (float)x/xresolution;
                float cy = (float)y/yresolution;

                cx = (float)(xminimum + (xmaximum - xminimum) * cx);
                cy = (float)(yminimum + (ymaximum - yminimum) * cy);

                evaluator.setContext(new ContextXY(cx,cy));
                utils.linear.Color color = (utils.linear.Color)(evaluator.evaluate());

                grid.setValue(x,y, color);
            }
            for(RenderListener listener : listeners)
                listener.setLine(y,yresolution);
        }

        return grid;
    }*/
    
    
    private BufferedImage buildImage() {
        BufferedImage img = new BufferedImage(
                xresolution,
                yresolution, 
                BufferedImage.TYPE_INT_ARGB);
        
        for(int y=0; y<yresolution && !isTerminated(); y++) {
            for(int x=0; x<xresolution && !isTerminated(); x++) {

                float cx = (float)x/xresolution;
                float cy = (float)y/yresolution;

                cx = (float)(xminimum + (xmaximum - xminimum) * cx);
                cy = (float)(yminimum + (ymaximum - yminimum) * cy);

                evaluator.setContext(new ContextXY(cx,cy));
                utils.linear.Color color = (utils.linear.Color)(evaluator.evaluate());

                img.setRGB(x, y, color.toARGB());
            }
            for(RenderListener listener : listeners)
                listener.setLine(y,yresolution);
        }
        
        return img;
    }
    
    public void run() {
        
        BufferedImage image = null;
        try {
            image = buildImage();
        } catch(RuntimeException e) {}
        
        for(RenderListener listener : listeners) {
            if(image != null)
                listener.setImage(image);
            listener.threadFinished();
        }
        
        /*
        ColorGrid grid = null;
        try {
            grid = buildImage();
        } catch(RuntimeException e) {}
        
        //grid.balance();
        
        for(RenderListener listener : listeners) {
            if(grid != null)
                listener.setImage(grid.makeImage());
            listener.threadFinished();
        }*/
    }
}
