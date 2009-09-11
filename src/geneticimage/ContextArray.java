/*
 * ContextArray.java
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
public class ContextArray extends Context {
    
    /** Creates a new instance of ContextArray */
    public ContextArray() {
        double a[] = new double[1];
        setVariable("a",a);
    }
    
    public ContextArray(double a[]) {
        setVariable("a",a);
    }
    
    public ContextArray(Context context, double a[]) {
        super(context);
        setVariable("a",a);
    }
    
    public double getA(int index) {
        double a[] = (double[])getVariable("a");
        return a[index];
    }
    
    public int getSize() {
        double a[] = (double[])getVariable("a");
        return a.length;
    }
    
}
