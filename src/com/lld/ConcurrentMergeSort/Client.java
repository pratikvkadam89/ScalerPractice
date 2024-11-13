package com.lld.ConcurrentMergeSort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      List<Integer> list = Arrays.asList(8,6,2,9,5,4,1,3);
      ExecutorService es = Executors.newCachedThreadPool();

      Future<List<Integer>> sortedFuture = es.submit(new ConcurentSorter(list,es));

      List<Integer> sortedList = sortedFuture.get();

      System.out.println(sortedList);

   }




}
