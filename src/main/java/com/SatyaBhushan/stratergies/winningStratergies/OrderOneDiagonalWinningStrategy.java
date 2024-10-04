package com.SatyaBhushan.stratergies.winningStratergies;

import com.SatyaBhushan.models.Board;
import com.SatyaBhushan.models.Move;
import com.SatyaBhushan.models.Player;
import com.SatyaBhushan.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneDiagonalWinningStrategy implements WinningStrategy{
    Map<Symbol, Integer> leftDiagonalMap ;
    Map<Symbol, Integer> rightDiagonalMap ;

    public OrderOneDiagonalWinningStrategy(int size , List<Player> players){
        this.leftDiagonalMap = new HashMap<>();
        this.rightDiagonalMap = new HashMap<>();
        for(int i=0 ; i<size ; ++i){
            for (Player player: players) {
                leftDiagonalMap.put(player.getSymbol(), 0);
                rightDiagonalMap.put(player.getSymbol(), 0);
            }
        }
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();

        if (row == col) {
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) + 1);
            if (leftDiagonalMap.get(symbol) == board.getSize()) {
                return true;
            }
        }

        if (row + col == board.getSize() - 1) {
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) + 1);
            if (rightDiagonalMap.get(symbol) == board.getSize()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {

    }
}