package com.lld.Concurrency2.Assignment1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    Node root;
    ExecutorService es;
    TreeSizeCalculator(Node root, ExecutorService es){
        this.root = root;
        this.es = es;
    }
    @Override
    public Integer call() throws Exception {
        if(root == null){
            return 0;
        }
        Future<Integer> leftSizeF  = es.submit(new TreeSizeCalculator(root.left,es));
        Future<Integer> rightSizeF  = es.submit(new TreeSizeCalculator(root.right,es));
        int leftSize = leftSizeF.get();
        int rigthSize = rightSizeF.get();

        return leftSize + rigthSize + 1;
    }
}
