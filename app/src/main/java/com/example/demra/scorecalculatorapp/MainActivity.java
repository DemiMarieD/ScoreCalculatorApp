package com.example.demra.scorecalculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        final String[] names=bundle.getStringArray("names");







    }
    public com.example.demra.scorecalculator.Player[] createPlayersArray (String [] names)
    {
        com.example.demra.scorecalculator.Player [] playersInit= new com.example.demra.scorecalculator.Player[names.length];
        for (int i=0;i<names.length;i++)
        {
            playersInit[i]=new com.example.demra.scorecalculator.Player(i+1,names[i]);
        }
        return playersInit;
    }
}
