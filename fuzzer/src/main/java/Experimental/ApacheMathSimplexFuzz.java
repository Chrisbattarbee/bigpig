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

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import static Experimental.ApacheMathTest.LPTest;
import static Settings.FuzzerSettings.*;

public class ApacheMathSimplexFuzz {
        private static final boolean useSeedbagAndCTrie = false;
        private static int byteArrToInt(byte[] bytes) {
            return ByteBuffer.wrap(bytes).getInt();
        }

        private static final ConcurrentHashMap<String, Byte> allPaths = new ConcurrentHashMap<>();

        private static byte[] intToByteArr(int num) {
            ByteBuffer buf = ByteBuffer.allocate(4);
            buf.putInt(num);
            return buf.array();
        }

        public static ParamGenerator<byte[]> createByteArrayGenerator(Integer... seeds) {
            List<byte[]> seedValues = Arrays.stream(seeds).map(ApacheMathSimplexFuzz::intToByteArr).collect(Collectors.toList());
            return ByteArrayParamGenerator.suggested(byte[].class,
                    ByteArrayParamGenerator.Config.builder().initialValues(seedValues).build());
        }


        private static CoordinatorCTrie<String, Integer> ctrie;
        private static CoordinatorSeedBag<Object[]> seedBag;
        private static final MethodInfo methodInfo = new MethodInfo("LPTest",
                new MethodInfo.ParamInfo[]{new MethodInfo.ParamInfo("a", MethodInfo.PrimitiveType.INT),
                                           new MethodInfo.ParamInfo("b", MethodInfo.PrimitiveType.INT),
                                           new MethodInfo.ParamInfo("c", MethodInfo.PrimitiveType.INT),
                                           new MethodInfo.ParamInfo("ep", MethodInfo.PrimitiveType.INT)},
                MethodInfo.PrimitiveType.INT, "ApacheMathTest");
        //TODO[gg]: Make this take some kind of config class
        private static int objByteArrToInt(Object obj) {
            byte[] arr = (byte[]) obj;
            return byteArrToInt(arr);
        }

        private static int objNoOp(Object obj) {
            return (int) obj;
        }

        public static void fuzzWithConfig(Object[][] seeds, boolean useSuggested) throws Throwable {
            //MethodInfo methodInfo = MethodInfo.fromJsonFile("/home/ggavriil/Programming/bigpig-extra/method.json");
            boolean[] suggested = new boolean[]{ useSuggested, useSuggested, useSuggested, useSuggested };
            ParamProvider paramProvider = FuzzingUtils.getParamProvider(methodInfo, seeds, suggested);
            Method declaredMethod = useSuggested ? ApacheMathTest.class.getDeclaredMethod("LPTest", int.class, int.class, int.class, int.class)
                    : ApacheMathTest.class.getDeclaredMethod("LPTestByte", byte[].class, byte[].class, byte[].class, byte[].class);
            Function<Object, Integer> outParser = useSuggested ? ApacheMathSimplexFuzz::objNoOp : ApacheMathSimplexFuzz::objByteArrToInt;
            /*
            ParamProvider paramProvider = FuzzingUtils.getParamProviderWithExternal(methodInfo, new RemoteParamSupplier(methodInfo, () -> {
                try {
                    return new Object[][] {seedBag.take()};
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }));
            */
            Set<Integer> seenPathHashes = Collections.newSetFromMap(new ConcurrentHashMap<>());
            // Create a fuzzer from configuration (which is created with a builder)
            Fuzzer fuzzer = new Fuzzer(Fuzzer.Config.builder().
                    // Let the fuzzer know to fuzz the isNum method
                            method(declaredMethod).
                    // We need to give the fuzzer a parameter provider. Here, we just use the suggested one.
                            params(paramProvider).

                    // Let's print out the parameter and result of each unique path
                            onEachResult(res -> {
                        // Create hash sans hit counts
                        int hash = BranchHit.Hasher.WITHOUT_HIT_COUNTS.hash(res.branchHits);
                        // Synchronized to prevent stdout overwrites
                        if (seenPathHashes.add(hash)) synchronized (ApacheMathSimplexFuzz.class) {
                            if(useSeedbagAndCTrie) {
                                try {
                                    ctrie.putAsync(res.pathString, ctrie.getOrDefault(res.pathString, 0) + 1);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            allPaths.put(res.pathString, (byte) 0);
                            System.out.printf("Unique path for params '%d %d %d %d': %s\n", outParser.apply(res.params[0]),
                                    outParser.apply(res.params[1]), outParser.apply(res.params[2]),
                                    outParser.apply(res.params[3]), res.exception == null ? res.result : res.exception);
                        }
                    }).
                    // Build the configuration
                            build()
            );
            // Just run it for 5 seconds
            fuzzer.fuzzFor(10, TimeUnit.SECONDS);
        }

        public static void main(String[] args) throws Throwable {

            if(useSeedbagAndCTrie) {
                try {
                    System.out.printf("%s:%d", settings().ctrieHostname, (int) settings().ctriePort);
                    seedBag = new CoordinatorSeedBag<>(settings().seedbagHostname, (int) settings().seedbagPort);
                    ctrie = new CoordinatorCTrie<>(settings().ctrieHostname, (int) settings().ctriePort);
                } catch (Exception e) {
                    System.out.println("Couldn't initialise CTrie and Seedbag");
                    e.printStackTrace();
                    seedBag = null;
                    ctrie = null;
                }
            }
            /*
            List<Object[][]> seeds = new ArrayList<>();
            seeds.add(new Object[][]{ new Object[] {4}, new Object[]{1}, new Object[]{3}, new Object[]{-6} });
            seeds.add(new Object[][]{ new Object[] {12}, new Object[]{7}, new Object[]{-1}, new Object[]{-6} });
            for(int i = 0; i < 2; i++) {
                fuzzWithConfig(seeds.get(i));
                System.out.println("---------------------------------------------------------------------------");
            }
            */

            //TODO: Maybe get this as an argument
            Duration timeout = Duration.ofSeconds(20);

            System.out.printf("Test:\n %f (Should be 7.7)\n", LPTest(4, 1, 3, -6));

            long startTime = System.nanoTime();

            while(System.nanoTime() - startTime < timeout.toNanos()) {
                Object[] seedArr = useSeedbagAndCTrie ? seedBag.take() : new Object[]{0, 0, 0, 0};
                Object[][] newSeed = new Object[][]{ new Object[] {seedArr[0]}, new Object[]{seedArr[1]}, new Object[]{seedArr[2]}, new Object[]{seedArr[3]} };
                fuzzWithConfig(newSeed, false);
            }

            System.out.printf("Total number of paths: %d\n", allPaths.size());
        }
}
