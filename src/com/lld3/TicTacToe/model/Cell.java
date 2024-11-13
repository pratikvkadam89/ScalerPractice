package com.lld3.TicTacToe.model;

import com.lld3.TicTacToe.enums.CellStatus;

public class Cell {

    int row;
    int colm;
    CellStatus cellStatus;
    Player player;


    public Cell(int row, int colm){
        this.row = row;
        this.colm = colm;
        this.cellStatus = CellStatus.EMPTY;
        player = null;
    }

    public int getRow() {
        return row;
    }

    public int getColm() {
        return colm;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public Player getPlayer() {
        return player;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColm(int colm) {
        this.colm = colm;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
