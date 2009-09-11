/*
 * AdvancedDialog.java
 *
 * Created on May 8, 2006, 3:14 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Calvin Ashmore
 */
public class AdvancedDialog extends JDialog implements ActionListener, ChangeListener{
    
    protected static Font labelFont = new Font("Arial",Font.PLAIN,12);
    
    private JFormattedTextField zoomText;
    private JFormattedTextField aspectText;
    private JFormattedTextField centerTextX;
    private JFormattedTextField centerTextY;
    
    private JSlider zoomSlider;
    private JSlider aspectSlider;
    private JSlider centerSliderX;
    private JSlider centerSliderY;
    
    private JButton okButton;
    private JButton cancelButton;
    
    private JPanel renderPanel;
    
    private NodeStructure structure;
    
    /** Creates a new instance of AdvancedDialog */
    public AdvancedDialog(NodeStructure structure) {
        
        this.structure = structure;
        setModal(true);
        setTitle("Advanced Settings");
        
        renderPanel = new RenderPanel(); // <-- use custom class, shows space of transformed image
        
        okButton = new JButton("OK");
        okButton.setFont(labelFont);
        okButton.addActionListener(this);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(labelFont);
        cancelButton.addActionListener(this);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout( new BoxLayout(mainPanel,BoxLayout.Y_AXIS) );
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        
        mainPanel.add(makeToolPanel());
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(renderPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(buttonPanel);
        
        add(mainPanel);
        
        pack();
    }
    
    protected JPanel makeToolPanel() {
        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.ipadx = 12;
        constraints.ipady = 4;
        constraints.anchor = constraints.NORTHWEST;
        
        DecimalFormat format = new DecimalFormat("0.0000########");
        
        JLabel zoomLabel = new JLabel("Zoom");
        zoomText = new JFormattedTextField(format);
        zoomSlider = new JSlider(-300,300,0);
        
        zoomLabel.setFont(labelFont);
        zoomText.setFont(labelFont);
        zoomText.setValue(structure.getMagnification());
        zoomText.setPreferredSize( new Dimension( 100, zoomText.getPreferredSize().height ) );
        zoomText.addActionListener(this);
        zoomSlider.addChangeListener(this);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        toolPanel.add( zoomLabel, constraints );
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        toolPanel.add( zoomText, constraints );
        
        constraints.gridx = 2;
        constraints.gridy = 0;
        toolPanel.add( zoomSlider, constraints );
        
        
        
        JLabel aspectLabel = new JLabel("Aspect Ratio");
        aspectText = new JFormattedTextField(format);
        aspectSlider = new JSlider(-100,100,0);
        
        aspectLabel.setFont(labelFont);
        aspectText.setFont(labelFont);
        aspectText.setValue(structure.getAspectRatio());
        aspectText.setPreferredSize( new Dimension( 100, zoomText.getPreferredSize().height ) );
        aspectText.addActionListener(this);
        aspectSlider.addChangeListener(this);
        
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        toolPanel.add( aspectLabel, constraints );
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        toolPanel.add( aspectText, constraints );
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        toolPanel.add( aspectSlider, constraints );
        
        
        
        JLabel centerLabelX = new JLabel("Center (X)");
        centerTextX = new JFormattedTextField(format);
        centerSliderX = new JSlider(-500,500,0);
        
        centerLabelX.setFont(labelFont);
        centerTextX.setFont(labelFont);
        centerTextX.setValue(structure.getXCenter());
        centerTextX.setPreferredSize( new Dimension( 100, zoomText.getPreferredSize().height ) );
        centerTextX.addActionListener(this);
        centerSliderX.addChangeListener(this);
        
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        toolPanel.add( centerLabelX, constraints );
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        toolPanel.add( centerTextX, constraints );
        
        constraints.gridx = 2;
        constraints.gridy = 2;
        toolPanel.add( centerSliderX, constraints );
        
        
        
        JLabel centerLabelY = new JLabel("Center (Y)");
        centerTextY = new JFormattedTextField(format);
        centerSliderY = new JSlider(-500,500,0);
        
        centerLabelY.setFont(labelFont);
        centerTextY.setFont(labelFont);
        centerTextY.setValue(structure.getYCenter());
        centerTextY.setPreferredSize( new Dimension( 100, zoomText.getPreferredSize().height ) );
        centerTextY.addActionListener(this);
        centerSliderY.addChangeListener(this);
        
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        toolPanel.add( centerLabelY, constraints );
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        toolPanel.add( centerTextY, constraints );
        
        constraints.gridx = 2;
        constraints.gridy = 3;
        toolPanel.add( centerSliderY, constraints );
        
        return toolPanel;
    }

    private boolean confirmed = false;
    public boolean isConfirmed() {
        return confirmed;
    }

    public NodeStructure getStructure() {
        return structure;
    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == okButton) {
            confirmed = true;
            setVisible(false);
        }
        if(e.getSource() == cancelButton) {
            setVisible(false);
        }
        
        if(e.getSource() == zoomText) {
            double value = 1;
            if(zoomText.getValue() instanceof Double) value = (Double)zoomText.getValue();
            if(zoomText.getValue() instanceof Float) value = (Float)zoomText.getValue();
            if(zoomText.getValue() instanceof Long) value = (Long)zoomText.getValue();
            if(zoomText.getValue() instanceof Integer) value = (Integer)zoomText.getValue();
            
            if(value <= 0) {
                zoomText.setText(""+structure.getMagnification());
            } else {
                structure.setMagnification( value );
                
                double slideValue = Math.log(value);
                //int slideValueMin = slideValue - 
                registerStateChange = false;
                zoomSlider.setMaximum( (int)(slideValue*100) + 300 );
                zoomSlider.setMinimum( (int)(slideValue*100) - 300 );
                zoomSlider.setValue( (int)(slideValue*100) );
                registerStateChange = true;
                renderPanel.repaint();
            }
        }
    }

    private boolean registerStateChange = true;
    public void stateChanged(ChangeEvent e) {
        
        if(!registerStateChange)
            return;
        
        if(e.getSource() == zoomSlider) {
            
            double slideValue = (double)zoomSlider.getValue()/100;
            double value = Math.exp(slideValue);
            
            structure.setMagnification( value );
            
            zoomText.setValue(structure.getMagnification());
            
            registerStateChange = false;
            int zoomAverage = (zoomSlider.getMaximum() + zoomSlider.getMinimum())/2;
            if( Math.abs(slideValue - zoomAverage) > 2 && !zoomSlider.getValueIsAdjusting()) {
                zoomSlider.setMaximum( (int)(slideValue*100) + 300 );
                zoomSlider.setMinimum( (int)(slideValue*100) - 300 );
                zoomSlider.setValue( (int)(slideValue*100) );
            }
            renderPanel.repaint();
            registerStateChange = true;
        }
        
    }
    
    private static final Color renderBG = new Color(180,180,180);
    
    private class RenderPanel extends JPanel {
        
        public Dimension getPreferredSize() {return new Dimension(250,250);}
        
        public void paint(Graphics g) {
            g.setColor( renderBG );
            g.fillRect(0,0, getWidth(), getHeight());
        }
    }
}
