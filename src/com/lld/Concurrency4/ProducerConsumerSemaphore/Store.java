package com.lld.Concurrency4.ProducerConsumerSemaphore;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {

    private ConcurrentLinkedDeque<Object> items ;
    private int maxSize ;

    Store(int maxSize){
        this.items = new ConcurrentLinkedDeque<Object>();
        this.maxSize = maxSize;
    }

    int getMaxSize(){
        return maxSize;
    }

    ConcurrentLinkedDeque<Object> getList(){
        return items;
    }

    public void add(Object object) {
        System.out.println("Producer producing, current size " + this.items.size());
        items.add(object);
    }

    public void remove() {
        System.out.println("Consumer consuming, current size " + this.items.size());
        items.remove();
    }




}
