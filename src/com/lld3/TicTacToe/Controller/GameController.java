package com.lld3.TicTacToe.Controller;

import com.lld3.TicTacToe.enums.GameStatus;
import com.lld3.TicTacToe.model.Game;
import com.lld3.TicTacToe.model.Player;
import com.lld3.TicTacToe.strategies.WinningStragies;

import java.util.List;

public class GameController {


    public Game startGame(int size, List<Player> players, List<WinningStragies> winningStragies ){
        return Game.getBuilder().setSize(size).setPlayers(players).setWinningStragies(winningStragies).build();
    }

    public void makeMove(Game game){
         game.makeMove();
    }

    public void display(Game game){

        game.display();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public Player getWinner(Game game){
        return game.getWinningPlayer();
    }
}
