package ctrie;

import com.romix.scala.collection.concurrent.TrieMap;

import java.io.Serializable;
import java.util.Map;

public interface CTrieMap<K extends Serializable, V extends Serializable> extends Map<K, V> {
    TrieMap<K, V> snapshot();
}
