package com.dsa;

import java.util.ArrayList;
import java.util.*;

public class TwoPointer {

    public static List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        // List<Integer> uniqueList = new ArrayList<>(Arrays.asList(nums));

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i <= n-3 ; i++){

            if (i > 0 && nums[i] == nums[i-1]  ){
                continue;
            }
            int refNum = -(nums[i]);

            int j = i +1;
            int k = n-1 ;
            while(j < k){

                int num1 = nums[j];
                int num2 = nums[k];

                if((num1 + num2) == refNum){

                    ans.add(Arrays.asList(nums[i] , num1 , num2 )  );

                    //skipping duplicate j's
                    while( j < k && nums[j] == nums[j+1]){
                        j++;
                    }

                    //skipping duplicate k's
                    while( j < k && nums[k] == nums[k-1]){
                        k--;
                    }


                    j++;
                    k--;
                }else if (( num1 + num2 ) < refNum){
                    j++;
                }else {
                    k--;
                }
            }
        }

        return ans;
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        int n = s.length();
        int i = 0 ;
        for(i = 0 ; i < n ; i++){
            char chari = s.charAt(i);
            if(chari >= 'a' && chari <= 'z'){
                sb.append(chari);
            }
        }

        s = sb.toString();
        i = 0 ;
        int j = s.length()-1;

        while(i <= j ){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;

    }

    public static int findPairsDiff(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0 ;
        int j = 1 ;
        int n = nums.length;
        int ans = 0 ;
        while (j<n){
            int diff = nums[j] - nums[i];
            if(i==j){
                j = i+1;
            }else if(diff < k){
                j++;
            }else if(diff > k){
                i++;
            }else if (diff==k){
                ans++;
                //we will be skipping all the dups of j
                int jj = j;
                if(jj<n && nums[jj]==nums[j]){
                    jj++;
                }
                j = jj;
            }
        }

        return ans;


    }



    public static int subarraySum(int[] nums, int k) {

        //two pointer

        int i = 0 ;
        int j = 0 ;
        int ans = 0 ;
        int n = nums.length;
        int sum = nums[0];

        while(j<n){
            if(sum < k){
                j++;
                if(j==n){
                    break;
                }
                sum += nums[j];
            }else if(sum>k){
                sum -= nums[i];
                i++;
                if(i>j && i<=n-1){
                    j++;
                    sum+= nums[j];
                }

            }else {
                ans++;
                i=j;
                sum = nums[i];
                if(j==n-1){
                    break;
                }

            }

        }

        return ans;

    }


    public static int findPairs(ArrayList<Integer> A, int B) {

        // Collections.sort(A);
        int n = A.size();

        int i = 0 ;
        int j = n-1;
        long count = 0 ;
        int mods = 1000000007;

        while(i<j){

            int sum = A.get(i) + A.get(j);

            if(sum == B){
                int ii = i;
                int jj = j;
                long count1 = 0;
                long count2 = 0;

                if(A.get(i).equals(A.get(j))){

                    long count3 = j - i + 1l;
                    count = count + (count3 * (count3-1)/2);
                    break;
                }else {

                    while(A.get(ii).equals(A.get(i))){
                        count1++;
                        ii++;
                    }
                    i = ii;

                    while(A.get(jj).equals(A.get(j))){
                        count2++;
                        jj--;
                    }
                    j = jj;

                    count = count + (count1 * count2);

                }

            }else if(sum < B){
                i++;
            }else{
                j--;
            }
        }
        return (int)(count%mods);
    }
}
