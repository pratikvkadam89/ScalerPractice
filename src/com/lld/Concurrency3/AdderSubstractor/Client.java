package com.lld.Concurrency3.AdderSubstractor;

import java.util.concurrent.*;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Count count = new Count();

        Callable<Void> adder = new Adder(count);
        Callable<Void> substractor = new Substractor(count);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> addF = es.submit(adder);
        Future<Void> addS = es.submit(substractor);

        addF.get(); //Constantly checkking on the task, is it over?
        addS.get();

        System.out.println("final count : " + count.value);

        es.shutdown();
    }




}
