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

public class Noise2 implements FunctionGroup, java.io.Serializable {
   class PerlinParameters1 extends NodeFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private LVect3d scale;
      private LVect3d translate;
      public PerlinParameters1() {
         translate = new LVect3d ( ) ; translate . x = Math . random ( ) * 100 - 50 ; translate . y = Math . random ( ) * 100 - 50 ; translate . z = Math . random ( ) * 100 - 50 ; scale = new LVect3d ( ) ; scale . x = 1 ; scale . y = 1 ; scale . z = 1 ;
      }

      public Class getReturnClass() {
         return PerlinNoiseParameters.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         params . scale = scale ; params . translate = translate ; return params ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return scale;
         if(i == 1) return translate;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scale = (LVect3d)param;
         if(i == 1) translate = (LVect3d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scale";
         if(i == 1) return "translate";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return LVect3d.class;
         if(i == 1) return LVect3d.class;
         return null;
      }

   }

   class PerlinParameters1a extends NodeFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private double scale;
      private LVect3d translate;
      public PerlinParameters1a() {
         translate = new LVect3d ( ) ; translate . x = Math . random ( ) * 100 - 50 ; translate . y = Math . random ( ) * 100 - 50 ; translate . z = Math . random ( ) * 100 - 50 ; scale = 1 ;
      }

      public Class getReturnClass() {
         return PerlinNoiseParameters.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         params . scale = new LVect3d ( scale , scale , scale ) ; params . translate = translate ; return params ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 2;
      }

      public Object getParameter(int i) {
         if(i == 0) return scale;
         if(i == 1) return translate;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scale = (Double)param;
         if(i == 1) translate = (LVect3d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scale";
         if(i == 1) return "translate";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         if(i == 1) return LVect3d.class;
         return null;
      }

   }

   class PerlinParameters2 extends NodeFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private LVect3d translate;
      public PerlinParameters2() {
         translate = new LVect3d ( ) ; translate . x = Math . random ( ) * 100 - 50 ; translate . y = Math . random ( ) * 100 - 50 ; translate . z = Math . random ( ) * 100 - 50 ;
      }

