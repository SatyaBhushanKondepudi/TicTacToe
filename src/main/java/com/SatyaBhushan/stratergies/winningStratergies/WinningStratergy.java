package com.SatyaBhushan.stratergies.winningStratergies;

import com.SatyaBhushan.models.Board;
import com.SatyaBhushan.models.Move;
import com.SatyaBhushan.models.Player;

public interface WinningStratergy {

    Player checkWinner(Board board , Move latestMove);
}
