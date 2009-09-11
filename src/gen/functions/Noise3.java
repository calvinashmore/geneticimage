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

public class Noise3 implements FunctionGroup, java.io.Serializable {
   class fBm1 extends NodeFunction implements NoiseFractal {
      public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double value = 0 ; double x1 = x ; double y1 = y ; double z1 = z ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent ; } return value ; }
      private double lacunarity;
      private double exponent;
      private int octaves;
      public fBm1() {
         lacunarity = 1.5 + Math . random ( ) ; exponent = .1 + .7 * Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return exponent;
         if(i == 2) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) exponent = (Double)param;
         if(i == 2) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         if(i == 2) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return int.class;
         return null;
      }

   }

   class fBm2 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double value = 0 ; double x1 = x ; double y1 = y ; double z1 = z ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent1 ; } return value ; }
      private double lacunarity;
      private int octaves;
      public fBm2() {
         lacunarity = 1.5 + Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble exponent = (LDouble)inputs[0]; 
         exponent1 = exponent . val / 4 ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d exponent = (Estimate_d)inputs[0]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class fBm3 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; private double lacunarity1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double value = 0 ; double x1 = x ; double y1 = y ; double z1 = z ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity1 ; y1 *= lacunarity1 ; z1 *= lacunarity1 ; amplitude *= exponent1 ; } return value ; }
      private int octaves;
      public fBm3() {
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lacunarity = (LDouble)inputs[0]; 
         LDouble exponent = (LDouble)inputs[1]; 
         exponent1 = exponent . val / 4 ; lacunarity1 = lacunarity . val ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lacunarity = (Estimate_d)inputs[0]; 
         Estimate_d exponent = (Estimate_d)inputs[1]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         return null;
      }

   }

   class StatsByAlt1 extends NodeFunction implements NoiseFractal {
      public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { value += value * f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent ; } return value ; }
      private double lacunarity;
      private double exponent;
      private int octaves;
      public StatsByAlt1() {
         lacunarity = 1.5 + Math . random ( ) ; exponent = .1 + .7 * Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return exponent;
         if(i == 2) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) exponent = (Double)param;
         if(i == 2) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         if(i == 2) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return int.class;
         return null;
      }

   }

   class StatsByAlt2 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { value += value * f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent1 ; } return value ; }
      private double lacunarity;
      private int octaves;
      public StatsByAlt2() {
         lacunarity = 1.5 + Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble exponent = (LDouble)inputs[0]; 
         exponent1 = exponent . val / 4 ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d exponent = (Estimate_d)inputs[0]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class StatsByAlt3 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; private double lacunarity1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { value += value * f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity1 ; y1 *= lacunarity1 ; z1 *= lacunarity1 ; amplitude *= exponent1 ; } return value ; }
      private int octaves;
      public StatsByAlt3() {
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lacunarity = (LDouble)inputs[0]; 
         LDouble exponent = (LDouble)inputs[1]; 
         exponent1 = exponent . val / 4 ; lacunarity1 = lacunarity . val ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lacunarity = (Estimate_d)inputs[0]; 
         Estimate_d exponent = (Estimate_d)inputs[1]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         return null;
      }

   }

   class MultifractalA_1 extends NodeFunction implements NoiseFractal {
      public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent ; } return value ; }
      private double lacunarity;
      private double exponent;
      private int octaves;
      public MultifractalA_1() {
         lacunarity = 1.5 + Math . random ( ) ; exponent = .1 + .7 * Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return exponent;
         if(i == 2) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) exponent = (Double)param;
         if(i == 2) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         if(i == 2) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return int.class;
         return null;
      }

   }

   class MultifractalA_2 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity ; y1 *= lacunarity ; z1 *= lacunarity ; amplitude *= exponent1 ; } return value ; }
      private double lacunarity;
      private int octaves;
      public MultifractalA_2() {
         lacunarity = 1.5 + Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble exponent = (LDouble)inputs[0]; 
         exponent1 = exponent . val / 4 ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d exponent = (Estimate_d)inputs[0]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class MultifractalA_3 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; private double lacunarity1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity1 ; y1 *= lacunarity1 ; z1 *= lacunarity1 ; amplitude *= exponent1 ; } return value ; }
      private int octaves;
      public MultifractalA_3() {
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lacunarity = (LDouble)inputs[0]; 
         LDouble exponent = (LDouble)inputs[1]; 
         exponent1 = exponent . val / 4 ; lacunarity1 = lacunarity . val ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lacunarity = (Estimate_d)inputs[0]; 
         Estimate_d exponent = (Estimate_d)inputs[1]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         return null;
      }

   }

   class MultifractalB_1 extends NodeFunction implements NoiseFractal {
      public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity + signal ; y1 *= lacunarity + signal ; z1 *= lacunarity + signal ; amplitude *= exponent ; } return value ; }
      private double lacunarity;
      private double exponent;
      private int octaves;
      public MultifractalB_1() {
         lacunarity = 1.5 + Math . random ( ) ; exponent = .1 + .7 * Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return exponent;
         if(i == 2) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) exponent = (Double)param;
         if(i == 2) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         if(i == 2) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return int.class;
         return null;
      }

   }

   class MultifractalB_2 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity + signal ; y1 *= lacunarity + signal ; z1 *= lacunarity + signal ; amplitude *= exponent1 ; } return value ; }
      private double lacunarity;
      private int octaves;
      public MultifractalB_2() {
         lacunarity = 1.5 + Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble exponent = (LDouble)inputs[0]; 
         exponent1 = exponent . val / 4 ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d exponent = (Estimate_d)inputs[0]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class MultifractalB_3 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; private double lacunarity1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; double weight = 0 ; double signal = 0 ; weight = value = f . noise ( x1 , y1 , z1 ) ; for ( int i = 1 ; i < octaves ; i ++ ) { signal = f . noise ( x1 , y1 , z1 ) * amplitude ; value += weight * signal ; weight = signal ; x1 *= lacunarity1 + signal ; y1 *= lacunarity1 + signal ; z1 *= lacunarity1 + signal ; amplitude *= exponent1 ; } return value ; }
      private int octaves;
      public MultifractalB_3() {
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lacunarity = (LDouble)inputs[0]; 
         LDouble exponent = (LDouble)inputs[1]; 
         exponent1 = exponent . val / 4 ; lacunarity1 = lacunarity . val ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lacunarity = (Estimate_d)inputs[0]; 
         Estimate_d exponent = (Estimate_d)inputs[1]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         return null;
      }

   }

   class MultifractalC_1 extends NodeFunction implements NoiseFractal {
      public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity + value ; y1 *= lacunarity + value ; z1 *= lacunarity + value ; amplitude *= exponent ; } return value ; }
      private double lacunarity;
      private double exponent;
      private int octaves;
      public MultifractalC_1() {
         lacunarity = 1.5 + Math . random ( ) ; exponent = .1 + .6 * Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 3;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return exponent;
         if(i == 2) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) exponent = (Double)param;
         if(i == 2) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         if(i == 2) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return double.class;
         if(i == 2) return int.class;
         return null;
      }

   }

   class MultifractalC_2 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity + value ; y1 *= lacunarity + value ; z1 *= lacunarity + value ; amplitude *= exponent1 ; } return value ; }
      private double lacunarity;
      private int octaves;
      public MultifractalC_2() {
         lacunarity = 1.5 + Math . random ( ) ; octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble exponent = (LDouble)inputs[0]; 
         exponent1 = exponent . val / 4 ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d exponent = (Estimate_d)inputs[0]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return lacunarity;
         if(i == 1) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) lacunarity = (Double)param;
         if(i == 1) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return int.class;
         return null;
      }

   }

   class MultifractalC_3 extends NodeFunction implements NoiseFractal {
      private double exponent1 ; private double lacunarity1 ; public double evalFractal ( NoiseFunction f , double x , double y , double z ) { double amplitude = 1 ; double x1 = x ; double y1 = y ; double z1 = z ; double value = 0 ; for ( int i = 0 ; i < octaves ; i ++ ) { value += f . noise ( x1 , y1 , z1 ) * amplitude ; x1 *= lacunarity1 + value ; y1 *= lacunarity1 + value ; z1 *= lacunarity1 + value ; amplitude *= exponent1 ; } return value ; }
      private int octaves;
      public MultifractalC_3() {
         octaves = 5 + new Random ( ) . nextInt ( 3 ) ;
      }

      public Class getReturnClass() {
         return NoiseFractal.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "lacunarity";
         if(i == 1) return "exponent";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble lacunarity = (LDouble)inputs[0]; 
         LDouble exponent = (LDouble)inputs[1]; 
         exponent1 = exponent . val / 4 ; lacunarity1 = lacunarity . val ; return this ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d lacunarity = (Estimate_d)inputs[0]; 
         Estimate_d exponent = (Estimate_d)inputs[1]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return octaves;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) octaves = (Integer)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "octaves";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return int.class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new fBm1() );
      functions.add( new fBm2() );
      functions.add( new fBm3() );
      functions.add( new StatsByAlt1() );
      functions.add( new StatsByAlt2() );
      functions.add( new StatsByAlt3() );
      functions.add( new MultifractalA_1() );
      functions.add( new MultifractalA_2() );
      functions.add( new MultifractalA_3() );
      functions.add( new MultifractalB_1() );
      functions.add( new MultifractalB_2() );
      functions.add( new MultifractalB_3() );
      functions.add( new MultifractalC_1() );
      functions.add( new MultifractalC_2() );
      functions.add( new MultifractalC_3() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == fBm1.class)
          return new fBm1();
      if(nfClass == fBm2.class)
          return new fBm2();
      if(nfClass == fBm3.class)
          return new fBm3();
      if(nfClass == StatsByAlt1.class)
          return new StatsByAlt1();
      if(nfClass == StatsByAlt2.class)
          return new StatsByAlt2();
      if(nfClass == StatsByAlt3.class)
          return new StatsByAlt3();
      if(nfClass == MultifractalA_1.class)
          return new MultifractalA_1();
      if(nfClass == MultifractalA_2.class)
          return new MultifractalA_2();
      if(nfClass == MultifractalA_3.class)
          return new MultifractalA_3();
      if(nfClass == MultifractalB_1.class)
          return new MultifractalB_1();
      if(nfClass == MultifractalB_2.class)
          return new MultifractalB_2();
      if(nfClass == MultifractalB_3.class)
          return new MultifractalB_3();
      if(nfClass == MultifractalC_1.class)
          return new MultifractalC_1();
      if(nfClass == MultifractalC_2.class)
          return new MultifractalC_2();
      if(nfClass == MultifractalC_3.class)
          return new MultifractalC_3();
      return null;
   }

}
