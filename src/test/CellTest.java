/*
 * CellTest.java
 *
 * Created on February 22, 2006, 4:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import utils.*;
import utils.cellularautomata.*;
import utils.linear.Color;
import utils.linear.LDouble;
import utils.linear.grid.ArrayGrid;
import utils.linear.grid.Buffer_d;
import utils.linear.grid.ColorGrid;
import utils.linear.grid.GridScaleMethod;

/**
 *
 * @author Calvin Ashmore
 */
public class CellTest {
    
    public static void main(String args[]) {
        CellTest ct = new CellTest();
        
        //CellularAutomata1d ca = new CellularAutomata1d1(ct.data, 3, 5);
        //CellularAutomata1d2 ca = new CellularAutomata1d2(ct.data, 2, 3);
        //CellularAutomata1d_cont ca = new CellularAutomata1d_cont(ct.data, 5);
        CellularAutomata1d2_cont ca = new CellularAutomata1d2_cont(ct.data, 3);
        //ca.fill();
        
        ColorGrid cg = ct.flesh();
        ArrayGrid<Color> cg0 = cg.rescale(1000,1000, GridScaleMethod.square);
        ColorGrid cg1 = new ColorGrid(cg0);
        
        /*ShowFrame sf = new ShowFrame(cg1.makeImage());
        sf.setVisible(true);
        sf.addWindowListener(
            new WindowAdapter()
            { 
                public void windowClosed(WindowEvent e)
                { 
                    System.exit(0); 
                } 

                public void windowClosing(WindowEvent e)
                { 
                    windowClosed(e); 
                } 
            }
        );*/
    }
    
    Buffer_d data;
    private ColorGrid flesh() {
        
        ColorGrid cg = new ColorGrid(data.getXRes(),data.getYRes());
        
        for(int x=0;x<data.getXRes();x++)
        for(int y=0;y<data.getYRes();y++) {
            double d = 1 - data.getValue(x,y).val;
            cg.setValue(x,y,new Color( d,d,d ));
        }
        
        return cg;
    }
    
    /*
    private double get(int x, int y) {
        return data.getValue( (x+data.getXRes())%data.getXRes() ,y).val;
    }
    
    private double evaluate1(int row, int pos) {
        
        double in1 = get(pos-1,row-1);
        double in2 = get(pos-0,row-1);
        double in3 = get(pos+1,row-1);
        
        //return (in1 + in2 + in3 + .2000)%1.0;
        
        double v = Math.pow(in1+Math.sqrt(in2) + 1.3*in3,1.2)/4;
        v = v - Math.floor(v);
        
        return v;
    }
    
    private double evaluate2(int row, int pos) {
        
        double in1 = get(pos-1,row-1);
        double in2 = get(pos-0,row-1);
        double in3 = get(pos+1,row-1);
        
        boolean bin1 = in1 == 1;
        boolean bin2 = in2 == 1;
        boolean bin3 = in3 == 1;
        
        
        int code = ~90;
        
        if( bin1 &&  bin2 &&  bin3 && ((code >> 0)&1) == 1)
            return 1;
        if(!bin1 &&  bin2 &&  bin3 && ((code >> 1)&1) == 1)
            return 1;
        if( bin1 && !bin2 &&  bin3 && ((code >> 2)&1) == 1)
            return 1;
        if(!bin1 && !bin2 &&  bin3 && ((code >> 3)&1) == 1)
            return 1;
        
        if( bin1 &&  bin2 && !bin3 && ((code >> 4)&1) == 1)
            return 1;
        if(!bin1 &&  bin2 && !bin3 && ((code >> 5)&1) == 1)
            return 1;
        if( bin1 && !bin2 && !bin3 && ((code >> 6)&1) == 1)
            return 1;
        if(!bin1 && !bin2 && !bin3 && ((code >> 7)&1) == 1)
            return 1;
        
        return 0;
    }
    
    int COLORS = 4;
    
    CellCode cc = new CellCode(3,COLORS);
    
    private double evaluate3(int row, int pos) {
        
        double in1 = get(pos-1,row-1);
        double in2 = get(pos-0,row-1);
        double in3 = get(pos+1,row-1);
        
        //double in4 = get(pos-2,row-1);
        //double in5 = get(pos+2,row-1);
        
        int inputs[] = new int[3];
        inputs[0] = (int) in1 * (COLORS-1);
        inputs[1] = (int) in2 * (COLORS-1);
        inputs[2] = (int) in3 * (COLORS-1);
        
        //inputs[3] = (int) in4 * (COLORS-1);
        //inputs[4] = (int) in5 * (COLORS-1);
        
        return cc.evaluate(inputs)/(COLORS-1.0);
    }
    
    private void fill() {
        
        for(int x=0;x<data.getXRes();x++)
        for(int y=0;y<data.getYRes();y++)
            data.setValue(x,y, new LDouble(0));
        
        //data.setValue(data.getXRes()/2,0,new LDouble(1));
        
        Random rand = new Random();
        
        for(int x=0;x<data.getXRes();x++)
            data.setValue(x,0, new LDouble( rand.nextInt(COLORS) / (COLORS-1.0) ));
        
        for(int y=1;y<data.getYRes();y++)
        for(int x=0;x<data.getXRes();x++)
            data.setValue(x,y, new LDouble(evaluate3(y,x)));
    }*/
    
    /** Creates a new instance of CellTest */
    public CellTest() {
        data = new Buffer_d(500,500);
    }
    
}
