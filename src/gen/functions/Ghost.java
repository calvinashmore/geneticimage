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

public class Ghost implements FunctionGroup, java.io.Serializable {
   class d extends NodeFunction_NodeBase {
      private int ghosts;
      private double[] a;
      private double[] b;
      private double[] c;
      private double[] d;
      private double[] e;
      private double[] f;
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
         Random myRand = new Random ( ) ; ghosts = 2 + myRand . nextInt ( 3 ) ; a = new double [ ghosts ] ; b = new double [ ghosts ] ; c = new double [ ghosts ] ; d = new double [ ghosts ] ; e = new double [ ghosts ] ; f = new double [ ghosts ] ; for ( int i = 0 ; i < ghosts ; i ++ ) { a [ i ] = 2 * myRand . nextDouble ( ) - 1 ; b [ i ] = 2 * myRand . nextDouble ( ) - 1 ; c [ i ] = 2 * myRand . nextDouble ( ) - 1 ; d [ i ] = 2 * myRand . nextDouble ( ) - 1 ; e [ i ] = 10 * myRand . nextDouble ( ) - 5 ; f [ i ] = 10 * myRand . nextDouble ( ) - 5 ; }
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LDouble r = new LDouble ( ) ; for ( int i = 0 ; i < ghosts ; i ++ ) { x . setContext ( new ContextXY ( a [ i ] * x1 + b [ i ] * y1 + e [ i ] , c [ i ] * x1 + d [ i ] * y1 + f [ i ] ) ) ; r . addv ( ((LDouble)x.evaluate()) ) ; } return r . mult ( 1.0 / ghosts ) ;
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

      public int getNumberParameters() {
         return 7;
      }

