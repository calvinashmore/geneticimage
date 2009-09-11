/*
 * ParameterRow.java
 *
 * Created on June 7, 2006, 8:10 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui.equation;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Calvin Ashmore
 */
public class VisualParameter {
    
    private Class type;
    private Object value;
    private VPEditor editor;
    
    /** Creates a new instance of ParameterRow */
    public VisualParameter(Class type, Object value) {
        this.type = type;
        this.value = value;
        
        makeEditor();
    }

    public String getTypeName() {
        
        if(isDoubleA())
            return "double[]";
        else if(isDoubleAA())
            return "double[][]";
        else if(isDoubleAAA())
            return "double[][][]";
        else return type.toString();
    }

    public Component getComponent() {
        return editor.getComponent();
    }
    
    public boolean isValueOK() {
        return editor.isValueOK();
    }
    
    public Object getValue() {
        return editor.getValue();
    }
    
    public void setValue(Object value) {
        this.value = value;
        editor.setValue(value);
    }
    
    private boolean isEnum() {return Enum.class.isAssignableFrom(type);}
    private boolean isDoubleA() {return double[].class.isAssignableFrom(type);}
    private boolean isDoubleAA() {return double[][].class.isAssignableFrom(type);}
    private boolean isDoubleAAA() {return double[][][].class.isAssignableFrom(type);}

    private void makeEditor() {
        
        /*if(value == null)
            editor = new VPNullEditor(); */
        
        if(isEnum())
            editor = new VPEnumEditor((Enum)value);
        else if(isDoubleA())
            editor = new VPDAEditor((double[])value);
        else if(isDoubleAA())
            editor = new VPDAAEditor((double[][])value);
        else if(isDoubleAAA())
            editor = new VPDAAAEditor((double[][][])value);
        else
            editor = new VPTextEditor(value);
    }
}
