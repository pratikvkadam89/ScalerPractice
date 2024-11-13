package com.dsa;

import java.util.*;

public class Disjoint {

    public int solve(int A, int[][] B, int[][] C) {
        int noOfPeople = A;
        Set<Integer> walkSet = new HashSet<>();
        Set<Integer> talkSet = new HashSet<>();

        int i = 0;
        for( i = 0 ; i < B.length; i++){
            walkSet.add(B[i][0]);
            walkSet.add(B[i][1]);
        }

        for( i = 0 ; i < C.length; i++){
            talkSet.add(C[i][0]);
            talkSet.add(C[i][1]);
        }

        walkSet.retainAll(talkSet);
        if(walkSet.size() > 0){
            return 0;
        }

        int[] parentArray = new int[A+1];
        for( i = 1 ; i <= A ; i++){
            parentArray[i] = i;
        }


        for(i = 0 ; i < B.length ; i++){
            union( B[i][0] , B[i][1], parentArray);
        }

        for(i = 0 ; i < C.length ; i++){
            union( C[i][0] , C[i][1], parentArray);
        }

        int countOfGroups = 0 ;
        // Arrays.sort(parentArray);
        // for(i = 1 ; i < parentArray.length;i++){
        //     if(parentArray[i-1] != parentArray[i]){
        //         countOfGroups++;
        //     }
        // }

        Set<Integer> groups = new HashSet<>();

        for(i = 1 ; i < parentArray.length;i++){
            if( i == parentArray[i]){
                countOfGroups++;
            }
        }

//        countOfGroups = groups.size();


        int ans = 1;
        int mods = 1000000007;

        for( i = 1 ; i <= countOfGroups ; i++){
            ans  *= 2;
        }

        return ans;




    }

    boolean union(int n1 , int n2,int[] parentArray ){

        int root1 = findRoot(n1,parentArray);
        int root2 = findRoot(n2,parentArray);


        if(root1 == root2){
            return false;
        }

        if(root1 < root2){
            parentArray[root2] = root1;
        }else {
            parentArray[root1] = root2;
        }

        return true;
    }

    int findRoot(int n1, int[] parentArray){

        if( n1 == parentArray[n1]){
            return n1;
        }

        parentArray[n1] = findRoot(parentArray[n1] , parentArray);
        return parentArray[n1];
    }
}
