package com.nexeo.katas.tennis.utils;

import com.nexeo.katas.tennis.entities.Game;
import com.nexeo.katas.tennis.entities.MatchResult;
import com.nexeo.katas.tennis.entities.Player;
import com.nexeo.katas.tennis.entities.interfaces.TennisMatchComponent;

import java.util.Random;

public class Utils {
    public static void printScoreToConsole(MatchResult result) {
        System.out.println("***********************************************");
       for  (String line : result.getResultLines()) {
           System.out.println("- " + line);
       }
    }

    public static void printCurrentGameScoreToConsole(MatchResult result) {

        for  (String line : result.getCurrentGameResultLines())
            System.out.println(line);
    }


    public static Player choosePlayerRandomly(Player player1, Player player2) {
        Random random = new Random();
        boolean isPlayerOne = random.nextBoolean();
        if (isPlayerOne) return player1;
        else return player2;
    }

    public static boolean isPlayer1(TennisMatchComponent gameComponent, Player player) {
        return player == gameComponent.getPlayer1();
    }

    public static boolean isPlayer2(TennisMatchComponent gameComponent, Player player) {
        return player == gameComponent.getPlayer2();
    }
}
