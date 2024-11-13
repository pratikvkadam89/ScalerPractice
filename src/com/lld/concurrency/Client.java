package com.lld.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);

        for(int i = 1 ; i<=100 ; i++){
            Runnable task = new NumberPrinter(i);
            /*Thread t = new Thread(task);
            t.run();*/
            es.execute(task);
        }
        es.shutdown();

    }
}
