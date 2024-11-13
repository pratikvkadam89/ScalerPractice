package com.dsa;

import java.util.ArrayList;
import java.util.Stack;

public class StackProblems {

    public static int getSumOfMaxAndMin(ArrayList<Integer> A) {

        Stack<Integer> stackOfInt = new Stack<>();
        int n = A.size();
        //for next greatest
        int i = 0;
        int[] nGL = new int[A.size()];
        for( ; i < n;i++){
            while (!stackOfInt.empty()&& A.get(stackOfInt.peek()) <= A.get(i)) {
                stackOfInt.pop();
            }
            if(stackOfInt.empty()) nGL[i] = -1;
            else nGL[i] = stackOfInt.peek();
            stackOfInt.push(i);
        }


        //empty the stackOfInt
        while(!stackOfInt.empty()){
            stackOfInt.pop();
        }

        int[] nGR = new int[A.size()];
        i = n - 1;

        for( ; i>=0;i--){
            while (!stackOfInt.empty()&& A.get(stackOfInt.peek()) <= A.get(i)) {
                stackOfInt.pop();
            }
            if(stackOfInt.empty()) nGR[i] = n;
            else nGR[i] = stackOfInt.peek();
            stackOfInt.push(i);
        }

        //empty the stackOfInt
        while(!stackOfInt.empty()){
            stackOfInt.pop();
        }

        //for next smallest
        int[] nSL = new int[A.size()];
        i = 0;
        for( ; i<n ;i++){
            while (!stackOfInt.empty()&& A.get(stackOfInt.peek()) >= A.get(i)) {
                stackOfInt.pop();
            }
            if(stackOfInt.empty()) nSL[i] = -1;
            else nSL[i] = stackOfInt.peek();
            stackOfInt.push(i);
        }



        //empty the stackOfInt
        while(!stackOfInt.empty()){
            stackOfInt.pop();
        }

        int[] nSR = new int[A.size()];
        i = n-1;

        for( ; i>=0 ;i--){
            while (!stackOfInt.empty()&& A.get(stackOfInt.peek()) >= A.get(i)) {
                stackOfInt.pop();
            }
            if(stackOfInt.empty()) nSR[i] = n;
            else nSR[i] = stackOfInt.peek();
            stackOfInt.push(i);
        }


        i=0;

        long ans = 0L;

        for(;i<n;i++){

            long subArraysWhereNumIsMax = (i - nGL[i]) * ( nGR[i] - i);
            long subArraysWhereNumIsMin = (i - nSL[i]) * (nSR[i] - i);

            ans +=   (subArraysWhereNumIsMax - subArraysWhereNumIsMin) *   A.get(i);

        }

        int mods = 1000000007;
        return (int) (ans%mods);

    }
}
