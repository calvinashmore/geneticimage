/*
 * AllFunctions.java
 *
 * Created on February 26, 2006, 12:35 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package geneticimage;

import functions.*;

import gen.functions.AllFn;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Calvin Ashmore
 */
public class AllFunctions implements FunctionGroup {
    public List<NodeFunction> getFunctions() {
        List<NodeFunction> allFunctions = new ArrayList();

        allFunctions.add(new A());
        allFunctions.add(new X());
        allFunctions.add(new Y());
        allFunctions.add(new Z());
        allFunctions.add(new Z1());
        allFunctions.add(new V2());
        allFunctions.add(new V3());
        
        allFunctions.add(new Constant_col());
        allFunctions.add(new Constant_d());
        allFunctions.add(new Constant_v2());
        allFunctions.add(new Constant_v3());

        allFunctions.addAll(new AllFn().getFunctions());

        return allFunctions;
    }

    public NodeFunction build(Class<?extends NodeFunction> nfClass,
        NodeFunctionFactory nff) {
        // this is not supported for this class...
        return null;
    }
}
