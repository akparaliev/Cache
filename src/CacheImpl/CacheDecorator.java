package CacheImpl;

import Interfaces.ICache;
import java.util.Iterator;

public abstract  class CacheDecorator<K,V> implements ICache<K,V> {
    private final ICache<K,V> cache;
    public CacheDecorator(ICache<K,V> cache) {
        this.cache = cache;
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public int getSize() {
        return cache.getSize();
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }
    
    @Override
    public Iterator<K> iterator() {
          // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
