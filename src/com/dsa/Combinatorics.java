package com.dsa;

public class Combinatorics {

    public static String convertToTitle(int A) {


        StringBuilder sb = new StringBuilder();
        int n = A ;
        // while (n > 0){
        //     char ans =  (char) ((n - 1) % 26 + 'A');
        //     sb.append(ans);
        //     n = (n -1) / 26;
        // }

        while (n > 0 ){
            int rem = n % 26;
            if(rem != 0) rem = rem -1 ;
            else rem = 25;
            char ans = (char) ('A' + rem);
            sb.append(ans);
            n = n / 26;
        }
        return sb.reverse().toString();


    }
}
