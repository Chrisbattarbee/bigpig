package server;

import ctrie.CoordinatorCTrie;
import utils.ByteStringManipulation;

import java.util.Map;

public class TestClient {
    public static void main(String[] args) {
        Map map = new CoordinatorCTrie("localhost", ByteStringManipulation.PORT_NUMBER);
        System.out.println(map.size());
    }
}
