package com.example.genesissy.coffe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Menu extends Activity {
    ArrayAdapter<String> listAdapter;
    Spinner spinner;
    int Conta=0;

    EditText Contact_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Contact_number=(EditText) findViewById(R.id.Contact_number);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.getSelectedItem().toString();

        String Team_A[] = {"CHOCOLATE", "VANILLA LATTE", "WHITE MOCHA", "VANILLA CREATE", "FRUIT SMOOTHIE"};

        listAdapter = new ArrayAdapter<String>(this, R.layout.cofee_one, Team_A);
        spinner.setAdapter(listAdapter);
        //adapter for teamB spinner
    }

    public void Oder(View view) {



        if (Contact_number.getText().toString().isEmpty() )
        {
            Toast.makeText(getApplicationContext(), "Enter Contact Number", Toast.LENGTH_SHORT).show();


        }else if((Contact_number.getText().toString().length())!=10)
        {

            Toast.makeText(getApplicationContext(), "Contact Number Must Be 10 digits", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Intent Resuits = new Intent(this, Results.class);
            //this print firt Team Name
            final Spinner ScoreB = (Spinner) findViewById(R.id.spinner2);
            String usermesage = ScoreB.getSelectedItem().toString();
            Resuits.putExtra("TeamB", usermesage);
            //printing Contact Number
            final EditText ResultsA= (EditText) findViewById(R.id.Contact_number);
            String scoremassegeA= ResultsA.getText().toString();
            Resuits.putExtra("ScoreA",scoremassegeA);
            startActivity(Resuits);
        }
    }
    public void Exit(View view){

        AlertDialog.Builder dialog = new AlertDialog.Builder(Menu.this);
        dialog.setTitle("EXIT");
        dialog.setMessage("Do You Real Want To Exit This Application? ");


        dialog.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        dialog.show();
    }
}

