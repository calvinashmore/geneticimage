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

public class Warp implements FunctionGroup, java.io.Serializable {
   class v3warp extends NodeFunction {
      private double[] a;
      public v3warp() {
         Random myRand = new Random ( ) ; a = new double [ 6 ] ; for ( int i = 0 ; i < 6 ; i ++ ) a [ i ] = 2 * myRand . nextDouble ( ) - 1 ;
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; return new LVect3d ( x1 * a [ 0 ] + y1 * a [ 1 ] , x1 * a [ 2 ] + y1 * a [ 3 ] , x1 * a [ 4 ] + y1 * a [ 5 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_v3 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
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

   class v2warp extends NodeFunction {
      private double[] a;
      public v2warp() {
         Random myRand = new Random ( ) ; a = new double [ 4 ] ; for ( int i = 0 ; i < 4 ; i ++ ) a [ i ] = 2 * myRand . nextDouble ( ) - 1 ;
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; return new LVect2d ( x1 * a [ 0 ] + y1 * a [ 1 ] , x1 * a [ 2 ] + y1 * a [ 3 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_v2 ( ) ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
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

   class qwarp extends NodeFunction {
      private double[] a;
      public qwarp() {
         Random myRand = new Random ( ) ; a = new double [ 8 ] ; for ( int i = 0 ; i < 8 ; i ++ ) a [ i ] = 2 * myRand . nextDouble ( ) - 1 ;
      }

      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; return new Quaternion ( x1 * a [ 0 ] + y1 * a [ 1 ] , x1 * a [ 2 ] + y1 * a [ 3 ] , x1 * a [ 4 ] + y1 * a [ 5 ] , x1 * a [ 6 ] + y1 * a [ 7 ] ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_q();
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
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

   class d extends NodeFunction_NodeBase {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; x . setContext ( new ContextXY ( x1 + v . x , y1 + v . y ) ) ; return ((LDouble)x.evaluate()) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         Estimate_d x = (Estimate_d)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v2 extends NodeFunction_NodeBase {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; x . setContext ( new ContextXY ( x1 + v . x , y1 + v . y ) ) ; return ((LVect2d)x.evaluate()) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class v3 extends NodeFunction_NodeBase {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; x . setContext ( new ContextXY ( x1 + v . x , y1 + v . y ) ) ; return ((LVect3d)x.evaluate()) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   class c extends NodeFunction_NodeBase {
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; x . setContext ( new ContextXY ( x1 + v . x , y1 + v . y ) ) ; return ((Complex)x.evaluate()) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         Estimate_c x = (Estimate_c)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new v3warp() );
      functions.add( new v2warp() );
      functions.add( new qwarp() );
      functions.add( new d() );
      functions.add( new v2() );
      functions.add( new v3() );
      functions.add( new c() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == v3warp.class)
          return new v3warp();
      if(nfClass == v2warp.class)
          return new v2warp();
      if(nfClass == qwarp.class)
          return new qwarp();
      if(nfClass == d.class)
          if(nff == null) return new d(); else return new d(nff);
      if(nfClass == v2.class)
          if(nff == null) return new v2(); else return new v2(nff);
      if(nfClass == v3.class)
          if(nff == null) return new v3(); else return new v3(nff);
      if(nfClass == c.class)
          if(nff == null) return new c(); else return new c(nff);
      return null;
   }

}
