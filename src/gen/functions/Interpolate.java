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

public class Interpolate implements FunctionGroup, java.io.Serializable {
   class Interpolate_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         LDouble y = (LDouble)inputs[2]; 
         double mod = Math . min ( Math . max ( interp . val , 0 ) , 1 ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         Estimate_d y = (Estimate_d)inputs[2]; 
         if ( interp . getMinimum ( ) >= 1 ) return x ; else if ( interp . getMaximum ( ) <= 0 ) return y ; else return new Estimate_d ( Math . min ( x . getMinimum ( ) , y . getMinimum ( ) ) , Math . max ( x . getMaximum ( ) , y . getMaximum ( ) ) ) ;
      }

   }

   class Interpolate_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         LVect2d y = (LVect2d)inputs[2]; 
         double mod = Math . min ( Math . max ( interp . val , 0 ) , 1 ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         Estimate_v2 y = (Estimate_v2)inputs[2]; 
         if ( interp . getMinimum ( ) >= 1 ) return x ; else if ( interp . getMaximum ( ) <= 0 ) return y ; else return new Estimate_v2 ( Math . min ( x . getXMinimum ( ) , y . getXMinimum ( ) ) , Math . max ( x . getXMaximum ( ) , y . getXMaximum ( ) ) , Math . min ( x . getYMinimum ( ) , y . getYMinimum ( ) ) , Math . max ( x . getYMaximum ( ) , y . getYMaximum ( ) ) ) ;
      }

   }

   class Interpolate_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         LVect3d y = (LVect3d)inputs[2]; 
         double mod = Math . min ( Math . max ( interp . val , 0 ) , 1 ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         Estimate_v3 y = (Estimate_v3)inputs[2]; 
         if ( interp . getMinimum ( ) >= 1 ) return x ; else if ( interp . getMaximum ( ) <= 0 ) return y ; else return new Estimate_v3 ( Math . min ( x . getXMinimum ( ) , y . getXMinimum ( ) ) , Math . max ( x . getXMaximum ( ) , y . getXMaximum ( ) ) , Math . min ( x . getYMinimum ( ) , y . getYMinimum ( ) ) , Math . max ( x . getYMaximum ( ) , y . getYMaximum ( ) ) , Math . min ( x . getZMinimum ( ) , y . getZMinimum ( ) ) , Math . max ( x . getZMaximum ( ) , y . getZMaximum ( ) ) ) ;
      }

   }

   class Interpolate_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         Color x = (Color)inputs[1]; 
         Color y = (Color)inputs[2]; 
         double mod = Math . min ( Math . max ( interp . val , 0 ) , 1 ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_col x = (Estimate_col)inputs[1]; 
         Estimate_col y = (Estimate_col)inputs[2]; 
         if ( interp . getMinimum ( ) >= 1 ) return x ; else if ( interp . getMaximum ( ) <= 0 ) return y ; else return new Estimate_col ( Math . min ( x . getRMinimum ( ) , y . getRMinimum ( ) ) , Math . max ( x . getRMaximum ( ) , y . getRMaximum ( ) ) , Math . min ( x . getGMinimum ( ) , y . getGMinimum ( ) ) , Math . max ( x . getGMaximum ( ) , y . getGMaximum ( ) ) , Math . min ( x . getBMinimum ( ) , y . getBMinimum ( ) ) , Math . max ( x . getBMaximum ( ) , y . getBMaximum ( ) ) ) ;
      }

   }

   class Interpolate1_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         LDouble y = (LDouble)inputs[2]; 
         double mod = 1 / ( 1.0 + Math . exp ( - interp . val ) ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         Estimate_d y = (Estimate_d)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Interpolate1_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         LVect2d y = (LVect2d)inputs[2]; 
         double mod = 1 / ( 1.0 + Math . exp ( - interp . val ) ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         Estimate_v2 y = (Estimate_v2)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Interpolate1_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         LVect3d y = (LVect3d)inputs[2]; 
         double mod = 1 / ( 1.0 + Math . exp ( - interp . val ) ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         Estimate_v3 y = (Estimate_v3)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Interpolate1_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         Color x = (Color)inputs[1]; 
         Color y = (Color)inputs[2]; 
         double mod = 1 / ( 1.0 + Math . exp ( - interp . val ) ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_col x = (Estimate_col)inputs[1]; 
         Estimate_col y = (Estimate_col)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Interpolate2_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         LDouble y = (LDouble)inputs[2]; 
         double mod = Math . exp ( - interp . val * interp . val ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         Estimate_d y = (Estimate_d)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Interpolate2_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         LVect2d y = (LVect2d)inputs[2]; 
         double mod = Math . exp ( - interp . val * interp . val ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         Estimate_v2 y = (Estimate_v2)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Interpolate2_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         LVect3d y = (LVect3d)inputs[2]; 
         double mod = Math . exp ( - interp . val * interp . val ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         Estimate_v3 y = (Estimate_v3)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Interpolate2_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, Color.class, Color.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "interp";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble interp = (LDouble)inputs[0]; 
         Color x = (Color)inputs[1]; 
         Color y = (Color)inputs[2]; 
         double mod = Math . exp ( - interp . val * interp . val ) ; return x . mult ( mod ) . add ( y . mult ( 1 - mod ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d interp = (Estimate_d)inputs[0]; 
         Estimate_col x = (Estimate_col)inputs[1]; 
         Estimate_col y = (Estimate_col)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Threshold_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "thresh";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble thresh = (LDouble)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         LDouble y = (LDouble)inputs[2]; 
         if ( thresh . val < .5 ) return x ; else return y ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d thresh = (Estimate_d)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         Estimate_d y = (Estimate_d)inputs[2]; 
         if ( thresh . getMinimum ( ) >= .5 ) return y ; else if ( thresh . getMaximum ( ) < .5 ) return x ; else return new Estimate_d ( Math . min ( x . getMinimum ( ) , y . getMinimum ( ) ) , Math . max ( x . getMaximum ( ) , y . getMaximum ( ) ) ) ;
      }

   }

   class Threshold_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "thresh";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble thresh = (LDouble)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         LVect2d y = (LVect2d)inputs[2]; 
         if ( thresh . val < .5 ) return x ; else return y ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d thresh = (Estimate_d)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         Estimate_v2 y = (Estimate_v2)inputs[2]; 
         if ( thresh . getMinimum ( ) >= .5 ) return y ; else if ( thresh . getMaximum ( ) < .5 ) return x ; else return new Estimate_v2 ( Math . min ( x . getXMinimum ( ) , y . getXMinimum ( ) ) , Math . max ( x . getXMaximum ( ) , y . getXMaximum ( ) ) , Math . min ( x . getYMinimum ( ) , y . getYMinimum ( ) ) , Math . max ( x . getYMaximum ( ) , y . getYMaximum ( ) ) ) ;
      }

   }

   class Threshold_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "thresh";
         if(i == 1) return "x";
         if(i == 2) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble thresh = (LDouble)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         LVect3d y = (LVect3d)inputs[2]; 
         if ( thresh . val < .5 ) return x ; else return y ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d thresh = (Estimate_d)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         Estimate_v3 y = (Estimate_v3)inputs[2]; 
         if ( thresh . getMinimum ( ) >= .5 ) return y ; else if ( thresh . getMaximum ( ) < .5 ) return x ; else return new Estimate_v3 ( Math . min ( x . getXMinimum ( ) , y . getXMinimum ( ) ) , Math . max ( x . getXMaximum ( ) , y . getXMaximum ( ) ) , Math . min ( x . getYMinimum ( ) , y . getYMinimum ( ) ) , Math . max ( x . getYMaximum ( ) , y . getYMaximum ( ) ) , Math . min ( x . getZMinimum ( ) , y . getZMinimum ( ) ) , Math . max ( x . getZMaximum ( ) , y . getZMaximum ( ) ) ) ;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new Interpolate_d() );
      functions.add( new Interpolate_v2() );
      functions.add( new Interpolate_v3() );
      functions.add( new Interpolate_col() );
      functions.add( new Interpolate1_d() );
      functions.add( new Interpolate1_v2() );
      functions.add( new Interpolate1_v3() );
      functions.add( new Interpolate1_col() );
      functions.add( new Interpolate2_d() );
      functions.add( new Interpolate2_v2() );
      functions.add( new Interpolate2_v3() );
      functions.add( new Interpolate2_col() );
      functions.add( new Threshold_d() );
      functions.add( new Threshold_v2() );
      functions.add( new Threshold_v3() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Interpolate_d.class)
          return new Interpolate_d();
      if(nfClass == Interpolate_v2.class)
          return new Interpolate_v2();
      if(nfClass == Interpolate_v3.class)
          return new Interpolate_v3();
      if(nfClass == Interpolate_col.class)
          return new Interpolate_col();
      if(nfClass == Interpolate1_d.class)
          return new Interpolate1_d();
      if(nfClass == Interpolate1_v2.class)
          return new Interpolate1_v2();
      if(nfClass == Interpolate1_v3.class)
          return new Interpolate1_v3();
      if(nfClass == Interpolate1_col.class)
          return new Interpolate1_col();
      if(nfClass == Interpolate2_d.class)
          return new Interpolate2_d();
      if(nfClass == Interpolate2_v2.class)
          return new Interpolate2_v2();
      if(nfClass == Interpolate2_v3.class)
          return new Interpolate2_v3();
      if(nfClass == Interpolate2_col.class)
          return new Interpolate2_col();
      if(nfClass == Threshold_d.class)
          return new Threshold_d();
      if(nfClass == Threshold_v2.class)
          return new Threshold_v2();
      if(nfClass == Threshold_v3.class)
          return new Threshold_v3();
      return null;
   }

}
