package com.nexeo.katas.tennis.entities;

public class Player
{
    final String id;
    final String name;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void scorePoint(Match match)
    {
        match.scoreForPlayer(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString()
    {
        return id+" - "+name;
    }
}
