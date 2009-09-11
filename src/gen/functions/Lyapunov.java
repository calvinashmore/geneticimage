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
import utils.lyapunov.*;

public class Lyapunov implements FunctionGroup, java.io.Serializable {
   class sin2b extends NodeFunction implements LyapunovFunction {
      public double apply ( double x , double k ) { return b * Math . pow ( Math . sin ( x + k ) , 2 ) ; } public double deriv ( double x , double k ) { return 2 * b * Math . sin ( x + k ) * Math . cos ( x + k ) ; }
      private double b;
      public sin2b() {
         b = Math . random ( ) * 2 + 1 ;
      }

      public Class getReturnClass() {
         return LyapunovFunction.class;
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
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) b = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class sin2b1 extends NodeFunction implements LyapunovFunction {
      private double b ; public double apply ( double x , double k ) { return b * Math . pow ( Math . sin ( x + k ) , 2 ) ; } public double deriv ( double x , double k ) { return 2 * b * Math . sin ( x + k ) * Math . cos ( x + k ) ; }
      public Class getReturnClass() {
         return LyapunovFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "b_in";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble b_in = (LDouble)inputs[0]; 
         b = b_in . val ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d b_in = (Estimate_d)inputs[0]; 
         return new Estimate_param();
      }

   }

   class cos2b extends NodeFunction implements LyapunovFunction {
      public double apply ( double x , double k ) { return b * Math . pow ( Math . cos ( x + k ) , 2 ) ; } public double deriv ( double x , double k ) { return - 2 * b * Math . cos ( x + k ) * Math . sin ( x + k ) ; }
      private double b;
      public cos2b() {
         b = Math . random ( ) * 2 + 1 ;
      }

      public Class getReturnClass() {
         return LyapunovFunction.class;
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
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) b = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class cos2b1 extends NodeFunction implements LyapunovFunction {
      private double b ; public double apply ( double x , double k ) { return b * Math . pow ( Math . cos ( x + k ) , 2 ) ; } public double deriv ( double x , double k ) { return - 2 * b * Math . cos ( x + k ) * Math . sin ( x + k ) ; }
      public Class getReturnClass() {
         return LyapunovFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "b_in";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble b_in = (LDouble)inputs[0]; 
         b = b_in . val ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d b_in = (Estimate_d)inputs[0]; 
         return new Estimate_param();
      }

   }

   class kcos2 extends NodeFunction implements LyapunovFunction {
      public double apply ( double x , double k ) { return k * Math . pow ( Math . cos ( x ) , 2 ) ; } public double deriv ( double x , double k ) { return - 2 * k * Math . cos ( x ) * Math . sin ( x ) ; }
      public Class getReturnClass() {
         return LyapunovFunction.class;
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
         return new Estimate_param();
      }

   }

   class logistic_saw extends NodeFunction implements LyapunovFunction {
      public double apply ( double x , double k ) { k = k - 4 * Math . floor ( k / 4 ) ; return k * x * ( 1 - x ) ; } public double deriv ( double x , double k ) { k = k - 4 * Math . floor ( k / 4 ) ; return k - 2 * k * x ; }
      public Class getReturnClass() {
         return LyapunovFunction.class;
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
         return new Estimate_param();
      }

   }

