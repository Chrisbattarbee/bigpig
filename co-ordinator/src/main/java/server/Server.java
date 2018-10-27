package server;

import com.romix.scala.collection.concurrent.TrieMap;
import ctrie.*;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import utils.ByteStringManipulation;

import java.io.IOException;
import java.util.Map;

public class Server extends CTrieServiceGrpc.CTrieServiceImplBase {

    private Map<Object, Object> cTrie;
    io.grpc.Server server;

    public Server() {
        cTrie = new TrieMap<>();
    }

    public void start() {
        server = ServerBuilder.forPort(ByteStringManipulation.PORT_NUMBER).addService(new Server()).build();
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

    @Override
    public void size(SizeRequest request, StreamObserver<SizeResponse> responseObserver) {
        responseObserver.onNext(SizeResponse.newBuilder().setSize(cTrie.size()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void isEmpty(IsEmptyRequest request, StreamObserver<IsEmptyResponse> responseObserver) {
        responseObserver.onNext(IsEmptyResponse.newBuilder().setIsEmpty(cTrie.isEmpty()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void containsKey(ContainsKeyRequest request, StreamObserver<ContainsKeyResponse> responseObserver) {
        Object deserializedObject = ByteStringManipulation.byteStringToObject(request.getSerializedObject());

        responseObserver.onNext(ContainsKeyResponse.newBuilder().setContainsKey(cTrie.containsKey(deserializedObject)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void containsValue(ContainsValueRequest request, StreamObserver<ContainsValueResponse> responseObserver) {
        Object deserializedObject = ByteStringManipulation.byteStringToObject(request.getSerializedObject());

        responseObserver.onNext(ContainsValueResponse.newBuilder().setContainsValue(cTrie.containsKey(deserializedObject)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
        super.get(request, responseObserver);
    }

    @Override
    public void put(PutRequest request, StreamObserver<PutResponse> responseObserver) {
        super.put(request, responseObserver);
    }

    @Override
    public void remove(RemoveRequest request, StreamObserver<RemoveResponse> responseObserver) {
        super.remove(request, responseObserver);
    }

    @Override
    public void putAll(PutAllRequest request, StreamObserver<PutAllResponse> responseObserver) {
        super.putAll(request, responseObserver);
    }

    @Override
    public void clear(ClearRequest request, StreamObserver<ClearResponse> responseObserver) {
        super.clear(request, responseObserver);
    }

    @Override
    public void keySet(KeySetRequest request, StreamObserver<KeySetResponse> responseObserver) {
        super.keySet(request, responseObserver);
    }

    @Override
    public void values(ValuesRequest request, StreamObserver<ValuesResponse> responseObserver) {
        super.values(request, responseObserver);
    }

    @Override
    public void entrySet(EntrySetRequest request, StreamObserver<EntrySetResponse> responseObserver) {
        super.entrySet(request, responseObserver);
    }


}
