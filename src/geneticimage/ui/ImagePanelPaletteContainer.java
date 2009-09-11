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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class ImagePanelPaletteContainer extends ImagePanelContainer implements ActionListener {
    
    private static final Icon newIcon; // = new ImageIcon("icons/new-icon1.png");
    private static final Icon storeIcon; // = new ImageIcon("icons/store-icon1.png");
    private static final Icon mutateIcon; // = new ImageIcon("icons/mutate-icon1.png");
    private static final Icon breedIcon; // = new ImageIcon("icons/breed-icon1.png");
    private static final Icon stopIcon; // = new ImageIcon("icons/stop-icon1.png");
    
    static {
        Class thisClass = ImagePanelPaletteContainer.class;
        
        if(thisClass.getResource("icons/new-icon1.png") == null) {
            newIcon = null;
            storeIcon = null;
            mutateIcon = null;
            breedIcon = null;
            stopIcon = null;
        } else {
            newIcon = new ImageIcon( thisClass.getResource("icons/new-icon1.png") );
            storeIcon = new ImageIcon( thisClass.getResource("icons/store-icon1.png") );
            mutateIcon = new ImageIcon( thisClass.getResource("icons/mutate-icon1.png") );
            breedIcon = new ImageIcon( thisClass.getResource("icons/breed-icon1.png") );
            stopIcon = new ImageIcon( thisClass.getResource("icons/stop-icon1.png") );
        }
    }
    
    private static final Color buttonBackground = new Color(180,180,180);
    
    private JPanel buttonBar;
    
    private JButton newButton;
    private JButton storeButton;
    private JButton mutateButton;
    private JButton breedButton;
    private JButton stopButton;
    
    /** Creates a new instance of ImagePanelContainer */
    public ImagePanelPaletteContainer(ImagePanel panel) {
        super(panel);
        
        buttonBar = new JPanel();
        buttonBar.setBackground( buttonBackground );
        add(buttonBar,BorderLayout.SOUTH);
        
        // add buttons here
        buttonBar.add(newButton = new IconButton(newIcon,this));
        buttonBar.add(storeButton = new IconButton(storeIcon,this));
        buttonBar.add(mutateButton = new IconButton(mutateIcon,this));
        buttonBar.add(breedButton = new IconButton(breedIcon,this));
        buttonBar.add(stopButton = new IconButton(stopIcon,this));
        
        newButton.setToolTipText("New");
        storeButton.setToolTipText("Store");
        mutateButton.setToolTipText("Mutate");
        breedButton.setToolTipText("Breed");
        stopButton.setToolTipText("Stop render");
    }

    public void actionPerformed(ActionEvent e) {
            
        if(e.getSource() == newButton && !getImagePanel().isRendering())
            Application.getApplication().doNewSingle(getImagePanel());
        
        if(getImagePanel().getStructure() == null)
            return;
        
        if(!getImagePanel().isRendering()) {
            
            if(e.getSource() == storeButton)
                Application.getApplication().doStore(getImagePanel().getStructure());

            if(e.getSource() == mutateButton)
                Application.getApplication().doMutate(getImagePanel().getStructure());

            if(e.getSource() == breedButton)
                Application.getApplication().doBreedButton(getImagePanel().getStructure());
        } else {
            if(e.getSource() == stopButton)
                getImagePanel().stopRender();
        }
    }
    
}
