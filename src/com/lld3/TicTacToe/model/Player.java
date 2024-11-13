package com.lld3.TicTacToe.model;

import com.lld3.TicTacToe.enums.PlayerType;

public abstract class Player {

    int id;
    String name;
    Character sign;
    PlayerType playerType;

    public  Player(int id , String name, Character sign , PlayerType playerType){
        this.id = id;
        this.name = name;
        this.sign = sign;
        this.playerType = playerType;
    }

    abstract Move makeMove(Board board);

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getSign() {
        return sign;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}
