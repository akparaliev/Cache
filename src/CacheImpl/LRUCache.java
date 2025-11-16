package CacheImpl;

import Interfaces.ICache;

public class LRUCache implements ICache{
    int capacity;
    String name;
    String serverName;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }


    @Override
    public void put(String key, int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public int get(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void remove(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    @Override
    public boolean containsKey(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsKey'");
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
