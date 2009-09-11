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

public class Quadtree implements FunctionGroup, java.io.Serializable {
   class qt2_density extends NodeFunction {
      private double radius;
      public qt2_density() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT2d qt = (QT2d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ; int ok = 0 ; for ( APoint2d point : contents ) { if ( point . distanceSquared ( x1 , y1 ) < rad * rad ) ok ++ ; } return new LDouble ( ( double ) ok / qt . getMaxDensity ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt2_density1 extends NodeFunction {
      private double radius;
      public qt2_density1() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT2d qt = (QT2d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ; int ok = 0 ; double dist2 = 100 ; for ( APoint2d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) dist2 = d ; if ( point . distanceSquared ( x1 , y1 ) < rad * rad ) ok ++ ; } dist2 = Math . sqrt ( dist2 ) / rad ; return new LDouble ( ( double ) ok * ( 1 - dist2 ) / qt . getMaxDensity ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt2_nearestDist extends NodeFunction {
      private double radius;
      public qt2_nearestDist() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT2d qt = (QT2d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; for ( APoint2d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) dist2 = d ; } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LDouble ( 0 ) ; return new LDouble ( 1 - dist2 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt2_nearestDist1 extends NodeFunction {
      private double radius;
      public qt2_nearestDist1() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT2d qt = (QT2d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; for ( APoint2d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) dist2 = d ; } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LDouble ( 0 ) ; return new LDouble ( dist2 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt2_nearestDist_progress extends NodeFunction {
      private double radius;
      public qt2_nearestDist_progress() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT2d qt = (QT2d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; double progress = 0 ; for ( APoint2d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) { dist2 = d ; progress = point . index ; } } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LDouble ( 0 ) ; return new LDouble ( ( 1 - dist2 ) * progress ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt2_geometric extends NodeFunction {
      private double radius;
      public qt2_geometric() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT2d qt = (QT2d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; for ( APoint2d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) dist2 = d ; } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LDouble ( 0 ) ; return new LDouble ( 1 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt2_geometric_progress extends NodeFunction {
      private double radius;
      public qt2_geometric_progress() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT2d qt = (QT2d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; double progress = 0 ; for ( APoint2d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) { dist2 = d ; progress = point . index ; } } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LDouble ( 0 ) ; return new LDouble ( progress ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt2_nearestVect extends NodeFunction {
      private double radius;
      public qt2_nearestVect() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT2d qt = (QT2d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint2d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; double dx = 0 ; double dy = 0 ; for ( APoint2d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) { dist2 = d ; dx = point . x - x1 ; dy = point . y - x1 ; } } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LVect2d ( 0 , 0 ) ; return new LVect2d ( dx , dy ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt2_depth extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT2d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT2d qt = (QT2d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; return new LDouble ( ( double ) qt . getDepth ( x1 , y1 ) / qt . getMaxDepth ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

   }

   class qt3_density extends NodeFunction {
      private double radius;
      public qt3_density() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT3d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT3d qt = (QT3d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ; int ok = 0 ; for ( APoint3d point : contents ) { if ( point . distanceSquared ( x1 , y1 ) < rad * rad ) ok ++ ; } return new LDouble ( ( double ) ok / qt . getMaxDensity ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt3_density1 extends NodeFunction {
      private double radius;
      public qt3_density1() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT3d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT3d qt = (QT3d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ; int ok = 0 ; double dist2 = 100 ; for ( APoint3d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) dist2 = d ; if ( point . distanceSquared ( x1 , y1 ) < rad * rad ) ok ++ ; } dist2 = Math . sqrt ( dist2 ) / rad ; return new LDouble ( ( double ) ok * ( 1 - dist2 ) / qt . getMaxDensity ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt3_nearestDist extends NodeFunction {
      private double radius;
      public qt3_nearestDist() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT3d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT3d qt = (QT3d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; for ( APoint3d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) dist2 = d ; } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LDouble ( 0 ) ; return new LDouble ( 1 - dist2 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt3_nearestDist1 extends NodeFunction {
      private double radius;
      public qt3_nearestDist1() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT3d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT3d qt = (QT3d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; for ( APoint3d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) dist2 = d ; } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LDouble ( 0 ) ; return new LDouble ( dist2 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt3_geometric_3Return extends NodeFunction {
      private double radius;
      public qt3_geometric_3Return() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT3d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT3d qt = (QT3d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; double zval = 0 ; for ( APoint3d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) { dist2 = d ; zval = point . z ; } } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LDouble ( 0 ) ; return new LDouble ( zval ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt3_nearestDist_3Return extends NodeFunction {
      private double radius;
      public qt3_nearestDist_3Return() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT3d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT3d qt = (QT3d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; double zval = 0 ; for ( APoint3d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) { dist2 = d ; zval = point . z ; } } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LDouble ( 0 ) ; return new LDouble ( dist2 * zval ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt3_nearestVect extends NodeFunction {
      private double radius;
      public qt3_nearestVect() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT3d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT3d qt = (QT3d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; double dx = 0 ; double dy = 0 ; double zval = 0 ; for ( APoint3d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) { dist2 = d ; dx = point . x - x1 ; dy = point . y - x1 ; zval = point . z ; } } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LVect2d ( 0 , 0 ) ; return new LVect2d ( dx * zval , dy * zval ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt3_nearestVect_3Return extends NodeFunction {
      private double radius;
      public qt3_nearestVect_3Return() {
         radius = Math . random ( ) + .02 ;
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT3d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT3d qt = (QT3d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double rad = qt . getRadiusEstimate ( ) * radius ; double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; List < APoint3d > contents = qt . getContents ( x1 , y1 , rad ) ; double dist2 = 100 ; double dx = 0 ; double dy = 0 ; for ( APoint3d point : contents ) { double d = point . distanceSquared ( x1 , y1 ) ; if ( d < dist2 ) { dist2 = d ; dx = point . x - x . x ; dy = point . y - x . y ; } } dist2 = Math . sqrt ( dist2 ) / rad ; if ( dist2 > 1 ) return new LVect2d ( 0 , 0 ) ; return new LVect2d ( dx , dy ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class qt3_depth extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {QT3d.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "qt";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         QT3d qt = (QT3d)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         double x1 = qt . convertXFromUnit ( x . x ) ; double y1 = qt . convertYFromUnit ( x . y ) ; return new LDouble ( ( double ) qt . getDepth ( x1 , y1 ) / qt . getMaxDepth ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param qt = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new qt2_density() );
      functions.add( new qt2_density1() );
      functions.add( new qt2_nearestDist() );
      functions.add( new qt2_nearestDist1() );
      functions.add( new qt2_nearestDist_progress() );
      functions.add( new qt2_geometric() );
      functions.add( new qt2_geometric_progress() );
      functions.add( new qt2_nearestVect() );
      functions.add( new qt2_depth() );
      functions.add( new qt3_density() );
      functions.add( new qt3_density1() );
      functions.add( new qt3_nearestDist() );
      functions.add( new qt3_nearestDist1() );
      functions.add( new qt3_geometric_3Return() );
      functions.add( new qt3_nearestDist_3Return() );
      functions.add( new qt3_nearestVect() );
      functions.add( new qt3_nearestVect_3Return() );
      functions.add( new qt3_depth() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == qt2_density.class)
          return new qt2_density();
      if(nfClass == qt2_density1.class)
          return new qt2_density1();
      if(nfClass == qt2_nearestDist.class)
          return new qt2_nearestDist();
      if(nfClass == qt2_nearestDist1.class)
          return new qt2_nearestDist1();
      if(nfClass == qt2_nearestDist_progress.class)
          return new qt2_nearestDist_progress();
      if(nfClass == qt2_geometric.class)
          return new qt2_geometric();
      if(nfClass == qt2_geometric_progress.class)
          return new qt2_geometric_progress();
      if(nfClass == qt2_nearestVect.class)
          return new qt2_nearestVect();
      if(nfClass == qt2_depth.class)
          return new qt2_depth();
      if(nfClass == qt3_density.class)
          return new qt3_density();
      if(nfClass == qt3_density1.class)
          return new qt3_density1();
      if(nfClass == qt3_nearestDist.class)
          return new qt3_nearestDist();
      if(nfClass == qt3_nearestDist1.class)
          return new qt3_nearestDist1();
      if(nfClass == qt3_geometric_3Return.class)
          return new qt3_geometric_3Return();
      if(nfClass == qt3_nearestDist_3Return.class)
          return new qt3_nearestDist_3Return();
      if(nfClass == qt3_nearestVect.class)
          return new qt3_nearestVect();
      if(nfClass == qt3_nearestVect_3Return.class)
          return new qt3_nearestVect_3Return();
      if(nfClass == qt3_depth.class)
          return new qt3_depth();
      return null;
   }

}
