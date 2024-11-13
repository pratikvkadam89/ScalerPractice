package com.lld.Concurrency4.Assignment2;

import java.util.concurrent.Semaphore;

public class FooBar {

    private int n;
    private Semaphore semaphoreFirst = new Semaphore(1);
    private Semaphore semaphoreSecond = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            semaphoreFirst.acquire();
            printFoo.run();
            semaphoreSecond.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            semaphoreSecond.acquire();
            printBar.run();
            semaphoreFirst.release();
        }
    }
}
