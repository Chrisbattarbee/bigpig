package Numbers;

import ctrie.CTrieMap;
import ctrie.CoordinatorCTrie;
import jwp.extras.TestWriter;
import jwp.fuzz.*;
import seedbag.CoordinatorSeedBag;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Num {

    public static byte[] objectToBytes(Object obj) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            out.flush();
            byte[] yourBytes = bos.toByteArray();
            //System.out.println(Arrays.toString(yourBytes));
            return yourBytes;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
        return bos.toByteArray();
    }
    public static void main(String[] args) throws Exception {

        //CoordinatorSeedBag<Integer> seedbag = new CoordinatorSeedBag<Integer>("coordinatorservice.default.svc.cluster.local", 8080);

        CoordinatorSeedBag<HashMap<String, Integer>> seedbag = new CoordinatorSeedBag<>("localhost", 8080);
        CoordinatorCTrie<String, Integer> ctrie = new CoordinatorCTrie<>("localhost", 8080);
        ctrie.put("0", 1);
        ctrie.put("1", 1);
        ctrie.put("00", 1);
        ctrie.put("01", 1);
        //List<Integer> seeds = seedbag.takeN(4);
        List<Integer> seeds = new ArrayList<>();
        seeds.add(3);
        seeds.add(4);
        seeds.add(17);
        seeds.add(9);
        seeds.add(121);
        seeds.add(62);
        for(int i = 0; i < 6; i++) {
            //seeds.add(seedbag.poll());
        }
        TestWriter testWriter = new TestWriter.JUnit4(new TestWriter.Config("Numbers.NumTest"));

        // Keep track of unique paths
        Set<Integer> seenPathHashes = new HashSet<>();
        final List<byte[]> pal = new ArrayList<>();
        //pal.add(objectToBytes((Object) Integer.valueOf(3)));
        //pal.add(objectToBytes((Object) Integer.valueOf(4)));
        //pal.add(objectToBytes((Object) Integer.valueOf(9)));
        //pal.add(objectToBytes((Object) Integer.valueOf(121)));
        //pal.add(ByteBuffer.allocate(4).putInt(121).array());
        //pal.add(ByteBuffer.allocate(4).putInt(3).array());
        //pal.add(objectToBytes((Object) Integer.valueOf(19)));
        //pal.add(objectToBytes((Object) Integer.valueOf(60)));

//        ByteArrayParamGenerator.Config bagConfig = ByteArrayParamGenerator.Config.builder().inputQueueCreator((c) -> {
//            ArrayList<ByteArrayParamGenerator.TestCase> q = new ArrayList<>();
//            q.add(new ByteArrayParamGenerator.TestCase(objectToBytes(Integer.valueOf(4))));
//            q.add(new ByteArrayParamGenerator.TestCase(objectToBytes(Integer.valueOf(3))));
            //q.add(new ByteArrayParamGenerator.TestCase(ByteBuffer.allocate(4).putInt(121).array()));
            //q.add(new ByteArrayParamGenerator.TestCase(ByteBuffer.allocate(4).putInt(3).array()));
            //q.add(new ByteArrayParamGenerator.TestCase(ByteBuffer.allocate(4).putInt(4).array()));
            //q.add(new ByteArrayParamGenerator.TestCase(ByteBuffer.allocate(4).putInt(9).array()));
            //q.add(new ByteArrayParamGenerator.TestCase(ByteBuffer.allocate(4).putInt(19).array()));
            //q.add(new ByteArrayParamGenerator.TestCase(ByteBuffer.allocate(4).putInt(60).array()));
            //q.add(4);
            //q.add(9);
            //q.add(121);
            //q.add(19);
            //q.add(60);
//            return new ByteArrayParamGenerator.InputQueue.ListBacked(q, c.hasher);
//        }).build();

//        ParamProvider provider = new ParamProvider.Suggested(ByteArrayParamGenerator.suggested(byte[].class, bagConfig));
        // Create a fuzzer from configuration (which is created with a builder)
        Fuzzer fuzzer = new Fuzzer(Fuzzer.Config.builder().
                        invoker(new Invoker.WithExecutorService(Executors.newFixedThreadPool(/*Runtime.getRuntime().availableProcessors()))*/1))).
                // Let the fuzzer know to fuzz the isNum method
                        method(Num.class.getDeclaredMethod( "toString", int.class)).
                // We need to give the fuzzer a parameter provider. Here, we just use the suggested one.
                          params(new ParamProviderSuggested(seenPathHashes, ctrie, seedbag, ParamGenerator.suggested(Integer.class))).
//                          params(new SeedbagParamProvider(seedbag, ParamProvider.suggested(Integer.class))).
               //         params(provider).

                // Build the configuration
                        build()
        );
        try {
            fuzzer.fuzzFor(60, TimeUnit.SECONDS);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //System.out.println(seenPathHashes);
        try {
            FileWriter fileWriter = new FileWriter("/tmp/test.java");
            testWriter.flush(fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Could not write test");
        }
    }

    public static String toString(int s) {
        if(s == 153) {
            return "153";
        }
        if(s == 4) {
            return "4";
        }
        if(s == 9) {
            return "9";
        }
        if(s == 121) {
            return "121";
        }
        if(s == 62) {
            return "62";
        }
        if(s == 17) {
            return "17";
        }

        return Integer.toString(s);
    }


}