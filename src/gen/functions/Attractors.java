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
import utils.pointfield.attractor.*;

public class Attractors implements FunctionGroup, java.io.Serializable {
   class PeterDeJong extends NodeFunction {
      private boolean built ; private QT2d qt ; private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { out_val . x = Math . sin ( a * in_val . y ) - Math . cos ( b * in_val . x ) ; out_val . y = Math . sin ( c * in_val . x ) - Math . cos ( d * in_val . y ) ; } public double derivMagnitude ( APoint2d in_val ) { double d00 = a * Math . sin ( a * in_val . y ) ; double d01 = b * Math . cos ( b * in_val . x ) ; double d10 = c * Math . cos ( c * in_val . x ) ; double d11 = d * Math . sin ( d * in_val . y ) ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = Math . random ( ) * 8 - 4 ; b = Math . random ( ) * 8 - 4 ; c = Math . random ( ) * 8 - 4 ; d = Math . random ( ) * 8 - 4 ; } public int getIdealIterations ( ) { return super . getIdealIterations ( ) * 4 ; } }
      private double a;
      private double b;
      private double c;
      private double d;
      public Class getReturnClass() {
         return QT2d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtree ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; built = true ; } else if ( parametersChanged ( ) ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtreeRaw ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; }
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

   class Clifford extends NodeFunction {
      private boolean built ; private QT2d qt ; private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { out_val . x = Math . sin ( a * in_val . y ) + b * Math . cos ( a * in_val . x ) ; out_val . y = Math . sin ( c * in_val . x ) + d * Math . cos ( c * in_val . y ) ; } public double derivMagnitude ( APoint2d in_val ) { double d00 = - a * Math . sin ( a * in_val . y ) ; double d01 = b * a * Math . cos ( a * in_val . x ) ; double d10 = c * Math . cos ( c * in_val . x ) ; double d11 = - d * c * Math . sin ( c * in_val . y ) ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = Math . random ( ) * 8 - 4 ; b = Math . random ( ) * 8 - 4 ; c = Math . random ( ) * 8 - 4 ; d = Math . random ( ) * 8 - 4 ; } public int getIdealIterations ( ) { return super . getIdealIterations ( ) * 4 ; } }
      private double a;
      private double b;
      private double c;
      private double d;
      public Class getReturnClass() {
         return QT2d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtree ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; built = true ; } else if ( parametersChanged ( ) ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtreeRaw ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; }
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

   class Quadratic2_x1 extends NodeFunction {
      private boolean built ; private QT2d qt ; private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { double x = in_val . x ; double y = in_val . y ; out_val . x = x * x * Math . sin ( y ) * a [ 0 ] + x * y * a [ 1 ] + y * y * a [ 2 ] + x * a [ 3 ] + y * a [ 4 ] + a [ 5 ] ; out_val . y = x * x * Math . cos ( y ) * b [ 0 ] + x * y * b [ 1 ] + y * y * b [ 2 ] + x * b [ 3 ] + y * b [ 4 ] + b [ 5 ] ; } public double derivMagnitude ( APoint2d in_val ) { double x = in_val . x ; double y = in_val . y ; double d00 = 2 * x * Math . sin ( y ) * a [ 0 ] + y * a [ 1 ] + a [ 3 ] ; double d01 = 2 * y * a [ 2 ] + x * a [ 1 ] + a [ 4 ] + Math . cos ( y ) * x * x * a [ 0 ] ; double d10 = 2 * x * Math . cos ( y ) * b [ 0 ] + y * b [ 1 ] + b [ 3 ] ; double d11 = 2 * y * b [ 2 ] + x * b [ 1 ] + b [ 4 ] + Math . cos ( y ) * x * x * a [ 0 ] ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = new double [ 6 ] ; b = new double [ 6 ] ; for ( int i = 0 ; i < 6 ; i ++ ) { a [ i ] = Math . random ( ) * 3 - 1.5 ; b [ i ] = Math . random ( ) * 3 - 1.5 ; } } public int getIdealIterations ( ) { return super . getIdealIterations ( ) / 2 ; } }
      private double[] a;
      private double[] b;
      public Class getReturnClass() {
         return QT2d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtree ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; built = true ; } else if ( parametersChanged ( ) ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtreeRaw ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; }
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

