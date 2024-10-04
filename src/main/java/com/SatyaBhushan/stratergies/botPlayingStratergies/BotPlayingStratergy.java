package com.SatyaBhushan.stratergies.botPlayingStratergies;

import com.SatyaBhushan.models.Board;
import com.SatyaBhushan.models.Cell;

public interface BotPlayingStratergy {
    Cell makeMove(Board board);
}
