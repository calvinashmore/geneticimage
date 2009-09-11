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

public class CFractal implements FunctionGroup, java.io.Serializable {
   class cf_z2c extends NodeFunction implements FractalFunction {
      public void apply ( Complex z , Complex c , Complex z1 ) { z1 . x = z . x * z . x - z . y * z . y + c . x ; z1 . y = 2 * z . x * z . y + c . y ; } public double getBailAmmount ( ) { return 2.0 ; } public boolean isZeroStable ( ) { return true ; }
      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class cf_z2c_nh1 extends NodeFunction implements FractalFunction {
      public void apply ( Complex z , Complex c , Complex z1 ) { z1 . x = z . x * z . x - z . y * z . y + c . x + a * z . x + b * z . y ; z1 . y = 2 * z . x * z . y + c . y + e * z . x + d * z . y ; } public double getBailAmmount ( ) { return 2.0 ; } public boolean isZeroStable ( ) { return true ; }
      private double a;
      private double b;
      private double e;
      private double d;
      public cf_z2c_nh1() {
         a = 2 * Math . random ( ) - 1 ; b = 2 * Math . random ( ) - 1 ; e = 2 * Math . random ( ) - 1 ; d = 2 * Math . random ( ) - 1 ;
      }

      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return e;
         if(i == 3) return d;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) b = (Double)param;
         if(i == 2) e = (Double)param;
         if(i == 3) d = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "e";
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

   class cf_z2c_nh2 extends NodeFunction implements FractalFunction {
      private transient double a ; private transient double b ; private transient double e ; private transient double d ; public void apply ( Complex z , Complex c , Complex z1 ) { z1 . x = z . x * z . x - z . y * z . y + c . x + a * z . x + b * z . y ; z1 . y = 2 * z . x * z . y + c . y + e * z . x + d * z . y ; } public double getBailAmmount ( ) { return 2.0 ; } public boolean isZeroStable ( ) { return true ; }
      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "ia";
         if(i == 1) return "ib";
         if(i == 2) return "ie";
         if(i == 3) return "id";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble ia = (LDouble)inputs[0]; 
         LDouble ib = (LDouble)inputs[1]; 
         LDouble ie = (LDouble)inputs[2]; 
         LDouble id = (LDouble)inputs[3]; 
         a = ia . val ; b = ib . val ; e = ie . val ; d = id . val ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d ia = (Estimate_d)inputs[0]; 
         Estimate_d ib = (Estimate_d)inputs[1]; 
         Estimate_d ie = (Estimate_d)inputs[2]; 
         Estimate_d id = (Estimate_d)inputs[3]; 
         return new Estimate_param ( null ) ;
      }

   }

