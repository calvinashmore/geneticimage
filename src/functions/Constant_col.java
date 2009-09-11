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
import utils.estimates.Estimate_col;
import utils.linear.Color;

/**
 *
 * @author gtg126z
 */
public class Constant_col extends geneticimage.NodeFunction {
    
    static final Class[] ic = null;
    
    private double value_x;
    private double value_y;
    private double value_z;
    
    /** Creates a new instance of X */
    
    public Constant_col(double x, double y, double z) {
        value_x = x;
        value_y = y;
        value_z = z;
    }
    
    public Constant_col() {
        
        value_x = (new java.util.Random()).nextDouble();
        value_x = 4*value_x - 2;
        
        value_y = (new java.util.Random()).nextDouble();
        value_y = 4*value_y - 2;
        
        value_z = (new java.util.Random()).nextDouble();
        value_z = 4*value_z - 2;
    }
    
    public Object evaluate(Object inputs[], geneticimage.Context context) {
        
        return new Color(value_x, value_y, value_z);
    }
    public Class[] getInputClasses() {return ic;}
    public Class getReturnClass() {return Color.class;}
    
    public Estimate estimate(Estimate inputs[]) {
        return new Estimate_col(value_x,value_x, value_y,value_y, value_z,value_z);
    }
    
    public String getInputName(int i) {
        return null;
    }

    public int getNumberParameters() {
        return 1;
    }

    public Object getParameter(int i) {
        return new Color(value_x,value_y,value_z);
    }

    public String getParameterName(int i) {
        return "value";
    }

    public Class getParameterType(int i) {
        return Color.class;
    }

    public void setParameter(int i, Object value) {
        this.value_x = ((Color)value).r;
        this.value_y = ((Color)value).g;
        this.value_z = ((Color)value).b;
    }
}
