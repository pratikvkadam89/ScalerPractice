package com.lld3.TicTacToe.strategies;

import com.lld3.TicTacToe.model.Board;
import com.lld3.TicTacToe.model.Move;

public interface PlayingStrategy {

    Move makeMove(Board board);
}
