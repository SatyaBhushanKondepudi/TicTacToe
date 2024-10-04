package com.SatyaBhushan.stratergies.winningStratergies;

import com.SatyaBhushan.models.Board;
import com.SatyaBhushan.models.Move;
import com.SatyaBhushan.models.Player;
import com.SatyaBhushan.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneColumnWinningStratergy implements WinningStrategy{
    List<Map<Symbol, Integer>> columnMap ;

    public OrderOneColumnWinningStratergy(int size , List<Player> players){
        this.columnMap = new ArrayList<>();
        for(int i=0 ; i<size ; i++){
            columnMap.add(new HashMap<>());
            for(Player player : players){
                columnMap.get(i).put(player.getSymbol() , 0);
            }
        }
    }

    @Override
    public boolean checkWinner(Board board, Move latestMove) {
        int column = latestMove.getCell().getColumn();
        Symbol symbol = latestMove.getPlayer().getSymbol();
        columnMap.get(column).put(symbol , 1+columnMap.get(column).get(symbol));
        if(columnMap.get(column).get(symbol) == board.getSize()){
            System.out.println(latestMove.getPlayer().getName() + "is the winner");
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {

    }
}
