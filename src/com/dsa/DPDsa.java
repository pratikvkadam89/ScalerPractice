package com.dsa;

import java.math.BigDecimal;
import java.util.*;

public class DPDsa {

    public int lis(final int[] A) {

        int nA = A.length;
        Integer[] dp = new Integer[nA];
        //dp[i] = max lis that can be formed till that index
        //since max length can be formed at any idx we will need addtion parameter for saving max length
        //ex. 1 2 1 5 2. Here max length is formed at index 3.
        for(int j = nA-1 ; j >= 0; j--){
            recLis(A,j,dp);
        }


        int maxv = 1;

        for(int i = 0 ; i < nA ; i++){
            if(dp[i] != null){
                maxv = Math.max(maxv,dp[i]);
            }
        }

        return maxv;

    }

    int recLis(int[] A , int idx, Integer[] dp){

        if(idx==0){

            return 1;
        }

        if(dp[idx] != null){
            return dp[idx];
        }

        //this is the min answer possible
        int ans = 1;
        for(int i = (idx - 1) ; i >= 0 ; i--){
            if(A[i] < A[idx]){
                int childAns = recLis(A,i,dp);
                ans = Math.max(ans, childAns+1);
            }
        }

        dp[idx] = ans;

        return ans;
    }

    public int flipArray(final int[] A) {

        //Flip the sign and To check if array can be divided in 2 parts such the diff of 2 parts is minized.
        //Here we will check if array can be divided in 2 part
        //And if sum/2 is possible or not.
        int sum = getSum(A);

        int n = A.length;
        int halfSum = sum / 2;

        boolean[][] dp = new boolean[n+1][halfSum+1];
        int rows = dp.length;
        int colms = dp[0].length;

        //dp[i][j] = For ith no of elements (from start) can we form jth sum
        int i = 0;
        int j = 0;

        for(i = 0 ; i < rows ; i++){
            for(j = 0 ; j < colms; j++){
                if(i==0 && j == 0 ){
                    //with 0 elements can we form 0 sum
                    dp[i][j] = true;
                }else if(i == 0 && j > 0 ) {
                    //with 0 elements can we form sum > 0;
                    dp[i][j] = false;
                }
//                }else if(i > 0 && j == 0) {
//                    //with elements > 0 can we form sum = 0
//                    dp[i][j] = false;
//                }
                else {

                    //To check elements > 0 and sum > 0
                    // boolean x = can sum = j be formed using ith no of elements
                    int value = A[i-1]; // value of an i-1 element. so i = no of elements considered,
                    boolean x = false;
                    if(value <= j) x = dp[i-1][j - value];
                    // boolean y = can sum = j be formed with-out using ith no of elements
                    boolean y = dp[i-1][j];

                    if(x||y){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = false;
                    }

                }
            }
        }

        for( j = colms-1 ; j >= 0 ; j--){
            boolean isJthSumPossible = dp[rows-1][j];
            if(isJthSumPossible){
                i = rows -1;
                while(i >= 0 && dp[i][j]){
                    i--;
                }
                break;
            }
        }
        return i +1 ;
    }

    int getSum(int[] a){
        int n = a.length;
        int sum = 0 ;

        for(int i = 0 ; i < n ; i++){
            sum += a[i];
        }

        return sum;
    }

    public int solve(int[] A, int[] B, int C) {

        //recurrssive way
        int n = A.length;
        Pair[] pairArray = new Pair[n];
        int i = 0;

        for( i =0 ;i < n ; i++){
            pairArray[i] = new Pair(A[i],B[i]);
        }
        int[][] dp = new int[n+1][C+1];
        int row = dp.length;
        int colm = dp[0].length;
        for(i  = 0 ; i < row ;i++){
            for( int j = 0 ; j < colm ; j++){
                dp[i][j] = -1;
            }
        }
        return recurrssiveWay(n-1, pairArray,C,dp);

        // As we can see from the recurrssive way : 2 variable changes
        // 1. indexFromStartConsidered
        // 2. capacity

        //therefore 2d array would be required to create a dp array

        // where i = indexFromStartConsidered and j = capacity
        //dp[i][j] = max value that can be achieved ith index and jth capacity.




    }

    int recurrssiveWay(int indexFromStartConsidered, Pair[] pairArray, int capacity,int[][] dp){
        System.out.println("idx: " + indexFromStartConsidered + "  " + "capa: " + capacity);
        Pair currPair = pairArray[indexFromStartConsidered];

        if(indexFromStartConsidered == 0 && capacity ==  0 ){
            return 0 ;
        }
        if(indexFromStartConsidered == 0 && currPair.weight <= capacity){
            return currPair.value;
        }

        if(indexFromStartConsidered == 0 && currPair.weight > capacity){
            return 0;
        }

        if(dp[indexFromStartConsidered][capacity] != -1 ){
            return dp[indexFromStartConsidered][capacity];
        }

        int valueIfCurrPairConsidered = 0 ;

        if(currPair.weight <= capacity){
            valueIfCurrPairConsidered = recurrssiveWay(indexFromStartConsidered -1 , pairArray, capacity - currPair.weight,dp) + currPair.value;
        }
        int valueIfCurrPairNotConsidered = recurrssiveWay(indexFromStartConsidered - 1 , pairArray, capacity,dp);
        dp[indexFromStartConsidered][capacity] = Math.max(valueIfCurrPairConsidered,valueIfCurrPairNotConsidered);
        return dp[indexFromStartConsidered][capacity];
    }


    class Pair {

        int value ;
        int weight ;

        Pair(int value , int weight){
            this.value = value;
            this.weight = weight;
        }
    }

}
