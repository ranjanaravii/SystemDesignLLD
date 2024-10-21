package com.developer.LLD.LRUCache.cache.storage;

import com.developer.LLD.LRUCache.cache.exceptions.NotFoundException;
import com.developer.LLD.LRUCache.cache.exceptions.StorageFullException;

public interface Storage<Key, Value> {
    void add(Key key, Value value) throws StorageFullException;
    void remove(Key key) throws NotFoundException;
    Value get(Key key) throws NotFoundException;
    boolean isFull();
}
