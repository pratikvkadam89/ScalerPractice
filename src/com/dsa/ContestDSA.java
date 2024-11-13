package com.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContestDSA {



    public ArrayList<ArrayList<Integer>> solve(final List<ArrayList<Integer>> A, final int B) {

        Collections.sort(A, (l1 , l2 ) -> {

            int x1 = l1.get(0);
            int y1 = l1.get(1);
            int x2 = l2.get(0);
            int y2 = l2.get(1);

            int val1 = (x1 * x1) + (y1 * y1);
            int val2 = (x2 * x2) + (y2 * y2);

            if(val1 < val2){
                return 1;
            }else if (val1 > val2) {
                return -1;
            }else {
                return 0;
            }

        });


        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < B ; i++){
            ans.add(A.get(i));
        }

        Collections.sort(ans, (l3 , l4 ) -> {
            int x3 = l3.get(0);
            int y3 = l3.get(1);
            int x4 = l4.get(0);
            int y4 = l4.get(1);

            if(x3 < x4){
                return -1;
            }else if (x3 > x4) {
                return 1;
            }else {
                if(y3 < y4){
                    return -1;
                }else if ( y3 > y4 ){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        return ans;
    }










    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int l = 1;

        int h = A.length;
        long sumOfAllWt = getSum(A);
        int ans = -1;

        while (l <= h){
            int mid = l + ((h-l)/2);
            if(check(mid,A,B,sumOfAllWt)){
                ans = mid;
                h = mid -1;
            }else {
                l = mid+1;
            }

        }
        return ans;

    }

    static boolean check(int noOfRides , int[]wtsOfStud, int capacityOfEachRide, long sumOfAllWtofStudent ){

        int noOfStudentCapacityOfEachRide = 2;
        int noOfStudentSittingOnARide = 1;
        int noOfRideTaken = 1;
        int n = wtsOfStud.length;
        for(int i = 1 ; i < n ; i++){
            noOfStudentSittingOnARide++;
            if(noOfStudentSittingOnARide>noOfStudentCapacityOfEachRide){
                noOfStudentSittingOnARide = 1;
                noOfRideTaken++;
            }
        }

        if(noOfRideTaken<=noOfRides && ( sumOfAllWtofStudent <= (1L*noOfRideTaken*capacityOfEachRide))) return true;
        else return false;
    }

    static long getSum(int[] A){
        long sum = 0L;
        for(int num : A){
            sum += num;
        }
        return sum;
    }
}
