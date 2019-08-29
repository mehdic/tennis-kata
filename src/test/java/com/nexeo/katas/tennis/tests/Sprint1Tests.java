package com.nexeo.katas.tennis.tests;

import com.nexeo.katas.tennis.entities.Match;
import com.nexeo.katas.tennis.entities.MatchResult;
import com.nexeo.katas.tennis.entities.Player;
import com.nexeo.katas.tennis.utils.Utils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sprint1Tests {


    @Test
    void Sprint1UserStory1Test()
    {
        Player player1=new Player("Player1","Nadal");
        Player player2=new Player("Player2","Federer");
        Match match=new Match(player1,player2,false,false,true);
        MatchResult result=match.getMatchResult();
        player1.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player1.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player2.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player1.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player2.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player2.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player2.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        Utils.printScoreToConsole(match.getMatchResult());
        assertEquals(match.isFinished(),true);
        assertEquals(match.getWinner(),player2);
    }


    @Test
    void Sprint1UserStory2DeuceRuleEnabledTest()
    {
        Player player1=new Player("Player1","Nadal");
        Player player2=new Player("Player2","Federer");
        Match match=new Match(player1,player2);
        MatchResult result=match.getMatchResult();

        player1.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player1.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player2.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player1.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player2.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player2.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player2.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player1.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player1.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        player1.scorePoint(match);
        Utils.printCurrentGameScoreToConsole(result);
        Utils.printScoreToConsole(result);
        assertEquals(match.isFinished(),true);
        assertEquals(match.getWinner(),player1);
    }

    @Test
    void Sprint1RandomMathTest()
    {

        Player nadal=new Player("Player1","Nadal");
        Player federer=new Player("Player2","Federer");
        Match match=new Match(nadal,federer);
        while(!match.isFinished())
        {
            Utils.choosePlayerRandomly(nadal,federer).scorePoint(match);
            Utils.printCurrentGameScoreToConsole(match.getMatchResult());
        }
        Utils.printScoreToConsole(match.getMatchResult());

        assertEquals(match.getWinner()!=null,true);
    }
}
