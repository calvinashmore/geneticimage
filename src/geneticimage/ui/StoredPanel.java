/*
 * ImagePanel.java
 *
 * Created on April 23, 2006, 8:24 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import utils.linear.grid.ColorGrid;

/**
 *
 * @author Calvin Ashmore
 */
public class StoredPanel extends JLayeredPane implements ScrollListener {
    
    private static final Color backgroundColor = new Color(200,200,200);
    
    private static final int imageSize = 100;
    private static final int imageContainerWidth = 120;
    
    //private List<NodeStructure> storedNodes;
    private List<ImagePanelContainer> nodeImages;
    private JLayeredPane contentPanel;
    private SimpleHScrollBar scrollBar;
    
    /** Creates a new instance of ImagePanel */
    public StoredPanel() {
        setBackground(backgroundColor);
        add(new JLabel("No StoredPanel yet..."));
        setOpaque(true);
        
        nodeImages = new ArrayList();
        
        setLayout(new BorderLayout());
        contentPanel = new JLayeredPane();
        add(contentPanel, BorderLayout.CENTER);
        scrollBar = new SimpleHScrollBar();
        add(scrollBar, BorderLayout.SOUTH);
        
        scrollBar.setListener(this);
    }
    
    public void addImage(NodeStructure structure) {
        if(structure == null)
            return;
        
        ImagePanel newPanel = new ImagePanel();
        newPanel.setImageSize(imageSize);
        newPanel.setStructure(structure);
        
        //newPanel.setImage(structure.getSmallImage());
        ColorGrid cg = ColorGrid.decodeImage(structure.getSmallImage());
        float scaleSize = imageSize / (float)Math.max(cg.getXRes(), cg.getYRes());
        cg = new ColorGrid( cg.rescale((int)(scaleSize * cg.getXRes()), (int)(scaleSize*cg.getYRes()) ));
        newPanel.setImage(cg.makeImage());
        
        ImagePanelContainer container = new ImagePanelStoreContainer(newPanel);
        container.setSize(container.getPreferredSize());
        
        contentPanel.add(container);
        nodeImages.add(container);
        
        reorder();
    }
    
    public void removeImage(NodeStructure structure) {
        // ??
        ImagePanelContainer target = null;
        for(ImagePanelContainer c : nodeImages) {
            if(c.getImagePanel().getStructure() == structure)
                target = c;
        }
        
        if(target != null) {
            contentPanel.remove(target);
            nodeImages.remove(target);
            reorder();
            repaint();
        }
    }
    
    public Dimension getPreferredSize() {return new Dimension(400,imageContainerWidth + SimpleHScrollBar.size);}
    public Dimension getMaximumSize() {return new Dimension(Short.MAX_VALUE,imageContainerWidth + SimpleHScrollBar.size);}
    public Dimension getMinimumSize() {return new Dimension(400,imageContainerWidth + SimpleHScrollBar.size);}
    
    private int scrollWindowOffset;
    private int scrollWindowSize;
    
    private void reorder() {
        
        if(nodeImages.size() > 0)
            scrollWindowSize = nodeImages.size() * imageContainerWidth + 10;
        else
            scrollWindowSize = 0;
        scrollBar.setMaxValue(scrollWindowSize - getWidth());
        
        for(int i=0;i<nodeImages.size();i++) {
            
            nodeImages.get(i).setLocation(
                    i * imageContainerWidth - scrollWindowOffset,
                    0 );
        }
    }

    public void setThumbPosition(int position) {
        scrollWindowOffset = position;
        //scrollBar.setMaxValue(scrollWindowSize - getWidth());
        reorder();
    }
}
