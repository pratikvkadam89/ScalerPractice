package com.dsa;

public class MyLinkedList {


    public static class Node{
        int val;
        Node next;

        public Node(int a){
            val = a;
            next = null;
        }
    }

    public static Node head = null;
    public static int length = 0;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer

        Node newNode = new Node(value);

        if(position ==1){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        //if pos is 3 , go till second Node
        int jump = 1;
        while (jump<(position-1)){
            temp = temp.next;
            jump++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return;
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position==1){
            head = head.next;
            return;
        }

        //travel to node less the position
        Node temp = head;
        int jump = 1;
        while(jump<(position-1)){
            temp = temp.next;
            jump++;
        }

        Node nodeToJoin = temp.next.next;
        temp.next = nodeToJoin;
        return;

    }

    public static void print_ll() {
        // Output each element followed by a space

        Node temp = head;
        while(temp!=null){
            if(temp.next!=null){
                System.out.print(temp.val);
                System.out.print(" ");
            }else {
                System.out.print(temp.val);
            }
            temp = temp.next;
        }
        return ;
    }

}
