package server;

import com.romix.scala.collection.concurrent.TrieMap;
import ctrie.CTrieMap;
import ctrie.CoordinatorCTrie;
import seedbag.CoordinatorSeedBag;
import utils.ByteStringManipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestClient {
    public static void main(String[] args) {
        cTrieDiagnostics();
        seedbagDiagnostics();
    }

    private static void cTrieDiagnostics() {
        CTrieMap map = new CoordinatorCTrie("localhost", ByteStringManipulation.PORT_NUMBER);
        System.out.println("size: " + map.size());

        System.out.println("Putting 1, 5 into the map");
        map.put(1, 5);
        System.out.println("size: " + map.size());
        System.out.println("Value associated with key 1: " + map.get(1));
        System.out.println("Value associated with key 0: " + map.get(0));

        System.out.println("Creating snapshot of map CTrie locally");
        TrieMap snapshot = map.snapshot();
        System.out.println("Snapshot value associated with key 1: " + map.get(1));
        System.out.println("Snapshot value associated with key 0: " + map.get(0));

        System.out.println("Removing 1 from map");
        map.remove(1);
        System.out.println("size: " + map.size());

        System.out.println("Using putAll and a hashmap to add 1, 10 and 3, 4 to the map");
        Map<Integer, Integer> hMap = new HashMap<>();
        hMap.put(1, 10);
        hMap.put(3, 4);
        map.putAll(hMap);
        System.out.println("size: " + map.size());
        System.out.println("Value associated with key 1: " + map.get(1));
        System.out.println("Value associated with key 3: " + map.get(3));

        System.out.println("Clearing map");
        map.clear();
        System.out.println("size: " + map.size());

        //Async testing
        System.out.println("Size before putasync: " + map.size());
        map.putAsync(2, 6);
        System.out.println("Size after putasync: " + map.size());

        System.out.println("Replacing key 2");
        Future<Integer> replacementFuture= map.putAsync(2, 9);
        try {
            System.out.println("Old value at 2 was: " + replacementFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("\nTesting async putAll");
        System.out.println("Running async putAll for (10,10), (11,11)");
        hMap.put(10,10);
        hMap.put(11,11);
        map.putAllAsync(hMap);
        System.out.println("Value at 10: " + map.get(10));
        try {
            System.out.println("Sleeping 0.5s");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Value at 11: " + map.get(11));


        System.out.println("\nAsync put testing:");
        System.out.println("Adding (4,4)");
        map.put(4,4);
        System.out.println("Async replacing (4,4) with (4,999)");
        Future<Integer> futurePut = map.putAsync(4,999);
        checkFuture(futurePut);
        try {
            System.out.println("Sleeping 0.5s");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkFuture(futurePut);

        System.out.println("\nAsync get testing:");
        System.out.println("Async getting value associated with key 4");
        Future<Integer> futureGet = map.getAsync(4);
        checkFuture(futureGet);
        try {
            System.out.println("Sleeping 0.5s");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkFuture(futureGet);
    }

    private static void checkFuture(Future<Integer> future) {
        if(future.isDone()) {
            try {
                System.out.println("Async get value at 4: " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Still waiting for async");
        }
    }

    private static void seedbagDiagnostics() {
        CoordinatorSeedBag<Integer> bag = new CoordinatorSeedBag<>("localhost", 8080);
        System.out.println("Size: " + bag.size());

        System.out.println("Adding 5");
        bag.add(5);

        System.out.println("Adding 10");
        bag.add(10);

        System.out.println("Adding 1");
        bag.add(1);

        System.out.println("Size: " + bag.size());

        System.out.println("Popping front value");
        System.out.println("Value: " + bag.poll());

        System.out.println("Size: " + bag.size());

        System.out.print("ToArray: [");
        for (Object o : bag.toArray()) {
            System.out.print(((Integer) o).intValue() + ",");
        }
        System.out.println("]");


        System.out.println("Clearing bag");
        bag.clear();

        System.out.println("Size: " + bag.size());
    }
}
