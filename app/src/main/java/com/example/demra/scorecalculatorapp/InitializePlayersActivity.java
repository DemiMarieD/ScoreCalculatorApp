package com.example.demra.scorecalculatorapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;

public class InitializePlayersActivity extends AppCompatActivity {
    com.example.demra.scorecalculator.DynamicFields dynamicFields;
    GridLayout mlayout;
    Context context;
    int index=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize_players);
        mlayout=(GridLayout) findViewById(R.id.mylayout);
        Bundle bundle = getIntent().getExtras();
        int PlayersCount=bundle.getInt("numberofplayers");
        dynamicFields=new com.example.demra.scorecalculator.DynamicFields(context);

        for (int i=0;i<PlayersCount;i++)
        {

            mlayout.addView(dynamicFields.labelTextView(getApplicationContext(),"#"+(i+1)),index);
            mlayout.addView(dynamicFields.inputPlayerName(getApplicationContext(),i+1),index+1);
            index+=2;
        }


    }
}
