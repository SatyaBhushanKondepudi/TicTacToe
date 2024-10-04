package com.SatyaBhushan.models;

import com.SatyaBhushan.models.enums.CellState;
import com.SatyaBhushan.models.enums.GameStatus;
import com.SatyaBhushan.models.enums.PlayerType;
import com.SatyaBhushan.stratergies.winningStratergies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private Board board ;
    private List<Player> playersList ;
    private List<Move> movesList ;
    private GameStatus gameStatus ;
    private Player winner ;
    private int currentPlayerIndex ;
    private List<WinningStrategy> winningStrategyList;


    //Constructor
    private Game(int dimensions ,
                List<Player> playersList ,
                List<WinningStrategy> winningStrategyList){
        this.board = new Board(dimensions);
        this.playersList = playersList;
        this.movesList = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS ;
        this.currentPlayerIndex = 0 ;
        this.winner = null ;
        this.winningStrategyList = winningStrategyList ;
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

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameState(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
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

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
    }


    //Methods
    public void PrintBoard(){
        this.board.print();
    }

    public void printResult(){
        if(gameStatus.equals(GameStatus.ENDED)){
            System.out.println("Game has ended");
            System.out.println("Winner is " + winner.getName());
        } else{
            System.out.println("Game is draw");
        }
    }
    public void makeMove(){
        /*
        Find who is the currentPlayer
        Need to get row , Column values & Validate the cell
        Validations :
        1. Row & Column values should be within Board dimensions
        2. CellState should be Empty

        If valid ,
        1. Fill that CellState as Filled & Fill the details of the player filling the cell
        2. Also add this move to the List<Move> movesList

        -> checkWinnerifAny
        -> checkDraw

        change the currentMovePlayerIndex += 1 ; currentMovePlayerIndex%=playersList.size()
         */

        Player currentPlayer = playersList.get(currentPlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn.");
        Cell proposedCell = currentPlayer.makeMove();
        System.out.println("Move made at row: " + proposedCell.getRow() +
                " col: " + proposedCell.getColumn() + ".");
        if(!validateMove(proposedCell)){
            System.out.println("Invalid move. Retry.");
            return;
        }
        Cell cellInBoard = board.getBoard()
                .get(proposedCell.getRow())
                .get(proposedCell.getColumn());
        cellInBoard.setCellState(CellState.FILLED);
        cellInBoard.setPlayer(currentPlayer);

        Move move = new Move(currentPlayer , cellInBoard);
        movesList.add(move);

        if (checkGameWinner(move, currentPlayer)) return;

        if (checkDraw()) return;

        currentPlayerIndex+=1;
        currentPlayerIndex %= playersList.size();
    }

    private boolean checkDraw() {
        if(movesList.size() == board.getSize()* board.getSize()){
            gameStatus = GameStatus.DRAW;
            return true;
        }
        return false;
    }

    private boolean checkGameWinner(Move move, Player currentPlayer) {
        for(WinningStrategy winningStrategy : winningStrategyList){
            if(winningStrategy.checkWinner(board , move)){
                gameStatus = GameStatus.ENDED ;
                winner = currentPlayer;
                return true;
            }
        }
        return false;
    }

    private boolean validateMove(Cell cell){
        int row = cell.getRow();
        int col = cell.getColumn();

        if( row < 0 || col<0 || row >= board.getSize() || col >= board.getSize()){
            return false;
        }
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public static Builder getBuilder(){
        return new Builder();
    }



    public static class Builder{

        private int dimensions;
        private List<Player> playersList ;
        private List<WinningStrategy> winningStrategyList;

        private Builder(){}

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayersList(List<Player> playersList) {
            this.playersList = playersList;
            return this;
        }

        public Builder setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
            this.winningStrategyList = winningStrategyList;
            return this;
        }
        public boolean isValid(){
            if(this.playersList.size()<2 && this.playersList.size() != this.dimensions-1){
                return false ;
            }
            int botCount = 0 ;
            for(Player player : playersList){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount += 1 ;
                    if(botCount>=2) return false;
                }
            }
            Set<Character> existingSymbol =new HashSet<>();
            for(Player player : playersList){
                if(existingSymbol.contains(player.getSymbol().getAchar())){
                    return false;
                }
                existingSymbol.add(player.getSymbol().getAchar());
            }
            return true;
        }

        public Game build(){
            if(!isValid()){
                throw new RuntimeException("Invalid input for a game");
            }
            return new Game(dimensions ,playersList , winningStrategyList);
        }
    }

}

/*
Builder Design Pattern :
Is used when a Complex object is required to be Constucted
Can easily validate the paramenter while creating that

Here we are creating a Game
Game Class
1. Make Game Constructor Private
2. Create the below method in Game class
public static Builder getBuilder{
    return new Builder();
 }

 Builder Class
3. Create a public static class Builder{}
4. Inside this add all the params required to build + public empty constructor
 + public setter Methods that return Builder object (return this;)
 5. Add Build method which return Game object like return Game(all params);
 */
