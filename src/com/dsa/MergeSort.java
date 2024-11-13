package com.dsa;

import java.util.ArrayList;

public class MergeSort {

    public static int solve(ArrayList<Integer> A) {

        int[] countAns = new int[1];
        countAns[0] = 0 ;
        mergeSort(A,0,A.size()-1,countAns);

        return countAns[0];

    }


    static void mergeSort(ArrayList<Integer> A , int s , int e , int[] countans ){

        if(s==e) return;
        int m = (s + e) / 2;

        mergeSort(A,s,m,countans);
        mergeSort(A,m+1,e,countans);

        mergerSortArray(A,s,m,e,countans);
    }

    static  void mergerSortArray(ArrayList<Integer> a, int s , int m , int e ,int[] countans){

        int p1 = s;

        int p2 = m+1;

        int p3 = 0 ; //counter for temp ArrayList

        int[] temp = new int[e-s+1];

        while (p1<=m && p2<=e){
            if(a.get(p2) < a.get(p1)){
                temp[p3] = a.get(p2);

                countans[0] = countans[0] + (m-p1+1);
                p2++;
            }else {
                temp[p3] = a.get(p1);
                p1++;
            }
            p3++;
        }

        while(p1<=m){
            temp[p3] = a.get(p1);
            p1++;
            p3++;
        }

        while(p2<=e){
            temp[p3] = a.get(p2);
            p2++;
            p3++;
        }

        int nTemp = temp.length;

        for(int i = 0 ; i< nTemp ; i++){
            a.set(s+i,temp[i]);
        }
    }
}
