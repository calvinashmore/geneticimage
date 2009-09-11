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

public class Imagefn implements FunctionGroup, java.io.Serializable {
   class ScaleMethod extends NodeFunction {
      private GridScaleMethod scaleMethod;
      public ScaleMethod() {
         GridScaleMethod meths [ ] = GridScaleMethod . values ( ) ; scaleMethod = meths [ ( new java . util . Random ( ) ) . nextInt ( meths . length ) ] ;
      }

      public Class getReturnClass() {
         return GridScaleMethod.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return scaleMethod ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( scaleMethod ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return scaleMethod;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) scaleMethod = (GridScaleMethod)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "scaleMethod";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return GridScaleMethod.class;
         return null;
      }

   }

   class WrapMethod extends NodeFunction {
      private GridWrapMethod wrapMethod;
      public WrapMethod() {
         GridWrapMethod meths [ ] = GridWrapMethod . values ( ) ; wrapMethod = meths [ ( new java . util . Random ( ) ) . nextInt ( meths . length ) ] ;
      }

      public Class getReturnClass() {
         return GridWrapMethod.class;
      }

      public Class[] getInputClasses() {
         return null;
      }

      public String getInputName(int i) {
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         return wrapMethod ;
      }

      public Estimate estimate(Estimate inputs[]) {
         return new Estimate_param ( wrapMethod ) ;
      }

      public int getNumberParameters() {
         return 1;
      }

      public Object getParameter(int i) {
         if(i == 0) return wrapMethod;
         return null;
      }

      public void setParameter(int i, Object param) {
         if(i == 0) wrapMethod = (GridWrapMethod)param;
      }

      public String getParameterName(int i) {
         if(i == 0) return "wrapMethod";
         return null;
      }

      public Class getParameterType(int i) {
         if(i == 0) return GridWrapMethod.class;
         return null;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new ScaleMethod() );
      functions.add( new WrapMethod() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == ScaleMethod.class)
          return new ScaleMethod();
      if(nfClass == WrapMethod.class)
          return new WrapMethod();
      return null;
   }

}
