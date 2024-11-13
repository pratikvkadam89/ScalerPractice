package com.lld.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Client {
    public static void main(String[] args) {

        /*List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> nums2 = Assignment1.getOdd(nums.stream());

        Integer sum = Assignment2.getSum(nums.stream());
        System.out.println(sum);*/
/*
        ConcurrentHashMap<String ,Integer> map = new ConcurrentHashMap<>();
        map.compute("B",(k,v)-> v==null ? 1: v+1);
        map.compute("B",(k,v)-> v==null ? 1: v+1);
        int ans = map.compute("B",(k,v)-> v==null ? 1: v+1);
        System.out.println(ans);*/


        MyThread thread = new MyThread();
        MyThread thread1 = new MyThread();
        thread.start();
        thread1.start();

    }
}
