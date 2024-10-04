package com.SatyaBhushan.stratergies.botPlayingStratergies;

import com.SatyaBhushan.models.enums.BotDifficultyLevel;

public class BotPlayingStratergyFactory {

    public static BotPlayingStratergy getBotPlayingStratergyForDifficultyLevel
            (BotDifficultyLevel difficultyLevel){
        return switch (difficultyLevel){
            case EASY -> new EasyBotPlayingStratergy();
            case MEDIUM -> new MediumBotPlayingStratergy();
            case HARD -> new HardBotPlayingStratergy();
        };
    }
}
