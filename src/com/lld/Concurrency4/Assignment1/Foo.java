package com.lld.Concurrency4.Assignment1;

import java.util.concurrent.Semaphore;

class Foo {

    private Semaphore semaphoreFirst = new Semaphore(1);
    private Semaphore semaphoreSecond = new Semaphore(0);
    private Semaphore semaphoreThird = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        semaphoreFirst.acquire();
        printFirst.run();
        semaphoreSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        semaphoreSecond.acquire();
        printSecond.run();
        semaphoreThird.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        semaphoreThird.acquire();
        printThird.run();
        semaphoreFirst.release();
    }
}
