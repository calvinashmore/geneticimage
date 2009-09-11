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
import utils.estimates.Estimate_v3;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class V3 extends NodeFunction {
    
    /** Creates a new instance of X */
    public V3() {
    }
    
    public Object evaluate(Object inputs[], Context context) {
        Double x = (Double)context.getVariable("x");
        Double y = (Double)context.getVariable("y");
        Double z = (Double)context.getVariable("z");
        if(x==null || y==null || z==null)
            return new LVect3d(0,0,0);
        return new LVect3d(x,y,z);
    }
    public Class getReturnClass() {return LVect3d.class;}
    public Class[] getInputClasses() {return null;}
    
    public boolean isContextDirect() {return true;}
    
    public Estimate estimate(Estimate inputs[]) {
        return new Estimate_v3();
    }
    
    public String[] necessaryContext() {
        String s[] = {"x","y","z"};
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
