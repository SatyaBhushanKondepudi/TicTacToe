package com.SatyaBhushan.stratergies.botPlayingStratergies;

import com.SatyaBhushan.models.Board;
import com.SatyaBhushan.models.Cell;
import com.SatyaBhushan.models.enums.CellState;

import java.util.List;

public class EasyBotPlayingStratergy implements BotPlayingStratergy {
    @Override
    public Cell makeMove(Board board) {
        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return cell;
                }
            }
        }
        return null; // You should never come here
    }
}
