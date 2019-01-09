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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

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
            for (int y = 0; y < 10; y++) {
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

    private static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int rv[][] = new int[n + 1][W + 1];    //rv means return value

        // Build table rv[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    rv[i][w] = 0;
                else if (wt[i - 1] <= w)
                    rv[i][w] = Math.max(val[i - 1] + rv[i - 1][w - wt[i - 1]], rv[i - 1][w]);
                else
                    rv[i][w] = rv[i - 1][w];
            }
        }

        return rv[n][W];
    }

    private static int networkFlow(int source, int sink) {
        final int INF = 987654321;
        int V = 6; // edges
        int[][] capacity, flow;
        flow = new int[V][V];
        capacity = new int[V][V];
        int totalFlow = 0;
        while (true) {
            Vector<Integer> parent = new Vector<>(V);
            for (int i = 0; i < V; i++)
                parent.add(-1);
            Queue<Integer> q = new LinkedList<>();
            parent.set(source, source);
            q.add(source);
            while (!q.isEmpty() && parent.get(sink) == -1) {
                int here = q.peek();
                q.poll();
                for (int there = 0; there < V; ++there)
                    if (capacity[here][there] - flow[here][there] > 0 && parent.get(there) == -1) {
                        q.add(there);
                        parent.set(there, here);
                    }
            }
            if (parent.get(sink) == -1)
                break;

            int amount = INF;
            String printer = "path : ";
            StringBuilder sb = new StringBuilder();
            for (int p = sink; p != source; p = parent.get(p)) {
                amount = Math.min(capacity[parent.get(p)][p] - flow[parent.get(p)][p], amount);
                sb.append(p + "-");
            }
            sb.append(source);
            for (int p = sink; p != source; p = parent.get(p)) {
                flow[parent.get(p)][p] += amount;
                flow[p][parent.get(p)] -= amount;
            }
            totalFlow += amount;
            printer += sb.reverse() + " / max flow : " + totalFlow;
            System.out.println(printer);
        }

        return totalFlow;
    }

    private static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    private static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    private static void radixsort(int arr[], int n) {

        int m = getMax(arr, n);


        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    public static void findPrimesTillN(int n) {
        int[] arr = new int[n+1];

        for (int i=0;i<=n;i++) {
            arr[i] = 1;
        }

        arr[0] = arr[1] = 0;

        for (int i=2;i<=Math.sqrt(n);i++) {
            if (arr[i] == 1) {
                for (int j=2;i*j <= n;j++) {
                    arr[i*j] = 0;
                }
            }
        }

        for (int i=0;i<n+1;i++) {
            if (arr[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static int gcd(int num1, int num2) {

        if (num1 == 0)
            return num2;

        while (num2 != 0) {
            if (num1 > num2)
                num1 -= num2;
            else
                num2 -= num1;
        }

        return num1;
    }
    
    public static void main(String[] args) {
        foo(0, 0, 0);
    }
}
