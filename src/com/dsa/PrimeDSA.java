package com.dsa;


import java.util.*;

public class PrimeDSA {

    public static int solve(ArrayList<Integer> A) {

        //Logic here used is, No's between 2 consequetive prime numbers will have same set of prime numbers in their factorial
        //For Ex : 7 , 8 , 9 , 10 , 11,
        //Here no. 7 , 8 , 9 , 10 will have same no of prime numbers in their factorial
        //Therefore they can form sub-set having same set of prime factors
        //Total no Of sub-set they can form 2^4 , substract 1 to deduct sub-set with zero elements.

        //Sort the array and calculate the prime for the max element of the array
        //this will give us all the possible prime numbers, which can be their in the facotrial of, an element, of the array.
        Collections.sort(A);
        int n = A.size();
        List<Integer> primeNoList = getPrimeList(A.get(n-1));

        //We will store the elements of A in queue
        //We will iterate through the primeNoList , for each prime no. we will calculate the no elements = B
        //less than the prime no. and pop them from the queues

        //storing element is queue
        Queue<Integer> arrayQ = new LinkedList<>();
        for(Integer num : A){
            if(num > 1) arrayQ.add(num);
        }
        double ans = 0.0 ;

        for(Integer primeNum : primeNoList){
            int countOfElement = 0;
            while(arrayQ.size() > 0 && arrayQ.peek() < primeNum){
                arrayQ.poll();
                countOfElement++;
            }
            //countOfElement will give the subset that can be formed;
            if(countOfElement > 0 ) ans = ans + (Math.pow(2,countOfElement) - 1.0);
        }

        if(arrayQ.size() > 0){
            ans = ans + (Math.pow(2,arrayQ.size()) - 1.0) ;
        }


        long longans = (long) ans;
        int mods = 1000000000 + 7;
        return (int) (longans % mods);

    }

    static List<Integer> getPrimeList(int n){
        //using sieve algo , TC n*log(log(n))
        List<Integer> list = new ArrayList<>();
        boolean[] primes = new boolean[n+1];
        int i =0;
        for(;i<=n;i++){
            primes[i] = true;
        }
        primes[0] = false;
        primes[1] = false;

        for(i = 2 ; i * i <= n ; i++){
            if(primes[i]) {
                for(int j = i * i ; j <= n ; j = j + i ){
                    primes[j] = false;
                }
            }
        }

        for( i = 0 ; i <= n ; i++){
            if(primes[i]){
                list.add(i);
            }
        }

        return list;
    }
}
