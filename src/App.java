import CacheImpl.CacheTimeMeasureDecorator;
import CacheImpl.CacheTypeEnum;
import CacheImpl.LegacyCacheAdapter;

import java.util.Iterator;

import CacheImpl.CacheDecorator;
import Interfaces.ICache;

public class App {
    public static void main(String[] args) {
       // testLFUwithFactory();
       // testFIFOwithFactory();
       // testLegacyCacheAdapter();
       // testCacheTimeMeasureDecorator();

       // testFifoCacheIterator();
       testGenerics1();
    }

     private static void testGenerics1() {
        ICache<Integer,String> fifoCache = 
            new CacheFactory<Integer,String>().createCacheInstance(CacheTypeEnum.FIFO, 9);
        fifoCache.put(1, "Group 1");
        fifoCache.put(3, "Group 333");
        System.out.println(fifoCache.get(3));
    }

    private static void testFifoCacheIterator() {
        ICache<String, Integer> fifoCache = new CacheFactory<String, Integer>().createCacheInstance(CacheTypeEnum.FIFO, 9);
        fifoCache.put("key1", 1);
        fifoCache.put("key2", 123);

        Iterator<String> fifoKeyIterator = fifoCache.iterator();
        while(fifoKeyIterator.hasNext()) {
            System.out.println(fifoCache.get(fifoKeyIterator.next()));
        }
    }

    private static void testCacheTimeMeasureDecorator() {
        ICache<String, Integer> lfuCache = new CacheFactory<String, Integer>().createCacheInstance(CacheTypeEnum.LFU, 10);
        CacheDecorator<String, Integer> decorator = new CacheTimeMeasureDecorator<String, Integer>(lfuCache); // {item1: 1}, {item3: 2}
        decorator.put("item1", 1); 
        decorator.put("item3", 2);

        decorator.get("item3");
    }

    private static void testLegacyCacheAdapter() {
        ICache<String, Integer> legacyCache = new LegacyCacheAdapter<String, Integer>(4);
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
        ICache<String, Integer> fifoCache = new CacheFactory<String, Integer>().createCacheInstance(CacheTypeEnum.LFU, 10);
        fifoCache.put("key1", 1);
        fifoCache.put("key2", 123);
        fifoCache.getSize(); // 2

        System.out.println(fifoCache.get("key2")); // 123

        fifoCache.remove("key1");
        System.out.println(fifoCache.getSize()); // 1
    }

    private static void testFIFOwithFactory() {
        ICache<String, Integer> fifoCache = new CacheFactory<String, Integer>().createCacheInstance(CacheTypeEnum.FIFO, 9);
        fifoCache.put("key1", 1);
        fifoCache.put("key2", 123);
        fifoCache.getSize(); // 2

        System.out.println(fifoCache.get("key2")); // 123

        fifoCache.remove("key1");
        System.out.println(fifoCache.getSize()); // 1
    }
}

