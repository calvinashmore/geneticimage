/*
 * BuilderThread.java
 *
 * Created on June 3, 2006, 4:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class BuilderThread extends Thread{
    
    volatile private boolean terminated;
    
    public void terminate() {terminated = true;}
    protected boolean isTerminated() {return terminated;}
    //protected void setTerminated(boolean t) {terminated = t;}
    
}
