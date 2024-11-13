package com.lld.Concurrency3.ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        Store store = new Store(5);

        for (int i = 0; i < 8; i++) {
            es.execute(new Producer(store));
        }

        for (int i = 0; i < 8; i++) {
            es.execute(new Consumer(store));
        }



    }
}
