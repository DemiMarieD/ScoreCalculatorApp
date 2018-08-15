package com.example.demra.scorecalculatorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {

    public int numberOfPlayers;
    EditText number_field;
    Button next_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        number_field=findViewById(R.id.inputNumber_players);
        next_button=findViewById(R.id.button_next);

    }
    public void next(View view)
    {
        if (number_field.getText().toString().equals("")){
            numberOfPlayers= 0;
        }
        else {
            numberOfPlayers=Integer.parseInt(number_field.getText().toString());
        }

        if (numberOfPlayers<2) {
            AlertDialog alertDialog = new AlertDialog.Builder(WelcomeActivity.this).create();
            alertDialog.setTitle("Invalid Input");
            alertDialog.setMessage("Please enter a number bigger than 1.");
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
            //new Page
            //Bundle bundle=new Bundle();
            //bundle.putInt("numberofplayers",numberOfPlayers);

            ((GlobalApplication)this.getApplication()).setNumberOfPlayers(numberOfPlayers);

            Intent i=new Intent(this,InitializePlayersActivity.class);
           // i.putExtras(bundle);
            startActivity(i);
            //setContentView(R.layout.activity_initialize_players);
        }
    }
}
