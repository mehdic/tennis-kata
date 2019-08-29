package com.nexeo.katas.tennis.entities;

import com.nexeo.katas.tennis.entities.interfaces.TennisMatchComponent;

import static com.nexeo.katas.tennis.entities.GameScore.WIN;
import static com.nexeo.katas.tennis.utils.Utils.isPlayer1;
import static com.nexeo.katas.tennis.utils.Utils.isPlayer2;

public class Game implements TennisMatchComponent
{
    private final Player player1;
    private final Player player2;
    private Player gameWinner;
    private GameScore score;
    private boolean isFinshed;
    private int gameNumber;
    private boolean deuceRuleActivated;
    Player lastScorer;

    public Game(Player player1, Player player2, int gameNumber,boolean deuceRuleActivated)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.gameNumber = gameNumber;
        this.gameWinner = null;
        this.score=new GameScore(this);
        this.deuceRuleActivated=deuceRuleActivated;
        System.out.println("New Game Starts ...");
    }

    public boolean isDeuceRuleActivated() {
        return deuceRuleActivated;
    }

    public void setGameWinner(Player winner) {
        this.gameWinner=winner;
    }

    public Player getGameWinner() {
        return gameWinner;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public GameScore getScore() {
        return score;
    }

    public void setScore(GameScore score) {
        this.score = score;
    }

    public boolean isFinished() {
        return isFinshed;
    }

    public void setFinshed(boolean finshed) {
        isFinshed = finshed;
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
        lastScorer=player;
        if(isPlayer1(this,player))
        {
            this.score.calculateNextPlayer1Score();
            checkIfGameIsFinished(lastScorer,this.score.getPlayer1Score());
        }
        else if(isPlayer2(this,player))
        {
            this.score.calculateNextPlayer2Score();
            checkIfGameIsFinished(lastScorer,this.score.getPlayer2Score());
        }
    }

    protected boolean checkIfGameIsFinished(Player lastScorer,String lastScore) {
        boolean gameIsFinshed=false;
        if(lastScore.equals(WIN))
        {
            gameIsFinshed=true;
            this.gameWinner=lastScorer;
        }

        if(gameIsFinshed)
        {
            this.isFinshed=true;
            score.setWinner(gameWinner);
        }
        return gameIsFinshed;
    }

    public int getGameNumber() {
        return this.gameNumber;
    }

    public String getStrGameScore()
    {
        String str="Score : "+player1.getName()+"  "+this.getScore().getPlayer1Score()+(lastScorer==player1?"(*)":"   ")+" / "+player2.getName()+"  "+this.getScore().getPlayer2Score()+(lastScorer==player2?"(*)":"   ");
        return str;
    }
    public  void printCurrentGameScore() {
        System.out.println(getStrGameScore());
    }
}
