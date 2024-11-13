package com.lld.Stream;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Assignment2 {

    static int getSum(Stream<Integer> stream){
        // write code here

        /*BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        return stream.reduce(0,sum);*/

        return stream.reduce(0, Integer::sum);
    }
}
