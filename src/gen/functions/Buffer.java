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

public class Buffer implements FunctionGroup, java.io.Serializable {
   class sampleBuffer_d extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, Buffer_d.class, GridScaleMethod.class, GridWrapMethod.class, GridWrapMethod.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "pos";
         if(i == 1) return "img";
         if(i == 2) return "scale";
         if(i == 3) return "xwrap";
         if(i == 4) return "ywrap";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d pos = (LVect2d)inputs[0]; 
         Buffer_d img = (Buffer_d)inputs[1]; 
         GridScaleMethod scale = (GridScaleMethod)inputs[2]; 
         GridWrapMethod xwrap = (GridWrapMethod)inputs[3]; 
         GridWrapMethod ywrap = (GridWrapMethod)inputs[4]; 
         int xres = img . getXRes ( ) ; return img . evalScale ( xres * pos . x , xres * pos . y , xwrap , ywrap , scale ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 pos = (Estimate_v2)inputs[0]; 
         Estimate_param img = (Estimate_param)inputs[1]; 
         Estimate_param scale = (Estimate_param)inputs[2]; 
         Estimate_param xwrap = (Estimate_param)inputs[3]; 
         Estimate_param ywrap = (Estimate_param)inputs[4]; 
         return new Estimate_d ( ) ;
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new sampleBuffer_d() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == sampleBuffer_d.class)
          return new sampleBuffer_d();
      return null;
   }

}
