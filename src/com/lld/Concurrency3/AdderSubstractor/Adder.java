package com.lld.Concurrency3.AdderSubstractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {

    Count count;

    Adder(Count count){
        this.count = count;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 1; i <= 10000; i++) {
            synchronized (count){
                count.value = count.value +  i;
                System.out.println("value of count is " + count.value);
            }

        }
        return null;

    }
}
