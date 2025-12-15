import CacheImpl.CacheTypeEnum;
import CacheImpl.FIFOCache;
import CacheImpl.LFUCacheBuilder;
import Interfaces.ICache;
import java.text.MessageFormat;

public class CacheFactory<K,V> {
    public ICache<K,V> createCacheInstance(CacheTypeEnum cacheTypeEnum, int capacity) {
        switch (cacheTypeEnum) {
            case FIFO:
                return new FIFOCache<>(capacity);
            case LFU:
                LFUCacheBuilder<K,V> lfuCacheBuilder = new LFUCacheBuilder<K,V>().setCapacity(capacity).setServerName("localhost:8080");
                return lfuCacheBuilder.build();
            default:
                System.out.println(MessageFormat.format("Cache with type {0} is not implemented yet.", cacheTypeEnum));
                throw new AssertionError();
        }
    }

}