   class cf_z3c extends NodeFunction implements FractalFunction {
      public void apply ( Complex z , Complex c , Complex z1 ) { z1 . x = z . x * z . x * z . x - 3 * z . x * z . y * z . y + c . x ; z1 . y = - z . y * z . y * z . y + 3 * z . x * z . x * z . y + c . y ; } public double getBailAmmount ( ) { return 2.0 ; } public boolean isZeroStable ( ) { return true ; }
      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class cf_zpowc1 extends NodeFunction implements FractalFunction {
      public void apply ( Complex z , Complex c , Complex z1 ) { z1 = z . pow ( power ) . add ( c ) ; } public double getBailAmmount ( ) { return 2.0 ; } public boolean isZeroStable ( ) { return true ; }
      private Complex power;
      public cf_zpowc1() {
         power = new Complex ( ) ; power . x = 4 * Math . random ( ) - 2 ; power . y = 4 * Math . random ( ) - 2 ;
      }

      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return power;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) power = (Complex)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "power";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return Complex.class;
         return null;
      }

   }

   class cf_zpowc2 extends NodeFunction implements FractalFunction {
      private transient Complex power ; public void apply ( Complex z , Complex c , Complex z1 ) { z1 = z . pow ( power ) . add ( c ) ; } public double getBailAmmount ( ) { return 2.0 ; } public boolean isZeroStable ( ) { return true ; }
      public cf_zpowc2() {
         power = new Complex ( 2 , 0 ) ;
      }

      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "ipower";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex ipower = (Complex)inputs[0]; 
         power = ipower ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c ipower = (Estimate_c)inputs[0]; 
         return new Estimate_param ( null ) ;
      }

   }

   class cf_csinz extends NodeFunction implements FractalFunction {
      public void apply ( Complex z , Complex c , Complex z1 ) { z1 . x = Math . sin ( z . x ) * Math . cosh ( z . y ) * ( c . x ) - Math . cos ( z . x ) * Math . sinh ( z . y ) * ( c . y ) ; z1 . y = Math . sin ( z . x ) * Math . cosh ( z . y ) * ( c . y ) + Math . cos ( z . x ) * Math . sinh ( z . y ) * ( c . x ) ; } public double getBailAmmount ( ) { return 100.0 ; } public boolean isZeroStable ( ) { return true ; }
      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class cf_ccosz extends NodeFunction implements FractalFunction {
      public void apply ( Complex z , Complex c , Complex z1 ) { z1 . x = Math . cos ( z . x ) * Math . cosh ( z . y ) * ( c . x ) + Math . sin ( z . x ) * Math . sinh ( z . y ) * ( c . y ) ; z1 . y = Math . cos ( z . x ) * Math . cosh ( z . y ) * ( c . y ) - Math . sin ( z . x ) * Math . sinh ( z . y ) * ( c . x ) ; } public double getBailAmmount ( ) { return 100.0 ; } public boolean isZeroStable ( ) { return true ; }
      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class cf_invertDragon1 extends NodeFunction implements FractalFunction {
      private double f1 ( double r ) { double v = ( 1 + r * r * r ) ; return r * ( 1 + 2 * r + r * r ) * ( r * r - 1 ) / ( v * v ) ; } private double g1 ( double r ) { double v = ( 1 + r * r * r ) ; return r * ( 1 - 2 * r + r * r ) * ( r * r - 1 ) / ( v * v ) ; } public void apply ( Complex z , Complex c , Complex z1 ) { double rad = c . magnitude ( ) ; z1 . x = z . x * z . x - z . y * z . y + f1 ( rad ) + c . x ; z1 . y = 2 * z . x * z . y + g1 ( rad ) + c . y ; } public double getBailAmmount ( ) { return 100.0 ; } public boolean isZeroStable ( ) { return true ; }
      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class cf_invertDragon2 extends NodeFunction implements FractalFunction {
      private double f1 ( double r ) { double v = ( 1 + r + Math . pow ( r , 7 ) ) ; return r * ( 1 + 2 * r + r * r ) * ( r * r - 1 ) / ( v ) ; } private double g1 ( double r ) { double v = ( 1 + r + Math . pow ( r , 7 ) ) ; return r * ( 1 - 2 * r + r * r ) * ( r * r - 1 ) / ( v ) ; } public void apply ( Complex z , Complex c , Complex z1 ) { double rad = c . magnitude ( ) ; z1 . x = z . x * z . x - z . y * z . y + f1 ( rad ) + c . x ; z1 . y = 2 * z . x * z . y + g1 ( rad ) + c . y ; } public double getBailAmmount ( ) { return 100.0 ; } public boolean isZeroStable ( ) { return true ; }
      public Class getReturnClass() {
         return FractalFunction.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class bail_mod extends NodeFunction implements FractalBailout {
      public boolean test ( Complex z , double ammount ) { return z . x * z . x + z . y * z . y < ammount * ammount ; }
      public Class getReturnClass() {
         return FractalBailout.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class bail_max extends NodeFunction implements FractalBailout {
      public boolean test ( Complex z , double ammount ) { return Math . max ( Math . abs ( z . x ) , Math . abs ( z . y ) ) < ammount ; }
      public Class getReturnClass() {
         return FractalBailout.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class bail_min extends NodeFunction implements FractalBailout {
      public boolean test ( Complex z , double ammount ) { return Math . min ( Math . abs ( z . x ) , Math . abs ( z . y ) ) < ammount ; }
      public Class getReturnClass() {
         return FractalBailout.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class bail_add1 extends NodeFunction implements FractalBailout {
      public boolean test ( Complex z , double ammount ) { return Math . abs ( z . x + z . y ) < ammount ; }
      public Class getReturnClass() {
         return FractalBailout.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class bail_add2 extends NodeFunction implements FractalBailout {
      public boolean test ( Complex z , double ammount ) { return Math . abs ( z . x ) + Math . abs ( z . y ) < ammount ; }
      public Class getReturnClass() {
         return FractalBailout.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class bail_cross extends NodeFunction implements FractalBailout {
      public boolean test ( Complex z , double ammount ) { return Math . abs ( z . x * z . y ) < ammount ; }
      public Class getReturnClass() {
         return FractalBailout.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class bail_re extends NodeFunction implements FractalBailout {
      public boolean test ( Complex z , double ammount ) { return Math . abs ( z . x ) < ammount ; }
      public Class getReturnClass() {
         return FractalBailout.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class bail_im extends NodeFunction implements FractalBailout {
      public boolean test ( Complex z , double ammount ) { return Math . abs ( z . y ) < ammount ; }
      public Class getReturnClass() {
         return FractalBailout.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

   }

   class result_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CFractalResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "r";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CFractalResult r = (CFractalResult)inputs[0]; 
         return r . endPoint ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param r = (Estimate_param)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class result_i extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CFractalResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "r";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CFractalResult r = (CFractalResult)inputs[0]; 
         return new LDouble ( ( double ) r . iteration / r . maxIterations ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param r = (Estimate_param)inputs[0]; 
         return new Estimate_d ( 0 , 1 ) ;
      }

   }

   class result_v3_1 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CFractalResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "r";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CFractalResult r = (CFractalResult)inputs[0]; 
         return new LVect3d ( r . endPoint . x , r . endPoint . y , ( double ) r . iteration / r . maxIterations ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param r = (Estimate_param)inputs[0]; 
         return new Estimate_v3 ( ) ;
      }

   }

   class result_v3_2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CFractalResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "r";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CFractalResult r = (CFractalResult)inputs[0]; 
         return new LVect3d ( r . endPoint . x , ( double ) r . iteration / r . maxIterations , r . endPoint . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param r = (Estimate_param)inputs[0]; 
         return new Estimate_v3 ( ) ;
      }

   }

   class result_v3_3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CFractalResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "r";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CFractalResult r = (CFractalResult)inputs[0]; 
         return new LVect3d ( ( double ) r . iteration / r . maxIterations , r . endPoint . x , r . endPoint . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param r = (Estimate_param)inputs[0]; 
         return new Estimate_v3 ( ) ;
      }

   }

   class result_v3_4 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CFractalResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "r";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CFractalResult r = (CFractalResult)inputs[0]; 
         return new LVect3d ( r . endPoint . magnitude ( ) , r . endPoint . theta ( ) , ( double ) r . iteration / r . maxIterations ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param r = (Estimate_param)inputs[0]; 
         return new Estimate_v3 ( ) ;
      }

   }

   class result_v3_5 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CFractalResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "r";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CFractalResult r = (CFractalResult)inputs[0]; 
         return new LVect3d ( r . endPoint . magnitude ( ) , ( double ) r . iteration / r . maxIterations , r . endPoint . theta ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param r = (Estimate_param)inputs[0]; 
         return new Estimate_v3 ( ) ;
      }

   }

   class result_v3_6 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CFractalResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "r";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CFractalResult r = (CFractalResult)inputs[0]; 
         return new LVect3d ( ( double ) r . iteration / r . maxIterations , r . endPoint . magnitude ( ) , r . endPoint . theta ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param r = (Estimate_param)inputs[0]; 
         return new Estimate_v3 ( ) ;
      }

   }

   class evaluate_mandel extends NodeFunction_NodeBase {
      private static final int maxIterations = 500 ; private static final double targetZoom = .001 ; private Complex transform ( Complex z ) { return z . mult ( viewRadius ) . add ( zCenter ) ; } private boolean check ( Complex z ) { FractalFunction f = ( FractalFunction ) getNode ( 0 ) . getFunction ( ) ; FractalBailout bail = ( FractalBailout ) getNode ( 1 ) . getFunction ( ) ; Complex c = new Complex ( z ) ; Complex z0 = new Complex ( z ) ; Complex z1 = new Complex ( ) ; double bailAmmount = f . getBailAmmount ( ) ; for ( int i = 0 ; i < maxIterations ; i ++ ) { f . apply ( z0 , c , z1 ) ; if ( ! bail . test ( z1 , bailAmmount ) ) return false ; z0 . x = z1 . x ; z0 . y = z1 . y ; } return true ; } private Complex getZoomCenter ( Complex oldCenter , double range , Random rand ) { FractalFunction f1 = ( FractalFunction ) getNode ( 0 ) . getFunction ( ) ; Complex inside = null , outside = null ; for ( int i = 0 ; i < 200 ; i ++ ) { Complex test = new Complex ( ) ; test . x = oldCenter . x + range * ( 2 * rand . nextDouble ( ) - 1 ) ; test . y = oldCenter . y + range * ( 2 * rand . nextDouble ( ) - 1 ) ; if ( check ( test ) ) { inside = test ; if ( outside != null ) break ; } else { outside = test ; if ( inside != null ) break ; } } if ( inside == null || outside == null ) { if ( inside == null ) { inside = new Complex ( oldCenter ) ; while ( ! check ( inside ) ) { if ( f1 . isZeroStable ( ) ) inside . multv ( .9 ) ; else inside . multv ( 2.1 ) ; } } if ( outside == null ) { outside = new Complex ( oldCenter ) ; while ( check ( outside ) ) { if ( f1 . isZeroStable ( ) ) outside . multv ( 2.1 ) ; else outside . multv ( .9 ) ; } } } for ( int i = 0 ; i <= 100 ; i ++ ) { Complex v = new Complex ( ) ; if ( f1 . isZeroStable ( ) ) { v . x = ( 1 - i / 100.0 ) * outside . x + ( i / 100.0 ) * inside . x ; v . y = ( 1 - i / 100.0 ) * outside . y + ( i / 100.0 ) * inside . y ; } else { v . x = ( i / 100.0 ) * outside . x + ( 1 - i / 100.0 ) * inside . x ; v . y = ( i / 100.0 ) * outside . y + ( 1 - i / 100.0 ) * inside . y ; } if ( check ( v ) ) return v ; } System . out . print ( "??? " ) ; return new Complex ( ( inside . x + outside . x ) / 2 , ( inside . y + outside . y ) / 2 ) ; } private boolean built = false ;
      private Complex zCenter;
      private double viewRadius;
      public int getNumberSubnodes() {
         return 2;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return FractalFunction.class;
         if(i == 1) return FractalBailout.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         if(i == 1) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "f";
         if(i == 1) return "bail";
         return null;
      }

      public evaluate_mandel(NodeFunctionFactory nff) {
         super(nff);
      }

      public evaluate_mandel() {
         this(null);
      }

      public Class getReturnClass() {
         return CFractalResult.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "input";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex input = (Complex)inputs[0]; 
         Node f = getNode(0); 
         Node bail = getNode(1); 
         FractalFunction f1 = ( FractalFunction ) getNode ( 0 ) . getFunction ( ) ; FractalBailout bail1 = ( FractalBailout ) getNode ( 1 ) . getFunction ( ) ; Complex c = transform ( input ) ; Complex z0 = transform ( input ) ; Complex z1 = new Complex ( ) ; CFractalResult r = new CFractalResult ( ) ; r . maxIterations = maxIterations ; r . iteration = maxIterations ; double bailAmmount = f1 . getBailAmmount ( ) ; for ( int i = 0 ; i < maxIterations ; i ++ ) { f1 . apply ( z0 , c , z1 ) ; if ( ! bail1 . test ( z1 , bailAmmount ) ) { r . iteration = i ; break ; } z0 . x = z1 . x ; z0 . y = z1 . y ; } r . endPoint = z1 ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c input = (Estimate_c)inputs[0]; 
         Estimate_param f = (Estimate_param)getEstimate(0); 
         Estimate_param bail = (Estimate_param)getEstimate(1); 
         return new Estimate_param ( null ) ;
      }

      public void setup() {
         if ( built ) return ; Random rand = new Random ( ) ; double radius = 2.0 ; Complex center = new Complex ( ) ; while ( radius > targetZoom ) { center = getZoomCenter ( center , radius , rand ) ; radius *= .8 ; } viewRadius = radius ; zCenter = center ; built = true ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return zCenter;
         if(i == 1) return viewRadius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) zCenter = (Complex)param;
         if(i == 1) viewRadius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "zCenter";
         if(i == 1) return "viewRadius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return Complex.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class evaluate_julia extends NodeFunction_NodeBase {
      private static final int maxIterations = 500 ; private static final double targetZoom = .001 ; private Complex transform ( Complex z ) { return z . mult ( viewRadius ) . add ( zCenter ) ; } private boolean check_m ( Complex z ) { FractalFunction f = ( FractalFunction ) getNode ( 0 ) . getFunction ( ) ; FractalBailout bail = ( FractalBailout ) getNode ( 1 ) . getFunction ( ) ; Complex c = new Complex ( z ) ; Complex z0 = new Complex ( z ) ; Complex z1 = new Complex ( ) ; double bailAmmount = f . getBailAmmount ( ) ; for ( int i = 0 ; i < maxIterations ; i ++ ) { f . apply ( z0 , c , z1 ) ; if ( ! bail . test ( z1 , bailAmmount ) ) return false ; z0 . x = z1 . x ; z0 . y = z1 . y ; } return true ; } private boolean check_j ( Complex z ) { FractalFunction f = ( FractalFunction ) getNode ( 0 ) . getFunction ( ) ; FractalBailout bail = ( FractalBailout ) getNode ( 1 ) . getFunction ( ) ; Complex c = new Complex ( myC ) ; Complex z0 = new Complex ( z ) ; Complex z1 = new Complex ( ) ; double bailAmmount = f . getBailAmmount ( ) ; for ( int i = 0 ; i < maxIterations ; i ++ ) { f . apply ( z0 , c , z1 ) ; if ( ! bail . test ( z1 , bailAmmount ) ) return false ; z0 . x = z1 . x ; z0 . y = z1 . y ; } return true ; } private boolean check ( Complex test , boolean j ) { return j ? check_j ( test ) : check_m ( test ) ; } private Complex getZoomCenter ( Complex oldCenter , double range , Random rand , boolean j ) { FractalFunction f1 = ( FractalFunction ) getNode ( 0 ) . getFunction ( ) ; Complex inside = null , outside = null ; for ( int i = 0 ; i < 200 ; i ++ ) { Complex test = new Complex ( ) ; test . x = oldCenter . x + range * ( 2 * rand . nextDouble ( ) - 1 ) ; test . y = oldCenter . y + range * ( 2 * rand . nextDouble ( ) - 1 ) ; if ( check ( test , j ) ) { inside = test ; if ( outside != null ) break ; } else { outside = test ; if ( inside != null ) break ; } } if ( inside == null || outside == null ) { if ( inside == null ) { inside = new Complex ( oldCenter ) ; while ( ! check ( inside , j ) ) { if ( f1 . isZeroStable ( ) ) inside . multv ( .9 ) ; else inside . multv ( 2.1 ) ; } } if ( outside == null ) { outside = new Complex ( oldCenter ) ; while ( check ( outside , j ) ) { if ( f1 . isZeroStable ( ) ) outside . multv ( 2.1 ) ; else outside . multv ( .9 ) ; } } } for ( int i = 0 ; i <= 100 ; i ++ ) { Complex v = new Complex ( ) ; if ( f1 . isZeroStable ( ) ) { v . x = ( 1 - i / 100.0 ) * outside . x + ( i / 100.0 ) * inside . x ; v . y = ( 1 - i / 100.0 ) * outside . y + ( i / 100.0 ) * inside . y ; } else { v . x = ( i / 100.0 ) * outside . x + ( 1 - i / 100.0 ) * inside . x ; v . y = ( i / 100.0 ) * outside . y + ( 1 - i / 100.0 ) * inside . y ; } if ( check ( v , j ) ) return v ; } System . out . print ( "??? " ) ; return new Complex ( ( inside . x + outside . x ) / 2 , ( inside . y + outside . y ) / 2 ) ; } private boolean built = false ;
      private Complex myC;
      private Complex zCenter;
      private double viewRadius;
      public int getNumberSubnodes() {
         return 2;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return FractalFunction.class;
         if(i == 1) return FractalBailout.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         if(i == 1) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "f";
         if(i == 1) return "bail";
         return null;
      }

      public evaluate_julia(NodeFunctionFactory nff) {
         super(nff);
      }

      public evaluate_julia() {
         this(null);
      }

      public Class getReturnClass() {
         return CFractalResult.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "input";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex input = (Complex)inputs[0]; 
         Node f = getNode(0); 
         Node bail = getNode(1); 
         FractalFunction f1 = ( FractalFunction ) getNode ( 0 ) . getFunction ( ) ; FractalBailout bail1 = ( FractalBailout ) getNode ( 1 ) . getFunction ( ) ; Complex c = myC ; Complex z0 = transform ( input ) ; Complex z1 = new Complex ( ) ; CFractalResult r = new CFractalResult ( ) ; r . maxIterations = maxIterations ; r . iteration = maxIterations ; double bailAmmount = f1 . getBailAmmount ( ) ; for ( int i = 0 ; i < maxIterations ; i ++ ) { f1 . apply ( z0 , c , z1 ) ; if ( ! bail1 . test ( z1 , bailAmmount ) ) { r . iteration = i ; break ; } z0 . x = z1 . x ; z0 . y = z1 . y ; } r . endPoint = z1 ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c input = (Estimate_c)inputs[0]; 
         Estimate_param f = (Estimate_param)getEstimate(0); 
         Estimate_param bail = (Estimate_param)getEstimate(1); 
         return new Estimate_param ( null ) ;
      }

      public void setup() {
         if ( built ) return ; Random rand = new Random ( ) ; double radius = 2.0 ; Complex center = new Complex ( ) ; while ( radius > targetZoom ) { center = getZoomCenter ( center , radius , rand , false ) ; radius *= .8 ; } myC = center ; radius = 2.0 ; center = new Complex ( ) ; while ( radius > targetZoom ) { center = getZoomCenter ( center , radius , rand , true ) ; radius *= .8 ; } viewRadius = radius ; zCenter = center ; built = true ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return myC;
         if(i == 1) return zCenter;
         if(i == 2) return viewRadius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) myC = (Complex)param;
         if(i == 1) zCenter = (Complex)param;
         if(i == 2) viewRadius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "myC";
         if(i == 1) return "zCenter";
         if(i == 2) return "viewRadius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return Complex.class;
         if(i == 1) return Complex.class;
         if(i == 2) return double.class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new cf_z2c() );
      functions.add( new cf_z2c_nh1() );
      functions.add( new cf_z2c_nh2() );
      functions.add( new cf_z3c() );
      functions.add( new cf_zpowc1() );
      functions.add( new cf_zpowc2() );
      functions.add( new cf_csinz() );
      functions.add( new cf_ccosz() );
      functions.add( new cf_invertDragon1() );
      functions.add( new cf_invertDragon2() );
      functions.add( new bail_mod() );
      functions.add( new bail_max() );
      functions.add( new bail_min() );
      functions.add( new bail_add1() );
      functions.add( new bail_add2() );
      functions.add( new bail_cross() );
      functions.add( new bail_re() );
      functions.add( new bail_im() );
      functions.add( new result_c() );
      functions.add( new result_i() );
      functions.add( new result_v3_1() );
      functions.add( new result_v3_2() );
      functions.add( new result_v3_3() );
      functions.add( new result_v3_4() );
      functions.add( new result_v3_5() );
      functions.add( new result_v3_6() );
      functions.add( new evaluate_mandel() );
      functions.add( new evaluate_julia() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == cf_z2c.class)
          return new cf_z2c();
      if(nfClass == cf_z2c_nh1.class)
          return new cf_z2c_nh1();
      if(nfClass == cf_z2c_nh2.class)
          return new cf_z2c_nh2();
      if(nfClass == cf_z3c.class)
          return new cf_z3c();
      if(nfClass == cf_zpowc1.class)
          return new cf_zpowc1();
      if(nfClass == cf_zpowc2.class)
          return new cf_zpowc2();
      if(nfClass == cf_csinz.class)
          return new cf_csinz();
      if(nfClass == cf_ccosz.class)
          return new cf_ccosz();
      if(nfClass == cf_invertDragon1.class)
          return new cf_invertDragon1();
      if(nfClass == cf_invertDragon2.class)
          return new cf_invertDragon2();
      if(nfClass == bail_mod.class)
          return new bail_mod();
      if(nfClass == bail_max.class)
          return new bail_max();
      if(nfClass == bail_min.class)
          return new bail_min();
      if(nfClass == bail_add1.class)
          return new bail_add1();
      if(nfClass == bail_add2.class)
          return new bail_add2();
      if(nfClass == bail_cross.class)
          return new bail_cross();
      if(nfClass == bail_re.class)
          return new bail_re();
      if(nfClass == bail_im.class)
          return new bail_im();
      if(nfClass == result_c.class)
          return new result_c();
      if(nfClass == result_i.class)
          return new result_i();
      if(nfClass == result_v3_1.class)
          return new result_v3_1();
      if(nfClass == result_v3_2.class)
          return new result_v3_2();
      if(nfClass == result_v3_3.class)
          return new result_v3_3();
      if(nfClass == result_v3_4.class)
          return new result_v3_4();
      if(nfClass == result_v3_5.class)
          return new result_v3_5();
      if(nfClass == result_v3_6.class)
          return new result_v3_6();
      if(nfClass == evaluate_mandel.class)
          if(nff == null) return new evaluate_mandel(); else return new evaluate_mandel(nff);
      if(nfClass == evaluate_julia.class)
          if(nff == null) return new evaluate_julia(); else return new evaluate_julia(nff);
      return null;
   }

}
