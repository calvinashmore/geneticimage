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

public class Gradient implements FunctionGroup, java.io.Serializable {
   class Scalar extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LDouble.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Scalar(NodeFunctionFactory nff) {
         super(nff);
      }

      public Scalar() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LDouble a , b , c , d ; x . setContext ( new ContextXY ( x1 - delta , y1 ) ) ; a = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + delta , y1 ) ) ; b = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 , y1 - delta ) ) ; c = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 , y1 + delta ) ) ; d = ((LDouble)x.evaluate()) ; LVect2d r = new LVect2d ( ) ; r . x = ( b . val - a . val ) / ( 2 * delta ) ; r . y = ( d . val - c . val ) / ( 2 * delta ) ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_v2 ( 0 , 0 , 0 , 0 ) ; else return new Estimate_v2 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v2_d extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LDouble.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public v2_d(NodeFunctionFactory nff) {
         super(nff);
      }

      public v2_d() {
         this(null);
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
         Node x = getNode(0); 
         double deltax = 0.05 * v . x ; double deltay = 0.05 * v . y ; double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LDouble a , b ; x . setContext ( new ContextXY ( x1 - deltax , y1 - deltay ) ) ; a = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + deltax , y1 + deltay ) ) ; b = ((LDouble)x.evaluate()) ; return b . sub ( a ) . mult ( 0.5 / Math . sqrt ( deltax * deltax + deltay * deltay ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         Estimate_d x = (Estimate_d)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_d ( 0 , 0 ) ; else return new Estimate_d ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v2_v2 extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LVect2d.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public v2_v2(NodeFunctionFactory nff) {
         super(nff);
      }

      public v2_v2() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect2d.class;
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
         Node x = getNode(0); 
         double deltax = 0.05 * v . x ; double deltay = 0.05 * v . y ; double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect2d a , b ; x . setContext ( new ContextXY ( x1 - deltax , y1 - deltay ) ) ; a = ((LVect2d)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + deltax , y1 + deltay ) ) ; b = ((LVect2d)x.evaluate()) ; return b . sub ( a ) . mult ( 0.5 / Math . sqrt ( deltax * deltax + deltay * deltay ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_v2 ( 0 , 0 , 0 , 0 ) ; else return new Estimate_v2 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v2_v3 extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LVect3d.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public v2_v3(NodeFunctionFactory nff) {
         super(nff);
      }

      public v2_v3() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect3d.class;
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
         Node x = getNode(0); 
         double deltax = 0.05 * v . x ; double deltay = 0.05 * v . y ; double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect3d a , b ; x . setContext ( new ContextXY ( x1 - deltax , y1 - deltay ) ) ; a = ((LVect3d)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + deltax , y1 + deltay ) ) ; b = ((LVect3d)x.evaluate()) ; return b . sub ( a ) . mult ( 0.5 / Math . sqrt ( deltax * deltax + deltay * deltay ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_v3 ( 0 , 0 , 0 , 0 , 0 , 0 ) ; else return new Estimate_v3 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class vardelta extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LDouble.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public vardelta(NodeFunctionFactory nff) {
         super(nff);
      }

      public vardelta() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "ldelta";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble ldelta = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double delta = ldelta . val ; LDouble a , b , c , d ; x . setContext ( new ContextXY ( x1 - delta , y1 ) ) ; a = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + delta , y1 ) ) ; b = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 , y1 - delta ) ) ; c = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 , y1 + delta ) ) ; d = ((LDouble)x.evaluate()) ; LVect2d r = new LVect2d ( ) ; r . x = ( b . val - a . val ) / ( 2 * delta ) ; r . y = ( d . val - c . val ) / ( 2 * delta ) ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d ldelta = (Estimate_d)inputs[0]; 
         Estimate_d x = (Estimate_d)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_v2 ( 0 , 0 , 0 , 0 ) ; else return new Estimate_v2 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class x extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LDouble.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public x(NodeFunctionFactory nff) {
         super(nff);
      }

      public x() {
         this(null);
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LDouble a , b ; x . setContext ( new ContextXY ( x1 - delta , y1 ) ) ; a = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + delta , y1 ) ) ; b = ((LDouble)x.evaluate()) ; LDouble r = new LDouble ( ) ; r . val = ( b . val - a . val ) / ( 2 * delta ) ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_d ( 0 , 0 ) ; else return new Estimate_d ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class x_vardelta extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LDouble.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public x_vardelta(NodeFunctionFactory nff) {
         super(nff);
      }

      public x_vardelta() {
         this(null);
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "ldelta";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble ldelta = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double delta = ldelta . val ; LDouble a , b ; x . setContext ( new ContextXY ( x1 - delta , y1 ) ) ; a = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + delta , y1 ) ) ; b = ((LDouble)x.evaluate()) ; LDouble r = new LDouble ( ) ; r . val = ( b . val - a . val ) / ( 2 * delta ) ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d ldelta = (Estimate_d)inputs[0]; 
         Estimate_d x = (Estimate_d)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_d ( 0 , 0 ) ; else return new Estimate_d ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class x_v2 extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LVect2d.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public x_v2(NodeFunctionFactory nff) {
         super(nff);
      }

      public x_v2() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect2d a , b ; x . setContext ( new ContextXY ( x1 - delta , y1 ) ) ; a = ((LVect2d)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + delta , y1 ) ) ; b = ((LVect2d)x.evaluate()) ; return b . sub ( a ) . mult ( 0.5 / delta ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_v2 ( 0 , 0 , 0 , 0 ) ; else return new Estimate_v2 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class x_v3 extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LVect3d.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public x_v3(NodeFunctionFactory nff) {
         super(nff);
      }

      public x_v3() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect3d a , b ; x . setContext ( new ContextXY ( x1 - delta , y1 ) ) ; a = ((LVect3d)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + delta , y1 ) ) ; b = ((LVect3d)x.evaluate()) ; return b . sub ( a ) . mult ( 0.5 / delta ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_v3 ( 0 , 0 , 0 , 0 , 0 , 0 ) ; else return new Estimate_v3 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class y extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LDouble.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public y(NodeFunctionFactory nff) {
         super(nff);
      }

      public y() {
         this(null);
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LDouble a , b ; x . setContext ( new ContextXY ( x1 , y1 - delta ) ) ; a = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 , y1 + delta ) ) ; b = ((LDouble)x.evaluate()) ; LDouble r = new LDouble ( ) ; r . val = ( b . val - a . val ) / ( 2 * delta ) ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_d ( 0 , 0 ) ; else return new Estimate_d ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class y_vardelta extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LDouble.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public y_vardelta(NodeFunctionFactory nff) {
         super(nff);
      }

      public y_vardelta() {
         this(null);
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "ldelta";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble ldelta = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double delta = ldelta . val ; LDouble a , b ; x . setContext ( new ContextXY ( x1 , y1 - delta ) ) ; a = ((LDouble)x.evaluate()) ; x . setContext ( new ContextXY ( x1 , y1 + delta ) ) ; b = ((LDouble)x.evaluate()) ; LDouble r = new LDouble ( ) ; r . val = ( b . val - a . val ) / ( 2 * delta ) ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d ldelta = (Estimate_d)inputs[0]; 
         Estimate_d x = (Estimate_d)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_d ( 0 , 0 ) ; else return new Estimate_d ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class y_v2 extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LVect2d.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public y_v2(NodeFunctionFactory nff) {
         super(nff);
      }

      public y_v2() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect2d a , b ; x . setContext ( new ContextXY ( x1 , y1 - delta ) ) ; a = ((LVect2d)x.evaluate()) ; x . setContext ( new ContextXY ( x1 , y1 + delta ) ) ; b = ((LVect2d)x.evaluate()) ; return b . sub ( a ) . mult ( 0.5 / delta ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_v2 ( 0 , 0 , 0 , 0 ) ; else return new Estimate_v2 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class y_v3 extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return LVect3d.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public y_v3(NodeFunctionFactory nff) {
         super(nff);
      }

      public y_v3() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect3d a , b ; x . setContext ( new ContextXY ( x1 , y1 - delta ) ) ; a = ((LVect3d)x.evaluate()) ; x . setContext ( new ContextXY ( x1 , y1 + delta ) ) ; b = ((LVect3d)x.evaluate()) ; return b . sub ( a ) . mult ( 0.5 / delta ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_v3 ( 0 , 0 , 0 , 0 , 0 , 0 ) ; else return new Estimate_v3 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class x_c extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Complex.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public x_c(NodeFunctionFactory nff) {
         super(nff);
      }

      public x_c() {
         this(null);
      }

      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Complex a , b ; x . setContext ( new ContextXY ( x1 - delta , y1 ) ) ; a = ((Complex)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + delta , y1 ) ) ; b = ((Complex)x.evaluate()) ; return b . sub ( a ) . mult ( 0.5 / delta ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_c ( 0 , 0 , 0 , 0 ) ; else return new Estimate_c ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class y_c extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Complex.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public y_c(NodeFunctionFactory nff) {
         super(nff);
      }

      public y_c() {
         this(null);
      }

      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Complex a , b ; x . setContext ( new ContextXY ( x1 , y1 - delta ) ) ; a = ((Complex)x.evaluate()) ; x . setContext ( new ContextXY ( x1 , y1 + delta ) ) ; b = ((Complex)x.evaluate()) ; return b . sub ( a ) . mult ( 0.5 / delta ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_c ( 0 , 0 , 0 , 0 ) ; else return new Estimate_c ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class mag_c extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Complex.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public mag_c(NodeFunctionFactory nff) {
         super(nff);
      }

      public mag_c() {
         this(null);
      }

      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double mag = Math . sqrt ( x1 * x1 + y1 * y1 ) ; double mag1 = mag * ( 1 - delta ) ; double mag2 = mag * ( 1 + delta ) ; double diff = mag2 - mag1 ; double x0 = x1 / mag ; double y0 = y1 / mag ; Complex a , b ; x . setContext ( new ContextXY ( x0 * mag1 , y0 * mag1 ) ) ; a = ((Complex)x.evaluate()) ; x . setContext ( new ContextXY ( x0 * mag2 , y0 * mag2 ) ) ; b = ((Complex)x.evaluate()) ; return b . sub ( a ) . mult ( diff ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_c ( 0 , 0 , 0 , 0 ) ; else return new Estimate_c ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class rad_c extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Complex.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public rad_c(NodeFunctionFactory nff) {
         super(nff);
      }

      public rad_c() {
         this(null);
      }

      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double mag = Math . sqrt ( x1 * x1 + y1 * y1 ) ; double x0 = x1 / mag ; double y0 = y1 / mag ; double theta = Math . atan2 ( y1 , x1 ) ; Complex a , b ; x . setContext ( new ContextXY ( mag * Math . cos ( theta - delta ) , mag * Math . sin ( theta - delta ) ) ) ; a = ((Complex)x.evaluate()) ; x . setContext ( new ContextXY ( mag * Math . cos ( theta + delta ) , mag * Math . sin ( theta + delta ) ) ) ; b = ((Complex)x.evaluate()) ; return b . sub ( a ) . mult ( .5 / delta ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_c ( 0 , 0 , 0 , 0 ) ; else return new Estimate_c ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v2_c extends NodeFunction_NodeBase {
      private static final double delta = 0.05 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Complex.class;
         return null;
      }

      public Class getNodeContextClass(int i) {
         if(i == 0) return ContextXY.class;
         return null;
      }

      public String getNodeInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public v2_c(NodeFunctionFactory nff) {
         super(nff);
      }

      public v2_c() {
         this(null);
      }

      public Class getReturnClass() {
         return Complex.class;
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
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Complex a , b ; double deltax = delta * v . x ; double deltay = delta * v . y ; x . setContext ( new ContextXY ( x1 - deltax , y1 - deltay ) ) ; a = ((Complex)x.evaluate()) ; x . setContext ( new ContextXY ( x1 + deltax , y1 + deltay ) ) ; b = ((Complex)x.evaluate()) ; return b . sub ( a ) . mult ( .5 / delta ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         Estimate_c x = (Estimate_c)getEstimate(0); 
         if ( x . isConstant ( ) ) return new Estimate_c ( 0 , 0 , 0 , 0 ) ; else return new Estimate_c ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new Scalar() );
      functions.add( new v2_d() );
      functions.add( new v2_v2() );
      functions.add( new v2_v3() );
      functions.add( new vardelta() );
      functions.add( new x() );
      functions.add( new x_vardelta() );
      functions.add( new x_v2() );
      functions.add( new x_v3() );
      functions.add( new y() );
      functions.add( new y_vardelta() );
      functions.add( new y_v2() );
      functions.add( new y_v3() );
      functions.add( new x_c() );
      functions.add( new y_c() );
      functions.add( new mag_c() );
      functions.add( new rad_c() );
      functions.add( new v2_c() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Scalar.class)
          if(nff == null) return new Scalar(); else return new Scalar(nff);
      if(nfClass == v2_d.class)
          if(nff == null) return new v2_d(); else return new v2_d(nff);
      if(nfClass == v2_v2.class)
          if(nff == null) return new v2_v2(); else return new v2_v2(nff);
      if(nfClass == v2_v3.class)
          if(nff == null) return new v2_v3(); else return new v2_v3(nff);
      if(nfClass == vardelta.class)
          if(nff == null) return new vardelta(); else return new vardelta(nff);
      if(nfClass == x.class)
          if(nff == null) return new x(); else return new x(nff);
      if(nfClass == x_vardelta.class)
          if(nff == null) return new x_vardelta(); else return new x_vardelta(nff);
      if(nfClass == x_v2.class)
          if(nff == null) return new x_v2(); else return new x_v2(nff);
      if(nfClass == x_v3.class)
          if(nff == null) return new x_v3(); else return new x_v3(nff);
      if(nfClass == y.class)
          if(nff == null) return new y(); else return new y(nff);
      if(nfClass == y_vardelta.class)
          if(nff == null) return new y_vardelta(); else return new y_vardelta(nff);
      if(nfClass == y_v2.class)
          if(nff == null) return new y_v2(); else return new y_v2(nff);
      if(nfClass == y_v3.class)
          if(nff == null) return new y_v3(); else return new y_v3(nff);
      if(nfClass == x_c.class)
          if(nff == null) return new x_c(); else return new x_c(nff);
      if(nfClass == y_c.class)
          if(nff == null) return new y_c(); else return new y_c(nff);
      if(nfClass == mag_c.class)
          if(nff == null) return new mag_c(); else return new mag_c(nff);
      if(nfClass == rad_c.class)
          if(nff == null) return new rad_c(); else return new rad_c(nff);
      if(nfClass == v2_c.class)
          if(nff == null) return new v2_c(); else return new v2_c(nff);
      return null;
   }

}
