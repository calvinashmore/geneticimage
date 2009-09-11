/*
 * ContextXYZ.java
 *
 * Created on February 26, 2006, 1:31 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage;

/**
 *
 * @author Calvin Ashmore
 */
public class ContextXYZ extends Context {
    
    /** Creates a new instance of ContextXYZ */
    public ContextXYZ() {
        setVariable("x",0.0);
        setVariable("y",0.0);
        setVariable("z",0.0);
    }
    
    public ContextXYZ(double x, double y, double z) {
        setVariable("x",x);
        setVariable("y",y);
        setVariable("z",z);
    }
    
    public ContextXYZ(Context context, double x, double y, double z) {
        super(context);
        setVariable("x",x);
        setVariable("y",y);
        setVariable("z",z);
    }
    
    public double getX() {return (Double)getVariable("x");}
    public double getY() {return (Double)getVariable("y");}
    public double getZ() {return (Double)getVariable("z");}
    
}
