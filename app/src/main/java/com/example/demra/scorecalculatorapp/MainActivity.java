package com.example.demra.scorecalculatorapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    //Bundle bundle = getIntent().getExtras();
    //String[] names=bundle.    getStringArray("name");

    int PlayersCount = ((GlobalApplication)this.getApplication()).getNumberOfPlayers();
    com.example.demra.scorecalculatorapp.Player[] Players=((GlobalApplication)this.getApplication()).getPlayerArray();

    Context context;
    GridLayout mlayout;
    int index=2;
    DynamicFieldsScoreInput dynamicScoreInput=new DynamicFieldsScoreInput(context);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Players=createPlayersArray(names);
        mlayout=(GridLayout) findViewById(R.id.my2layout);

        for (int i=0;i<PlayersCount;i++)
        {
            String name=Players[i].getName();
            mlayout.addView(dynamicScoreInput.nameTextView(getApplicationContext(),name),index);
            mlayout.addView(dynamicScoreInput.inputPlayerScore(getApplicationContext(),i+1),index+1);

            index+=2;
        }


    }
    public void roundFinished (View view)
    {
        //test ob alles ausgefüllt

        //wenn ja:
        //werte addieren

        //speichern
        ((GlobalApplication)this.getApplication()).setPlayerArray(Players);

    }
}
