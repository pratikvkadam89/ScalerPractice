package com.lld3.TicTacToe.model;

import com.lld3.TicTacToe.enums.PlayerType;

import java.util.Scanner;

public class HumanPlayer extends Player {

    Scanner sc = new Scanner(System.in);


    public  HumanPlayer(int id , String name, Character sign , PlayerType playerType){
        super(id,name,sign,playerType);
    }

    @Override
    Move makeMove(Board board) {

        System.out.println( this.name +  ": Enter row....");
        int r = sc.nextInt();

        System.out.println(this.name + ": Enter column...");
        int c = sc.nextInt();

        return new Move(new Cell(r,c),this);

    }
}
