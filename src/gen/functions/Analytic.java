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

public class Analytic implements FunctionGroup, java.io.Serializable {
   class Gaussian_v2 extends NodeFunction {
      double gauss ( double x ) { return Math . exp ( - x * x ) ; }
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         return new LVect2d ( gauss ( x . x ) , gauss ( x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2();
      }

   }

   class Squash_v2 extends NodeFunction {
      double squash ( double x ) { return x / ( 1.0 + Math . abs ( x ) ) ; }
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         return new LVect2d ( squash ( x . x ) , squash ( x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2();
      }

   }

   class Squash2_v2 extends NodeFunction {
      double squash ( double x , double y ) { return x / ( y + Math . abs ( x ) ) ; }
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LVect2d ( squash ( x . x , y . val ) , squash ( x . y , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class Sigmoid_v2 extends NodeFunction {
      double squash ( double x ) { return 1 / ( 1.0 + Math . exp ( - x ) ) ; }
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         return new LVect2d ( squash ( x . x ) , squash ( x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2();
      }

   }

   class Gaussian_v3 extends NodeFunction {
      double gauss ( double x ) { return Math . exp ( - x * x ) ; }
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         return new LVect3d ( gauss ( x . x ) , gauss ( x . y ) , gauss ( x . z ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v3();
      }

   }

   class Squash_v3 extends NodeFunction {
      double squash ( double x ) { return x / ( 1.0 + Math . abs ( x ) ) ; }
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         return new LVect3d ( squash ( x . x ) , squash ( x . y ) , squash ( x . z ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v3();
      }

   }

   class Squash2_v3 extends NodeFunction {
      double squash ( double x , double y ) { return x / ( y + Math . abs ( x ) ) ; }
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LVect3d ( squash ( x . x , y . val ) , squash ( x . y , y . val ) , squash ( x . z , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class Sigmoid_v3 extends NodeFunction {
      double squash ( double x ) { return 1 / ( 1.0 + Math . exp ( - x ) ) ; }
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         return new LVect3d ( squash ( x . x ) , squash ( x . y ) , squash ( x . z ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v3();
      }

   }

   class Gaussian_col extends NodeFunction {
      double gauss ( double x ) { return Math . exp ( - x * x ) ; }
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
         return new Color ( gauss ( x . r ) , gauss ( x . g ) , gauss ( x . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class Squash_col extends NodeFunction {
      double squash ( double x ) { return x / ( 1.0 + Math . abs ( x ) ) ; }
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
         return new Color ( squash ( x . r ) , squash ( x . g ) , squash ( x . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class Squash2_col extends NodeFunction {
      double squash ( double x , double y ) { return x / ( y + Math . abs ( x ) ) ; }
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Color.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Color x = (Color)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new Color ( squash ( x . r , y . val ) , squash ( x . g , y . val ) , squash ( x . b , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Sigmoid_col extends NodeFunction {
      double squash ( double x ) { return 1 / ( 1.0 + Math . exp ( - x ) ) ; }
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
         return new Color ( squash ( x . r ) , squash ( x . g ) , squash ( x . b ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_col();
      }

   }

   class Abs extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . abs ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         if ( x . getMinimum ( ) > 0 ) return x ; else if ( x . getMaximum ( ) < 0 ) return new Estimate_d ( - x . getMaximum ( ) , - x . getMinimum ( ) ) ; else return new Estimate_d ( 0 , Math . max ( x . getMaximum ( ) , - x . getMinimum ( ) ) ) ;
      }

   }

   class Step extends NodeFunction {
      private double steps;
      public Step() {
         steps = 5 + Math . random ( ) * 10 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( ( int ) ( x . val * steps ) / ( double ) steps ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return x ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return steps;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) steps = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "steps";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Sawtooth extends NodeFunction {
      private double steps;
      public Sawtooth() {
         steps = 5 + Math . random ( ) * 10 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         double x1 = x . val * steps ; double xbase = Math . floor ( x1 ) ; return new LDouble ( x1 - xbase ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( 0 , 1 ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return steps;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) steps = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "steps";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Inverse extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( 1 / x . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         if ( x . getMinimum ( ) > 0 || x . getMaximum ( ) < 0 ) return new Estimate_d ( 1 / x . getMaximum ( ) , 1 / x . getMinimum ( ) ) ; else return new Estimate_d ( ) ;
      }

   }

   class Square extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( x . val * x . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         if ( x . getMinimum ( ) > 0 ) return new Estimate_d ( x . getMinimum ( ) * x . getMinimum ( ) , x . getMaximum ( ) * x . getMaximum ( ) ) ; else if ( x . getMaximum ( ) < 0 ) return new Estimate_d ( x . getMaximum ( ) * x . getMaximum ( ) , x . getMinimum ( ) * x . getMinimum ( ) ) ; else return new Estimate_d ( 0 , Math . max ( x . getMinimum ( ) * x . getMinimum ( ) , x . getMaximum ( ) * x . getMaximum ( ) ) ) ;
      }

   }

   class Cube extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( x . val * x . val * x . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( x . getMinimum ( ) * x . getMinimum ( ) * x . getMinimum ( ) , x . getMaximum ( ) * x . getMaximum ( ) * x . getMaximum ( ) ) ;
      }

   }

   class Sqrt extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . sqrt ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( Math . sqrt ( x . getMinimum ( ) ) , Math . sqrt ( x . getMaximum ( ) ) ) ;
      }

   }

   class Cbrt extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . cbrt ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( Math . cbrt ( x . getMinimum ( ) ) , Math . cbrt ( x . getMaximum ( ) ) ) ;
      }

   }

   class Gaussian extends NodeFunction {
      double gauss ( double x ) { return Math . exp ( - x * x ) ; }
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( gauss ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         if ( x . getMinimum ( ) > 0 ) return new Estimate_d ( gauss ( x . getMinimum ( ) ) , gauss ( x . getMaximum ( ) ) ) ; else if ( x . getMaximum ( ) < 0 ) return new Estimate_d ( gauss ( x . getMaximum ( ) ) , gauss ( x . getMinimum ( ) ) ) ; else return new Estimate_d ( Math . min ( gauss ( x . getMaximum ( ) ) , gauss ( x . getMinimum ( ) ) ) , 1.0 ) ;
      }

   }

   class Squash extends NodeFunction {
      double squash ( double x ) { return x / ( 1.0 + Math . abs ( x ) ) ; }
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( squash ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( squash ( x . getMinimum ( ) ) , squash ( x . getMaximum ( ) ) ) ;
      }

   }

   class Squash2 extends NodeFunction {
      double squash ( double x , double y ) { return x / ( y + Math . abs ( x ) ) ; }
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LDouble ( squash ( x . val , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_d();
      }

   }

   class Sigmoid extends NodeFunction {
      double squash ( double x ) { return 1 / ( 1.0 + Math . exp ( - x ) ) ; }
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( squash ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( squash ( x . getMinimum ( ) ) , squash ( x . getMaximum ( ) ) ) ;
      }

   }

   class Exp extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . exp ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( Math . exp ( x . getMinimum ( ) ) , Math . exp ( x . getMaximum ( ) ) ) ;
      }

   }

   class Log extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . log ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( Math . log ( x . getMinimum ( ) ) , Math . log ( x . getMaximum ( ) ) ) ;
      }

   }

   class Sin extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . sin ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( - 1 , 1 ) ;
      }

   }

   class Cos extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . cos ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( - 1 , 1 ) ;
      }

   }

   class Tan extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . tan ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( - 1 , 1 ) ;
      }

   }

   class Sinh extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . sinh ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( - 1 , 1 ) ;
      }

   }

   class Cosh extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . cosh ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( - 1 , 1 ) ;
      }

   }

   class Tanh extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . tanh ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( ) ;
      }

   }

