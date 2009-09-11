/*
 * VisualNodeViewPopupMenu.java
 *
 * Created on June 4, 2006, 12:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui.equation;

import geneticimage.AllFunctions;
import geneticimage.NodeFunction;
import geneticimage.NodeFunctionFactory;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Calvin Ashmore
 */
public class VisualNodeViewPopupMenu extends JPopupMenu implements ActionListener {
    
    protected static Font menuFont = new Font("Arial",Font.PLAIN,12);
    
    private VisualNodeView vnv;
    private Map<Class, JMenu> functionsByOutput; // class is output class
    private Map<Class, Map<Class,JMenu>> functionsByGroup; // output, then group
    private Map<JMenuItem, NodeFunction> allFunctions;
    
    private JMenuItem update;
    private JMenuItem reset;
    private JMenuItem paste;
    private JMenu create;
    
    /** Creates a new instance of VisualNodeViewPopupMenu */
    public VisualNodeViewPopupMenu(VisualNodeView vnv) {
        this.vnv = vnv;
        
        setFont(menuFont);
        
        update = new JMenuItem("Update");
        update.setFont(menuFont);
        update.addActionListener(this);
        add(update);
        
        reset = new JMenuItem("Reset");
        reset.setFont(menuFont);
        reset.addActionListener(this);
        add(reset);
        
        paste = new JMenuItem("Paste");
        paste.setFont(menuFont);
        paste.addActionListener(this);
        add(paste);
        
        create = new JMenu("Create");
        create.setFont(menuFont);
        create.addActionListener(this);
        add(create);
        
        functionsByOutput = new Hashtable();
        functionsByGroup = new Hashtable();
        allFunctions = new Hashtable();
        
        for(NodeFunction nf : NodeFunctionFactory.allFunctions()) {
            String functionName = nf.getClass().getName();
            functionName = functionName.substring(functionName.lastIndexOf(".")+1);
            
            JMenuItem functionItem = new JMenuItem(functionName);
            functionItem.addActionListener(this);
            functionItem.setFont(menuFont);
            allFunctions.put(functionItem,nf);
            
            Class outputClass = nf.getReturnClass();
            Map<Class, JMenu> groupMap = functionsByGroup.get(outputClass);
            if(groupMap == null) {
                groupMap = new Hashtable();
                functionsByGroup.put(outputClass, groupMap);
            }
            
            if(nf.getClass().getEnclosingClass() == null) {
                
                JMenu outputGroup = getOutputGroup(outputClass);
                outputGroup.add(functionItem);
                
            } else {
                Class groupClass = nf.getClass().getEnclosingClass();
                JMenu groupItem = groupMap.get(groupClass);
                if(groupItem == null) {
                    String groupName = groupClass.getName();
                    groupName = groupName.substring(groupName.lastIndexOf(".")+1);
                    groupItem = new JMenu(groupName);
                    groupItem.setFont(menuFont);
                    groupMap.put(groupClass,groupItem);
                    
                    JMenu outputGroup = getOutputGroup(outputClass);
                    outputGroup.add(groupItem);
                    
                }
                
                groupItem.add(functionItem);
            }
        }
    }

    private JMenu getOutputGroup(final Class outputClass) {
        
        JMenu outputGroup = functionsByOutput.get(outputClass);
        if(outputGroup == null) {
            String outputName = outputClass.getName();
            outputName = outputName.substring(outputName.lastIndexOf(".")+1);

            outputGroup = new JMenu(outputName);
            outputGroup.setFont(menuFont);
            functionsByOutput.put(outputClass,outputGroup);
            
            //add(outputGroup);
            create.add(outputGroup);
        }
        return outputGroup;
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == update)
            vnv.updateView();
        
        else if(e.getSource() == reset)
            vnv.resetView();
        
        else if(e.getSource() == paste)
            vnv.pasteNode();
        
        else if(e.getSource() instanceof JMenuItem) {
            NodeFunction nf = allFunctions.get((JMenuItem)e.getSource());
            vnv.createNewNode(nf);
            //System.out.println("selected "+nf.getClass());
        }
    }
    
}
