package com.example.demra.scorecalculatorapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

public class InitializePlayersActivity extends AppCompatActivity {
    DynamicFieldsNames dynamicFieldsNames;
    GridLayout mlayout;
    Context context;
    Button startButton;
    int PlayersCount;

    int index=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize_players);
        mlayout=(GridLayout) findViewById(R.id.mylayout);
       // Bundle bundle = getIntent().getExtras();
        PlayersCount=((GlobalApplication)this.getApplication()).getNumberOfPlayers();
        dynamicFieldsNames =new DynamicFieldsNames(context);

        for (int i=0;i<PlayersCount;i++)
        {

            mlayout.addView(dynamicFieldsNames.labelTextView(getApplicationContext(),"#"+(i+1)),index);
            mlayout.addView(dynamicFieldsNames.inputPlayerName(getApplicationContext(),i+1),index+1);

            index+=2;
        }
        //startButton=(Button)findViewById(R.id.startBtn);

    }
    public void start(View view)
    {
        boolean full=true;
        String [] names=new String[PlayersCount];
        for (int i=0;i<PlayersCount;i++)
        {
            EditText name=findViewById(i+1);
            if (name.getText().toString().equals(""))
            {
                full=false;
            }
            else {
                names[i]=name.getText().toString();
            }
        }

        if (!full)
        {
            AlertDialog alertDialog = new AlertDialog.Builder(InitializePlayersActivity.this).create();
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
        else
        {

            //Bundle bundle=new Bundle();
            //bundle.putStringArray("names",names);
            ((GlobalApplication)this.getApplication()).setPlayerArray(createPlayersArray(names));
            Log.d("main","ich bin hier");

            Intent i=new Intent(this,MainActivity.class);
           // i.putExtras(bundle);
            startActivity(i);
        }
    }

    public com.example.demra.scorecalculatorapp.Player[] createPlayersArray (String [] names)
    {
        com.example.demra.scorecalculatorapp.Player [] playersInit= new com.example.demra.scorecalculatorapp.Player[names.length];
        for (int i=0;i<names.length;i++)
        {
            playersInit[i]=new com.example.demra.scorecalculatorapp.Player(i+1,names[i]);
        }
        return playersInit;
    }

}
