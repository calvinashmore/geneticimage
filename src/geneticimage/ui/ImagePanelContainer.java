/*
 * ImagePanelContainer.java
 *
 * Created on April 29, 2006, 6:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Calvin Ashmore
 */
public class ImagePanelContainer extends JPanel {
    
    private ImagePanel panel;
    private static final Color backgroundColor = new Color(128,128,128);
    
    /** Creates a new instance of ImagePanelContainer */
    public ImagePanelContainer(ImagePanel panel) {
        this.panel = panel;
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        
        setBorder(new EmptyBorder(2,2,2,2));
        setBackground(backgroundColor);
    }
    
    public ImagePanel getImagePanel() {return panel;}
    
    // can set buttons and things??
}
