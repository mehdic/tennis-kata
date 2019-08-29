package com.nexeo.katas.tennis.entities;

import com.nexeo.katas.tennis.entities.interfaces.TennisMatchComponent;

import static com.nexeo.katas.tennis.utils.Utils.isPlayer1;
import static com.nexeo.katas.tennis.utils.Utils.isPlayer2;

public class Set implements TennisMatchComponent
{
    private final Player player1;
    private final Player player2;
    private Player setWinner;
    private SetScore score;
    private boolean isFinshed;
    private boolean tieBreakRuleActivated;

    public Set(Player player1, Player player2) {
        this(player1, player2, false);
    }

    public Set(Player player1, Player player2, boolean tieBreakRuleActivated) {
        this.player1 = player1;
        this.player2 = player2;
        this.tieBreakRuleActivated = tieBreakRuleActivated;
        this.setWinner = null;
        this.score=new SetScore(this);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getSetWinner() {
        return setWinner;
    }

    public void setSetWinner(Player setWinner) {
        this.setWinner = setWinner;
    }

    public SetScore getScore() {
        return score;
    }

    public void setScore(SetScore score) {
        this.score = score;
    }

    public boolean isFinshed() {
        return isFinshed;
    }

    public void setFinshed(boolean finshed) {
        isFinshed = finshed;
    }

    public boolean isTieBreakRuleActivated() {
        return tieBreakRuleActivated;
    }

    public boolean scoreForPlayer(Player player) {
        boolean scoreCalculated=false;
        if(isFinshed)
            return scoreCalculated;
        updateScoreForPlayer(player);
        scoreCalculated=true;
        return scoreCalculated;
    }

    private void updateScoreForPlayer(Player player) {
        //implement score update based on definied rules
        if(isPlayer1(this,player))
        {
            this.score.calculateNextPlayer1Score();
            checkIfGameIsFinished(player,this.score.getPlayer1Score());
        }
        else if(isPlayer2(this,player))
        {
            this.score.calculateNextPlayer2Score();
            checkIfGameIsFinished(player,this.score.getPlayer2Score());
        }
    }

    private boolean checkIfGameIsFinished(Player lastScorer,String lastScore) {
        boolean setIsFinshed=false;
        if(lastScore.equals("WIN"))
        {
            setIsFinshed=true;
            this.setWinner=lastScorer;
        }

        if(setIsFinshed)
        {
            this.isFinshed=true;
            score.setWinner(setWinner);
        }
        return setIsFinshed;
    }

    public String getStrGameScore()
    {
        String str="Score : "+player1.getName()+"  "+this.getScore().getPlayer1Score()+" / "+player2.getName()+"  "+this.getScore().getPlayer2Score();
        return str;
    }
    public  void printCurrentGameScore() {
        System.out.println(getStrGameScore());
    }


}
