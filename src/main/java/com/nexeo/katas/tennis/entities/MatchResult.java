package com.nexeo.katas.tennis.entities;

import com.nexeo.katas.tennis.utils.Utils;

import java.util.*;

public class MatchResult {
    private SortedMap<Integer, Game> map = new TreeMap<>();
    int player1WonGames=0;
    int player2WonGames=0;
    private final Match currentMatch;

    public MatchResult(Match match) {

        currentMatch = match;
    }


    public void updateResult(int gameNumber,Game game) {
        map.put(gameNumber,game);
    }

    protected Map<Integer, Game> getResultMap()
    {
        return map;
    }

    private void resetMatchResult()
    {
        player1WonGames=0;
        player2WonGames=0;
    }

    public List<String> getResultLines()
    {
        List<String> lines=new ArrayList<>();
        calculateMatchResult();
        lines.add(currentMatch.getPlayer1().toString()+" / "+currentMatch.getPlayer2().toString());
        lines.add("Match Result : "+ player1WonGames+"/"+player2WonGames);
        if(currentMatch.isFinished())
        {
            lines.add(currentMatch.getWinner().getId()+" - "+currentMatch.getWinner().getName()+" wins the Match");
        }
        return lines;
    }


    public List<String> getCurrentGameResultLines()
    {
        List<String> lines=new ArrayList<>();
        calculateMatchResult();
        Game latestGame=map.get(map.lastKey());
       // lines.add("Player  1  / Player   2");
        lines.add(latestGame.getStrGameScore());
        if(latestGame.isFinished())
        {
            lines.add(latestGame.getGameWinner().getId()+" - "+latestGame.getGameWinner().getName()+" wins the Game "+" (current Set : "+ player1WonGames+"/"+player2WonGames+")");
        }
        if(currentMatch.isFinished())
        {
            lines.add(currentMatch.getWinner().getId()+" - "+currentMatch.getWinner().getName()+" wins the Match "+ player1WonGames+"/"+player2WonGames);
        }
        return lines;
    }

    private void calculateMatchResult() {
        resetMatchResult();
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            Integer gameNumber = (Integer) iterator.next();
            Game game= map.get(gameNumber);
            GameScore score=game.getScore();

            if(Utils.isPlayer1(game,score.getWinner()))
            {
                player1WonGames++;
            }
            else if(Utils.isPlayer2(game,score.getWinner()))
            {
                player2WonGames++;
            }
        }
    }




}
