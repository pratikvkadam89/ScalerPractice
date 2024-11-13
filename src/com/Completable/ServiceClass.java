package com.Completable;


import java.util.concurrent.CompletableFuture;

public class ServiceClass {

    private static ServiceClass sc = null;

    private ServiceClass() {
    }

    public static ServiceClass getInstance() {

        if (sc == null) {
            sc = new ServiceClass();
        }

        return sc;
    }

    public void methodA(int id) {
        System.out.println("thread name :" + Thread.currentThread().getName());
        System.out.println("calling method a " + id);

        CompletableFuture.runAsync(() -> {
                    methodB(id);
                }
        );

    }


    public void methodB(int id) {
        System.out.println("thread name :" + Thread.currentThread().getName());
        System.out.println("calling method b " + id);
    }
}
