package com.lld.Concurrency4.ProducerConsumerSemaphore;

import javax.swing.*;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    Store store;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    Producer(Store store) {
        this.store = store;
    }

    Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }


    @Override
    public void run() {
        while (true) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.getMessage());
            }
            store.add(new Object());
            consumerSemaphore.release();


        }
    }
}
