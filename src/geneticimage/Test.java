/*
 * Test.java
 *
 * Created on September 27, 2005, 10:04 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package geneticimage;

import java.awt.*;
import java.awt.image.*;

import javax.imageio.*;
import java.io.*;


import utils.*;
import utils.linear.grid.*;

/**
 *
 * @author gtg126z
 */
public class Test {
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        //NodeFunctionFactory nff = new NodeFunctionFactory();
        
        //Node evaluator = nff.makeTree(utils.Color.class);
        //System.out.println(evaluator);
        
        
        ColorGrid cg = ColorGrid.decodeImage(ImageIO.read(new File("wombat01.png")));
        
        int N = 3;
        
        ColorGrid cgdup = new ColorGrid(N*cg.getXRes(), N*cg.getYRes());
        
        for(int i=0;i<cgdup.getXRes();i++)
        for(int j=0;j<cgdup.getYRes();j++)
        {
            //cgdup.setValue(i,j, cg.pointGaussAverage((float)i/N,(float)j/N, 2, 10));
            
            float x = (float)i/N;
            float y = (float)j/N;
            
            cgdup.setValue(i,j, cg.evalScale(10*x,10*y,
                    GridWrapMethod.mirror, GridWrapMethod.repeat, GridScaleMethod.cubic ));
        }
        
        BufferedImage img = cgdup.makeImage();
        ImageIO.write(img, "png", new File("wombatOut.png"));
        
        
        /*NodeFunctionFactory nff = new NodeFunctionFactory();
        Node evaluator = nff.makeTree(utils.Color.class);
        Node evalcopy = evaluator.clone();
        
        System.out.println(evaluator);
        System.out.println("\n\n");
        System.out.println(evalcopy); */
        
        /*
        int res = 500;
        Image img = buildImage(res,res);
        
        Frame frame = new ShowFrame(img);
        frame.setVisible(true); */
    }
    
    /*
    static public Image buildImage(int xres, int yres) {
        
        BufferedImage img = new BufferedImage(xres,yres, BufferedImage.TYPE_INT_ARGB);
        
        //Context c = new Context();
        //NodeFunction.setContext(c);
        
        Cellular cell = new Cellular();
        
        for(int y=0; y<yres; y++)
        for(int x=0; x<yres; x++) {
            
            LVect3d pos = new LVect3d(x/20.0 + 5, y/20.0, 0);
            CellularResult cr = cell.evaluate(pos);
            
             
            double r,g,b;
            
            r = cr.getF(3) - cr.getF(0);
            g = cr.getF(3) - cr.getF(0);
            b = cr.getF(3) - cr.getF(0);
            
            if(y%100 == 0 && x%50 == 3)
                System.out.println(r + " " + g + " " + b);
            
            int A = 255;
            int R = Math.max( Math.min( (int)(r*255), 255 ), 0 );
            int G = Math.max( Math.min( (int)(g*255), 255 ), 0 );
            int B = Math.max( Math.min( (int)(b*255), 255 ), 0 );

            int color = (A << 24) + (R << 16) + (G << 8) + (B);
            
            img.setRGB(x,y, color);
            
        }
        
        return img;
    }*/
    
}
