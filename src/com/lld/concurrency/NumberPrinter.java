package com.lld.concurrency;

public class NumberPrinter implements  Runnable{

    int num;

    NumberPrinter(int num){
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("number -->" + num + " thread name ->" + Thread.currentThread().getName());;
    }
}
