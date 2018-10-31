package server;

import ctrie.CoordinatorCTrie;
import seedbag.CoordinatorSeedBag;
import utils.ByteStringManipulation;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestClient {
    public static void main(String[] args) throws InterruptedException {
//        cTrieDiagnostics();
        seedbagDiagnostics();
    }

    private static void cTrieDiagnostics() {
        Map map = new CoordinatorCTrie("localhost", ByteStringManipulation.PORT_NUMBER);
        System.out.println("size: " + map.size());

        System.out.println("Putting 1, 5 into the map");
        map.put(1, 5);
        System.out.println("size: " + map.size());
        System.out.println("Value associated with key 1: " + map.get(1));
        System.out.println("Value associated with key 0: " + map.get(0));

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
    }

    private static void seedbagDiagnostics() throws InterruptedException {
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
        bag.put(12);
        Collections.addAll(bag, 1, 2, 3, 4, 5, 6);
        List<Integer> result = bag.takeN(5);
        List<Integer> resultPoll = bag.pollN(5, 5, TimeUnit.SECONDS);
        System.out.println(Arrays.toString(result.toArray()));
        System.out.println(Arrays.toString(resultPoll.toArray()));
        System.out.println(bag.size());
    }
}