   class Lyapunov_2_v2 extends NodeFunction {
      private static final int prelim = 20 ; private static final int iterations = 100 ; private char seqAt ( int i ) { return sequence . charAt ( i % sequence . length ( ) ) ; }
      private String sequence;
      private double seed;
      public Lyapunov_2_v2() {
         int len = 2 + ( int ) ( Math . random ( ) * 6 ) ; char chars [ ] = new char [ len ] ; chars [ 0 ] = 'a' ; do { for ( int i = 1 ; i < len ; i ++ ) chars [ i ] = ( char ) ( 'a' + ( Math . random ( ) * 2 ) ) ; sequence = new String ( chars ) ; } while ( sequence . indexOf ( 'b' ) == - 1 ) ; seed = Math . random ( ) * Math . PI ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LyapunovFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "f";
         if(i == 1) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LyapunovFunction f = (LyapunovFunction)inputs[0]; 
         LVect2d v = (LVect2d)inputs[1]; 
         double x = v . x ; double y = v . y ; double sum = 0 ; double p = seed ; for ( int i = 0 ; i < iterations ; i ++ ) { char seq = seqAt ( i ) ; if ( i > prelim ) { if ( seq == 'a' ) sum += Math . log ( Math . abs ( f . deriv ( p , x ) ) ) ; else sum += Math . log ( Math . abs ( f . deriv ( p , y ) ) ) ; } if ( seq == 'a' ) p = f . apply ( p , x ) ; else p = f . apply ( p , y ) ; } sum /= ( iterations - prelim ) ; if ( sum < 0 ) sum /= 2 ; else sum *= 2 ; return new LDouble ( sum ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param f = (Estimate_param)inputs[0]; 
         Estimate_v2 v = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return sequence;
         if(i == 1) return seed;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) sequence = (String)param;
         if(i == 1) seed = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "sequence";
         if(i == 1) return "seed";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return String.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Lyapunov_2_dd extends NodeFunction {
      private static final int prelim = 20 ; private static final int iterations = 100 ; private char seqAt ( int i ) { return sequence . charAt ( i % sequence . length ( ) ) ; }
      private String sequence;
      private double seed;
      public Lyapunov_2_dd() {
         int len = 2 + ( int ) ( Math . random ( ) * 6 ) ; char chars [ ] = new char [ len ] ; chars [ 0 ] = 'a' ; do { for ( int i = 1 ; i < len ; i ++ ) chars [ i ] = ( char ) ( 'a' + ( Math . random ( ) * 2 ) ) ; sequence = new String ( chars ) ; } while ( sequence . indexOf ( 'b' ) == - 1 ) ; seed = Math . random ( ) * Math . PI ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LyapunovFunction.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "f";
         if(i == 1) return "x1";
         if(i == 2) return "y1";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LyapunovFunction f = (LyapunovFunction)inputs[0]; 
         LDouble x1 = (LDouble)inputs[1]; 
         LDouble y1 = (LDouble)inputs[2]; 
         double x = x1 . val ; double y = y1 . val ; double sum = 0 ; double p = seed ; for ( int i = 0 ; i < iterations ; i ++ ) { char seq = seqAt ( i ) ; if ( i > prelim ) { if ( seq == 'a' ) sum += Math . log ( Math . abs ( f . deriv ( p , x ) ) ) ; else sum += Math . log ( Math . abs ( f . deriv ( p , y ) ) ) ; } if ( seq == 'a' ) p = f . apply ( p , x ) ; else p = f . apply ( p , y ) ; } sum /= ( iterations - prelim ) ; if ( sum < 0 ) sum /= 2 ; else sum *= 2 ; return new LDouble ( sum ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param f = (Estimate_param)inputs[0]; 
         Estimate_d x1 = (Estimate_d)inputs[1]; 
         Estimate_d y1 = (Estimate_d)inputs[2]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return sequence;
         if(i == 1) return seed;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) sequence = (String)param;
         if(i == 1) seed = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "sequence";
         if(i == 1) return "seed";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return String.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Lyapunov_3_v3 extends NodeFunction {
      private static final int prelim = 20 ; private static final int iterations = 100 ; private char seqAt ( int i ) { return sequence . charAt ( i % sequence . length ( ) ) ; }
      private String sequence;
      private double seed;
      public Lyapunov_3_v3() {
         int len = 2 + ( int ) ( Math . random ( ) * 6 ) ; char chars [ ] = new char [ len ] ; chars [ 0 ] = 'a' ; do { for ( int i = 1 ; i < len ; i ++ ) chars [ i ] = ( char ) ( 'a' + ( Math . random ( ) * 3 ) ) ; sequence = new String ( chars ) ; } while ( sequence . indexOf ( 'b' ) == - 1 && sequence . indexOf ( 'c' ) == - 1 ) ; seed = Math . random ( ) * Math . PI ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LyapunovFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "f";
         if(i == 1) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LyapunovFunction f = (LyapunovFunction)inputs[0]; 
         LVect3d v = (LVect3d)inputs[1]; 
         double x = v . x ; double y = v . y ; double z = v . z ; double sum = 0 ; double p = seed ; for ( int i = 0 ; i < iterations ; i ++ ) { char seq = seqAt ( i ) ; if ( i > prelim ) { if ( seq == 'a' ) sum += Math . log ( Math . abs ( f . deriv ( p , x ) ) ) ; else if ( seq == 'b' ) sum += Math . log ( Math . abs ( f . deriv ( p , y ) ) ) ; else sum += Math . log ( Math . abs ( f . deriv ( p , z ) ) ) ; } if ( seq == 'a' ) p = f . apply ( p , x ) ; else if ( seq == 'b' ) p = f . apply ( p , y ) ; else p = f . apply ( p , z ) ; } sum /= ( iterations - prelim ) ; if ( sum < 0 ) sum /= 2 ; else sum *= 2 ; return new LDouble ( sum ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param f = (Estimate_param)inputs[0]; 
         Estimate_v3 v = (Estimate_v3)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return sequence;
         if(i == 1) return seed;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) sequence = (String)param;
         if(i == 1) seed = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "sequence";
         if(i == 1) return "seed";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return String.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new sin2b() );
      functions.add( new sin2b1() );
      functions.add( new cos2b() );
      functions.add( new cos2b1() );
      functions.add( new kcos2() );
      functions.add( new logistic_saw() );
      functions.add( new Lyapunov_2_v2() );
      functions.add( new Lyapunov_2_dd() );
      functions.add( new Lyapunov_3_v3() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == sin2b.class)
          return new sin2b();
      if(nfClass == sin2b1.class)
          return new sin2b1();
      if(nfClass == cos2b.class)
          return new cos2b();
      if(nfClass == cos2b1.class)
          return new cos2b1();
      if(nfClass == kcos2.class)
          return new kcos2();
      if(nfClass == logistic_saw.class)
          return new logistic_saw();
      if(nfClass == Lyapunov_2_v2.class)
          return new Lyapunov_2_v2();
      if(nfClass == Lyapunov_2_dd.class)
          return new Lyapunov_2_dd();
      if(nfClass == Lyapunov_3_v3.class)
          return new Lyapunov_3_v3();
      return null;
   }

}
