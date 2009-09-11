/*
 * X.java
 *
 * Created on September 23, 2005, 10:57 AM
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
public class X extends NodeFunction {
    
    /** Creates a new instance of X */
    public X() {
    }
    
    public Object evaluate(Object inputs[], Context context) {
        Double x = (Double)context.getVariable("x");
        if(x==null)
            return new LDouble(0);
        return new LDouble(x);
    }
    public Class getReturnClass() {return LDouble.class;}
    public Class[] getInputClasses() {return null;}
    
    public boolean isContextDirect() {return true;}
    
    public Estimate estimate(Estimate inputs[]) {
        return new Estimate_d();
    }
    
    public String[] necessaryContext() {
        String s[] = {"x"};
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
