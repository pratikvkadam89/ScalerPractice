package com.dsa;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer,Node> lRUMap;
    private DoublyLinkedList list;
    private int sizeOfCache;

    public LRUCache(int capacity) {
        this.lRUMap = new HashMap<>();
        this.list = new DoublyLinkedList();
        this.sizeOfCache = capacity;
    }

    public int get(int key) {

        //get the Nodes address from the HashMap
        if(lRUMap.containsKey(key)){
            Node nodeFound = lRUMap.get(key);
            //Move this to ahead  /// **** if node is get then also you should move it to recent.
            list.remove(nodeFound);
            list.add(nodeFound);
            return nodeFound.value;

        }
        return -1;
    }

    public void set(int key, int value) {

        //this is for set

        if(lRUMap.containsKey(key)){
            //get the addres from Map
            Node node = lRUMap.get(key);
            //remove the element from list
            list.remove(node);
            //create new node node and
            Node newNode = new Node(key,value);
            //add to it list
            list.add(newNode);
            //update addrs in map
            lRUMap.replace(key,newNode);
        }else {

            //this is for insert;
            //check the capacitkeyy
            Node newNode = new Node(key,value);
            if(lRUMap.size()==sizeOfCache){
                //get key of least used node
                Node leastUsedNode = list.getLeastUsed();
                lRUMap.remove(leastUsedNode.key);
                //remove the node next to head
                list.remove(leastUsedNode);

                //add new node nxt to tail
                list.add(newNode);
                lRUMap.put(key,newNode);
            }else {
                //add new node nxt to tail;
                list.add(newNode);
                lRUMap.put(key,newNode);
            }

        }

    }


    class DoublyLinkedList {
        private Node head;
        private Node tail;

        public DoublyLinkedList(){
            this.head = new Node(-1,-1);
            this.tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node newNode ){
            Node tailPrev = tail.prev;
            tailPrev.next = newNode;
            newNode.prev = tailPrev;
            newNode.next = tail;
            tail.prev = newNode;
        }

        void removeNextToHead(){
            Node temp = head.next.next;
            head.next = temp;
            temp.prev = head;

        }

        void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        Node getLeastUsed(){
            return head.next;
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
