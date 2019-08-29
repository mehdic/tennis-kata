package com.nexeo.katas.tennis.entities.interfaces;

import com.nexeo.katas.tennis.entities.Player;

public interface TennisMatchComponent {
    Player getPlayer1();
    Player getPlayer2();
    boolean scoreForPlayer(Player player);
    String getStrGameScore();
    void printCurrentGameScore();
}
