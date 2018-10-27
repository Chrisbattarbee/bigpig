package server;

import ctrie.CoordinatorCTrie;
import utils.ByteStringManipulation;

import java.util.HashMap;
import java.util.Map;

public class TestClient {
    public static void main(String[] args) {
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
    }
}
