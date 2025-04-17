package uk.ac.ucl;

import java.util.Iterator;

public class LinkedList {
    private class Node<T> {
        private final T value;
        private Node<T> next;
        private Node(T value){
            this.value = value;
            this.next = null;
        }
        public Node getNext() {
            return this.next;
        }
        public T getValue() {
            return this.value;
        }
    }
}
