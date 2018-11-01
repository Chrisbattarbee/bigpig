package server;

import io.grpc.ServerBuilder;
import utils.ByteStringManipulation;

import java.io.IOException;

public class Server {

    private final io.grpc.Server server;
  
    public Server() {
        server = ServerBuilder
                .forPort(ByteStringManipulation.PORT_NUMBER)
                .addService(new CTrieService())
                .addService(new SeedBagService())
                .build();
    }

    public void start() {
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void blockUntilShutDown() {
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
