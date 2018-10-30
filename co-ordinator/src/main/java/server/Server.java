package server;

import com.google.protobuf.ByteString;
import com.romix.scala.collection.concurrent.TrieMap;
import ctrie.*;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import utils.ByteStringManipulation;

import java.io.IOException;
import java.util.Map;

public class Server extends CTrieServiceGrpc.CTrieServiceImplBase {

    private TrieMap<Object, Object> cTrie;
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
        Object deserializedKey = ByteStringManipulation.byteStringToObject(request.getSerializedObject());

        responseObserver.onNext(GetResponse.newBuilder().setSerializedObject(ByteStringManipulation.objectToByteString(cTrie.get(deserializedKey))).build());
        responseObserver.onCompleted();
    }

    @Override
    public void put(PutRequest request, StreamObserver<PutResponse> responseObserver) {
        Object deserializedKey = ByteStringManipulation.byteStringToObject(request.getSerializedKeyObject());
        Object deserializedValue = ByteStringManipulation.byteStringToObject(request.getSerializedValueObject());

        Object prevValue = cTrie.put(deserializedKey, deserializedValue);

        responseObserver.onNext(PutResponse.newBuilder().setSerializedValueObject(ByteStringManipulation.objectToByteString(prevValue)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void remove(RemoveRequest request, StreamObserver<RemoveResponse> responseObserver) {
        Object deserializedKey = ByteStringManipulation.byteStringToObject(request.getSerializedKeyObject());

        Object prevValue = cTrie.remove(deserializedKey);

        responseObserver.onNext(RemoveResponse.newBuilder().setSerializedValueObject(ByteStringManipulation.objectToByteString(prevValue)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void putAll(PutAllRequest request, StreamObserver<PutAllResponse> responseObserver) {
        Object deserializedMap = ByteStringManipulation.byteStringToObject(request.getSerializedMapObject());

        cTrie.putAll((Map<?, ?>) deserializedMap);

        responseObserver.onNext(PutAllResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void clear(ClearRequest request, StreamObserver<ClearResponse> responseObserver) {
        cTrie.clear();

        responseObserver.onNext(ClearResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void keySet(KeySetRequest request, StreamObserver<KeySetResponse> responseObserver) {
        ByteString serializedKeySet  = ByteStringManipulation.objectToByteString(cTrie.keySet());

        responseObserver.onNext(KeySetResponse.newBuilder().setSerializedSet(serializedKeySet).build());
        responseObserver.onCompleted();
    }

    @Override
    public void values(ValuesRequest request, StreamObserver<ValuesResponse> responseObserver) {
        ByteString serializedCollection = ByteStringManipulation.objectToByteString(cTrie.values());

        responseObserver.onNext(ValuesResponse.newBuilder().setSerializedCollection(serializedCollection).build());
        responseObserver.onCompleted();
    }

    @Override
    public void entrySet(EntrySetRequest request, StreamObserver<EntrySetResponse> responseObserver) {
        ByteString serializedEntrySet = ByteStringManipulation.objectToByteString(cTrie.entrySet());

        responseObserver.onNext(EntrySetResponse.newBuilder().setSerializedSet(serializedEntrySet).build());
        responseObserver.onCompleted();
    }

    @Override
    public void snapshot(SnapshotRequest request, StreamObserver<SnapshotResponse> responseObserver) {
        ByteString serializedCTrie = ByteStringManipulation.objectToByteString(cTrie.snapshot());

        responseObserver.onNext(SnapshotResponse.newBuilder().setSerializedCTrie(serializedCTrie).build());
        responseObserver.onCompleted();
    }


}
