/*
 * VizPanel.java
 *
 * Created on March 13, 2006, 10:32 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gen.functions.src;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import utils.*;
import utils.noise.*;

/**
 *
 * @author gtg126z
 */
public class VizPanel extends javax.swing.JPanel {
    
    public final static float amplitude = 1000;
    public final static float scaleBase = 5.0f;
    
    /** Creates a new instance of VizPanel */
    public VizPanel() {
        addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent e) {repaint();}
        });
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new VizPanel());
                frame.setVisible(true);
                //new VizFrame().setVisible(true);
            }
        });
    }
    
    public void paint(Graphics g) {
        
        g.setColor(new java.awt.Color(255,255,255));
        g.fillRect(0,0,getWidth(),getHeight());
        
        double minRange = 0;
        double maxRange = 2000;
        
        double yOffset = getHeight();
        double yScale = -getHeight() / (maxRange-minRange);
        
        double lastX=0;
        double lastY=0;
        
        g.setColor(new java.awt.Color(0,0,0));
        
        PerlinNoiseParameters noiseParams = new PerlinNoiseParameters();
        noiseParams.translate.x = 10*Math.random();
        noiseParams.translate.y = 10*Math.random();
        noiseParams.translate.z = 10*Math.random();
        PerlinNoise noise1 = new PerlinNoise( noiseParams );
        NoiseFractal test = new TestF();
        
        for(int x=0;x<getWidth();x++) {
            
            double fx = ((float)x)/getWidth();
            
            //float y = fx*1000;
            double y;
            
            //y = 1000 * noise1.noise(fx*2) + 1000;
            y = 1000 * test.evalFractal(noise1,fx*5,0,0) + 1000;
            //y = 2000 * (float)noise1.fade(fx);
                
            y = y*yScale+yOffset;
            
            if(x>0) {
                g.drawLine(
                        (int) lastX,
                        (int) lastY,
                        (int) x,
                        (int) y
                        );
            }
            
            lastX = x;
            lastY = y;
        }
    }
    
    private class TestF implements NoiseFractal {
        
        private double lacunarity;
        private double exponent;
        private int octaves;
        
        public TestF() {
            lacunarity = 1.5 + Math.random();
            exponent = .3 + .4*Math.random();
            octaves = 12+new Random().nextInt(3);
        }
        
        public double evalFractal(NoiseFunction f, double x, double y, double z) {
            
            double amplitude = 1;

            double x1 = x;
            double y1 = y;
            double z1 = z;

            double value = 0;
            double weight = 0;
            double signal = 0;
            
            //weight = value = f.noise( x1, y1, z1 );

            for(int i=0;i<octaves;i++) {
                //signal = f.noise( x1, y1, z1 ) * amplitude;
                //value += weight * signal;
                //weight = signal;
                signal = f.noise( x1, y1, z1 );
                value += signal * amplitude;
                
                x1 *= lacunarity + value;
                y1 *= lacunarity + value;
                z1 *= lacunarity + value;
                amplitude *= exponent;
            }
            return value;
        }
        
    }
}
