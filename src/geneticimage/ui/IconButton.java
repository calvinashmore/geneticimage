package geneticimage.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;


class IconButton extends JButton {
    
    public IconButton(Icon icon, ActionListener listener) {
        
        super(icon);
        
        if(listener != null)
            addActionListener(listener);
        
        setContentAreaFilled(true);
        setBackground( new Color(255, 255, 255) );
        Dimension dim;
        if(icon == null)
            dim = new Dimension(10,10);
        else dim = new Dimension( icon.getIconWidth()+6, icon.getIconHeight()+6 );
        setMaximumSize(dim);
        setMinimumSize(dim);
        setPreferredSize(dim);
    }
}