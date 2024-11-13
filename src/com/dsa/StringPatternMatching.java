package com.dsa;

import java.util.*;

public class StringPatternMatching {

    public int premutation(String A, String B) {

        int nA = A.length();
        int i = 0 ;
        int j = nA-1 ;
        int nB = B.length();
        int ans = 0 ;

        while( j < nB ){

           String subStringToCheck = B.substring(i , j+1);

            if( isEqual(A,subStringToCheck) ){
                ans++;
            }

            i++;
            j++;

        }

        return ans;


    }

    boolean isEqual(String refString , String stringToCheck){

        char[] refArr = refString.toCharArray();
        char[] toCheckArr = stringToCheck.toCharArray();

        Arrays.sort(refArr);
        Arrays.sort(toCheckArr);

        for( int i =0 ; i < refArr.length ; i++){
            if(refArr[i] != toCheckArr[i]){
                return false;
            }
        }

        return true;
    }
}
