/*
 * VPTextEditor.java
 *
 * Created on June 7, 2006, 12:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui.equation;

import java.awt.Dimension;
import javax.swing.JTextField;
import utils.linear.Color;
import utils.linear.Complex;
import utils.linear.LDouble;
import utils.linear.LVect2d;
import utils.linear.LVect3d;
import utils.linear.Quaternion;

/**
 *
 * @author Calvin Ashmore
 */
class VPTextEditor extends VPEditor {
    
    private Object value;
    JTextField textField;
    
    /** Creates a new instance of VPTextEditor */
    public VPTextEditor(Object value) {
        this.value = value;
        
        textField = new JTextField();
        component = textField;
        
        if(value != null)
            textField.setText( value.toString() );
        else textField.setText( "null" );
        
        textField.setPreferredSize( new Dimension (
                200, textField.getPreferredSize().height
                ) );
        textField.setMaximumSize( new Dimension (
                Short.MAX_VALUE, Short.MAX_VALUE
                ) );
    }

    public boolean isValueOK() {
        String s = textField.getText();
        if(value instanceof Integer) {
            try{
                Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e) {return false;}
        } else if(value instanceof Double) {
            try{
                Double.parseDouble(s);
                return true;
            } catch(NumberFormatException e) {return false;}
        } else if(value instanceof LVect2d) {
            try{
                LVect2d.parse(s);
                return true;
            }
            catch(NumberFormatException e) {return false;}
            catch(ArrayIndexOutOfBoundsException e) {return false;}
        } else if(value instanceof LVect3d) {
            try{
                LVect3d.parse(s);
                return true;
            }
            catch(NumberFormatException e) {return false;}
            catch(ArrayIndexOutOfBoundsException e) {return false;}
        } else if(value instanceof Color) {
            try{
                Color.parse(s);
                return true;
            }
            catch(NumberFormatException e) {return false;}
            catch(ArrayIndexOutOfBoundsException e) {return false;}
        } else if(value instanceof Complex) {
            try{
                Complex.parse(s);
                return true;
            }
            catch(NumberFormatException e) {return false;}
            catch(ArrayIndexOutOfBoundsException e) {return false;}
        } else if(value instanceof Quaternion) {
            try{
                Quaternion.parse(s);
                return true;
            }
            catch(NumberFormatException e) {return false;}
            catch(ArrayIndexOutOfBoundsException e) {return false;}
        } else if(value instanceof String) {
            return true;
        }
        
        return false;
    }

    public Object getValue() {
        
        String s = textField.getText();
        if(value instanceof Integer)
            return Integer.parseInt(s);
        if(value instanceof Double)
            return Double.parseDouble(s);
        if(value instanceof LVect2d)
            return LVect2d.parse(s);
        if(value instanceof LVect3d)
            return LVect3d.parse(s);
        if(value instanceof Color)
            return Color.parse(s);
        if(value instanceof Complex)
            return Complex.parse(s);
        if(value instanceof Quaternion)
            return Quaternion.parse(s);
        if(value instanceof String)
            return s;
        return null;
    }

    void setValue(Object value) {
        if(value != null)
            textField.setText( value.toString() );
        else textField.setText( "null" );
    }
    
}
