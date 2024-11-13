package com.lld3.TicTacToe;

import com.lld3.TicTacToe.Controller.GameController;
import com.lld3.TicTacToe.enums.GameStatus;
import com.lld3.TicTacToe.enums.PlayerType;
import com.lld3.TicTacToe.model.Game;
import com.lld3.TicTacToe.model.HumanPlayer;
import com.lld3.TicTacToe.model.Player;
import com.lld3.TicTacToe.strategies.HorizontalWinningStrategy;
import com.lld3.TicTacToe.strategies.VerticalStartegy;
import com.lld3.TicTacToe.strategies.WinningStragies;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {


        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1,"sohail",'X', PlayerType.HUMAN));
        players.add(new HumanPlayer(2,"brijesh",'Y', PlayerType.HUMAN));

        List<WinningStragies> winningStragies = new ArrayList<>();
        winningStragies.add(new VerticalStartegy());
        winningStragies.add(new HorizontalWinningStrategy());
        Game game = gameController.startGame(3,players,winningStragies);

        while (game.getGameStatus().equals(GameStatus.INPROGRESS)){
            gameController.display(game);
            gameController.makeMove(game);
            GameStatus gameStatus = gameController.getGameStatus(game);

            //TODO undo feature

            if(gameStatus.equals(GameStatus.WON)){
                String name = gameController.getWinner(game).getName();
                System.out.println(name + " won the game");
                gameController.display(game);
                break;
            }else if (gameStatus.equals(GameStatus.DRAW)){
                System.out.println("game is draw");
                break;
            }

        }


    }
}
