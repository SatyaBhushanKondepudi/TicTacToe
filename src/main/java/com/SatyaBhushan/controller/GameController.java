package com.SatyaBhushan.controller;

import com.SatyaBhushan.models.Game;
import com.SatyaBhushan.models.Player;
import com.SatyaBhushan.models.enums.GameStatus;
import com.SatyaBhushan.stratergies.winningStratergies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int dimensions ,
                           List<Player> players ,
                           List<WinningStrategy> winningStrategyList){
        return Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayersList(players)
                .setWinningStrategyList(winningStrategyList)
                .build();
    }



    public void displayBoard(Game game){
        game.PrintBoard();
    }

    public void undo(Game game){

    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }


    public void printResult(Game game){
        game.printResult();
    }
}
