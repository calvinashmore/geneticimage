/*
 * ApplicationFrame.java
 *
 * Created on April 29, 2006, 2:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Calvin Ashmore
 */
public class ApplicationFrame extends JFrame {
    
    private static final ImageIcon appIcon;
    
    static {
        Class thisClass = ApplicationFrame.class;
        
        if(thisClass.getResource("/icon.png") == null) {
            appIcon = null;
        } else {
            appIcon = new ImageIcon( thisClass.getResource("/icon.png") );
        }
    }
    
    private Application app;
    
    /** Creates a new instance of ApplicationFrame */
    public ApplicationFrame() {
        super("Genetic Image");
        
        if(appIcon != null)
            setIconImage(appIcon.getImage());
        
        app = new Application();
        add(app);
                 
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                
                if( Application.getApplication().getNumberRenderWindows() > 0)
                    if( JOptionPane.showConfirmDialog(ApplicationFrame.this,
                        "There are still render windows open. If you exit now, they will be closed. Still exit?","Warning",
                        JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == JOptionPane.NO_OPTION )
                        return;
                
                //super.windowClosing(e);
                System.exit(0);
            }
        } );
        pack();
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationFrame appFrame = new ApplicationFrame();
                appFrame.setVisible(true);
                //appFrame.toBack();
            }
        });
    }
}
