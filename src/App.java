import CacheImpl.CacheTypeEnum;
import Interfaces.ICache;

public class App {
    public static void main(String[] args) throws Exception {
       // testLFUwithFactory();
        testFIFOwithFactory();
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

