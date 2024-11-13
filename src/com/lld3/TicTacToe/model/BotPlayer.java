package com.lld3.TicTacToe.model;

import com.lld3.TicTacToe.enums.DifficultyLevel;
import com.lld3.TicTacToe.enums.PlayerType;
import com.lld3.TicTacToe.strategies.EasyStrategy;
import com.lld3.TicTacToe.strategies.PlayingStrategy;

public class BotPlayer extends Player {

    DifficultyLevel difficultyLevel;
    PlayingStrategy playingStrategy;

    public  BotPlayer(int id , String name, Character sign , PlayerType playerType,DifficultyLevel level){
        super(id,name,sign,playerType);
        this.difficultyLevel = level;
        this.playingStrategy = getPlayingStrategy(level);
    }

    static  PlayingStrategy getPlayingStrategy(DifficultyLevel level){

        if(level.equals(DifficultyLevel.EASY)){
            return new EasyStrategy();
        }
        return null;

    }
    @Override
    public  Move makeMove(Board board) {
        return playingStrategy.makeMove(board);
    }
}
