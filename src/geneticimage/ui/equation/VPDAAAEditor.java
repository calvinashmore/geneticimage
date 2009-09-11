/*
 * VPDAEditor.java
 *
 * Created on June 7, 2006, 11:52 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui.equation;

import geneticimage.ui.Application;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Calvin Ashmore
 */
class VPDAAAEditor extends VPEditor implements ActionListener {
    
    double[][][] myVals;
    
    /** Creates a new instance of VPDAEditor */
    public VPDAAAEditor(double[][][] vals) {
        
        if(vals != null) {
            myVals = new double[vals.length][vals[0].length][vals[0][0].length];
            for(int i=0;i<vals.length;i++)
            for(int j=0;j<vals[0].length;j++)
            for(int k=0;k<vals[0][0].length;k++)
                myVals[i][j][k] = vals[i][j][k];
        }
        
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(this);
        editButton.setEnabled(vals != null);
        component = editButton;
    }

    public boolean isValueOK() {
        return true;
    }

    public Object getValue() {
        return myVals;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() != component)
            return;
        
        EditDialog dialog = new EditDialog();
        dialog.setVisible(true);
        dialog.dispose();
    }
    
    void setValue(Object value) {
        double[][][] vals = (double[][][])value;
        
        if(vals != null) {
            myVals = new double[vals.length][vals[0].length][vals[0][0].length];
            for(int i=0;i<vals.length;i++)
            for(int j=0;j<vals[0].length;j++)
            for(int k=0;k<vals[0][0].length;k++)
                myVals[i][j][k] = vals[i][j][k];
        }
        
        ((JButton)component).setEnabled(vals != null);
    }
    
    private static final Font labelFont = new Font("Arial",Font.PLAIN,12);
    
    private class EditDialog extends JDialog implements ActionListener {
    
        private JButton okButton;
        private JButton cancelButton;
        private JTextField[][] textFields;
        
        public EditDialog() {
            setModal(true);
            setTitle("Edit parameter");

            okButton = new JButton("OK");
            okButton.setFont(labelFont);
            okButton.addActionListener(this);

            cancelButton = new JButton("Cancel");
            cancelButton.setFont(labelFont);
            cancelButton.addActionListener(this);
            
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridBagLayout());
            
            GridBagConstraints constraints = new GridBagConstraints();
            
            textFields = new JTextField[myVals.length][myVals[0].length];
            for(int i=0;i<myVals.length;i++) {
                constraints.gridy = i;
                for(int j=0;j<myVals[0].length;j++) {
                    String text = "[ "+ myVals[i][j][0];
                    for(int k=1;k<myVals[0][0].length;k++) {
                        text += " , "+myVals[i][j][k];
                    }
                    text += " ]";
                    
                    JTextField field = new JTextField(text);
                    field.setFont(labelFont);
                    field.setMaximumSize(new Dimension(200,200));
                    textFields[i][j] = field;

                    constraints.gridx = j;
                    mainPanel.add(field,constraints);
                }
            }
            mainPanel.setBorder(new EmptyBorder(5,5,5,5));
            
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(okButton);
            buttonPanel.add(cancelButton);
            
            setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
            add(mainPanel);
            add(buttonPanel);
            
            pack();
            setLocationRelativeTo(Application.getApplication());
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == okButton) {
                
                try{
                    for(int i=0;i<myVals.length;i++)
                    for(int j=0;j<myVals[0].length;j++) {
                        //String array[] = textFields[i][j].getText().split("[], ");
                        String s = textFields[i][j].getText().replaceAll("[\\[\\] ]","");
                        String array[] = s.split(",");
                        for(int k=0;k<myVals[0][0].length;k++) 
                            myVals[i][j][k] = Double.parseDouble(array[k]);
                    }
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,"Invalid input format!","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                } catch(ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(this,"Invalid input format!","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                } catch(java.util.regex.PatternSyntaxException ex) {
                    JOptionPane.showMessageDialog(this,"Invalid input format!","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                setVisible(false);
            }
            if(e.getSource() == cancelButton) {
                setVisible(false);
            }
        }
    }
}
