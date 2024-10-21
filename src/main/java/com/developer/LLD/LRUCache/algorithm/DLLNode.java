package com.developer.LLD.LRUCache.algorithm;

public class DLLNode<E> {
    E element;
    DLLNode<E> next;
    DLLNode<E> prev;

    public DLLNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public E getElement() {
        return element;
    }

}
