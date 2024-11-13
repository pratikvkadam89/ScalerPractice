package com.lld.Concurrency2.Assignment1;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Integer> listInteger = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            listInteger.add(i);
        }

        Node rootNode = new Node(listInteger.get(0));

        Queue<Node> queue = new LinkedList<>();
        int index = 1;
        queue.add(rootNode);
        while (!queue.isEmpty() ) {
            int n =  queue.size();
            for (int i = 1; i <= n ; i++) {
                Node node = queue.poll();
                if(index < listInteger.size()) {
                    node.left = new Node(listInteger.get(index++));
                    queue.add(node.left);
                }

                if(index < listInteger.size()) {
                    node.right = new Node(listInteger.get(index++));
                    queue.add(node.right);
                }

            }
        }

        long start = System.currentTimeMillis();


        TreeSizeCalculator treeSizeCalculator = new TreeSizeCalculator(rootNode, executorService);
        Future<Integer> resultFutureL = executorService.submit(treeSizeCalculator);
        Integer re = resultFutureL.get() ;

//        Integer re = getLength(rootNode);
        long end = System.currentTimeMillis();

        System.out.println( "time taken in milisec: " + (end - start));
        System.out.println(re);

        executorService.shutdown();

    }


    static  int getLength(Node node) {

        if(node == null) {
            return 0;
        }
        int leftSize = getLength(node.left);
        int rightSize = getLength(node.right);

        return leftSize + rightSize + 1;
    }
}
