package com.dsa;

import java.util.*;

public class TrieBits {

    public int[] solve(int[] A) {

        int n = A.length;

        //create prefix xor array

        int[] prefixor = new int[n];
        int i = 0;
        prefixor[0] = A[0];
        for (i = 1; i < n; i++) {
            prefixor[i] = prefixor[i - 1] ^ A[i];
        }

        /*
            Max subarray xor  can be from following values
            case 1 : prefixor[0 -> j ] = prefix[j]
                                or
            case 2 : prefixor[i -> j ] = prefix[j] ^ prefix[i - 1], where   i > 0
        */
        int ans = 0;

        for(i = 0 ; i <n ; i++){
            ans = Math.max(ans,A[i]);
        }

        //Insert all the prefixor num in TrieBit
        TrieBit root = new TrieBit();


        //Case 1 -> can be checked by finding max in prefixor array
        for (i = 0; i < n; i++) {

            if (prefixor[i] > ans) {
                ans = prefixor[i];
            }
        }

        //case 1 ans is saved in the ans

        //case 2


        // insert(root, prefixor[0]);

        //inserting all the prefixor
        //find max for case 2
        for (i = 1; i < n; i++) {
            //insert prefix i-1 in the TrieBit
            insert(root, prefixor[i - 1]);
            int maxor = getMax(root, prefixor[i]);
            if (maxor > ans) {
                ans = maxor;
            }
        }

        HashMap<Integer, Integer> mapOfXorToIndx = new HashMap<>();

        int lenthOfSubArr = Integer.MAX_VALUE;
        int[] ansArr = new int[2];
//        ans = 25;

        for (i = 0; i < n; i++) {

            int valueOtherXor = ans ^ prefixor[i];

            if (valueOtherXor == 0) {

                if (mapOfXorToIndx.containsKey(valueOtherXor)) {
                    int L = mapOfXorToIndx.get(valueOtherXor);
                    L = L+1;
                    int R = i;

                    int length = R - L + 1;

                    if (length < lenthOfSubArr) {
                        lenthOfSubArr = length;
                        ansArr[0] = L;
                        ansArr[1] = R;
                    } else if (length == lenthOfSubArr) {
                        if (ansArr[0] < L) {
                            ansArr[0] = L;
                            ansArr[1] = R;
                        }
                    }


                } else {
                    int L = 0;
                    int R = i;

                    int length = R - L + 1;

                    if (length < lenthOfSubArr) {
                        lenthOfSubArr = length;
                        ansArr[0] = L;
                        ansArr[1] = R;
                    } else if (length == lenthOfSubArr) {
                        if (ansArr[0] < L) {
                            ansArr[0] = L;
                            ansArr[1] = R;
                        }
                    }
                }


            } else if (mapOfXorToIndx.containsKey(valueOtherXor)) {
                int L = mapOfXorToIndx.get(valueOtherXor);
                L = L + 1;
                int R = i;

                int length = R - L + 1;

                if (length < lenthOfSubArr) {
                    lenthOfSubArr = length;
                    ansArr[0] = L;
                    ansArr[1] = R;
                } else if (length == lenthOfSubArr) {
                    if (ansArr[0] < L) {
                        ansArr[0] = L;
                        ansArr[1] = R;
                    }
                }


            }

            mapOfXorToIndx.put(prefixor[i], i);
        }

        ansArr[0]++;
        ansArr[1]++;

        return ansArr;


    }

    int getMax(TrieBit root, int num) {

        TrieBit temp = root;

        int ans = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = num >> i & 1;
            int bitCompliment = 0;

            if (bit == 0) {
                bitCompliment = 1;
            }

            if (temp.child[bitCompliment] != null) {

                ans = ans | (1 << i);

                temp = temp.child[bitCompliment];
            } else {
                temp = temp.child[bit];
            }
        }

        return ans;
    }


    void insert(TrieBit root, int num) {

        TrieBit temp = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (temp.child[bit] == null) {
                temp.child[bit] = new TrieBit();
            }
            temp = temp.child[bit];
        }
    }


    class TrieBit {

        TrieBit[] child;

        TrieBit() {
            child = new TrieBit[2];
        }
    }
}
