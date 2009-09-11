/*
 * SimpleHScrollBar.java
 *
 * Created on April 30, 2006, 7:41 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package geneticimage.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class SimpleHScrollBar extends JPanel implements MouseListener, MouseMotionListener {
    
    public static final int size = 12;
    public static final int thumbWidth = 50;
    
    public static final int pressPeriod = 50;
    
    public static final Color barColor = new Color(220,220,220);
    public static final Color buttonColor = new Color(150,150,150);
    public static final Color lineColor = new Color(100,100,100);
    
    private int thumbPosition;
    private int maxValue;
    private ScrollListener listener;
    
    /** Creates a new instance of SimpleHScrollBar */
    public SimpleHScrollBar() {
        setOpaque(true);
        this.thumbPosition = 0;
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    public void setMaxValue(int maxValue) {
        
        if(Math.max(maxValue,0) == this.maxValue)
            return;
        
        if(maxValue <= 0) {
            this.maxValue = 0;
            setThumbPos(0);
            return;
        }
        
        //thumbPosition = thumbPosition*this.maxValue / maxValue;
        this.maxValue = maxValue;
        repaint();
    }
    
    public void setListener(ScrollListener listener) {this.listener = listener;}
    
    public void paint(Graphics g) {
        
        g.setColor(barColor);
        g.fillRect(0,0,getWidth(),getHeight());
        
        g.setColor(buttonColor);
        g.fillRect(0,0,size,getHeight()); // left button
        g.fillRect(getWidth()-size,0,size,getHeight()); // right button
        
        g.setColor(lineColor);
        g.drawLine(1, getHeight()/2, size-2, 1);
        g.drawLine(size-2, 1, size-2, getHeight()-1);
        g.drawLine(size-2, getHeight()-1, 1, getHeight()/2);
        
        g.drawLine(getWidth()-2, getHeight()/2, getWidth()-size+1, 1);
        g.drawLine(getWidth()-size+1, 1, getWidth()-size+1, getHeight()-1);
        g.drawLine(getWidth()-size+1, getHeight()-1, getWidth()-2, getHeight()/2);
        
        if(maxValue != 0) {
            g.setColor(buttonColor);
            g.fillRect(getThumbLeft(),0,thumbWidth,getHeight());
            
            g.setColor(lineColor);
            g.drawRect(getThumbLeft(),0,thumbWidth,getHeight()-1);
        }
    }
    
    private void setThumbPos(int pos) {
        
        //if(maxValue == 0)
        //    return;
        
        thumbPosition = pos;
        
        if(thumbPosition < 0)
            thumbPosition = 0;
        else if(thumbPosition >= maxValue)
            thumbPosition = Math.max( maxValue-1, 0);
        
        if(listener != null)
            listener.setThumbPosition(thumbPosition);
        
        repaint();
    }
    
    private int getThumbLeft() {
        if(maxValue == 0)
            return 0;
        return size+thumbPosition*(getWidth()-2*size-thumbWidth) / maxValue;
    }
    
    public Dimension getMinimumSize() {
        return new Dimension(2*size+thumbWidth,size);
    }
    public Dimension getMaximumSize() {
        return new Dimension(Short.MAX_VALUE,size);
    }
    
    private int difference;
    private boolean dragging;
    private Timer pressTimer;

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        
        int x = e.getX();
        
        if(x < size) {
            // left button
            pressTimer = new Timer();
            pressTimer.scheduleAtFixedRate( new IncrementTask(-1),0,pressPeriod );
            
        } else if(x > getWidth()-size) {
            // right button
            pressTimer = new Timer();
            pressTimer.scheduleAtFixedRate( new IncrementTask(+1),0,pressPeriod );
            
        } else if(x < getThumbLeft()) {
            // left space
            setThumbPos ( x * maxValue / (getWidth()-2*size-thumbWidth) );
            dragging = true;
            difference = x;
            
        } else if(x > getThumbLeft()+thumbWidth) {
            // right space
            setThumbPos ( x * maxValue / (getWidth()-2*size-thumbWidth) );
            dragging = true;
            difference = x;
            
        } else {
            // thumb
            dragging = true;
            difference = x;
        }
        
    }

    public void mouseReleased(MouseEvent e) {
        dragging = false;
        if(pressTimer != null) {
            pressTimer.cancel();
            pressTimer = null;
        }
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {
        if(dragging) {
            
            int oldPos = difference * maxValue / (getWidth()-2*size-thumbWidth);
            int newPos = e.getX() * maxValue / (getWidth()-2*size-thumbWidth);
            
            setThumbPos( newPos - oldPos + thumbPosition );
            difference = e.getX();
        }
    }

    public void mouseMoved(MouseEvent e) {}
    
    private class IncrementTask extends TimerTask {
        
        private int ammount;
        public IncrementTask(int ammount) {
            this.ammount = ammount;
        }
        
        public void run() {
            setThumbPos(thumbPosition + ammount);
        }
    }
}
