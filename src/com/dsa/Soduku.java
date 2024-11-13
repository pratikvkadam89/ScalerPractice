package com.dsa;

import java.util.*;

public class Soduku {

    public static void solveSudoku(char[][] A) {

        int n = A.length;
        int m = A[0].length;

        int[][] soduku = new int[n][m];

        recSolveSudoko(A,0,n);


    }

    static boolean  recSolveSudoko(char[][] A, int currRow, int rowPossible){


        if(currRow == rowPossible){
            return true;
        }

        int columns = A[0].length;

        HashSet<Integer> rowOfSet = new HashSet<>();

        for(int i = 0 ; i < columns ; i++){

            if(A[currRow][i] == '.'){

                //trying all number from 1 to 9 for that cell
                for(int j = 1 ; j <= 9 ; j++){

                    //checking if the no is valid for that cell
                    if( isValid( j , currRow, i ,A, rowOfSet)  ) {

                        A[currRow][i] = (char) (j+'0')  ;
                        rowOfSet.add(j);

                        boolean valid = recSolveSudoko(A,currRow+1,rowPossible);

                        if(valid){
                            break;

                        }else {
                            rowOfSet.remove(j);
                            A[currRow][i] = '.';
                        }
                    }

                }

            }else {
                rowOfSet.add(A[currRow][i] - '1' +1);
            }
        }


        return true;



    }


    static boolean isValid(int value , int row , int column , char[][] A , HashSet<Integer> rowSet){

        //check if value valide for this row

        if(rowSet.contains(value)){
            return false;
        }


        //check if value valid for this column

        for(int i = 0 ; i < column ; i++){

            if((char) (value+'0') == A[row][i]){
                return false;
            }
        }

        //check if value valid for the block

        row = row - (row%3) ;
        column = column - (column % 3);

        for(int j = row ; j < row+3  ; j++) {
            for(int k = column ; k < column+3 ; k++){
                if((char) (value+'0') == A[j][k] ){
                    return false;
                }
            }
        }


        return true;


    }
}
