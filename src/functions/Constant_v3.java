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
import utils.estimates.Estimate_v3;
import utils.linear.LVect3d;

/**
 *
 * @author gtg126z
 */
public class Constant_v3 extends geneticimage.NodeFunction {
    
    static final Class[] ic = null;
    
    private double value_x;
    private double value_y;
    private double value_z;
    
    /** Creates a new instance of X */
    
    public Constant_v3(double x, double y, double z) {
        value_x = x;
        value_y = y;
        value_z = z;
    }
    public Constant_v3(LVect3d v) {
        value_x = v.x;
        value_y = v.y;
        value_z = v.z;
    }
    
    public Constant_v3() {
        
        value_x = (new java.util.Random()).nextDouble();
        value_x = 4*value_x - 2;
        
        value_y = (new java.util.Random()).nextDouble();
        value_y = 4*value_y - 2;
        
        value_z = (new java.util.Random()).nextDouble();
        value_z = 4*value_z - 2;
    }
    
    public Object evaluate(Object inputs[], geneticimage.Context context) {
        
        return new LVect3d(value_x, value_y, value_z);
    }
    public Class[] getInputClasses() {return ic;}
    public Class getReturnClass() {return LVect3d.class;}
    
    public Estimate estimate(Estimate inputs[]) {
        return new Estimate_v3(value_x,value_x, value_y,value_y, value_z,value_z);
    }
    
    public String getInputName(int i) {
        return null;
    }

    public int getNumberParameters() {
        return 1;
    }

    public Object getParameter(int i) {
        return new LVect3d(value_x,value_y,value_z);
    }

    public String getParameterName(int i) {
        return "value";
    }

    public Class getParameterType(int i) {
        return LVect3d.class;
    }

    public void setParameter(int i, Object value) {
        this.value_x = ((LVect3d)value).x;
        this.value_y = ((LVect3d)value).y;
        this.value_z = ((LVect3d)value).z;
    }
}
