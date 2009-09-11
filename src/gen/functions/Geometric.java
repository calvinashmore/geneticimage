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

public class Geometric implements FunctionGroup, java.io.Serializable {
   class circle extends NodeFunction {
      private double radius;
      private LVect2d center;
      public circle() {
         Random rand = new Random ( ) ; radius = .8 * rand . nextDouble ( ) + .2 ; center = new LVect2d ( ) ; center . x = 2 * rand . nextDouble ( ) - 1 ; center . y = 2 * rand . nextDouble ( ) - 1 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d v = (LVect2d)inputs[0]; 
         if ( center . sub ( v ) . magnitude ( ) < radius ) return new LDouble ( 1 ) ; else return new LDouble ( 0 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         return new Estimate_d ( 0 , 1 ) ;
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         if(i == 1) return center;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
         if(i == 1) center = (LVect2d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         if(i == 1) return "center";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return LVect2d.class;
         return null;
      }

   }

   class circle_hole extends NodeFunction {
      private double radius;
      private double innerRadius;
      private LVect2d center;
      public circle_hole() {
         Random rand = new Random ( ) ; radius = .8 * rand . nextDouble ( ) + .2 ; innerRadius = rand . nextDouble ( ) * radius ; center = new LVect2d ( ) ; center . x = 2 * rand . nextDouble ( ) - 1 ; center . y = 2 * rand . nextDouble ( ) - 1 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d v = (LVect2d)inputs[0]; 
         double r = center . sub ( v ) . magnitude ( ) ; if ( r < radius && r > innerRadius ) return new LDouble ( 1 ) ; else return new LDouble ( 0 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         return new Estimate_d ( 0 , 1 ) ;
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         if(i == 1) return innerRadius;
         if(i == 2) return center;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
         if(i == 1) innerRadius = (Double)param;
         if(i == 2) center = (LVect2d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         if(i == 1) return "innerRadius";
         if(i == 2) return "center";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return LVect2d.class;
         return null;
      }

   }

   class square extends NodeFunction {
      private double radius;
      private double tilt;
      private LVect2d center;
      public square() {
         Random rand = new Random ( ) ; radius = .8 * rand . nextDouble ( ) + .2 ; tilt = rand . nextDouble ( ) * Math . PI ; center = new LVect2d ( ) ; center . x = 2 * rand . nextDouble ( ) - 1 ; center . y = 2 * rand . nextDouble ( ) - 1 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d v = (LVect2d)inputs[0]; 
         LVect2d u = center . sub ( v ) ; double r = Math . max ( Math . abs ( Math . cos ( tilt ) * u . x + Math . sin ( tilt ) * u . y ) , Math . abs ( Math . cos ( tilt ) * u . y - Math . sin ( tilt ) * u . x ) ) ; if ( r < radius ) return new LDouble ( 1 ) ; else return new LDouble ( 0 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         return new Estimate_d ( 0 , 1 ) ;
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         if(i == 1) return tilt;
         if(i == 2) return center;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
         if(i == 1) tilt = (Double)param;
         if(i == 2) center = (LVect2d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         if(i == 1) return "tilt";
         if(i == 2) return "center";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return LVect2d.class;
         return null;
      }

   }

   class square_hole extends NodeFunction {
      private double radius;
      private double innerRadius;
      private double tilt;
      private LVect2d center;
      public square_hole() {
         Random rand = new Random ( ) ; radius = .8 * rand . nextDouble ( ) + .2 ; innerRadius = rand . nextDouble ( ) * radius ; tilt = rand . nextDouble ( ) * Math . PI ; center = new LVect2d ( ) ; center . x = 2 * rand . nextDouble ( ) - 1 ; center . y = 2 * rand . nextDouble ( ) - 1 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d v = (LVect2d)inputs[0]; 
         LVect2d u = center . sub ( v ) ; double r = Math . max ( Math . abs ( Math . cos ( tilt ) * u . x + Math . sin ( tilt ) * u . y ) , Math . abs ( Math . cos ( tilt ) * u . y - Math . sin ( tilt ) * u . x ) ) ; if ( r < radius && r > innerRadius ) return new LDouble ( 1 ) ; else return new LDouble ( 0 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         return new Estimate_d ( 0 , 1 ) ;
      }

      public int getNumberParameters() {
         return 4;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         if(i == 1) return innerRadius;
         if(i == 2) return tilt;
         if(i == 3) return center;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
         if(i == 1) innerRadius = (Double)param;
         if(i == 2) tilt = (Double)param;
         if(i == 3) center = (LVect2d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         if(i == 1) return "innerRadius";
         if(i == 2) return "tilt";
         if(i == 3) return "center";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         if(i == 3) return LVect2d.class;
         return null;
      }

   }

   class bar extends NodeFunction {
      private double radius;
      private double tilt;
      private LVect2d center;
      public bar() {
         Random rand = new Random ( ) ; radius = .3 * rand . nextDouble ( ) ; tilt = rand . nextDouble ( ) * Math . PI ; center = new LVect2d ( ) ; center . x = 2 * rand . nextDouble ( ) - 1 ; center . y = 2 * rand . nextDouble ( ) - 1 ;
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d v = (LVect2d)inputs[0]; 
         LVect2d u = center . sub ( v ) ; double r = Math . abs ( Math . cos ( tilt ) * u . x + Math . sin ( tilt ) * u . y ) ; if ( r < radius ) return new LDouble ( 1 ) ; else return new LDouble ( 0 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         return new Estimate_d ( 0 , 1 ) ;
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return radius;
         if(i == 1) return tilt;
         if(i == 2) return center;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) radius = (Double)param;
         if(i == 1) tilt = (Double)param;
         if(i == 2) center = (LVect2d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "radius";
         if(i == 1) return "tilt";
         if(i == 2) return "center";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return LVect2d.class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new circle() );
      functions.add( new circle_hole() );
      functions.add( new square() );
      functions.add( new square_hole() );
      functions.add( new bar() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == circle.class)
          return new circle();
      if(nfClass == circle_hole.class)
          return new circle_hole();
      if(nfClass == square.class)
          return new square();
      if(nfClass == square_hole.class)
          return new square_hole();
      if(nfClass == bar.class)
          return new bar();
      return null;
   }

}
