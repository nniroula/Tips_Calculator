package com.example.tipscalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
    Added variables
     */
    private EditText userInputAmount;  // working on this
    private EditText userTaxAmount;

    // radio buttons
    private RadioButton zeroButton;
    private RadioButton fiveButton;
    private RadioButton tenButton;
    private RadioButton twentyButton;

    //buttons

    private Button clearButton;
    private Button calculateButton;
    // totals
    private double grandTotal = 0.00;
    private double tipAmount = 0.00;

    // text view variable
    private TextView viewGrandTotal;
    private TextView grandTotalValue;
    private TextView viewTipsAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Added code
         */
        // get the values from amount, tax, and tips
        // use IDs

        // user inputs
        userInputAmount = findViewById(R.id.enterAmount); // working on this
        userTaxAmount = findViewById(R.id.enterTaxAmount);

        // radio buttons
        zeroButton = findViewById(R.id.buttonZero);
        fiveButton = findViewById(R.id.buttonFive);
        tenButton = findViewById(R.id.buttonTen);
        twentyButton = findViewById(R.id.buttonTwenty);

        // buttons
        clearButton = findViewById(R.id.clearButton);
        calculateButton = findViewById(R.id.calculateButton);

        // grand total and tip amount
        viewGrandTotal = findViewById(R.id.grandTotal);
        viewTipsAmount = findViewById(R.id.tipsAmountValue);
        grandTotalValue = findViewById(R.id.grandTotalValue);
    }

    public void calculateGrandTotal(View v){
        // user amount
        TextView inputAmt = userInputAmount;
//        String inputAmtToString = inputAmt.getText().toString();
        double inputAmtToDecimal = Double.parseDouble(inputAmt.getText().toString());

        // user tax amount
        TextView inputTaxAmount = userTaxAmount;
//        String inputTaxAmountToString = inputTaxAmount.getText().toString();
        double inputTaxAmountToDecimal = Double.parseDouble(inputTaxAmount.getText().toString());

        // tips amount


        // calculations
        double sum = inputAmtToDecimal + inputTaxAmountToDecimal;
        DecimalFormat df = new DecimalFormat("##0.00"); // Decimal Format
        grandTotalValue.setText(df.format(sum));
    }

    public void onCalculateButtonClick (View view){
        calculateGrandTotal(view);
    }

    public void onClearButtonClick(View view){
//        textViewResult.setText("0"); // radio button - set to 0, default
//        radioButtonAdd.setChecked(true);
        double defaultTotal = 0.00;
        DecimalFormat df = new DecimalFormat("##0.00"); // Decimal Format
        grandTotalValue.setText(df.format(defaultTotal));

        userInputAmount.setText(df.format(defaultTotal)); // setText takes String argument
        userTaxAmount.setText(df.format(defaultTotal));
        userTaxAmount.setText(df.format(defaultTotal));
    }



}