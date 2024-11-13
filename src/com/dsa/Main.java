package com.dsa;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String ans = Interview.reverseWord("ym eman. si , ujar.");

        System.out.println(ans);
    }

    static int findNoOfFactors(int B){
        int count = 0 ;
        for(int i = 1 ; i * i <= B ; i++){
            if(B%i==0){
                int otherNum = B/i;
                if(otherNum==i){
                    count++;
                }else {
                    count += 2;
                }
            }
        }

        return count ;
    }

    public static int maxHieghtOfStairCase(int A) {



        if( A == 0){
            return 0;
        }

        int varWithProgScope = 0;

        int num = 1;

        int diff = (A*2 - num);
        int powerInt = 44720* 44720;
        while ( powerInt <= diff ){
            varWithProgScope = num;
            num++;
            diff = (A*2 - num);
            powerInt = num* num;
        }



        return varWithProgScope;

        /*double H = (Math.sqrt(1+8*A) - 1 ) / 2;

        return (int) H ;*/

       /* //soln 1 : binary search approach  TC = O(log A);
        int low = 1;
        int high = A;

        int maxHieght = 0;

        int mods = 1000000007;
        int modsInvOfTwo = (int)Math.pow(2, mods - 2) % mods;


        /// 1 .................(initial height)..................A

        while ( low <= high){
            int mid =  low +  ((high - low) / 2);  // a possible height
//            int noOfBlocks =  ((mid%mods) * (((mid + 1) / 2)%mods)) %mods ;

            *//*int multiple = ((mid%mods) * ((mid + 1)%mods))%mods;
            int  noOfBlocks = ( multiple * modsInvOfTwo)%mods;*//*
            int noOfBlocks = 0 ;
            if(mid%2 == 0 ){
                noOfBlocks = (((mid/2) % mods) * ((mid+1) % mods))%mods;
            }else {
                noOfBlocks = ((mid % mods) * (((mid+1)/2) % mods))%mods;

            }



            if(noOfBlocks == A){
                return mid;
            }else if (noOfBlocks > A){
                //goLeft
                high = mid -1  ;

            }else {
                //This is possible ans , try to maximize This
                //go right
                low = mid + 1 ;
                maxHieght = Math.max(mid,maxHieght);
            }

        }

//        int noOfBlocks1 =  ((maxHieght%mods) * (((maxHieght + 1) / 2)%mods)) %mods ; ;
       *//* int  noOfBlocks1 =  ((maxHieght%mods) * ((maxHieght + 1)%mods)) / 2; / 2;
        if(noOfBlocks1 > A){
            return maxHieght -1;
        }*//*

        return maxHieght;*/
    }

    public static ArrayList<Integer> subArraySum(ArrayList<Integer> A, int B) {

        HashMap<Integer,Integer> indxMap = new HashMap<>();

        int n = A.size();
        int idx1 = -1;
        int idx2 = -1;
        ArrayList<Integer> preFixSum = new ArrayList<>();
        preFixSum.add(A.get(0));
        for(int j= 1 ; j < n ; j++){
            int sum = preFixSum.get(j-1) + A.get(j);
            preFixSum.add(sum);

        }

        for(int i = 0; i<n ; i++){
            int otherNum = preFixSum.get(i) - B;
            if(preFixSum.get(i)==B){
                idx1 = 0;
                idx2 = i;
                break;
            }else if(indxMap.containsKey(otherNum)){
                idx1 = indxMap.get(otherNum) + 1;
                idx2 = i;
                break;
            }
            indxMap.put(preFixSum.get(i),i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if(idx1 == -1 && idx2 == -1){
            ans.add(-1);
        }else {
            // ans.add(idx1);
            // ans.add(idx2);
            //loop idx1 to idx2 include

            for(int k = idx1 ; k<=idx2 ; k++){
                ans.add(A.get(k));
            }
        }

        return ans;
    }



    static public int noOfDoors(int A) {

        //create smallest prime factor

        int[] spf = new int[A+1];
        int n = spf.length;
        int i = 0 ;
        for(i = 0 ; i <= A ; i++){
            spf[i] = i;
        }
        i=2;

        for(i =2 ; i*i <= n ; i++ ){  //2 , 3 ,4,
            int x = i;
            if(spf[i] == i){ // this check is need to check prime
                for(int j = i*i ; j<n ; j += i) { // 4 , 6 ,8,10,12,14,16,18,20
                    //if spf is not marked
                    if(spf[j]==j){
                        spf[j] = i;
                    }
                }
            }
        }
        int noOfDoorsOpen = 0;
        // we have array with spf
        i=1;
        for(i =1 ; i <=A ; i++){
            int noOfFactors = getNoOfFactors(i,spf);
            if(noOfFactors%2!=0){
                noOfDoorsOpen++;
            }
        }

        return noOfDoorsOpen;



    }

    static int getNoOfFactors(int num , int[] spf){

        if(num==1){
            return 1;
        }

        HashMap<Integer,Integer> primeFactors = new HashMap<>();

        while(num > 1){
            int smallestPrimeFactor = spf[num];
            int countOfPrimeFactor = primeFactors.getOrDefault(smallestPrimeFactor,0);
            countOfPrimeFactor++;
            primeFactors.put(smallestPrimeFactor,countOfPrimeFactor);
            num = num/smallestPrimeFactor;
        }

        int numOfFactors = 1 ;
        Collection<Integer> listOfNoOfPF = primeFactors.values();

        for(Integer p : listOfNoOfPF){
            numOfFactors = numOfFactors * (p+1);
        }
        return numOfFactors;

    }


    public static int modSum(ArrayList<Integer> A) {


        ArrayList<Integer> pA = new ArrayList<>();
        ArrayList<Integer> sA = new ArrayList(A);

        int n = A.size();

        int mods = 1000000007;

        //construct prefix
        int i =0;
        pA.add(A.get(0));
        for (i = 1 ; i<n ; i++ ){
            int num = (pA.get(i-1)%mods  + A.get(i)%mods )%mods;
            pA.add(num);
        }


        //construct suffix
        for( i = n-2 ; i >= 0 ; i--){
            int num1 = (sA.get(i+1) % mods  + A.get(i)%mods)%mods;
            sA.set(i,num1);
        }


        int ans = 0 ;

        ans = ans +  (sA.get(1) % A.get(0)) ;

        ans = ans +  (pA.get(n-2) % A.get(n-1) ) ;

        for (i =1 ; i < n-1 ; i++){
            ans = ans + ((pA.get(i-1) + sA.get(i+1)) % A.get(i) ) ;
        }

        return ans % mods;
    }



    static public int afterRmvGreatestGCD(ArrayList<Integer> A) {

        //prefix gcd
        int n = A.size();
        ArrayList<Integer> gPrefix = new ArrayList(n);
        gPrefix.add(A.get(0));
        ArrayList<Integer> gSuffix = new ArrayList(n);
        gSuffix.addAll(A);
        // gSuffix.add(n-1,A.get(n-1));

        int i =1;

        while(i<n){

            gPrefix.add( gcd (gPrefix.get(i-1),A.get(i)) );
            i++;

        }

        i = n-2;
        while(i>=0){
            gSuffix.set( i,gcd (gSuffix.get(i+1),A.get(i)));
            i--;
        }


        int gMax = Integer.MIN_VALUE;

        //for 0th element
        gMax = Math.max(gMax,gSuffix.get(1));

        //for n-1 element
        gMax = Math.max(gMax,gPrefix.get(n-2));

        i = 1;
        while ( i < n-1){
            int aftRmvGcd = gcd(gPrefix.get(i-1),gSuffix.get(i+1));

            gMax = Math.max(gMax,aftRmvGcd);
            i++;
        }

        return gMax;
    }

    static int gcd(int a,int b){
        if(b==0) return a;
        else {
            return gcd(b,a%b);
        }
    }


    static public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        int index  = 0;
        ArrayList<Integer> container = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        recSubSets(A,container,ans,index);
        int size = A.size();

        for(ArrayList<Integer> list : ans){
            list.sort((e1, e2) -> {
                return e1.compareTo(e2);
            });
        }


        ans.sort( (ArrayList<Integer> c , ArrayList<Integer> d ) ->
        {
            int comparator = 0;
            for(int i = 0 ; i < size ; i++){

                if(i >= c.size() || i >= d.size()){
                    if(c.size() < d.size()){
                        return  -1;
                    }else {
                        return  1;
                    }
                }
                comparator = c.get(i).compareTo(d.get(i));
                if(comparator != 0){
                    break;
                }
            }
            return  comparator;
        });
        return ans;

    }

    static  void  recSubSets(ArrayList<Integer> sourceList , ArrayList<Integer> container , ArrayList<ArrayList<Integer>> ans , int index){
        if(index == sourceList.size()){
            ans.add((ArrayList<Integer>) container.clone());
            return;
        }
        //first we add the sourceList[index] element
        container.add(sourceList.get(index));
        // int rightIndex = index + 1;
        recSubSets(sourceList,container,ans,index +1);
        //remove the added element
        // container.remove(container.size()-1);
        container.remove(index);
        //then we call th function without the element
        // int leftIndex = index + 1;
        recSubSets(sourceList,container,ans,index + 1);

//         recSubSets(sourceList,container,ans,index + 1);
//         container.add(sourceList.get(index));
//         recSubSets(sourceList,container,ans,index +1);
    }

    public static int[] getMaxSumIndex(int[] A){
        int[] ans = new int[2];

        int csum = A[0];
        int max= A[0];
        int n = A.length;
        int start = 0 ;
        int end = 0;

        for(int i = 1 ; i < n ; i++){
            if(A[i]<A[i-1]){
                csum = 0;
                start = i;
                end = i;
            }else {
                end++;
            }
            csum += A[i];
            if(csum>max){
                max=csum;
               ans[0] = start;
               ans[1] = end;
            }
        }

        return ans;
    }




    public static int minSwap2(ArrayList<Integer> A, int B) {


        //count the elememts less than or equal to B
        int window = 0;
        int n = A.size();
        for(int i = 0 ; i < n ; i++ ){
            if(A.get(i) <= B ){
                window++;
            }
        }

        //getting the intial count of no. greater that B for start window 0 to window -1
        int count = 0;

        int window1 = window -1 ;
        for(int j = 0 ; j < window ; j++){
            if(A.get(j)>B){
                count++;
            }
        }

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans,count);

        //starting the window slide from 1 to window
        int start = 1;
        int end = window;
        while(end < n ){
            if(A.get(start-1)> B){
                count--;
            }
            if(A.get(end)>B){
                count++;
            }
            ans = Math.min(ans,count);
            start++;
            end++;
        }

        return ans ;


    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {


        // [1,3],[2,6],[8,10],[15,18]
        //  ref   curr

        //sort the intervals based on starting point

        intervals = intervals.stream().sorted( (a , b) -> {
            if(a.start < b.start){
                return -1;
            }else if(a.start > b.start){
                return 1 ;
            }else {
                return 0;
            }
        }).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);

        ArrayList<Interval> ans = new ArrayList<>();

        int n = intervals.size();
        Interval refInterval = intervals.get(0);
//     [1,3],[2,6],[8,10],[15,18]
        //  ref   curr
        for (int i = 1 ; i < n ; i++){
            Interval currInterval = intervals.get(i);
            //if overlap
            if(currInterval.start <= refInterval.end ){
                int start = Math.min(currInterval.start, refInterval.start);
                int end = Math.max(currInterval.end, refInterval.end);
                //merging interval
                refInterval = new Interval(start,end);
            }else {
                //if non-overlap
                ans.add(refInterval);
                refInterval = currInterval;
            }
        }
        ans.add(refInterval);
        return ans;

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {



        Collections.reverse(A);
        Integer carry = 1 ;

        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer digit : A){
            int sum = digit + carry;
            int ansDigit = 0;
            carry = sum / 10;
            ansDigit = sum % 10;
            ans.add(ansDigit);

        }
        if(carry > 0){
            ans.add(carry);
        }
        Collections.reverse(ans);

        while(true){
            int firsDigit = ans.get(0);
            if(firsDigit == 0 ){
                ans.remove(0);
            }else {
                break;
            }
        }



        return  ans;

        /*int n = A.length;

        BigInteger[] multiplierArray = new BigInteger[n];
        multiplierArray[n-1] = new BigInteger("1");
        for (int i = n -2 ; i>= 0 ; i--){
            multiplierArray[i] = 10 * multiplierArray[i+1];
        }

        long valueOfA = 0 ;
        for ( int j = 0 ; j < n ; j++){
            valueOfA += A[j] * multiplierArray[j];
        }

        valueOfA++;

        //calculate no of digits;
        int noOfDigits = 0;

        long quotient = valueOfA;
        while (quotient > 0 ){
            quotient  = quotient/10; //10 , 1 , 0 = 100 , 10 , 1
            noOfDigits++; //
        }

        long[] multiplierArrayAns = new long[noOfDigits];
        multiplierArrayAns[noOfDigits-1] = 1;
        for (int k = noOfDigits -2 ; k>= 0 ; k--){
            multiplierArrayAns[k] = 10 * multiplierArrayAns[k+1];
        }
        int[] ansDigits = new int[noOfDigits];
        for(int l = 0 ; l < noOfDigits ; l++ ){
            if(valueOfA == 0 ){
                break;
            }
            long digit = valueOfA /multiplierArrayAns[l];
            valueOfA = valueOfA - (digit*multiplierArrayAns[l]);
            ansDigits[l] = (int) digit;
        }

        return ansDigits;
*/


    }

    public static int colorful(int A) {

        String str = String.valueOf(A);
        char[] digits = str.toCharArray();
        int n = digits.length;

        ArrayList<Long> listOfProducts = new ArrayList<>();
        Set<Long> setOfProducts = new HashSet<>();

        for (int i = 0 ; i<n ; i++){
            long product = digits[i] - 48;
            listOfProducts.add(product);
            setOfProducts.add(product);
            for(int j = i+1 ; j < n ; j++){
                product = product * (digits[j] - 48);
                listOfProducts.add(product);
                setOfProducts.add(product);
            }
        }

        if(setOfProducts.size() < listOfProducts.size()){
            return 0;
        }else {
            return 1;
        }

    }

    public static int consecutive(String A) {

        char[] strArray = A.toCharArray();
        int n = strArray.length;
        int lengthOfConsecutive = 0;
        int noOf1 = 0;

        for(int i = 0 ; i < n ; i++){
            if(strArray[i] == '0'){

                //go left till char you find is 1 and within array boundary
                int leftIndex = i-1;
                int leftLenght = 0;

                while (leftIndex >= 0 && strArray[leftIndex] == 1){
                    leftIndex--;
                    leftLenght++;
                }

                //go right till char is 1 and within array boundary
                int rightIndex = i+1;
                int rightLenght = 0;

                while (rightIndex < n && strArray[rightIndex] == 1){
                    rightIndex++;
                    rightLenght++;
                }
                if(rightLenght > 0 || leftLenght > 0){
                    lengthOfConsecutive = Math.max(lengthOfConsecutive, leftLenght+rightLenght+1);
                }
            }else {
                noOf1++;
            }

        }

        if (noOf1 == n) {
            return n;
        }else {
            return lengthOfConsecutive;
        }
    }


    public static String addBinary(String A, String B) {

        String small = null;
        String big = null;
        if(A.length() < B.length()){
            small = A;
        }else {
            small = B;
        }

        if(A.length() > B.length()){
            big = A;
        }else {
            big = B;
        }

        StringBuilder sb = new StringBuilder();
        int loop = big.length() - small.length();

        for (int i = 0 ; i < loop ; i++){
            sb.append("0");
        }
        sb.append(small);
        small = sb.toString();


        int n = big.length();
        char[] smallArray = small.toCharArray();
        char[] bigArray = big.toCharArray();
        char[] ansArray = new char[n];
        int carry = 0 ;
        for (int i = n-1 ; i>=0; i--){
            int smallint = Character.getNumericValue(smallArray[i]);
            int bigint = Character.getNumericValue(bigArray[i]);

            int ans = smallint + bigint + carry;

            if(ans == 2) {
                ans = 0;
                carry = 1;
            } else if(ans == 3) {
                ans = 1;
                carry = 1;
            } else {
                carry = 0;
            }
            ansArray[i] = String.valueOf(ans).charAt(0);
        }
        String scary = String.valueOf(carry);


        String sans = new String(ansArray);

        if(carry>0){
            sans = scary.concat(sans);
        }

        return sans;
    }

    public static int amazingSubArray(String A) {


        char[] v = {'a','e','i','o','u','A','E','I','O','U'} ;

        int nv = v.length;
        int subCount = 0;
        int mods = 10003;
        int nA = A.length();

        for(int i = 0 ; i < nv ; i++){
            boolean isCharPresent = true;
            int searchFrom = 0;
            while(isCharPresent){
                int index = A.indexOf(v[i],searchFrom);
                if(index>=0){
                    subCount = subCount + (nA - index) % mods;
                    searchFrom = index + 1;
                }else {
                    isCharPresent = false;
                }

            }
        }

        return subCount;
    }

    public static String longestPalindrome(String A) {

        char[] s = A.toCharArray();
        int n = s.length;
        int maxLength = Integer.MIN_VALUE;
        int startMax = 0;
        int endMax = 0;
        for (int i = 0 ; i < n ; i ++){
            //check for odd palindrome
            int left = i;
            int right = i;
            while (left >= 0 && left < n && right>=0 && right < n) {
                if(s[left] != s[right]){
                    break;
                }
                left--;
                right++;
            }
            left++;
            right--;
            int lengthOfOddPalindrome = right - left + 1;
            if(lengthOfOddPalindrome > maxLength){
                maxLength = lengthOfOddPalindrome;
                startMax = left;
                endMax = right;
            }

            left = i;
            right = i+1;
            while (left >= 0 && left < n && right>=0 && right < n) {
                if(s[left] != s[right]){
                    break;
                }
                left--;
                right++;
            }
            left++;
            right--;
            int lengthOfEvenPalindrome = right - left + 1;
            if(lengthOfEvenPalindrome > maxLength){
                maxLength = lengthOfEvenPalindrome;
                startMax = left;
                endMax = right;
            }


        }

        return A.substring(startMax,endMax+1);



    }

    public static String toggle(String A) {

        char[] charArray = A.toCharArray();
        int n = charArray.length;
        for (int i = 0 ; i < n ; i++){
            if(65 <= (int)charArray[i] && (int)charArray[i] <= 90){
                charArray[i] += 32;
            } else {
                charArray[i] -= 32;
            }
        }
        String string = new String(charArray);
        return string;
    }

    public static int nobleNo(ArrayList<Integer> A) {
        Collections.reverse(A);
        int noGreaterThanMe = 0;
        int count = 0 ;
        int n = A.size();

        for (int i = 1 ; i < n ; i++){
            if(A.get(i) != A.get(i-1)){
                noGreaterThanMe = i;
            }
            if(A.get(i) == noGreaterThanMe){
                count++;
            }
        }
        count = count==0 ? -1 : count;
        return count;
    }

    public static int minSwaps(int[] A, int B) {
        int n = A.length;
        int wL = 0;
        for (int i = 0 ; i< n ; i++){
            if(A[i]<=B) {
                wL++;
            }
        }
        int i = 0;
        int j = wL-1;
        int countOfSwaps = Integer.MAX_VALUE;
        int badCounts = 0 ;
        for (int k = 0 ; k < wL-1 ; k++){
            if(A[k] > B){
                badCounts++;
            }
        }

        i++;
        j++;

        countOfSwaps = Math.min(countOfSwaps,badCounts);

        while (j < n) {
            if(A[i-1] > B){
                badCounts--;
            }
            if(A[j] > B){
                badCounts++;
            }
            countOfSwaps = Math.min(countOfSwaps, badCounts);
            i++;
            j++;
        }

        return countOfSwaps;

    }

    static void checkMethodCalls(int i, List<Integer> result) {
        result.add(i);
        if (i == 3) {
            return;
        } else {
            i++;
            checkMethodCalls(i, result);
        }
    }

    public static int[][] solve(int[] A) {
        int n = A.length;
//        double tempa = (double) (n+1)/2 ;
        double tempd1 = (double) n * (n+1)/2  ;
        int d1 = (int) tempd1;
        System.out.println(d1);
        int[][] result = new int[d1][n];
        int resultIndx = 0;
        for ( int i = 0 ; i < n ; i++){
            for( int j = i ; j < n ; j++){
                System.out.println(resultIndx);
                result[resultIndx++] = getSubArray(A, i , j);

            }
        }
        return result;

    }

    public static int[] getSubArray(int[] A, int B, int C) {
        int lenghtOfSub = C - B +1;
        int[] subArray = new int[lenghtOfSub];
        int indexOfSub = 0;
        for(int i = B ; i<=C; i++){
            subArray[indexOfSub++] = A[i];
        }
        return subArray;
    }
}
