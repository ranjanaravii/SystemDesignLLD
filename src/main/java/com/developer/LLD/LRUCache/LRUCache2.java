package com.developer.LLD.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU (Least Recently Used) Cache in Java
1. Standard Implementation
    Data Structures Used:
    HashMap: Fast lookup of cache entries by key (O(1)).
    Doubly Linked List: Maintains the order of entries from most to least recently used. The head is most recently used; the tail is least.


    Core Operations:
        get(key): Return value if key exists and move entry to head.

        put(key, value): Insert/update value, move entry to head. If over capacity, remove from tail.
    Implementation Steps:
        Each cache entry is a node in the linked list.
        Use HashMap to map keys to these nodes.
        Upon access or update, move the node to the head.
    
    If adding exceeds capacity, remove the tail node.
    All operations are O(1).
    Example Code Structure:
2. Alternative Java Approaches

    LinkedHashMap: Easier LRU using built-in structure; override removeEldestEntry() for eviction.

    TreeMap: Less efficient (O(log n)), rarely used for LRU.

3. Common Pitfalls
    Linked List Pointer Errors: Incorrect update of prev/next leading to data loss or corruption.

    Losing O(1) Guarantees: Not using a HashMap alongside the list leads to poor performance.

    No Thread-Safety: Manual LRU is not synchronized. Needs explicit locking in multithreaded use.

    Unbounded Cache Size: Always set a fixed cache capacity; else, memory leaks can occur.

    Incomplete Eviction: Forgotten removal from either HashMap or list can cause bugs.

    Nulls/Edge Cases: Code must safely handle nulls and non-existent keys.

    Lack of Error Handling: Validate inputs like cache size; handle exceptions gracefully.

    No Metrics/Monitoring: Without tracking hits/misses/evictions, cache effectiveness is unclear.

    Incorrect Policy Implementation: Mistakenly applying MRU or wrong eviction logic.

    Unnecessary Data Structures: Avoid arrays, heaps, or over-complicating the design.
 */

class LRUCache2 {

    private class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }
    private final int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) 
            remove(cache.get(key));
        if(cache.size() == capacity) 
            remove(tail.prev);
        Node node = new Node(key, value);
        insert(node);
        cache.put(key, node);
    }

    private void remove(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

