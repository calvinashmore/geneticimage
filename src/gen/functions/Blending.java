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

public class Blending implements FunctionGroup, java.io.Serializable {
   class Limit extends NodeFunction {
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
         return new Color ( Math . max ( Math . min ( x . r , 1 ) , 0 ) , Math . max ( Math . min ( x . g , 1 ) , 0 ) , Math . max ( Math . min ( x . b , 1 ) , 0 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col ( Math . min ( 1 , x . getRMinimum ( ) ) , Math . max ( 0 , x . getRMaximum ( ) ) , Math . min ( 1 , x . getGMinimum ( ) ) , Math . max ( 0 , x . getGMaximum ( ) ) , Math . min ( 1 , x . getBMinimum ( ) ) , Math . max ( 0 , x . getBMaximum ( ) ) ) ;
      }

   }

   class Average extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( ( x . r + y . r ) / 2 , ( x . g + y . g ) / 2 , ( x . b + y . b ) / 2 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   class ColorBurn extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( 1 - ( 1 - x . r ) / ( y . r ) , 1 - ( 1 - x . g ) / ( y . g ) , 1 - ( 1 - x . b ) / ( y . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col();
      }

   }

   class ColorDodge extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( x . r / ( 1 - y . r ) , x . g / ( 1 - y . g ) , x . b / ( 1 - y . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   class Darken extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( Math . min ( x . r , y . r ) , Math . min ( x . g , y . g ) , Math . min ( x . b , y . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( Math . min ( x . getRMinimum ( ) , y . getRMinimum ( ) ) , Math . min ( x . getRMaximum ( ) , y . getRMaximum ( ) ) , Math . min ( x . getGMinimum ( ) , y . getGMinimum ( ) ) , Math . min ( x . getGMaximum ( ) , y . getGMaximum ( ) ) , Math . min ( x . getBMinimum ( ) , y . getBMinimum ( ) ) , Math . min ( x . getBMaximum ( ) , y . getBMaximum ( ) ) ) ;
      }

   }

   class Difference extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( Math . abs ( y . r - x . r ) , Math . abs ( y . g - x . g ) , Math . abs ( y . b - x . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   class Exclusion extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( x . r + y . r - 2 * x . r * y . r , x . g + y . g - 2 * x . g * y . g , x . b + y . b - 2 * x . b * y . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   class HardLight extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         double lum = .2125 * y . r + .7154 * y . g + .0721 * y . b ; if ( lum < 0.45 ) { return new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ; } else if ( lum > .55 ) { return new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ; } else { Color r1 = new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ; Color r2 = new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ; r1 . multv ( 10 * ( lum - 0.45 ) ) ; r2 . multv ( 1 - 10 * ( lum - 0.45 ) ) ; return r1 . add ( r2 ) ; }
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   class InverseDifference extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( 1 - Math . abs ( 1 - y . r - x . r ) , 1 - Math . abs ( 1 - y . g - x . g ) , 1 - Math . abs ( 1 - y . b - x . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   class Lighten extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( Math . max ( x . r , y . r ) , Math . max ( x . g , y . g ) , Math . max ( x . b , y . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( Math . max ( x . getRMinimum ( ) , y . getRMinimum ( ) ) , Math . max ( x . getRMaximum ( ) , y . getRMaximum ( ) ) , Math . max ( x . getGMinimum ( ) , y . getGMinimum ( ) ) , Math . max ( x . getGMaximum ( ) , y . getGMaximum ( ) ) , Math . max ( x . getBMinimum ( ) , y . getBMinimum ( ) ) , Math . max ( x . getBMaximum ( ) , y . getBMaximum ( ) ) ) ;
      }

   }

   class Multiply extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( x . r * y . r , x . g * y . g , x . b * y . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   class Overlay extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         double lum = .2125 * x . r + .7154 * x . g + .0721 * x . b ; Color r1 = new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ; Color r2 = new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ; r1 . multv ( lum ) ; r2 . multv ( 1 - lum ) ; return r1 . add ( r2 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Overlay_x extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         double lum = .2125 * x . r + .7154 * x . g + .0721 * x . b ; if ( lum < 0.45 ) { return new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ; } else if ( lum > .55 ) { return new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ; } else { Color r1 = new Color ( 2 * x . r * y . r , 2 * x . g * y . g , 2 * x . b * y . b ) ; Color r2 = new Color ( 1 - 2 * ( 1 - x . r ) * ( 1 - y . r ) , 1 - 2 * ( 1 - x . g ) * ( 1 - y . g ) , 1 - 2 * ( 1 - x . b ) * ( 1 - y . b ) ) ; r1 . multv ( 10 * ( lum - 0.45 ) ) ; r2 . multv ( 1 - 10 * ( lum - 0.45 ) ) ; return r1 . add ( r2 ) ; }
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   class Screen extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( 1 - ( 1 - x . r ) * ( 1 - y . r ) , 1 - ( 1 - x . g ) * ( 1 - y . g ) , 1 - ( 1 - x . b ) * ( 1 - y . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   class SoftLight extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         Color y = (Color)inputs[1]; 
         return new Color ( 2 * x . r * y . r + x . r * x . r - 2 * x . r * x . r * y . r , 2 * x . g * y . g + x . g * x . g - 2 * x . g * x . g * y . g , 2 * x . b * y . b + x . b * x . b - 2 * x . b * x . b * y . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_col y = (Estimate_col)inputs[1]; 
         return new Estimate_col ( ) ;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new Limit() );
      functions.add( new Average() );
      functions.add( new ColorBurn() );
      functions.add( new ColorDodge() );
      functions.add( new Darken() );
      functions.add( new Difference() );
      functions.add( new Exclusion() );
      functions.add( new HardLight() );
      functions.add( new InverseDifference() );
      functions.add( new Lighten() );
      functions.add( new Multiply() );
      functions.add( new Overlay() );
      functions.add( new Overlay_x() );
      functions.add( new Screen() );
      functions.add( new SoftLight() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Limit.class)
          return new Limit();
      if(nfClass == Average.class)
          return new Average();
      if(nfClass == ColorBurn.class)
          return new ColorBurn();
      if(nfClass == ColorDodge.class)
          return new ColorDodge();
      if(nfClass == Darken.class)
          return new Darken();
      if(nfClass == Difference.class)
          return new Difference();
      if(nfClass == Exclusion.class)
          return new Exclusion();
      if(nfClass == HardLight.class)
          return new HardLight();
      if(nfClass == InverseDifference.class)
          return new InverseDifference();
      if(nfClass == Lighten.class)
          return new Lighten();
      if(nfClass == Multiply.class)
          return new Multiply();
      if(nfClass == Overlay.class)
          return new Overlay();
      if(nfClass == Overlay_x.class)
          return new Overlay_x();
      if(nfClass == Screen.class)
          return new Screen();
      if(nfClass == SoftLight.class)
          return new SoftLight();
      return null;
   }

}
