package com.dsa;

public class InverseMod {

    public int computeCombination(int A, int B, int C) {
        int n  = A ;
        int r = B ;
        int p = C;


        //nCr % p =   n !/ (n - r ) ! * r !
        // n! * (n-r)! ^ -1    *   r! ^ -1

        // n! % p

        int nFact = factorial(n,p);
        int i = 0;

        //(n-r)!

        int nRFact = factorial(n-r,p);

        int rFact = factorial(r,p);

        int a = powerFunc(nRFact, p-2 , p);
        int b = powerFunc(rFact,p-2 , p);

        return  ((((nFact%C)*(b%C))%C*(a%C))%C)%C;


    }

    int factorial(int n, int p){
         int fact=1 ;
        for(int i=2;i<=n;i++){
            fact = ( (fact *i%p)) % p;
        }
        return  fact;
    }



    int powerFunc(int number , int exponent, int mod){

        if(exponent == 0 ){
            return 1;
        }

        long p = powerFunc(number , exponent/2 , mod );

        if( (exponent%2) == 0 ){

            return (int) ((p * p ) % mod)    ;
        }else {
            return  (int) (( ( (p * p ) % mod ) * number ) % mod ) ;
        }

    }
}
