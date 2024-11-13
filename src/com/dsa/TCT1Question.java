package com.dsa;

public class TCT1Question {



    /*

    Question : Contiguous Characters

    You are given a string A, tell how many contiguous character c
    you can get in a given string? You are allowed to do at most B number of changes
    in the string. A change is defined as changing a character at any index in the
    given string.

    Input 1:
        A = "oyorooms"
        B = 1
        C = "o"

    Output 1:
        4

    Explanation 1:
        Modified string would be - "oyooooms".
    */

    public int contigousCharacter(String A, int B, String C) {



        int nA = A.length();

        if(B >= nA ){
            return B;
        }

        int countOfC = 0 ;

        int i = 0 ;
        for(i = 0 ; i < nA ; i++){

            if(A.charAt(i) == C.charAt(0)){
                countOfC++;
            }
        }


        int windowToCheck = countOfC + B;

        if(windowToCheck > nA){
            windowToCheck = nA;
        }
        int countOfIrrelevant = 0 ;
        int countOfRelevant = 0;

        for(i = 0 ; i < windowToCheck ; i++){
            if(A.charAt(i) == C.charAt(0)){
                countOfRelevant++;
            }else {
                countOfIrrelevant++;
            }
        }


        int maxLength = Integer.MIN_VALUE;


        i = 0 ;
        int j = windowToCheck-1;

        while(j < nA){

            if(countOfIrrelevant > B){
                //reduce the window size;
                if(A.charAt(i) != C.charAt(0)){
                    countOfIrrelevant--;
                }else {
                    countOfRelevant--;
                }
                i++;

            }else {
                //this is the valid condition to check the length;

                int length = j - i + 1;
                maxLength = Math.max(maxLength,length);

                if( ++j < nA && A.charAt(j) != C.charAt(0) ){
                    countOfIrrelevant++;
                }else {
                    countOfRelevant++;
                }


            }




        }


        return maxLength;



    }
}
