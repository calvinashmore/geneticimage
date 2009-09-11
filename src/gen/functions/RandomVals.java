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

public class RandomVals implements FunctionGroup, java.io.Serializable {
   class random_d_d_const extends NodeFunction {
      private double[] a;
      public random_d_d_const() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; for ( int i = 0 ; i < a . length ; i ++ ) a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
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
         double v = x . val - Math . floor ( x . val ) ; int i = ( int ) ( v * a . length ) ; return new LDouble ( a [ i ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         return null;
      }

   }

   class random_d_d_linear extends NodeFunction {
      private double[] a;
      public random_d_d_linear() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; for ( int i = 0 ; i < a . length ; i ++ ) a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
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
         double v = x . val - Math . floor ( x . val ) ; double alpha = v * a . length - Math . floor ( v * a . length ) ; int i = ( int ) ( v * a . length ) ; int j = ( i + 1 ) % a . length ; return new LDouble ( a [ i ] * ( 1 - alpha ) + a [ j ] * ( alpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         return null;
      }

   }

   class random_d_d_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[] a;
      public random_d_d_spline() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; for ( int i = 0 ; i < a . length ; i ++ ) a [ i ] = rand . nextDouble ( ) * 2 - 1 ;
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
         double v = x . val - Math . floor ( x . val ) ; double alpha = v * a . length - Math . floor ( v * a . length ) ; int i = ( int ) ( v * a . length ) ; double r = 0 ; r += a [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ; r += a [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ; r += a [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ; r += a [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ; return new LDouble ( r ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         return null;
      }

   }

   class random_d_v2_const extends NodeFunction {
      private double[] a;
      private double[] b;
      public random_d_v2_const() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; b = new double [ a . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) { a [ i ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect2d.class;
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
         double v = x . val - Math . floor ( x . val ) ; int i = ( int ) ( v * a . length ) ; return new LVect2d ( a [ i ] , b [ i ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
         if(i == 1) b = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         return null;
      }

   }

   class random_d_v2_linear extends NodeFunction {
      private double[] a;
      private double[] b;
      public random_d_v2_linear() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; b = new double [ a . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) { a [ i ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect2d.class;
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
         double v = x . val - Math . floor ( x . val ) ; double alpha = v * a . length - Math . floor ( v * a . length ) ; int i = ( int ) ( v * a . length ) ; int j = ( i + 1 ) % a . length ; return new LVect2d ( a [ i ] * ( 1 - alpha ) + a [ j ] * ( alpha ) , b [ i ] * ( 1 - alpha ) + b [ j ] * ( alpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
         if(i == 1) b = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         return null;
      }

   }

   class random_d_v2_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[] a;
      private double[] b;
      public random_d_v2_spline() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; b = new double [ a . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) { a [ i ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect2d.class;
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
         double v = x . val - Math . floor ( x . val ) ; double alpha = v * a . length - Math . floor ( v * a . length ) ; int i = ( int ) ( v * a . length ) ; double rx = 0 , ry = 0 ; rx += a [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ; rx += a [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ; rx += a [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ; rx += a [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ; ry += b [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ; ry += b [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ; ry += b [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ; ry += b [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ; return new LVect2d ( rx , ry ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
         if(i == 1) b = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         return null;
      }

   }

   class random_d_v3_const extends NodeFunction {
      private double[] a;
      private double[] b;
      private double[] c;
      public random_d_v3_const() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; b = new double [ a . length ] ; c = new double [ a . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) { a [ i ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] = rand . nextDouble ( ) * 2 - 1 ; c [ i ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect3d.class;
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
         double v = x . val - Math . floor ( x . val ) ; int i = ( int ) ( v * a . length ) ; return new LVect3d ( a [ i ] , b [ i ] , c [ i ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
         if(i == 1) b = (double[])param;
         if(i == 2) c = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         return null;
      }

   }

   class random_d_v3_linear extends NodeFunction {
      private double[] a;
      private double[] b;
      private double[] c;
      public random_d_v3_linear() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; b = new double [ a . length ] ; c = new double [ a . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) { a [ i ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] = rand . nextDouble ( ) * 2 - 1 ; c [ i ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect3d.class;
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
         double v = x . val - Math . floor ( x . val ) ; double alpha = v * a . length - Math . floor ( v * a . length ) ; int i = ( int ) ( v * a . length ) ; int j = ( i + 1 ) % a . length ; return new LVect3d ( a [ i ] * ( 1 - alpha ) + a [ j ] * ( alpha ) , b [ i ] * ( 1 - alpha ) + b [ j ] * ( alpha ) , c [ i ] * ( 1 - alpha ) + c [ j ] * ( alpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
         if(i == 1) b = (double[])param;
         if(i == 2) c = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         return null;
      }

   }

   class random_d_v3_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[] a;
      private double[] b;
      private double[] c;
      public random_d_v3_spline() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; b = new double [ a . length ] ; c = new double [ a . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) { a [ i ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] = rand . nextDouble ( ) * 2 - 1 ; c [ i ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect3d.class;
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
         double v = x . val - Math . floor ( x . val ) ; double alpha = v * a . length - Math . floor ( v * a . length ) ; int i = ( int ) ( v * a . length ) ; double rx = 0 , ry = 0 , rz = 0 ; rx += a [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ; rx += a [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ; rx += a [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ; rx += a [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ; ry += b [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ; ry += b [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ; ry += b [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ; ry += b [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ; rz += c [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ; rz += c [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ; rz += c [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ; rz += c [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ; return new LVect3d ( rx , ry , rz ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
         if(i == 1) b = (double[])param;
         if(i == 2) c = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         return null;
      }

   }

   class random_d_col_const extends NodeFunction {
      private double[] a;
      private double[] b;
      private double[] c;
      public random_d_col_const() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; b = new double [ a . length ] ; c = new double [ a . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) { a [ i ] = rand . nextDouble ( ) * 1 ; b [ i ] = rand . nextDouble ( ) * 1 ; c [ i ] = rand . nextDouble ( ) * 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
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
         double v = x . val - Math . floor ( x . val ) ; int i = ( int ) ( v * a . length ) ; return new Color ( a [ i ] , b [ i ] , c [ i ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
         if(i == 1) b = (double[])param;
         if(i == 2) c = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         return null;
      }

   }

   class random_d_col_linear extends NodeFunction {
      private double[] a;
      private double[] b;
      private double[] c;
      public random_d_col_linear() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; b = new double [ a . length ] ; c = new double [ a . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) { a [ i ] = rand . nextDouble ( ) * 1 ; b [ i ] = rand . nextDouble ( ) * 1 ; c [ i ] = rand . nextDouble ( ) * 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
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
         double v = x . val - Math . floor ( x . val ) ; double alpha = v * a . length - Math . floor ( v * a . length ) ; int i = ( int ) ( v * a . length ) ; int j = ( i + 1 ) % a . length ; return new Color ( a [ i ] * ( 1 - alpha ) + a [ j ] * ( alpha ) , b [ i ] * ( 1 - alpha ) + b [ j ] * ( alpha ) , c [ i ] * ( 1 - alpha ) + c [ j ] * ( alpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
         if(i == 1) b = (double[])param;
         if(i == 2) c = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         return null;
      }

   }

   class random_d_col_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[] a;
      private double[] b;
      private double[] c;
      public random_d_col_spline() {
         Random rand = new Random ( ) ; a = new double [ 5 + rand . nextInt ( 5 ) ] ; b = new double [ a . length ] ; c = new double [ a . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) { a [ i ] = rand . nextDouble ( ) * 1 ; b [ i ] = rand . nextDouble ( ) * 1 ; c [ i ] = rand . nextDouble ( ) * 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
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
         double v = x . val - Math . floor ( x . val ) ; double alpha = v * a . length - Math . floor ( v * a . length ) ; int i = ( int ) ( v * a . length ) ; double rx = 0 , ry = 0 , rz = 0 ; rx += a [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ; rx += a [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ; rx += a [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ; rx += a [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ; ry += b [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ; ry += b [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ; ry += b [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ; ry += b [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ; rz += c [ getWrap ( i - 1 ) ] * splineEval ( alpha , - 1 ) ; rz += c [ getWrap ( i + 0 ) ] * splineEval ( alpha , 0 ) ; rz += c [ getWrap ( i + 1 ) ] * splineEval ( alpha , 1 ) ; rz += c [ getWrap ( i + 2 ) ] * splineEval ( alpha , 2 ) ; return new Color ( rx , ry , rz ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[])param;
         if(i == 1) b = (double[])param;
         if(i == 2) c = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         return null;
      }

   }

   class random_v2_d_const extends NodeFunction {
      private double[][] a;
      public random_v2_d_const() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ i ] . length ; j ++ ) a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
      }

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
         double u = x . x - Math . floor ( x . x ) ; double v = x . y - Math . floor ( x . y ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; return new LDouble ( a [ ui ] [ vi ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         return null;
      }

   }

   class random_v2_d_linear extends NodeFunction {
      private double[][] a;
      public random_v2_d_linear() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ i ] . length ; j ++ ) a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
      }

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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int uj = ( ui + 1 ) % a . length ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int vj = ( vi + 1 ) % a [ 0 ] . length ; return new LDouble ( a [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + a [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + a [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + a [ uj ] [ vj ] * ( ualpha ) * ( valpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         return null;
      }

   }

   class random_v2_d_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[][] a;
      public random_v2_d_spline() {
         Random rand = new Random ( ) ; int size = 3 + rand . nextInt ( 3 ) ; a = new double [ size ] [ size ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ i ] . length ; j ++ ) a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ;
      }

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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; double r = 0 ; for ( int i = - 1 ; i <= 2 ; i ++ ) for ( int j = - 1 ; j <= 2 ; j ++ ) r += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * splineEval ( ualpha , i ) * splineEval ( valpha , j ) ; return new LDouble ( r ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         return null;
      }

   }

   class random_v2_v2_const extends NodeFunction {
      private double[][] a;
      private double[][] b;
      public random_v2_v2_const() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) { a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; }
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
         double u = x . x - Math . floor ( x . x ) ; double v = x . y - Math . floor ( x . y ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; return new LVect2d ( a [ ui ] [ vi ] , b [ ui ] [ vi ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
         if(i == 1) b = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         if(i == 1) return double[][].class;
         return null;
      }

   }

   class random_v2_v2_linear extends NodeFunction {
      private double[][] a;
      private double[][] b;
      public random_v2_v2_linear() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) { a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; }
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int uj = ( ui + 1 ) % a . length ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int vj = ( vi + 1 ) % a [ 0 ] . length ; return new LVect2d ( a [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + a [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + a [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + a [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , b [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + b [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + b [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + b [ uj ] [ vj ] * ( ualpha ) * ( valpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
         if(i == 1) b = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         if(i == 1) return double[][].class;
         return null;
      }

   }

   class random_v2_v2_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[][] a;
      private double[][] b;
      public random_v2_v2_spline() {
         Random rand = new Random ( ) ; int size = 3 + rand . nextInt ( 3 ) ; a = new double [ size ] [ size ] ; b = new double [ a . length ] [ a [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) { a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; }
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; double rx = 0 ; double ry = 0 ; for ( int i = - 1 ; i <= 2 ; i ++ ) for ( int j = - 1 ; j <= 2 ; j ++ ) { double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) ; rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ; ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ; } return new LVect2d ( rx , ry ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
         if(i == 1) b = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         if(i == 1) return double[][].class;
         return null;
      }

   }

   class random_v2_v3_const extends NodeFunction {
      private double[][] a;
      private double[][] b;
      private double[][] c;
      public random_v2_v3_const() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) { a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; c [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect3d.class;
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
         double u = x . x - Math . floor ( x . x ) ; double v = x . y - Math . floor ( x . y ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; return new LVect3d ( a [ ui ] [ vi ] , b [ ui ] [ vi ] , c [ ui ] [ vi ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
         if(i == 1) b = (double[][])param;
         if(i == 2) c = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         if(i == 1) return double[][].class;
         if(i == 2) return double[][].class;
         return null;
      }

   }

   class random_v2_v3_linear extends NodeFunction {
      private double[][] a;
      private double[][] b;
      private double[][] c;
      public random_v2_v3_linear() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) { a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; c [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect3d.class;
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int uj = ( ui + 1 ) % a . length ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int vj = ( vi + 1 ) % a [ 0 ] . length ; return new LVect3d ( a [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + a [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + a [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + a [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , b [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + b [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + b [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + b [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , c [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + c [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + c [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + c [ uj ] [ vj ] * ( ualpha ) * ( valpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
         if(i == 1) b = (double[][])param;
         if(i == 2) c = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         if(i == 1) return double[][].class;
         if(i == 2) return double[][].class;
         return null;
      }

   }

   class random_v2_v3_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[][] a;
      private double[][] b;
      private double[][] c;
      public random_v2_v3_spline() {
         Random rand = new Random ( ) ; int size = 3 + rand . nextInt ( 3 ) ; a = new double [ size ] [ size ] ; b = new double [ a . length ] [ a [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) { a [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; c [ i ] [ j ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect3d.class;
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; double rx = 0 ; double ry = 0 ; double rz = 0 ; for ( int i = - 1 ; i <= 2 ; i ++ ) for ( int j = - 1 ; j <= 2 ; j ++ ) { double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) ; rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ; ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ; rz += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ; } return new LVect3d ( rx , ry , rz ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
         if(i == 1) b = (double[][])param;
         if(i == 2) c = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         if(i == 1) return double[][].class;
         if(i == 2) return double[][].class;
         return null;
      }

   }

   class random_v2_col_const extends NodeFunction {
      private double[][] a;
      private double[][] b;
      private double[][] c;
      public random_v2_col_const() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) { a [ i ] [ j ] = rand . nextDouble ( ) * 1 ; b [ i ] [ j ] = rand . nextDouble ( ) * 1 ; c [ i ] [ j ] = rand . nextDouble ( ) * 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
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
         double u = x . x - Math . floor ( x . x ) ; double v = x . y - Math . floor ( x . y ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; return new Color ( a [ ui ] [ vi ] , b [ ui ] [ vi ] , c [ ui ] [ vi ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
         if(i == 1) b = (double[][])param;
         if(i == 2) c = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         if(i == 1) return double[][].class;
         if(i == 2) return double[][].class;
         return null;
      }

   }

   class random_v2_col_linear extends NodeFunction {
      private double[][] a;
      private double[][] b;
      private double[][] c;
      public random_v2_col_linear() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) { a [ i ] [ j ] = rand . nextDouble ( ) * 1 ; b [ i ] [ j ] = rand . nextDouble ( ) * 1 ; c [ i ] [ j ] = rand . nextDouble ( ) * 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int uj = ( ui + 1 ) % a . length ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int vj = ( vi + 1 ) % a [ 0 ] . length ; return new Color ( a [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + a [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + a [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + a [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , b [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + b [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + b [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + b [ uj ] [ vj ] * ( ualpha ) * ( valpha ) , c [ ui ] [ vi ] * ( 1 - ualpha ) * ( 1 - valpha ) + c [ ui ] [ vj ] * ( 1 - ualpha ) * ( valpha ) + c [ uj ] [ vi ] * ( ualpha ) * ( 1 - valpha ) + c [ uj ] [ vj ] * ( ualpha ) * ( valpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
         if(i == 1) b = (double[][])param;
         if(i == 2) c = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         if(i == 1) return double[][].class;
         if(i == 2) return double[][].class;
         return null;
      }

   }

   class random_v2_col_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[][] a;
      private double[][] b;
      private double[][] c;
      public random_v2_col_spline() {
         Random rand = new Random ( ) ; int size = 3 + rand . nextInt ( 3 ) ; a = new double [ size ] [ size ] ; b = new double [ a . length ] [ a [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) { a [ i ] [ j ] = rand . nextDouble ( ) * 1 ; b [ i ] [ j ] = rand . nextDouble ( ) * 1 ; c [ i ] [ j ] = rand . nextDouble ( ) * 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; double rx = 0 ; double ry = 0 ; double rz = 0 ; for ( int i = - 1 ; i <= 2 ; i ++ ) for ( int j = - 1 ; j <= 2 ; j ++ ) { double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) ; rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ; ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ; rz += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] * coeff ; } return new Color ( rx , ry , rz ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][])param;
         if(i == 1) b = (double[][])param;
         if(i == 2) c = (double[][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][].class;
         if(i == 1) return double[][].class;
         if(i == 2) return double[][].class;
         return null;
      }

   }

   class random_v3_d_const extends NodeFunction {
      private double[][][] a;
      public random_v3_d_const() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
      }

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
         double u = x . x - Math . floor ( x . x ) ; double v = x . y - Math . floor ( x . y ) ; double w = x . z - Math . floor ( x . z ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; return new LDouble ( a [ ui ] [ vi ] [ wi ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         return null;
      }

   }

   class random_v3_d_linear extends NodeFunction {
      private double[][][] a;
      public random_v3_d_linear() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
      }

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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; double w = x . z - Math . floor ( x . z ) ; double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int uj = ( ui + 1 ) % a . length ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int vj = ( vi + 1 ) % a [ 0 ] . length ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; int wj = ( wi + 1 ) % a [ 0 ] [ 0 ] . length ; return new LDouble ( a [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + a [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         return null;
      }

   }

   class random_v3_d_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[][][] a;
      public random_v3_d_spline() {
         Random rand = new Random ( ) ; int size = 3 + rand . nextInt ( 3 ) ; a = new double [ size ] [ size ] [ size ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ;
      }

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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; double w = x . z - Math . floor ( x . z ) ; double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; double r = 0 ; for ( int i = - 1 ; i <= 2 ; i ++ ) for ( int j = - 1 ; j <= 2 ; j ++ ) for ( int k = - 1 ; k <= 2 ; k ++ ) r += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * splineEval ( ualpha , i ) * splineEval ( valpha , j ) * splineEval ( walpha , k ) ; return new LDouble ( r ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         return null;
      }

   }

   class random_v3_v2_const extends NodeFunction {
      private double[][][] a;
      private double[][][] b;
      public random_v3_v2_const() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) { a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect2d.class;
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
         double u = x . x - Math . floor ( x . x ) ; double v = x . y - Math . floor ( x . y ) ; double w = x . z - Math . floor ( x . z ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; return new LVect2d ( a [ ui ] [ vi ] [ wi ] , b [ ui ] [ vi ] [ wi ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
         if(i == 1) b = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         if(i == 1) return double[][][].class;
         return null;
      }

   }

   class random_v3_v2_linear extends NodeFunction {
      private double[][][] a;
      private double[][][] b;
      public random_v3_v2_linear() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) { a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect2d.class;
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; double w = x . z - Math . floor ( x . z ) ; double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int uj = ( ui + 1 ) % a . length ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int vj = ( vi + 1 ) % a [ 0 ] . length ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; int wj = ( wi + 1 ) % a [ 0 ] [ 0 ] . length ; return new LVect2d ( a [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + a [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , b [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + b [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
         if(i == 1) b = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         if(i == 1) return double[][][].class;
         return null;
      }

   }

   class random_v3_v2_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[][][] a;
      private double[][][] b;
      public random_v3_v2_spline() {
         Random rand = new Random ( ) ; int size = 3 + rand . nextInt ( 3 ) ; a = new double [ size ] [ size ] [ size ] ; b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) { a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect2d.class;
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; double w = x . z - Math . floor ( x . z ) ; double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; double rx = 0 ; double ry = 0 ; for ( int i = - 1 ; i <= 2 ; i ++ ) for ( int j = - 1 ; j <= 2 ; j ++ ) for ( int k = - 1 ; k <= 2 ; k ++ ) { double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) * splineEval ( walpha , k ) ; rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ; ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ; } return new LVect2d ( rx , ry ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
         if(i == 1) b = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         if(i == 1) return double[][][].class;
         return null;
      }

   }

   class random_v3_v3_const extends NodeFunction {
      private double[][][] a;
      private double[][][] b;
      private double[][][] c;
      public random_v3_v3_const() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) { a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; }
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
         double u = x . x - Math . floor ( x . x ) ; double v = x . y - Math . floor ( x . y ) ; double w = x . z - Math . floor ( x . z ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; return new LVect3d ( a [ ui ] [ vi ] [ wi ] , b [ ui ] [ vi ] [ wi ] , c [ ui ] [ vi ] [ wi ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
         if(i == 1) b = (double[][][])param;
         if(i == 2) c = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         if(i == 1) return double[][][].class;
         if(i == 2) return double[][][].class;
         return null;
      }

   }

   class random_v3_v3_linear extends NodeFunction {
      private double[][][] a;
      private double[][][] b;
      private double[][][] c;
      public random_v3_v3_linear() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) { a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; }
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; double w = x . z - Math . floor ( x . z ) ; double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int uj = ( ui + 1 ) % a . length ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int vj = ( vi + 1 ) % a [ 0 ] . length ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; int wj = ( wi + 1 ) % a [ 0 ] [ 0 ] . length ; return new LVect3d ( a [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + a [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , b [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + b [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , c [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + c [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + c [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + c [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + c [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + c [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + c [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + c [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
         if(i == 1) b = (double[][][])param;
         if(i == 2) c = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         if(i == 1) return double[][][].class;
         if(i == 2) return double[][][].class;
         return null;
      }

   }

   class random_v3_v3_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[][][] a;
      private double[][][] b;
      private double[][][] c;
      public random_v3_v3_spline() {
         Random rand = new Random ( ) ; int size = 3 + rand . nextInt ( 3 ) ; a = new double [ size ] [ size ] [ size ] ; b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) { a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 2 - 1 ; }
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; double w = x . z - Math . floor ( x . z ) ; double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; double rx = 0 ; double ry = 0 ; double rz = 0 ; for ( int i = - 1 ; i <= 2 ; i ++ ) for ( int j = - 1 ; j <= 2 ; j ++ ) for ( int k = - 1 ; k <= 2 ; k ++ ) { double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) * splineEval ( walpha , k ) ; rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ; ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ; rz += c [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ; } return new LVect3d ( rx , ry , rz ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
         if(i == 1) b = (double[][][])param;
         if(i == 2) c = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         if(i == 1) return double[][][].class;
         if(i == 2) return double[][][].class;
         return null;
      }

   }

   class random_v3_col_const extends NodeFunction {
      private double[][][] a;
      private double[][][] b;
      private double[][][] c;
      public random_v3_col_const() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) { a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ; b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ; c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
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
         double u = x . x - Math . floor ( x . x ) ; double v = x . y - Math . floor ( x . y ) ; double w = x . z - Math . floor ( x . z ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; return new Color ( a [ ui ] [ vi ] [ wi ] , b [ ui ] [ vi ] [ wi ] , c [ ui ] [ vi ] [ wi ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
         if(i == 1) b = (double[][][])param;
         if(i == 2) c = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         if(i == 1) return double[][][].class;
         if(i == 2) return double[][][].class;
         return null;
      }

   }

   class random_v3_col_linear extends NodeFunction {
      private double[][][] a;
      private double[][][] b;
      private double[][][] c;
      public random_v3_col_linear() {
         Random rand = new Random ( ) ; a = new double [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] [ 3 + rand . nextInt ( 3 ) ] ; b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) { a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ; b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ; c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; double w = x . z - Math . floor ( x . z ) ; double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int uj = ( ui + 1 ) % a . length ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int vj = ( vi + 1 ) % a [ 0 ] . length ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; int wj = ( wi + 1 ) % a [ 0 ] [ 0 ] . length ; return new Color ( a [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + a [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + a [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + a [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + a [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , b [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + b [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + b [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + b [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + b [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) , c [ ui ] [ vi ] [ wi ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + c [ ui ] [ vj ] [ wi ] * ( 1 - ualpha ) * ( valpha ) * ( 1 - walpha ) + c [ uj ] [ vi ] [ wi ] * ( ualpha ) * ( 1 - valpha ) * ( 1 - walpha ) + c [ uj ] [ vj ] [ wi ] * ( ualpha ) * ( valpha ) * ( 1 - walpha ) + c [ ui ] [ vi ] [ wj ] * ( 1 - ualpha ) * ( 1 - valpha ) * ( walpha ) + c [ ui ] [ vj ] [ wj ] * ( 1 - ualpha ) * ( valpha ) * ( walpha ) + c [ uj ] [ vi ] [ wj ] * ( ualpha ) * ( 1 - valpha ) * ( walpha ) + c [ uj ] [ vj ] [ wj ] * ( ualpha ) * ( valpha ) * ( walpha ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
         if(i == 1) b = (double[][][])param;
         if(i == 2) c = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         if(i == 1) return double[][][].class;
         if(i == 2) return double[][][].class;
         return null;
      }

   }

   class random_v3_col_spline extends NodeFunction {
      private double splineEval ( double t , int lev ) { switch ( lev ) { case - 1 : return ( 1 / 6.0 ) * ( 1 - 3 * t + 3 * t * t - t * t * t ) ; case 0 : return ( 1 / 6.0 ) * ( 4 - 6 * t * t + 3 * t * t * t ) ; case 1 : return ( 1 / 6.0 ) * ( 1 + 3 * t + 3 * t * t - 3 * t * t * t ) ; case 2 : return ( 1 / 6.0 ) * ( t * t * t ) ; } return 0 ; } private int getWrap ( int x ) { return ( x + a . length ) % a . length ; }
      private double[][][] a;
      private double[][][] b;
      private double[][][] c;
      public random_v3_col_spline() {
         Random rand = new Random ( ) ; int size = 3 + rand . nextInt ( 3 ) ; a = new double [ size ] [ size ] [ size ] ; b = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; c = new double [ a . length ] [ a [ 0 ] . length ] [ a [ 0 ] [ 0 ] . length ] ; for ( int i = 0 ; i < a . length ; i ++ ) for ( int j = 0 ; j < a [ 0 ] . length ; j ++ ) for ( int k = 0 ; k < a [ 0 ] [ 0 ] . length ; k ++ ) { a [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ; b [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ; c [ i ] [ j ] [ k ] = rand . nextDouble ( ) * 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
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
         double u = x . x - Math . floor ( x . x ) ; double ualpha = u * a . length - Math . floor ( u * a . length ) ; double v = x . y - Math . floor ( x . y ) ; double valpha = v * a [ 0 ] . length - Math . floor ( v * a [ 0 ] . length ) ; double w = x . z - Math . floor ( x . z ) ; double walpha = w * a [ 0 ] [ 0 ] . length - Math . floor ( w * a [ 0 ] [ 0 ] . length ) ; int ui = ( int ) ( u * a . length ) ; int vi = ( int ) ( v * a [ 0 ] . length ) ; int wi = ( int ) ( w * a [ 0 ] [ 0 ] . length ) ; double rx = 0 ; double ry = 0 ; double rz = 0 ; for ( int i = - 1 ; i <= 2 ; i ++ ) for ( int j = - 1 ; j <= 2 ; j ++ ) for ( int k = - 1 ; k <= 2 ; k ++ ) { double coeff = splineEval ( ualpha , i ) * splineEval ( valpha , j ) * splineEval ( walpha , k ) ; rx += a [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ; ry += b [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ; rz += c [ getWrap ( ui + i ) ] [ getWrap ( vi + j ) ] [ getWrap ( wi + k ) ] * coeff ; } return new Color ( rx , ry , rz ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return c;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (double[][][])param;
         if(i == 1) b = (double[][][])param;
         if(i == 2) c = (double[][][])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "c";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[][][].class;
         if(i == 1) return double[][][].class;
         if(i == 2) return double[][][].class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new random_d_d_const() );
      functions.add( new random_d_d_linear() );
      functions.add( new random_d_d_spline() );
      functions.add( new random_d_v2_const() );
      functions.add( new random_d_v2_linear() );
      functions.add( new random_d_v2_spline() );
      functions.add( new random_d_v3_const() );
      functions.add( new random_d_v3_linear() );
      functions.add( new random_d_v3_spline() );
      functions.add( new random_d_col_const() );
      functions.add( new random_d_col_linear() );
      functions.add( new random_d_col_spline() );
      functions.add( new random_v2_d_const() );
      functions.add( new random_v2_d_linear() );
      functions.add( new random_v2_d_spline() );
      functions.add( new random_v2_v2_const() );
      functions.add( new random_v2_v2_linear() );
      functions.add( new random_v2_v2_spline() );
      functions.add( new random_v2_v3_const() );
      functions.add( new random_v2_v3_linear() );
      functions.add( new random_v2_v3_spline() );
      functions.add( new random_v2_col_const() );
      functions.add( new random_v2_col_linear() );
      functions.add( new random_v2_col_spline() );
      functions.add( new random_v3_d_const() );
      functions.add( new random_v3_d_linear() );
      functions.add( new random_v3_d_spline() );
      functions.add( new random_v3_v2_const() );
      functions.add( new random_v3_v2_linear() );
      functions.add( new random_v3_v2_spline() );
      functions.add( new random_v3_v3_const() );
      functions.add( new random_v3_v3_linear() );
      functions.add( new random_v3_v3_spline() );
      functions.add( new random_v3_col_const() );
      functions.add( new random_v3_col_linear() );
      functions.add( new random_v3_col_spline() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == random_d_d_const.class)
          return new random_d_d_const();
      if(nfClass == random_d_d_linear.class)
          return new random_d_d_linear();
      if(nfClass == random_d_d_spline.class)
          return new random_d_d_spline();
      if(nfClass == random_d_v2_const.class)
          return new random_d_v2_const();
      if(nfClass == random_d_v2_linear.class)
          return new random_d_v2_linear();
      if(nfClass == random_d_v2_spline.class)
          return new random_d_v2_spline();
      if(nfClass == random_d_v3_const.class)
          return new random_d_v3_const();
      if(nfClass == random_d_v3_linear.class)
          return new random_d_v3_linear();
      if(nfClass == random_d_v3_spline.class)
          return new random_d_v3_spline();
      if(nfClass == random_d_col_const.class)
          return new random_d_col_const();
      if(nfClass == random_d_col_linear.class)
          return new random_d_col_linear();
      if(nfClass == random_d_col_spline.class)
          return new random_d_col_spline();
      if(nfClass == random_v2_d_const.class)
          return new random_v2_d_const();
      if(nfClass == random_v2_d_linear.class)
          return new random_v2_d_linear();
      if(nfClass == random_v2_d_spline.class)
          return new random_v2_d_spline();
      if(nfClass == random_v2_v2_const.class)
          return new random_v2_v2_const();
      if(nfClass == random_v2_v2_linear.class)
          return new random_v2_v2_linear();
      if(nfClass == random_v2_v2_spline.class)
          return new random_v2_v2_spline();
      if(nfClass == random_v2_v3_const.class)
          return new random_v2_v3_const();
      if(nfClass == random_v2_v3_linear.class)
          return new random_v2_v3_linear();
      if(nfClass == random_v2_v3_spline.class)
          return new random_v2_v3_spline();
      if(nfClass == random_v2_col_const.class)
          return new random_v2_col_const();
      if(nfClass == random_v2_col_linear.class)
          return new random_v2_col_linear();
      if(nfClass == random_v2_col_spline.class)
          return new random_v2_col_spline();
      if(nfClass == random_v3_d_const.class)
          return new random_v3_d_const();
      if(nfClass == random_v3_d_linear.class)
          return new random_v3_d_linear();
      if(nfClass == random_v3_d_spline.class)
          return new random_v3_d_spline();
      if(nfClass == random_v3_v2_const.class)
          return new random_v3_v2_const();
      if(nfClass == random_v3_v2_linear.class)
          return new random_v3_v2_linear();
      if(nfClass == random_v3_v2_spline.class)
          return new random_v3_v2_spline();
      if(nfClass == random_v3_v3_const.class)
          return new random_v3_v3_const();
      if(nfClass == random_v3_v3_linear.class)
          return new random_v3_v3_linear();
      if(nfClass == random_v3_v3_spline.class)
          return new random_v3_v3_spline();
      if(nfClass == random_v3_col_const.class)
          return new random_v3_col_const();
      if(nfClass == random_v3_col_linear.class)
          return new random_v3_col_linear();
      if(nfClass == random_v3_col_spline.class)
          return new random_v3_col_spline();
      return null;
   }

}
