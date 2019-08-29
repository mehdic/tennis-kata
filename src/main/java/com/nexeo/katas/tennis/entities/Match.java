package com.nexeo.katas.tennis.entities;

import com.nexeo.katas.tennis.utils.Utils;

public class Match {
    private boolean finished;
    final private Player player1;
    final private Player player2;
    private MatchResult matchResult;
    private Player winner;
    private Game currentGame;
    private Set currentSet;
    private boolean deuceRuleActivated;
    private boolean tieBreakRuleActivated;
    private boolean oneGameSet;




    //Main constructor : with deuce rule activated by default : Sprint 1 : UserStory2
    public Match(Player player1, Player player2) {
        this(player1,player2,  true,true,true);
    }

    //Constructor allows to start the Match without deuce rule : Sprint 1 UserStory1
    public Match(Player player1, Player player2,boolean activateDeuceRule,boolean tieBreakRuleActivated,boolean oneGameSet) {
        this.player1=player1;
        this.player2=player2;
        this.matchResult=new MatchResult(this);
        winner=null;
        this.deuceRuleActivated=activateDeuceRule;
        this.tieBreakRuleActivated=tieBreakRuleActivated;
        this.oneGameSet=oneGameSet;
        //only one set per match always
        this.currentSet=new Set(player1,player2,tieBreakRuleActivated);
    }

    public Player getWinner() {
        return winner;
    }


    public boolean isFinished() {
        return finished;
    }

    public boolean isDeuceRuleActivated() {
        return deuceRuleActivated;
    }
    public boolean isTieBreakRuleActivated() {
        return deuceRuleActivated;
    }
    private void setFinished(boolean finished) {
        this.finished = finished;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean scoreForPlayer(Player player) {
        boolean scoreCalculated=false;
        if(isFinished())
            return scoreCalculated;
        //System.out.println("Scoring for "+player.getName());
        //create a new current game the first time
        if(currentGame==null)
        {
            currentGame=new Game(player1,player2, 1,deuceRuleActivated);
        }
        else if (currentGame.isFinished())
        {
            //create a new game with the next game number sequence if last game isfinished
            currentGame=new Game(player1,player2, currentGame.getGameNumber()+1,deuceRuleActivated);
        }

        scoreCalculated=currentGame.scoreForPlayer(player);
        matchResult.updateResult(currentGame.getGameNumber() ,currentGame);

        if(currentGame.isFinished() && oneGameSet)
        {
            //Sprint 1 - UserStory 1: a set is only one game. so finishing a game ends the set/match
            setFinished(true);
            winner=currentGame.getGameWinner();
            //print the game final score
            Utils.printCurrentGameScoreToConsole(matchResult);
        }
        else
        {
            scoreCalculated=currentSet.scoreForPlayer(currentGame.getGameWinner());
            if(currentSet.isFinshed())
            {
                setFinished(true);
                winner=currentSet.getSetWinner();
            }
        }

        return scoreCalculated;
    }


}
