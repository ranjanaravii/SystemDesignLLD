package com.developer.LLD.HashMapImpl;

public class HashMapImpl<K, V> {
    private static final int DEFAULT_CAPACITY = 1 << 4; //16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAX_CAPACITY = 1 << 30; //1073741824;

    public Entry[] hashTable;

    public HashMapImpl() {
        this.hashTable = new Entry[DEFAULT_CAPACITY];
    }

    public HashMapImpl(int capacity) {
        int tableSize = tableSizeFor(capacity);
        this.hashTable = new Entry[tableSize];
    }

    private int tableSizeFor(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }

    static class Entry<K, V> {
        public K key;
        public V value;
        public Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if (node == null) {
            Entry<K, V> newNode = new Entry<>(key, value);
            hashTable[hashCode] = newNode;
        }else {
            Entry previousNode = node;
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            previousNode.next = new Entry<>(key, value);
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];
        while (node != null) {
            if (node.key.equals(key)) {
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashMapImpl<Integer, String> hashMap = new HashMapImpl<>(20);
        hashMap.put(1, "Hi");
        hashMap.put(2, "Ravi");
        hashMap.put(3, "Abhinav");
        hashMap.put(4, "Kumar");
        hashMap.put(4, "khjnk");
        hashMap.put(5, "Saket");
        String value = hashMap.get(4);
        System.out.println(value);
    }
}
