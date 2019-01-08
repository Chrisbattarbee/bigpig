package Experimental;

import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.lang.Math;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.util.Arrays;

public class ApacheMathTest {

    public static double LPTestByte(byte[] a, byte[] b, byte[] c, byte[] ep) {
        return LPTest(byteArrToInt(a), byteArrToInt(b), byteArrToInt(c), byteArrToInt(ep));
    }
    public static double LPTest(int a, int b, int c, int ep) {
        double eps = 0d;
        System.out.println("here1");
        if (ep >= -12 && ep <= -3) {
            eps = Math.pow(10d, ep);
        } else {
            eps = Math.pow(10d, -6d);
        }
        System.out.println("here2");
        SimplexSolver solver = new SimplexSolver(eps);
        System.out.println("here2.1");


        DescriptiveStatistics stats = new DescriptiveStatistics();
        // Add the data from the array
        int[] inputArray = new int[]{12, 341, 1234};
        for (int i = 0; i < inputArray.length; i++) {
            stats.addValue(inputArray[i]);
        }

        // Compute some statistics
        double mean = stats.getMean();

        System.out.println("here2.3");

        System.out.println(System.getProperty("java.version"));


        System.out.println("Number format methods");
        Arrays.asList(NumberFormat.class.getMethods()).forEach(x -> {
//                System.out.println("new method start");
            System.out.println(x);
//                System.out.println("Parameters");
//                System.out.println(Arrays.deepToString(x.getParameters()));

        });
        System.out.println("Number format methods end ");

        System.out.println("Strict Math methods");
        Arrays.asList(StrictMath.class.getMethods()).forEach(x -> {
            System.out.println(x);
        });
        System.out.println("Strict Math methods end");


        Method[] methods = LinearConstraint.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        for (Constructor constructor : LinearConstraint.class.getDeclaredConstructors()) {
            System.out.println(LinearConstraint.class.getDeclaredConstructors().length);
            System.out.println("Length");
            System.out.println(constructor);
            System.out.println("here");
        }

        OptimizationData objFunction = new LinearObjectiveFunction(new double[]{1.9d, 2.3d, (double) c, (double) a}, 0d);
        System.out.println("here2.4");
        LinearConstraint x = new LinearConstraint(new double[]{0d, 0d, 1d, 0d}, Relationship.LEQ, 1d);
        System.out.println("here2.5");
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
        System.out.println("here3");
        OptimizationData goalType = GoalType.MAXIMIZE;
        System.out.println("here4");
        PointValuePair result = solver.optimize(objFunction, constraints, goalType);
        System.out.println("here5");
        return result.getValue();

    }

    private static int byteArrToInt(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }

    public static int fooByte(byte[] n, byte[] m, byte[] x) {
        return foo(byteArrToInt(n), byteArrToInt(m), byteArrToInt(x));
    }

    public static int foo(int n, int m, int x) {
        // Fuzzer doesn't get in here
        if (x == -456290) {
            for (int y = 0; y < 10; y ++) {
                if (n < 0 || m - n > 0) {
                    if (m < 0) {
                        return 12;
                    }
                    m += Math.sin((double) m);
                }
                m *= n;
                if (m % 3671 == 3) {
                    return m;
                }
            }
        }

        if (Math.sin(Math.cos(Math.tan(n) + 11)) < Math.tan(Math.cos(Math.sin(m)))) {
            return 15;
        }

        // Decent number of ifs for fuzzer
        return 0;
    }

//
//
//    public static int foo(int n, int m, int x) {
//
//        // Fuzzer doesn't get in here
//        if (x == -456290) {
//            for (int y = 0; y < 10; y ++) {
//                if (n < 0 || n << m > 0) {
//                    if (m < 0) {
//                        return 12;
//                    }
//                    return 5;
//                }
//                if (m > 0) {
//                    return m;
//                }
//                m *= n;
//                n += 1;
//            }
////        }
//
//        // Decent number of ifs for fuzzer
//        return 0;
//    }

    public static void main(String[] args) {
        foo(0, 0, 0);
    }
}
