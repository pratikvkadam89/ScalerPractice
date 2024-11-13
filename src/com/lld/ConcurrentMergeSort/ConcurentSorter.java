package com.lld.ConcurrentMergeSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ConcurentSorter implements Callable<List<Integer>> {

    List<Integer> arrToSort;
    ExecutorService es;

    ConcurentSorter(List<Integer> list , ExecutorService es) {
        this.arrToSort = list;
        this.es = es;
    }


    @Override
    public List<Integer> call() throws Exception {

        if(arrToSort.size() <= 1){
            return arrToSort;
        }
        int length = arrToSort.size();
        int mid = length / 2;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int i = 0;
        for(i = 0; i < mid; i++){
            list1.add(arrToSort.get(i));
        }
        for(i = mid ; i < length; i++){
            list2.add(arrToSort.get(i));
        }

        Future<List<Integer>> sortedListFuture1 = es.submit(new ConcurentSorter(list1, es));
        Future<List<Integer>> sortedListFuture2 = es.submit(new ConcurentSorter(list2, es));

        List<Integer> sortedList1 = sortedListFuture1.get();
        List<Integer> sortedList2 = sortedListFuture2.get();

        List<Integer> sortedList = mergeSortList(sortedList1,sortedList2);
        return sortedList;

    }

    List<Integer> mergeSortList(List<Integer> sortedList1, List<Integer> sortedList2){
        List<Integer> sortedList = new ArrayList<>();
        int i = 0 ;
        int j = 0 ;

        while(i < sortedList1.size() && j < sortedList2.size()){
            if(sortedList1.get(i) <= sortedList2.get(j)){
                sortedList.add(sortedList1.get(i));
                i++;
            }else {
                sortedList.add(sortedList2.get(j));
                j++;
            }
        }
        while(i < sortedList1.size()){
            sortedList.add(sortedList1.get(i));
            i++;
        }
        while(j < sortedList2.size()){
            sortedList.add(sortedList2.get(j));
            j++;
        }

        return sortedList;
    }
}
