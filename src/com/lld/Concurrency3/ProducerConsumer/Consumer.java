package com.lld.Concurrency3.ProducerConsumer;

public class Consumer implements Runnable{

    Store store;

    public Consumer(Store store) {
        this.store = store;
    }
    @Override
    public void run() {



            while(true){
                synchronized (store){
                if(store.getStore().size() > 0){
                    store.remove();
                }

            }

        }

    }
}
