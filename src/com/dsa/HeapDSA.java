package com.dsa;

import java.util.Stack;

public class HeapDSA {

    public int checkTwoBracketExpression(String A, String B) {

        int[] letterSignMapA = getSignMap(A);
        int[] letterSignMapB = getSignMap(B);


        for(int i = 0 ; i < 25 ; i++){
            if(letterSignMapA[i] != letterSignMapB[i] ){
                return 0;
            }
        }

        return 1;

    }

    int[] getSignMap(String A){

        Stack<Character> operator = new Stack<>();
        Stack<Character> oprAndBracket = new Stack<>();
        Stack<Character> letters = new Stack<>();
        int[] lettersSign = new int[26];
        int i = 0 ;
        char[] charA = A.toCharArray();
        boolean isBracketOpen = false;
        for(Character charOfA : charA){
            if(charOfA >= 'a'  && charOfA <= 'z' && i==0 ){
                operator.push('+');
                letters.push(charOfA);
            } else if(charOfA >= 'a'  && charOfA <= 'z'){
                letters.push(charOfA);
            }

            if(charOfA == '+' || charOfA == '-'){
                if(isBracketOpen){
                    oprAndBracket.push(charOfA);
                }else {
                    operator.push(charOfA);
                }
            }

            if(charOfA == '('){
                oprAndBracket.push(charOfA);
                isBracketOpen = true;
            }

            if(charOfA == ')'){

                while(!oprAndBracket.isEmpty()){

                    char elementsInBracket =  oprAndBracket.pop();

                    if(elementsInBracket == '+' || elementsInBracket == '-'){

                        char operatorOutsideBracket = operator.isEmpty() ? '+' : operator.peek();
                        if(operatorOutsideBracket == '-'){
                            if(elementsInBracket == '-') elementsInBracket = '+';
                            if(elementsInBracket == '+') elementsInBracket = '-';

                        }

                        char charAtTop = letters.pop();
                        lettersSign[charAtTop - 'a'] = elementsInBracket == '+' ? 1 : -1;

                    } else {
                        isBracketOpen = false;
                        break;
                    }

                }
            }

            i++;
        }

        while(!operator.isEmpty() && !letters.isEmpty()){
            char opr =  operator.pop();
            char lettr = letters.pop();

            lettersSign[lettr - 'a'] = opr == '+' ? 1 : -1;
        }

        return lettersSign;

    }






    public int braces(String A) {

        Stack<Character> bracketStacks = new Stack<>();

        char[] charrArry = A.toCharArray();

        for(int i = 0 ; i < charrArry.length ; i++){
            char charAtI = charrArry[i];

            if(charAtI == ')'){
                int countOfElements = 0;

                while(!bracketStacks.isEmpty()){
                    char topChar = bracketStacks.pop();
                    if(topChar == '(') {
                        bracketStacks.push('a');
                        break;
                    }else {
                        countOfElements++;
                    }
                }

                if(countOfElements == 3){
                    continue ;
                }else if(countOfElements != 3) {
                    return 1;
                }
            } else {
                bracketStacks.push(charAtI);
                continue;
            }
        }

        if(bracketStacks.isEmpty() || bracketStacks.size() == 3){
            return 0;
        }else {
            return 1;
        }


    }
}
