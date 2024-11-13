package com.lld3.TicTacToe.model;

import com.lld3.TicTacToe.enums.CellStatus;
import com.lld3.TicTacToe.enums.GameStatus;
import com.lld3.TicTacToe.strategies.WinningStragies;
import sun.awt.WindowIDProvider;

import java.util.ArrayList;
import java.util.List;

public class Game {

    Board board;
    List<Player> players;
    int currentPlayerIndx;
    GameStatus gameStatus;
    List<WinningStragies> winningStragies;
    List<Move> moves;
    Player winningPlayer;

    private WinningStragies winningStrategy;

    public WinningStragies getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStragies winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    private Game(int size, List<Player> players , List<WinningStragies> winningStragies){
        board = new Board(size);
        this.players = players;
        this.gameStatus = GameStatus.INPROGRESS;
        this.moves = new ArrayList<>();
        this.winningStragies = winningStragies;
        this.currentPlayerIndx = 0;
    }

    public void display(){
        board.display();
    }

    public void makeMove(){
        //get the current player;

        Player player = players.get(currentPlayerIndx);

        //player will make the move
        //validate the move
        Move move ;
        do{
            move = player.makeMove(board);
        }while( !validateMove(move) );


        //update the board

        Cell boardCell = board.getGrid().get(move.getCell().getRow()).get(move.getCell().getColm());
        boardCell.setCellStatus(CellStatus.FILLED);
        boardCell.setPlayer(move.getPlayer());
        //update the current player
        currentPlayerIndx = (currentPlayerIndx + 1) % players.size();

        //add to move
        moves.add(move);

        //check status of board after move
        this.gameStatus = checkGameStatus(move);

        if(gameStatus.equals(GameStatus.WON)){
            this.winningPlayer = player;
        }
    }

    private boolean validateMove(Move move){

        int row = move.getCell().getRow();
        int colm = move.getCell().getColm();

        //check if row and colmn is valid
        if( row < 0 || row >= board.size  || colm < 0 || colm >= board.size){
            System.out.println("Entered row or column is invalid");
            return false;
        }
        //check if cell is blank
        if( ! board.getGrid().get(row).get(colm).getCellStatus().equals(CellStatus.EMPTY)){
            System.out.println("cell is invalid");
            return false;
        }

        return true;

    }

    public GameStatus checkGameStatus(Move move){

        if(moves.size() == (board.size * board.size)){
            return GameStatus.DRAW;
        }

        for(WinningStragies winningStrategy : winningStragies){
            GameStatus gameStatus = winningStrategy.getGameStatus(board,move);
            if(gameStatus.equals(GameStatus.WON)){
                return gameStatus;
            }
        }
        return GameStatus.INPROGRESS;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayerIndx() {
        return currentPlayerIndx;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<WinningStragies> getWinningStragies() {
        return winningStragies;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public  static  Builder getBuilder(){
        return new Builder();
    }

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public static  class Builder {

        int size;
        List<Player> players;
        List<WinningStragies> winningStragies;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return  this;
        }

        public Builder setWinningStragies(List<WinningStragies> winningStragies) {
            this.winningStragies = winningStragies;
            return this;

        }

        public Game build(){
            return  new Game(size,players,winningStragies);
        }
    }


}
