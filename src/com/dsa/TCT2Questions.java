package com.dsa;

import java.util.*;

public class TCT2Questions {

    //Damaged Roads Questionex
    // ******* minimum spanning tree question variant, solved it using kruskal algorithm
    int damagedRoad(List<Integer> A , List<Integer> B){

        ///Here the city is represente as (x,y) co-ordinates
        //Therefor this question becomes complicated to represent the city

        int n = A.size();
        int cityId = 0 ;

        //here each city is give Id
        int[][] cityMap = new int[n+1][n+1];
        for(int i  = 0 ; i <= n ; i++){
            for(int j = 0 ; j<= n ; j++){
                cityMap[j][i] = ++cityId;
            }
        }

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1,e2) -> e1.cost - e2.cost);

        //here edges are created as per the given arrays
        //and added to the min heap
        for(int i  = 0 ; i <= n ; i++){
            for(int j = 0 ; j<= n ; j++){

              int sourceCity =  cityMap[j][i];


              int dest1 = j+1 <= n ? cityMap[j+1][i] : 0;
              int dest2 = i+1 <= n ? cityMap[j][i+1] : 0;

              Edge e1 = dest1 >= 1 ? new Edge(sourceCity, dest1,A.get(j) ) : null;
              Edge e2 = dest2 >= 1 ? new Edge(sourceCity, dest2,B.get(i) ) : null;
              if(e1 != null)  minHeap.add(e1);
              if(e2 != null)  minHeap.add(e2);
            }
        }

        //disjoint set is created.
        DisjointSet djs = new DisjointSet((n+1)*(n+1) );
        int ans = 0;

        while(!minHeap.isEmpty()){
            Edge top = minHeap.poll();


            if(djs.join(top.sourceCityId,top.destCityId)){
                ans += top.cost;
            }else {
                //this is the case where 2 cities are already connected via some road
                // i.e they are already belonging to same set.
            }
        }

        return ans;

    }


    class DisjointSet {
        int[] parent ;

        DisjointSet(int n ){
            this.parent = new int[n+1];
            for(int i = 1; i <= n ; i++){
                this.parent[i] = i;
            }
        }

        boolean join(int source , int dest){

            int root1 = getRoot(source);
            int root2 = getRoot(dest);

            if(root1 < root2){
                this.parent[root2] = root1;
                return true;
            }else if (root2 < root1){
                this.parent[root1] = root2;
                return true;
            }else {
                return false;
            }
        }


        int getRoot(int node){

            if(this.parent[node] == node){
                return node;
            }

            this.parent[node] = getRoot(this.parent[node]);
            return this.parent[node];
        }
    }

    class Edge {
        int sourceCityId;
        int destCityId;
        int cost;

        Edge(int cost){
            this.cost = cost;
        }

        Edge(int a , int b , int c){
            this.sourceCityId = a;
            this.destCityId = b;
            this.cost = c;
        }
    }

    class City {
        int i ;
        int j ;

        City(int i , int j){
            this.i = i;
            this.j = j;
        }


    }






    /*
    * Given N jobs where every job is represented by following three elements of it.
    * Start Time , Finish Time ,Profit Associated
    * Find and return the maximum profit subset of jobs such that no two jobs in the subset overlap.
    *
    *
    * Input 1:
    * A = [ [1, 2, 50],
            [3, 5, 20],
            [6, 19, 100],
            [2, 100, 200] ]

      Output 1:
        250
    * */

    public int solve(int[][] A) {
        Job[] jobs = new Job[A.length];
        for(int i = 0 ; i < A.length; i++){
            jobs[i] = new Job(A[i][0] , A[i][1] , A[i][2] ) ;
        }
        Arrays.sort(jobs , (j1 , j2 ) -> {

            if(j1.end == j2.end){
                return j1.start - j2.start;
            }else {
                return j1.end - j2.end;
            }
        } ) ;
        int n = jobs.length;
        Integer[] dp = new Integer[n+1];
        //dp[i] = max Profit that can be made till the ith job.
        return maxProfit(n,jobs,dp);
    }


    int maxProfit( int jobNum , Job[] jobs , Integer[] dp ){

        if(jobNum ==0){
            return 0;
        }
        if(dp[jobNum] != null){
            return dp[jobNum];
        }
        //we are starting here from the last job
        Job currJob = jobs[jobNum-1];
        int j = 0 ;
        //here j is the first job we can pick
        //j is valid job , if j.end <= currJob.start; and closes to the currJob
        //since our job array is already sorted, we will use binary search
        int min = 1 ;
        int max = jobNum-1 ;
        while(min <= max){
            int mid = min + ((max - min)/2 );
            Job midsJob = jobs[mid-1];
            if(midsJob.end <= currJob.start){
                j = mid;
                //we will be finding the closest j, hence moving mid toward max
                min = mid +1;
            }else {
                max = mid -1 ;
            }
        }

        //case 1 : we take the job.
        int p1 = currJob.profit + maxProfit(j, jobs , dp);

        //case 2 : we don't take the job and check the next job.
        int p2 = maxProfit(jobNum-1, jobs , dp);

        dp[jobNum] = Math.max(p1,p2);
        return dp[jobNum];
    }

    class Job{

        int start;
        int end;
        int profit;

        Job(int start , int end , int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }




    /*
    * Question 1 : Given a singly linked list A and an integer B,
    * reverse the nodes of the list B at a time and return the modified linked list.
    * Input 1:

        A = [1, 2, 3, 4, 5, 6]
        B = 2
      Output:

        [2, 1, 4, 3, 6, 5]
    * */

    public ListNode reverseList(ListNode A, int B) {

        //get length of Listnode
        int n = 0 ;
        ListNode temp = A;
        while ( temp != null){
            temp = temp.next;
            n++;
        }
        n++;

        //Break the linked list in B small parts
        List<ListNode> listOfListNode = new ArrayList<>();

        int i = 1 ;
        ListNode head = A;
        ListNode tail = A;
        //here breaking the list in B small parts
        while (head !=null ){

            int j = 1 ;
            while(tail != null && j <= B-1){
                tail = tail.next;
                j++;
            }

            ListNode nextHead = tail != null ? tail.next : null;
            if(tail != null){
                tail.next = null;
            }

            listOfListNode.add(head);
            head = nextHead;
            tail = nextHead;
        }

        List<ListNode> listOfListNode2 = new ArrayList<>();
        //here the listNode is reversed
        for( ListNode n1 : listOfListNode){

            ListNode reverseTail = null ;
            ListNode itrHead = n1;

            while(itrHead != null){
                ListNode currNext = itrHead.next;

                itrHead.next = reverseTail;
                reverseTail = itrHead;
                itrHead = currNext;
            }

            //adding the reversed head to the new list
            listOfListNode2.add(reverseTail);
            //n1 = reverseTail;
        }

        ListNode ansHead = listOfListNode2.get(0);
        ListNode ansTail = listOfListNode2.get(0);

        while(ansTail.next != null){
            ansTail = ansTail.next;
        }

        //binding all the heads.
        for(i = 1 ; i < listOfListNode2.size() ; i++){
            ListNode ithHead = listOfListNode2.get(i);
            ansTail.next = ithHead;
            ansTail = ansTail.next ;
            while(ansTail.next != null){
                ansTail = ansTail.next;
            }

        }

        return ansHead;


    }

    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
}
