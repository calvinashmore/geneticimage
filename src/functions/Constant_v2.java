/*
 * Sin.java
 *
 * Created on September 23, 2005, 12:03 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package functions;

import utils.*;
import geneticimage.*;
import utils.estimates.Estimate;
import utils.estimates.Estimate_v2;
import utils.linear.LVect2d;

/**
 *
 * @author gtg126z
 */
public class Constant_v2 extends geneticimage.NodeFunction {
    
    static final Class[] ic = null;
    
    private double value_x;
    private double value_y;
    
    /** Creates a new instance of X */
    
    public Constant_v2(double x, double y) {
        value_x = x;
        value_y = y;
    }
    public Constant_v2(LVect2d v) {
        value_x = v.x;
        value_y = v.y;
    }
    
    public Constant_v2() {
        
        value_x = (new java.util.Random()).nextDouble();
        value_x = 4*value_x - 2;
        
        value_y = (new java.util.Random()).nextDouble();
        value_y = 4*value_y - 2;
    }
    
    public Object evaluate(Object inputs[], geneticimage.Context context) {
        
        return new LVect2d(value_x, value_y);
    }
    public Class[] getInputClasses() {return ic;}
    public Class getReturnClass() {return LVect2d.class;}
    
    public Estimate estimate(Estimate inputs[]) {
        return new Estimate_v2(value_x,value_x, value_y,value_y);
    }
    
    public String getInputName(int i) {
        return null;
    }

    public int getNumberParameters() {
        return 1;
    }

    public Object getParameter(int i) {
        return new LVect2d(value_x,value_y);
    }

    public String getParameterName(int i) {
        return "value";
    }

    public Class getParameterType(int i) {
        return LVect2d.class;
    }

    public void setParameter(int i, Object value) {
        this.value_x = ((LVect2d)value).x;
        this.value_y = ((LVect2d)value).y;
    }
}
