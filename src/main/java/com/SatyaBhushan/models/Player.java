package com.SatyaBhushan.models;

import com.SatyaBhushan.models.enums.PlayerType;

public class Player {

    private Symbol symbol ;
    private String name ;
//    private Long playerId ;
    private PlayerType playerType ;

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
}
