package Interfaces;

// Defines methods for Cache.
public interface ICache<K,V> extends Iterable<K> {
    // Put new pair {key:value} to cache. // {string:string}
    void put(K key, V value);

    // Get value by key.
    V get(K key);

    // Remove item in cache by key.
    void remove(K key);

    // optional methods.
    void clear();

    int getSize();

    boolean containsKey(K key);
}

