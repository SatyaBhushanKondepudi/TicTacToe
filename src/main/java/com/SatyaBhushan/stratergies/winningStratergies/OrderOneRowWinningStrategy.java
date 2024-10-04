package com.SatyaBhushan.stratergies.winningStratergies;

import com.SatyaBhushan.models.Board;
import com.SatyaBhushan.models.Move;
import com.SatyaBhushan.models.Player;
import com.SatyaBhushan.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneRowWinningStrategy implements WinningStrategy{
    List<Map<Symbol , Integer>> rowMap;

    public OrderOneRowWinningStrategy(int size , List<Player> players){
        this.rowMap = new ArrayList<>();
        for(int i=0 ; i<size ; i++){
            rowMap.add(new HashMap<>());
            for(Player player : players){
                rowMap.get(i).put(player.getSymbol(),0);
            }
        }
    }

    @Override
    public boolean checkWinner(Board board, Move latestMove) {
        int row = latestMove.getCell().getRow();
        Symbol symbol = latestMove.getPlayer().getSymbol();
        rowMap.get(row).put(symbol , 1 + rowMap.get(row).get(symbol));
        if(rowMap.get(row).get(symbol) == board.getSize()){
            System.out.println(latestMove.getPlayer().getName() + "is the winner");
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {

    }
}
