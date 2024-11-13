package com.lld.generics.iterable;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Node implements   Iterable<Integer> {
    private int data;
    private Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator(this);
    }

    class NodeIterator implements Iterator<Integer> {
        Node head;
        public NodeIterator(Node head) {
            this.head = head;
        }


        @Override
        public boolean hasNext() {
            return this.head != null;
        }

        @Override
        public Integer next() {
            Node temp = head;
            head = head.next;
            return temp.data;
        }
    }
}
