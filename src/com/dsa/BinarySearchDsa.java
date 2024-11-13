package com.dsa;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchDsa {

    public static ArrayList<Integer> solveAddOrNot(ArrayList<Integer> A, int B) {

        Collections.sort(A);
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(Integer.MIN_VALUE);
        ans.add(-1);

        long[] prefixSum = new long[n];
        prefixSum[0] = 1l * A.get(0);
        for(int j = 1 ; j<n ; j++){
            prefixSum[j] =  prefixSum[j-1] +  A.get(j);
        }
        //optimal soln tc :  O(nlogn)  and sc : O(n)
        for(int i = 0 ; i < n ; i++){
            //for A[i] we need to check how many elements can be incremented to A[i]
            int low = 1;
            int high = i + 1;
            long operationAllowed = (long) B;
            int maxOccurence = Integer.MIN_VALUE;
            //this is tc log(n)
            while (low <= high){
                int noOfElement = low + ((high - low) / 2);  // a + (b - a)/2
                long sumRequired = 1L * noOfElement * A.get(i); //sum with noOfElement which is possible occurence
                long sumAct = getSum(prefixSum,(i-noOfElement+1),i); //sum which is there the array
                long diff = sumRequired - sumAct; // operation required. for actual sum to reach sumRequired
                if(diff <= operationAllowed){
                    maxOccurence = Math.max(maxOccurence,noOfElement);
                    //increase no of elements
                    low = noOfElement + 1;
                }else {
                    //decrease no of elements
                    high = noOfElement -1;
                }
            }
            if(maxOccurence > ans.get(0)){
                ans.set(0,maxOccurence);
                ans.set(1,A.get(i));
            }
        }
        return ans;

        // //O(n^2) soln
        // //Here for all A[i] we checked back using j -> i to 0 , and getting the occurence
        // for(int i = 0 ; i < n ; i++){
        //     int occurence = 0;
        //     int operationAllowed = B;

        //     for( int j = i ; j>=0; j--){
        //         if(A.get(i) - A.get(j) <= operationAllowed){
        //             operationAllowed -= A.get(i) - A.get(j);
        //             occurence++;
        //         }else {
        //             break;
        //         }
        //     }

        //     if(occurence>ans.get(0)){
        //         ans.set(0,occurence);
        //         ans.set(1,A.get(i));
        //     }
        // }

        // return ans;
    }



    static long  getSum(long[] prefixSum, int s , int e){
        long ans = 0l;
        if(s == 0){
            ans = prefixSum[e];
        }else {
            ans = prefixSum[e] - prefixSum[s-1];
        }
        return ans;
    }





    public static boolean  check(int dayToStartFrom, long noOfDayWithUs, int noOfBouqesToCreate, int noOfFlowerRequiredToCreateOneBq,int[] bDays){

        int i = dayToStartFrom;
        int n = bDays.length;


        while(i<=noOfDayWithUs){

            //we have to check how many adjacent no Of fower we have on that
            int count = 0 ;
            int noOfBqCreated = 0 ;
            for(int j = 0 ; j < n; j++ ){
                if(bDays[j]<=i){
                    count++;
                    if(count==noOfFlowerRequiredToCreateOneBq){
                        noOfBqCreated++;
                        count = 0;
                    }
                } else {
                    count = 0 ;
                }
            }
            if(noOfBqCreated>=noOfBouqesToCreate){
                return true;

            }
            i++;
        }

        return false;

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // soln is to manifest the merged sorted array not actually merge it
        // assuming is nums1.lenght is less or equal to nums2.lenght
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return findMedianSortedArrays(nums2,nums1);
        }

        int totalLength  = n1 + n2;


        int elementsInFirstHalf = (n1 + n2 + 1)/2;

        int l = 0; // min elems that can be chose from nums1
        int h = n1; //max elemn that can be chosen from nums2

        double ans = 0.0 ;

        while(l<=h){
            int mid = l + ((h-l)/2);

            //we start by chosing mid no of elements from nums1
            int cut1 = mid;
            //remaing element will be chosen from nums2
            int cut2 = elementsInFirstHalf - cut1;

            int l1 = cut1==0 ? Integer.MIN_VALUE :  nums1[cut1-1];
            int l2 = cut2==0 ? Integer.MIN_VALUE :  nums2[cut2-1];

            int r1 = cut1 == n1 ? Integer.MAX_VALUE :  nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE :  nums2[cut2];

            /// ------l1 r1---- array1
            /// =======l2 r2==== aaray 2
            if(l1<=r2 && l2<=r1){
                if(totalLength%2==0){
                    ans = (0.0 + Math.max(l1,l2) + Math.min(r1,r2)) / 2;
                }else {
                    ans = 0.0 + Math.max(l1,l2);
                }
                break;

            }else if (l1 > r2 ){
                //go left
                h = mid-1 ;
            }else {
                l = mid + 1;
            }
        }

        return ans ;

    }

    public static int sqrt(int A) {
        int min = 0 ;
        int max = A;

        int ans = 0 ;
        int mods = 1000000007;

        while(min<=max){
            int mid = min + ((max - min) / 2);
            Long possibleAns = (long) mid* mid;
            if(possibleAns == A){
                ans =  mid;
                break;
            } else if ( possibleAns > A){
                //go left
                max = mid -1;
            } else {
                ans = mid;
                min = mid + 1;
            }
        }

        return ans;

    }

    public static int paint(int A, int B, ArrayList<Integer> C) {

        ArrayList<Long> D = new ArrayList<>();
        for(int i = 0 ; i < C.size() ; i++){
            long totalLength =  (long) C.get(i )* (long)B;
            D.add(totalLength);
        }

        int mods = 1000000003;

        long l = maxOf(D); // assuming you have infinite no of painters, then this min time will be the max of C

        long h = sumOf(D); // assuming you have only one painter, then max time will be taken to paint all the boards;

        if(A==1){

            int ans1 = (int) (h%mods);
            return ans1;
        }
        long ans = 0L ;

        while (l<=h){

            long mid = l + ((h-l)/2L);

            if(check(mid,D,A)){
                ans = mid;
                //go left to minimize
                h = mid - 1L ;

            }else {
                l = mid + 1L ;
            }
        }

        return (int) ans%mods;
    }

   static private boolean check(long totalMinTimeWithEachPainter, ArrayList<Long> listOfBoardLength, int noOfPainters){

        int c = 1 ;//we start with first painter
        int n = listOfBoardLength.size();
        long s = 0; // time spent

        for(int i = 0 ; i < n ; i++ ){
            long timeTakenToPaintTheBoard = listOfBoardLength.get(i);
            s += timeTakenToPaintTheBoard;

            if(s > totalMinTimeWithEachPainter){
                c++;
                s = timeTakenToPaintTheBoard;
                if(c>noOfPainters){
                    return false;
                }

            }

        }

        return true;

    }

    static Long sumOf(ArrayList<Long> c){

        Long ans = 0L;
        int n = c.size();

        for(int i = 0 ; i < n ; i++){
            ans += c.get(i);
        }
        return ans;

    }

    static Long maxOf(ArrayList<Long> c){
        Long ans = Long.MIN_VALUE;
        int n = c.size();

        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans,c.get(i));
        }
        return ans;
    }

}
