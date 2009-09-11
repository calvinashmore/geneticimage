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

public class Noise1Grad implements FunctionGroup, java.io.Serializable {
   class ngrad_v2_d_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         NoiseFunction noise = (NoiseFunction)inputs[1]; 
         double dx = ( noise . noise ( x . x + delta , x . y , 0 ) - noise . noise ( x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ; double dy = ( noise . noise ( x . x , x . y + delta , 0 ) - noise . noise ( x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ; return new LVect2d ( dx , dy ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_param noise = (Estimate_param)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class ngrad_v2_d_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         NoiseFunction noise = (NoiseFunction)inputs[1]; 
         double dx = ( noise . noise ( x . x + delta , x . y , 0 ) - noise . noise ( x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ; double dy = ( noise . noise ( x . x , x . y + delta , 0 ) - noise . noise ( x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ; return new LVect2d ( dx , dy ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_param noise = (Estimate_param)inputs[1]; 
         return new Estimate_v2();
      }

   }

   class ngrad_v3_d_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         NoiseFunction noise = (NoiseFunction)inputs[1]; 
         double dx = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; return new LVect3d ( dx , dy , dz ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_param noise = (Estimate_param)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class ngrad_v3_d_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         NoiseFunction noise = (NoiseFunction)inputs[1]; 
         double dx = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; return new LVect3d ( dx , dy , dz ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_param noise = (Estimate_param)inputs[1]; 
         return new Estimate_v3();
      }

   }

   class ngrad_v2_v2_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , 0 ) - noise . noise ( x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , 0 ) - noise . noise ( x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new LVect2d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class ngrad_v2_v2_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , 0 ) - noise . noise ( x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , 0 ) - noise . noise ( x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new LVect2d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class ngrad_v2_v2_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , 0 ) , noise . noise ( x . x + delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , 0 ) , noise . noise ( x . x - delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , 0 ) , noise . noise ( x . x + 100 , x . y + delta + 100 , 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , 0 ) , noise . noise ( x . x + 100 , x . y - delta + 100 , 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect2d ( xpart , ypart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class ngrad_v2_v2_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , 0 ) , noise . noise ( x . x + delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , 0 ) , noise . noise ( x . x - delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , 0 ) , noise . noise ( x . x + 100 , x . y + delta + 100 , 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , 0 ) , noise . noise ( x . x + 100 , x . y - delta + 100 , 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect2d ( xpart , ypart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class ngrad_v3_v2_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class ngrad_v3_v2_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class ngrad_v3_v2_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vz1 = new LVect2d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ; LVect2d vz2 = new LVect2d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect3d ( xpart , ypart , zpart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class ngrad_v3_v2_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vz1 = new LVect2d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ; LVect2d vz2 = new LVect2d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect3d ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class ngrad_v3_v3_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; double dx3 = ( noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) - noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dy3 = ( noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) - noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dz3 = ( noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) - noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ; LVect3d ynorm = y . normal ( ) ; return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class ngrad_v3_v3_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; double dx3 = ( noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) - noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dy3 = ( noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) - noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dz3 = ( noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) - noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ; LVect3d ynorm = y . normal ( ) ; return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class ngrad_v3_v3_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect3d vx1 = new LVect3d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vx2 = new LVect3d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy1 = new LVect3d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy2 = new LVect3d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vz1 = new LVect3d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ; LVect3d vz2 = new LVect3d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ; LVect3d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect3d ( xpart , ypart , zpart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class ngrad_v3_v3_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect3d vx1 = new LVect3d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vx2 = new LVect3d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy1 = new LVect3d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy2 = new LVect3d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vz1 = new LVect3d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ; LVect3d vz2 = new LVect3d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ; LVect3d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect3d ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class ngrad_col_v2_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new Color ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_col();
      }

   }

   class ngrad_col_v2_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new Color ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_col();
      }

   }

   class ngrad_col_v2_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vz1 = new LVect2d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ; LVect2d vz2 = new LVect2d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new Color ( xpart , ypart , zpart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_col();
      }

   }

   class ngrad_col_v2_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect2d vx1 = new LVect2d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vz1 = new LVect2d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ; LVect2d vz2 = new LVect2d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new Color ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_col();
      }

   }

   class ngrad_col_v3_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; double dx3 = ( noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) - noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dy3 = ( noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) - noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dz3 = ( noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) - noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ; LVect3d ynorm = y . normal ( ) ; return new Color ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_col();
      }

   }

   class ngrad_col_v3_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         double dx1 = ( noise . noise ( x . x + delta , x . y , x . z ) - noise . noise ( x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( noise . noise ( x . x , x . y + delta , x . z ) - noise . noise ( x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( noise . noise ( x . x , x . y , x . z + delta ) - noise . noise ( x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) - noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) - noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) - noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; double dx3 = ( noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) - noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dy3 = ( noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) - noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dz3 = ( noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) - noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ; LVect3d ynorm = y . normal ( ) ; return new Color ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_col();
      }

   }

   class ngrad_col_v3_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect3d vx1 = new LVect3d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vx2 = new LVect3d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy1 = new LVect3d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy2 = new LVect3d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vz1 = new LVect3d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ; LVect3d vz2 = new LVect3d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ; LVect3d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new Color ( xpart , ypart , zpart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_col();
      }

   }

   class ngrad_col_v3_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         LVect3d vx1 = new LVect3d ( noise . noise ( x . x + delta , x . y , x . z ) , noise . noise ( x . x + delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vx2 = new LVect3d ( noise . noise ( x . x - delta , x . y , x . z ) , noise . noise ( x . x - delta + 100 , x . y + 100 , x . z + 100 ) , noise . noise ( x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy1 = new LVect3d ( noise . noise ( x . x , x . y + delta , x . z ) , noise . noise ( x . x + 100 , x . y + delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy2 = new LVect3d ( noise . noise ( x . x , x . y - delta , x . z ) , noise . noise ( x . x + 100 , x . y - delta + 100 , x . z + 100 ) , noise . noise ( x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vz1 = new LVect3d ( noise . noise ( x . x , x . y , x . z + delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z + delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ; LVect3d vz2 = new LVect3d ( noise . noise ( x . x , x . y , x . z - delta ) , noise . noise ( x . x + 100 , x . y + 100 , x . z - delta + 100 ) , noise . noise ( x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ; LVect3d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new Color ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         return new Estimate_col();
      }

   }

   class fgrad_v2_d_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "noise";
         if(i == 2) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         NoiseFunction noise = (NoiseFunction)inputs[1]; 
         NoiseFractal fractal = (NoiseFractal)inputs[2]; 
         double dx = ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) - fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ; double dy = ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) - fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ; return new LVect2d ( dx , dy ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_param noise = (Estimate_param)inputs[1]; 
         Estimate_param fractal = (Estimate_param)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class fgrad_v2_d_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "noise";
         if(i == 2) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         NoiseFunction noise = (NoiseFunction)inputs[1]; 
         NoiseFractal fractal = (NoiseFractal)inputs[2]; 
         double dx = ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) - fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ; double dy = ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) - fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ; return new LVect2d ( dx , dy ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_param noise = (Estimate_param)inputs[1]; 
         Estimate_param fractal = (Estimate_param)inputs[2]; 
         return new Estimate_v2();
      }

   }

   class fgrad_v3_d_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "noise";
         if(i == 2) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         NoiseFunction noise = (NoiseFunction)inputs[1]; 
         NoiseFractal fractal = (NoiseFractal)inputs[2]; 
         double dx = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; return new LVect3d ( dx , dy , dz ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_param noise = (Estimate_param)inputs[1]; 
         Estimate_param fractal = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class fgrad_v3_d_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "noise";
         if(i == 2) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         NoiseFunction noise = (NoiseFunction)inputs[1]; 
         NoiseFractal fractal = (NoiseFractal)inputs[2]; 
         double dx = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; return new LVect3d ( dx , dy , dz ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_param noise = (Estimate_param)inputs[1]; 
         Estimate_param fractal = (Estimate_param)inputs[2]; 
         return new Estimate_v3();
      }

   }

   class fgrad_v2_v2_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) - fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) - fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new LVect2d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v2();
      }

   }

   class fgrad_v2_v2_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) - fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) - fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new LVect2d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v2();
      }

   }

   class fgrad_v2_v2_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect2d ( xpart , ypart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v2();
      }

   }

