package ctrie;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.ByteString;
import com.squareup.okhttp.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

import static utils.ByteStringManipulation.*;

public class AsyncCTrie<K extends Serializable, V extends Serializable> extends CoordinatorCTrie {

    private final ManagedChannel channel;
    private final CTrieServiceGrpc.CTrieServiceFutureStub futureStub;
/*
    public AsyncCTrie() {
        super();
    }

    public AsyncCTrie(String host, int port) {
        super(host, port);
    }
*/
    public AsyncCTrie(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();

        futureStub = CTrieServiceGrpc.newFutureStub(channel);
    }

    public Future<V> asyncPut(K key, V value) {
        ByteString serializedKey = objectToByteString(key);
        ByteString serializedValue = objectToByteString(value);
        PutRequest putRequest = PutRequest.newBuilder().setSerializedKeyObject(serializedKey).setSerializedValueObject(serializedValue).build();

        ListenableFuture<PutResponse> response = futureStub.put(putRequest);
        return new FutureObject(response);

    }

    //Wrapper of future
    public class FutureObject<V extends Serializable> implements Future {

        private ListenableFuture<PutResponse> response;

        public FutureObject(ListenableFuture<PutResponse> response) {
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
}
