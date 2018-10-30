package server;

import com.romix.scala.collection.concurrent.TrieMap;
import ctrie.CTrieMap;
import ctrie.CoordinatorCTrie;
import seedbag.CoordinatorSeedBag;
import utils.ByteStringManipulation;

import java.util.*;

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
