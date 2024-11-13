package com.Completable;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {


    public static void main(String[] args) {

        System.out.println("thread name :" + Thread.currentThread().getName());


        ExecutorService es = Executors.newFixedThreadPool(4);


        for(int i = 1 ; i < 100 ; i++){
            int a = 78;
            es.submit(() -> {
                ServiceClass sc = ServiceClass.getInstance();
                sc.methodA(a);
            });


        }



    }
}
