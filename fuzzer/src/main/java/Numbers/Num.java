package Numbers;

import jwp.extras.TestWriter;
import jwp.fuzz.*;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

public class Num {

    private static Method getDeclaredMethod(Class c, String methodName, Class<?>... classes) {
        try {
            return c.getDeclaredMethod(methodName, classes);
        } catch (NoSuchMethodException e) {
            System.out.println("No such method moron");
            return null;
        }
    }

    public static void main(String[] args) {

        TestWriter testWriter = new TestWriter.JUnit4(new TestWriter.Config("Numbers.NumTest"));

        // Keep track of unique paths
        Set<Integer> seenPathHashes = Collections.newSetFromMap(new ConcurrentHashMap<>());
        // Create a fuzzer from configuration (which is created with a builder)
        Fuzzer fuzzer = new Fuzzer(Fuzzer.Config.builder().
                        invoker(new Invoker.WithExecutorService(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()))).
                // Let the fuzzer know to fuzz the isNum method
                        method(getDeclaredMethod(Num.class, "toString", String.class)).
                // We need to give the fuzzer a parameter provider. Here, we just use the suggested one.
                        params(ParamProvider.suggested(String.class)).
                // Let's print out the parameter and result of each unique path
                        onEachResult(res -> {
                    // Create hash sans hit counts
                    int hash = BranchHit.Hasher.WITHOUT_HIT_COUNTS.hash(res.branchHits);
                    // Synchronized to prevent stdout overwrites
                    if (seenPathHashes.add(hash)) synchronized (Num.class) {
                        System.out.printf("Unique path for param '%s': %s\n", res.params[0],
                                res.exception == null ? res.result : res.exception);
                        try {
                            testWriter.append(res);
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                }).
                // Build the configuration
                        build()
        );
        try {
            fuzzer.fuzzFor(10, TimeUnit.SECONDS);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("/tmp/test.java");
            testWriter.flush(fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Could not write test");
        }
    }

    public static String toString(String s) {
        try {
            Integer.parseInt(s);
            return s;
        } catch (Exception e) {
            return "";
        }
    }
}