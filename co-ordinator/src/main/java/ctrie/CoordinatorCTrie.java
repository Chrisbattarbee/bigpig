package ctrie;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CoordinatorCTrie<K extends Serializable, V extends Serializable> implements Map<K, V> {
    public static final String HOST_NAME = "co-ordinator";
    public static final int PORT_NUMBER = 8080;


    private final ManagedChannel channel;
    private final CTrieServiceGrpc.CTrieServiceBlockingStub blockingStub;
    private final CTrieServiceGrpc.CTrieServiceFutureStub futureStub;

    private static ByteString objectToByteString(Object o) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

        // Make our object writer and write our serialized object to it
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Flush all the bytes
        try {
            byteStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ByteString.copyFrom(byteStream.toByteArray());
    }

    private static Object byteStringToObject(ByteString byteString) {
        byte[] serializedValue = new byte[byteString.size()];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedValue);

        try {
            ObjectInputStream stream = new ObjectInputStream(byteArrayInputStream);
            return stream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CoordinatorCTrie() {
        this(ManagedChannelBuilder.forAddress(HOST_NAME, PORT_NUMBER).usePlaintext());
    }

    public CoordinatorCTrie(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public CoordinatorCTrie(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();

        blockingStub = CTrieServiceGrpc.newBlockingStub(channel);
        futureStub = CTrieServiceGrpc.newFutureStub(channel);
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

    @Override
    public V put(K key, V value) {
        ByteString serializedKey = objectToByteString(key);
        ByteString serializedValue = objectToByteString(value);

        PutRequest putRequest = PutRequest.newBuilder().setSerializedKeyObject(serializedKey).setSerializedValueObject(serializedValue).build();
        return (V) byteStringToObject(blockingStub.put(putRequest).getSerializedValueObject());
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

}

