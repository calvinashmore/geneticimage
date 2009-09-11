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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Calvin Ashmore
 */
public class PalettePanel extends JPanel implements ScrollListener {
    
    private static final Color backgroundColor = new Color(200,200,200);
    private static final int horizontalNumberImagesStart = 5;
    
    private static final int imageBorder = 2;
    private static final int imageSize = 200;
    private static final int imageContainerWidth = imageSize+6;
    private static final int imageContainerHeight = imageSize+38;
    
    private int horizontalNumberImages;
    
    private List<ImagePanelContainer> images;
    
    private JLayeredPane contentPanel;
    private SimpleHScrollBar scrollBar;
    //private JScrollPane scrollPane;
    
    public List<ImagePanelContainer> getImages() {return Collections.unmodifiableList(images);}
    
    public Dimension getMinimumSize() { return new Dimension(0, imageContainerHeight*2 + SimpleHScrollBar.size ); }
    
    /** Creates a new instance of ImagePanel */
    public PalettePanel() {
        setBackground(backgroundColor);
        setOpaque(true);
        
        setLayout(new BorderLayout());
        contentPanel = new JLayeredPane();
        add(contentPanel, BorderLayout.CENTER);
        scrollBar = new SimpleHScrollBar();
        add(scrollBar, BorderLayout.SOUTH);
        
        //scrollBar.setMaxValue(100);
        scrollBar.setListener(this);
        
        images = new ArrayList();
        setHorizontalNumberImages(horizontalNumberImagesStart);
    }
    
    private int scrollWindowSize;
    private int scrollWindowOffset;
    
    public int getHorizontalNumberImages() {return horizontalNumberImages;}
    public void setHorizontalNumberImages(int number) {
        
        if(number > horizontalNumberImages) {
            
            for(int i=horizontalNumberImages; i<number; i++) {
                
                
                ImagePanel image1 = new ImagePanel();
                ImagePanel image2 = new ImagePanel();
                
                image1.setImageSize(imageSize);
                image2.setImageSize(imageSize);
                
                ImagePanelContainer container1 = new ImagePanelPaletteContainer(image1);
                ImagePanelContainer container2 = new ImagePanelPaletteContainer(image2);
                
                images.add(container1);
                images.add(container2);
                
                contentPanel.add(container1);
                contentPanel.add(container2);
                
                container1.setLocation(
                        i * imageContainerWidth + scrollWindowOffset,
                        0 );
                container1.setSize(container1.getPreferredSize());
                
                container2.setLocation(
                        i * imageContainerWidth + scrollWindowOffset,
                        imageContainerHeight );
                container2.setSize(container2.getPreferredSize());
            }
            
        } else if (number < horizontalNumberImages) {
            
            for(int i=horizontalNumberImages; i>=number; i--) {
                
                ImagePanelContainer container1 = images.remove(2*i);
                contentPanel.remove(container1);
                
                ImagePanelContainer container2 = images.remove(2*i+1);
                contentPanel.remove(container2);
            }
        }
        
        contentPanel.setSize(contentPanel.getPreferredSize());
        horizontalNumberImages = number;
        
        scrollWindowSize = number * images.get(0).getPreferredSize().width + 10;
        scrollBar.setMaxValue(scrollWindowSize - getWidth());
    }

    //private int lastSize;
    public void setThumbPosition(int position) {
        
        scrollWindowOffset = position;
        
        /*
        if(scrollWindowSize - getWidth() != lastSize) {
            lastSize = scrollWindowSize - getWidth();
            scrollBar.setMaxValue(lastSize);
        }*/
        
        //lastSize = scrollWindowSize - getWidth();
        scrollBar.setMaxValue(scrollWindowSize - getWidth());
        
        for(int i=0;i<horizontalNumberImages;i++) {
            images.get(2*i).setLocation(
                    i * imageContainerWidth - scrollWindowOffset,
                    0 );
            
            images.get(2*i+1).setLocation(
                    i * imageContainerWidth - scrollWindowOffset,
                    imageContainerHeight );
        }
    }
    
}
