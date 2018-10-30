package ctrie;

import com.romix.scala.collection.concurrent.TrieMap;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Future;

public interface CTrieMap<K extends Serializable, V extends Serializable> extends Map<K, V> {
    TrieMap<K, V> snapshot();
    public void putAllAsync(Map map);
    public Future<V> putAsync(K key, V value);
    public Future<V> getAsync(Object key);
}
