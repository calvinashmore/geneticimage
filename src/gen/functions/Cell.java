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

public class Cell implements FunctionGroup, java.io.Serializable {
   class Cell_v3 extends NodeFunction {
      public Class getReturnClass() {
         return CellularResult.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CellularParams.class, CellularDistance.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "cp";
         if(i == 1) return "cd";
         if(i == 2) return "pos";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CellularParams cp = (CellularParams)inputs[0]; 
         CellularDistance cd = (CellularDistance)inputs[1]; 
         LVect3d pos = (LVect3d)inputs[2]; 
         Cellular cell = new Cellular ( cp , cd ) ; return cell . evaluate ( pos ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param cp = (Estimate_param)inputs[0]; 
         Estimate_param cd = (Estimate_param)inputs[1]; 
         Estimate_v3 pos = (Estimate_v3)inputs[2]; 
         return new Estimate_param();
      }

   }

   class Cell_v2 extends NodeFunction {
      public Class getReturnClass() {
         return CellularResult.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CellularParams.class, CellularDistance.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "cp";
         if(i == 1) return "cd";
         if(i == 2) return "pos";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CellularParams cp = (CellularParams)inputs[0]; 
         CellularDistance cd = (CellularDistance)inputs[1]; 
         LVect2d pos = (LVect2d)inputs[2]; 
         Cellular cell = new Cellular ( cp , cd ) ; return cell . evaluate ( new LVect3d ( pos . x , pos . y , 0 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param cp = (Estimate_param)inputs[0]; 
         Estimate_param cd = (Estimate_param)inputs[1]; 
         Estimate_v2 pos = (Estimate_v2)inputs[2]; 
         return new Estimate_param();
      }

   }

   class CellDistanceEuclidean extends NodeFunction {
      private CellularDistance dist ;
      public CellDistanceEuclidean() {
         dist = CellularDistance . getEuclidean ( ) ;
      }

      public Class getReturnClass() {
         return CellularDistance.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return dist ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( dist ) ;
      }

   }

   class CellDistanceManhattan extends NodeFunction {
      private CellularDistance dist ;
      public CellDistanceManhattan() {
         dist = CellularDistance . getManhattan ( ) ;
      }

      public Class getReturnClass() {
         return CellularDistance.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return dist ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( dist ) ;
      }

   }

   class CellDistanceEuclideanStretched extends NodeFunction {
      private CellularDistance dist ;
      private double stretchx;
      private double stretchy;
      private double stretchz;
      public CellDistanceEuclideanStretched() {
         stretchx = 3 * Math . random ( ) ; stretchy = 3 * Math . random ( ) ; stretchz = 3 * Math . random ( ) ; dist = CellularDistance . getEuclidean ( ) ;
      }

      public Class getReturnClass() {
         return CellularDistance.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return dist ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( dist ) ;
      }

      public void setup() {
         dist = CellularDistance . getEuclideanStretched ( stretchx , stretchy , stretchz ) ;
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return stretchx;
         if(i == 1) return stretchy;
         if(i == 2) return stretchz;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) stretchx = (Double)param;
         if(i == 1) stretchy = (Double)param;
         if(i == 2) stretchz = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "stretchx";
         if(i == 1) return "stretchy";
         if(i == 2) return "stretchz";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         return null;
      }

   }

   class CellDistanceHyperQuadratic extends NodeFunction {
      private CellularDistance dist ;
      private double xpow;
      private double ypow;
      private double zpow;
      public CellDistanceHyperQuadratic() {
         xpow = 3 * Math . random ( ) ; ypow = 3 * Math . random ( ) ; zpow = 3 * Math . random ( ) ; dist = CellularDistance . getEuclidean ( ) ;
      }

      public Class getReturnClass() {
         return CellularDistance.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return dist ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( dist ) ;
      }

      public void setup() {
         dist = CellularDistance . getEuclideanStretched ( xpow , ypow , zpow ) ;
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return xpow;
         if(i == 1) return ypow;
         if(i == 2) return zpow;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) xpow = (Double)param;
         if(i == 1) ypow = (Double)param;
         if(i == 2) zpow = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "xpow";
         if(i == 1) return "ypow";
         if(i == 2) return "zpow";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         return null;
      }

   }

   class CellParameters extends NodeFunction {
      private CellularParams cp ;
      private int max_order;
      private LVect3d translate;
      private double scale;
      public CellParameters() {
         translate = new LVect3d ( ) ; translate . x = Math . random ( ) * 100 - 50 ; translate . y = Math . random ( ) * 100 - 50 ; translate . z = Math . random ( ) * 100 - 50 ; scale = Math . random ( ) * 5 + 5 ; max_order = 4 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return CellularParams.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return cp ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( cp ) ;
      }

