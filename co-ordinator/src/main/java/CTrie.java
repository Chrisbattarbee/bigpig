import com.google.protobuf.RpcChannel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import protos.CTrie.CTrieProto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;



public class CTrie<K extends Serializable, V extends Serializable> implements Map {

    public static final String HOST_NAME = "co-ordinator";


    private final ManagedChannel channel;
    private final CTrieProto.CTrieService.BlockingInterface blockingStub;

    public CTrie() {
        channel = ManagedChannelBuilder.forAddress(HOST_NAME, 444).usePlaintext().build();
        CTrieProto.CTrieService.newBlockingStub(channel);
    }

    @Override
    public int size() {

        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