   class Quadratic2 extends NodeFunction {
      private boolean built ; private QT2d qt ; private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { double x = in_val . x ; double y = in_val . y ; out_val . x = x * x * a [ 0 ] + x * y * a [ 1 ] + y * y * a [ 2 ] + x * a [ 3 ] + y * a [ 4 ] + a [ 5 ] ; out_val . y = x * x * b [ 0 ] + x * y * b [ 1 ] + y * y * b [ 2 ] + x * b [ 3 ] + y * b [ 4 ] + b [ 5 ] ; } public double derivMagnitude ( APoint2d in_val ) { double x = in_val . x ; double y = in_val . y ; double d00 = 2 * x * a [ 0 ] + y * a [ 1 ] + a [ 3 ] ; double d01 = 2 * y * a [ 2 ] + x * a [ 1 ] + a [ 4 ] ; double d10 = 2 * x * b [ 0 ] + y * b [ 1 ] + b [ 3 ] ; double d11 = 2 * y * b [ 2 ] + x * b [ 1 ] + b [ 4 ] ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = new double [ 6 ] ; b = new double [ 6 ] ; for ( int i = 0 ; i < 6 ; i ++ ) { a [ i ] = Math . random ( ) * 3 - 1.5 ; b [ i ] = Math . random ( ) * 3 - 1.5 ; } } public int getIdealIterations ( ) { return super . getIdealIterations ( ) / 2 ; } }
      private double[] a;
      private double[] b;
      public Class getReturnClass() {
         return QT2d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtree ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; built = true ; } else if ( parametersChanged ( ) ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtreeRaw ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; }
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

