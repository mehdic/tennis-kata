package com.nexeo.katas.tennis.entities;

import com.nexeo.katas.tennis.entities.interfaces.Score;

public class GameScore implements Score
{


    public static final String SCORE_0 = "0    ";
    public static final String SCORE_15 = "15   ";
    public static final String SCORE_30 = "30   ";
    public static final String SCORE_40 = "40   ";
    public static final String DEUCE = "DEUCE";
    public static final String ADV = "ADV  ";
    public static final String WIN = "WIN  ";
    String player1Score;
    String player2Score;
    Player winner=null;
    Game relatedGame;

    public GameScore(Game relatedGame) {
        this.relatedGame = relatedGame;
        player1Score=SCORE_0;
        player2Score=SCORE_0;
    }

    public Game getRelatedGame() {
        return relatedGame;
    }

    public String getPlayer1Score() {
        return player1Score;
    }

    public void calculateNextPlayer2Score() {
        this.player2Score = getNextScore(player2Score,player1Score);
        if(this.player2Score.equals(DEUCE))
            this.player1Score= DEUCE;
        else if(this.player2Score.equals(ADV))
            this.player1Score= SCORE_40;

    }

    public void calculateNextPlayer1Score() {
        this.player1Score = getNextScore(player1Score,player2Score);
        if(this.player1Score.equals(DEUCE))
            this.player2Score= DEUCE;
        else if(this.player1Score.equals(ADV))
            this.player2Score= SCORE_40;
    }

    private String getNextScore(String oldScore,String otherPlayerScore) {
        String newScore= SCORE_0;
        switch (oldScore) {
            case SCORE_0:
               newScore= SCORE_15;
               break;
            case SCORE_15:
                newScore= SCORE_30;
                break;
            case SCORE_30:
                if(getRelatedGame().isDeuceRuleActivated() && otherPlayerScore.equals(SCORE_40))
                {
                    newScore= DEUCE;
                }
                else {
                    newScore=SCORE_40;
                }
                break;
            case SCORE_40:
                if(getRelatedGame().isDeuceRuleActivated() && otherPlayerScore.equals(ADV))
                {
                    newScore= DEUCE;
                }
                else {
                    newScore = WIN;
                }
                break;
            case DEUCE:
                newScore = ADV;
                break;
            case ADV:
                newScore = WIN;
                break;
           default:
               newScore= SCORE_15;
        }
        return newScore;
    }

    public String getPlayer2Score() {
        return player2Score;
    }


    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
        relatedGame.setGameWinner(winner);
    }
}
