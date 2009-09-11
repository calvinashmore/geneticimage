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

public class Binary implements FunctionGroup, java.io.Serializable {
   class And extends NodeFunction {
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
         long xl = Double . doubleToRawLongBits ( x . val ) ; long yl = Double . doubleToRawLongBits ( y . val ) ; return new LDouble ( Double . longBitsToDouble ( xl & yl ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_d ( ) ;
      }

   }

   class And_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         long xx = Double . doubleToRawLongBits ( x . x ) ; long yx = Double . doubleToRawLongBits ( y . x ) ; long xy = Double . doubleToRawLongBits ( x . y ) ; long yy = Double . doubleToRawLongBits ( y . y ) ; return new LVect2d ( Double . longBitsToDouble ( xx & yx ) , Double . longBitsToDouble ( xy & yy ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         return new Estimate_v2 ( ) ;
      }

   }

   class And_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         long xx = Double . doubleToRawLongBits ( x . x ) ; long yx = Double . doubleToRawLongBits ( y . x ) ; long xy = Double . doubleToRawLongBits ( x . y ) ; long yy = Double . doubleToRawLongBits ( y . y ) ; long xz = Double . doubleToRawLongBits ( x . y ) ; long yz = Double . doubleToRawLongBits ( y . y ) ; return new LVect3d ( Double . longBitsToDouble ( xx & yx ) , Double . longBitsToDouble ( xy & yy ) , Double . longBitsToDouble ( xz & yz ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         return new Estimate_v3 ( ) ;
      }

   }

   class Or extends NodeFunction {
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
         long xl = Double . doubleToRawLongBits ( x . val ) ; long yl = Double . doubleToRawLongBits ( y . val ) ; return new LDouble ( Double . longBitsToDouble ( xl | yl ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_d ( ) ;
      }

   }

   class Or_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         long xx = Double . doubleToRawLongBits ( x . x ) ; long yx = Double . doubleToRawLongBits ( y . x ) ; long xy = Double . doubleToRawLongBits ( x . y ) ; long yy = Double . doubleToRawLongBits ( y . y ) ; return new LVect2d ( Double . longBitsToDouble ( xx | yx ) , Double . longBitsToDouble ( xy | yy ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         return new Estimate_v2 ( ) ;
      }

   }

   class Or_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         long xx = Double . doubleToRawLongBits ( x . x ) ; long yx = Double . doubleToRawLongBits ( y . x ) ; long xy = Double . doubleToRawLongBits ( x . y ) ; long yy = Double . doubleToRawLongBits ( y . y ) ; long xz = Double . doubleToRawLongBits ( x . y ) ; long yz = Double . doubleToRawLongBits ( y . y ) ; return new LVect3d ( Double . longBitsToDouble ( xx | yx ) , Double . longBitsToDouble ( xy | yy ) , Double . longBitsToDouble ( xz | yz ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         return new Estimate_v3 ( ) ;
      }

   }

   class Xor extends NodeFunction {
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
         long xl = Double . doubleToRawLongBits ( x . val ) ; long yl = Double . doubleToRawLongBits ( y . val ) ; return new LDouble ( Double . longBitsToDouble ( xl ^ yl ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_d ( ) ;
      }

   }

   class Xor_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         long xx = Double . doubleToRawLongBits ( x . x ) ; long yx = Double . doubleToRawLongBits ( y . x ) ; long xy = Double . doubleToRawLongBits ( x . y ) ; long yy = Double . doubleToRawLongBits ( y . y ) ; return new LVect2d ( Double . longBitsToDouble ( xx ^ yx ) , Double . longBitsToDouble ( xy ^ yy ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         return new Estimate_v2 ( ) ;
      }

   }

   class Xor_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         long xx = Double . doubleToRawLongBits ( x . x ) ; long yx = Double . doubleToRawLongBits ( y . x ) ; long xy = Double . doubleToRawLongBits ( x . y ) ; long yy = Double . doubleToRawLongBits ( y . y ) ; long xz = Double . doubleToRawLongBits ( x . y ) ; long yz = Double . doubleToRawLongBits ( y . y ) ; return new LVect3d ( Double . longBitsToDouble ( xx ^ yx ) , Double . longBitsToDouble ( xy ^ yy ) , Double . longBitsToDouble ( xz ^ yz ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         return new Estimate_v3 ( ) ;
      }

   }

   class Max extends NodeFunction {
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
         return new LDouble ( Math . max ( x . val , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_d ( Math . max ( x . getMaximum ( ) , y . getMaximum ( ) ) , Math . max ( x . getMinimum ( ) , y . getMinimum ( ) ) ) ;
      }

   }

   class Min extends NodeFunction {
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
         return new LDouble ( Math . min ( x . val , y . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         return new Estimate_d ( Math . min ( x . getMaximum ( ) , y . getMaximum ( ) ) , Math . min ( x . getMinimum ( ) , y . getMinimum ( ) ) ) ;
      }

   }

   class Div extends NodeFunction {
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
         return new LDouble ( x . val / y . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         if ( x . isConstant ( ) && y . isConstant ( ) ) { double v = x . getCValue ( ) . val / y . getCValue ( ) . val ; return new Estimate_d ( v , v ) ; } else if ( y . getMinimum ( ) > 0 || y . getMaximum ( ) < 0 ) { double xmax = x . getMaximum ( ) ; double xmin = x . getMinimum ( ) ; double ymax = y . getMaximum ( ) ; double ymin = y . getMinimum ( ) ; double a = xmax / ymax ; double b = xmin / ymax ; double c = xmax / ymin ; double d = xmin / ymin ; double min = Math . min ( Math . min ( a , b ) , Math . min ( c , d ) ) ; double max = Math . max ( Math . max ( a , b ) , Math . max ( c , d ) ) ; return new Estimate_d ( min , max ) ; } else return new Estimate_d ( ) ;
      }

   }

   class Atan2 extends NodeFunction {
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
         return new LDouble ( Math . atan2 ( y . val , x . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         Estimate_d y = (Estimate_d)inputs[1]; 
         if ( x . isConstant ( ) && y . isConstant ( ) ) { double xv = x . getCValue ( ) . val ; double yv = y . getCValue ( ) . val ; double theta = Math . atan2 ( yv , xv ) ; return new Estimate_d ( theta , theta ) ; } return new Estimate_d ( - Math . PI , Math . PI ) ;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new And() );
      functions.add( new And_v2() );
      functions.add( new And_v3() );
      functions.add( new Or() );
      functions.add( new Or_v2() );
      functions.add( new Or_v3() );
      functions.add( new Xor() );
      functions.add( new Xor_v2() );
      functions.add( new Xor_v3() );
      functions.add( new Max() );
      functions.add( new Min() );
      functions.add( new Div() );
      functions.add( new Atan2() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == And.class)
          return new And();
      if(nfClass == And_v2.class)
          return new And_v2();
      if(nfClass == And_v3.class)
          return new And_v3();
      if(nfClass == Or.class)
          return new Or();
      if(nfClass == Or_v2.class)
          return new Or_v2();
      if(nfClass == Or_v3.class)
          return new Or_v3();
      if(nfClass == Xor.class)
          return new Xor();
      if(nfClass == Xor_v2.class)
          return new Xor_v2();
      if(nfClass == Xor_v3.class)
          return new Xor_v3();
      if(nfClass == Max.class)
          return new Max();
      if(nfClass == Min.class)
          return new Min();
      if(nfClass == Div.class)
          return new Div();
      if(nfClass == Atan2.class)
          return new Atan2();
      return null;
   }

}
