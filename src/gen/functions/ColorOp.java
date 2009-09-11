package gen.functions;

import utils.*;
import utils.estimates.*;
import utils.linear.*;
import utils.linear.grid.*;
import utils.noise.*;
import utils.cellular.*;
import utils.cfractal.*;
import java.util.*;
import geneticimage.*;

public class ColorOp implements FunctionGroup, java.io.Serializable {
   class Invert extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         return new Color ( 1 - x . r , 1 - x . g , 1 - x . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class Invert1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color c = new Color ( 1 - x . r , 1 - x . g , 1 - x . b ) ; return c . mult ( x . magnitude ( ) / c . magnitude ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class Tone_blend extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "t";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         LDouble t = (LDouble)inputs[1]; 
         Color c = new Color ( 1 - x . r , 1 - x . g , 1 - x . b ) ; c = c . mult ( x . magnitude ( ) / c . magnitude ( ) ) ; return x . mult ( 1 - t . val ) . add ( c . mult ( t . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_d t = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class offsetHue extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "offset";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         LDouble offset = (LDouble)inputs[1]; 
         double hsb [ ] = x . hsbvals ( ) ; return new Color ( hsb [ 0 ] + offset . val , hsb [ 1 ] , hsb [ 2 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_d offset = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class setHue extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "value";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         LDouble value = (LDouble)inputs[1]; 
         double hsb [ ] = x . hsbvals ( ) ; return new Color ( value . val , hsb [ 1 ] , hsb [ 2 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_d value = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class setSaturation extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "value";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         LDouble value = (LDouble)inputs[1]; 
         double hsb [ ] = x . hsbvals ( ) ; return new Color ( hsb [ 0 ] , value . val , hsb [ 2 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_d value = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class setBrightness extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "value";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         LDouble value = (LDouble)inputs[1]; 
         double hsb [ ] = x . hsbvals ( ) ; return new Color ( hsb [ 0 ] , hsb [ 1 ] , value . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_d value = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class RGB_to_HSB1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         return Color . makeHSB ( x . r , x . g , x . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class RGB_to_HSB2 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         return Color . makeHSB ( x . g , x . r , x . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class RGB_to_HSB3 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         return Color . makeHSB ( x . r , x . b , x . g ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class RGB_to_HSB4 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         return Color . makeHSB ( x . g , x . b , x . r ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class RGB_to_HSB5 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         return Color . makeHSB ( x . b , x . r , x . g ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class RGB_to_HSB6 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         return Color . makeHSB ( x . b , x . g , x . r ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HSB_to_RGB1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         double [ ] hsb = x . hsbvals ( ) ; return new Color ( hsb [ 0 ] , hsb [ 1 ] , hsb [ 2 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HSB_to_RGB2 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         double [ ] hsb = x . hsbvals ( ) ; return new Color ( hsb [ 0 ] , hsb [ 2 ] , hsb [ 1 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HSB_to_RGB3 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         double [ ] hsb = x . hsbvals ( ) ; return new Color ( hsb [ 1 ] , hsb [ 0 ] , hsb [ 2 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HSB_to_RGB4 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         double [ ] hsb = x . hsbvals ( ) ; return new Color ( hsb [ 1 ] , hsb [ 2 ] , hsb [ 0 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HSB_to_RGB5 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         double [ ] hsb = x . hsbvals ( ) ; return new Color ( hsb [ 2 ] , hsb [ 1 ] , hsb [ 0 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HSB_to_RGB6 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         double [ ] hsb = x . hsbvals ( ) ; return new Color ( hsb [ 2 ] , hsb [ 0 ] , hsb [ 1 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HSB extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "s";
         if(i == 2) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble h = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         LDouble b = (LDouble)inputs[2]; 
         return Color . makeHSB ( h . val , s . val , b . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d h = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         Estimate_d b = (Estimate_d)inputs[2]; 
         return new Estimate_col ( b . getMinimum ( ) , b . getMaximum ( ) , b . getMinimum ( ) , b . getMaximum ( ) , b . getMinimum ( ) , b . getMaximum ( ) ) ;
      }

   }

   class HSB1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "s";
         if(i == 2) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble h = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         LDouble b = (LDouble)inputs[2]; 
         return Color . makeHSB ( h . val , s . val , .5 + .5 * b . val / ( 1 + Math . abs ( b . val ) ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d h = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         Estimate_d b = (Estimate_d)inputs[2]; 
         return new Estimate_col();
      }

   }

   class HSB_v3 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hsb";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d hsb = (LVect3d)inputs[0]; 
         return Color . makeHSB ( hsb . x , hsb . y , hsb . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 hsb = (Estimate_v3)inputs[0]; 
         return new Estimate_col ( hsb . getZMinimum ( ) , hsb . getZMaximum ( ) , hsb . getZMinimum ( ) , hsb . getZMaximum ( ) , hsb . getZMinimum ( ) , hsb . getZMaximum ( ) ) ;
      }

   }

   class HSB1_v3 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hsb";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d hsb = (LVect3d)inputs[0]; 
         return Color . makeHSB ( hsb . x , hsb . y , .5 + .5 * hsb . z / ( 1 + Math . abs ( hsb . z ) ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 hsb = (Estimate_v3)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HSB_v3_gauss extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hsb";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d hsb = (LVect3d)inputs[0]; 
         return Color . makeHSB ( hsb . x , Math . exp ( - hsb . y * hsb . y ) , Math . exp ( - hsb . z * hsb . z ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 hsb = (Estimate_v3)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HSB_v3_sigmoid extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hsb";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d hsb = (LVect3d)inputs[0]; 
         return Color . makeHSB ( hsb . x , 1 / ( 1.0 + Math . exp ( - hsb . y ) ) , 1 / ( 1.0 + Math . exp ( - hsb . z ) ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 hsb = (Estimate_v3)inputs[0]; 
         return new Estimate_col();
      }

   }

   class v3_RGB extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "rgb";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color rgb = (Color)inputs[0]; 
         return new LVect3d ( rgb . r , rgb . g , rgb . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col rgb = (Estimate_col)inputs[0]; 
         return new Estimate_v3();
      }

   }

   class v3_HSB extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         double [ ] hsb = x . hsbvals ( ) ; return new LVect3d ( hsb [ 0 ] , hsb [ 1 ] , hsb [ 2 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_v3();
      }

   }

   class RGB extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "r";
         if(i == 1) return "g";
         if(i == 2) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble r = (LDouble)inputs[0]; 
         LDouble g = (LDouble)inputs[1]; 
         LDouble b = (LDouble)inputs[2]; 
         return new Color ( r . val , g . val , b . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d r = (Estimate_d)inputs[0]; 
         Estimate_d g = (Estimate_d)inputs[1]; 
         Estimate_d b = (Estimate_d)inputs[2]; 
         return new Estimate_col ( r . getMinimum ( ) , r . getMaximum ( ) , g . getMinimum ( ) , g . getMaximum ( ) , b . getMinimum ( ) , b . getMaximum ( ) ) ;
      }

   }

   class RGB_v3 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "rgb";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d rgb = (LVect3d)inputs[0]; 
         return new Color ( rgb . x , rgb . y , rgb . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 rgb = (Estimate_v3)inputs[0]; 
         return new Estimate_col ( rgb . getXMinimum ( ) , rgb . getXMaximum ( ) , rgb . getYMinimum ( ) , rgb . getYMaximum ( ) , rgb . getZMinimum ( ) , rgb . getZMaximum ( ) ) ;
      }

   }

   class RGB_v3_gauss extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "rgb";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d rgb = (LVect3d)inputs[0]; 
         return new Color ( Math . exp ( - rgb . x * rgb . x ) , Math . exp ( - rgb . y * rgb . y ) , Math . exp ( - rgb . z * rgb . z ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 rgb = (Estimate_v3)inputs[0]; 
         return new Estimate_col();
      }

   }

   class RGB_v3_sigmoid extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "rgb";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d rgb = (LVect3d)inputs[0]; 
         return new Color ( 1 / ( 1.0 + Math . exp ( - rgb . x ) ) , 1 / ( 1.0 + Math . exp ( - rgb . y ) ) , 1 / ( 1.0 + Math . exp ( - rgb . z ) ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 rgb = (Estimate_v3)inputs[0]; 
         return new Estimate_col();
      }

   }

   class Blend_to_White extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "color";
         if(i == 1) return "blend";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color color = (Color)inputs[0]; 
         LDouble blend = (LDouble)inputs[1]; 
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ; return new Color ( blend1 + ( 1 - blend1 ) * color . r , blend1 + ( 1 - blend1 ) * color . g , blend1 + ( 1 - blend1 ) * color . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col color = (Estimate_col)inputs[0]; 
         Estimate_d blend = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Blend_to_Black extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "color";
         if(i == 1) return "blend";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color color = (Color)inputs[0]; 
         LDouble blend = (LDouble)inputs[1]; 
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ; return new Color ( 0 + ( 1 - blend1 ) * color . r , 0 + ( 1 - blend1 ) * color . g , 0 + ( 1 - blend1 ) * color . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col color = (Estimate_col)inputs[0]; 
         Estimate_d blend = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Blend_to_Gray extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "color";
         if(i == 1) return "blend";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color color = (Color)inputs[0]; 
         LDouble blend = (LDouble)inputs[1]; 
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ; return new Color ( .5 * blend1 + ( 1 - blend1 ) * color . r , .5 * blend1 + ( 1 - blend1 ) * color . g , .5 * blend1 + ( 1 - blend1 ) * color . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col color = (Estimate_col)inputs[0]; 
         Estimate_d blend = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Monochrome extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "color";
         if(i == 1) return "blend";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color color = (Color)inputs[0]; 
         LDouble blend = (LDouble)inputs[1]; 
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ; if ( blend1 > .5 ) return new Color ( 2 * ( blend1 - .5 ) + ( 1 - 2 * ( blend1 - .5 ) ) * color . r , 2 * ( blend1 - .5 ) + ( 1 - 2 * ( blend1 - .5 ) ) * color . g , 2 * ( blend1 - .5 ) + ( 1 - 2 * ( blend1 - .5 ) ) * color . b ) ; else return new Color ( ( 2 * blend1 ) * color . r , ( 2 * blend1 ) * color . g , ( 2 * blend1 ) * color . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col color = (Estimate_col)inputs[0]; 
         Estimate_d blend = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Sigmoidize extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "color";
         if(i == 1) return "blend";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color color = (Color)inputs[0]; 
         LDouble blend = (LDouble)inputs[1]; 
         double blend1 = 1 / ( 1.0 + Math . exp ( - blend . val ) ) ; return new Color ( blend1 * ( 1 - color . r ) + ( 1 - blend1 ) * color . r , blend1 * ( 1 - color . g ) + ( 1 - blend1 ) * color . g , blend1 * ( 1 - color . b ) + ( 1 - blend1 ) * color . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col color = (Estimate_col)inputs[0]; 
         Estimate_d blend = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new Invert() );
      functions.add( new Invert1() );
      functions.add( new Tone_blend() );
      functions.add( new offsetHue() );
      functions.add( new setHue() );
      functions.add( new setSaturation() );
      functions.add( new setBrightness() );
      functions.add( new RGB_to_HSB1() );
      functions.add( new RGB_to_HSB2() );
      functions.add( new RGB_to_HSB3() );
      functions.add( new RGB_to_HSB4() );
      functions.add( new RGB_to_HSB5() );
      functions.add( new RGB_to_HSB6() );
      functions.add( new HSB_to_RGB1() );
      functions.add( new HSB_to_RGB2() );
      functions.add( new HSB_to_RGB3() );
      functions.add( new HSB_to_RGB4() );
      functions.add( new HSB_to_RGB5() );
      functions.add( new HSB_to_RGB6() );
      functions.add( new HSB() );
      functions.add( new HSB1() );
      functions.add( new HSB_v3() );
      functions.add( new HSB1_v3() );
      functions.add( new HSB_v3_gauss() );
      functions.add( new HSB_v3_sigmoid() );
      functions.add( new v3_RGB() );
      functions.add( new v3_HSB() );
      functions.add( new RGB() );
      functions.add( new RGB_v3() );
      functions.add( new RGB_v3_gauss() );
      functions.add( new RGB_v3_sigmoid() );
      functions.add( new Blend_to_White() );
      functions.add( new Blend_to_Black() );
      functions.add( new Blend_to_Gray() );
      functions.add( new Monochrome() );
      functions.add( new Sigmoidize() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Invert.class)
          return new Invert();
      if(nfClass == Invert1.class)
          return new Invert1();
      if(nfClass == Tone_blend.class)
          return new Tone_blend();
      if(nfClass == offsetHue.class)
          return new offsetHue();
      if(nfClass == setHue.class)
          return new setHue();
      if(nfClass == setSaturation.class)
          return new setSaturation();
      if(nfClass == setBrightness.class)
          return new setBrightness();
      if(nfClass == RGB_to_HSB1.class)
          return new RGB_to_HSB1();
      if(nfClass == RGB_to_HSB2.class)
          return new RGB_to_HSB2();
      if(nfClass == RGB_to_HSB3.class)
          return new RGB_to_HSB3();
      if(nfClass == RGB_to_HSB4.class)
          return new RGB_to_HSB4();
      if(nfClass == RGB_to_HSB5.class)
          return new RGB_to_HSB5();
      if(nfClass == RGB_to_HSB6.class)
          return new RGB_to_HSB6();
      if(nfClass == HSB_to_RGB1.class)
          return new HSB_to_RGB1();
      if(nfClass == HSB_to_RGB2.class)
          return new HSB_to_RGB2();
      if(nfClass == HSB_to_RGB3.class)
          return new HSB_to_RGB3();
      if(nfClass == HSB_to_RGB4.class)
          return new HSB_to_RGB4();
      if(nfClass == HSB_to_RGB5.class)
          return new HSB_to_RGB5();
      if(nfClass == HSB_to_RGB6.class)
          return new HSB_to_RGB6();
      if(nfClass == HSB.class)
          return new HSB();
      if(nfClass == HSB1.class)
          return new HSB1();
      if(nfClass == HSB_v3.class)
          return new HSB_v3();
      if(nfClass == HSB1_v3.class)
          return new HSB1_v3();
      if(nfClass == HSB_v3_gauss.class)
          return new HSB_v3_gauss();
      if(nfClass == HSB_v3_sigmoid.class)
          return new HSB_v3_sigmoid();
      if(nfClass == v3_RGB.class)
          return new v3_RGB();
      if(nfClass == v3_HSB.class)
          return new v3_HSB();
      if(nfClass == RGB.class)
          return new RGB();
      if(nfClass == RGB_v3.class)
          return new RGB_v3();
      if(nfClass == RGB_v3_gauss.class)
          return new RGB_v3_gauss();
      if(nfClass == RGB_v3_sigmoid.class)
          return new RGB_v3_sigmoid();
      if(nfClass == Blend_to_White.class)
          return new Blend_to_White();
      if(nfClass == Blend_to_Black.class)
          return new Blend_to_Black();
      if(nfClass == Blend_to_Gray.class)
          return new Blend_to_Gray();
      if(nfClass == Monochrome.class)
          return new Monochrome();
      if(nfClass == Sigmoidize.class)
          return new Sigmoidize();
      return null;
   }

}
