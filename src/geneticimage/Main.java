/*
 * Main.java
 *
 * Created on September 20, 2005, 11:56 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package geneticimage;

//import geneticimage.ui_old.MainContainer;
import geneticimage.ui.ApplicationFrame;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import utils.*;

/**
 *
 * @author gtg126z
 */
public class Main {
    
    private static final ImageIcon appSplash;
    
    static {
        Class thisClass = ApplicationFrame.class;
        
        if(thisClass.getResource("/genetic_logo.jpg") == null) {
            appSplash = null;
        } else {
            appSplash = new ImageIcon( thisClass.getResource("/genetic_logo.jpg") );
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        if(appSplash != null) {
            new geneticimage.ui.Splash(appSplash, 3000);
        }
        try {
            
            Class.forName("geneticimage.ui.ApplicationFrame")
                .getMethod("main", new Class[] {String[].class})
                .invoke(null, new Object[] {args});
        } catch (Exception e) {
            InternalError error = new InternalError("Failed to invoke main method");
            error.initCause(e);
            throw error;
        }
        //ApplicationFrame.main(args);
    }
}