   class fgrad_v2_v2_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect2d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect2d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect2d x = (LVect2d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , 0 ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , 0 ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , 0 ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect2d ( xpart , ypart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v2 x = (Estimate_v2)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v2();
      }

   }

   class fgrad_v3_v2_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v3();
      }

   }

   class fgrad_v3_v2_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v3();
      }

   }

   class fgrad_v3_v2_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vz1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ; LVect2d vz2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect3d ( xpart , ypart , zpart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v3();
      }

   }

   class fgrad_v3_v2_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vz1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ; LVect2d vz2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect3d ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v3();
      }

   }

   class fgrad_v3_v3_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; double dx3 = ( fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dy3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dz3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ; LVect3d ynorm = y . normal ( ) ; return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v3();
      }

   }

   class fgrad_v3_v3_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; double dx3 = ( fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dy3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dz3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ; LVect3d ynorm = y . normal ( ) ; return new LVect3d ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v3();
      }

   }

   class fgrad_v3_v3_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect3d vx1 = new LVect3d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vx2 = new LVect3d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vz1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ; LVect3d vz2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ; LVect3d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect3d ( xpart , ypart , zpart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v3();
      }

   }

   class fgrad_v3_v3_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect3d vx1 = new LVect3d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vx2 = new LVect3d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vz1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ; LVect3d vz2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ; LVect3d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new LVect3d ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_v3();
      }

   }

   class fgrad_col_v2_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new Color ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_col();
      }

   }

   class fgrad_col_v2_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; LVect2d ynorm = y . normal ( ) ; return new Color ( dx1 * ynorm . x + dx2 * ynorm . y , dy1 * ynorm . x + dy2 * ynorm . y , dz1 * ynorm . x + dz2 * ynorm . y ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_col();
      }

   }

   class fgrad_col_v2_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vz1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ; LVect2d vz2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new Color ( xpart , ypart , zpart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_col();
      }

   }

   class fgrad_col_v2_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect2d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect2d y = (LVect2d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect2d vx1 = new LVect2d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vx2 = new LVect2d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vy2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) . normal ( ) ; LVect2d vz1 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) ) . normal ( ) ; LVect2d vz2 = new LVect2d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) . normal ( ) ; LVect2d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new Color ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v2 y = (Estimate_v2)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_col();
      }

   }

   class fgrad_col_v3_1 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; double dx3 = ( fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dy3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dz3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ; LVect3d ynorm = y . normal ( ) ; return new Color ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_col();
      }

   }

   class fgrad_col_v3_2 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         double dx1 = ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) - fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) ) / ( 2 * delta ) ; double dy1 = ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) - fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) ) / ( 2 * delta ) ; double dz1 = ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) - fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) ) / ( 2 * delta ) ; double dx2 = ( fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dy2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) ) / ( 2 * delta ) ; double dz2 = ( fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) - fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) ) / ( 2 * delta ) ; double dx3 = ( fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dy3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) / ( 2 * delta ) ; double dz3 = ( fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) - fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) / ( 2 * delta ) ; LVect3d ynorm = y . normal ( ) ; return new Color ( dx1 * ynorm . x + dx2 * ynorm . y + dx3 * ynorm . z , dy1 * ynorm . x + dy2 * ynorm . y + dy3 * ynorm . z , dz1 * ynorm . x + dz2 * ynorm . y + dz3 * ynorm . z ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_col();
      }

   }

   class fgrad_col_v3_3 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect3d vx1 = new LVect3d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vx2 = new LVect3d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vz1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ; LVect3d vz2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ; LVect3d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new Color ( xpart , ypart , zpart ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_col();
      }

   }

   class fgrad_col_v3_4 extends NodeFunction {
      private static final double delta = .01 ;
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LVect3d.class, LVect3d.class, NoiseFunction.class, NoiseFractal.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "x";
         if(i == 1) return "y";
         if(i == 2) return "noise";
         if(i == 3) return "fractal";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LVect3d x = (LVect3d)inputs[0]; 
         LVect3d y = (LVect3d)inputs[1]; 
         NoiseFunction noise = (NoiseFunction)inputs[2]; 
         NoiseFractal fractal = (NoiseFractal)inputs[3]; 
         LVect3d vx1 = new LVect3d ( fractal . evalFractal ( noise , x . x + delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x + delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vx2 = new LVect3d ( fractal . evalFractal ( noise , x . x - delta , x . y , x . z ) , fractal . evalFractal ( noise , x . x - delta + 100 , x . y + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x - delta + 300 , x . y + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y + delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y + delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vy2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y - delta , x . z ) , fractal . evalFractal ( noise , x . x + 100 , x . y - delta + 100 , x . z + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y - delta + 300 , x . z + 300 ) ) . normal ( ) ; LVect3d vz1 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z + delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z + delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z + delta + 300 ) ) . normal ( ) ; LVect3d vz2 = new LVect3d ( fractal . evalFractal ( noise , x . x , x . y , x . z - delta ) , fractal . evalFractal ( noise , x . x + 100 , x . y + 100 , x . z - delta + 100 ) , fractal . evalFractal ( noise , x . x + 300 , x . y + 300 , x . z - delta + 300 ) ) . normal ( ) ; LVect3d ynorm = y . normal ( ) ; double xpart = vx1 . sub ( vx2 ) . dot ( ynorm ) / ( 2 * delta ) ; double ypart = vy1 . sub ( vy2 ) . dot ( ynorm ) / ( 2 * delta ) ; double zpart = vz1 . sub ( vz2 ) . dot ( ynorm ) / ( 2 * delta ) ; return new Color ( xpart , ypart , zpart ) . normal ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_v3 x = (Estimate_v3)inputs[0]; 
         Estimate_v3 y = (Estimate_v3)inputs[1]; 
         Estimate_param noise = (Estimate_param)inputs[2]; 
         Estimate_param fractal = (Estimate_param)inputs[3]; 
         return new Estimate_col();
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new ngrad_v2_d_1() );
      functions.add( new ngrad_v2_d_2() );
      functions.add( new ngrad_v3_d_1() );
      functions.add( new ngrad_v3_d_2() );
      functions.add( new ngrad_v2_v2_1() );
      functions.add( new ngrad_v2_v2_2() );
      functions.add( new ngrad_v2_v2_3() );
      functions.add( new ngrad_v2_v2_4() );
      functions.add( new ngrad_v3_v2_1() );
      functions.add( new ngrad_v3_v2_2() );
      functions.add( new ngrad_v3_v2_3() );
      functions.add( new ngrad_v3_v2_4() );
      functions.add( new ngrad_v3_v3_1() );
      functions.add( new ngrad_v3_v3_2() );
      functions.add( new ngrad_v3_v3_3() );
      functions.add( new ngrad_v3_v3_4() );
      functions.add( new ngrad_col_v2_1() );
      functions.add( new ngrad_col_v2_2() );
      functions.add( new ngrad_col_v2_3() );
      functions.add( new ngrad_col_v2_4() );
      functions.add( new ngrad_col_v3_1() );
      functions.add( new ngrad_col_v3_2() );
      functions.add( new ngrad_col_v3_3() );
      functions.add( new ngrad_col_v3_4() );
      functions.add( new fgrad_v2_d_1() );
      functions.add( new fgrad_v2_d_2() );
      functions.add( new fgrad_v3_d_1() );
      functions.add( new fgrad_v3_d_2() );
      functions.add( new fgrad_v2_v2_1() );
      functions.add( new fgrad_v2_v2_2() );
      functions.add( new fgrad_v2_v2_3() );
      functions.add( new fgrad_v2_v2_4() );
      functions.add( new fgrad_v3_v2_1() );
      functions.add( new fgrad_v3_v2_2() );
      functions.add( new fgrad_v3_v2_3() );
      functions.add( new fgrad_v3_v2_4() );
      functions.add( new fgrad_v3_v3_1() );
      functions.add( new fgrad_v3_v3_2() );
      functions.add( new fgrad_v3_v3_3() );
      functions.add( new fgrad_v3_v3_4() );
      functions.add( new fgrad_col_v2_1() );
      functions.add( new fgrad_col_v2_2() );
      functions.add( new fgrad_col_v2_3() );
      functions.add( new fgrad_col_v2_4() );
      functions.add( new fgrad_col_v3_1() );
      functions.add( new fgrad_col_v3_2() );
      functions.add( new fgrad_col_v3_3() );
      functions.add( new fgrad_col_v3_4() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == ngrad_v2_d_1.class)
          return new ngrad_v2_d_1();
      if(nfClass == ngrad_v2_d_2.class)
          return new ngrad_v2_d_2();
      if(nfClass == ngrad_v3_d_1.class)
          return new ngrad_v3_d_1();
      if(nfClass == ngrad_v3_d_2.class)
          return new ngrad_v3_d_2();
      if(nfClass == ngrad_v2_v2_1.class)
          return new ngrad_v2_v2_1();
      if(nfClass == ngrad_v2_v2_2.class)
          return new ngrad_v2_v2_2();
      if(nfClass == ngrad_v2_v2_3.class)
          return new ngrad_v2_v2_3();
      if(nfClass == ngrad_v2_v2_4.class)
          return new ngrad_v2_v2_4();
      if(nfClass == ngrad_v3_v2_1.class)
          return new ngrad_v3_v2_1();
      if(nfClass == ngrad_v3_v2_2.class)
          return new ngrad_v3_v2_2();
      if(nfClass == ngrad_v3_v2_3.class)
          return new ngrad_v3_v2_3();
      if(nfClass == ngrad_v3_v2_4.class)
          return new ngrad_v3_v2_4();
      if(nfClass == ngrad_v3_v3_1.class)
          return new ngrad_v3_v3_1();
      if(nfClass == ngrad_v3_v3_2.class)
          return new ngrad_v3_v3_2();
      if(nfClass == ngrad_v3_v3_3.class)
          return new ngrad_v3_v3_3();
      if(nfClass == ngrad_v3_v3_4.class)
          return new ngrad_v3_v3_4();
      if(nfClass == ngrad_col_v2_1.class)
          return new ngrad_col_v2_1();
      if(nfClass == ngrad_col_v2_2.class)
          return new ngrad_col_v2_2();
      if(nfClass == ngrad_col_v2_3.class)
          return new ngrad_col_v2_3();
      if(nfClass == ngrad_col_v2_4.class)
          return new ngrad_col_v2_4();
      if(nfClass == ngrad_col_v3_1.class)
          return new ngrad_col_v3_1();
      if(nfClass == ngrad_col_v3_2.class)
          return new ngrad_col_v3_2();
      if(nfClass == ngrad_col_v3_3.class)
          return new ngrad_col_v3_3();
      if(nfClass == ngrad_col_v3_4.class)
          return new ngrad_col_v3_4();
      if(nfClass == fgrad_v2_d_1.class)
          return new fgrad_v2_d_1();
      if(nfClass == fgrad_v2_d_2.class)
          return new fgrad_v2_d_2();
      if(nfClass == fgrad_v3_d_1.class)
          return new fgrad_v3_d_1();
      if(nfClass == fgrad_v3_d_2.class)
          return new fgrad_v3_d_2();
      if(nfClass == fgrad_v2_v2_1.class)
          return new fgrad_v2_v2_1();
      if(nfClass == fgrad_v2_v2_2.class)
          return new fgrad_v2_v2_2();
      if(nfClass == fgrad_v2_v2_3.class)
          return new fgrad_v2_v2_3();
      if(nfClass == fgrad_v2_v2_4.class)
          return new fgrad_v2_v2_4();
      if(nfClass == fgrad_v3_v2_1.class)
          return new fgrad_v3_v2_1();
      if(nfClass == fgrad_v3_v2_2.class)
          return new fgrad_v3_v2_2();
      if(nfClass == fgrad_v3_v2_3.class)
          return new fgrad_v3_v2_3();
      if(nfClass == fgrad_v3_v2_4.class)
          return new fgrad_v3_v2_4();
      if(nfClass == fgrad_v3_v3_1.class)
          return new fgrad_v3_v3_1();
      if(nfClass == fgrad_v3_v3_2.class)
          return new fgrad_v3_v3_2();
      if(nfClass == fgrad_v3_v3_3.class)
          return new fgrad_v3_v3_3();
      if(nfClass == fgrad_v3_v3_4.class)
          return new fgrad_v3_v3_4();
      if(nfClass == fgrad_col_v2_1.class)
          return new fgrad_col_v2_1();
      if(nfClass == fgrad_col_v2_2.class)
          return new fgrad_col_v2_2();
      if(nfClass == fgrad_col_v2_3.class)
          return new fgrad_col_v2_3();
      if(nfClass == fgrad_col_v2_4.class)
          return new fgrad_col_v2_4();
      if(nfClass == fgrad_col_v3_1.class)
          return new fgrad_col_v3_1();
      if(nfClass == fgrad_col_v3_2.class)
          return new fgrad_col_v3_2();
      if(nfClass == fgrad_col_v3_3.class)
          return new fgrad_col_v3_3();
      if(nfClass == fgrad_col_v3_4.class)
          return new fgrad_col_v3_4();
      return null;
   }

}
