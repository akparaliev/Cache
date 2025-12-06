package CacheImpl;

import Interfaces.ICache;
import java.util.Iterator;

public class LegacyCacheAdapter<K,V> implements ICache<K,V> {
    private LegacyCache<K,V> legacyCache;
    private int capacity;

    public LegacyCacheAdapter(int capacity) {
        this.capacity = capacity;
        legacyCache = new LegacyCache<K,V>();
    }

    @Override
    public void put(K key, V value) {
        if (legacyCache.getSize() >= capacity) {
            System.out.println("Cache is full. Please, remove items.");
            return;
        }

        legacyCache.put(key, value);
    }

    @Override
    public V get(K key) {
        return legacyCache.get(key);
    }

    @Override
    public void remove(K key) {
        legacyCache.remove(key);
    }

    @Override
    public void clear() {
        legacyCache.clear();
    }

    @Override
    public int getSize() {
        return legacyCache.getSize();
    }

    @Override
    public boolean containsKey(K key) {
        return legacyCache.containsKey(key);
    }
    
    @Override
    public Iterator<K> iterator() {
          // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
