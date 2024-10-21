package com.developer.LLD.LRUCache.algorithm;


public class DoublyLinkedList<E> {
    DLLNode<E> first;
    DLLNode<E> last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    /**
     * Add node to the end of the list
     * @param node
     */
    public void detachNode(DLLNode<E> node) {
        if (node == null) return;

        if (node.equals(first)){
            first = first.next;
            if (first != null) {
                first.prev = null;
            }
        } else if (node.equals(last)) {
            last = last.prev;
            if (last.next != null) {
                last.next = null;
            }
        }else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     * add node to the end of the list
     * @param node
     */
    public void addNodeAtLast(DLLNode<E> node) {
        if (node == null) {
            throw new InvalidNodeException("Node cannot be null");
        }
        if (last == null) {
            last = node;
            first = node;
        }
        else {
            last.next = node;
            node.prev = last;
            last = node;
            last.next = null;
        }
    }

    public DLLNode<E> addElementAtLast(E element) {
        if (element == null) {
            throw new InvalidNodeException("Element cannot be null");
        }
        DLLNode<E> node = new DLLNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    public void printList() {
        DLLNode<E> temp = first;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public E remove() {
        if (first == null) {
            return null;
        }
        DLLNode<E> node = first;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        return node.element;
    }
}
