/*
 * VisualNodePopupMenu.java
 *
 * Created on June 4, 2006, 10:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui.equation;

import geneticimage.Node;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Calvin Ashmore
 */
public class VisualNodePopupMenu extends JPopupMenu implements ActionListener {
    
    protected static Font menuFont = new Font("Arial",Font.PLAIN,12);
    
    private VisualNode vn;
    private JMenuItem reroot;
    private JMenuItem remove;
    private JMenuItem newParams;
    private JMenuItem copyNode;
    private JMenuItem setupNode;
    
    /** Creates a new instance of VisualNodePopupMenu */
    public VisualNodePopupMenu(VisualNode vn) {
        this.vn = vn;
        
        copyNode = new JMenuItem("Copy node");
        copyNode.setFont(menuFont);
        copyNode.addActionListener(this);
        add(copyNode);
        
        remove = new JMenuItem("Remove node");
        remove.setFont(menuFont);
        remove.addActionListener(this);
        add(remove);
        
        //if(canSetup(vn.getBase())) {
        setupNode = new JMenuItem("Execute setup");
        setupNode.setFont(menuFont);
        setupNode.addActionListener(this);
        add(setupNode);
        //}
        
        if(vn.getBase().getNumberParameters() > 0) {
            newParams = new JMenuItem("Randomize parameters");
            newParams.setFont(menuFont);
            newParams.addActionListener(this);
            add(newParams);
        }
        
        if(vn.getBase().getOutputType() == utils.linear.Color.class) {
            reroot = new JMenuItem("Set as root node");
            reroot.setFont(menuFont);
            reroot.addActionListener(this);
            add(reroot);
        }
    }

    public void actionPerformed(ActionEvent e) {
        VisualNodeView vnv = (VisualNodeView)vn.getParent();
        
        if(e.getSource() == reroot) {
            vnv.setRoot(vn);
        } else if(e.getSource() == remove) {
            vnv.removeNode(vn);
        } else if(e.getSource() == newParams) {
            vnv.randomParams(vn);
        } else if(e.getSource() == copyNode) {
            vnv.copyNode(vn);
        } else if(e.getSource() == setupNode) {
            vnv.setupNode(vn);
        }
    }

    /*private boolean canSetup(Node node) {
        for(int i=0;i<node.getNumberParameters();i++)
            if(node.getParameterValue(i) == null)
                return true;
        return false;
    }*/
}
