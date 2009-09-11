/*
 * ImagePanelStoreContainer.java
 *
 * Created on May 29, 2006, 12:11 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Calvin Ashmore
 */
public class ImagePanelStoreContainer extends ImagePanelContainer {
    
    private static final Icon closeIcon;
    
    static {
        Class thisClass = ImagePanelPaletteContainer.class;
        
        if(thisClass.getResource("icons/close-icon.png") == null) {
            closeIcon = null;
        } else {
            closeIcon = new ImageIcon( thisClass.getResource("icons/close-icon.png") );
        }
    }
    
    private boolean entered;
    
    /** Creates a new instance of ImagePanelStoreContainer */
    public ImagePanelStoreContainer(final ImagePanel panel) {
        super(panel);
        
        panel.addMouseListener( new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                entered = true;
                repaint();
            }
            public void mouseExited(MouseEvent e) {
                entered = false;
                repaint();
            }
            public void mousePressed(MouseEvent e) {
                if(closeIcon == null)
                    return;
                if( e.getX() > getWidth()-closeIcon.getIconWidth()-2 && e.getY() < closeIcon.getIconHeight() )
                    Application.getApplication().getStoredPanel().removeImage(panel.getStructure());
            }
        } );
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        if(entered && closeIcon != null)
            closeIcon.paintIcon(this,g,getWidth()-closeIcon.getIconWidth()-2,2);
    }
    
}
