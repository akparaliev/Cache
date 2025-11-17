import Interfaces.ICache;

import java.text.MessageFormat;

import CacheImpl.CacheTypeEnum;
import CacheImpl.FIFOCache;
import CacheImpl.LFUCacheBuilder;

public class CacheFactory {
    public ICache createCacheInstance(CacheTypeEnum cacheTypeEnum, int capacity) {
        switch (cacheTypeEnum) {
            case FIFO:
                return new FIFOCache(capacity);
            case LFU:
                LFUCacheBuilder lfuCacheBuilder = new LFUCacheBuilder().setCapacity(capacity).setServerName("localhost:8080");
                return lfuCacheBuilder.build();
            default:
                System.out.println(MessageFormat.format("Cache with type {0} is not implemented yet.", cacheTypeEnum));
                throw new AssertionError();
        }
    }

}
