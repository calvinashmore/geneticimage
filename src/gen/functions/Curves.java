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

public class Curves implements FunctionGroup, java.io.Serializable {
   class Supercircle extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t + offset ; APoint2d r = new APoint2d ( ) ; double c = Math . cos ( t1 ) ; double s = Math . sin ( t1 ) ; r . x = Math . pow ( Math . abs ( c ) , a ) * Math . signum ( c ) ; r . y = Math . pow ( Math . abs ( s ) , a ) * Math . signum ( s ) ; return r ; }
      private double a;
      private double offset;
      private int count;
      public Supercircle() {
         a = Math . random ( ) * 4 + .01 ; count = ( int ) ( Math . random ( ) * 1000 ) + 100 ; offset = Math . random ( ) * Math . PI ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return offset;
         if(i == 2) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) offset = (Double)param;
         if(i == 2) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "offset";
         if(i == 2) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return int.class;
         return null;
      }

   }

   class Supershape_ab1 extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t + offset ; APoint2d r = new APoint2d ( ) ; double rad ; double tx , ty ; tx = Math . abs ( Math . cos ( m * t1 / 4 ) / 1 ) ; tx = Math . pow ( tx , n2 ) ; ty = Math . abs ( Math . sin ( m * t1 / 4 ) / 1 ) ; ty = Math . pow ( ty , n3 ) ; rad = Math . pow ( tx + ty , 1 / n1 ) ; if ( Math . abs ( rad ) == 0 ) { r . x = 0 ; r . y = 0 ; } else { rad = 1 / rad ; r . x = rad * Math . cos ( t1 ) ; r . y = rad * Math . sin ( t1 ) ; } return r ; }
      private double offset;
      private double m;
      private double n1;
      private double n2;
      private double n3;
      private int count;
      public Supershape_ab1() {
         m = Math . random ( ) * 7 + .001 ; n1 = Math . random ( ) * 100 + .001 ; n2 = Math . random ( ) * 100 + .001 ; n3 = Math . random ( ) * 100 + .001 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ; offset = Math . random ( ) * Math . PI ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 6;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         if(i == 1) return m;
         if(i == 2) return n1;
         if(i == 3) return n2;
         if(i == 4) return n3;
         if(i == 5) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Double)param;
         if(i == 1) m = (Double)param;
         if(i == 2) n1 = (Double)param;
         if(i == 3) n2 = (Double)param;
         if(i == 4) n3 = (Double)param;
         if(i == 5) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         if(i == 1) return "m";
         if(i == 2) return "n1";
         if(i == 3) return "n2";
         if(i == 4) return "n3";
         if(i == 5) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return double.class;
         if(i == 4) return double.class;
         if(i == 5) return int.class;
         return null;
      }

   }

   class Supershape_ab2 extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t + offset ; APoint2d r = new APoint2d ( ) ; double rad ; double tx , ty ; tx = Math . abs ( Math . cos ( m * t1 / 4 ) / a ) ; tx = Math . pow ( tx , n2 ) ; ty = Math . abs ( Math . sin ( m * t1 / 4 ) / b ) ; ty = Math . pow ( ty , n3 ) ; rad = Math . pow ( tx + ty , 1 / n1 ) ; if ( Math . abs ( rad ) == 0 ) { r . x = 0 ; r . y = 0 ; } else { rad = 1 / rad ; r . x = rad * Math . cos ( t1 ) ; r . y = rad * Math . sin ( t1 ) ; } return r ; }
      private double offset;
      private double m;
      private double n1;
      private double n2;
      private double n3;
      private double a;
      private double b;
      private int count;
      public Supershape_ab2() {
         m = Math . random ( ) * 7 + .001 ; n1 = Math . random ( ) * 100 + .001 ; n2 = Math . random ( ) * 100 + .001 ; n3 = Math . random ( ) * 100 + .001 ; a = Math . random ( ) * 1 + .5 ; b = Math . random ( ) * 1 + .5 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ; offset = Math . random ( ) * Math . PI ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 8;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         if(i == 1) return m;
         if(i == 2) return n1;
         if(i == 3) return n2;
         if(i == 4) return n3;
         if(i == 5) return a;
         if(i == 6) return b;
         if(i == 7) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Double)param;
         if(i == 1) m = (Double)param;
         if(i == 2) n1 = (Double)param;
         if(i == 3) n2 = (Double)param;
         if(i == 4) n3 = (Double)param;
         if(i == 5) a = (Double)param;
         if(i == 6) b = (Double)param;
         if(i == 7) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         if(i == 1) return "m";
         if(i == 2) return "n1";
         if(i == 3) return "n2";
         if(i == 4) return "n3";
         if(i == 5) return "a";
         if(i == 6) return "b";
         if(i == 7) return "count";
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
         if(i == 7) return int.class;
         return null;
      }

   }

   class Spiral_log extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t * extent ; APoint2d r = new APoint2d ( ) ; double rad = Math . exp ( a * t ) ; r . x = Math . cos ( t1 + offset ) * rad ; r . y = Math . sin ( t1 + offset ) * rad ; return r ; }
      private double offset;
      private double a;
      private double extent;
      private int count;
      public Spiral_log() {
         a = Math . random ( ) * 3 + 1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ; extent = Math . random ( ) * 11 + 1 ; offset = Math . random ( ) * 2 * Math . PI ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         if(i == 1) return a;
         if(i == 2) return extent;
         if(i == 3) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Double)param;
         if(i == 1) a = (Double)param;
         if(i == 2) extent = (Double)param;
         if(i == 3) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         if(i == 1) return "a";
         if(i == 2) return "extent";
         if(i == 3) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return int.class;
         return null;
      }

   }

   class Spiral_archimedes extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t * extent ; APoint2d r = new APoint2d ( ) ; double rad = a * t ; r . x = Math . cos ( t1 + offset ) * rad ; r . y = Math . sin ( t1 + offset ) * rad ; return r ; }
      private double offset;
      private double a;
      private double extent;
      private int count;
      public Spiral_archimedes() {
         a = Math . random ( ) * 10 + 1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ; extent = Math . random ( ) * 11 + 1 ; offset = Math . random ( ) * 2 * Math . PI ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         if(i == 1) return a;
         if(i == 2) return extent;
         if(i == 3) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Double)param;
         if(i == 1) a = (Double)param;
         if(i == 2) extent = (Double)param;
         if(i == 3) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         if(i == 1) return "a";
         if(i == 2) return "extent";
         if(i == 3) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return int.class;
         return null;
      }

   }

   class Spiral_fermat extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t * extent ; APoint2d r = new APoint2d ( ) ; double rad = a * Math . sqrt ( Math . abs ( 2 * t - 1 ) ) ; r . x = Math . cos ( t1 ) * rad * Math . signum ( 2 * t - 1 ) ; r . y = Math . sin ( t1 ) * rad ; return r ; }
      private double a;
      private double extent;
      private int count;
      public Spiral_fermat() {
         a = Math . random ( ) * 10 + 1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ; extent = Math . random ( ) * 11 + 1 ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return extent;
         if(i == 2) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) extent = (Double)param;
         if(i == 2) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "extent";
         if(i == 2) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return int.class;
         return null;
      }

   }

   class Spiral_fermat1 extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t * extent ; APoint2d r = new APoint2d ( ) ; double rad = a * Math . sqrt ( Math . abs ( 2 * t - 1 ) ) ; r . x = Math . cos ( t1 ) * rad * Math . signum ( 2 * t - 1 ) ; r . y = Math . sin ( t1 + offset ) * rad ; return r ; }
      private double offset;
      private double a;
      private double extent;
      private int count;
      public Spiral_fermat1() {
         a = Math . random ( ) * 10 + 1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ; extent = Math . random ( ) * 11 + 1 ; offset = Math . random ( ) * Math . PI ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         if(i == 1) return a;
         if(i == 2) return extent;
         if(i == 3) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Double)param;
         if(i == 1) a = (Double)param;
         if(i == 2) extent = (Double)param;
         if(i == 3) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         if(i == 1) return "a";
         if(i == 2) return "extent";
         if(i == 3) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return int.class;
         return null;
      }

   }

   class Spiral_hyperbolic extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t * extent ; APoint2d r = new APoint2d ( ) ; double rad = a / ( b * t + .03 ) ; r . x = Math . cos ( t1 + offset ) * rad ; r . y = Math . sin ( t1 + offset ) * rad ; return r ; }
      private double offset;
      private double a;
      private double b;
      private double extent;
      private int count;
      public Spiral_hyperbolic() {
         a = Math . random ( ) * 10 + 1 ; b = Math . random ( ) * 10 + 1 ; extent = Math . random ( ) * 11 + 1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ; offset = Math . random ( ) * 2 * Math . PI ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 5;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         if(i == 1) return a;
         if(i == 2) return b;
         if(i == 3) return extent;
         if(i == 4) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Double)param;
         if(i == 1) a = (Double)param;
         if(i == 2) b = (Double)param;
         if(i == 3) extent = (Double)param;
         if(i == 4) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         if(i == 1) return "a";
         if(i == 2) return "b";
         if(i == 3) return "extent";
         if(i == 4) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return double.class;
         if(i == 4) return int.class;
         return null;
      }

   }

   class Spiral_lituus extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t * extent ; APoint2d r = new APoint2d ( ) ; double rad = a * Math . sqrt ( 1 / ( b * Math . abs ( 2 * t - 1 ) + .1 ) ) ; r . x = Math . cos ( t1 ) * rad * Math . signum ( 2 * t - 1 ) ; r . y = Math . sin ( t1 ) * rad ; return r ; }
      private double a;
      private double b;
      private double extent;
      private int count;
      public Spiral_lituus() {
         a = Math . random ( ) * 10 + 1 ; b = Math . random ( ) * 10 + 1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ; extent = Math . random ( ) * 11 + 1 ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return b;
         if(i == 2) return extent;
         if(i == 3) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) b = (Double)param;
         if(i == 2) extent = (Double)param;
         if(i == 3) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         if(i == 2) return "extent";
         if(i == 3) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return int.class;
         return null;
      }

   }

   class Spiral_lituus1 extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 2 * Math . PI * t * extent ; APoint2d r = new APoint2d ( ) ; double rad = a * Math . sqrt ( 1 / ( b * Math . abs ( 2 * t - 1 ) + .1 ) ) ; r . x = Math . cos ( t1 ) * rad * Math . signum ( 2 * t - 1 ) ; r . y = Math . sin ( t1 + offset ) * rad ; return r ; }
      private double offset;
      private double a;
      private double b;
      private double extent;
      private int count;
      public Spiral_lituus1() {
         a = Math . random ( ) * 10 + 1 ; b = Math . random ( ) * 10 + 1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ; extent = Math . random ( ) * 11 + 1 ; offset = Math . random ( ) * 2 * Math . PI ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 5;
      }

      public Object getParameter(int i) {
         if(i == 0) return offset;
         if(i == 1) return a;
         if(i == 2) return b;
         if(i == 3) return extent;
         if(i == 4) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) offset = (Double)param;
         if(i == 1) a = (Double)param;
         if(i == 2) b = (Double)param;
         if(i == 3) extent = (Double)param;
         if(i == 4) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "offset";
         if(i == 1) return "a";
         if(i == 2) return "b";
         if(i == 3) return "extent";
         if(i == 4) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return double.class;
         if(i == 4) return int.class;
         return null;
      }

   }

   class Spiral_tanh extends NodeFunction implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { double t1 = 1 * Math . PI * t - Math . PI / 2 ; APoint2d r = new APoint2d ( ) ; r . x = Math . sinh ( 2 * t1 ) / ( Math . cos ( 2 * a * t1 ) + Math . cosh ( 2 * t1 ) ) ; r . x = Math . sin ( 2 * a * t1 ) / ( Math . cos ( 2 * a * t1 ) + Math . cosh ( 2 * t1 ) ) ; return r ; }
      private double a;
      private int count;
      public Spiral_tanh() {
         a = Math . random ( ) * 3 + .1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ;
      }

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
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class Curve_noise1 extends NodeFunction_NodeBase implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { getNode ( 0 ) . setContext ( new ContextNone ( ) ) ; NoiseFunction n = ( NoiseFunction ) getNode ( 0 ) . evaluate ( ) ; APoint2d x = new APoint2d ( ) ; x . x = n . noise ( a * t , 0 , 0 ) ; x . y = n . noise ( a * t + 100 , 100 , 100 ) ; return x ; }
      private double a;
      private int count;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return NoiseFunction.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextNone.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "noise";
         return null;
      }

      public Curve_noise1(NodeFunctionFactory nff) {
         super(nff);
         a = Math . random ( ) * 10 + .1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ;
      }

      public Curve_noise1() {
         this(null);
      }

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
         Node noise = getNode(0); 
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)getEstimate(0); 
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class Curve_noise2 extends NodeFunction_NodeBase implements CurveFunction {
      private boolean built ; private QT3d qt ; public APoint evalCurve ( double t ) { getNode ( 0 ) . setContext ( new ContextNone ( ) ) ; NoiseFunction n = ( NoiseFunction ) getNode ( 0 ) . evaluate ( ) ; APoint3d x = new APoint3d ( ) ; x . x = n . noise ( a * t , 0 , 0 ) ; x . y = n . noise ( a * t + 100 , 100 , 100 ) ; x . z = n . noise ( a * t + 300 , 300 , 300 ) ; return x ; }
      private double a;
      private int count;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return NoiseFunction.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextNone.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "noise";
         return null;
      }

      public Curve_noise2(NodeFunctionFactory nff) {
         super(nff);
         a = Math . random ( ) * 10 + .1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ;
      }

      public Curve_noise2() {
         this(null);
      }

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
         Node noise = getNode(0); 
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)getEstimate(0); 
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built || parametersChanged ( ) ) { qt = new QT3d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class Curve_fractal1 extends NodeFunction_NodeBase implements CurveFunction {
      private boolean built ; private QT2d qt ; public APoint evalCurve ( double t ) { getNode ( 0 ) . setContext ( new ContextNone ( ) ) ; getNode ( 1 ) . setContext ( new ContextNone ( ) ) ; NoiseFunction n = ( NoiseFunction ) getNode ( 0 ) . evaluate ( ) ; NoiseFractal f = ( NoiseFractal ) getNode ( 1 ) . evaluate ( ) ; APoint2d x = new APoint2d ( ) ; x . x = f . evalFractal ( n , a * t , 0 , 0 ) ; x . y = f . evalFractal ( n , a * t + 100 , 100 , 100 ) ; return x ; }
      private double a;
      private int count;
      public int getNumberSubnodes() {
         return 2;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return NoiseFunction.class;
         if(i == 1) return NoiseFractal.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextNone.class;
         if(i == 1) return ContextNone.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         return null;
      }

      public Curve_fractal1(NodeFunctionFactory nff) {
         super(nff);
         a = Math . random ( ) * 3 + .1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ;
      }

      public Curve_fractal1() {
         this(null);
      }

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
         Node noise = getNode(0); 
         Node fractal = getNode(1); 
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)getEstimate(0); 
         Estimate_param fractal = (Estimate_param)getEstimate(1); 
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built || parametersChanged ( ) ) { qt = new QT2d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class Curve_fractal2 extends NodeFunction_NodeBase implements CurveFunction {
      private boolean built ; private QT3d qt ; public APoint evalCurve ( double t ) { getNode ( 0 ) . setContext ( new ContextNone ( ) ) ; getNode ( 1 ) . setContext ( new ContextNone ( ) ) ; NoiseFunction n = ( NoiseFunction ) getNode ( 0 ) . evaluate ( ) ; NoiseFractal f = ( NoiseFractal ) getNode ( 1 ) . evaluate ( ) ; APoint3d x = new APoint3d ( ) ; x . x = f . evalFractal ( n , a * t , 0 , 0 ) ; x . y = f . evalFractal ( n , a * t + 100 , 100 , 100 ) ; x . z = f . evalFractal ( n , a * t + 300 , 300 , 300 ) ; return x ; }
      private double a;
      private int count;
      public int getNumberSubnodes() {
         return 2;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return NoiseFunction.class;
         if(i == 1) return NoiseFractal.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextNone.class;
         if(i == 1) return ContextNone.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         return null;
      }

      public Curve_fractal2(NodeFunctionFactory nff) {
         super(nff);
         a = Math . random ( ) * 3 + .1 ; count = ( int ) ( Math . random ( ) * 2000 ) + 500 ;
      }

      public Curve_fractal2() {
         this(null);
      }

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
         Node noise = getNode(0); 
         Node fractal = getNode(1); 
         return qt ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)getEstimate(0); 
         Estimate_param fractal = (Estimate_param)getEstimate(1); 
         return new Estimate_param();
      }

      public void setup() {
         if ( ! built || parametersChanged ( ) ) { qt = new QT3d ( ) ; new Curve ( ) . process ( this , qt , count ) ; setParametersChanged ( false ) ; built = true ; }
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return a;
         if(i == 1) return count;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) a = (Double)param;
         if(i == 1) count = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "count";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new Supercircle() );
      functions.add( new Supershape_ab1() );
      functions.add( new Supershape_ab2() );
      functions.add( new Spiral_log() );
      functions.add( new Spiral_archimedes() );
      functions.add( new Spiral_fermat() );
      functions.add( new Spiral_fermat1() );
      functions.add( new Spiral_hyperbolic() );
      functions.add( new Spiral_lituus() );
      functions.add( new Spiral_lituus1() );
      functions.add( new Spiral_tanh() );
      functions.add( new Curve_noise1() );
      functions.add( new Curve_noise2() );
      functions.add( new Curve_fractal1() );
      functions.add( new Curve_fractal2() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Supercircle.class)
          return new Supercircle();
      if(nfClass == Supershape_ab1.class)
          return new Supershape_ab1();
      if(nfClass == Supershape_ab2.class)
          return new Supershape_ab2();
      if(nfClass == Spiral_log.class)
          return new Spiral_log();
      if(nfClass == Spiral_archimedes.class)
          return new Spiral_archimedes();
      if(nfClass == Spiral_fermat.class)
          return new Spiral_fermat();
      if(nfClass == Spiral_fermat1.class)
          return new Spiral_fermat1();
      if(nfClass == Spiral_hyperbolic.class)
          return new Spiral_hyperbolic();
      if(nfClass == Spiral_lituus.class)
          return new Spiral_lituus();
      if(nfClass == Spiral_lituus1.class)
          return new Spiral_lituus1();
      if(nfClass == Spiral_tanh.class)
          return new Spiral_tanh();
      if(nfClass == Curve_noise1.class)
          if(nff == null) return new Curve_noise1(); else return new Curve_noise1(nff);
      if(nfClass == Curve_noise2.class)
          if(nff == null) return new Curve_noise2(); else return new Curve_noise2(nff);
      if(nfClass == Curve_fractal1.class)
          if(nff == null) return new Curve_fractal1(); else return new Curve_fractal1(nff);
      if(nfClass == Curve_fractal2.class)
          if(nff == null) return new Curve_fractal2(); else return new Curve_fractal2(nff);
      return null;
   }

}
