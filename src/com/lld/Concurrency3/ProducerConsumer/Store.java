package com.lld.Concurrency3.ProducerConsumer;

import java.util.ArrayList;

public class Store {

    private ArrayList<Object> store;
    private int capacity;

    public Store(int capacity) {
        this.capacity = capacity;
        this.store = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    public ArrayList<Object> getStore() {
        return store;
    }
    public void  add (Object object) {
        System.out.println("Producer producing, current size " + this.store.size());
        store.add(object);
    }

    public void remove() {
        System.out.println("Consumer consuming, current size " + this.store.size());
        store.remove(store.size() - 1);
    }


}