   class Cubic2 extends NodeFunction {
      private boolean built ; private QT2d qt ; private class Impl extends AttractorFunction2 { public void apply ( APoint2d in_val , APoint2d out_val ) { double x = in_val . x ; double y = in_val . y ; out_val . x = x * x * x * a [ 0 ] + x * x * y * a [ 1 ] + x * y * y * a [ 2 ] + y * y * y * a [ 3 ] + x * x * a [ 4 ] + x * y * a [ 5 ] + y * y * a [ 6 ] + x * a [ 7 ] + y * a [ 8 ] + a [ 9 ] ; out_val . y = x * x * x * b [ 0 ] + x * x * y * b [ 1 ] + x * y * y * b [ 2 ] + y * y * y * b [ 3 ] + x * x * b [ 4 ] + x * y * b [ 5 ] + y * y * b [ 6 ] + x * a [ 7 ] + y * b [ 8 ] + b [ 9 ] ; } public double derivMagnitude ( APoint2d in_val ) { double x = in_val . x ; double y = in_val . y ; double d00 = 3 * x * x * a [ 0 ] + 2 * x * y * a [ 1 ] + y * y * a [ 2 ] + 2 * x * a [ 4 ] + y * a [ 5 ] + a [ 7 ] ; double d01 = x * x * a [ 1 ] + 2 * x * y * a [ 2 ] + 3 * y * y * a [ 3 ] + x * a [ 5 ] + 2 * y * a [ 6 ] + a [ 8 ] ; double d10 = 3 * x * x * b [ 0 ] + 2 * x * y * b [ 1 ] + y * y * b [ 2 ] + 2 * x * b [ 4 ] + y * b [ 5 ] + b [ 7 ] ; double d11 = x * x * b [ 1 ] + 2 * x * y * b [ 2 ] + 3 * y * y * b [ 3 ] + x * b [ 5 ] + 2 * y * b [ 6 ] + b [ 8 ] ; return Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) , Math . abs ( d10 ) + Math . abs ( d11 ) ) ; } public void adjustParameters ( ) { a = new double [ 10 ] ; b = new double [ 10 ] ; for ( int i = 0 ; i < 10 ; i ++ ) { a [ i ] = Math . random ( ) * 3 - 1.5 ; b [ i ] = Math . random ( ) * 3 - 1.5 ; } } public int getIdealIterations ( ) { return super . getIdealIterations ( ) / 2 ; } }
      private double[] a;
      private double[] b;
      public Class getReturnClass() {
         return QT2d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtree ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; built = true ; } else if ( parametersChanged ( ) ) { qt = ( QT2d ) new Attractor ( ) . makeQuadtreeRaw ( new Impl ( ) , new APoint2d ( ) ) ; setParametersChanged ( false ) ; }
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

   class Quadratic3 extends NodeFunction {
      private boolean built ; private QT3d qt ; private class Impl extends AttractorFunction3 { public void apply ( APoint3d in_val , APoint3d out_val ) { double x = in_val . x ; double y = in_val . y ; double z = in_val . z ; out_val . x = x * x * a [ 0 ] + x * y * a [ 1 ] + x * z * a [ 2 ] + y * y * a [ 3 ] + y * z * a [ 4 ] + z * z * a [ 5 ] + x * a [ 6 ] + y * a [ 7 ] + z * a [ 8 ] + a [ 9 ] ; out_val . y = x * x * b [ 0 ] + x * y * b [ 1 ] + x * z * b [ 2 ] + y * y * b [ 3 ] + y * z * b [ 4 ] + z * z * b [ 5 ] + x * b [ 6 ] + y * b [ 7 ] + z * b [ 8 ] + b [ 9 ] ; out_val . z = x * x * c [ 0 ] + x * y * c [ 1 ] + x * z * c [ 2 ] + y * y * c [ 3 ] + y * z * c [ 4 ] + z * z * c [ 5 ] + x * c [ 6 ] + y * c [ 7 ] + z * c [ 8 ] + c [ 9 ] ; } public double derivMagnitude ( APoint3d in_val ) { double x = in_val . x ; double y = in_val . y ; double z = in_val . y ; double d00 = 2 * x * a [ 0 ] + y * a [ 1 ] + z * a [ 2 ] + a [ 6 ] ; double d01 = 2 * y * a [ 3 ] + x * a [ 1 ] + z * a [ 4 ] + a [ 7 ] ; double d02 = 2 * z * a [ 5 ] + x * a [ 2 ] + y * a [ 4 ] + a [ 8 ] ; double d10 = 2 * x * b [ 0 ] + y * b [ 1 ] + z * b [ 2 ] + b [ 6 ] ; double d11 = 2 * y * b [ 3 ] + x * b [ 1 ] + z * b [ 4 ] + b [ 7 ] ; double d12 = 2 * z * b [ 5 ] + x * b [ 2 ] + y * b [ 4 ] + b [ 8 ] ; double d20 = 2 * x * c [ 0 ] + y * c [ 1 ] + z * c [ 2 ] + c [ 6 ] ; double d21 = 2 * y * c [ 3 ] + x * c [ 1 ] + z * c [ 4 ] + c [ 7 ] ; double d22 = 2 * z * c [ 5 ] + x * c [ 2 ] + y * c [ 4 ] + c [ 8 ] ; return Math . max ( Math . max ( Math . abs ( d00 ) + Math . abs ( d01 ) + Math . abs ( d02 ) , Math . abs ( d10 ) + Math . abs ( d11 ) + Math . abs ( d12 ) ) , Math . abs ( d20 ) + Math . abs ( d21 ) + Math . abs ( d22 ) ) ; } public void adjustParameters ( ) { a = new double [ 10 ] ; b = new double [ 10 ] ; c = new double [ 10 ] ; for ( int i = 0 ; i < 10 ; i ++ ) { a [ i ] = Math . random ( ) * 2 - 1 ; b [ i ] = Math . random ( ) * 2 - 1 ; c [ i ] = Math . random ( ) * 2 - 1 ; } } public int getIdealIterations ( ) { return super . getIdealIterations ( ) / 2 ; } }
      private double[] a;
      private double[] b;
      private double[] c;
      public Class getReturnClass() {
         return QT3d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built ) { qt = ( QT3d ) new Attractor ( ) . makeQuadtree ( new Impl ( ) , new APoint3d ( ) ) ; setParametersChanged ( false ) ; built = true ; } else if ( parametersChanged ( ) ) { qt = ( QT3d ) new Attractor ( ) . makeQuadtreeRaw ( new Impl ( ) , new APoint3d ( ) ) ; setParametersChanged ( false ) ; }
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

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new PeterDeJong() );
      functions.add( new Clifford() );
      functions.add( new Quadratic2_x1() );
      functions.add( new Quadratic2() );
      functions.add( new Cubic2() );
      functions.add( new Quadratic3() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == PeterDeJong.class)
          return new PeterDeJong();
      if(nfClass == Clifford.class)
          return new Clifford();
      if(nfClass == Quadratic2_x1.class)
          return new Quadratic2_x1();
      if(nfClass == Quadratic2.class)
          return new Quadratic2();
      if(nfClass == Cubic2.class)
          return new Cubic2();
      if(nfClass == Quadratic3.class)
          return new Quadratic3();
      return null;
   }

}
