package ctrie;


import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.ByteString;
import com.romix.scala.collection.concurrent.TrieMap;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import utils.ByteStringManipulation;

import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static utils.ByteStringManipulation.*;

public class CoordinatorCTrie<K extends Serializable, V extends Serializable> implements CTrieMap<K, V> {

    private final ManagedChannel channel;
    private final CTrieServiceGrpc.CTrieServiceBlockingStub blockingStub;
    private final CTrieServiceGrpc.CTrieServiceFutureStub futureStub;

    public CoordinatorCTrie() {
        this(ManagedChannelBuilder.forAddress(HOST_NAME, PORT_NUMBER).usePlaintext());
    }

    public CoordinatorCTrie(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public CoordinatorCTrie(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();

        blockingStub = CTrieServiceGrpc.newBlockingStub(channel);
        futureStub   =  CTrieServiceGrpc.newFutureStub(channel);
    }

    @Override
    public int size() {
        SizeRequest sizeRequest = SizeRequest.newBuilder().build();
        return blockingStub.size(sizeRequest).getSize();
    }

    @Override
    public boolean isEmpty() {
        IsEmptyRequest emptyRequest = IsEmptyRequest.newBuilder().build();
        return blockingStub.isEmpty(emptyRequest).getIsEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        ByteString serializedKey = objectToByteString(key);
        ContainsKeyRequest keyRequest = ContainsKeyRequest.newBuilder().setSerializedObject(serializedKey).build();
        return blockingStub.containsKey(keyRequest).getContainsKey();
    }

    @Override
    public boolean containsValue(Object value) {
        ByteString serializedValue = objectToByteString(value);
        ContainsValueRequest valueRequest = ContainsValueRequest.newBuilder().setSerializedObject(serializedValue).build();
        return blockingStub.containsValue(valueRequest).getContainsValue();
    }

    @Override
    public V get(Object key) {
        ByteString serializedKey = objectToByteString(key);
        GetRequest getRequest = GetRequest.newBuilder().setSerializedObject(serializedKey).build();
        return (V) byteStringToObject(blockingStub.get(getRequest).getSerializedObject());
    }

    //Future wrapper for future get response - to convert byte string to object
    public class FutureGetObject implements Future {

        private ListenableFuture<GetResponse> response;

        public FutureGetObject(ListenableFuture<GetResponse> response) {
            this.response = response;
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return response.cancel(mayInterruptIfRunning);
        }

        @Override
        public boolean isCancelled() {
            return response.isCancelled();
        }

        @Override
        public boolean isDone() {
            return response.isDone();
        }

        @Override
        public Object get() throws InterruptedException, ExecutionException {
            return (V) byteStringToObject(response.get().getSerializedObject());
        }

        @Override
        public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) byteStringToObject(response.get(timeout, unit).getSerializedObject());
        }
    }

    @Override
    public Future<V> getAsync(Object key) {
        ByteString serializedKey = objectToByteString(key);
        GetRequest getRequest = GetRequest.newBuilder().setSerializedObject(serializedKey).build();
        ListenableFuture<GetResponse> response = futureStub.get(getRequest);

        return new FutureGetObject(response);
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        V v = get(key);
        return v == null ? defaultValue : v;
    }

    @Override
    public Set<K> getNextNPaths(int size) {
        GetNextNPathsRequest getNextNPathsRequest = GetNextNPathsRequest.newBuilder().setN(size).build();
        return (Set<K>) ByteStringManipulation.byteStringToObject(blockingStub.getNextNPaths(getNextNPathsRequest).getSerializedPathCollection());
    }

    @Override
    public V put(K key, V value) {
        ByteString serializedKey = objectToByteString(key);
        ByteString serializedValue = objectToByteString(value);
        PutRequest putRequest = PutRequest.newBuilder().setSerializedKeyObject(serializedKey).setSerializedValueObject(serializedValue).build();
        return (V) byteStringToObject(blockingStub.put(putRequest).getSerializedValueObject());
    }

    //Future wrapper for future put response - to convert byte string to object
    public class FuturePutObject implements Future {

        private ListenableFuture<PutResponse> response;

        public FuturePutObject(ListenableFuture<PutResponse> response) {
            this.response = response;
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return response.cancel(mayInterruptIfRunning);
        }

        @Override
        public boolean isCancelled() {
            return response.isCancelled();
        }

        @Override
        public boolean isDone() {
            return response.isDone();
        }

        @Override
        public Object get() throws InterruptedException, ExecutionException {
            return (V) byteStringToObject(response.get().getSerializedValueObject());
        }

        @Override
        public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) byteStringToObject(response.get(timeout, unit).getSerializedValueObject());
        }
    }

    @Override
    public Future<V> putAsync(K key, V value) {
        ByteString serializedKey = objectToByteString(key);
        ByteString serializedValue = objectToByteString(value);
        PutRequest putRequest = PutRequest.newBuilder().setSerializedKeyObject(serializedKey).setSerializedValueObject(serializedValue).build();
        ListenableFuture<PutResponse> response = futureStub.put(putRequest);
        return new FuturePutObject(response);

    }

    @Override
    public V remove(Object key) {
        ByteString serializedKey = objectToByteString(key);
        RemoveRequest removeRequest = RemoveRequest.newBuilder().setSerializedKeyObject(serializedKey).build();
        return (V) byteStringToObject(blockingStub.remove(removeRequest).getSerializedValueObject());
    }

    @Override
    // Make sure that this map is serializable, otherwise there may be unintended consequences
    public void putAll(Map map) {
        ByteString serializedMap = objectToByteString(map);
        PutAllRequest putAllRequest = PutAllRequest.newBuilder().setSerializedMapObject(serializedMap).build();
        blockingStub.putAll(putAllRequest);
    }

    @Override
    public void putAllAsync(Map map) {
        ByteString serializedMap = objectToByteString(map);
        PutAllRequest putAllRequest = PutAllRequest.newBuilder().setSerializedMapObject(serializedMap).build();
        futureStub.putAll(putAllRequest);
    }

    @Override
    public void clear() {
        ClearRequest clearRequest = ClearRequest.newBuilder().build();
        blockingStub.clear(clearRequest);
    }

    @Override
    public Set keySet() {
        KeySetRequest keySetRequest = KeySetRequest.newBuilder().build();
        return (Set) byteStringToObject(blockingStub.keySet(keySetRequest).getSerializedSet());
    }

    @Override
    public Collection values() {
        ValuesRequest valuesRequest = ValuesRequest.newBuilder().build();
        return (Collection) byteStringToObject(blockingStub.values(valuesRequest).getSerializedCollection());
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        EntrySetRequest entrySetRequest = EntrySetRequest.newBuilder().build();
        return (Set<Entry<K, V>>) byteStringToObject(blockingStub.entrySet(entrySetRequest).getSerializedSet());
    }

    @Override
    public TrieMap<K, V> snapshot() {
        SnapshotRequest snapshotRequest = SnapshotRequest.newBuilder().build();
        return (TrieMap<K, V>) byteStringToObject(blockingStub.snapshot(snapshotRequest).getSerializedCTrie());
    }
}

