package com.example.demra.scorecalculatorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {
    Player [] Players;
    Player winner;
    TextView winnerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Players = ((GlobalApplication)this.getApplication()).getPlayerArray();
        winner=Players[0];
        for(int i =0;i<Players.length;i++)
        {
            if(Players[i].score>winner.score)
            {
                winner=Players[i];
            }
        }
        winnerName=findViewById(R.id.winnerName);
        winnerName.setText(winner.name+" with "+winner.score+" points");

    }

    public void newGame(View view)
    {
        Intent intent=new Intent(this,WelcomeActivity.class);
        startActivity(intent);
    }
}
