package gen.functions;

import geneticimage.*;
import java.util.*;

public class AllFn implements FunctionGroup {
   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.addAll( new Algebraic().getFunctions() );
      functions.addAll( new Analytic().getFunctions() );
      functions.addAll( new Attractors().getFunctions() );
      functions.addAll( new Binary().getFunctions() );
      functions.addAll( new Blending().getFunctions() );
      functions.addAll( new Blur().getFunctions() );
      functions.addAll( new Buffer().getFunctions() );
      functions.addAll( new CellAutomata().getFunctions() );
      functions.addAll( new Cell().getFunctions() );
      functions.addAll( new CFractal().getFunctions() );
      functions.addAll( new ColorOp().getFunctions() );
      functions.addAll( new Complexfn().getFunctions() );
      functions.addAll( new Curves().getFunctions() );
      functions.addAll( new Geometric().getFunctions() );
      functions.addAll( new Ghost().getFunctions() );
      functions.addAll( new Gradient().getFunctions() );
      functions.addAll( new Imagefn().getFunctions() );
      functions.addAll( new Interpolate().getFunctions() );
      functions.addAll( new Lyapunov().getFunctions() );
      functions.addAll( new Noise1().getFunctions() );
      functions.addAll( new Noise1Grad().getFunctions() );
      functions.addAll( new Noise2().getFunctions() );
      functions.addAll( new Noise3().getFunctions() );
      functions.addAll( new Painter().getFunctions() );
      functions.addAll( new Quadtree().getFunctions() );
      functions.addAll( new Quaternions().getFunctions() );
      functions.addAll( new RandomVals().getFunctions() );
      functions.addAll( new Transform().getFunctions() );
      functions.addAll( new VectSwitch().getFunctions() );
      functions.addAll( new Warp().getFunctions() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if( (r = new Algebraic().build(nfClass,nff)) != null) return r;
      if( (r = new Analytic().build(nfClass,nff)) != null) return r;
      if( (r = new Attractors().build(nfClass,nff)) != null) return r;
      if( (r = new Binary().build(nfClass,nff)) != null) return r;
      if( (r = new Blending().build(nfClass,nff)) != null) return r;
      if( (r = new Blur().build(nfClass,nff)) != null) return r;
      if( (r = new Buffer().build(nfClass,nff)) != null) return r;
      if( (r = new CellAutomata().build(nfClass,nff)) != null) return r;
      if( (r = new Cell().build(nfClass,nff)) != null) return r;
      if( (r = new CFractal().build(nfClass,nff)) != null) return r;
      if( (r = new ColorOp().build(nfClass,nff)) != null) return r;
      if( (r = new Complexfn().build(nfClass,nff)) != null) return r;
      if( (r = new Curves().build(nfClass,nff)) != null) return r;
      if( (r = new Geometric().build(nfClass,nff)) != null) return r;
      if( (r = new Ghost().build(nfClass,nff)) != null) return r;
      if( (r = new Gradient().build(nfClass,nff)) != null) return r;
      if( (r = new Imagefn().build(nfClass,nff)) != null) return r;
      if( (r = new Interpolate().build(nfClass,nff)) != null) return r;
      if( (r = new Lyapunov().build(nfClass,nff)) != null) return r;
      if( (r = new Noise1().build(nfClass,nff)) != null) return r;
      if( (r = new Noise1Grad().build(nfClass,nff)) != null) return r;
      if( (r = new Noise2().build(nfClass,nff)) != null) return r;
      if( (r = new Noise3().build(nfClass,nff)) != null) return r;
      if( (r = new Painter().build(nfClass,nff)) != null) return r;
      if( (r = new Quadtree().build(nfClass,nff)) != null) return r;
      if( (r = new Quaternions().build(nfClass,nff)) != null) return r;
      if( (r = new RandomVals().build(nfClass,nff)) != null) return r;
      if( (r = new Transform().build(nfClass,nff)) != null) return r;
      if( (r = new VectSwitch().build(nfClass,nff)) != null) return r;
      if( (r = new Warp().build(nfClass,nff)) != null) return r;
      return null;
   }

}
