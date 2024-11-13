package com.lld.Concurrency4.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private Store store;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    Consumer(Store store) {
        this.store = store;
    }

    Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.getMessage());
            }
            store.remove();
            producerSemaphore.release();


        }
    }
}
