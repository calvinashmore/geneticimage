/*
 * Test.java
 *
 * Created on February 18, 2006, 12:23 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package test;

import geneticimage.*;

/**
 *
 * @author Calvin Ashmore
 */
public class Test {
    
    public static void main(String args[]) {
        
        NodeBuilder nb = new NodeBuilder();
        nb.getImageManager().addFolder("D:\\Projects\\Genetic\\GeneticImage\\images");
        nb.setLogging(true);
        
        /*
        for(int i=0;i<30;i++) {
            Node n = nb.buildNode(utils.linear.Color.class, ContextXY.class, true, false, 4, 30, 3);
            String s = nb.nodeToString(n);
            
            if(s.contains("CFractal"))
                //System.out.println("!!!");
                System.out.println(s);
        }*/
        System.out.println("done...");
    }
    
}
