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
import utils.cellularautomata.*;

public class CellAutomata implements FunctionGroup, java.io.Serializable {
   class type0 extends NodeFunction {
      private transient Buffer_d data ; private double get ( int x , int y ) { return data . getValue ( ( x + data . getXRes ( ) ) % data . getXRes ( ) , y ) . val ; } private double evaluate1 ( int row , int pos ) { double in1 = get ( pos - 1 , row - 1 ) ; double in2 = get ( pos - 0 , row - 1 ) ; double in3 = get ( pos + 1 , row - 1 ) ; boolean bin1 = in1 == 1 ; boolean bin2 = in2 == 1 ; boolean bin3 = in3 == 1 ; if ( bin1 && bin2 && bin3 && ( ( code >> 0 ) & 1 ) == 1 ) return 1 ; if ( ! bin1 && bin2 && bin3 && ( ( code >> 1 ) & 1 ) == 1 ) return 1 ; if ( bin1 && ! bin2 && bin3 && ( ( code >> 2 ) & 1 ) == 1 ) return 1 ; if ( ! bin1 && ! bin2 && bin3 && ( ( code >> 3 ) & 1 ) == 1 ) return 1 ; if ( bin1 && bin2 && ! bin3 && ( ( code >> 4 ) & 1 ) == 1 ) return 1 ; if ( ! bin1 && bin2 && ! bin3 && ( ( code >> 5 ) & 1 ) == 1 ) return 1 ; if ( bin1 && ! bin2 && ! bin3 && ( ( code >> 6 ) & 1 ) == 1 ) return 1 ; if ( ! bin1 && ! bin2 && ! bin3 && ( ( code >> 7 ) & 1 ) == 1 ) return 1 ; return 0 ; }
      private int code;
      private int size;
      public Class getReturnClass() {
         return Buffer_d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return data ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

      public void setup() {
         if ( data != null || ! parametersChanged ( ) ) return ; Random rand = new Random ( ) ; if ( data == null ) { if ( size == 0 ) { size = 50 + rand . nextInt ( 200 ) ; code = rand . nextInt ( 256 ) ; } } data = new Buffer_d ( size , size ) ; setParametersChanged ( false ) ; for ( int x = 0 ; x < data . getXRes ( ) ; x ++ ) data . setValue ( x , 0 , new LDouble ( rand . nextInt ( 2 ) ) ) ; for ( int y = 1 ; y < data . getYRes ( ) ; y ++ ) for ( int x = 0 ; x < data . getXRes ( ) ; x ++ ) data . setValue ( x , y , new LDouble ( evaluate1 ( y , x ) ) ) ;
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return code;
         if(i == 1) return size;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) code = (Integer)param;
         if(i == 1) size = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "code";
         if(i == 1) return "size";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class type1 extends NodeFunction {
      private int tempColors ; private int tempInputs ; private transient Buffer_d data ;
      private CellularAutomata1d ca;
      private int size;
      public type1() {
         Random rand = new Random ( ) ; tempColors = 2 + rand . nextInt ( 4 ) ; tempInputs = 2 + rand . nextInt ( 4 ) ; size = 10 + rand . nextInt ( 300 ) ;
      }

      public Class getReturnClass() {
         return Buffer_d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return data ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

      public void setup() {
         if ( data != null ) return ; data = new Buffer_d ( size , size ) ; if ( ca == null ) ca = new CellularAutomata1d ( data , tempInputs , tempColors ) ; else { ca . data = data ; ca . fill ( ) ; }
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return ca;
         if(i == 1) return size;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) ca = (CellularAutomata1d)param;
         if(i == 1) size = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "ca";
         if(i == 1) return "size";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return CellularAutomata1d.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class type1_2 extends NodeFunction {
      private int tempColors ; private int tempInputs ; private transient Buffer_d data ;
      private CellularAutomata1d2 ca;
      private int size;
      public type1_2() {
         Random rand = new Random ( ) ; tempColors = 2 + rand . nextInt ( 3 ) ; tempInputs = 2 + rand . nextInt ( 4 ) ; size = 10 + rand . nextInt ( 300 ) ;
      }

      public Class getReturnClass() {
         return Buffer_d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return data ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

      public void setup() {
         if ( data != null ) return ; data = new Buffer_d ( size , size ) ; if ( ca == null ) ca = new CellularAutomata1d2 ( data , tempInputs , tempColors ) ; else { ca . data = data ; ca . fill ( ) ; }
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return ca;
         if(i == 1) return size;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) ca = (CellularAutomata1d2)param;
         if(i == 1) size = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "ca";
         if(i == 1) return "size";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return CellularAutomata1d2.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class type2 extends NodeFunction {
      private int tempInputs ; private transient Buffer_d data ;
      private CellularAutomata1d_cont ca;
      private int size;
      public type2() {
         Random rand = new Random ( ) ; tempInputs = 2 + rand . nextInt ( 5 ) ; size = 10 + rand . nextInt ( 300 ) ;
      }

      public Class getReturnClass() {
         return Buffer_d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return data ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

      public void setup() {
         if ( data != null ) return ; data = new Buffer_d ( size , size ) ; if ( ca == null ) ca = new CellularAutomata1d_cont ( data , tempInputs ) ; else { ca . data = data ; ca . fill ( ) ; }
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return ca;
         if(i == 1) return size;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) ca = (CellularAutomata1d_cont)param;
         if(i == 1) size = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "ca";
         if(i == 1) return "size";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return CellularAutomata1d_cont.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class type2_2 extends NodeFunction {
      private int tempInputs ; private transient Buffer_d data ;
      private CellularAutomata1d2_cont ca;
      private int size;
      public type2_2() {
         Random rand = new Random ( ) ; tempInputs = 2 + rand . nextInt ( 5 ) ; size = 10 + rand . nextInt ( 300 ) ;
      }

      public Class getReturnClass() {
         return Buffer_d.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return data ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( null ) ;
      }

      public void setup() {
         if ( data != null ) return ; data = new Buffer_d ( size , size ) ; if ( ca == null ) ca = new CellularAutomata1d2_cont ( data , tempInputs ) ; else { ca . data = data ; ca . fill ( ) ; }
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return ca;
         if(i == 1) return size;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) ca = (CellularAutomata1d2_cont)param;
         if(i == 1) size = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "ca";
         if(i == 1) return "size";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return CellularAutomata1d2_cont.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new type0() );
      functions.add( new type1() );
      functions.add( new type1_2() );
      functions.add( new type2() );
      functions.add( new type2_2() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == type0.class)
          return new type0();
      if(nfClass == type1.class)
          return new type1();
      if(nfClass == type1_2.class)
          return new type1_2();
      if(nfClass == type2.class)
          return new type2();
      if(nfClass == type2_2.class)
          return new type2_2();
      return null;
   }

}
