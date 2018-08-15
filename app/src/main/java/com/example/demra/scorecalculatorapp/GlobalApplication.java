package com.example.demra.scorecalculatorapp;

import android.app.Application;

import com.example.demra.scorecalculatorapp.Player;

public class GlobalApplication extends Application {

    private int numberOfPlayers;

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }


    private com.example.demra.scorecalculatorapp.Player[] playerArray;

    public Player[] getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }


}
