/*
 * RenderListener.java
 *
 * Created on April 23, 2006, 12:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage;

/**
 *
 * @author Calvin Ashmore
 */
public interface RenderListener {
    
    public void setLine(int line, int maxlines);
    public void setImage(java.awt.image.BufferedImage img);
    public void threadFinished();
}