      public Object getParameter(int i) {
         if(i == 0) return ghosts;
         if(i == 1) return a;
         if(i == 2) return b;
         if(i == 3) return c;
         if(i == 4) return d;
         if(i == 5) return e;
         if(i == 6) return f;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) ghosts = (Integer)param;
         if(i == 1) a = (double[])param;
         if(i == 2) b = (double[])param;
         if(i == 3) c = (double[])param;
         if(i == 4) d = (double[])param;
         if(i == 5) e = (double[])param;
         if(i == 6) f = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "ghosts";
         if(i == 1) return "a";
         if(i == 2) return "b";
         if(i == 3) return "c";
         if(i == 4) return "d";
         if(i == 5) return "e";
         if(i == 6) return "f";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         if(i == 3) return double[].class;
         if(i == 4) return double[].class;
         if(i == 5) return double[].class;
         if(i == 6) return double[].class;
         return null;
      }

   }

   class v2 extends NodeFunction_NodeBase {
      private int ghosts;
      private double[] a;
      private double[] b;
      private double[] c;
      private double[] d;
      private double[] e;
      private double[] f;
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
         Random myRand = new Random ( ) ; ghosts = 2 + myRand . nextInt ( 3 ) ; a = new double [ ghosts ] ; b = new double [ ghosts ] ; c = new double [ ghosts ] ; d = new double [ ghosts ] ; e = new double [ ghosts ] ; f = new double [ ghosts ] ; for ( int i = 0 ; i < ghosts ; i ++ ) { a [ i ] = 2 * myRand . nextDouble ( ) - 1 ; b [ i ] = 2 * myRand . nextDouble ( ) - 1 ; c [ i ] = 2 * myRand . nextDouble ( ) - 1 ; d [ i ] = 2 * myRand . nextDouble ( ) - 1 ; e [ i ] = 10 * myRand . nextDouble ( ) - 5 ; f [ i ] = 10 * myRand . nextDouble ( ) - 5 ; }
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect2d r = new LVect2d ( ) ; for ( int i = 0 ; i < ghosts ; i ++ ) { x . setContext ( new ContextXY ( a [ i ] * x1 + b [ i ] * y1 + e [ i ] , c [ i ] * x1 + d [ i ] * y1 + f [ i ] ) ) ; r . addv ( ((LVect2d)x.evaluate()) ) ; } return r . mult ( 1.0 / ghosts ) ;
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

      public int getNumberParameters() {
         return 7;
      }

      public Object getParameter(int i) {
         if(i == 0) return ghosts;
         if(i == 1) return a;
         if(i == 2) return b;
         if(i == 3) return c;
         if(i == 4) return d;
         if(i == 5) return e;
         if(i == 6) return f;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) ghosts = (Integer)param;
         if(i == 1) a = (double[])param;
         if(i == 2) b = (double[])param;
         if(i == 3) c = (double[])param;
         if(i == 4) d = (double[])param;
         if(i == 5) e = (double[])param;
         if(i == 6) f = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "ghosts";
         if(i == 1) return "a";
         if(i == 2) return "b";
         if(i == 3) return "c";
         if(i == 4) return "d";
         if(i == 5) return "e";
         if(i == 6) return "f";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         if(i == 3) return double[].class;
         if(i == 4) return double[].class;
         if(i == 5) return double[].class;
         if(i == 6) return double[].class;
         return null;
      }

   }

   class v3 extends NodeFunction_NodeBase {
      private int ghosts;
      private double[] a;
      private double[] b;
      private double[] c;
      private double[] d;
      private double[] e;
      private double[] f;
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
         Random myRand = new Random ( ) ; ghosts = 2 + myRand . nextInt ( 3 ) ; a = new double [ ghosts ] ; b = new double [ ghosts ] ; c = new double [ ghosts ] ; d = new double [ ghosts ] ; e = new double [ ghosts ] ; f = new double [ ghosts ] ; for ( int i = 0 ; i < ghosts ; i ++ ) { a [ i ] = 2 * myRand . nextDouble ( ) - 1 ; b [ i ] = 2 * myRand . nextDouble ( ) - 1 ; c [ i ] = 2 * myRand . nextDouble ( ) - 1 ; d [ i ] = 2 * myRand . nextDouble ( ) - 1 ; e [ i ] = 10 * myRand . nextDouble ( ) - 5 ; f [ i ] = 10 * myRand . nextDouble ( ) - 5 ; }
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; LVect3d r = new LVect3d ( ) ; for ( int i = 0 ; i < ghosts ; i ++ ) { x . setContext ( new ContextXY ( a [ i ] * x1 + b [ i ] * y1 + e [ i ] , c [ i ] * x1 + d [ i ] * y1 + f [ i ] ) ) ; r . addv ( ((LVect3d)x.evaluate()) ) ; } return r . mult ( 1.0 / ghosts ) ;
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

      public int getNumberParameters() {
         return 7;
      }

      public Object getParameter(int i) {
         if(i == 0) return ghosts;
         if(i == 1) return a;
         if(i == 2) return b;
         if(i == 3) return c;
         if(i == 4) return d;
         if(i == 5) return e;
         if(i == 6) return f;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) ghosts = (Integer)param;
         if(i == 1) a = (double[])param;
         if(i == 2) b = (double[])param;
         if(i == 3) c = (double[])param;
         if(i == 4) d = (double[])param;
         if(i == 5) e = (double[])param;
         if(i == 6) f = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "ghosts";
         if(i == 1) return "a";
         if(i == 2) return "b";
         if(i == 3) return "c";
         if(i == 4) return "d";
         if(i == 5) return "e";
         if(i == 6) return "f";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         if(i == 3) return double[].class;
         if(i == 4) return double[].class;
         if(i == 5) return double[].class;
         if(i == 6) return double[].class;
         return null;
      }

   }

   class col extends NodeFunction_NodeBase {
      private int ghosts;
      private double[] a;
      private double[] b;
      private double[] c;
      private double[] d;
      private double[] e;
      private double[] f;
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
         Random myRand = new Random ( ) ; ghosts = 2 + myRand . nextInt ( 3 ) ; a = new double [ ghosts ] ; b = new double [ ghosts ] ; c = new double [ ghosts ] ; d = new double [ ghosts ] ; e = new double [ ghosts ] ; f = new double [ ghosts ] ; for ( int i = 0 ; i < ghosts ; i ++ ) { a [ i ] = 2 * myRand . nextDouble ( ) - 1 ; b [ i ] = 2 * myRand . nextDouble ( ) - 1 ; c [ i ] = 2 * myRand . nextDouble ( ) - 1 ; d [ i ] = 2 * myRand . nextDouble ( ) - 1 ; e [ i ] = 10 * myRand . nextDouble ( ) - 5 ; f [ i ] = 10 * myRand . nextDouble ( ) - 5 ; }
      }

      public col() {
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
         if(i == 0) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d v = (LVect2d)inputs[0]; 
         Node x = getNode(0); 
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Color r = new Color ( ) ; for ( int i = 0 ; i < ghosts ; i ++ ) { x . setContext ( new ContextXY ( a [ i ] * x1 + b [ i ] * y1 + e [ i ] , c [ i ] * x1 + d [ i ] * y1 + f [ i ] ) ) ; r . addv ( ((Color)x.evaluate()) ) ; } return r . mult ( 1.0 / ghosts ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 v = (Estimate_v2)inputs[0]; 
         Estimate_col x = (Estimate_col)getEstimate(0); 
         return x ;
      }

      public String[] necessaryContext() {
         String s[] = {"x" , "y"};
         return s;
      }

      public int getNumberParameters() {
         return 7;
      }

      public Object getParameter(int i) {
         if(i == 0) return ghosts;
         if(i == 1) return a;
         if(i == 2) return b;
         if(i == 3) return c;
         if(i == 4) return d;
         if(i == 5) return e;
         if(i == 6) return f;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) ghosts = (Integer)param;
         if(i == 1) a = (double[])param;
         if(i == 2) b = (double[])param;
         if(i == 3) c = (double[])param;
         if(i == 4) d = (double[])param;
         if(i == 5) e = (double[])param;
         if(i == 6) f = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "ghosts";
         if(i == 1) return "a";
         if(i == 2) return "b";
         if(i == 3) return "c";
         if(i == 4) return "d";
         if(i == 5) return "e";
         if(i == 6) return "f";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         if(i == 3) return double[].class;
         if(i == 4) return double[].class;
         if(i == 5) return double[].class;
         if(i == 6) return double[].class;
         return null;
      }

   }

   class c extends NodeFunction_NodeBase {
      private int ghosts;
      private double[] a;
      private double[] b;
      private double[] c;
      private double[] d;
      private double[] e;
      private double[] f;
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
         Random myRand = new Random ( ) ; ghosts = 2 + myRand . nextInt ( 3 ) ; a = new double [ ghosts ] ; b = new double [ ghosts ] ; c = new double [ ghosts ] ; d = new double [ ghosts ] ; e = new double [ ghosts ] ; f = new double [ ghosts ] ; for ( int i = 0 ; i < ghosts ; i ++ ) { a [ i ] = 2 * myRand . nextDouble ( ) - 1 ; b [ i ] = 2 * myRand . nextDouble ( ) - 1 ; c [ i ] = 2 * myRand . nextDouble ( ) - 1 ; d [ i ] = 2 * myRand . nextDouble ( ) - 1 ; e [ i ] = 10 * myRand . nextDouble ( ) - 5 ; f [ i ] = 10 * myRand . nextDouble ( ) - 5 ; }
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
         double x1 = ( Double ) context . getVariable ( "x" ) ; double y1 = ( Double ) context . getVariable ( "y" ) ; Complex r = new Complex ( ) ; for ( int i = 0 ; i < ghosts ; i ++ ) { x . setContext ( new ContextXY ( a [ i ] * x1 + b [ i ] * y1 + e [ i ] , c [ i ] * x1 + d [ i ] * y1 + f [ i ] ) ) ; r . addv ( ((Complex)x.evaluate()) ) ; } return r . mult ( 1.0 / ghosts ) ;
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

      public int getNumberParameters() {
         return 7;
      }

      public Object getParameter(int i) {
         if(i == 0) return ghosts;
         if(i == 1) return a;
         if(i == 2) return b;
         if(i == 3) return c;
         if(i == 4) return d;
         if(i == 5) return e;
         if(i == 6) return f;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) ghosts = (Integer)param;
         if(i == 1) a = (double[])param;
         if(i == 2) b = (double[])param;
         if(i == 3) c = (double[])param;
         if(i == 4) d = (double[])param;
         if(i == 5) e = (double[])param;
         if(i == 6) f = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "ghosts";
         if(i == 1) return "a";
         if(i == 2) return "b";
         if(i == 3) return "c";
         if(i == 4) return "d";
         if(i == 5) return "e";
         if(i == 6) return "f";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         if(i == 3) return double[].class;
         if(i == 4) return double[].class;
         if(i == 5) return double[].class;
         if(i == 6) return double[].class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new d() );
      functions.add( new v2() );
      functions.add( new v3() );
      functions.add( new col() );
      functions.add( new c() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == d.class)
          if(nff == null) return new d(); else return new d(nff);
      if(nfClass == v2.class)
          if(nff == null) return new v2(); else return new v2(nff);
      if(nfClass == v3.class)
          if(nff == null) return new v3(); else return new v3(nff);
      if(nfClass == col.class)
          if(nff == null) return new col(); else return new col(nff);
      if(nfClass == c.class)
          if(nff == null) return new c(); else return new c(nff);
      return null;
   }

}