   class ASin extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . asin ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( - Math . PI / 2 , Math . PI / 2 ) ;
      }

   }

   class ACos extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . acos ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( 0 , Math . PI ) ;
      }

   }

   class ATan extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         return new LDouble ( Math . atan ( x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d ( - Math . PI / 2 , Math . PI / 2 ) ;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new Gaussian_v2() );
      functions.add( new Squash_v2() );
      functions.add( new Squash2_v2() );
      functions.add( new Sigmoid_v2() );
      functions.add( new Gaussian_v3() );
      functions.add( new Squash_v3() );
      functions.add( new Squash2_v3() );
      functions.add( new Sigmoid_v3() );
      functions.add( new Gaussian_col() );
      functions.add( new Squash_col() );
      functions.add( new Squash2_col() );
      functions.add( new Sigmoid_col() );
      functions.add( new Abs() );
      functions.add( new Step() );
      functions.add( new Sawtooth() );
      functions.add( new Inverse() );
      functions.add( new Square() );
      functions.add( new Cube() );
      functions.add( new Sqrt() );
      functions.add( new Cbrt() );
      functions.add( new Gaussian() );
      functions.add( new Squash() );
      functions.add( new Squash2() );
      functions.add( new Sigmoid() );
      functions.add( new Exp() );
      functions.add( new Log() );
      functions.add( new Sin() );
      functions.add( new Cos() );
      functions.add( new Tan() );
      functions.add( new Sinh() );
      functions.add( new Cosh() );
      functions.add( new Tanh() );
      functions.add( new ASin() );
      functions.add( new ACos() );
      functions.add( new ATan() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Gaussian_v2.class)
          return new Gaussian_v2();
      if(nfClass == Squash_v2.class)
          return new Squash_v2();
      if(nfClass == Squash2_v2.class)
          return new Squash2_v2();
      if(nfClass == Sigmoid_v2.class)
          return new Sigmoid_v2();
      if(nfClass == Gaussian_v3.class)
          return new Gaussian_v3();
      if(nfClass == Squash_v3.class)
          return new Squash_v3();
      if(nfClass == Squash2_v3.class)
          return new Squash2_v3();
      if(nfClass == Sigmoid_v3.class)
          return new Sigmoid_v3();
      if(nfClass == Gaussian_col.class)
          return new Gaussian_col();
      if(nfClass == Squash_col.class)
          return new Squash_col();
      if(nfClass == Squash2_col.class)
          return new Squash2_col();
      if(nfClass == Sigmoid_col.class)
          return new Sigmoid_col();
      if(nfClass == Abs.class)
          return new Abs();
      if(nfClass == Step.class)
          return new Step();
      if(nfClass == Sawtooth.class)
          return new Sawtooth();
      if(nfClass == Inverse.class)
          return new Inverse();
      if(nfClass == Square.class)
          return new Square();
      if(nfClass == Cube.class)
          return new Cube();
      if(nfClass == Sqrt.class)
          return new Sqrt();
      if(nfClass == Cbrt.class)
          return new Cbrt();
      if(nfClass == Gaussian.class)
          return new Gaussian();
      if(nfClass == Squash.class)
          return new Squash();
      if(nfClass == Squash2.class)
          return new Squash2();
      if(nfClass == Sigmoid.class)
          return new Sigmoid();
      if(nfClass == Exp.class)
          return new Exp();
      if(nfClass == Log.class)
          return new Log();
      if(nfClass == Sin.class)
          return new Sin();
      if(nfClass == Cos.class)
          return new Cos();
      if(nfClass == Tan.class)
          return new Tan();
      if(nfClass == Sinh.class)
          return new Sinh();
      if(nfClass == Cosh.class)
          return new Cosh();
      if(nfClass == Tanh.class)
          return new Tanh();
      if(nfClass == ASin.class)
          return new ASin();
      if(nfClass == ACos.class)
          return new ACos();
      if(nfClass == ATan.class)
          return new ATan();
      return null;
   }

}
