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

public class Noise1 implements FunctionGroup, java.io.Serializable {
   class Noise_d_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new LDouble ( noise . noise ( x . val , 0 , 0 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_d();
      }

   }

   class Noise_d_d_n extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new LDouble ( noise . noise ( x . val , 0 , 0 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_d();
      }

   }

   class Noise_d_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new LVect2d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class Noise_d_v2_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new LVect2d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class Noise_d_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new Complex ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_c();
      }

   }

   class Noise_d_c_n extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new Complex ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_c();
      }

   }

   class Noise_d_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new LVect3d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class Noise_d_v3_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new LVect3d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class Noise_d_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new Color ( .5 + .5 * noise . noise ( x . val , 0 , 0 ) , .5 + .5 * noise . noise ( x . val + 100 , 100 , 100 ) , .5 + .5 * noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_d_col_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new Color ( .5 + .5 * noise . noise ( x . val , 0 , 0 ) , .5 + .5 * noise . noise ( x . val + 100 , 100 , 100 ) , .5 + .5 * noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_d_col1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return Color . makeHSB ( noise . noise ( x . val , 0 , 0 ) , .5 + .5 * noise . noise ( x . val + 100 , 100 , 100 ) , .5 + .5 * noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_d_col1_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         LVect3d v = new LVect3d ( noise . noise ( x . val , 0 , 0 ) , .5 + .5 * noise . noise ( x . val + 100 , 100 , 100 ) , .5 + .5 * noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_d_colA extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new Color ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_d_colA_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return new Color ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_d_col1A extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         return Color . makeHSB ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_d_col1A_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LDouble x = (LDouble)inputs[1]; 
         LVect3d v = new LVect3d ( noise . noise ( x . val , 0 , 0 ) , noise . noise ( x . val + 100 , 100 , 100 ) , noise . noise ( x . val + 300 , 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_d x = (Estimate_d)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v2_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new LDouble ( noise . noise ( x . x , x . y , 0 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

   }

   class Noise_v2_d_n extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new LDouble ( noise . noise ( x . x , x . y , 0 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_d();
      }

   }

   class Noise_v2_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new LVect2d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class Noise_v2_v2_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new LVect2d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class Noise_v2_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new Complex ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_c();
      }

   }

   class Noise_v2_c_n extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new Complex ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_c();
      }

   }

   class Noise_v2_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class Noise_v2_v3_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class Noise_v2_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v2_col_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v2_col1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return Color . makeHSB ( noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v2_col1_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v2_colA extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new Color ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v2_colA_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return new Color ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v2_col1A extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         return Color . makeHSB ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v2_col1A_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect2d x = (LVect2d)inputs[1]; 
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v2 x = (Estimate_v2)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_c_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new LDouble ( noise . noise ( x . x , x . y , 0 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_d();
      }

   }

   class Noise_c_d_n extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new LDouble ( noise . noise ( x . x , x . y , 0 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_d();
      }

   }

   class Noise_c_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new LVect2d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class Noise_c_v2_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new LVect2d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class Noise_c_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new Complex ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_c();
      }

   }

   class Noise_c_c_n extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new Complex ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_c();
      }

   }

   class Noise_c_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class Noise_c_v3_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class Noise_c_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_c_col_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_c_col1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return Color . makeHSB ( noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_c_col1_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , 0 ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_c_colA extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new Color ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_c_colA_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return new Color ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_c_col1A extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         return Color . makeHSB ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_c_col1A_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         Complex x = (Complex)inputs[1]; 
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , 0 ) , noise . noise ( x . x + 100 , x . y + 100 , 100 ) , noise . noise ( x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_c x = (Estimate_c)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v3_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new LDouble ( noise . noise ( x . x , x . y , x . z ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_d();
      }

   }

   class Noise_v3_d_n extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new LDouble ( noise . noise ( x . x , x . y , x . z ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_d();
      }

   }

   class Noise_v3_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new LVect2d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class Noise_v3_v2_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new LVect2d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class Noise_v3_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new Complex ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_c();
      }

   }

   class Noise_v3_c_n extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new Complex ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_c();
      }

   }

   class Noise_v3_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new LVect3d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class Noise_v3_v3_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new LVect3d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class Noise_v3_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , x . z ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v3_col_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new Color ( .5 + .5 * noise . noise ( x . x , x . y , x . z ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v3_col1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return Color . makeHSB ( noise . noise ( x . x , x . y , x . z ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v3_col1_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , x . z ) , .5 + .5 * noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v3_colA extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new Color ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v3_colA_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return new Color ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v3_col1A extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         return Color . makeHSB ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Noise_v3_col1A_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         LVect3d x = (LVect3d)inputs[1]; 
         LVect3d v = new LVect3d ( noise . noise ( x . x , x . y , x . z ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_v3 x = (Estimate_v3)inputs[1]; 
         return new Estimate_col();
      }

   }

   class Fractal_d_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new LDouble ( fractal . evalFractal ( noise , x . val , 0 , 0 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Fractal_d_d_n extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new LDouble ( fractal . evalFractal ( noise , x . val , 0 , 0 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Fractal_d_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new LVect2d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Fractal_d_v2_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new LVect2d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Fractal_d_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new Complex ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_c();
      }

   }

   class Fractal_d_c_n extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new Complex ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_c();
      }

   }

   class Fractal_d_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new LVect3d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Fractal_d_v3_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new LVect3d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Fractal_d_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . val , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_d_col_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . val , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_d_col1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return Color . makeHSB ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_d_col1_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_d_colA extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new Color ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_d_colA_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return new Color ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_d_col1A extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         return Color . makeHSB ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_d_col1A_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LDouble x = (LDouble)inputs[2]; 
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . val , 0 , 0 ) , fractal . evalFractal ( noise , x . val + 100 , 100 , 100 ) , fractal . evalFractal ( noise , x . val + 300 , 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_d x = (Estimate_d)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v2_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , 0 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Fractal_v2_d_n extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , 0 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Fractal_v2_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Fractal_v2_v2_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Fractal_v2_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_c();
      }

   }

   class Fractal_v2_c_n extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_c();
      }

   }

   class Fractal_v2_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Fractal_v2_v3_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Fractal_v2_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v2_col_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v2_col1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v2_col1_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ; ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v2_colA extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v2_colA_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v2_col1A extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v2_col1A_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect2d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect2d x = (LVect2d)inputs[2]; 
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ; ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v2 x = (Estimate_v2)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_c_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , 0 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Fractal_c_d_n extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , 0 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Fractal_c_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Fractal_c_v2_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Fractal_c_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_c();
      }

   }

   class Fractal_c_c_n extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_c();
      }

   }

   class Fractal_c_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Fractal_c_v3_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Fractal_c_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_c_col_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_c_col1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_c_col1_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_c_colA extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_c_colA_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_c_col1A extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_c_col1A_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         Complex x = (Complex)inputs[2]; 
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_c x = (Estimate_c)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v3_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , x . z ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Fractal_v3_d_n extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new LDouble ( fractal . evalFractal ( noise , x . x , x . y , x . z ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_d();
      }

   }

   class Fractal_v3_v2 extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Fractal_v3_v2_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class Fractal_v3_c extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_c();
      }

   }

   class Fractal_v3_c_n extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new Complex ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_c();
      }

   }

   class Fractal_v3_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Fractal_v3_v3_n extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class Fractal_v3_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , x . z ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v3_col_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new Color ( .5 + .5 * fractal . evalFractal ( noise , x . x , x . y , x . z ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v3_col1 extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v3_col1_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , .5 + .5 * fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v3_colA extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v3_colA_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return new Color ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v3_col1A extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         return Color . makeHSB ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_col();
      }

   }

   class Fractal_v3_col1A_n extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {NoiseFunction.class, NoiseFractal.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "noise";
         if(i == 1) return "fractal";
         if(i == 2) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         NoiseFunction noise = (NoiseFunction)inputs[0]; 
         NoiseFractal fractal = (NoiseFractal)inputs[1]; 
         LVect3d x = (LVect3d)inputs[2]; 
         LVect3d v = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; return Color . makeHSB ( v . x , v . y , v . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param noise = (Estimate_param)inputs[0]; 
         Estimate_param fractal = (Estimate_param)inputs[1]; 
         Estimate_v3 x = (Estimate_v3)inputs[2]; 
         return new Estimate_col();
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new Noise_d_d() );
      functions.add( new Noise_d_d_n() );
      functions.add( new Noise_d_v2() );
      functions.add( new Noise_d_v2_n() );
      functions.add( new Noise_d_c() );
      functions.add( new Noise_d_c_n() );
      functions.add( new Noise_d_v3() );
      functions.add( new Noise_d_v3_n() );
      functions.add( new Noise_d_col() );
      functions.add( new Noise_d_col_n() );
      functions.add( new Noise_d_col1() );
      functions.add( new Noise_d_col1_n() );
      functions.add( new Noise_d_colA() );
      functions.add( new Noise_d_colA_n() );
      functions.add( new Noise_d_col1A() );
      functions.add( new Noise_d_col1A_n() );
      functions.add( new Noise_v2_d() );
      functions.add( new Noise_v2_d_n() );
      functions.add( new Noise_v2_v2() );
      functions.add( new Noise_v2_v2_n() );
      functions.add( new Noise_v2_c() );
      functions.add( new Noise_v2_c_n() );
      functions.add( new Noise_v2_v3() );
      functions.add( new Noise_v2_v3_n() );
      functions.add( new Noise_v2_col() );
      functions.add( new Noise_v2_col_n() );
      functions.add( new Noise_v2_col1() );
      functions.add( new Noise_v2_col1_n() );
      functions.add( new Noise_v2_colA() );
      functions.add( new Noise_v2_colA_n() );
      functions.add( new Noise_v2_col1A() );
      functions.add( new Noise_v2_col1A_n() );
      functions.add( new Noise_c_d() );
      functions.add( new Noise_c_d_n() );
      functions.add( new Noise_c_v2() );
      functions.add( new Noise_c_v2_n() );
      functions.add( new Noise_c_c() );
      functions.add( new Noise_c_c_n() );
      functions.add( new Noise_c_v3() );
      functions.add( new Noise_c_v3_n() );
      functions.add( new Noise_c_col() );
      functions.add( new Noise_c_col_n() );
      functions.add( new Noise_c_col1() );
      functions.add( new Noise_c_col1_n() );
      functions.add( new Noise_c_colA() );
      functions.add( new Noise_c_colA_n() );
      functions.add( new Noise_c_col1A() );
      functions.add( new Noise_c_col1A_n() );
      functions.add( new Noise_v3_d() );
      functions.add( new Noise_v3_d_n() );
      functions.add( new Noise_v3_v2() );
      functions.add( new Noise_v3_v2_n() );
      functions.add( new Noise_v3_c() );
      functions.add( new Noise_v3_c_n() );
      functions.add( new Noise_v3_v3() );
      functions.add( new Noise_v3_v3_n() );
      functions.add( new Noise_v3_col() );
      functions.add( new Noise_v3_col_n() );
      functions.add( new Noise_v3_col1() );
      functions.add( new Noise_v3_col1_n() );
      functions.add( new Noise_v3_colA() );
      functions.add( new Noise_v3_colA_n() );
      functions.add( new Noise_v3_col1A() );
      functions.add( new Noise_v3_col1A_n() );
      functions.add( new Fractal_d_d() );
      functions.add( new Fractal_d_d_n() );
      functions.add( new Fractal_d_v2() );
      functions.add( new Fractal_d_v2_n() );
      functions.add( new Fractal_d_c() );
      functions.add( new Fractal_d_c_n() );
      functions.add( new Fractal_d_v3() );
      functions.add( new Fractal_d_v3_n() );
      functions.add( new Fractal_d_col() );
      functions.add( new Fractal_d_col_n() );
      functions.add( new Fractal_d_col1() );
      functions.add( new Fractal_d_col1_n() );
      functions.add( new Fractal_d_colA() );
      functions.add( new Fractal_d_colA_n() );
      functions.add( new Fractal_d_col1A() );
      functions.add( new Fractal_d_col1A_n() );
      functions.add( new Fractal_v2_d() );
      functions.add( new Fractal_v2_d_n() );
      functions.add( new Fractal_v2_v2() );
      functions.add( new Fractal_v2_v2_n() );
      functions.add( new Fractal_v2_c() );
      functions.add( new Fractal_v2_c_n() );
      functions.add( new Fractal_v2_v3() );
      functions.add( new Fractal_v2_v3_n() );
      functions.add( new Fractal_v2_col() );
      functions.add( new Fractal_v2_col_n() );
      functions.add( new Fractal_v2_col1() );
      functions.add( new Fractal_v2_col1_n() );
      functions.add( new Fractal_v2_colA() );
      functions.add( new Fractal_v2_colA_n() );
      functions.add( new Fractal_v2_col1A() );
      functions.add( new Fractal_v2_col1A_n() );
      functions.add( new Fractal_c_d() );
      functions.add( new Fractal_c_d_n() );
      functions.add( new Fractal_c_v2() );
      functions.add( new Fractal_c_v2_n() );
      functions.add( new Fractal_c_c() );
      functions.add( new Fractal_c_c_n() );
      functions.add( new Fractal_c_v3() );
      functions.add( new Fractal_c_v3_n() );
      functions.add( new Fractal_c_col() );
      functions.add( new Fractal_c_col_n() );
      functions.add( new Fractal_c_col1() );
      functions.add( new Fractal_c_col1_n() );
      functions.add( new Fractal_c_colA() );
      functions.add( new Fractal_c_colA_n() );
      functions.add( new Fractal_c_col1A() );
      functions.add( new Fractal_c_col1A_n() );
      functions.add( new Fractal_v3_d() );
      functions.add( new Fractal_v3_d_n() );
      functions.add( new Fractal_v3_v2() );
      functions.add( new Fractal_v3_v2_n() );
      functions.add( new Fractal_v3_c() );
      functions.add( new Fractal_v3_c_n() );
      functions.add( new Fractal_v3_v3() );
      functions.add( new Fractal_v3_v3_n() );
      functions.add( new Fractal_v3_col() );
      functions.add( new Fractal_v3_col_n() );
      functions.add( new Fractal_v3_col1() );
      functions.add( new Fractal_v3_col1_n() );
      functions.add( new Fractal_v3_colA() );
      functions.add( new Fractal_v3_colA_n() );
      functions.add( new Fractal_v3_col1A() );
      functions.add( new Fractal_v3_col1A_n() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Noise_d_d.class)
          return new Noise_d_d();
      if(nfClass == Noise_d_d_n.class)
          return new Noise_d_d_n();
      if(nfClass == Noise_d_v2.class)
          return new Noise_d_v2();
      if(nfClass == Noise_d_v2_n.class)
          return new Noise_d_v2_n();
      if(nfClass == Noise_d_c.class)
          return new Noise_d_c();
      if(nfClass == Noise_d_c_n.class)
          return new Noise_d_c_n();
      if(nfClass == Noise_d_v3.class)
          return new Noise_d_v3();
      if(nfClass == Noise_d_v3_n.class)
          return new Noise_d_v3_n();
      if(nfClass == Noise_d_col.class)
          return new Noise_d_col();
      if(nfClass == Noise_d_col_n.class)
          return new Noise_d_col_n();
      if(nfClass == Noise_d_col1.class)
          return new Noise_d_col1();
      if(nfClass == Noise_d_col1_n.class)
          return new Noise_d_col1_n();
      if(nfClass == Noise_d_colA.class)
          return new Noise_d_colA();
      if(nfClass == Noise_d_colA_n.class)
          return new Noise_d_colA_n();
      if(nfClass == Noise_d_col1A.class)
          return new Noise_d_col1A();
      if(nfClass == Noise_d_col1A_n.class)
          return new Noise_d_col1A_n();
      if(nfClass == Noise_v2_d.class)
          return new Noise_v2_d();
      if(nfClass == Noise_v2_d_n.class)
          return new Noise_v2_d_n();
      if(nfClass == Noise_v2_v2.class)
          return new Noise_v2_v2();
      if(nfClass == Noise_v2_v2_n.class)
          return new Noise_v2_v2_n();
      if(nfClass == Noise_v2_c.class)
          return new Noise_v2_c();
      if(nfClass == Noise_v2_c_n.class)
          return new Noise_v2_c_n();
      if(nfClass == Noise_v2_v3.class)
          return new Noise_v2_v3();
      if(nfClass == Noise_v2_v3_n.class)
          return new Noise_v2_v3_n();
      if(nfClass == Noise_v2_col.class)
          return new Noise_v2_col();
      if(nfClass == Noise_v2_col_n.class)
          return new Noise_v2_col_n();
      if(nfClass == Noise_v2_col1.class)
          return new Noise_v2_col1();
      if(nfClass == Noise_v2_col1_n.class)
          return new Noise_v2_col1_n();
      if(nfClass == Noise_v2_colA.class)
          return new Noise_v2_colA();
      if(nfClass == Noise_v2_colA_n.class)
          return new Noise_v2_colA_n();
      if(nfClass == Noise_v2_col1A.class)
          return new Noise_v2_col1A();
      if(nfClass == Noise_v2_col1A_n.class)
          return new Noise_v2_col1A_n();
      if(nfClass == Noise_c_d.class)
          return new Noise_c_d();
      if(nfClass == Noise_c_d_n.class)
          return new Noise_c_d_n();
      if(nfClass == Noise_c_v2.class)
          return new Noise_c_v2();
      if(nfClass == Noise_c_v2_n.class)
          return new Noise_c_v2_n();
      if(nfClass == Noise_c_c.class)
          return new Noise_c_c();
      if(nfClass == Noise_c_c_n.class)
          return new Noise_c_c_n();
      if(nfClass == Noise_c_v3.class)
          return new Noise_c_v3();
      if(nfClass == Noise_c_v3_n.class)
          return new Noise_c_v3_n();
      if(nfClass == Noise_c_col.class)
          return new Noise_c_col();
      if(nfClass == Noise_c_col_n.class)
          return new Noise_c_col_n();
      if(nfClass == Noise_c_col1.class)
          return new Noise_c_col1();
      if(nfClass == Noise_c_col1_n.class)
          return new Noise_c_col1_n();
      if(nfClass == Noise_c_colA.class)
          return new Noise_c_colA();
      if(nfClass == Noise_c_colA_n.class)
          return new Noise_c_colA_n();
      if(nfClass == Noise_c_col1A.class)
          return new Noise_c_col1A();
      if(nfClass == Noise_c_col1A_n.class)
          return new Noise_c_col1A_n();
      if(nfClass == Noise_v3_d.class)
          return new Noise_v3_d();
      if(nfClass == Noise_v3_d_n.class)
          return new Noise_v3_d_n();
      if(nfClass == Noise_v3_v2.class)
          return new Noise_v3_v2();
      if(nfClass == Noise_v3_v2_n.class)
          return new Noise_v3_v2_n();
      if(nfClass == Noise_v3_c.class)
          return new Noise_v3_c();
      if(nfClass == Noise_v3_c_n.class)
          return new Noise_v3_c_n();
      if(nfClass == Noise_v3_v3.class)
          return new Noise_v3_v3();
      if(nfClass == Noise_v3_v3_n.class)
          return new Noise_v3_v3_n();
      if(nfClass == Noise_v3_col.class)
          return new Noise_v3_col();
      if(nfClass == Noise_v3_col_n.class)
          return new Noise_v3_col_n();
      if(nfClass == Noise_v3_col1.class)
          return new Noise_v3_col1();
      if(nfClass == Noise_v3_col1_n.class)
          return new Noise_v3_col1_n();
      if(nfClass == Noise_v3_colA.class)
          return new Noise_v3_colA();
      if(nfClass == Noise_v3_colA_n.class)
          return new Noise_v3_colA_n();
      if(nfClass == Noise_v3_col1A.class)
          return new Noise_v3_col1A();
      if(nfClass == Noise_v3_col1A_n.class)
          return new Noise_v3_col1A_n();
      if(nfClass == Fractal_d_d.class)
          return new Fractal_d_d();
      if(nfClass == Fractal_d_d_n.class)
          return new Fractal_d_d_n();
      if(nfClass == Fractal_d_v2.class)
          return new Fractal_d_v2();
      if(nfClass == Fractal_d_v2_n.class)
          return new Fractal_d_v2_n();
      if(nfClass == Fractal_d_c.class)
          return new Fractal_d_c();
      if(nfClass == Fractal_d_c_n.class)
          return new Fractal_d_c_n();
      if(nfClass == Fractal_d_v3.class)
          return new Fractal_d_v3();
      if(nfClass == Fractal_d_v3_n.class)
          return new Fractal_d_v3_n();
      if(nfClass == Fractal_d_col.class)
          return new Fractal_d_col();
      if(nfClass == Fractal_d_col_n.class)
          return new Fractal_d_col_n();
      if(nfClass == Fractal_d_col1.class)
          return new Fractal_d_col1();
      if(nfClass == Fractal_d_col1_n.class)
          return new Fractal_d_col1_n();
      if(nfClass == Fractal_d_colA.class)
          return new Fractal_d_colA();
      if(nfClass == Fractal_d_colA_n.class)
          return new Fractal_d_colA_n();
      if(nfClass == Fractal_d_col1A.class)
          return new Fractal_d_col1A();
      if(nfClass == Fractal_d_col1A_n.class)
          return new Fractal_d_col1A_n();
      if(nfClass == Fractal_v2_d.class)
          return new Fractal_v2_d();
      if(nfClass == Fractal_v2_d_n.class)
          return new Fractal_v2_d_n();
      if(nfClass == Fractal_v2_v2.class)
          return new Fractal_v2_v2();
      if(nfClass == Fractal_v2_v2_n.class)
          return new Fractal_v2_v2_n();
      if(nfClass == Fractal_v2_c.class)
          return new Fractal_v2_c();
      if(nfClass == Fractal_v2_c_n.class)
          return new Fractal_v2_c_n();
      if(nfClass == Fractal_v2_v3.class)
          return new Fractal_v2_v3();
      if(nfClass == Fractal_v2_v3_n.class)
          return new Fractal_v2_v3_n();
      if(nfClass == Fractal_v2_col.class)
          return new Fractal_v2_col();
      if(nfClass == Fractal_v2_col_n.class)
          return new Fractal_v2_col_n();
      if(nfClass == Fractal_v2_col1.class)
          return new Fractal_v2_col1();
      if(nfClass == Fractal_v2_col1_n.class)
          return new Fractal_v2_col1_n();
      if(nfClass == Fractal_v2_colA.class)
          return new Fractal_v2_colA();
      if(nfClass == Fractal_v2_colA_n.class)
          return new Fractal_v2_colA_n();
      if(nfClass == Fractal_v2_col1A.class)
          return new Fractal_v2_col1A();
      if(nfClass == Fractal_v2_col1A_n.class)
          return new Fractal_v2_col1A_n();
      if(nfClass == Fractal_c_d.class)
          return new Fractal_c_d();
      if(nfClass == Fractal_c_d_n.class)
          return new Fractal_c_d_n();
      if(nfClass == Fractal_c_v2.class)
          return new Fractal_c_v2();
      if(nfClass == Fractal_c_v2_n.class)
          return new Fractal_c_v2_n();
      if(nfClass == Fractal_c_c.class)
          return new Fractal_c_c();
      if(nfClass == Fractal_c_c_n.class)
          return new Fractal_c_c_n();
      if(nfClass == Fractal_c_v3.class)
          return new Fractal_c_v3();
      if(nfClass == Fractal_c_v3_n.class)
          return new Fractal_c_v3_n();
      if(nfClass == Fractal_c_col.class)
          return new Fractal_c_col();
      if(nfClass == Fractal_c_col_n.class)
          return new Fractal_c_col_n();
      if(nfClass == Fractal_c_col1.class)
          return new Fractal_c_col1();
      if(nfClass == Fractal_c_col1_n.class)
          return new Fractal_c_col1_n();
      if(nfClass == Fractal_c_colA.class)
          return new Fractal_c_colA();
      if(nfClass == Fractal_c_colA_n.class)
          return new Fractal_c_colA_n();
      if(nfClass == Fractal_c_col1A.class)
          return new Fractal_c_col1A();
      if(nfClass == Fractal_c_col1A_n.class)
          return new Fractal_c_col1A_n();
      if(nfClass == Fractal_v3_d.class)
          return new Fractal_v3_d();
      if(nfClass == Fractal_v3_d_n.class)
          return new Fractal_v3_d_n();
      if(nfClass == Fractal_v3_v2.class)
          return new Fractal_v3_v2();
      if(nfClass == Fractal_v3_v2_n.class)
          return new Fractal_v3_v2_n();
      if(nfClass == Fractal_v3_c.class)
          return new Fractal_v3_c();
      if(nfClass == Fractal_v3_c_n.class)
          return new Fractal_v3_c_n();
      if(nfClass == Fractal_v3_v3.class)
          return new Fractal_v3_v3();
      if(nfClass == Fractal_v3_v3_n.class)
          return new Fractal_v3_v3_n();
      if(nfClass == Fractal_v3_col.class)
          return new Fractal_v3_col();
      if(nfClass == Fractal_v3_col_n.class)
          return new Fractal_v3_col_n();
      if(nfClass == Fractal_v3_col1.class)
          return new Fractal_v3_col1();
      if(nfClass == Fractal_v3_col1_n.class)
          return new Fractal_v3_col1_n();
      if(nfClass == Fractal_v3_colA.class)
          return new Fractal_v3_colA();
      if(nfClass == Fractal_v3_colA_n.class)
          return new Fractal_v3_colA_n();
      if(nfClass == Fractal_v3_col1A.class)
          return new Fractal_v3_col1A();
      if(nfClass == Fractal_v3_col1A_n.class)
          return new Fractal_v3_col1A_n();
      return null;
   }

}
