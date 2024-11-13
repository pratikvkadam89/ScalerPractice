package com.lld.Concurrency4.Assignment3;

import java.util.concurrent.Semaphore;

public class H2O {

    private Semaphore semaphoreHydrogen = new Semaphore(2);
    private Semaphore semaphoreOxygen = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        semaphoreHydrogen.acquire();
        releaseHydrogen.run();
        if (semaphoreHydrogen.availablePermits() == 0) {
            semaphoreOxygen.release();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        semaphoreOxygen.acquire();
        releaseOxygen.run();
        semaphoreHydrogen.release(2);

    }
}
