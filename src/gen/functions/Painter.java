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

public class Painter implements FunctionGroup, java.io.Serializable {
   class Pure extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble h = (LDouble)inputs[0]; 
         return ColorPainter . getColor ( h . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d h = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HueSat extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble h = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         Color val = ColorPainter . getColor ( h . val ) ; Color compliment = ColorPainter . getColor ( h . val + .5 ) ; return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d h = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class HueSat_gauss extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble h = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         Color val = ColorPainter . getColor ( h . val ) ; Color compliment = ColorPainter . getColor ( h . val + .5 ) ; double sat = Math . exp ( - s . val * s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d h = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class HueSat_sigmoid extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble h = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         Color val = ColorPainter . getColor ( h . val ) ; Color compliment = ColorPainter . getColor ( h . val + .5 ) ; double sat = 1 / ( 1.0 + Math . exp ( - s . val ) ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d h = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class HueSat_gauss01 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble h = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         Color val = ColorPainter . getColor ( h . val ) ; Color compliment = ColorPainter . getColor ( h . val + .5 ) ; double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d h = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class HueSat_sigmoid01 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble h = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         Color val = ColorPainter . getColor ( h . val ) ; Color compliment = ColorPainter . getColor ( h . val + .5 ) ; double sat = .5 + .5 * 1 / ( 1.0 + Math . exp ( - s . val ) ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d h = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class HueSat_v2 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hs";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d hs = (LVect2d)inputs[0]; 
         Color val = ColorPainter . getColor ( hs . x ) ; Color compliment = ColorPainter . getColor ( hs . x + .5 ) ; return val . mult ( hs . y ) . add ( compliment . mult ( 1 - hs . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 hs = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HueSat_v2_gauss extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hs";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d hs = (LVect2d)inputs[0]; 
         Color val = ColorPainter . getColor ( hs . x ) ; Color compliment = ColorPainter . getColor ( hs . x + .5 ) ; double sat = Math . exp ( - hs . y * hs . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 hs = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HueSat_v2_sigmoid extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hs";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d hs = (LVect2d)inputs[0]; 
         Color val = ColorPainter . getColor ( hs . x ) ; Color compliment = ColorPainter . getColor ( hs . x + .5 ) ; double sat = 1 / ( 1.0 + Math . exp ( - hs . y ) ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 hs = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HueSat_v2_gauss01 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hs";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d hs = (LVect2d)inputs[0]; 
         Color val = ColorPainter . getColor ( hs . x ) ; Color compliment = ColorPainter . getColor ( hs . x + .5 ) ; double sat = .5 + .5 * Math . exp ( - hs . y * hs . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 hs = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

   }

   class HueSat_v2_sigmoid01 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hs";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d hs = (LVect2d)inputs[0]; 
         Color val = ColorPainter . getColor ( hs . x ) ; Color compliment = ColorPainter . getColor ( hs . x + .5 ) ; double sat = .5 + .5 / ( 1.0 + Math . exp ( - hs . y ) ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 hs = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

   }

   class Hue extends NodeFunction {
      private double s;
      public Hue() {
         s = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble h = (LDouble)inputs[0]; 
         Color val = ColorPainter . getColor ( h . val ) ; Color compliment = ColorPainter . getColor ( h . val + .5 ) ; return val . mult ( s ) . add ( compliment . mult ( 1 - s ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d h = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return s;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) s = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "s";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Sat extends NodeFunction {
      private double h;
      public Sat() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble s = (LDouble)inputs[0]; 
         Color val = ColorPainter . getColor ( h ) ; Color compliment = ColorPainter . getColor ( h + .5 ) ; return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d s = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Sat_sigmoid extends NodeFunction {
      private double h;
      public Sat_sigmoid() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble s = (LDouble)inputs[0]; 
         Color val = ColorPainter . getColor ( h ) ; Color compliment = ColorPainter . getColor ( h + .5 ) ; double sat = 1 / Math . exp ( 1 + s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d s = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Sat_gauss01 extends NodeFunction {
      private double h;
      public Sat_gauss01() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble s = (LDouble)inputs[0]; 
         Color val = ColorPainter . getColor ( h ) ; Color compliment = ColorPainter . getColor ( h + .5 ) ; double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d s = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Sat_near extends NodeFunction {
      private double h;
      private double offset;
      public Sat_near() {
         h = Math . random ( ) ; offset = Math . random ( ) / 3 - 1.0 / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble s = (LDouble)inputs[0]; 
         Color val = ColorPainter . getColor ( h ) ; Color compliment = ColorPainter . getColor ( h + .5 + offset ) ; return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d s = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return offset;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) offset = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "offset";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Sat_near_sigmoid extends NodeFunction {
      private double h;
      private double offset;
      public Sat_near_sigmoid() {
         h = Math . random ( ) ; offset = Math . random ( ) / 3 - 1.0 / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble s = (LDouble)inputs[0]; 
         Color val = ColorPainter . getColor ( h ) ; Color compliment = ColorPainter . getColor ( h + .5 + offset ) ; double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d s = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return offset;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) offset = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "offset";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Secondaries_h extends NodeFunction {
      private double h;
      private double s;
      public Secondaries_h() {
         h = Math . random ( ) ; s = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; return val . mult ( s ) . add ( compliment . mult ( 1 - s ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return s;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) s = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "s";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Secondaries_hs extends NodeFunction {
      private double h;
      public Secondaries_hs() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Secondaries_hs_gauss extends NodeFunction {
      private double h;
      public Secondaries_hs_gauss() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; double sat = Math . exp ( - s . val * s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Secondaries_hs_sigmoid extends NodeFunction {
      private double h;
      public Secondaries_hs_sigmoid() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; double sat = 1 / Math . exp ( 1 + s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Secondaries_hs_gauss01 extends NodeFunction {
      private double h;
      public Secondaries_hs_gauss01() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Secondaries_hs_sigmoid01 extends NodeFunction {
      private double h;
      public Secondaries_hs_sigmoid01() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; double sat = .5 + .5 * 1 / Math . exp ( 1 + s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Secondaries_hs_v2 extends NodeFunction {
      private double h;
      public Secondaries_hs_v2() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; return val . mult ( x . y ) . add ( compliment . mult ( 1 - x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Secondaries_hs_v2_gauss extends NodeFunction {
      private double h;
      public Secondaries_hs_v2_gauss() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; double sat = Math . exp ( - x . y * x . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Secondaries_hs_v2_sigmoid extends NodeFunction {
      private double h;
      public Secondaries_hs_v2_sigmoid() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; double sat = 1 / Math . exp ( 1 + x . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Secondaries_hs_v2_gauss01 extends NodeFunction {
      private double h;
      public Secondaries_hs_v2_gauss01() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; double sat = .5 + .5 * Math . exp ( - x . y * x . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Secondaries_hs_v2_sigmoid01 extends NodeFunction {
      private double h;
      public Secondaries_hs_v2_sigmoid01() {
         h = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + ( 1.0 / 6 ) * hue_bias + .5 ) ; double sat = .5 + .5 * 1 / Math . exp ( 1 + x . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class Arc_h extends NodeFunction {
      private double h;
      private double s;
      private double arc;
      public Arc_h() {
         h = Math . random ( ) ; s = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; return val . mult ( s ) . add ( compliment . mult ( 1 - s ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return s;
         if(i == 2) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) s = (Double)param;
         if(i == 2) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "s";
         if(i == 2) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return double.class;
         return null;
      }

   }

   class Arc_hs extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; return val . mult ( s . val ) . add ( compliment . mult ( 1 - s . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Arc_hs_gauss extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs_gauss() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; double sat = Math . exp ( - s . val * s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Arc_hs_sigmoid extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs_sigmoid() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; double sat = 1 / Math . exp ( 1 + s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Arc_hs_gauss01 extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs_gauss01() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; double sat = .5 + .5 * Math . exp ( - s . val * s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Arc_hs_sigmoid01 extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs_sigmoid01() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "hbias";
         if(i == 1) return "s";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble hbias = (LDouble)inputs[0]; 
         LDouble s = (LDouble)inputs[1]; 
         double hue_bias = Math . max ( Math . min ( hbias . val , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; double sat = .5 + .5 * 1 / Math . exp ( 1 + s . val ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d hbias = (Estimate_d)inputs[0]; 
         Estimate_d s = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Arc_hs_v2 extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs_v2() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; return val . mult ( x . y ) . add ( compliment . mult ( 1 - x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Arc_hs_v2_gauss extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs_v2_gauss() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; double sat = Math . exp ( - x . y * x . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Arc_hs_v2_sigmoid extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs_v2_sigmoid() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; double sat = 1 / Math . exp ( 1 + x . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Arc_hs_v2_gauss01 extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs_v2_gauss01() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; double sat = .5 + .5 * Math . exp ( - x . y * x . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Arc_hs_v2_sigmoid01 extends NodeFunction {
      private double h;
      private double arc;
      public Arc_hs_v2_sigmoid01() {
         h = Math . random ( ) ; arc = Math . random ( ) / 6 ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         double hue_bias = Math . max ( Math . min ( x . x , 1 ) , - 1 ) ; Color val = ColorPainter . getColor ( h + arc * hue_bias ) ; Color compliment = ColorPainter . getColor ( h + arc * hue_bias + .5 ) ; double sat = .5 + .5 * 1 / Math . exp ( 1 + x . y ) ; return val . mult ( sat ) . add ( compliment . mult ( 1 - sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return arc;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) arc = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "arc";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class Chord_h extends NodeFunction {
      private double h1;
      private double h2;
      public Chord_h() {
         h1 = Math . random ( ) ; h2 = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble v = (LDouble)inputs[0]; 
         Color v1 = ColorPainter . getColor ( h1 ) ; Color v2 = ColorPainter . getColor ( h2 ) ; return v1 . mult ( v . val ) . add ( v2 . mult ( 1 - v . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d v = (Estimate_d)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h1;
         if(i == 1) return h2;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h1 = (Double)param;
         if(i == 1) h2 = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h1";
         if(i == 1) return "h2";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class MotherColor extends NodeFunction {
      private double h;
      private double h0;
      public MotherColor() {
         h = Math . random ( ) ; h0 = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "u";
         if(i == 1) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble u = (LDouble)inputs[0]; 
         LDouble v = (LDouble)inputs[1]; 
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ; Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ; Color c3 = ColorPainter . getColor ( h + .5 ) ; Color c4 = c1 . mult ( u . val ) . add ( c2 . mult ( 1 - u . val ) ) ; return c4 . mult ( v . val ) . add ( c3 . mult ( 1 - v . val ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d u = (Estimate_d)inputs[0]; 
         Estimate_d v = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return h0;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) h0 = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "h0";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class MotherColor_gauss extends NodeFunction {
      private double h;
      private double h0;
      public MotherColor_gauss() {
         h = Math . random ( ) ; h0 = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "u";
         if(i == 1) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble u = (LDouble)inputs[0]; 
         LDouble v = (LDouble)inputs[1]; 
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ; Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ; Color c3 = ColorPainter . getColor ( h + .5 ) ; Color c4 = c1 . mult ( u . val ) . add ( c2 . mult ( 1 - u . val ) ) ; double sat = Math . exp ( - v . val * v . val ) ; return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d u = (Estimate_d)inputs[0]; 
         Estimate_d v = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return h0;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) h0 = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "h0";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class MotherColor_gauss1 extends NodeFunction {
      private double h;
      private double h0;
      public MotherColor_gauss1() {
         h = Math . random ( ) ; h0 = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "u";
         if(i == 1) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble u = (LDouble)inputs[0]; 
         LDouble v = (LDouble)inputs[1]; 
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ; Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ; Color c3 = ColorPainter . getColor ( h + .5 ) ; Color c4 = c1 . mult ( u . val ) . add ( c2 . mult ( 1 - u . val ) ) ; double sat = 1 - Math . exp ( - v . val * v . val ) ; return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d u = (Estimate_d)inputs[0]; 
         Estimate_d v = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return h0;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) h0 = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "h0";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class MotherColor_sigmoid extends NodeFunction {
      private double h;
      private double h0;
      public MotherColor_sigmoid() {
         h = Math . random ( ) ; h0 = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "u";
         if(i == 1) return "v";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble u = (LDouble)inputs[0]; 
         LDouble v = (LDouble)inputs[1]; 
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ; Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ; Color c3 = ColorPainter . getColor ( h + .5 ) ; Color c4 = c1 . mult ( u . val ) . add ( c2 . mult ( 1 - u . val ) ) ; double sat = 1 / Math . exp ( 1 + v . val ) ; return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d u = (Estimate_d)inputs[0]; 
         Estimate_d v = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return h0;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) h0 = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "h0";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class MotherColor_v2 extends NodeFunction {
      private double h;
      private double h0;
      public MotherColor_v2() {
         h = Math . random ( ) ; h0 = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ; Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ; Color c3 = ColorPainter . getColor ( h + .5 ) ; Color c4 = c1 . mult ( x . x ) . add ( c2 . mult ( 1 - x . x ) ) ; return c4 . mult ( x . y ) . add ( c3 . mult ( 1 - x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return h0;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) h0 = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "h0";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class MotherColor_v2_gauss extends NodeFunction {
      private double h;
      private double h0;
      public MotherColor_v2_gauss() {
         h = Math . random ( ) ; h0 = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ; Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ; Color c3 = ColorPainter . getColor ( h + .5 ) ; Color c4 = c1 . mult ( x . x ) . add ( c2 . mult ( 1 - x . x ) ) ; double sat = Math . exp ( - x . y * x . y ) ; return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return h0;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) h0 = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "h0";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class MotherColor_v2_gauss1 extends NodeFunction {
      private double h;
      private double h0;
      public MotherColor_v2_gauss1() {
         h = Math . random ( ) ; h0 = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ; Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ; Color c3 = ColorPainter . getColor ( h + .5 ) ; Color c4 = c1 . mult ( x . x ) . add ( c2 . mult ( 1 - x . x ) ) ; double sat = 1 - Math . exp ( - x . y * x . y ) ; return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return h0;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) h0 = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "h0";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   class MotherColor_v2_sigmoid extends NodeFunction {
      private double h;
      private double h0;
      public MotherColor_v2_sigmoid() {
         h = Math . random ( ) ; h0 = Math . random ( ) ;
      }

      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         Color c1 = ColorPainter . getColor ( h - h0 / 6 ) ; Color c2 = ColorPainter . getColor ( h + 1.0 / 6 - h0 / 6 ) ; Color c3 = ColorPainter . getColor ( h + .5 ) ; Color c4 = c1 . mult ( x . x ) . add ( c2 . mult ( 1 - x . x ) ) ; double sat = 1 / Math . exp ( 1 + x . y ) ; return c4 . mult ( sat ) . add ( c3 . mult ( sat ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         return new Estimate_col();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return h;
         if(i == 1) return h0;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) h = (Double)param;
         if(i == 1) h0 = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "h";
         if(i == 1) return "h0";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new Pure() );
      functions.add( new HueSat() );
      functions.add( new HueSat_gauss() );
      functions.add( new HueSat_sigmoid() );
      functions.add( new HueSat_gauss01() );
      functions.add( new HueSat_sigmoid01() );
      functions.add( new HueSat_v2() );
      functions.add( new HueSat_v2_gauss() );
      functions.add( new HueSat_v2_sigmoid() );
      functions.add( new HueSat_v2_gauss01() );
      functions.add( new HueSat_v2_sigmoid01() );
      functions.add( new Hue() );
      functions.add( new Sat() );
      functions.add( new Sat_sigmoid() );
      functions.add( new Sat_gauss01() );
      functions.add( new Sat_near() );
      functions.add( new Sat_near_sigmoid() );
      functions.add( new Secondaries_h() );
      functions.add( new Secondaries_hs() );
      functions.add( new Secondaries_hs_gauss() );
      functions.add( new Secondaries_hs_sigmoid() );
      functions.add( new Secondaries_hs_gauss01() );
      functions.add( new Secondaries_hs_sigmoid01() );
      functions.add( new Secondaries_hs_v2() );
      functions.add( new Secondaries_hs_v2_gauss() );
      functions.add( new Secondaries_hs_v2_sigmoid() );
      functions.add( new Secondaries_hs_v2_gauss01() );
      functions.add( new Secondaries_hs_v2_sigmoid01() );
      functions.add( new Arc_h() );
      functions.add( new Arc_hs() );
      functions.add( new Arc_hs_gauss() );
      functions.add( new Arc_hs_sigmoid() );
      functions.add( new Arc_hs_gauss01() );
      functions.add( new Arc_hs_sigmoid01() );
      functions.add( new Arc_hs_v2() );
      functions.add( new Arc_hs_v2_gauss() );
      functions.add( new Arc_hs_v2_sigmoid() );
      functions.add( new Arc_hs_v2_gauss01() );
      functions.add( new Arc_hs_v2_sigmoid01() );
      functions.add( new Chord_h() );
      functions.add( new MotherColor() );
      functions.add( new MotherColor_gauss() );
      functions.add( new MotherColor_gauss1() );
      functions.add( new MotherColor_sigmoid() );
      functions.add( new MotherColor_v2() );
      functions.add( new MotherColor_v2_gauss() );
      functions.add( new MotherColor_v2_gauss1() );
      functions.add( new MotherColor_v2_sigmoid() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Pure.class)
          return new Pure();
      if(nfClass == HueSat.class)
          return new HueSat();
      if(nfClass == HueSat_gauss.class)
          return new HueSat_gauss();
      if(nfClass == HueSat_sigmoid.class)
          return new HueSat_sigmoid();
      if(nfClass == HueSat_gauss01.class)
          return new HueSat_gauss01();
      if(nfClass == HueSat_sigmoid01.class)
          return new HueSat_sigmoid01();
      if(nfClass == HueSat_v2.class)
          return new HueSat_v2();
      if(nfClass == HueSat_v2_gauss.class)
          return new HueSat_v2_gauss();
      if(nfClass == HueSat_v2_sigmoid.class)
          return new HueSat_v2_sigmoid();
      if(nfClass == HueSat_v2_gauss01.class)
          return new HueSat_v2_gauss01();
      if(nfClass == HueSat_v2_sigmoid01.class)
          return new HueSat_v2_sigmoid01();
      if(nfClass == Hue.class)
          return new Hue();
      if(nfClass == Sat.class)
          return new Sat();
      if(nfClass == Sat_sigmoid.class)
          return new Sat_sigmoid();
      if(nfClass == Sat_gauss01.class)
          return new Sat_gauss01();
      if(nfClass == Sat_near.class)
          return new Sat_near();
      if(nfClass == Sat_near_sigmoid.class)
          return new Sat_near_sigmoid();
      if(nfClass == Secondaries_h.class)
          return new Secondaries_h();
      if(nfClass == Secondaries_hs.class)
          return new Secondaries_hs();
      if(nfClass == Secondaries_hs_gauss.class)
          return new Secondaries_hs_gauss();
      if(nfClass == Secondaries_hs_sigmoid.class)
          return new Secondaries_hs_sigmoid();
      if(nfClass == Secondaries_hs_gauss01.class)
          return new Secondaries_hs_gauss01();
      if(nfClass == Secondaries_hs_sigmoid01.class)
          return new Secondaries_hs_sigmoid01();
      if(nfClass == Secondaries_hs_v2.class)
          return new Secondaries_hs_v2();
      if(nfClass == Secondaries_hs_v2_gauss.class)
          return new Secondaries_hs_v2_gauss();
      if(nfClass == Secondaries_hs_v2_sigmoid.class)
          return new Secondaries_hs_v2_sigmoid();
      if(nfClass == Secondaries_hs_v2_gauss01.class)
          return new Secondaries_hs_v2_gauss01();
      if(nfClass == Secondaries_hs_v2_sigmoid01.class)
          return new Secondaries_hs_v2_sigmoid01();
      if(nfClass == Arc_h.class)
          return new Arc_h();
      if(nfClass == Arc_hs.class)
          return new Arc_hs();
      if(nfClass == Arc_hs_gauss.class)
          return new Arc_hs_gauss();
      if(nfClass == Arc_hs_sigmoid.class)
          return new Arc_hs_sigmoid();
      if(nfClass == Arc_hs_gauss01.class)
          return new Arc_hs_gauss01();
      if(nfClass == Arc_hs_sigmoid01.class)
          return new Arc_hs_sigmoid01();
      if(nfClass == Arc_hs_v2.class)
          return new Arc_hs_v2();
      if(nfClass == Arc_hs_v2_gauss.class)
          return new Arc_hs_v2_gauss();
      if(nfClass == Arc_hs_v2_sigmoid.class)
          return new Arc_hs_v2_sigmoid();
      if(nfClass == Arc_hs_v2_gauss01.class)
          return new Arc_hs_v2_gauss01();
      if(nfClass == Arc_hs_v2_sigmoid01.class)
          return new Arc_hs_v2_sigmoid01();
      if(nfClass == Chord_h.class)
          return new Chord_h();
      if(nfClass == MotherColor.class)
          return new MotherColor();
      if(nfClass == MotherColor_gauss.class)
          return new MotherColor_gauss();
      if(nfClass == MotherColor_gauss1.class)
          return new MotherColor_gauss1();
      if(nfClass == MotherColor_sigmoid.class)
          return new MotherColor_sigmoid();
      if(nfClass == MotherColor_v2.class)
          return new MotherColor_v2();
      if(nfClass == MotherColor_v2_gauss.class)
          return new MotherColor_v2_gauss();
      if(nfClass == MotherColor_v2_gauss1.class)
          return new MotherColor_v2_gauss1();
      if(nfClass == MotherColor_v2_sigmoid.class)
          return new MotherColor_v2_sigmoid();
      return null;
   }

}
