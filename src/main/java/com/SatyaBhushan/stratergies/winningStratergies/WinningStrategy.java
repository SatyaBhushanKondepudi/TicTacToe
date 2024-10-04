package com.SatyaBhushan.stratergies.winningStratergies;

import com.SatyaBhushan.models.Board;
import com.SatyaBhushan.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Board board , Move latestMove);

    void handleUndo(Board board, Move lastMove);
}
