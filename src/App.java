import BuilderExample.Animal;
import BuilderExample.AnimalBuilder;
import BuilderExample.FastFoodRestaurant;
import BuilderExample.FastFoodRestaurantBuilder;
import CacheImpl.CacheTypeEnum;
import CacheImpl.FIFOCache;
import CacheImpl.LRUCache;
import CacheImpl.LRUCacheBuilder;
import Interfaces.ICache;

public class App {
    public static void main(String[] args) throws Exception {
        // testFIFO();
        //testFIFOwithFactory();
        // testLRUwithFactory();

        testLRUCacheBuilder();

        
    }

    private static void testFFR() { 
        FastFoodRestaurantBuilder f1Builder = new FastFoodRestaurantBuilder();
        FastFoodRestaurant f1 = f1Builder.buildKidsMenu().buildChristmasMenu().build();

        FastFoodRestaurantBuilder f2Builder = new FastFoodRestaurantBuilder();
        FastFoodRestaurant f2 = f2Builder.buildKidsMenu().build();
    }

    private static void testAnimal() {
        AnimalBuilder giraffeBuilder = new AnimalBuilder(); // Animal.Builder builder = new Animal.Builder();
        Animal giraffe = giraffeBuilder.setAge(1).setHeight(150).setWeight(10).build();
        AnimalBuilder lioAnimalBuilder = new AnimalBuilder(); 
        Animal lion = lioAnimalBuilder.setAge(2).setHeight(12).setWeight(10).setName("Loki").build();
        AnimalBuilder tigerAnimalBuilder = new AnimalBuilder(); 
        Animal tiger = tigerAnimalBuilder.setHeight(12).setWeight(10).build();
    }

    private static void testLRUCacheBuilder() {
       LRUCacheBuilder lruCacheBuilder = new LRUCacheBuilder(15); // 
       ICache lruCache = lruCacheBuilder.setName("LRU custom cache").setServerName("localhost").build();

        lruCache.put("key1", 1);
        lruCache.put("key2", 123);
        lruCache.getSize(); // 2

        System.out.print(lruCache.get("key2")); // 123

        lruCache.remove("key1");
        System.out.print(lruCache.getSize()); // 1
    }

    private static void testLRUwithFactory() {
        ICache fifoCache = new CacheFactory().createCacheInstance(CacheTypeEnum.LRU, 10);
        fifoCache.put("key1", 1);
        fifoCache.put("key2", 123);
        fifoCache.getSize(); // 2

        System.out.print(fifoCache.get("key2")); // 123

        fifoCache.remove("key1");
        System.out.print(fifoCache.getSize()); // 1
    }

    private static void testFIFOwithFactory() {
        ICache fifoCache = new CacheFactory().createCacheInstance(CacheTypeEnum.FIFO, 9);
        fifoCache.put("key1", 1);
        fifoCache.put("key2", 123);
        fifoCache.getSize(); // 2

        System.out.print(fifoCache.get("key2")); // 123

        fifoCache.remove("key1");
        System.out.print(fifoCache.getSize()); // 1
    }

    private static void testFIFO() {
        ICache fifoCache = new LRUCache(9);
        fifoCache.put("key1", 1);
        fifoCache.put("key2", 123);
        fifoCache.getSize(); // 2

        System.out.print(fifoCache.get("key2")); // 123

        fifoCache.remove("key1");
        System.out.print(fifoCache.getSize()); // 1
    }
}

