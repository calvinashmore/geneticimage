/*
 * RenderWindow.java
 *
 * Created on May 2, 2006, 2:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author gtg126z
 */
public class RenderWindow extends JFrame implements ActionListener {
    
    final private ImagePanel panel;
    private JButton saveImage;
    private JButton saveData;
    private NodeStructure structure;
    
    /** Creates a new instance of RenderWindow */
    public RenderWindow(NodeStructure structure, int resolution) {
        super("Render View");
        this.structure = structure;
        
        if(structure.getSmallImage() != null) {
            this.setIconImage(structure.getSmallImage());
        }
        
        panel = new ImagePanel();
        panel.setStructure(structure);
        panel.setImageSize(resolution);
        panel.setBorder( new EmptyBorder(10,10,10,10) );
        
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        
        saveImage = new JButton("Save Image");
        saveImage.addActionListener(this);
        buttonPanel.add(saveImage);
        
        saveData = new JButton("Save Data");
        saveData.addActionListener(this);
        buttonPanel.add(saveData);
        
        panel.beginRender();
        
        Application.getApplication().incrementNumberRenderWindows(1);
        
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                panel.stopRender();
                Application.getApplication().incrementNumberRenderWindows(-1);
            }
        } );
        
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveImage) {
            
            if(panel.isRendering())
                return;
            
            Application.getApplication().saveImage(panel.getImage());
        }
        
        if(e.getSource() == saveData) {
            Application.getApplication().saveData(structure);
        }
    }
    
}
