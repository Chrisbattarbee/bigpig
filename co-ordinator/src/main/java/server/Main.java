package server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
        System.out.println("Started Server");
        server.blockUntilShutDown();
    }
}
