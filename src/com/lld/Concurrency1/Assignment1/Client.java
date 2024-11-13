package com.lld.Concurrency1.Assignment1;

public class Client {

    public static void main(String[] args) {
        System.out.println("I am the main class");
        ScalerThread t1 = new ScalerThread(new Adder());
        ScalerThread t2 = new ScalerThread(new Subtractor());
        t1.start();
        t2.start();
    }
}
