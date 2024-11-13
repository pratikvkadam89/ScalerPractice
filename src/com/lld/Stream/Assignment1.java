package com.lld.Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment1 {

    static List<Integer> getOdd(Stream<Integer> stream){
        // write code here
        /*Supplier<List<Integer>> supplier = new Supplier<List<Integer>>() {
            @Override
            public List<Integer> get() {
                return new ArrayList<>();
            }
        };*/

//        Supplier<List<Integer>> supplier = () -> new ArrayList<>();

        /*BiConsumer<List<Integer>, Integer> accumulator = new BiConsumer<List<Integer>, Integer>() {
            @Override
            public void accept(List<Integer> integers, Integer integer) {
                integers.add(integer);
            }
        };*/
//        BiConsumer<List<Integer>, Integer> accumulator = (list,num) -> list.add(num);


        /*BiConsumer<List<Integer>, List<Integer>> combiner = new BiConsumer<List<Integer>, List<Integer>>() {
            @Override
            public void accept(List<Integer> integers, List<Integer> integers2) {
                    integers.addAll(integers2);
            }
        };*/
//        BiConsumer<List<Integer>, List<Integer>> combiner = (list1,list2) -> list1.addAll(list2) ;



//        return stream.filter(num -> num%2 != 0).collect(supplier,accumulator,combiner);
       /* return stream
                .filter(num -> num%2 != 0)
                .collect(()->new ArrayList<>() , (list,num) -> list.add(num) , (l1,l2) -> l1.addAll(l2));*/

        return stream.filter(num -> num%2 != 0).collect(Collectors.toList());
    }

}
