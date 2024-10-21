package com.developer.LLD.LRUCache.cache.policies;

public interface EvictionPolicy<Key> {

    /**
     * This method will be called whenever a key is accessed in the cache
     * @param key
     */
    void keyAccessed(Key key);

    /**
     * This method will be called when the capacity of the cache is full and we need to evict a key
     * @return
     */
    Key evictKey();
}
