package com.lld.Concurrency3.ProducerConsumer;

public class Producer implements Runnable {

    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {


            while (true) {
                synchronized (store){
                if(store.getStore().size() < store.getCapacity()){
                    store.add(new Object());
                }
            }



        }

    }
}
