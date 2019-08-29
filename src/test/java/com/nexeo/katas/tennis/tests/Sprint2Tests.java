package com.nexeo.katas.tennis.tests;

import com.nexeo.katas.tennis.entities.Match;
import com.nexeo.katas.tennis.entities.MatchResult;
import com.nexeo.katas.tennis.entities.Player;
import com.nexeo.katas.tennis.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sprint2Tests {


    @Test
    void Sprint2UserStory1NormalGameTest()
    {
        Player player1=new Player("Player1","Nadal");
        Player player2=new Player("Player2","Federer");
        Match match=new Match(player1,player2,true,false,false);
        MatchResult result=match.getMatchResult();
        List<Player> matchScenario= Arrays.asList(
                player1,player1,player2,player1,player1,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player1,player1,player1,player1,
                player2,player2,player2,player2
        );
        for (Player player : matchScenario) {
            player.scorePoint(match);
            Utils.printCurrentGameScoreToConsole(result);
        }

        Utils.printScoreToConsole(match.getMatchResult());
        assertEquals(match.isFinished(),true);
        assertEquals(match.getWinner(),player2);
    }


    @Test
    void Sprint2UserStory1TightGameTest()
    {
        Player player1=new Player("Player1","Nadal");
        Player player2=new Player("Player2","Federer");
        Match match=new Match(player1,player2,true,false,false);
        MatchResult result=match.getMatchResult();
        List<Player> matchScenario= Arrays.asList(
                player1,player1,player2,player1,player1,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player1,player1,player1,player1,
                player1,player1,player1,player1,
                player1,player1,player1,player1,
                player1,player1,player1,player1,
                player1,player1,player1,player1,
                player2,player2,player2,player2,
                player1,player1,player1,player1
        );
        for (Player player : matchScenario) {
            player.scorePoint(match);
            Utils.printCurrentGameScoreToConsole(result);
        }

        Utils.printScoreToConsole(match.getMatchResult());
        assertEquals(match.isFinished(),true);
        assertEquals(match.getWinner(),player1);
    }


    @Test
    void Sprint2UserStory2TieBreakRuleEnabledTest()
    {
        Player player1=new Player("Player1","Nadal");
        Player player2=new Player("Player2","Federer");
        Match match=new Match(player1,player2,true,true,false);
        MatchResult result=match.getMatchResult();
        List<Player> matchScenario= Arrays.asList(
                player1,player1,player2,player1,player1,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player2,player2,player2,player2,
                player1,player1,player1,player1,
                player1,player1,player1,player1,
                player1,player1,player1,player1,
                player1,player1,player1,player1,
                player1,player1,player1,player1,
                player2,player2,player2,player2,
                player1,player1,player1,player1,
                player2,player2,player2,player2,
                player1,player1,player1,player1 ,
                player2,player2,player2,player2,
                player1,player1,player1,player1,
                player2,player2,player2,player2,
                player1,player1,player1,player1,
                player1,player1,player1,player1
        );
        for (Player player : matchScenario) {
            player.scorePoint(match);
            Utils.printCurrentGameScoreToConsole(result);
        }

        Utils.printScoreToConsole(match.getMatchResult());
        assertEquals(match.isFinished(),true);
        assertEquals(match.getWinner(),player1);
    }

    @Test
    void Sprint2RandomMathTest()
    {

        Player nadal=new Player("Player1","Nadal");
        Player federer=new Player("Player2","Federer");
        Match match=new Match(nadal,federer,true,false,false);

        while(!match.isFinished())
        {
            Utils.choosePlayerRandomly(nadal,federer).scorePoint(match);
            Utils.printCurrentGameScoreToConsole(match.getMatchResult());
        }
        Utils.printScoreToConsole(match.getMatchResult());

        assertEquals(match.getWinner()!=null,true);
    }
}
