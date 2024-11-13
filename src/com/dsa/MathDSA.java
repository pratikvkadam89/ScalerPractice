package com.dsa;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class MathDSA {

    public static int[] primesum(int A) {
        ///step 1 generate hash set of prime numbers


        int n = A+1;

        boolean[] primes = new boolean[n];

        int i = 0 ;
        for(; i<n ; i++){
            primes[i] = true;
        }

        primes[0] = false;
        primes[1] = false;
        for(i = 2 ; i*i <= A ; i++){

            if(primes[i]){

                for(int j = i * i ; j <= A ; j = j+i ){
                    primes[j] = false;
                }
            }
        }

        SortedSet<Integer> setOfPrimes = new TreeSet<>();
        for(i = 0 ; i<n ; i++){
            if(primes[i]){
                setOfPrimes.add(i);
            }
        }

        int[] ans = new int[2];
        int sizeOfPrimes = setOfPrimes.size();
        for(Integer primeNum : setOfPrimes ){
            int otherNum = A - primeNum;
            if(setOfPrimes.contains(otherNum)){
                ans[0] = primeNum;
                ans[1] = otherNum;
                break;
            }
        }

        return ans;

    }

    public static int combination(int A, int B, int C) {
        // we make use pascal triangle over here

        // we make pascal triangle and get the value from that 2d array


        if(A==B){
            return 1%C ;
        } else if (B==1){
            return A%C;
        }
        int n = Math.max(A,B);

        int[][] pascalTri = new int[A+1][B+1];
        int row = pascalTri.length;
        int column = pascalTri[0].length;

        for(int i =0 ; i < row ; i++ ) {
            pascalTri[i][0] = 1;

            for(int j = 1 ; j <= column ; j++){

                if(j==i){
                    pascalTri[i][j] = 1;
                }else {
                    pascalTri[i][j] = pascalTri[i-1][j]%C + pascalTri[i-1][j-1]%C;
                }

            }
        }

        return pascalTri[A][B] % C;
    }
}
