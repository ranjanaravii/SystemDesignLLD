package com.developer.LLD.LRUCache.cache.storage;

import com.developer.LLD.LRUCache.cache.exceptions.NotFoundException;
import com.developer.LLD.LRUCache.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {
    private final Map<Key, Value> storage;
    private final int capacity;

    public HashMapBasedStorage(int capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isFull() && !storage.containsKey(key)) {
            throw new StorageFullException("Storage is full");
        }
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) {
            throw new NotFoundException("Key not found");
        }
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) {
            throw new NotFoundException("Key not found");
        }
        return storage.get(key);
    }

    @Override
    public boolean isFull() {
        return storage.size() == capacity;
    }
}
