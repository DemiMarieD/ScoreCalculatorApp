package com.example.demra.scorecalculatorapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //Bundle bundle = getIntent().getExtras();
    //String[] names=bundle.    getStringArray("name");

    int PlayersCount;
    com.example.demra.scorecalculatorapp.Player[] Players;
    Context context;
    GridLayout mlayout;
    int index=2;
    DynamicFieldsScoreInput dynamicScoreInput;
    int round;
    TextView Round;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        round=((GlobalApplication)this.getApplication()).getRoundNumber();
        Round=findViewById(R.id.Round);
        Round.setText("Round "+round);
        PlayersCount = ((GlobalApplication)this.getApplication()).getNumberOfPlayers();
        Players = ((GlobalApplication)this.getApplication()).getPlayerArray();

        dynamicScoreInput = new DynamicFieldsScoreInput(context);
        mlayout=(GridLayout)findViewById(R.id.my2layout);

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
        boolean full=true;
        String [] score=new String[PlayersCount];
        for (int i=0;i<PlayersCount;i++)
        {
            EditText points=findViewById(i+1);
            if (points.getText().toString().equals(""))
            {
                full=false;
            }
            else {
                score[i]=points.getText().toString();
            }
        }

        if (!full)
        {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Invalid Input");
            alertDialog.setMessage("Please enter all the names.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        else {


            //wenn ja:
            //werte addieren
            for(int i =0;i<PlayersCount;i++)
            {
                Players[i].addToScore((Integer.parseInt(score[i])));
            }
            //speichern
            ((GlobalApplication) this.getApplication()).setPlayerArray(Players);
            Intent i = new Intent(this, ScoreView.class);
            startActivity(i);
        }
    }

}
