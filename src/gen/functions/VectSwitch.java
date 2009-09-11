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

public class VectSwitch implements FunctionGroup, java.io.Serializable {
   class C_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
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
         return new LVect2d ( x . x , x . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_v2 ( x . getXMinimum ( ) , x . getXMaximum ( ) , x . getYMinimum ( ) , x . getYMaximum ( ) ) ;
      }

   }

   class C_x extends NodeFunction {
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
         return new LDouble ( x . x ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_d ( x . getXMinimum ( ) , x . getXMaximum ( ) ) ;
      }

   }

   class C_y extends NodeFunction {
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
         return new LDouble ( x . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_d ( x . getYMinimum ( ) , x . getYMaximum ( ) ) ;
      }

   }

   class V2_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
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
         return new Complex ( x . x , x . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_c ( x . getXMinimum ( ) , x . getXMaximum ( ) , x . getYMinimum ( ) , x . getYMaximum ( ) ) ;
      }

   }

   class V2_x extends NodeFunction {
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
         return new LDouble ( x . x ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_d ( x . getXMinimum ( ) , x . getXMaximum ( ) ) ;
      }

   }

   class V2_y extends NodeFunction {
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
         return new LDouble ( x . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_d ( x . getYMinimum ( ) , x . getYMaximum ( ) ) ;
      }

   }

   class V2_swap extends NodeFunction {
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
         return new LVect2d ( x . y , x . x ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2 ( x . getYMinimum ( ) , x . getYMaximum ( ) , x . getXMinimum ( ) , x . getXMaximum ( ) ) ;
      }

   }

   class V2_to_magTheta extends NodeFunction {
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
         double r = Math . sqrt ( x . x * x . x + x . y * x . y ) ; double theta = Math . atan2 ( x . y , x . x ) ; return new LVect2d ( r , theta ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         if ( x . isConstant ( ) ) { double xx = x . getXMaximum ( ) ; double xy = x . getYMaximum ( ) ; double r = Math . sqrt ( xx * xx + xy * xy ) ; double theta = Math . atan2 ( xy , xx ) ; return new Estimate_v2 ( r , r , theta , theta ) ; } return new Estimate_v2 ( x . getMinMagnitude ( ) , x . getMaxMagnitude ( ) , - Math . PI , Math . PI ) ;
      }

   }

   class MagTheta_to_v2 extends NodeFunction {
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
         return new LVect2d ( x . x * Math . cos ( x . y ) , x . x * Math . sin ( x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         if ( x . isConstant ( ) ) { double r = x . getXMaximum ( ) ; double t = x . getYMaximum ( ) ; double xx = r * Math . cos ( t ) ; double xy = r * Math . sin ( t ) ; return new Estimate_v2 ( xx , xx , xy , xy ) ; } return new Estimate_v2 ( x . getXMinimum ( ) , x . getXMaximum ( ) , x . getXMinimum ( ) , x . getXMaximum ( ) ) ;
      }

   }

   class Color_r extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
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
         return new LDouble ( x . r ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_d ( x . getRMinimum ( ) , x . getRMaximum ( ) ) ;
      }

   }

   class Color_g extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
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
         return new LDouble ( x . g ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_d ( x . getGMinimum ( ) , x . getGMaximum ( ) ) ;
      }

   }

   class Color_b extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
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
         return new LDouble ( x . b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_d ( x . getBMinimum ( ) , x . getBMaximum ( ) ) ;
      }

   }

   class Color_hue extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
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
         return new LDouble ( x . hsbvals ( ) [ 0 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_d();
      }

   }

   class Color_saturation extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
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
         return new LDouble ( x . hsbvals ( ) [ 1 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_d();
      }

   }

   class Color_brightness extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
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
         return new LDouble ( x . hsbvals ( ) [ 2 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)inputs[0]; 
         return new Estimate_d();
      }

   }

   class New_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
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
         return new Complex ( x . val , y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_c ( x . getMinimum ( ) , x . getMaximum ( ) , y . getMinimum ( ) , y . getMaximum ( ) ) ;
      }

   }

   class New_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
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
         return new LVect2d ( x . val , y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_v2 ( x . getMinimum ( ) , x . getMaximum ( ) , y . getMinimum ( ) , y . getMaximum ( ) ) ;
      }

   }

   class New_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "z";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         LDouble z = (LDouble)inputs[2]; 
         return new LVect3d ( x . val , y . val , z . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         Estimate_d z = (Estimate_d)inputs[2]; 
         return new Estimate_v3 ( x . getMinimum ( ) , x . getMaximum ( ) , y . getMinimum ( ) , y . getMaximum ( ) , z . getMinimum ( ) , z . getMaximum ( ) ) ;
      }

   }

   class New_dv2_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "yz";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble x = (LDouble)inputs[0]; 
         LVect2d yz = (LVect2d)inputs[1]; 
         return new LVect3d ( x . val , yz . x , yz . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_v2 yz = (Estimate_v2)inputs[1]; 
         return new Estimate_v3 ( x . getMinimum ( ) , x . getMaximum ( ) , yz . getXMinimum ( ) , yz . getXMaximum ( ) , yz . getYMinimum ( ) , yz . getYMaximum ( ) ) ;
      }

   }

   class New_v2d_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "xy";
         if(i == 1) return "z";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d xy = (LVect2d)inputs[0]; 
         LDouble z = (LDouble)inputs[1]; 
         return new LVect3d ( xy . x , xy . y , z . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 xy = (Estimate_v2)inputs[0]; 
         Estimate_d z = (Estimate_d)inputs[1]; 
         return new Estimate_v3 ( xy . getXMinimum ( ) , xy . getXMaximum ( ) , xy . getYMinimum ( ) , xy . getYMaximum ( ) , z . getMinimum ( ) , z . getMaximum ( ) ) ;
      }

   }

   class New_vdv_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "xz";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d xz = (LVect2d)inputs[0]; 
         LDouble y = (LDouble)inputs[1]; 
         return new LVect3d ( xz . x , y . val , xz . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 xz = (Estimate_v2)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_v3 ( xz . getXMinimum ( ) , xz . getXMaximum ( ) , y . getMinimum ( ) , y . getMaximum ( ) , xz . getYMinimum ( ) , xz . getYMaximum ( ) ) ;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new C_v2() );
      functions.add( new C_x() );
      functions.add( new C_y() );
      functions.add( new V2_c() );
      functions.add( new V2_x() );
      functions.add( new V2_y() );
      functions.add( new V2_swap() );
      functions.add( new V2_to_magTheta() );
      functions.add( new MagTheta_to_v2() );
      functions.add( new Color_r() );
      functions.add( new Color_g() );
      functions.add( new Color_b() );
      functions.add( new Color_hue() );
      functions.add( new Color_saturation() );
      functions.add( new Color_brightness() );
      functions.add( new New_c() );
      functions.add( new New_v2() );
      functions.add( new New_v3() );
      functions.add( new New_dv2_v3() );
      functions.add( new New_v2d_v3() );
      functions.add( new New_vdv_v3() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == C_v2.class)
          return new C_v2();
      if(nfClass == C_x.class)
          return new C_x();
      if(nfClass == C_y.class)
          return new C_y();
      if(nfClass == V2_c.class)
          return new V2_c();
      if(nfClass == V2_x.class)
          return new V2_x();
      if(nfClass == V2_y.class)
          return new V2_y();
      if(nfClass == V2_swap.class)
          return new V2_swap();
      if(nfClass == V2_to_magTheta.class)
          return new V2_to_magTheta();
      if(nfClass == MagTheta_to_v2.class)
          return new MagTheta_to_v2();
      if(nfClass == Color_r.class)
          return new Color_r();
      if(nfClass == Color_g.class)
          return new Color_g();
      if(nfClass == Color_b.class)
          return new Color_b();
      if(nfClass == Color_hue.class)
          return new Color_hue();
      if(nfClass == Color_saturation.class)
          return new Color_saturation();
      if(nfClass == Color_brightness.class)
          return new Color_brightness();
      if(nfClass == New_c.class)
          return new New_c();
      if(nfClass == New_v2.class)
          return new New_v2();
      if(nfClass == New_v3.class)
          return new New_v3();
      if(nfClass == New_dv2_v3.class)
          return new New_dv2_v3();
      if(nfClass == New_v2d_v3.class)
          return new New_v2d_v3();
      if(nfClass == New_vdv_v3.class)
          return new New_vdv_v3();
      return null;
   }

}
