/*
 * VPEditor.java
 *
 * Created on June 7, 2006, 9:37 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui.equation;

import javax.swing.JComponent;

/**
 *
 * @author Calvin Ashmore
 */
abstract class VPEditor {
    
    protected JComponent component;
    
    /** Creates a new instance of VPEditor */
    public VPEditor() {
    }
    
    public JComponent getComponent() {return component;}
    
    abstract public boolean isValueOK();
    abstract public Object getValue();

    abstract void setValue(Object value);
}
