package com.dsa;

import java.util.LinkedList;

public class QueueProblems {

    public static int[] slidingMaximum(final int[] A, int B) {

        LinkedList<Integer> dq = new LinkedList<>();

        //start with by initiating window

        int n = A.length;
        int[] ans = new int[n-B+1];
        int idxOfAnx = 0 ;
        int i = 0 ;
        for ( ; i < B ; i++){
            while( dq.size() > 0 && A[dq.peekLast()] <= A[i]){
                dq.pollLast();
            }
            dq.add(i);
        }
        ans[idxOfAnx++] = A[dq.peekFirst()];

        i = 1;
        int j = B;

        while (j < n){

            if(A[dq.peekFirst()] == A[i-1]){
                dq.pollFirst();
            }
            while( dq.size() > 0 && A[dq.peekLast()] <= A[j]){
                dq.pollLast();
            }
            dq.add(j);

            ans[idxOfAnx++] = A[dq.peekFirst()];
            i++;
            j++;

        }

        return ans;

    }
}
