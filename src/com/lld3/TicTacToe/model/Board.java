package com.lld3.TicTacToe.model;

import com.lld3.TicTacToe.enums.CellStatus;

import java.util.ArrayList;
import java.util.List;


public class Board {

    int size;
    List<List<Cell>> grid;


    public Board(int size){
        this.size = size;

        grid = new ArrayList<>();
        for(int i = 0 ; i < size ; i++){

            List<Cell> row = new ArrayList<>();

            for(int j = 0 ; j < size ; j++){
                row.add(new Cell(i,j) );
            }
            grid.add(row);

        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public void display(){

        for(int i =0 ;i < size ; i++){
            List<Cell> row = grid.get(i);
            for(int j = 0 ; j<size;j++){
               Cell cell = row.get(j);
               if(cell.cellStatus.equals(CellStatus.EMPTY)){
                   System.out.print("|_|");
               }else {
                   System.out.print("|"+cell.getPlayer().getSign()+"|");
               }
            }
            System.out.println();
        }
    }



}
