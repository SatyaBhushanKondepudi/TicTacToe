package com.SatyaBhushan.models;

import com.SatyaBhushan.models.enums.CellState;

public class Cell {
    private int row  ;
    private int column ;
    private CellState cellState ;
    private Player player ;

    //Constructor
    public Cell(int row , int column){
        this.row = row ;
        this.column = column ;
        this.cellState = CellState.EMPTY ;

    }

    //Getters & Setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    //print symbol
    public void printSymbol(){
        if(getCellState().equals(CellState.EMPTY)){
            System.out.print(" - |");
        }else{
            System.out.print(" " + getPlayer().getSymbol().getAchar() + " |");
        }
    }
}
