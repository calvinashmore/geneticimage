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
import java.awt.Font;
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
class VPDAEditor extends VPEditor implements ActionListener {
    
    double[] myVals;
    
    /** Creates a new instance of VPDAEditor */
    public VPDAEditor(double[] vals) {
        
        if(vals != null) {
            myVals = new double[vals.length];
            System.arraycopy(vals,0,myVals,0,vals.length);
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
        double[] vals = (double[])value;
        
        if(vals != null) {
            myVals = new double[vals.length];
            System.arraycopy(vals,0,myVals,0,vals.length);
        }
        
        ((JButton)component).setEnabled(vals != null);
    }
    
    private static final Font labelFont = new Font("Arial",Font.PLAIN,12);
    
    private class EditDialog extends JDialog implements ActionListener {
    
        private JButton okButton;
        private JButton cancelButton;
        private JTextField[] textFields;
        
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
            mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
            textFields = new JTextField[myVals.length];
            for(int i=0;i<myVals.length;i++) {
                JTextField field = new JTextField(""+myVals[i]);
                field.setFont(labelFont);
                textFields[i] = field;
                
                mainPanel.add(field);
                /*JPanel row = new JPanel();
                row.add(new JLabel(""+(i+1)));
                row.add(field);
                mainPanel.add(row);*/
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
                        myVals[i] = Double.parseDouble(textFields[i].getText());
                } catch(NumberFormatException ex) {
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
