package com.dsa.TCT1_8;

import java.util.*;

public class SuperArray {

    public static ArrayList<Integer> superArray(ArrayList<Integer> A, ArrayList<Long> B) {
        Collections.sort(A);
        int nA = A.size();

        int[] freqA = new int[nA];

        int i = 0 ;
        for(i = 0 ; i < nA ; i++){
            freqA[i] = (i+1) * (nA - i);
        }

        long[] preFixFreq = new long[nA];
        preFixFreq[0] = (1l * freqA[0])  ;
        for(i = 1 ; i < nA ; i++){
            preFixFreq[i] = preFixFreq[i-1] + freqA[i] ;
        }
        ArrayList<Integer> ans = new ArrayList<>();

        int nB = B.size();
        for(i = 0 ; i < nB ; i++){
            long indexToFind = B.get(i);

            if(indexToFind == 11){
                System.out.println(indexToFind);
            }

            int l = 0 ;
            int h = nA-1;
            int indexAns = -1;
            while(l <= h){
                int mid = l + ((h -l)/2);
                long value = preFixFreq[mid];

                if(value <= indexToFind){
                    l = mid +1;
                }else  {
                    indexAns = mid;
                    h = mid - 1;
                }
            }

            if(indexAns != -1){
                ans.add(A.get(indexAns));
            }else {
                ans.add(-1);
            }

        }

        return ans;


    }
}
