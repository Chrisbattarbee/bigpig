package server;

import com.google.protobuf.ByteString;
import com.romix.scala.collection.concurrent.TrieMap;
import ctrie.*;
import io.grpc.stub.StreamObserver;
import utils.ByteStringManipulation;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class CTrieService extends CTrieServiceGrpc.CTrieServiceImplBase {

    private TrieMap<Object, Object> cTrie;
    private final Set<Object> solvedPaths;
    private AtomicInteger totalNumberOfHits;
    private final Random random;

    public CTrieService() {
        cTrie = new TrieMap<>();
        totalNumberOfHits = new AtomicInteger(0);
        random = new Random();
        solvedPaths = new HashSet<>();
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
        this.totalNumberOfHits.incrementAndGet();

        Object deserializedKey = ByteStringManipulation.byteStringToObject(request.getSerializedKeyObject());
        Object deserializedValue = ByteStringManipulation.byteStringToObject(request.getSerializedValueObject());

        System.out.println("Putting (" + deserializedKey + ", " + deserializedValue + ") into the CTrie");

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

        this.totalNumberOfHits.addAndGet(((Map<?, ?>)deserializedMap).size());

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
        ByteString serializedKeySet = ByteStringManipulation.objectToByteString(cTrie.keySet());

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
        ByteString serializedSnapshot = ByteStringManipulation.objectToByteString(cTrie.snapshot());

        responseObserver.onNext(SnapshotResponse.newBuilder().setSerializedCTrie(serializedSnapshot).build());
        responseObserver.onCompleted();
    }

    @Override
    // N is rounded up to the nearest multiple of 5
    public void getNextNPaths(GetNextNPathsRequest request, StreamObserver<GetNextNPathsResponse> responseObserver) {

        System.out.println(this.cTrie.size());

        if (this.cTrie.size() == 0) {
            System.out.println("Hello");
            responseObserver.onNext(GetNextNPathsResponse.newBuilder().setSerializedPathCollection(ByteStringManipulation.objectToByteString(new HashSet<>(this.cTrie.keySet()))).build());
            responseObserver.onCompleted();
            return;
        }

        Set<Object> returnSet = new HashSet<>();

        AtomicReference<Iterator<Map.Entry<Object, Object>>> iterator = new AtomicReference<>(cTrie.iterator());

        int advanceBy = random.nextInt(cTrie.size());
        IntStream.range(0, advanceBy).forEach(x -> {
            if (!iterator.get().hasNext()) {
                iterator.set(cTrie.iterator());
            }
            iterator.get().next();
        });

        while (returnSet.size() < request.getN()) {
            if (!iterator.get().hasNext()) {
                iterator.set(cTrie.iterator());
            }

            Map.Entry<Object, Object> entry = iterator.get().next();
            System.out.println(totalNumberOfHits.get());
            if (random.nextInt(totalNumberOfHits.get()) >= (Integer) entry.getValue()) {
                String str = (String)entry.getKey();

                returnSet.add(str.substring(0, str.length() - 1) + "0");
                returnSet.add(str.substring(0, str.length() - 1) + "1");
                returnSet.add(str.substring(0, str.length() - 1) + "00");
                returnSet.add(str.substring(0, str.length() - 1) + "01");
                returnSet.add(str.substring(0, str.length() - 1) + "11");
            }
        }

        solvedPaths.addAll(returnSet);
        responseObserver.onNext(GetNextNPathsResponse.newBuilder().setSerializedPathCollection(ByteStringManipulation.objectToByteString(returnSet)).build());
        responseObserver.onCompleted();
    }
}
