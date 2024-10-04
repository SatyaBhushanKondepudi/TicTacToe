package com.SatyaBhushan.models;

import com.SatyaBhushan.models.enums.GameState;
import com.SatyaBhushan.stratergies.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board ;
    private List<Player> playersList ;
    private List<Move> movesList ;
    private GameState gameState ;
    private Player winner ;
    private int currentPlayerIndex ;
    private List<WinningStratergy> winningStratergyList;

    //Constructor
    public Game(int dimensions ,
                List<Player> playersList ,
                List<WinningStratergy> winningStratergyList){
        this.board = new Board(dimensions);
        this.playersList = playersList;
        this.movesList = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS ;
        this.currentPlayerIndex = 0 ;
        this.winner = null ;
        this.winningStratergyList = winningStratergyList ;
    }

    //Getters & Setters
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public List<Move> getMovesList() {
        return movesList;
    }

    public void setMovesList(List<Move> movesList) {
        this.movesList = movesList;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public List<WinningStratergy> getWinningStratergyList() {
        return winningStratergyList;
    }

    public void setWinningStratergyList(List<WinningStratergy> winningStratergyList) {
        this.winningStratergyList = winningStratergyList;
    }
}
