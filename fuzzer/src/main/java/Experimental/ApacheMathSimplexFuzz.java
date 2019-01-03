package Experimental;

import Settings.FuzzerSettings;
import Utils.FuzzingUtils;
import Utils.MethodInfo;
import Utils.RemoteParamSupplier;
import ctrie.CoordinatorCTrie;
import jwp.fuzz.*;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import seedbag.CoordinatorSeedBag;

import java.nio.ByteBuffer;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static Settings.FuzzerSettings.*;

public class ApacheMathSimplexFuzz {

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
        public static ParamGenerator<byte[]> createByteArrayGenerator(Integer... seeds) {
            List<byte[]> seedValues = Arrays.stream(seeds).map(ApacheMathSimplexFuzz::intToByteArr).collect(Collectors.toList());
            return ByteArrayParamGenerator.suggested(byte[].class,
                    ByteArrayParamGenerator.Config.builder().initialValues(seedValues).build());
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

        private static CoordinatorCTrie<String, Integer> ctrie;
        private static CoordinatorSeedBag<Object[]> seedBag;

        //TODO[gg]: Make this take some kind of config class
        public static void fuzzWithConfig(Object[][] seeds) throws Throwable {
            MethodInfo methodInfo = MethodInfo.fromJsonFile("/home/ggavriil/Programming/bigpig-extra/method.json");
            boolean[] suggested = new boolean[]{ false, false, false, false };
            //ParamProvider paramProvider = FuzzingUtils.getParamProvider(methodInfo, seeds, suggested);
            ParamProvider paramProvider = FuzzingUtils.getParamProviderWithExternal(methodInfo, new RemoteParamSupplier(methodInfo, () -> {
                try {
                    return new Object[][] {seedBag.take()};
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }));
            Set<Integer> seenPathHashes = Collections.newSetFromMap(new ConcurrentHashMap<>());
            // Create a fuzzer from configuration (which is created with a builder)
            Fuzzer fuzzer = new Fuzzer(Fuzzer.Config.builder().
                    // Let the fuzzer know to fuzz the isNum method
                            method(ApacheMathSimplexFuzz.class.getDeclaredMethod("LPTestByte", byte[].class, byte[].class, byte[].class, byte[].class)).
                    // We need to give the fuzzer a parameter provider. Here, we just use the suggested one.
                            params(paramProvider).

                    // Let's print out the parameter and result of each unique path
                            onEachResult(res -> {
                        // Create hash sans hit counts
                        int hash = BranchHit.Hasher.WITHOUT_HIT_COUNTS.hash(res.branchHits);
                        // Synchronized to prevent stdout overwrites
                        if (seenPathHashes.add(hash)) synchronized (ApacheMathSimplexFuzz.class) {
                            try {
                                ctrie.putAsync(res.pathString, ctrie.getOrDefault(res.pathString, 0) + 1);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.printf("Unique path for params '%d %d %d %d': %s\n", byteArrToInt((byte[])res.params[0]),
                                    byteArrToInt((byte[])res.params[1]), byteArrToInt((byte[])res.params[2]),
                                    byteArrToInt((byte[])res.params[3]), res.exception == null ? res.result : res.exception);
                        }
                    }).
                    // Build the configuration
                            build()
            );
            // Just run it for 5 seconds
            fuzzer.fuzzFor(300, TimeUnit.SECONDS);
        }

        public static void main(String[] args) throws Throwable {
            try {
                System.out.printf("%s:%d", settings().ctrieHostname, (int) settings().ctriePort);
                seedBag = new CoordinatorSeedBag<>(settings().seedbagHostname, (int) settings().seedbagPort);
                ctrie = new CoordinatorCTrie<>(settings().ctrieHostname, (int) settings().ctriePort);
            } catch(Exception e) {
                System.out.println("Couldn't initialise CTrie and Seedbag");
                e.printStackTrace();
                seedBag = null;
                ctrie = null;
            }
            List<Object[][]> seeds = new ArrayList<>();
            seeds.add(new Object[][]{ new Object[] {4}, new Object[]{1}, new Object[]{3}, new Object[]{-6} });
            seeds.add(new Object[][]{ new Object[] {12}, new Object[]{7}, new Object[]{-1}, new Object[]{-6} });
            for(int i = 0; i < 2; i++) {
                fuzzWithConfig(seeds.get(i));
                System.out.println("---------------------------------------------------------------------------");
            }
            System.out.printf("Test:\n %f (Should be 7.7)\n", LPTest(4, 1, 3, -6));
            while(true) {
                Object[] seedArr = seedBag.take();
                Object[][] newSeed = new Object[][]{ new Object[] {seedArr[0]}, new Object[]{seedArr[1]}, new Object[]{seedArr[2]}, new Object[]{seedArr[3]} };
                fuzzWithConfig(newSeed);
            }
        }
}
