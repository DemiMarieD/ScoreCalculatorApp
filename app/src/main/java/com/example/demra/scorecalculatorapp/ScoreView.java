package com.example.demra.scorecalculatorapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class ScoreView extends AppCompatActivity {

    Player[] Players;
    DynamicScoreView dynamicScoreView;
    GridLayout mlayout;
    Context context;
    Button doneBtn, nextBtn;
    int PlayersCount;

    int index=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_view);
        Players = ((GlobalApplication)this.getApplication()).getPlayerArray();

        mlayout=(GridLayout) findViewById(R.id.ScoreGridLayout);
        // Bundle bundle = getIntent().getExtras();
        PlayersCount=((GlobalApplication)this.getApplication()).getNumberOfPlayers();
        dynamicScoreView =new DynamicScoreView(context);


        for (int i=0;i<PlayersCount;i++)
        {
            String name=Players[i].getName();
            int score=Players[i].getScore();
            mlayout.addView(dynamicScoreView.nameTextView(getApplicationContext(),name),index);
            mlayout.addView(dynamicScoreView.scoreTextView(getApplicationContext(),score),index+1);
            index+=2;
        }
    }
    public void nextRound(View view)
    {
        ((GlobalApplication)this.getApplication()).setRoundNumber(((GlobalApplication)this.getApplication()).getRoundNumber()+1);
        Intent i =new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void endOfTheGame(View view)
    {

        Intent i =new Intent(this,EndActivity.class);
        startActivity(i);
    }
}
