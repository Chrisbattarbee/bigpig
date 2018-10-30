package ctrie;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static utils.ByteStringManipulation.HOST_NAME;
import static utils.ByteStringManipulation.PORT_NUMBER;

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
}