      public Class getReturnClass() {
         return PerlinNoiseParameters.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "scale";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d scale = (LVect3d)inputs[0]; 
         params . scale = scale ; params . translate = translate ; return params ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 scale = (Estimate_v3)inputs[0]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return translate;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) translate = (LVect3d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "translate";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return LVect3d.class;
         return null;
      }

   }

   class PerlinParameters2a extends NodeFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private LVect3d translate;
      public PerlinParameters2a() {
         translate = new LVect3d ( ) ; translate . x = Math . random ( ) * 100 - 50 ; translate . y = Math . random ( ) * 100 - 50 ; translate . z = Math . random ( ) * 100 - 50 ;
      }

      public Class getReturnClass() {
         return PerlinNoiseParameters.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "scale";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble scale = (LDouble)inputs[0]; 
         params . scale . x = scale . val ; params . scale . y = scale . val ; params . scale . z = scale . val ; params . translate = translate ; return params ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d scale = (Estimate_d)inputs[0]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return translate;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) translate = (LVect3d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "translate";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return LVect3d.class;
         return null;
      }

   }

   class PerlinParameters3 extends NodeFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private LVect3d scale;
      public PerlinParameters3() {
         scale = new LVect3d ( ) ; scale . x = 1 ; scale . y = 1 ; scale . z = 1 ;
      }

      public Class getReturnClass() {
         return PerlinNoiseParameters.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "translate";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d translate = (LVect3d)inputs[0]; 
         params . scale = scale ; params . translate = translate ; return params ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 translate = (Estimate_v3)inputs[0]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return scale;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scale = (LVect3d)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scale";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return LVect3d.class;
         return null;
      }

   }

   class PerlinParameters3a extends NodeFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      private double scale;
      public PerlinParameters3a() {
         scale = 1 ;
      }

      public Class getReturnClass() {
         return PerlinNoiseParameters.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "translate";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d translate = (LVect3d)inputs[0]; 
         params . scale . x = scale ; params . scale . y = scale ; params . scale . z = scale ; params . translate = translate ; return params ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 translate = (Estimate_v3)inputs[0]; 
         return new Estimate_param();
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return scale;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scale = (Double)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scale";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return double.class;
         return null;
      }

   }

   class PerlinParameters4 extends NodeFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      public Class getReturnClass() {
         return PerlinNoiseParameters.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "scale";
         if(i == 1) return "translate";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d scale = (LVect3d)inputs[0]; 
         LVect3d translate = (LVect3d)inputs[1]; 
         params . scale = scale ; params . translate = translate ; return params ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 scale = (Estimate_v3)inputs[0]; 
         Estimate_v3 translate = (Estimate_v3)inputs[1]; 
         return new Estimate_param();
      }

   }

   class PerlinParameters4a extends NodeFunction {
      private PerlinNoiseParameters params = new PerlinNoiseParameters ( ) ;
      public Class getReturnClass() {
         return PerlinNoiseParameters.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "scale";
         if(i == 1) return "translate";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble scale = (LDouble)inputs[0]; 
         LVect3d translate = (LVect3d)inputs[1]; 
         params . scale . x = scale . val ; params . scale . y = scale . val ; params . scale . z = scale . val ; params . translate = translate ; return params ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d scale = (Estimate_d)inputs[0]; 
         Estimate_v3 translate = (Estimate_v3)inputs[1]; 
         return new Estimate_param();
      }

   }

   class Perlin1 extends NodeFunction {
      public Class getReturnClass() {
         return NoiseFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {PerlinNoiseParameters.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "params";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0]; 
         return new PerlinNoise ( params ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param params = (Estimate_param)inputs[0]; 
         return new Estimate_param();
      }

   }

   class Perlin2 extends NodeFunction {
      public Class getReturnClass() {
         return NoiseFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {PerlinNoiseParameters.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "params";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0]; 
         PerlinNoise noise = new PerlinNoise ( ) { public double fade ( double t ) { return t ; } } ; noise . setParameters ( params ) ; return noise ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param params = (Estimate_param)inputs[0]; 
         return new Estimate_param();
      }

   }

   class Perlin3 extends NodeFunction {
      public Class getReturnClass() {
         return NoiseFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {PerlinNoiseParameters.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "params";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0]; 
         PerlinNoise noise = new PerlinNoise ( ) { public double fade ( double t ) { return Math . sqrt ( t ) ; } } ; noise . setParameters ( params ) ; return noise ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param params = (Estimate_param)inputs[0]; 
         return new Estimate_param();
      }

   }

   class Perlin4 extends NodeFunction {
      public Class getReturnClass() {
         return NoiseFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {PerlinNoiseParameters.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "params";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0]; 
         PerlinNoise noise = new PerlinNoise ( ) { public double fade ( double t ) { return t * t ; } } ; noise . setParameters ( params ) ; return noise ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param params = (Estimate_param)inputs[0]; 
         return new Estimate_param();
      }

   }

   class Perlin5 extends NodeFunction {
      public Class getReturnClass() {
         return NoiseFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {PerlinNoiseParameters.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "params";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0]; 
         PerlinNoise noise = new PerlinNoise ( ) { public double fade ( double x ) { double y = 2 * ( x - .5 ) ; return ( y * y * y - y ) / 2 + x ; } } ; noise . setParameters ( params ) ; return noise ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param params = (Estimate_param)inputs[0]; 
         return new Estimate_param();
      }

   }

   class Perlin6 extends NodeFunction {
      public Class getReturnClass() {
         return NoiseFunction.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {PerlinNoiseParameters.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "params";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         PerlinNoiseParameters params = (PerlinNoiseParameters)inputs[0]; 
         PerlinNoise noise = new PerlinNoise ( ) { public double fade ( double x ) { return Math . sin ( x * Math . PI / 2 ) ; } } ; noise . setParameters ( params ) ; return noise ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_param params = (Estimate_param)inputs[0]; 
         return new Estimate_param();
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new PerlinParameters1() );
      functions.add( new PerlinParameters1a() );
      functions.add( new PerlinParameters2() );
      functions.add( new PerlinParameters2a() );
      functions.add( new PerlinParameters3() );
      functions.add( new PerlinParameters3a() );
      functions.add( new PerlinParameters4() );
      functions.add( new PerlinParameters4a() );
      functions.add( new Perlin1() );
      functions.add( new Perlin2() );
      functions.add( new Perlin3() );
      functions.add( new Perlin4() );
      functions.add( new Perlin5() );
      functions.add( new Perlin6() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == PerlinParameters1.class)
          return new PerlinParameters1();
      if(nfClass == PerlinParameters1a.class)
          return new PerlinParameters1a();
      if(nfClass == PerlinParameters2.class)
          return new PerlinParameters2();
      if(nfClass == PerlinParameters2a.class)
          return new PerlinParameters2a();
      if(nfClass == PerlinParameters3.class)
          return new PerlinParameters3();
      if(nfClass == PerlinParameters3a.class)
          return new PerlinParameters3a();
      if(nfClass == PerlinParameters4.class)
          return new PerlinParameters4();
      if(nfClass == PerlinParameters4a.class)
          return new PerlinParameters4a();
      if(nfClass == Perlin1.class)
          return new Perlin1();
      if(nfClass == Perlin2.class)
          return new Perlin2();
      if(nfClass == Perlin3.class)
          return new Perlin3();
      if(nfClass == Perlin4.class)
          return new Perlin4();
      if(nfClass == Perlin5.class)
          return new Perlin5();
      if(nfClass == Perlin6.class)
          return new Perlin6();
      return null;
   }

}
