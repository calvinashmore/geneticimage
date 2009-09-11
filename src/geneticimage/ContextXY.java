/*
 * ContextXY.java
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
public class ContextXY extends Context {
    /** Creates a new instance of ContextXY */
    public ContextXY() {
        setVariable("x", 0.0);
        setVariable("y", 0.0);
    }

    public ContextXY(double x, double y) {
        setVariable("x", x);
        setVariable("y", y);
    }

    public ContextXY(Context context, double x, double y) {
        super(context);
        setVariable("x", x);
        setVariable("y", y);
    }

    public double getX() {
        return (Double) getVariable("x");
    }

    public double getY() {
        return (Double) getVariable("y");
    }
}
