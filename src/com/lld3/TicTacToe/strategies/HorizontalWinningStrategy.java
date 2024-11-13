package com.lld3.TicTacToe.strategies;

import com.lld3.TicTacToe.enums.GameStatus;
import com.lld3.TicTacToe.model.Board;
import com.lld3.TicTacToe.model.Move;

import java.util.HashMap;
import java.util.Map;

public class HorizontalWinningStrategy implements WinningStragies {

    Map<Integer, Map<Character,Integer>> mapOfColumnToCharacterCount = new HashMap<>();

    @Override
    public GameStatus getGameStatus(Board board, Move move) {

        int row = move.getCell().getRow();

        //adding empty map if no Map character is there
        mapOfColumnToCharacterCount.putIfAbsent(row,new HashMap<>());

        Map<Character,Integer> characterIntegerMap =  mapOfColumnToCharacterCount.get(row);

        //adding zero move if no move is done
        characterIntegerMap.putIfAbsent(move.getPlayer().getSign(),0);

        int count = characterIntegerMap.get(move.getPlayer().getSign());
        count++;
        characterIntegerMap.put(move.getPlayer().getSign(),count);


        if(count == board.getSize()){
            return GameStatus.WON;
        }

        return GameStatus.INPROGRESS;
    }
}