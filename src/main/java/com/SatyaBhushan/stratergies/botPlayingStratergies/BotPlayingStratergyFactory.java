package com.SatyaBhushan.stratergies.botPlayingStratergies;

import com.SatyaBhushan.models.enums.BotDifficultyLevel;

public class BotPlayingStratergyFactory {

    public static BotPlayingStratergy getBotPlayingStratergyForDifficultyLevel
            (BotDifficultyLevel difficultyLevel){
        System.out.println("Hello Bot");
        return new EasyBotPlayingStratergy();
//        return switch (difficultyLevel){
//            case EASY -> new EasyBotPlayingStratergy();
//            case MEDIUM -> new MediumBotPlayingStratergy();
//            case HARD -> new HardBotPlayingStratergy();
//        };
    }
}
