/*
 * Splash.java
 *
 * Created on May 29, 2006, 5:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

/**
 *
 * @author Calvin Ashmore
 */
public class Splash extends JWindow {
    
    public Splash(ImageIcon icon, /*Frame f,*/ int waitTime) {
        //super(f);
        
        //getContentPane().setLayout(new BorderLayout());
        JLabel label = new JLabel(icon, JLabel.CENTER);
        label.setOpaque(true);
        //JLabel label = new JLabel("ajsdklfajslkdfjaklsfa", JLabel.CENTER);
        add(label);
        pack();
        
        Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = label.getPreferredSize();
        
        setLocation(screenSize.width/2 - (labelSize.width/2),
                screenSize.height/2 - (labelSize.height/2));
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                dispose();
            }
        });
        
        final int pause = waitTime;
        final Runnable closerRunner = new Runnable() {
            public void run() {
                setVisible(false);
                dispose();
            }
        };
        
        Runnable waitRunner = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(pause);
                    SwingUtilities.invokeAndWait(closerRunner);
                } catch(Exception e) {
                    e.printStackTrace();
                    // can catch InvocationTargetException
                    // can catch InterruptedException
                }
            }
        };
        
        setFocusable(true);
        setFocusableWindowState(true);
        setVisible(true);
        toFront();
        Thread splashThread = new Thread(waitRunner, "SplashThread");
        splashThread.start();
    }
    
}