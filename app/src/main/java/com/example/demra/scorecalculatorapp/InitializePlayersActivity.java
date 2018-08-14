package com.example.demra.scorecalculatorapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.demra.scorecalculator.Player;

public class InitializePlayersActivity extends AppCompatActivity {
    com.example.demra.scorecalculator.DynamicFields dynamicFields;
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
        Bundle bundle = getIntent().getExtras();
        PlayersCount=bundle.getInt("numberofplayers");
        dynamicFields=new com.example.demra.scorecalculator.DynamicFields(context);

        for (int i=0;i<PlayersCount;i++)
        {

            mlayout.addView(dynamicFields.labelTextView(getApplicationContext(),"#"+(i+1)),index);
            mlayout.addView(dynamicFields.inputPlayerName(getApplicationContext(),i+1),index+1);

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

            Bundle bundle=new Bundle();
            bundle.putStringArray("names",names);

            Intent i=new Intent(this,MainActivity.class);
            i.putExtras(bundle);
            startActivity(i);
        }
    }


}
