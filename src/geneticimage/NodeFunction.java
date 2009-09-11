/*
 * NodeFunction.java
 *
 * Created on September 20, 2005, 1:00 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package geneticimage;
import java.util.*;
import java.io.*;
import utils.estimates.Estimate;

/**
 *
 * @author gtg126z
 */
abstract public class NodeFunction implements Serializable {
    
    private boolean parametersChanged = true;
    public void setParametersChanged(boolean changed) {parametersChanged=changed;}
    public boolean parametersChanged() {return parametersChanged;}
    
    private Map<String,Object> meta;
    public Object getMeta(String key) {
        if(meta==null)
            return null;
        return meta.get(key);
    }
    protected void addMeta(String key, Object value) {
        if(meta==null)
            meta = new Hashtable();
        meta.put(key,value);
    }
    
    /** Creates a new instance of NodeFunction */
    public NodeFunction() {
        //meta = new Hashtable();
    }
    
    //private transient boolean isSetup;
    //public boolean isSetup() {return isSetup;}
    //public void setIsSetup(boolean v) {isSetup = v;}
    public void setup() {}
    
    public Object evaluate(List inputs, Context context) {
        if(inputs.size() == 0)
            return evaluate((Object[])null, context);
        else {
            return evaluate(inputs.toArray(), context);
        }
    }
    
    abstract public Object evaluate(Object inputs[], Context context);
    abstract public Class[] getInputClasses();
    abstract public String getInputName(int i);
    abstract public Class getReturnClass();
    
    public boolean isContextUsable(Context c) {
        String requiredVars[] = necessaryContext();
        if(requiredVars == null)
            return true;
        
        for(String var : requiredVars)
            if(c.getVariable(var) == null)
                return false;
        return true;
    }
    
    public String[] necessaryContext() {return null;}
    public boolean isContextDirect() {return false;}
    //public Estimate estimate(Estimate inputs[]) {return new Estimate();}
    abstract public Estimate estimate(Estimate inputs[]);
    
    //public Object[] getParameters() {return null;}
    //public void setParameters(Object params[]) {}
    
    // these should be overridden
    public int getNumberParameters() {return 0;}
    public Object getParameter(int i) {return null;}
    public String getParameterName(int i) {return null;}
    public Class getParameterType(int i) {return null;}
    public void setParameter(int i, Object value) {}

    String getDescription() {
        return "No description.";
    }
}
