package com.developer.LLD.LRUCache.cache.factories;

import com.developer.LLD.LRUCache.cache.Cache;
import com.developer.LLD.LRUCache.cache.policies.LRUEvictionPolicy;
import com.developer.LLD.LRUCache.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> defaultCache() {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(10));
    }
}
