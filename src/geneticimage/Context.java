/*
 * Context.java
 *
 * Created on September 23, 2005, 11:01 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package geneticimage;

import java.util.*;


/**
 *
 * @author gtg126z
 */
abstract public class Context implements java.io.Serializable {
    private Map<String, Object> variables;

    //private Map<String,Class> variableTypes;

    /** Creates a new instance of Context */
    public Context( /*double x, double y, NodeFunctionFactory nff*/
    ) {
        //this.x = x;
        //this.y = y;
        //this.nff = nff;

        //variableTypes = new Hashtable();
        variables = new Hashtable();
    }

    public Context(Context base) {
        variables = new Hashtable();
        variables.putAll(base.variables);
    }

    public void setVariable(String name, Object value) {
        variables.put(name, value);
    }

    public Object getVariable(String name) {
        return variables.get(name);
    }

    //private double x,y;
    //private NodeFunctionFactory nff;

    // simple for now:
    //public double getX() {return x;}
    //public double getY() {return y;}
    //public NodeFunctionFactory getNFF() {return nff;}
}
