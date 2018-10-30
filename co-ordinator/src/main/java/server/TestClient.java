package server;

import com.romix.scala.collection.concurrent.TrieMap;
import ctrie.CTrieMap;
import ctrie.CoordinatorCTrie;
import utils.ByteStringManipulation;

import java.util.*;

public class TestClient {
    public static void main(String[] args) {
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
}
