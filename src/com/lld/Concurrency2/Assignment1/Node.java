package com.lld.Concurrency2.Assignment1;

public class Node {
    public Node left;
    public Node right;
    public int data;

    public Node(Node left,Node right,int data){
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node(int data){
        this.data = data;
        this.left = this.right = null;
    }

    int getLengthSize(){
        if(this == null) {
            return 0;
        }
       int leftSize =  left.getLengthSize();
       int rightSize =  right.getLengthSize();
       return leftSize + rightSize + 1;
    }

    public Node(){

    }
}
