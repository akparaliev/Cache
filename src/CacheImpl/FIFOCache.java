package CacheImpl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import Interfaces.ICache;

public class FIFOCache implements ICache {
    private final int capacity;
    private final Map<String, Integer> dictMap;
    private final LinkedList<String> queue;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.dictMap = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    @Override
    public void put(String key, Integer value) {
        if (containsKey(key)) {
            dictMap.put(key, value);

            // update the order of the key from queue
            queue.remove(key);
            queue.addLast(key);
        } else {
            while (getSize() >= capacity) {
                // remove the oldest element from queue and cache.
                String oldestItemKey = queue.removeFirst();
                dictMap.remove(oldestItemKey);
            }

            dictMap.put(key, value);
            queue.addLast(key);
        }
    }

    @Override
    public Integer get(String key) {
        if (containsKey(key)){
            return dictMap.get(key);
        }

        System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        return null;
    }

    @Override
    public void remove(String key) {
        if (containsKey(key)) {
            dictMap.remove(key);
            queue.remove(key);
        } else {
            System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        }
    }

    @Override
    public void clear() {
        dictMap.clear();
        queue.clear();
    }

    @Override
    public int getSize() {
        return dictMap.size();
    }

    @Override
    public boolean containsKey(String key) {
        return dictMap.containsKey(key);
    }
}
