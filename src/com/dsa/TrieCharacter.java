package com.dsa;


import java.util.*;

public class TrieCharacter {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        ////Approach
        //we will insert words into tries based on thier weightages -> highest firs

        //for every node will maintain a hashmap and list -> to maintain the insertion order

        //we will also maintain a list of words for ever node. where it was traversed will inserting the word.

        //We will create method for trie. where if we pass a trie node. we get all the child string posssible

        Scanner s = new Scanner(System.in);

        int numCases = s.nextInt();

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        while( numCases > 0 ) {

            int i = 0 ;

            int numStr = s.nextInt();
            int numprefix = s.nextInt();
            ArrayList<Pair> listOfPair = new ArrayList<>();

            for( i  = 0 ; i < numStr; i++ ) {
                Pair p = new Pair(s.next());

                listOfPair.add(p );
            }
            for(  i = 0; i < numStr; i++ ) {
                Pair n = listOfPair.get(i);
                n.weight = s.nextInt();
            }

            String pref [] = new String[numprefix];
            for(  i = 0; i < numprefix; i++ ) {
                pref[i] = (s.next());
            }

            //sortin pairs based on weight in descenging order
            Collections.sort(listOfPair , (p1, p2) -> {
                return p2.weight - p1.weight;
            });

            //Create root node of trie
            Trie root = new Trie();

            //inserting words based

            for( i = 0 ; i < numStr ; i++ ){
                root.Insert(listOfPair.get(i).s);
            }

            List<List<String>> listOfWordsForEachPrefix = new ArrayList<>();

            for( i = 0 ; i < numprefix ; i++){
                listOfWordsForEachPrefix.add( root.getWords(pref[i]) );
            }

            int j = 0 ;
            int rows = listOfWordsForEachPrefix.size();

            for( i = 0 ; i < rows ; i++ ){
                int columns = listOfWordsForEachPrefix.get(i).size();
                List<String> words = listOfWordsForEachPrefix.get(i);

                if(columns == 0 ){
                    System.out.println("-1 ");

                } else {

                    for(j = 0 ; j < columns ; j++){
                        System.out.print(words.get(j));
                        System.out.print(" ");
                        // if(! (j == (columns-1))){
                        //     System.out.print(" ");
                        // }

                    }

                    System.out.println();

                }

            }

            numCases--;



        }




    }

    static class Trie {

        HashMap<Character,Trie> mapOfChild;
        List<String> listOfWords;
        boolean isEnd;

        Trie(){
            mapOfChild  = new HashMap<>();
            listOfWords = new ArrayList<>();
            isEnd = false;
        }

        void Insert(String word){

            char[] chAr = word.toCharArray();
            int n = chAr.length;

            Trie temp = this;

            for(int i = 0 ; i < n ; i++){
                if(!temp.mapOfChild.containsKey(chAr[i])) {

                    Trie childNode = new Trie();

                    temp.mapOfChild.put(chAr[i] , childNode );

                }

                if(temp.listOfWords.size() < 5){
                    temp.listOfWords.add(word);
                }
                temp = temp.mapOfChild.get(chAr[i]);

            }

            temp.listOfWords.add(word);

            temp.isEnd = true;
        }



        List<String> getWords(String prefix) {

            char[] chArr = prefix.toCharArray();

            int n = chArr.length;

            Trie temp = this;

            for(int i =0 ; i<n ;i++){

                if(temp.mapOfChild.containsKey(chArr[i])){
                    temp = temp.mapOfChild.get(chArr[i]);
                }else {

                    return new ArrayList<>();

                }
            }

            return temp.listOfWords;

        }
    }


    static class Pair {

        String s ;
        int weight;

        Pair(String s){
            this.s = s;
            this.weight = 0;
        }
    }
}
