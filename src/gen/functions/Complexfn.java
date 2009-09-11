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

public class Complexfn implements FunctionGroup, java.io.Serializable {
   class Sin extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return new Complex ( Math . sin ( x . x ) * Math . cosh ( x . y ) , Math . cos ( x . x ) * Math . sinh ( x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class Cos extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return new Complex ( Math . cos ( x . x ) * Math . cosh ( x . y ) , - Math . sin ( x . x ) * Math . sinh ( x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class Tan extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return new Complex ( Math . sinh ( x . y ) * Math . cosh ( x . y ) , Math . sin ( x . x ) * Math . cos ( x . x ) ) . mult ( 1.0 / ( Math . cos ( x . x ) * Math . cos ( x . x ) + Math . sinh ( x . y ) * Math . sinh ( x . y ) ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class Sinh extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return new Complex ( Math . sinh ( x . x ) * Math . cos ( x . y ) , Math . cosh ( x . x ) * Math . sin ( x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class Cosh extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return new Complex ( Math . cosh ( x . x ) * Math . cos ( x . y ) , Math . sinh ( x . x ) * Math . sin ( x . y ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class Tanh extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return new Complex ( Math . sinh ( x . x ) * Math . cosh ( x . x ) , Math . sin ( x . y ) * Math . cos ( x . y ) ) . mult ( 1.0 / ( Math . cos ( x . y ) * Math . cos ( x . y ) + Math . sinh ( x . x ) * Math . sinh ( x . x ) ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class Asin extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex r = new Complex ( - x . y , x . x ) . add ( new Complex ( 1 - x . x * x . x + x . y * x . y , - 2 * x . x * x . y ) . pow ( .5 ) ) . log ( ) ; Complex p = new Complex ( r . y , - r . x ) ; return p ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class Acos extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex r = new Complex ( - x . y , x . x ) . add ( new Complex ( 1 - x . x * x . x + x . y * x . y , - 2 * x . x * x . y ) . pow ( .5 ) ) . log ( ) ; Complex p = new Complex ( Math . PI / 2 - r . y , r . x ) ; return p ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class Atan extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex r = new Complex ( 1 + x . y , - x . x ) . log ( ) ; Complex s = new Complex ( 1 - x . y , x . x ) . log ( ) ; Complex t = r . add ( s ) ; Complex p = new Complex ( - t . y / 2 , t . x / 2 ) ; return p ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( ) ;
      }

   }

   class Pow extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex y = (Complex)inputs[1]; 
         Complex xlog = new Complex ( Math . log ( x . magnitude ( ) ) , x . theta ( ) ) ; Complex ymul = new Complex ( xlog . x * y . x - xlog . y * y . y , xlog . x * y . y + xlog . y * y . x ) ; Complex z = new Complex ( Math . exp ( ymul . x ) * Math . cos ( ymul . y ) , Math . exp ( ymul . x ) * Math . sin ( ymul . y ) ) ; return z ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         Estimate_c y = (Estimate_c)inputs[1]; 
         return new Estimate_c ( ) ;
      }

   }

   class Div extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex y = (Complex)inputs[1]; 
         Complex z = new Complex ( ) ; z . x = x . x * y . x + x . y * y . y ; z . y = x . y * y . x - x . x * y . y ; double mag = x . magnitude ( ) * y . magnitude ( ) ; return z . mult ( 1.0 / mag ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         Estimate_c y = (Estimate_c)inputs[1]; 
         return new Estimate_c ( ) ;
      }

   }

   class Exp extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return x . exp ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         double mag = Math . exp ( x . getXMaximum ( ) ) ; return new Estimate_c ( - mag , mag , - mag , mag ) ;
      }

   }

   class Log extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         return x . log ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         return new Estimate_c ( Math . log ( x . getMinMagnitude ( ) ) , Math . log ( x . getMaxMagnitude ( ) ) , 0 , 2 * Math . PI ) ;
      }

   }

   class Spin extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex x = (Complex)inputs[0]; 
         Complex y = (Complex)inputs[1]; 
         Complex c = new Complex ( ) ; c . x = - x . x ; c . y = x . y + y . theta ( ) ; return c . exp ( ) . mult ( y . magnitude ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c x = (Estimate_c)inputs[0]; 
         Estimate_c y = (Estimate_c)inputs[1]; 
         return new Estimate_c ( ) ;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new Sin() );
      functions.add( new Cos() );
      functions.add( new Tan() );
      functions.add( new Sinh() );
      functions.add( new Cosh() );
      functions.add( new Tanh() );
      functions.add( new Asin() );
      functions.add( new Acos() );
      functions.add( new Atan() );
      functions.add( new Pow() );
      functions.add( new Div() );
      functions.add( new Exp() );
      functions.add( new Log() );
      functions.add( new Spin() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == Sin.class)
          return new Sin();
      if(nfClass == Cos.class)
          return new Cos();
      if(nfClass == Tan.class)
          return new Tan();
      if(nfClass == Sinh.class)
          return new Sinh();
      if(nfClass == Cosh.class)
          return new Cosh();
      if(nfClass == Tanh.class)
          return new Tanh();
      if(nfClass == Asin.class)
          return new Asin();
      if(nfClass == Acos.class)
          return new Acos();
      if(nfClass == Atan.class)
          return new Atan();
      if(nfClass == Pow.class)
          return new Pow();
      if(nfClass == Div.class)
          return new Div();
      if(nfClass == Exp.class)
          return new Exp();
      if(nfClass == Log.class)
          return new Log();
      if(nfClass == Spin.class)
          return new Spin();
      return null;
   }

}
