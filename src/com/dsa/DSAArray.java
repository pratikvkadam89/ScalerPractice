package com.dsa;

import java.util.ArrayList;
import java.util.List;

public class DSAArray {


//    public static void (int[] a , int[] b){
//
//
//
//
//    }

    public static int trapWater(int[] height) {

        int n = height.length;

        int[] lmax = new int[n];
        int[] rmax = new int[n];

        // construc lmax arrray
        int i = 1 ;
        lmax[0] = 0;
        for(i = 1; i<n ; i++){
            lmax[i] = Math.max(lmax[i-1],height[i-1]);
        }
        i = n-2;

        rmax[n-1] = 0;
        for(i = n-2; i>=0 ; i--){

            int num1 = lmax[i+1];
            int num2 = height[i+1];
            rmax[i] = Math.max(lmax[i+1],height[i+1]);
        }


        int waterTrapped = 0 ;
        i=0;
        for(i = 1 ; i <= n-1 ; i++){
            int waterHt = Math.min(lmax[i],rmax[i]) - height[i];
            if(waterHt > 0 ){
                waterTrapped += waterHt;
            }
        }
        return waterTrapped;
    }


    public static int[] flip(String A) {

        //the question ask to flip the bits , (0 > 1 and 1 > 0) ,so that maximum 1's are there
        // flip  0 -> 1  = +1 and Flip 1 -> 0 = -1

        // therefore we have to find sub-array where this sum is maxmized


        int n = A.length();
        char[] achar = A.toCharArray();
        int[] aint= new int[n];

        for(int i =0 ; i < n ; i++){
            if(achar[i] =='1'){
                aint[i] = -1;
            }else if(achar[i] == '0'){
                aint[i] = 1;
            }
        }
        int cSum = 0;
        int maxSum = 0 ;
        int[] ans = new int[2];

        int L = 0;
        int R = 0;

        for(int j = 0 ; j<n ; j++){
            cSum += aint[j];

            if(cSum > maxSum){
                maxSum = cSum;

                //Here ans is update only if cSum is max
                ans[0] = L+1;
                ans[1] = R+1;
            }
            if(cSum < 0 ){
                /// here we set L and R
                /// when ever csum becomes negative new L and R  will be considered;
                cSum = 0;
                L = j+1;
                R = j+1;
            }else {
                // here only r is incremented  and not L;
                // L was set
                R++;
            }
        }

        if(maxSum==0){
            return new int[0];
        }
        return ans;


    }

    //spiral order for 2D array : work for both square and rect
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0 ;
        int j = 0 ;
        ArrayList<Integer> ans = new ArrayList<>();

        int count = 0;

        int row = matrix.length;
        int column = matrix[0].length;

        while ( column > 1 && row > 1 ){
            for(count = 1 ; count < column ; count++){
                ans.add(matrix[i][j]);
                j++;  //0 , 1 ,2 ,3
            }
            //i = 0 ans j = 3

            for(count  = 1 ; count < row; count++){
                ans.add(matrix[i][j]);
                i++;
            }
            //i = 2  and j = 3
            for(count  = 1 ; count < column; count++){
                ans.add(matrix[i][j]);
                j--;
            }
            //i = 2  and j = 0
            for(count  = 1 ; count < row; count++){
                ans.add(matrix[i][j]);
                i--;
            }
            //i = 0  and j = 0

            i++;
            j++;
            column = column -2;
            row = row -2;
        }

        //condt 1 : for square matrix
        //condt 2 and 3 : for rect matrix
        if(column == 1 && row == 1){
            ans.add(matrix[i][j]);
        } else if(column > 1 && row == 1) {
            for(count = 1 ; count <= column ; count++){
                ans.add(matrix[i][j]);
                j++;  //0 , 1 ,2 ,3
            }
        } else if(row > 1 && column == 1){
            for(count  = 1 ; count <= row; count++){
                ans.add(matrix[i][j]);
                i++;
            }
        }

        return ans;


    }
}
