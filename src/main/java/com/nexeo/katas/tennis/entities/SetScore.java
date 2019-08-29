package com.nexeo.katas.tennis.entities;

import com.nexeo.katas.tennis.entities.interfaces.Score;

public class SetScore implements Score
{
    public static final String SCORE_0 = "0";
    public static final String SCORE_1 = "1";
    public static final String SCORE_2 = "2";
    public static final String SCORE_3 = "3";
    public static final String SCORE_4 = "4";
    public static final String SCORE_5 = "5";
    public static final String SCORE_6 = "6";
    public static final String WIN = "WIN";
    String player1Score;
    String player2Score;
    Player winner=null;
    Set relatedSet;


    public SetScore(Set relatedSet) {
        this.relatedSet = relatedSet;
        player1Score=SCORE_0;
        player2Score=SCORE_0;
    }

    public Set getRelatedSet() {
        return relatedSet;
    }

    public String getPlayer1Score() {
        return player1Score;
    }

    public void calculateNextPlayer2Score() {
        this.player2Score = getNextScore(player2Score,player1Score);
       /* if(this.player2Score.equals(DEUCE))
            this.player1Score= DEUCE;
        else if(this.player2Score.equals(ADV))
            this.player1Score= SCORE_40;*/

    }

    public void calculateNextPlayer1Score() {
        this.player1Score = getNextScore(player1Score,player2Score);
       /* if(this.player1Score.equals(DEUCE))
            this.player2Score= DEUCE;
        else if(this.player1Score.equals(ADV))
            this.player2Score= SCORE_40;*/
    }

    private String getNextScore(String oldScore,String otherPlayerScore) {
        String newScore= SCORE_0;
        switch (oldScore) {
            case SCORE_0:
                newScore= SCORE_1;
                break;
            case SCORE_1:
                newScore= SCORE_2;
                break;
            case SCORE_2:
                newScore= SCORE_3;
                break;
            case SCORE_3:
                newScore= SCORE_4;
                break;
            case SCORE_4:
                newScore= SCORE_5;
                break;
            case SCORE_5:
                if(isScoreLessThenFive(otherPlayerScore)) {
                    newScore= WIN;
                }
                else
                {
                    newScore= SCORE_6;
                }
                break;
            default:
                if(getRelatedSet().isTieBreakRuleActivated())
                {
                    if(wasPlayerWinningByOne(oldScore,otherPlayerScore))
                    {
                        newScore = WIN;
                    }
                    else
                    {
                        newScore=""+(Integer.parseInt(oldScore.trim())+1);
                    }
                }
                else {
                    newScore = WIN;
                }
                break;

          /*  case SCORE_30:
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
                newScore= SCORE_15;*/
        }
        return newScore;
    }

    private boolean wasPlayerWinningByOne(String oldScore, String otherPlayerScore) {
        int oldScoreInt=Integer.parseInt(oldScore.trim());
        int otherPlayerScoreInt=Integer.parseInt(otherPlayerScore.trim());
        if(oldScoreInt>otherPlayerScoreInt)
            return true;
        else
            return false;
    }

    private boolean isScoreLessThenFive(String score) {
        boolean isLessThenFive=false;
        switch (score)
        {
            case SCORE_0:
            case SCORE_2:
            case SCORE_1:
            case SCORE_3:
            case SCORE_4:
                    isLessThenFive=true;
                break;
            default:
                isLessThenFive=false;
        }
        return isLessThenFive;
    }

    public String getPlayer2Score() {
        return player2Score;
    }


    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
        relatedSet.setSetWinner(winner);
    }
}
