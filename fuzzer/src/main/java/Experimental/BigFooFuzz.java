package Experimental;

import Utils.FuzzingUtils;
import Utils.MethodInfo;
import ctrie.CoordinatorCTrie;
import jwp.fuzz.*;
import org.mockito.cglib.core.Local;
import seedbag.CoordinatorSeedBag;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Settings.FuzzerSettings.settings;

public class BigFooFuzz {
        private static final boolean useSeedbagAndCTrie = true;
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
            List<byte[]> seedValues = Arrays.stream(seeds).map(BigFooFuzz::intToByteArr).collect(Collectors.toList());
            return ByteArrayParamGenerator.suggested(byte[].class,
                    ByteArrayParamGenerator.Config.builder().initialValues(seedValues).build());
        }


        private static CoordinatorCTrie<String, Integer> ctrie;
        private static CoordinatorSeedBag<Object[]> seedBag;
        private static final MethodInfo methodInfo = new MethodInfo("foo",
                new MethodInfo.ParamInfo[]{new MethodInfo.ParamInfo("n", MethodInfo.PrimitiveType.INT),
                                           new MethodInfo.ParamInfo("m", MethodInfo.PrimitiveType.INT),
                                           new MethodInfo.ParamInfo("x", MethodInfo.PrimitiveType.INT)},
                MethodInfo.PrimitiveType.INT, "BigFoo");
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
            Method declaredMethod = useSuggested ? ApacheMathTest.class.getDeclaredMethod("foo", int.class, int.class, int.class)
                    : ApacheMathTest.class.getDeclaredMethod("fooByte", byte[].class, byte[].class, byte[].class);
            Function<Object, Integer> outParser = useSuggested ? BigFooFuzz::objNoOp : BigFooFuzz::objByteArrToInt;
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
                        if (seenPathHashes.add(hash)) synchronized (BigFooFuzz.class) {
                            if(useSeedbagAndCTrie) {
                                try {
                                    ctrie.putAsync(res.pathString, ctrie.getOrDefault(res.pathString, 0) + 1);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            allPaths.put(res.pathString, (byte) 0);
//                            System.out.printf("Unique path for params '%d %d %d': %s\n", outParser.apply(res.params[0]),
//                                    outParser.apply(res.params[1]), outParser.apply(res.params[2]),
//                                    res.exception == null ? res.result : res.exception);
                        }
                    }).
                    // Build the configuration
                            build()
            );
            // Just run it for 5 seconds
            fuzzer.fuzzFor(12, TimeUnit.SECONDS);
        }


        private static Fuzzer.Config getConfig(Object[][] seeds, boolean useSuggested, Set<Integer> seenPathHashes) throws NoSuchMethodException {
            boolean[] suggested = new boolean[]{ useSuggested, useSuggested, useSuggested, useSuggested };
            ParamProvider paramProvider = FuzzingUtils.getParamProvider(methodInfo, seeds, suggested);
            Method declaredMethod = useSuggested ? ApacheMathTest.class.getDeclaredMethod("foo", int.class, int.class, int.class)
                    : ApacheMathTest.class.getDeclaredMethod("fooByte", byte[].class, byte[].class, byte[].class);
            Function<Object, Integer> outParser = useSuggested ? BigFooFuzz::objNoOp : BigFooFuzz::objByteArrToInt;
            return Fuzzer.Config.builder().
                    // Let the fuzzer know to fuzz the isNum method
                            method(declaredMethod).
                    // We need to give the fuzzer a parameter provider. Here, we just use the suggested one.
                            params(paramProvider).

                    // Let's print out the parameter and result of each unique path
                            onEachResult(res -> {
                        // Create hash sans hit counts
                        int hash = BranchHit.Hasher.WITHOUT_HIT_COUNTS.hash(res.branchHits);
                        // Synchronized to prevent stdout overwrites
                        if (seenPathHashes.add(hash)) synchronized (BigFooFuzz.class) {
                            if(useSeedbagAndCTrie) {
                                try {
                                    ctrie.putAsync(res.pathString, ctrie.getOrDefault(res.pathString, 0) + 1);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            allPaths.put(res.pathString, (byte) 0);
//                            System.out.printf("Unique path for params '%d %d %d': %s\n", outParser.apply(res.params[0]),
//                                    outParser.apply(res.params[1]), outParser.apply(res.params[2]),
//                                    res.exception == null ? res.result : res.exception);
                        }
                    }).
                    // Build the configuration
                            build();
        }

        private abstract static class FuzzerInstance implements Runnable {
            private final Fuzzer.Config fuzzerConfig;
            private LocalDateTime timeStarted;
            private final Set<Integer> seenPathHashes = Collections.newSetFromMap(new ConcurrentHashMap<>());

            public AtomicBoolean getStopper() {
                return stopper;
            }

            private final AtomicBoolean stopper = new AtomicBoolean();

            public FuzzerInstance(Function<Set<Integer>, Fuzzer.Config> fuzzerConfig) {
                this.fuzzerConfig = fuzzerConfig.apply(seenPathHashes);
            }

            public Fuzzer.Config getFuzzerConfig() {
                return fuzzerConfig;
            }

            public LocalDateTime getTimeStarted() {
                return timeStarted;
            }

            public void stop() {
                stopper.set(true);
            }

            public abstract boolean isSeeded();

        }

        private static class UnseededFuzzerInstance extends FuzzerInstance {

            public UnseededFuzzerInstance() {
                super((s) -> {
                    try {
                        return getConfig(new Object[][]{{0}, {0}, {0}}, false, s);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                });
            }

            @Override
            public boolean isSeeded() {
                return false;
            }

            @Override
            public void run() {
                super.timeStarted = LocalDateTime.now();
                Fuzzer fuzzer = new Fuzzer(super.getFuzzerConfig());
                try {
                    fuzzer.fuzz(super.getStopper());
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }

        private static class SeededFuzzerInstance extends FuzzerInstance {
            private final ExecutorService executor;
            private final Object[][] seeds;

            private SeededFuzzerInstance(Object[][] seeds, ExecutorService executor) {
                super((s) -> {
                    try {
                        return getConfig(seeds, false, s);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                });
                this.executor = executor;
                this.seeds = seeds;
            }

            @Override
            public boolean isSeeded() {
                return true;
            }

            @Override
            public void run() {
                super.timeStarted = LocalDateTime.now();
                //TODO How to pause a thread?
            }
        }

        private static void fuzz() throws Throwable {

            while(true) {
                Object[] seedArr = useSeedbagAndCTrie ? seedBag.poll() : new Object[]{0, 0, 0};
                if (seedArr == null) {
                    seedArr = new Object[]{0, 0, 0};
                }

                Object[][] newSeed = new Object[][]{ new Object[] {seedArr[0]}, new Object[]{seedArr[1]}, new Object[]{seedArr[2]} };
                fuzzWithConfig(newSeed, false);
            }
        }

        public static void main(String[] args) throws Throwable {

            if(useSeedbagAndCTrie) {
                try {
                    seedBag = new CoordinatorSeedBag<>(settings().seedbagHostname, (int) settings().seedbagPort);
                    ctrie = new CoordinatorCTrie<>(settings().ctrieHostname, (int) settings().ctriePort);
                } catch (Exception e) {
                    e.printStackTrace();
                    seedBag = null;
                    ctrie = null;
                }
            }

            Supplier<Fuzzer> defaultUnseededFuzzerSuppleir = null;

            int numInstances = Runtime.getRuntime().availableProcessors() - 1;
            AtomicInteger seededFuzzersCount = new AtomicInteger(0);

            PriorityBlockingQueue<FuzzerInstance> unseededFuzzers = new PriorityBlockingQueue<>(10, Comparator.comparing(FuzzerInstance::getTimeStarted));

            IntStream.range(0, numInstances).forEach((i) -> unseededFuzzers.add(new FuzzerInstance(null, null, null, null)));

            Function getNewSeed = () -> {
                try {
                    Object[] seed = seedBag.take();
                    FuzzerInstance oldestUnseededFuzzer = unseededFuzzers.poll();
                    if(oldestUnseededFuzzer != null) {
                        oldestUnseededFuzzer.stop();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            };


            int seconds = Integer.valueOf(args[0]);

            Duration timeout = Duration.ofSeconds(seconds);

            ExecutorService mainExecutor = Executors.newSingleThreadExecutor();

            mainExecutor.submit(() -> {
                ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);

                for(int i = 0; i < Runtime.getRuntime().availableProcessors() - 1; i++) {
                    executor.submit(() -> {
                        try {
                            fuzz();
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    });
                }

                executor.shutdown(); //TODO
                try {
                    executor.awaitTermination(timeout.getNano(), TimeUnit.NANOSECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            mainExecutor.shutdown();
            mainExecutor.awaitTermination(timeout.getNano(), TimeUnit.NANOSECONDS);


            System.out.printf("Total number of paths: %d\n", allPaths.size());
        }
}
