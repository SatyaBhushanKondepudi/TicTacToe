package com.SatyaBhushan.models;

import com.SatyaBhushan.models.enums.PlayerType;

import java.util.Scanner;

public class Player {

    private Symbol symbol ;
    private String name ;
//    private Long playerId ;
    private PlayerType playerType ;
    private Scanner scanner ;

    //Constructor


    public Player(Symbol symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Long getPlayerId() {
//        return playerId;
//    }
//
//    public void setPlayerId(Long playerId) {
//        this.playerId = playerId;
//    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Cell makeMove(){
        System.out.println("Please tell row number (starting from 0)");
        int row = scanner.nextInt();

        System.out.println("Please tell col number (starting from 0)");
        int col = scanner.nextInt();

        return new Cell(row, col);
    }
}
