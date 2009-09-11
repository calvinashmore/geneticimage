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
import utils.estimates.Estimate_d;
import utils.linear.LDouble;

/**
 *
 * @author gtg126z
 */
public class Constant_d extends geneticimage.NodeFunction {
    
    static final Class[] ic = null;
    
    private double value;
    
    /** Creates a new instance of X */
    
    public Constant_d(double v) {
        value = v;
    }
    public Constant_d(LDouble v) {
        value = v.val;
    }
    
    public Constant_d() {
        
        value = (new java.util.Random()).nextDouble();
        value = 4*value - 2;
    }
    
    public Object evaluate(Object inputs[], geneticimage.Context context) {
        
        //return new LDouble(Math.cos(x.val * Math.PI));
        return new LDouble(value);
    }
    public Class[] getInputClasses() {return ic;}
    public Class getReturnClass() {return LDouble.class;}
    
    public Estimate estimate(Estimate inputs[]) {
        return new Estimate_d(value,value);
    }
    
    public String getInputName(int i) {
        return null;
    }

    public int getNumberParameters() {
        return 1;
    }

    public Object getParameter(int i) {
        return value;
    }

    public String getParameterName(int i) {
        return "value";
    }

    public Class getParameterType(int i) {
        return double.class;
    }

    public void setParameter(int i, Object value) {
        this.value = (Double)value;
    }
}
