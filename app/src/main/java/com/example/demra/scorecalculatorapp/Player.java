package com.example.demra.scorecalculator;

public class Player {
    String name;
    int score;
    int id;

    public Player(int id, String name){
        this.id=id;
        this.name=name;
        this.score=0;
    }

    public int getScore()
    {
        return this.score;
    }

    public int addToScore(int value)
    {
        return this.score+value;
    }

    public int getId()
    {
        return this.id;
    }
}