      public void setup() {
         cp = new CellularParams ( ) ; cp . translate = translate ; cp . scale . x = scale ; cp . scale . y = scale ; cp . scale . z = scale ; cp . max_order = max_order ;
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return max_order;
         if(i == 1) return translate;
         if(i == 2) return scale;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) max_order = (Integer)param;
         if(i == 1) translate = (LVect3d)param;
         if(i == 2) scale = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "max_order";
         if(i == 1) return "translate";
         if(i == 2) return "scale";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         if(i == 1) return LVect3d.class;
         if(i == 2) return double.class;
         return null;
      }

   }

   class CellResultDelta extends NodeFunction {
      private double[] coeff;
      public CellResultDelta() {
         coeff = new double [ 7 ] ; for ( int i = 0 ; i < 7 ; i ++ ) coeff [ i ] = Math . random ( ) * 2 - 1 ;
      }

      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CellularResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "cr";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CellularResult cr = (CellularResult)inputs[0]; 
         LVect3d r = new LVect3d ( ) ; for ( int i = 0 ; i < 7 ; i ++ ) r . addv ( cr . getDelta ( i ) . mult ( coeff [ i ] ) ) ; return r ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param cr = (Estimate_param)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return coeff;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) coeff = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "coeff";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         return null;
      }

   }

   class CellResult_c extends NodeFunction {
      private double[] coeff_x;
      private double[] coeff_y;
      public CellResult_c() {
         coeff_x = new double [ 7 ] ; coeff_y = new double [ 7 ] ; for ( int i = 0 ; i < 7 ; i ++ ) { coeff_x [ i ] = Math . random ( ) * 2 - 1 ; coeff_y [ i ] = Math . random ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CellularResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "cr";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CellularResult cr = (CellularResult)inputs[0]; 
         double r = 0 ; double p = 0 ; for ( int i = 0 ; i < 7 ; i ++ ) { r += cr . getF ( i ) * coeff_x [ i ] ; p += cr . getF ( i ) * coeff_y [ i ] ; } return new Complex ( r , p ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param cr = (Estimate_param)inputs[0]; 
         return new Estimate_c();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return coeff_x;
         if(i == 1) return coeff_y;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) coeff_x = (double[])param;
         if(i == 1) coeff_y = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "coeff_x";
         if(i == 1) return "coeff_y";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         return null;
      }

   }

   class CellResult_col extends NodeFunction {
      private double[] coeff_x;
      private double[] coeff_y;
      private double[] coeff_z;
      public CellResult_col() {
         coeff_x = new double [ 7 ] ; coeff_y = new double [ 7 ] ; coeff_z = new double [ 7 ] ; for ( int i = 0 ; i < 7 ; i ++ ) { coeff_x [ i ] = Math . random ( ) * 2 - 1 ; coeff_y [ i ] = Math . random ( ) * 2 - 1 ; coeff_z [ i ] = Math . random ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CellularResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "cr";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CellularResult cr = (CellularResult)inputs[0]; 
         double r = 0 ; double p = 0 ; double q = 0 ; for ( int i = 0 ; i < 7 ; i ++ ) { r += cr . getF ( i ) * coeff_x [ i ] ; p += cr . getF ( i ) * coeff_y [ i ] ; q += cr . getF ( i ) * coeff_z [ i ] ; } return new Color ( r , p , q ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param cr = (Estimate_param)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return coeff_x;
         if(i == 1) return coeff_y;
         if(i == 2) return coeff_z;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) coeff_x = (double[])param;
         if(i == 1) coeff_y = (double[])param;
         if(i == 2) coeff_z = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "coeff_x";
         if(i == 1) return "coeff_y";
         if(i == 2) return "coeff_z";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         if(i == 2) return double[].class;
         return null;
      }

   }

   class CellResult_d extends NodeFunction {
      private double[] coeff_x;
      public CellResult_d() {
         coeff_x = new double [ 7 ] ; for ( int i = 0 ; i < 7 ; i ++ ) { coeff_x [ i ] = Math . random ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CellularResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "cr";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CellularResult cr = (CellularResult)inputs[0]; 
         double r = 0 ; for ( int i = 0 ; i < 7 ; i ++ ) { r += cr . getF ( i ) * coeff_x [ i ] ; } return new LDouble ( r ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param cr = (Estimate_param)inputs[0]; 
         return new Estimate_d();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return coeff_x;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) coeff_x = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "coeff_x";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         return null;
      }

   }

   class CellResult_v2 extends NodeFunction {
      private double[] coeff_x;
      private double[] coeff_y;
      public CellResult_v2() {
         coeff_x = new double [ 7 ] ; coeff_y = new double [ 7 ] ; for ( int i = 0 ; i < 7 ; i ++ ) { coeff_x [ i ] = Math . random ( ) * 2 - 1 ; coeff_y [ i ] = Math . random ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CellularResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "cr";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CellularResult cr = (CellularResult)inputs[0]; 
         double r = 0 ; double p = 0 ; for ( int i = 0 ; i < 7 ; i ++ ) { r += cr . getF ( i ) * coeff_x [ i ] ; p += cr . getF ( i ) * coeff_y [ i ] ; } return new LVect2d ( r , p ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param cr = (Estimate_param)inputs[0]; 
         return new Estimate_v2();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return coeff_x;
         if(i == 1) return coeff_y;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) coeff_x = (double[])param;
         if(i == 1) coeff_y = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "coeff_x";
         if(i == 1) return "coeff_y";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double[].class;
         if(i == 1) return double[].class;
         return null;
      }

   }

   class CellResult_v3 extends NodeFunction {
      private double[] coeff_x;
      private double[] coeff_y;
      private double[] coeff_z;
      public CellResult_v3() {
         coeff_x = new double [ 7 ] ; coeff_y = new double [ 7 ] ; coeff_z = new double [ 7 ] ; for ( int i = 0 ; i < 7 ; i ++ ) { coeff_x [ i ] = Math . random ( ) * 2 - 1 ; coeff_y [ i ] = Math . random ( ) * 2 - 1 ; coeff_z [ i ] = Math . random ( ) * 2 - 1 ; }
      }

      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {CellularResult.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "cr";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         CellularResult cr = (CellularResult)inputs[0]; 
         double r = 0 ; double p = 0 ; double q = 0 ; for ( int i = 0 ; i < 7 ; i ++ ) { r += cr . getF ( i ) * coeff_x [ i ] ; p += cr . getF ( i ) * coeff_y [ i ] ; q += cr . getF ( i ) * coeff_z [ i ] ; } return new LVect3d ( r , p , q ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param cr = (Estimate_param)inputs[0]; 
         return new Estimate_v3();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return coeff_x;
         if(i == 1) return coeff_y;
         if(i == 2) return coeff_z;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) coeff_x = (double[])param;
         if(i == 1) coeff_y = (double[])param;
         if(i == 2) coeff_z = (double[])param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "coeff_x";
         if(i == 1) return "coeff_y";
         if(i == 2) return "coeff_z";
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
      functions.add( new Cell_v3() );
      functions.add( new Cell_v2() );
      functions.add( new CellDistanceEuclidean() );
      functions.add( new CellDistanceManhattan() );
      functions.add( new CellDistanceEuclideanStretched() );
      functions.add( new CellDistanceHyperQuadratic() );
      functions.add( new CellParameters() );
      functions.add( new CellResultDelta() );
      functions.add( new CellResult_c() );
      functions.add( new CellResult_col() );
      functions.add( new CellResult_d() );
      functions.add( new CellResult_v2() );
      functions.add( new CellResult_v3() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Cell_v3.class)
          return new Cell_v3();
      if(nfClass == Cell_v2.class)
          return new Cell_v2();
      if(nfClass == CellDistanceEuclidean.class)
          return new CellDistanceEuclidean();
      if(nfClass == CellDistanceManhattan.class)
          return new CellDistanceManhattan();
      if(nfClass == CellDistanceEuclideanStretched.class)
          return new CellDistanceEuclideanStretched();
      if(nfClass == CellDistanceHyperQuadratic.class)
          return new CellDistanceHyperQuadratic();
      if(nfClass == CellParameters.class)
          return new CellParameters();
      if(nfClass == CellResultDelta.class)
          return new CellResultDelta();
      if(nfClass == CellResult_c.class)
          return new CellResult_c();
      if(nfClass == CellResult_col.class)
          return new CellResult_col();
      if(nfClass == CellResult_d.class)
          return new CellResult_d();
      if(nfClass == CellResult_v2.class)
          return new CellResult_v2();
      if(nfClass == CellResult_v3.class)
          return new CellResult_v3();
      return null;
   }

}
