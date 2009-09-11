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
public class A extends NodeFunction {
    
    private int j=-1;
    
    /** Creates a new instance of X */
    public A() {
    }
    
    public Object[] getParameters() {
        Object[] r = new Object[1];
        r[0] = j;
        return r;
    }
    public void setParameters(Object params[]) {
        j = (Integer)params[0];
    }
    
    public Object evaluate(Object inputs[], Context context) {
        double x[] = (double[])context.getVariable("a");
        
        if(j<0)
            j = new java.util.Random().nextInt(x.length);
        
        return new LDouble(x[j]);
    }
    public Class getReturnClass() {return LDouble.class;}
    public Class[] getInputClasses() {return null;}
    
    public boolean isContextDirect() {return true;}
    
    public Estimate estimate(Estimate inputs[]) {
        return new Estimate_d();
    }
    
    public String[] necessaryContext() {
        String s[] = {"a"};
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
