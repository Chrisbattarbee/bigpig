package server;

import ctrie.CoordinatorCTrie;
import utils.ByteStringManipulation;

import java.util.Map;

public class TestClient {
    public static void main(String[] args) {
        Map map = new CoordinatorCTrie("localhost", ByteStringManipulation.PORT_NUMBER);
        System.out.println("size: " + map.size());

        System.out.println("Putting 1, 5 into the map");
        map.put(1, 5);
        System.out.println("size: " + map.size());
    }
}
