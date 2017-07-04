package com.example.genesissy.coffe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class Results extends Activity {
    int Quantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //this for second Data
        Bundle SecondaData = getIntent().getExtras();
        String SecondMassage = SecondaData.getString("TeamB");
        final TextView ThirdMessage = (TextView) findViewById(R.id.Item_name);
        ThirdMessage.setText(SecondMassage);

        // thisdisplay Score for Team A
        Bundle ScoreDataOne = getIntent().getExtras();
        String ThirdMassage = ScoreDataOne.getString("ScoreA");
        final TextView ScoreMassegeA = (TextView) findViewById(R.id.Get_Contact);
        ScoreMassegeA.setText(ThirdMassage);
    }

    //while this method is being used for displaying te view in the tex view

    public void Add(View view) {

        Quantity=Quantity+1;
        display(Quantity);


    }

    public void Subtract(View view) {
        if(Quantity == 0)
        {
            return;
        }
        Quantity= Quantity-1;
        display(Quantity);


    }

    private void display(int number) {
        TextView quantityTextview = (TextView) findViewById(R.id.number);
        quantityTextview.setText("" + number);
    }

    private void DisplayPrice(int number) {
        TextView priceTextview = (TextView) findViewById(R.id.ToTal_Amount);
        priceTextview.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void Get_oder(View view) {
        display(Quantity);
        DisplayPrice(5*Quantity);
    }
}
