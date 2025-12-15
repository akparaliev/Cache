package CacheImpl;

public class LFUCacheBuilder<K,V> {
    private final LFUCache<K,V> lfuCache;

    public LFUCacheBuilder() {
        lfuCache = new LFUCache<>();
    }

    public LFUCacheBuilder<K,V> setCapacity(int capacity){
        lfuCache.setCapacity(capacity);
        return this;
    }

    public LFUCacheBuilder<K,V> setServerName(String serverName){
        lfuCache.setServerName(serverName);
        return this;
    }

    public LFUCache<K,V> build() {
        return lfuCache;
    }
}
