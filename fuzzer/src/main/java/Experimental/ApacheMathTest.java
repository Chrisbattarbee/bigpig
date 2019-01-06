package Experimental;

import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.nio.ByteBuffer;

public class ApacheMathTest {

     private static int byteArrToInt(byte[] bytes) {
            return ByteBuffer.wrap(bytes).getInt();
        }

        private static byte[] intToByteArr(int num) {
            ByteBuffer buf = ByteBuffer.allocate(4);
            buf.putInt(num);
            return buf.array();
        }

        public static double LPTestByte(byte[] a, byte[] b, byte[] c, byte[] ep) {
            return LPTest(byteArrToInt(a), byteArrToInt(b), byteArrToInt(c), byteArrToInt(ep));
        }

        public static double LPTest(int a, int b, int c, int ep) {
            double eps = 0d;
            if(ep >= -12 && ep <= -3) {
                eps = Math.pow(10d, ep);
            } else {
                eps = Math.pow(10d, -6d);
            }
            OptimizationData objFunction = new LinearObjectiveFunction(new double[]{1.9d, 2.3d, (double) c, (double) a}, 0d);
            OptimizationData constraints = new LinearConstraintSet(
                    new LinearConstraint(new double[]{0.6d, 0.8d, (double) b, 1.3d}, Relationship.LEQ, 2.5d),
                    new LinearConstraint(new double[]{1d, 0d, 0d, 0d}, Relationship.LEQ, 1d),
                    new LinearConstraint(new double[]{0d, 1d, 0d, 0d}, Relationship.LEQ, 1d),
                    new LinearConstraint(new double[]{0d, 0d, 1d, 0d}, Relationship.LEQ, 1d),
                    new LinearConstraint(new double[]{0d, 0d, 0d, 1d}, Relationship.LEQ, 1d),
                    new LinearConstraint(new double[]{1d, 0d, 0d, 0d}, Relationship.GEQ, 0d),
                    new LinearConstraint(new double[]{0d, 1d, 0d, 0d}, Relationship.GEQ, 0d),
                    new LinearConstraint(new double[]{0d, 0d, 1d, 0d}, Relationship.GEQ, 0d),
                    new LinearConstraint(new double[]{0d, 0d, 0d, 1d}, Relationship.GEQ, 0d));
            OptimizationData goalType = GoalType.MAXIMIZE;
            SimplexSolver solver = new SimplexSolver(eps);
            PointValuePair result = solver.optimize(objFunction, constraints, goalType);
            return result.getValue();

        }

    public static void main(String[] args) {
        LPTestByte(intToByteArr(0),intToByteArr(0),intToByteArr(0),intToByteArr(0));
    }
}
