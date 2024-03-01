package com.example.tipscalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /* variables */
    private EditText userInputAmount;
    private EditText userTaxAmount;

    /* radio buttons */
    private RadioButton zeroButton;
    private RadioButton fiveButton;
    private RadioButton tenButton;
    private RadioButton twentyButton;

    /* total and tip */
    private TextView grandTotalValue;
    private TextView viewTipsAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* get the values from amount, tax, and tips, use IDs */
        /* user inputs */
        userInputAmount = findViewById(R.id.enterAmount);
        userTaxAmount = findViewById(R.id.enterTaxAmount);

        /* radio buttons */
        zeroButton = findViewById(R.id.buttonZero);
        fiveButton = findViewById(R.id.buttonFive);
        tenButton = findViewById(R.id.buttonTen);
        twentyButton = findViewById(R.id.buttonTwenty);

        /* grand total and tip amount */
        viewTipsAmount = findViewById(R.id.tipsAmountValue);
        grandTotalValue = findViewById(R.id.grandTotalValue);
    }

    public void calculateGrandTotal(View v){
        /* user amount */
        TextView inputAmt = userInputAmount;
        double inputAmtToDecimal = Double.parseDouble(inputAmt.getText().toString());

        /* user tax amount */
        TextView inputTaxAmount = userTaxAmount;
        double inputTaxAmountToDecimal = Double.parseDouble(inputTaxAmount.getText().toString());

        /* tips amount  zeroButton  fiveButton  tenButton  twentyButton */
        double tipsAmt = 0.00;
        if (zeroButton.isChecked()) {
            tipsAmt = 0.00;
        }else if(fiveButton.isChecked()){
            tipsAmt = 0.05* inputAmtToDecimal;
        }else if(tenButton.isChecked()){
            tipsAmt = 0.1 * inputAmtToDecimal;
        }else if(twentyButton.isChecked()){
            tipsAmt = 0.2 * inputAmtToDecimal;
        }

        /* calculations */
        double sum = inputAmtToDecimal + inputTaxAmountToDecimal + tipsAmt;
        DecimalFormat df = new DecimalFormat("##0.00");                 // Decimal Format

        /* display values on UI */
        grandTotalValue.setText(df.format(sum));
        viewTipsAmount.setText(df.format(tipsAmt));
    }

    public void onCalculateButtonClick (View view){
        calculateGrandTotal(view);
    }

    public void onClearButtonClick(View view){
        double defaultTotal = 0.00;
        DecimalFormat df = new DecimalFormat("##0.00"); // Decimal Format

        grandTotalValue.setText(df.format(defaultTotal));
        userInputAmount.setText(df.format(defaultTotal)); // setText takes String argument
        userTaxAmount.setText(df.format(defaultTotal));
        viewTipsAmount.setText(df.format(defaultTotal));

        /* radio buttons default to 0% and check zero button on clearing */
        zeroButton.setText("0");
        zeroButton.setChecked(true);
    }
}