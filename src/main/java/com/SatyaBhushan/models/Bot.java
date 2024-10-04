package com.SatyaBhushan.models;

import com.SatyaBhushan.models.enums.BotDifficultyLevel;
import com.SatyaBhushan.models.enums.PlayerType;
import com.SatyaBhushan.stratergies.botPlayingStratergies.BotPlayingStratergy;
import com.SatyaBhushan.stratergies.botPlayingStratergies.BotPlayingStratergyFactory;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStratergy botPlayingStratergy;

    public Bot(Symbol symbol, String name,
               BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, PlayerType.BOT);
        this.difficultyLevel = botDifficultyLevel;
        this.botPlayingStratergy = BotPlayingStratergyFactory
                .getBotPlayingStratergyForDifficultyLevel(botDifficultyLevel);
    }

    //Getters & Setters

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public BotPlayingStratergy getBotPlayingStratergy() {
        return botPlayingStratergy;
    }

    public void setBotPlayingStratergy(BotPlayingStratergy botPlayingStratergy) {
        this.botPlayingStratergy = botPlayingStratergy;
    }


    @Override
    public Cell makeMove(Board board){
        return botPlayingStratergy.makeMove(board);
    }
}
