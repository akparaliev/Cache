import CacheImpl.CacheTimeMeasureDecorator;
import CacheImpl.CacheTypeEnum;
import CacheImpl.LegacyCacheAdapter;
import CacheImpl.CacheDecorator;
import Interfaces.ICache;

public class App {
    public static void main(String[] args) throws Exception {
       // testLFUwithFactory();
       // testFIFOwithFactory();
       // testLegacyCacheAdapter();
       testCacheTimeMeasureDecorator();
    }

    private static void testCacheTimeMeasureDecorator() {
        ICache lfuCache = new CacheFactory().createCacheInstance(CacheTypeEnum.LFU, 10);
        CacheDecorator decorator = new CacheTimeMeasureDecorator(lfuCache); // {item1: 1}, {item3: 2}
        decorator.put("item1", 1); 
        decorator.put("item3", 2);

        decorator.get("item3");
    }

    private static void testLegacyCacheAdapter() {
        ICache legacyCache = new LegacyCacheAdapter(4);
        legacyCache.put("item 1", 1);
        legacyCache.put("item 2", 2);
        legacyCache.put("item 3", 3);
        legacyCache.put("item 4", 4);
        System.out.println(legacyCache.getSize());
        legacyCache.put("item 5", 5);
        System.out.println(legacyCache.getSize());
        legacyCache.remove("item 2");
        System.out.println(legacyCache.getSize());
        legacyCache.put("item 6", 6);
        System.out.println(legacyCache.getSize());
    }


    private static void testLFUwithFactory() {
        ICache fifoCache = new CacheFactory().createCacheInstance(CacheTypeEnum.LFU, 10);
        fifoCache.put("key1", 1);
        fifoCache.put("key2", 123);
        fifoCache.getSize(); // 2

        System.out.println(fifoCache.get("key2")); // 123

        fifoCache.remove("key1");
        System.out.println(fifoCache.getSize()); // 1
    }

    private static void testFIFOwithFactory() {
        ICache fifoCache = new CacheFactory().createCacheInstance(CacheTypeEnum.FIFO, 9);
        fifoCache.put("key1", 1);
        fifoCache.put("key2", 123);
        fifoCache.getSize(); // 2

        System.out.println(fifoCache.get("key2")); // 123

        fifoCache.remove("key1");
        System.out.println(fifoCache.getSize()); // 1
    }
}

