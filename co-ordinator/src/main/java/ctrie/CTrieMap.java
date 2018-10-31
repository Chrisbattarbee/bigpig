package ctrie;

import com.romix.scala.collection.concurrent.TrieMap;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Future;

public interface CTrieMap<K extends Serializable, V extends Serializable> extends Map<K, V> {
    TrieMap<K, V> snapshot();
    void putAllAsync(Map map);
    Future<V> putAsync(K key, V value);
    Future<V> getAsync(Object key);
}
