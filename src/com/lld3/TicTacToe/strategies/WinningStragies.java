package com.lld3.TicTacToe.strategies;

import com.lld3.TicTacToe.enums.GameStatus;
import com.lld3.TicTacToe.model.Board;
import com.lld3.TicTacToe.model.Move;

public interface WinningStragies {

    GameStatus getGameStatus(Board board , Move move);
}
