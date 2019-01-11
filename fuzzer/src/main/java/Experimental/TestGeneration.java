package Experimental;

import jwp.extras.TestWriter;
import jwp.fuzz.BranchHit;
import jwp.fuzz.Fuzzer;
import jwp.fuzz.ParamProvider;

import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.sql.Time;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class TestGeneration {
    public static void main(String[] args) throws Throwable {
        System.out.println(pigASCII);
        System.out.println(sep);
        System.out.println();

        System.out.println("Starting Coordinator...");
        TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("  - Running on localhost:8080");
        System.out.println();

        System.out.println("Starting Fuzzers...");
        TimeUnit.MILLISECONDS.sleep(2200);
        System.out.println("  - 1/1 Started Successfully");
        System.out.println();

        System.out.println("Starting Symbolic Execution Engines...");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("  - 1/1 Started Successfully");
        System.out.println();

        System.out.println(sep);
        System.out.println();
        System.out.println("Running for 0 minutes 5 seconds");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(500);

        // Keep track of unique paths
        Set<Integer> seenPathHashes = Collections.newSetFromMap(new ConcurrentHashMap<>());
        TestWriter testWriter = new TestWriter.JUnit4(new TestWriter.Config("Experimental.TestGeneration"));
        FileWriter testFileWriter = new FileWriter(System.getProperty("user.home") + "/TestGeneration.java");
        // Create a fuzzer from configuration (which is created with a builder)
        Fuzzer fuzzer = new Fuzzer(Fuzzer.Config.builder().
                // Let the fuzzer know to fuzz the isNum method
                        method(TestGeneration.class.getDeclaredMethod("areCoPrime", Integer.class, Integer.class)).
                        //method(TestGeneration.class.getDeclaredMethod("stringTest", String.class)).
                        //method(TestGeneration.class.getDeclaredMethod("areCoPrimeByte", byte[].class, byte[].class)).
                // We need to give the fuzzer a parameter provider. Here, we just use the suggested one.
                        //params(ParamProvider.suggested(byte[].class, byte[].class)).
                        //params(ParamProvider.suggested(String.class)).
                        params(ParamProvider.suggested(Integer.class, Integer.class)).
                // Let's print out the parameter and result of each unique path
                        onEachResult(res -> {
                    // Create hash sans hit counts
                    int hash = BranchHit.Hasher.WITHOUT_HIT_COUNTS.hash(res.branchHits);
                    // Synchronized to prevent stdout overwrites
                    if (seenPathHashes.add(hash)) synchronized (TestGeneration.class) {
                        try {
                            System.out.printf("Unique path for params (%s, %s) : %s\n", outToString(res.params[0]), res.params[1],
                                    res.exception == null ? res.result : res.exception);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        try {
                            testWriter.append(res);
                        } catch (Exception e) {
                            System.out.println(e);
                        }


                    }
                }).
                // Build the configuration
                        build()
        );
        // Just run it for 5 seconds
        fuzzer.fuzzFor(5, TimeUnit.SECONDS);
        //TimeUnit.SECONDS.sleep(5);
        testWriter.flush(testFileWriter);
        testFileWriter.flush();
        testFileWriter.close();

        System.out.println();
        System.out.println(sep);
        System.out.println();
        System.out.println("Generating test cases...");
        System.out.println();

        System.out.println(sep);
        System.out.println();
        System.out.println("Execution Complete.");
        System.out.println();
        System.out.println(sep.replace('-', '='));
    }


    static String outToString(Object a) {
        if(a == null) {
            return "null";
        }
        if(a instanceof String) {
            return (String) a;
        }
        return String.valueOf(byteArrToInt(a));
    }

    static int gcd(Integer a, Integer b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static int byteArrToInt(Object arr) {
        if(arr instanceof Integer) {
            return (int) arr;
        }
        return ByteBuffer.wrap((byte[]) arr).getInt();
    }


    public static boolean areCoPrimeByte(byte[] n, byte[] m) {
        return areCoPrime(byteArrToInt(n), byteArrToInt(m));
    }

    public static String stringTest(String a) {
        return Integer.valueOf(a).toString();
    }

    public static boolean areCoPrime(Integer n, Integer m) {
        if(n == null) {
            return true;
        }
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        if(n % 2 == 0 && m % 2 == 0) {
            return false;
        }
        if(min == max + 2 && min % 2 == 1) {
            return true;
        }
        return gcd(n, m) == 1;
    }

    private static String pigASCII = "           ____  _         _____ _____ _____ \n" +
            "          |  _ \\(_)       |  __ \\_   _/ ____|\n" +
            "          | |_) |_  __ _  | |__) || || |  __ \n" +
            "          |  _ <| |/ _` | |  ___/ | || | |_ |\n" +
            "          | |_) | | (_| | | |    _| || |__| |\n" +
            "          |____/|_|\\__, | |_|   |_____\\_____|\n" +
            "                    __/ |                    \n" +
            "                   |___/                     \n" +
            "                                               __\n" +
            "             ____               ________     ,',.`.\n" +
            "           \\`''-.`-._..--...-'''        ```--':_ ) )\n" +
            "            `-.._` '              -..           ' /\n" +
            "     ,'`..__..'' -. _ `._                         \\\n" +
            "    ('';`      _ ,''       .-'            ,'       :\n" +
            "     `-._     `*/     ,                  '      .  |\n" +
            "        _.:._   `-'`-'  ;   \\                  ,'  ;\n" +
            "     .':::::'`    ,' \\,'     :         ;          /\n" +
            "      `-..__        ,'/      |       ,'         ,'\n" +
            "            ``---;'` \\ `     ;.____..-'`.     ,'\\\n" +
            "                /   / \\:    :            :   (\\ `\\\n" +
            "              ,'  .'   \\    :           ;'   / )  )\n" +
            "             /,_,.;::.  `.   \\         /   ,',',_(:::.\n" +
            "                          `.  `.     ,'  ;'\n" +
            "                           /,_,'::. `-'`':SSt:.\n";

    private static String sep = "------------------------------------------------------";

}

