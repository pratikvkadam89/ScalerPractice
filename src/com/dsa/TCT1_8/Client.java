package com.dsa.TCT1_8;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7,4,2,5));

        ArrayList<Long> list2 = new ArrayList<>(Arrays.asList(11l,7l));

        ArrayList<Integer> result = SuperArray.superArray(list,list2);

        System.out.println(result);
    }
}
