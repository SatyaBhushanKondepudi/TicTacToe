package com.SatyaBhushan.stratergies.winningStratergies;

import com.SatyaBhushan.models.Board;
import com.SatyaBhushan.models.Move;

public class OrderOneColumnWinningStratergy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move latestMove) {
        return false;
    }
}
