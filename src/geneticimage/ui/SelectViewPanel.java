/*
 * ImagePanel.java
 *
 * Created on April 23, 2006, 8:24 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import geneticimage.Node;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Calvin Ashmore
 */
public class SelectViewPanel extends JPanel implements ActionListener {
    
    private static final Icon storeIcon; // = new ImageIcon("icons/store-icon.png");
    private static final Icon mutateIcon; // = new ImageIcon("icons/mutate-icon.png");
    private static final Icon breedIcon; // = new ImageIcon("icons/breed-icon.png");
    private static final Icon renderIcon; // = new ImageIcon("icons/render-icon.png");
    private static final Icon newIcon; // = new ImageIcon("icons/new-icon.png");
    private static final Icon openIcon; // = new ImageIcon("icons/open-icon.png");
    private static final Icon saveIcon; // = new ImageIcon("icons/save-icon.png");
    private static final Icon aspectIcon; // = new ImageIcon("icons/aspect-icon.png");
    //private static final Icon stopIcon; // = new ImageIcon("icons/stop-icon.png");
    
    static {
        Class thisClass = SelectViewPanel.class;
        
        if(thisClass.getResource("icons/store-icon.png") == null) {
            storeIcon = null;
            mutateIcon = null;
            breedIcon = null;
            renderIcon = null;
            newIcon = null;
            openIcon = null;
            saveIcon = null;
            aspectIcon = null;
            // stopIcon = null;
        } else {        
            storeIcon = new ImageIcon( thisClass.getResource("icons/store-icon.png") );
            mutateIcon = new ImageIcon( thisClass.getResource("icons/mutate-icon.png") );
            breedIcon = new ImageIcon( thisClass.getResource("icons/breed-icon.png") );
            renderIcon = new ImageIcon( thisClass.getResource("icons/render-icon.png") );
            newIcon = new ImageIcon( thisClass.getResource("icons/new-icon.png") );
            openIcon = new ImageIcon( thisClass.getResource("icons/open-icon.png") );
            saveIcon = new ImageIcon( thisClass.getResource("icons/save-icon.png") );
            aspectIcon = new ImageIcon( thisClass.getResource("icons/aspect-icon.png") );
            //stopIcon = new ImageIcon( thisClass.getResource("icons/stop-icon.png") );
        }
    }
    
    private static final Color backgroundColor = new Color(200,200,200);
    private static final Color textColor = new Color(50,50,50);
    private static final Font textFont = new Font("Arial",Font.PLAIN,12);
    private NodeStructure selection;
    private ImagePanel myImagePanel;
    
    private JPanel buttonPanel;
    
    private JButton newPaletteButton;
    private JButton mutateButton;
    private JButton breedButton;
    private JButton renderButton;
    private JButton storeButton;
    //private JButton advancedButton;
    private JButton libraryButton;
    
    private JButton openButton;
    private JButton saveButton;
    
    /** Creates a new instance of ImagePanel */
    public SelectViewPanel() {
        setBackground(backgroundColor);
        setOpaque(true);
        
        setLayout(new BorderLayout());
        
        myImagePanel = new ImagePanel();
        myImagePanel.setImageSize(200);
        add(myImagePanel, BorderLayout.NORTH);
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(backgroundColor);
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        
        buttonPanel.add( makeButtonAndLabel(
                newPaletteButton = new IconButton(newIcon, this),
                "New palette" ) );
        
        buttonPanel.add( makeButtonAndLabel(
                storeButton = new IconButton(storeIcon, this),
                "Store" ) );
        
        buttonPanel.add( makeButtonAndLabel(
                renderButton = new IconButton(renderIcon, this),
                "Render" ) );
        
        buttonPanel.add( makeButtonAndLabel(
                mutateButton = new IconButton(mutateIcon, this),
                "Mutate" ) );
        
        buttonPanel.add( makeButtonAndLabel(
                breedButton = new IconButton(breedIcon, this),
                "Breed" ) );
        
        buttonPanel.add( makeButtonAndLabel(
                saveButton = new IconButton(saveIcon, this),
                "Save" ) );
        
        buttonPanel.add( makeButtonAndLabel(
                openButton = new IconButton(openIcon, this),
                "Load" ) );

        buttonPanel.add( makeButtonAndLabel(
                libraryButton = new IconButton(aspectIcon, this),
                "Function control" ) );
        
        /* buttonPanel.add( makeButtonAndLabel(
                advancedButton = new IconButton(aspectIcon, this),
                "Advanced" ) ); */
        
        buttonPanel.add( Box.createVerticalGlue() );
    }
    
    private JPanel makeButtonAndLabel(JButton button, String text) {
        
        JLabel label = new JLabel(text);
        label.setFont(textFont);
        label.setForeground(textColor);
        
        //button.setText(text);
        //button.setFont(textFont);
        //button.setForeground(textColor);
        //button.setMaximumSize( new Dimension(Short.MAX_VALUE, button.getMaximumSize().height) );
        
        JPanel bar = new JPanel();
        bar.setBackground(backgroundColor);
        bar.setLayout(new BoxLayout(bar,BoxLayout.X_AXIS));
        bar.add(button);
        bar.add(Box.createHorizontalStrut(10));
        bar.add(label);
        bar.setMaximumSize( new Dimension(Short.MAX_VALUE, button.getMaximumSize().height) );
        bar.setBorder(new EmptyBorder(2,2,2,2));
        return bar;
    }

    void select(NodeStructure selected) {
        selection = selected;
        myImagePanel.setStructure(selection);
    }
    
    //public Dimension getPreferredSize() {return new Dimension(400,400);}
    public Dimension getMaximumSize() {return new Dimension(400,Short.MAX_VALUE);}
    //public Dimension getMinimumSize() {return new Dimension(400,400);}

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == newPaletteButton)
            Application.getApplication().doNewPalette();
        
        if(e.getSource() == openButton) {
            NodeStructure structure = Application.getApplication().loadData();
            if(structure != null) {
                myImagePanel.setStructure(structure);
                myImagePanel.beginRender();
            }
        }
        
        if(e.getSource() == libraryButton){
            FunctaionLibraryDialog dialog = new FunctaionLibraryDialog();
            dialog.pack();
            dialog.setVisible(true);
        }
        
        if(myImagePanel.getStructure() != null) {

            if(e.getSource() == storeButton)
                Application.getApplication().doStore(myImagePanel.getStructure());

            if(e.getSource() == renderButton)
                Application.getApplication().doRender(myImagePanel.getStructure());

            if(e.getSource() == mutateButton)
                Application.getApplication().doMutate(myImagePanel.getStructure());

            if(e.getSource() == breedButton)
                Application.getApplication().doBreedButton(myImagePanel.getStructure());

            if(e.getSource() == saveButton)
                Application.getApplication().saveData(myImagePanel.getStructure());

                //Application.getApplication().saveData(myImagePanel.getStructure());

//            if(e.getSource() == advancedButton) {
//
//                AdvancedDialog dialog = new AdvancedDialog(myImagePanel.getStructure().clone());
//                dialog.setVisible(true);
//                if(dialog.isConfirmed()) {
//                    myImagePanel.setStructure( dialog.getStructure() );
//                    myImagePanel.beginRender();
//                }
//
//            }
        }
    }

    void beginRender() {
        myImagePanel.beginRender();
    }
    
}
