package com.dsa;

import java.util.Arrays;

public class Interview {


    //my , name .
    static String reverseWord ( String sentence){

        char[] charArr = sentence.toCharArray();

        for( int i = 0  ; i < charArr.length ; ){

            if( isLetter(charArr[i])){

                int j = i;

                while ( j <charArr.length && isLetter(charArr[j])){
                    j++;
                }

                char[] words = Arrays.copyOfRange(charArr,i,j);

                reverseArray(words);

                copyToOriginal(charArr, words, i,j);

                i = j;

            }else {
                i++;
            }
        }

        return new String(charArr);
    }

    static  void copyToOriginal(char[] original , char[] reversed , int s , int e){
        int i = 0 ;
        while(s < e){
            original[s] = reversed[i++];
            s++;
        }
    }

    static char[] reverseArray(char[] words){

        int i = 0 ;
        int j = words.length-1;
        while ( i < j ){
            char t = words[i];
            words[i] = words[j];
            words[j] = t;
            i++;
            j--;
        }

        return words;


    }

    static boolean isLetter(char c ){

        if((c >= 'a'  && c <= 'z') || (c >= 'A'  && c <= 'Z')) return true;
        return false;
    }
}
