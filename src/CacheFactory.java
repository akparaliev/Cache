import Interfaces.ICache;

import java.text.MessageFormat;

import CacheImpl.CacheTypeEnum;
import CacheImpl.FIFOCache;
import CacheImpl.LRUCache;

public class CacheFactory {
    public ICache createCacheInstance(CacheTypeEnum cacheTypeEnum, int capacity) {
        switch (cacheTypeEnum) {
            case FIFO:
                return new FIFOCache(capacity);
            case LRU:
                return new LRUCache(capacity);
            default:
                System.out.println(MessageFormat.format("Cache with type {0} is not implemented yet.", cacheTypeEnum));
                throw new AssertionError();
        }
    }

}
