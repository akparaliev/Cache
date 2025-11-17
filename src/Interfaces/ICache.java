package Interfaces;

// Defines methods for Cache.
public interface ICache {
    // Put new pair {key:value} to cache.
    void put(String key, Integer value);

    // Get value by key.
    Integer get(String key);

    // Remove item in cache by key.
    void remove(String key);

    // optional methods.
    void clear();

    int getSize();

    boolean containsKey(String key);
}
