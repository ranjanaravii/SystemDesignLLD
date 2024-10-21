package com.developer.LLD.LRUCache.cache;

import com.developer.LLD.LRUCache.cache.exceptions.NotFoundException;
import com.developer.LLD.LRUCache.cache.exceptions.StorageFullException;
import com.developer.LLD.LRUCache.cache.policies.EvictionPolicy;
import com.developer.LLD.LRUCache.cache.storage.Storage;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        }catch (StorageFullException exception) {
            System.out.println("Got storage full! Will try to evict a key");
            Key keyToBeRemoved = this.evictionPolicy.evictKey();
            if (keyToBeRemoved == null) {
                throw new RuntimeException("Eviction policy returned null which is not possible");
            }
            this.storage.remove(keyToBeRemoved);
            put(key, value);
        }
    }

    public Value get(Key key) {
      try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
      }catch (NotFoundException exception) {
          System.out.println("Key not present in system");
          return null;
      }
    }
}
