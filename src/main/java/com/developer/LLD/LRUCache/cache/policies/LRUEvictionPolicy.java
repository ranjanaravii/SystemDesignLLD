package com.developer.LLD.LRUCache.cache.policies;


import com.developer.LLD.LRUCache.algorithm.DLLNode;
import com.developer.LLD.LRUCache.algorithm.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for evicting the least recently used element from the cache.
 * It uses the concept of a doubly linked list to keep track of the order of elements.
 * Whenever an element is accessed, it is moved to the front of the list.
 * When we need to evict an element, we remove the last element of the list.
 * @param <Key>
 */
public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private final DoublyLinkedList<Key> dll;
    private final Map<Key, DLLNode<Key>> keyNodeMap;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.keyNodeMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (keyNodeMap.containsKey(key)) {
            DLLNode<Key> node = keyNodeMap.get(key);
            dll.detachNode(node);
            dll.addNodeAtLast(node);
        } else {
           // DLLNode<Key> node = new DLLNode<>(key);
            //both are same
            DLLNode<Key> node = dll.addElementAtLast(key);
            dll.addNodeAtLast(node);
            keyNodeMap.put(key, node);
        }
    }

    @Override
    public Key evictKey() {
        DLLNode<Key> first = dll.getFirst();
        if (first == null) {
            return null;
        }
        dll.detachNode(first);
        return first.getElement();
    }
}
