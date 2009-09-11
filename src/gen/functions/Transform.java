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

public class Transform implements FunctionGroup, java.io.Serializable {
   class cross extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d a = (LVect3d)inputs[0]; 
         LVect3d b = (LVect3d)inputs[1]; 
         return LVect3d . cross ( a , b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 a = (Estimate_v3)inputs[0]; 
         Estimate_v3 b = (Estimate_v3)inputs[1]; 
         Estimate_v3 x = ( Estimate_v3 ) inputs [ 0 ] ; Estimate_v3 y = ( Estimate_v3 ) inputs [ 1 ] ; if ( x . isConstant ( ) && y . isConstant ( ) ) { LVect3d r = LVect3d . cross ( x . getCValue ( ) , y . getCValue ( ) ) ; return new Estimate_v3 ( r , r ) ; } double v1 = x . getMaxMagnitude ( ) ; double v2 = y . getMaxMagnitude ( ) ; return new Estimate_v3 ( - v1 * v2 , v1 * v2 , - v1 * v2 , v1 * v2 , - v1 * v2 , v1 * v2 ) ;
      }

   }

   class dot_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d a = (LVect2d)inputs[0]; 
         LVect2d b = (LVect2d)inputs[1]; 
         return new LDouble ( a . x * b . x + a . y * b . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 a = (Estimate_v2)inputs[0]; 
         Estimate_v2 b = (Estimate_v2)inputs[1]; 
         double ax = a . getXMaximum ( ) * b . getXMaximum ( ) ; double bx = a . getXMaximum ( ) * b . getXMinimum ( ) ; double cx = a . getXMinimum ( ) * b . getXMaximum ( ) ; double dx = a . getXMinimum ( ) * b . getXMinimum ( ) ; double ay = a . getYMaximum ( ) * b . getYMaximum ( ) ; double by = a . getYMaximum ( ) * b . getYMinimum ( ) ; double cy = a . getYMinimum ( ) * b . getYMaximum ( ) ; double dy = a . getYMinimum ( ) * b . getYMinimum ( ) ; return new Estimate_d ( Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) + Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) , Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) + Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) ) ;
      }

   }

   class dot_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d a = (LVect3d)inputs[0]; 
         LVect3d b = (LVect3d)inputs[1]; 
         return new LDouble ( a . x * b . x + a . y * b . y + a . z * b . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 a = (Estimate_v3)inputs[0]; 
         Estimate_v3 b = (Estimate_v3)inputs[1]; 
         double ax = a . getXMaximum ( ) * b . getXMaximum ( ) ; double bx = a . getXMaximum ( ) * b . getXMinimum ( ) ; double cx = a . getXMinimum ( ) * b . getXMaximum ( ) ; double dx = a . getXMinimum ( ) * b . getXMinimum ( ) ; double ay = a . getYMaximum ( ) * b . getYMaximum ( ) ; double by = a . getYMaximum ( ) * b . getYMinimum ( ) ; double cy = a . getYMinimum ( ) * b . getYMaximum ( ) ; double dy = a . getYMinimum ( ) * b . getYMinimum ( ) ; double az = a . getZMaximum ( ) * b . getZMaximum ( ) ; double bz = a . getZMaximum ( ) * b . getZMinimum ( ) ; double cz = a . getZMinimum ( ) * b . getZMaximum ( ) ; double dz = a . getZMinimum ( ) * b . getZMinimum ( ) ; return new Estimate_d ( Math . max ( Math . max ( ax , bx ) , Math . max ( cx , dx ) ) + Math . max ( Math . max ( ay , by ) , Math . max ( cy , dy ) ) + Math . max ( Math . max ( az , bz ) , Math . max ( cz , dz ) ) , Math . min ( Math . min ( ax , bx ) , Math . min ( cx , dx ) ) + Math . min ( Math . min ( ay , by ) , Math . min ( cy , dy ) ) + Math . min ( Math . min ( az , bz ) , Math . min ( cz , dz ) ) ) ;
      }

   }

   class Magnitude_c extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return new LDouble ( x . magnitude ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_d ( x . getMinMagnitude ( ) , x . getMaxMagnitude ( ) ) ;
      }

   }

   class Magnitude_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
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
         return new LDouble ( x . magnitude ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_d ( x . getMinMagnitude ( ) , x . getMaxMagnitude ( ) ) ;
      }

   }

   class Magnitude_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
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
         return new LDouble ( x . magnitude ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_d ( x . getMinMagnitude ( ) , x . getMaxMagnitude ( ) ) ;
      }

   }

   class Rotate_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "angle";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LDouble angle = (LDouble)inputs[1]; 
         LVect2d r = new LVect2d ( ) ; r . x = x . x * Math . cos ( angle . val ) + x . y * Math . sin ( angle . val ) ; r . y = x . y * Math . cos ( angle . val ) - x . x * Math . sin ( angle . val ) ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_d angle = (Estimate_d)inputs[1]; 
         return new Estimate_v2 ( - x . getMaxMagnitude ( ) , x . getMaxMagnitude ( ) , - x . getMaxMagnitude ( ) , x . getMaxMagnitude ( ) ) ;
      }

   }

   class Rotate_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "angle";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         LDouble angle = (LDouble)inputs[1]; 
         Complex r = new Complex ( ) ; r . x = x . x * Math . cos ( angle . val ) + x . y * Math . sin ( angle . val ) ; r . y = x . y * Math . cos ( angle . val ) - x . x * Math . sin ( angle . val ) ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         Estimate_d angle = (Estimate_d)inputs[1]; 
         return new Estimate_c ( - x . getMaxMagnitude ( ) , x . getMaxMagnitude ( ) , - x . getMaxMagnitude ( ) , x . getMaxMagnitude ( ) ) ;
      }

   }

   class Squash2 extends NodeFunction {
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
         return new LDouble ( x . val / ( Math . abs ( y . val ) + Math . abs ( x . val ) ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         if ( y . getMinimum ( ) > 0 ) { double min1 = x . getMinimum ( ) / ( y . getMinimum ( ) + x . getMinimum ( ) ) ; double max1 = x . getMaximum ( ) / ( y . getMinimum ( ) + x . getMaximum ( ) ) ; return new Estimate_d ( min1 , max1 ) ; } else if ( y . getMaximum ( ) < 0 ) { double min1 = x . getMinimum ( ) / ( y . getMaximum ( ) + x . getMinimum ( ) ) ; double max1 = x . getMaximum ( ) / ( y . getMaximum ( ) + x . getMaximum ( ) ) ; return new Estimate_d ( min1 , max1 ) ; } else { double yv = Math . max ( y . getMaximum ( ) , - y . getMinimum ( ) ) ; double min1 = x . getMinimum ( ) / ( yv + x . getMinimum ( ) ) ; double max1 = x . getMaximum ( ) / ( yv + x . getMaximum ( ) ) ; return new Estimate_d ( min1 , max1 ) ; }
      }

   }

   class Theta_c extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return new LDouble ( Math . atan2 ( x . y , x . x ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         if ( x . isConstant ( ) ) { double xv = x . getXMaximum ( ) ; double yv = x . getYMaximum ( ) ; double theta = Math . atan2 ( yv , xv ) ; return new Estimate_d ( theta , theta ) ; } return new Estimate_d ( - Math . PI , Math . PI ) ;
      }

   }

   class Theta_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
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
         return new LDouble ( Math . atan2 ( x . y , x . x ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         if ( x . isConstant ( ) ) { double xv = x . getXMaximum ( ) ; double yv = x . getYMaximum ( ) ; double theta = Math . atan2 ( yv , xv ) ; return new Estimate_d ( theta , theta ) ; } return new Estimate_d ( - Math . PI , Math . PI ) ;
      }

   }

   class Transform_v2 extends NodeFunction {
      private double a;
      private double b;
      private double c;
      private double d;
      public Transform_v2() {
         Random rand = new Random ( ) ; a = 2 * rand . nextDouble ( ) - 1 ; b = 2 * rand . nextDouble ( ) - 1 ; c = 2 * rand . nextDouble ( ) - 1 ; d = 2 * rand . nextDouble ( ) - 1 ;
      }

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
         return new LVect2d ( a * x . x + b * x . y , c * x . x + d * x . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         double xmin = Math . min ( a * x . getXMinimum ( ) , a * x . getXMaximum ( ) ) + Math . min ( b * x . getYMinimum ( ) , b * x . getYMaximum ( ) ) ; double xmax = Math . max ( a * x . getXMinimum ( ) , a * x . getXMaximum ( ) ) + Math . max ( b * x . getYMinimum ( ) , b * x . getYMaximum ( ) ) ; double ymin = Math . min ( c * x . getXMinimum ( ) , c * x . getXMaximum ( ) ) + Math . min ( d * x . getYMinimum ( ) , d * x . getYMaximum ( ) ) ; double ymax = Math . max ( c * x . getXMinimum ( ) , c * x . getXMaximum ( ) ) + Math . max ( d * x . getYMinimum ( ) , d * x . getYMaximum ( ) ) ; return new Estimate_v2 ( xmin , xmax , ymin , ymax ) ;
      }

      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         if(i == 3) return d;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) b = (Double)param;
         if(i == 2) c = (Double)param;
         if(i == 3) d = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         if(i == 3) return "d";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return double.class;
         return null;
      }

   }

   class Transform_v3 extends NodeFunction {
      private double a;
      private double b;
      private double c;
      private double d;
      private double e;
      private double f;
      private double g;
      private double h;
      private double j;
      public Transform_v3() {
         Random rand = new Random ( ) ; a = 2 * rand . nextDouble ( ) - 1 ; b = 2 * rand . nextDouble ( ) - 1 ; c = 2 * rand . nextDouble ( ) - 1 ; d = 2 * rand . nextDouble ( ) - 1 ; e = 2 * rand . nextDouble ( ) - 1 ; f = 2 * rand . nextDouble ( ) - 1 ; g = 2 * rand . nextDouble ( ) - 1 ; h = 2 * rand . nextDouble ( ) - 1 ; j = 2 * rand . nextDouble ( ) - 1 ;
      }

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
         return new LVect3d ( a * x . x + b * x . y + c * x . z , d * x . x + e * x . y + f * x . z , g * x . x + h * x . y + j * x . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         double xmin = Math . min ( a * x . getXMinimum ( ) , a * x . getXMaximum ( ) ) + Math . min ( b * x . getYMinimum ( ) , b * x . getYMaximum ( ) ) + Math . min ( c * x . getZMinimum ( ) , c * x . getZMaximum ( ) ) ; double xmax = Math . max ( a * x . getXMinimum ( ) , a * x . getXMaximum ( ) ) + Math . max ( b * x . getYMinimum ( ) , b * x . getYMaximum ( ) ) + Math . max ( c * x . getZMinimum ( ) , c * x . getZMaximum ( ) ) ; double ymin = Math . min ( d * x . getXMinimum ( ) , d * x . getXMaximum ( ) ) + Math . min ( e * x . getYMinimum ( ) , e * x . getYMaximum ( ) ) + Math . min ( f * x . getZMinimum ( ) , f * x . getZMaximum ( ) ) ; double ymax = Math . max ( d * x . getXMinimum ( ) , d * x . getXMaximum ( ) ) + Math . max ( e * x . getYMinimum ( ) , e * x . getYMaximum ( ) ) + Math . max ( f * x . getZMinimum ( ) , f * x . getZMaximum ( ) ) ; double zmin = Math . min ( g * x . getXMinimum ( ) , g * x . getXMaximum ( ) ) + Math . min ( h * x . getYMinimum ( ) , h * x . getYMaximum ( ) ) + Math . min ( j * x . getZMinimum ( ) , j * x . getZMaximum ( ) ) ; double zmax = Math . max ( g * x . getXMinimum ( ) , g * x . getXMaximum ( ) ) + Math . max ( h * x . getYMinimum ( ) , h * x . getYMaximum ( ) ) + Math . max ( j * x . getZMinimum ( ) , j * x . getZMaximum ( ) ) ; return new Estimate_v3 ( xmin , xmax , ymin , ymax , zmin , zmax ) ;
      }

      public int getNumberParameters() {
         return 9;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         if(i == 3) return d;
         if(i == 4) return e;
         if(i == 5) return f;
         if(i == 6) return g;
         if(i == 7) return h;
         if(i == 8) return j;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) b = (Double)param;
         if(i == 2) c = (Double)param;
         if(i == 3) d = (Double)param;
         if(i == 4) e = (Double)param;
         if(i == 5) f = (Double)param;
         if(i == 6) g = (Double)param;
         if(i == 7) h = (Double)param;
         if(i == 8) j = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         if(i == 3) return "d";
         if(i == 4) return "e";
         if(i == 5) return "f";
         if(i == 6) return "g";
         if(i == 7) return "h";
         if(i == 8) return "j";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return double.class;
         if(i == 4) return double.class;
         if(i == 5) return double.class;
         if(i == 6) return double.class;
         if(i == 7) return double.class;
         if(i == 8) return double.class;
         return null;
      }

   }

   class Transform_col extends NodeFunction {
      private double a;
      private double b;
      private double c;
      private double d;
      private double e;
      private double f;
      private double g;
      private double h;
      private double j;
      public Transform_col() {
         Random rand = new Random ( ) ; a = 2 * rand . nextDouble ( ) - 1 ; b = 2 * rand . nextDouble ( ) - 1 ; c = 2 * rand . nextDouble ( ) - 1 ; d = 2 * rand . nextDouble ( ) - 1 ; e = 2 * rand . nextDouble ( ) - 1 ; f = 2 * rand . nextDouble ( ) - 1 ; g = 2 * rand . nextDouble ( ) - 1 ; h = 2 * rand . nextDouble ( ) - 1 ; j = 2 * rand . nextDouble ( ) - 1 ;
      }

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
         return new Color ( a * x . r + b * x . g + c * x . b , d * x . r + e * x . g + f * x . b , g * x . r + h * x . g + j * x . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         double xmin = Math . min ( a * x . getRMinimum ( ) , a * x . getRMaximum ( ) ) + Math . min ( b * x . getGMinimum ( ) , b * x . getGMaximum ( ) ) + Math . min ( c * x . getBMinimum ( ) , c * x . getBMaximum ( ) ) ; double xmax = Math . max ( a * x . getRMinimum ( ) , a * x . getRMaximum ( ) ) + Math . max ( b * x . getGMinimum ( ) , b * x . getGMaximum ( ) ) + Math . max ( c * x . getBMinimum ( ) , c * x . getBMaximum ( ) ) ; double ymin = Math . min ( d * x . getRMinimum ( ) , d * x . getRMaximum ( ) ) + Math . min ( e * x . getGMinimum ( ) , e * x . getGMaximum ( ) ) + Math . min ( f * x . getBMinimum ( ) , f * x . getBMaximum ( ) ) ; double ymax = Math . max ( d * x . getRMinimum ( ) , d * x . getRMaximum ( ) ) + Math . max ( e * x . getGMinimum ( ) , e * x . getGMaximum ( ) ) + Math . max ( f * x . getBMinimum ( ) , f * x . getBMaximum ( ) ) ; double zmin = Math . min ( g * x . getRMinimum ( ) , g * x . getRMaximum ( ) ) + Math . min ( h * x . getGMinimum ( ) , h * x . getGMaximum ( ) ) + Math . min ( j * x . getBMinimum ( ) , j * x . getBMaximum ( ) ) ; double zmax = Math . max ( g * x . getRMinimum ( ) , g * x . getRMaximum ( ) ) + Math . max ( h * x . getGMinimum ( ) , h * x . getGMaximum ( ) ) + Math . max ( j * x . getBMinimum ( ) , j * x . getBMaximum ( ) ) ; return new Estimate_col ( xmin , xmax , ymin , ymax , zmin , zmax ) ;
      }

      public int getNumberParameters() {
         return 9;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         if(i == 3) return d;
         if(i == 4) return e;
         if(i == 5) return f;
         if(i == 6) return g;
         if(i == 7) return h;
         if(i == 8) return j;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) b = (Double)param;
         if(i == 2) c = (Double)param;
         if(i == 3) d = (Double)param;
         if(i == 4) e = (Double)param;
         if(i == 5) f = (Double)param;
         if(i == 6) g = (Double)param;
         if(i == 7) h = (Double)param;
         if(i == 8) j = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         if(i == 3) return "d";
         if(i == 4) return "e";
         if(i == 5) return "f";
         if(i == 6) return "g";
         if(i == 7) return "h";
         if(i == 8) return "j";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return double.class;
         if(i == 4) return double.class;
         if(i == 5) return double.class;
         if(i == 6) return double.class;
         if(i == 7) return double.class;
         if(i == 8) return double.class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new cross() );
      functions.add( new dot_v2() );
      functions.add( new dot_v3() );
      functions.add( new Magnitude_c() );
      functions.add( new Magnitude_v2() );
      functions.add( new Magnitude_v3() );
      functions.add( new Rotate_v2() );
      functions.add( new Rotate_c() );
      functions.add( new Squash2() );
      functions.add( new Theta_c() );
      functions.add( new Theta_v2() );
      functions.add( new Transform_v2() );
      functions.add( new Transform_v3() );
      functions.add( new Transform_col() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == cross.class)
          return new cross();
      if(nfClass == dot_v2.class)
          return new dot_v2();
      if(nfClass == dot_v3.class)
          return new dot_v3();
      if(nfClass == Magnitude_c.class)
          return new Magnitude_c();
      if(nfClass == Magnitude_v2.class)
          return new Magnitude_v2();
      if(nfClass == Magnitude_v3.class)
          return new Magnitude_v3();
      if(nfClass == Rotate_v2.class)
          return new Rotate_v2();
      if(nfClass == Rotate_c.class)
          return new Rotate_c();
      if(nfClass == Squash2.class)
          return new Squash2();
      if(nfClass == Theta_c.class)
          return new Theta_c();
      if(nfClass == Theta_v2.class)
          return new Theta_v2();
      if(nfClass == Transform_v2.class)
          return new Transform_v2();
      if(nfClass == Transform_v3.class)
          return new Transform_v3();
      if(nfClass == Transform_col.class)
          return new Transform_col();
      return null;
   }

}
