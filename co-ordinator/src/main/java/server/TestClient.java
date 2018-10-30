package server;

import ctrie.CoordinatorCTrie;
import utils.ByteStringManipulation;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class TestClient {
    public static void main(String[] args) {
        CoordinatorCTrie map = new CoordinatorCTrie("localhost", ByteStringManipulation.PORT_NUMBER);
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

        System.out.println("Adding (4,4) with async putAll");
        hMap.put(4, 4);
        map.putAllAsync(hMap);
        System.out.println("");
        System.out.println("Immediate value associated with key 4:" + map.get(4));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Delayed value associated with key 4:" + map.get(4));

    }
}
