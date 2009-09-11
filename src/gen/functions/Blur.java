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

public class Blur implements FunctionGroup, java.io.Serializable {
   class d extends NodeFunction_NodeBase {
      private static final double radius = 0.01 ;
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

      public d(NodeFunctionFactory nff) {
         super(nff);
      }

      public d() {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LDouble r = new LDouble ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LDouble)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class d_d extends NodeFunction_NodeBase {
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

      public d_d(NodeFunctionFactory nff) {
         super(nff);
      }

      public d_d() {
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
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.01 ; LDouble r = new LDouble ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((LDouble)x.evaluate()) ; } for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LDouble)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_d x = (Estimate_d)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class d_v2 extends NodeFunction_NodeBase {
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

      public d_v2(NodeFunctionFactory nff) {
         super(nff);
      }

      public d_v2() {
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
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LDouble r = new LDouble ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius . x * i * 0.01 + x1 ; double newy = radius . y * j * 0.01 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LDouble)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_d x = (Estimate_d)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v2 extends NodeFunction_NodeBase {
      private static final double radius = 0.01 ;
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

      public v2(NodeFunctionFactory nff) {
         super(nff);
      }

      public v2() {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect2d r = new LVect2d ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect2d)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         return x ;
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

      public v2_d(NodeFunctionFactory nff) {
         super(nff);
      }

      public v2_d() {
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
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.01 ; LVect2d r = new LVect2d ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((LVect2d)x.evaluate()) ; } for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect2d)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         return x ;
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
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect2d r = new LVect2d ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius . x * i * 0.01 + x1 ; double newy = radius . y * j * 0.01 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect2d)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v3 extends NodeFunction_NodeBase {
      private static final double radius = 0.01 ;
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

      public v3(NodeFunctionFactory nff) {
         super(nff);
      }

      public v3() {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect3d r = new LVect3d ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect3d)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v3_d extends NodeFunction_NodeBase {
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

      public v3_d(NodeFunctionFactory nff) {
         super(nff);
      }

      public v3_d() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.01 ; LVect3d r = new LVect3d ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((LVect3d)x.evaluate()) ; } for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect3d)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v3_v2 extends NodeFunction_NodeBase {
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

      public v3_v2(NodeFunctionFactory nff) {
         super(nff);
      }

      public v3_v2() {
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
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect3d r = new LVect3d ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius . x * i * 0.01 + x1 ; double newy = radius . y * j * 0.01 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect3d)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class c extends NodeFunction_NodeBase {
      private static final double radius = 0.01 ;
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

      public c(NodeFunctionFactory nff) {
         super(nff);
      }

      public c() {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Complex r = new Complex ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Complex)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class c_d extends NodeFunction_NodeBase {
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

      public c_d(NodeFunctionFactory nff) {
         super(nff);
      }

      public c_d() {
         this(null);
      }

      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.01 ; Complex r = new Complex ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((Complex)x.evaluate()) ; } for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Complex)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_c x = (Estimate_c)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class c_v2 extends NodeFunction_NodeBase {
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

      public c_v2(NodeFunctionFactory nff) {
         super(nff);
      }

      public c_v2() {
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
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Complex r = new Complex ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius . x * i * 0.01 + x1 ; double newy = radius . y * j * 0.01 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Complex)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_c x = (Estimate_c)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class col extends NodeFunction_NodeBase {
      private static final double radius = 0.01 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Color.class;
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

      public col(NodeFunctionFactory nff) {
         super(nff);
      }

      public col() {
         this(null);
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Color r = new Color ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Color)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class col_d extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Color.class;
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

      public col_d(NodeFunctionFactory nff) {
         super(nff);
      }

      public col_d() {
         this(null);
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.01 ; Color r = new Color ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((Color)x.evaluate()) ; } for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Color)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_col x = (Estimate_col)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class col_v2 extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Color.class;
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

      public col_v2(NodeFunctionFactory nff) {
         super(nff);
      }

      public col_v2() {
         this(null);
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Color r = new Color ( ) ; for ( int i = - 1 ; i <= 1 ; i ++ ) for ( int j = - 1 ; j <= 1 ; j ++ ) { double newx = radius . x * i * 0.01 + x1 ; double newy = radius . y * j * 0.01 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Color)x.evaluate()) ) ; } return r . mult ( 1.0 / 9 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_col x = (Estimate_col)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class d_2 extends NodeFunction_NodeBase {
      private static final double radius = 0.005 ;
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

      public d_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public d_2() {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LDouble r = new LDouble ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LDouble)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d x = (Estimate_d)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class d_d_2 extends NodeFunction_NodeBase {
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

      public d_d_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public d_d_2() {
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
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.005 ; LDouble r = new LDouble ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((LDouble)x.evaluate()) ; } for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LDouble)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_d x = (Estimate_d)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class d_v2_2 extends NodeFunction_NodeBase {
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

      public d_v2_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public d_v2_2() {
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
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LDouble r = new LDouble ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius . x * i * 0.005 + x1 ; double newy = radius . y * j * 0.005 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LDouble)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_d x = (Estimate_d)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v2_2 extends NodeFunction_NodeBase {
      private static final double radius = 0.005 ;
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

      public v2_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public v2_2() {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect2d r = new LVect2d ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect2d)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v2_d_2 extends NodeFunction_NodeBase {
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

      public v2_d_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public v2_d_2() {
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
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.005 ; LVect2d r = new LVect2d ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((LVect2d)x.evaluate()) ; } for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect2d)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v2_v2_2 extends NodeFunction_NodeBase {
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

      public v2_v2_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public v2_v2_2() {
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
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect2d r = new LVect2d ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius . x * i * 0.005 + x1 ; double newy = radius . y * j * 0.005 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect2d)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v3_2 extends NodeFunction_NodeBase {
      private static final double radius = 0.005 ;
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

      public v3_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public v3_2() {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect3d r = new LVect3d ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect3d)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v3_d_2 extends NodeFunction_NodeBase {
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

      public v3_d_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public v3_d_2() {
         this(null);
      }

      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.005 ; LVect3d r = new LVect3d ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((LVect3d)x.evaluate()) ; } for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect3d)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v3_v2_2 extends NodeFunction_NodeBase {
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

      public v3_v2_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public v3_v2_2() {
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
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect3d r = new LVect3d ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius . x * i * 0.005 + x1 ; double newy = radius . y * j * 0.005 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((LVect3d)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class c_2 extends NodeFunction_NodeBase {
      private static final double radius = 0.005 ;
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

      public c_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public c_2() {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Complex r = new Complex ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Complex)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class c_d_2 extends NodeFunction_NodeBase {
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

      public c_d_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public c_d_2() {
         this(null);
      }

      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.005 ; Complex r = new Complex ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((Complex)x.evaluate()) ; } for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Complex)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_c x = (Estimate_c)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class c_v2_2 extends NodeFunction_NodeBase {
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

      public c_v2_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public c_v2_2() {
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
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Complex r = new Complex ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius . x * i * 0.005 + x1 ; double newy = radius . y * j * 0.005 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Complex)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_c x = (Estimate_c)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class col_2 extends NodeFunction_NodeBase {
      private static final double radius = 0.005 ;
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Color.class;
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

      public col_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public col_2() {
         this(null);
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Color r = new Color ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Color)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_col x = (Estimate_col)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class col_d_2 extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Color.class;
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

      public col_d_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public col_d_2() {
         this(null);
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lradius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lradius = (LDouble)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; double radius = lradius . val * 0.005 ; Color r = new Color ( ) ; if ( radius == 0 ) { x . setContext ( new ContextXY ( x1 , y1 ) ) ; return ((Color)x.evaluate()) ; } for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius * i + x1 ; double newy = radius * j + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Color)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lradius = (Estimate_d)inputs[0]; 
         Estimate_col x = (Estimate_col)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class col_v2_2 extends NodeFunction_NodeBase {
      public int getNumberSubnodes() {
         return 1;
      }

      public Class getNodeBaseClass(int i) {
         if(i == 0) return Color.class;
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

      public col_v2_2(NodeFunctionFactory nff) {
         super(nff);
      }

      public col_v2_2() {
         this(null);
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "radius";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d radius = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Color r = new Color ( ) ; for ( int i = - 2 ; i <= 2 ; i ++ ) for ( int j = - 2 ; j <= 2 ; j ++ ) { double newx = radius . x * i * 0.005 + x1 ; double newy = radius . y * j * 0.005 + y1 ; x . setContext ( new ContextXY ( newx , newy ) ) ; r . addv ( ((Color)x.evaluate()) ) ; } return r . mult ( 1.0 / 25 ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 radius = (Estimate_v2)inputs[0]; 
         Estimate_col x = (Estimate_col)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new d() );
      functions.add( new d_d() );
      functions.add( new d_v2() );
      functions.add( new v2() );
      functions.add( new v2_d() );
      functions.add( new v2_v2() );
      functions.add( new v3() );
      functions.add( new v3_d() );
      functions.add( new v3_v2() );
      functions.add( new c() );
      functions.add( new c_d() );
      functions.add( new c_v2() );
      functions.add( new col() );
      functions.add( new col_d() );
      functions.add( new col_v2() );
      functions.add( new d_2() );
      functions.add( new d_d_2() );
      functions.add( new d_v2_2() );
      functions.add( new v2_2() );
      functions.add( new v2_d_2() );
      functions.add( new v2_v2_2() );
      functions.add( new v3_2() );
      functions.add( new v3_d_2() );
      functions.add( new v3_v2_2() );
      functions.add( new c_2() );
      functions.add( new c_d_2() );
      functions.add( new c_v2_2() );
      functions.add( new col_2() );
      functions.add( new col_d_2() );
      functions.add( new col_v2_2() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == d.class)
          if(nff == null) return new d(); else return new d(nff);
      if(nfClass == d_d.class)
          if(nff == null) return new d_d(); else return new d_d(nff);
      if(nfClass == d_v2.class)
          if(nff == null) return new d_v2(); else return new d_v2(nff);
      if(nfClass == v2.class)
          if(nff == null) return new v2(); else return new v2(nff);
      if(nfClass == v2_d.class)
          if(nff == null) return new v2_d(); else return new v2_d(nff);
      if(nfClass == v2_v2.class)
          if(nff == null) return new v2_v2(); else return new v2_v2(nff);
      if(nfClass == v3.class)
          if(nff == null) return new v3(); else return new v3(nff);
      if(nfClass == v3_d.class)
          if(nff == null) return new v3_d(); else return new v3_d(nff);
      if(nfClass == v3_v2.class)
          if(nff == null) return new v3_v2(); else return new v3_v2(nff);
      if(nfClass == c.class)
          if(nff == null) return new c(); else return new c(nff);
      if(nfClass == c_d.class)
          if(nff == null) return new c_d(); else return new c_d(nff);
      if(nfClass == c_v2.class)
          if(nff == null) return new c_v2(); else return new c_v2(nff);
      if(nfClass == col.class)
          if(nff == null) return new col(); else return new col(nff);
      if(nfClass == col_d.class)
          if(nff == null) return new col_d(); else return new col_d(nff);
      if(nfClass == col_v2.class)
          if(nff == null) return new col_v2(); else return new col_v2(nff);
      if(nfClass == d_2.class)
          if(nff == null) return new d_2(); else return new d_2(nff);
      if(nfClass == d_d_2.class)
          if(nff == null) return new d_d_2(); else return new d_d_2(nff);
      if(nfClass == d_v2_2.class)
          if(nff == null) return new d_v2_2(); else return new d_v2_2(nff);
      if(nfClass == v2_2.class)
          if(nff == null) return new v2_2(); else return new v2_2(nff);
      if(nfClass == v2_d_2.class)
          if(nff == null) return new v2_d_2(); else return new v2_d_2(nff);
      if(nfClass == v2_v2_2.class)
          if(nff == null) return new v2_v2_2(); else return new v2_v2_2(nff);
      if(nfClass == v3_2.class)
          if(nff == null) return new v3_2(); else return new v3_2(nff);
      if(nfClass == v3_d_2.class)
          if(nff == null) return new v3_d_2(); else return new v3_d_2(nff);
      if(nfClass == v3_v2_2.class)
          if(nff == null) return new v3_v2_2(); else return new v3_v2_2(nff);
      if(nfClass == c_2.class)
          if(nff == null) return new c_2(); else return new c_2(nff);
      if(nfClass == c_d_2.class)
          if(nff == null) return new c_d_2(); else return new c_d_2(nff);
      if(nfClass == c_v2_2.class)
          if(nff == null) return new c_v2_2(); else return new c_v2_2(nff);
      if(nfClass == col_2.class)
          if(nff == null) return new col_2(); else return new col_2(nff);
      if(nfClass == col_d_2.class)
          if(nff == null) return new col_d_2(); else return new col_d_2(nff);
      if(nfClass == col_v2_2.class)
          if(nff == null) return new col_v2_2(); else return new col_v2_2(nff);
      return null;
   }

}
