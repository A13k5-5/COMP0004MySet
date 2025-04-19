package uk.ac.ucl;

import java.util.Iterator;

public class LinkedList<T> {
    private Node<T> head;

    private static class Node<E> {
        public E value;
        public Node<E> next;

        public Node(E value){
            this(value, null);
        }
        public Node(E value, Node<E> next){
            this.value = value;
            this.next = next;
        }
    }

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T getHead(){ return this.head.value; }

    public void add(T newVal) {
        Node<T> toAdd = new Node<>(newVal);
        if (this.isEmpty()) {
            this.head = toAdd;
            return;
        }
        this.addAtEnd(toAdd);
    }

    private Node<T> getTail() {
        Node<T> cur = this.head;
        while (cur != null && cur.next != null)
            cur = cur.next;
        return cur;
    }

    private void addAtEnd(Node<T> toAdd){
        Node<T> tail = this.getTail();
        tail.next = toAdd;
    }

    public String toString() {
        String s = "";
        Node<T> cur = this.head;
        while (cur != null && cur.next != null){
            s += String.valueOf(cur.value) + " ";
            cur = cur.next;
        }
        return s;
    }
}
