package CacheImpl;

import java.util.HashMap;
import java.util.Map;

public class LegacyCache<K,V> {
    private final Map<K, V> keyValueMap = new HashMap<K, V>();

    // Put new pair {key:value} to cache.
    public void put(K key, V value) {
        keyValueMap.put(key, value);
    }

    // Get value by key.
    public V get(K key) {
        return keyValueMap.get(key);
    }

    // Remove item in cache by key.
    public void remove(K key) {
        keyValueMap.remove(key);
    }

    // optional methods.
    public void clear() {
        keyValueMap.clear();
    }

    public int getSize() {
        return keyValueMap.size();
    }

    public boolean containsKey(K key) {
        return keyValueMap.containsKey(key);
    }
}
