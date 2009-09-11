/*
 * V2.java
 *
 * Created on September 25, 2005, 4:55 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package functions;

import utils.*;
import geneticimage.*;
import utils.estimates.Estimate;
import utils.estimates.Estimate_c;
import utils.linear.Complex;

/**
 *
 * @author Calvin Ashmore
 */
public class Z extends NodeFunction {
    
    /** Creates a new instance of X */
    public Z() {
    }
    
    public Object evaluate(Object inputs[], Context context) {
        Double x = (Double)context.getVariable("x");
        Double y = (Double)context.getVariable("y");
        if(x==null || y==null)
            return new Complex(0,0);
        return new Complex(x,y);
    }
    public Class getReturnClass() {return Complex.class;}
    public Class[] getInputClasses() {return null;}
    
    public boolean isContextDirect() {return true;}
    
    public Estimate estimate(Estimate inputs[]) {
        return new Estimate_c();
    }
    
    public String[] necessaryContext() {
        String s[] = {"x","y"};
        return s;
    }

    public String getInputName(int i) {
        return null;
    }

    public int getNumberParameters() {
        return 0;
    }

    public Object getParameter(int i) {
        return null;
    }

    public String getParameterName(int i) {
        return null;
    }

    public Class getParameterType(int i) {
        return null;
    }

    public void setParameter(int i, Object value) {
    }
}
