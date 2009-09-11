/*
 * VPEnumEditor.java
 *
 * Created on June 7, 2006, 10:20 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui.equation;

import javax.swing.JComboBox;

/**
 *
 * @author Calvin Ashmore
 */
class VPEnumEditor extends VPEditor {
    
    /** Creates a new instance of VPEnumEditor */
    public VPEnumEditor(Enum value) {
        Enum[] types = null;
        try {
            //utils.linear.grid.GridScaleMethod.
            java.lang.reflect.Method m = value.getClass().getMethod("values");
            types = (Enum[])m.invoke(value);
        }
        catch(NoSuchMethodException e) {}
        catch(IllegalAccessException e) {}
        catch(java.lang.reflect.InvocationTargetException e) {}

        component = new JComboBox(types);
        ((JComboBox)component).setSelectedItem(value);
    }

    public boolean isValueOK() {
        return true;
    }

    public Object getValue() {
        return ((JComboBox)component).getSelectedItem();
    }

    void setValue(Object value) {
        ((JComboBox)component).setSelectedItem(value);
    }
    
}
