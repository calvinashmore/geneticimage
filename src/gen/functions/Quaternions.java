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

public class Quaternions implements FunctionGroup, java.io.Serializable {
   class NewQuat4d extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LDouble.class, LDouble.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "u";
         if(i == 1) return "i";
         if(i == 2) return "j";
         if(i == 3) return "k";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble u = (LDouble)inputs[0]; 
         LDouble i = (LDouble)inputs[1]; 
         LDouble j = (LDouble)inputs[2]; 
         LDouble k = (LDouble)inputs[3]; 
         return new Quaternion ( u . val , i . val , j . val , k . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d u = (Estimate_d)inputs[0]; 
         Estimate_d i = (Estimate_d)inputs[1]; 
         Estimate_d j = (Estimate_d)inputs[2]; 
         Estimate_d k = (Estimate_d)inputs[3]; 
         return new Estimate_q ( u . getMinimum ( ) , u . getMaximum ( ) , i . getMinimum ( ) , i . getMaximum ( ) , j . getMinimum ( ) , j . getMaximum ( ) , k . getMinimum ( ) , k . getMaximum ( ) ) ;
      }

   }

   class NewQuat2c1 extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex a = (Complex)inputs[0]; 
         Complex b = (Complex)inputs[1]; 
         return new Quaternion ( a . x , a . y , b . x , b . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c a = (Estimate_c)inputs[0]; 
         Estimate_c b = (Estimate_c)inputs[1]; 
         return new Estimate_q ( a . getXMinimum ( ) , a . getXMaximum ( ) , a . getYMinimum ( ) , a . getYMaximum ( ) , b . getXMinimum ( ) , b . getXMaximum ( ) , b . getYMinimum ( ) , b . getYMaximum ( ) ) ;
      }

   }

   class NewQuatdv3 extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {LDouble.class, LVect3d.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         LDouble a = (LDouble)inputs[0]; 
         LVect3d b = (LVect3d)inputs[1]; 
         return new Quaternion ( a . val , b . x , b . y , b . z ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_d a = (Estimate_d)inputs[0]; 
         Estimate_v3 b = (Estimate_v3)inputs[1]; 
         return new Estimate_q ( a . getMinimum ( ) , a . getMaximum ( ) , b . getXMinimum ( ) , b . getXMaximum ( ) , b . getYMinimum ( ) , b . getYMaximum ( ) , b . getZMinimum ( ) , b . getZMaximum ( ) ) ;
      }

   }

   class NewQuat2c2 extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Complex.class, Complex.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Complex a = (Complex)inputs[0]; 
         Complex b = (Complex)inputs[1]; 
         return new Quaternion ( a . x * b . x , a . y * b . x , b . y * a . x , a . y * b . y ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_c a = (Estimate_c)inputs[0]; 
         Estimate_c b = (Estimate_c)inputs[1]; 
         double umin = Math . min ( Math . min ( a . getXMinimum ( ) * b . getXMinimum ( ) , a . getXMinimum ( ) * b . getXMaximum ( ) ) , Math . min ( a . getXMaximum ( ) * b . getXMinimum ( ) , a . getXMaximum ( ) * b . getXMaximum ( ) ) ) ; double umax = Math . max ( Math . max ( a . getXMinimum ( ) * b . getXMinimum ( ) , a . getXMinimum ( ) * b . getXMaximum ( ) ) , Math . max ( a . getXMaximum ( ) * b . getXMinimum ( ) , a . getXMaximum ( ) * b . getXMaximum ( ) ) ) ; double imin = Math . min ( Math . min ( a . getYMinimum ( ) * b . getXMinimum ( ) , a . getYMinimum ( ) * b . getXMaximum ( ) ) , Math . min ( a . getYMinimum ( ) * b . getXMinimum ( ) , a . getYMinimum ( ) * b . getXMaximum ( ) ) ) ; double imax = Math . max ( Math . max ( a . getYMinimum ( ) * b . getXMinimum ( ) , a . getYMinimum ( ) * b . getXMaximum ( ) ) , Math . max ( a . getYMinimum ( ) * b . getXMinimum ( ) , a . getYMinimum ( ) * b . getXMaximum ( ) ) ) ; double jmin = Math . min ( Math . min ( a . getXMaximum ( ) * b . getYMinimum ( ) , a . getXMaximum ( ) * b . getYMinimum ( ) ) , Math . min ( a . getXMaximum ( ) * b . getYMinimum ( ) , a . getXMaximum ( ) * b . getYMinimum ( ) ) ) ; double jmax = Math . max ( Math . max ( a . getXMaximum ( ) * b . getYMinimum ( ) , a . getXMaximum ( ) * b . getYMinimum ( ) ) , Math . max ( a . getXMaximum ( ) * b . getYMinimum ( ) , a . getXMaximum ( ) * b . getYMinimum ( ) ) ) ; double kmin = Math . min ( Math . min ( a . getYMinimum ( ) * b . getYMinimum ( ) , a . getYMinimum ( ) * b . getYMinimum ( ) ) , Math . min ( a . getYMinimum ( ) * b . getYMinimum ( ) , a . getYMinimum ( ) * b . getYMinimum ( ) ) ) ; double kmax = Math . max ( Math . max ( a . getYMinimum ( ) * b . getYMinimum ( ) , a . getYMinimum ( ) * b . getYMinimum ( ) ) , Math . max ( a . getYMinimum ( ) * b . getYMinimum ( ) , a . getYMinimum ( ) * b . getYMinimum ( ) ) ) ; return new Estimate_q ( umin , umax , imin , imax , jmin , jmax , kmin , kmax ) ;
      }

   }

   class q_u extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new LDouble ( q . u ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_d ( q . getUMinimum ( ) , q . getUMaximum ( ) ) ;
      }

   }

   class q_i extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new LDouble ( q . i ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_d ( q . getIMinimum ( ) , q . getIMaximum ( ) ) ;
      }

   }

   class q_j extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new LDouble ( q . j ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_d ( q . getJMinimum ( ) , q . getJMaximum ( ) ) ;
      }

   }

   class q_k extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new LDouble ( q . k ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_d ( q . getKMinimum ( ) , q . getKMaximum ( ) ) ;
      }

   }

   class q_angle extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new LDouble ( q . anglePart ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_d ( 0 , Math . PI ) ;
      }

   }

   class q_magnitude extends NodeFunction {
      public Class getReturnClass() {
         return LDouble.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new LDouble ( q . magnitude ( ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_d ( q . getMinMagnitude ( ) , q . getMaxMagnitude ( ) ) ;
      }

   }

   class q_ci extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new Complex ( q . u , q . i ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_c ( q . getUMinimum ( ) , q . getUMaximum ( ) , q . getIMinimum ( ) , q . getIMaximum ( ) ) ;
      }

   }

   class q_cj extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new Complex ( q . u , q . j ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_c ( q . getUMinimum ( ) , q . getUMaximum ( ) , q . getJMinimum ( ) , q . getJMaximum ( ) ) ;
      }

   }

   class q_ck extends NodeFunction {
      public Class getReturnClass() {
         return Complex.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new Complex ( q . u , q . k ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_c ( q . getUMinimum ( ) , q . getUMaximum ( ) , q . getKMinimum ( ) , q . getKMaximum ( ) ) ;
      }

   }

   class q_v3 extends NodeFunction {
      public Class getReturnClass() {
         return LVect3d.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return q . vectorPart ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return q . getVectorEstimate ( ) ;
      }

   }

   class q_col extends NodeFunction {
      public Class getReturnClass() {
         return Color.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "q";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion q = (Quaternion)inputs[0]; 
         return new Color ( q . i , q . j , q . k ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q q = (Estimate_q)inputs[0]; 
         return new Estimate_col ( q . getIMinimum ( ) , q . getIMaximum ( ) , q . getJMinimum ( ) , q . getJMaximum ( ) , q . getKMinimum ( ) , q . getKMaximum ( ) ) ;
      }

   }

   class add extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class, Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         Quaternion b = (Quaternion)inputs[1]; 
         return a . add ( b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         Estimate_q b = (Estimate_q)inputs[1]; 
         return new Estimate_q ( a . getUMinimum ( ) + b . getUMinimum ( ) , a . getUMaximum ( ) + b . getUMaximum ( ) , a . getIMinimum ( ) + b . getIMinimum ( ) , a . getIMaximum ( ) + b . getIMaximum ( ) , a . getJMinimum ( ) + b . getJMinimum ( ) , a . getJMaximum ( ) + b . getJMaximum ( ) , a . getKMinimum ( ) + b . getKMinimum ( ) , a . getKMaximum ( ) + b . getKMaximum ( ) ) ;
      }

   }

   class sub extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class, Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         Quaternion b = (Quaternion)inputs[1]; 
         return a . sub ( b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         Estimate_q b = (Estimate_q)inputs[1]; 
         return new Estimate_q ( a . getUMinimum ( ) - b . getUMinimum ( ) , a . getUMaximum ( ) - b . getUMaximum ( ) , a . getIMinimum ( ) - b . getIMinimum ( ) , a . getIMaximum ( ) - b . getIMaximum ( ) , a . getJMinimum ( ) - b . getJMinimum ( ) , a . getJMaximum ( ) - b . getJMaximum ( ) , a . getKMinimum ( ) - b . getKMinimum ( ) , a . getKMaximum ( ) - b . getKMaximum ( ) ) ;
      }

   }

   class mult extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class, Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         Quaternion b = (Quaternion)inputs[1]; 
         return a . mult ( b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         Estimate_q b = (Estimate_q)inputs[1]; 
         return new Estimate_q();
      }

   }

   class div extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class, Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         Quaternion b = (Quaternion)inputs[1]; 
         return a . div ( b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         Estimate_q b = (Estimate_q)inputs[1]; 
         return new Estimate_q();
      }

   }

   class powq extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class, Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         Quaternion b = (Quaternion)inputs[1]; 
         return a . pow ( b ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         Estimate_q b = (Estimate_q)inputs[1]; 
         return new Estimate_q();
      }

   }

   class pow extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class, LDouble.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         LDouble b = (LDouble)inputs[1]; 
         return a . pow ( b . val ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         Estimate_d b = (Estimate_d)inputs[1]; 
         return new Estimate_q();
      }

   }

   class invert extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . invert ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class square extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . mult ( a ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class exp extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . exp ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class log extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . log ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class sin extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . sin ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class cos extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . cos ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class tan extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . tan ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class sinh extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . sinh ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class cosh extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . cosh ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class tanh extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . tanh ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class arcsin extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . arcsin ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class arccos extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . arccos ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class arctan extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . arctan ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class arcsinh extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . arcsinh ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class arccosh extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . arccosh ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class arctanh extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . arctanh ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class isin extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return new Quaternion ( Math . sin ( a . u ) , Math . sin ( a . i ) , Math . sin ( a . j ) , Math . sin ( a . k ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class icos extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return new Quaternion ( Math . cos ( a . u ) , Math . cos ( a . i ) , Math . cos ( a . j ) , Math . cos ( a . k ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class itan extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return new Quaternion ( Math . tan ( a . u ) , Math . tan ( a . i ) , Math . tan ( a . j ) , Math . tan ( a . k ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class iexp extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return new Quaternion ( Math . exp ( a . u ) , Math . exp ( a . i ) , Math . exp ( a . j ) , Math . exp ( a . k ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class ilog extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return new Quaternion ( Math . log ( a . u ) , Math . log ( a . i ) , Math . log ( a . j ) , Math . log ( a . k ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class swapl extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return new Quaternion ( a . i , a . j , a . k , a . u ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class swapr extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return new Quaternion ( a . k , a . u , a . i , a . j ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class conj extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return a . conj ( ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   class aut1 extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class, Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         Quaternion b = (Quaternion)inputs[1]; 
         return b . div ( a ) . mult ( a ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         Estimate_q b = (Estimate_q)inputs[1]; 
         return new Estimate_q();
      }

   }

   class aut2 extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class, Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         Quaternion b = (Quaternion)inputs[1]; 
         return b . div ( a . conj ( ) ) . mult ( a ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         Estimate_q b = (Estimate_q)inputs[1]; 
         return new Estimate_q();
      }

   }

   class orth extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class, Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         if(i == 1) return "b";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         Quaternion b = (Quaternion)inputs[1]; 
         return a . normal ( ) . mult ( b . mult ( a . normal ( ) . conj ( ) ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         Estimate_q b = (Estimate_q)inputs[1]; 
         return new Estimate_q();
      }

   }

   class mod extends NodeFunction {
      public Class getReturnClass() {
         return Quaternion.class;
      }

      public Class[] getInputClasses() {
         Class inputClasses[] = {Quaternion.class};
         return inputClasses;
      }

      public String getInputName(int i) {
         if(i == 0) return "a";
         return null;
      }

      public Object evaluate(Object inputs[], Context context) {
         Quaternion a = (Quaternion)inputs[0]; 
         return new Quaternion ( a . u - Math . floor ( a . u ) , a . i - Math . floor ( a . i ) , a . j - Math . floor ( a . j ) , a . k - Math . floor ( a . k ) ) ;
      }

      public Estimate estimate(Estimate inputs[]) {
         Estimate_q a = (Estimate_q)inputs[0]; 
         return new Estimate_q();
      }

   }

   public List<NodeFunction> getFunctions() {
      List<NodeFunction> functions = new LinkedList();
      functions.add( new NewQuat4d() );
      functions.add( new NewQuat2c1() );
      functions.add( new NewQuatdv3() );
      functions.add( new NewQuat2c2() );
      functions.add( new q_u() );
      functions.add( new q_i() );
      functions.add( new q_j() );
      functions.add( new q_k() );
      functions.add( new q_angle() );
      functions.add( new q_magnitude() );
      functions.add( new q_ci() );
      functions.add( new q_cj() );
      functions.add( new q_ck() );
      functions.add( new q_v3() );
      functions.add( new q_col() );
      functions.add( new add() );
      functions.add( new sub() );
      functions.add( new mult() );
      functions.add( new div() );
      functions.add( new powq() );
      functions.add( new pow() );
      functions.add( new invert() );
      functions.add( new square() );
      functions.add( new exp() );
      functions.add( new log() );
      functions.add( new sin() );
      functions.add( new cos() );
      functions.add( new tan() );
      functions.add( new sinh() );
      functions.add( new cosh() );
      functions.add( new tanh() );
      functions.add( new arcsin() );
      functions.add( new arccos() );
      functions.add( new arctan() );
      functions.add( new arcsinh() );
      functions.add( new arccosh() );
      functions.add( new arctanh() );
      functions.add( new isin() );
      functions.add( new icos() );
      functions.add( new itan() );
      functions.add( new iexp() );
      functions.add( new ilog() );
      functions.add( new swapl() );
      functions.add( new swapr() );
      functions.add( new conj() );
      functions.add( new aut1() );
      functions.add( new aut2() );
      functions.add( new orth() );
      functions.add( new mod() );
      return functions;
   }

   public NodeFunction build(Class<? extends NodeFunction> nfClass, NodeFunctionFactory nff) {
      NodeFunction r;
      if(nfClass == NewQuat4d.class)
          return new NewQuat4d();
      if(nfClass == NewQuat2c1.class)
          return new NewQuat2c1();
      if(nfClass == NewQuatdv3.class)
          return new NewQuatdv3();
      if(nfClass == NewQuat2c2.class)
          return new NewQuat2c2();
      if(nfClass == q_u.class)
          return new q_u();
      if(nfClass == q_i.class)
          return new q_i();
      if(nfClass == q_j.class)
          return new q_j();
      if(nfClass == q_k.class)
          return new q_k();
      if(nfClass == q_angle.class)
          return new q_angle();
      if(nfClass == q_magnitude.class)
          return new q_magnitude();
      if(nfClass == q_ci.class)
          return new q_ci();
      if(nfClass == q_cj.class)
          return new q_cj();
      if(nfClass == q_ck.class)
          return new q_ck();
      if(nfClass == q_v3.class)
          return new q_v3();
      if(nfClass == q_col.class)
          return new q_col();
      if(nfClass == add.class)
          return new add();
      if(nfClass == sub.class)
          return new sub();
      if(nfClass == mult.class)
          return new mult();
      if(nfClass == div.class)
          return new div();
      if(nfClass == powq.class)
          return new powq();
      if(nfClass == pow.class)
          return new pow();
      if(nfClass == invert.class)
          return new invert();
      if(nfClass == square.class)
          return new square();
      if(nfClass == exp.class)
          return new exp();
      if(nfClass == log.class)
          return new log();
      if(nfClass == sin.class)
          return new sin();
      if(nfClass == cos.class)
          return new cos();
      if(nfClass == tan.class)
          return new tan();
      if(nfClass == sinh.class)
          return new sinh();
      if(nfClass == cosh.class)
          return new cosh();
      if(nfClass == tanh.class)
          return new tanh();
      if(nfClass == arcsin.class)
          return new arcsin();
      if(nfClass == arccos.class)
          return new arccos();
      if(nfClass == arctan.class)
          return new arctan();
      if(nfClass == arcsinh.class)
          return new arcsinh();
      if(nfClass == arccosh.class)
          return new arccosh();
      if(nfClass == arctanh.class)
          return new arctanh();
      if(nfClass == isin.class)
          return new isin();
      if(nfClass == icos.class)
          return new icos();
      if(nfClass == itan.class)
          return new itan();
      if(nfClass == iexp.class)
          return new iexp();
      if(nfClass == ilog.class)
          return new ilog();
      if(nfClass == swapl.class)
          return new swapl();
      if(nfClass == swapr.class)
          return new swapr();
      if(nfClass == conj.class)
          return new conj();
      if(nfClass == aut1.class)
          return new aut1();
      if(nfClass == aut2.class)
          return new aut2();
      if(nfClass == orth.class)
          return new orth();
      if(nfClass == mod.class)
          return new mod();
      return null;
   }

}
