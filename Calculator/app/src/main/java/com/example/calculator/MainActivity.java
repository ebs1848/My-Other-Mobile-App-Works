package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public float result; // return a result for operation +,/,*,-
    public float firstValue=-1; // entered first number
    String operation; // operation type mult, div, sum, sub
    int operationContinue=0; // for use operation continued 0 is not continue 1 is continue
    int operationCompleted=0; // if operation completed this 1
    int plusMinus=0; // use pozitive or negative number
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnC=(Button) findViewById(R.id.buttonC);
        final Button btnDiv=(Button) findViewById(R.id.buttonDiv);
        final Button btnMult=(Button) findViewById(R.id.buttonMult);
        final Button btnSum=(Button) findViewById(R.id.buttonSum);
        final Button btnSub=(Button) findViewById(R.id.buttonSub);
        final Button btnPlusMinus=(Button) findViewById(R.id.buttonPlusMinus);
        final Button btnEqual=(Button) findViewById(R.id.buttonEqual);
        final Button btnBack=(Button) findViewById(R.id.buttonBack);
        final TextView txtScreen=(TextView) findViewById(R.id.textScreen);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtScreen.setText("0");
                firstValue=0;
                result=0;
                operationContinue=0;
                operationCompleted=0;
                operation=""; // blank not operation
                plusMinus=0;
            }
        });
        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (plusMinus==1) {
                    txtScreen.setText(ReadScreen().substring(1));
                    plusMinus=0;
                }
                else {
                    txtScreen.setText("-"+ReadScreen());
                    plusMinus=1; // this value show minus is active
                }
            }
        });
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ReadScreen().equals(""))
                    firstValue=Float.valueOf(ReadScreen());
                    operation="Sum";
                    operationContinue=1;
                }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ReadScreen().equals("")){
                    firstValue=Float.valueOf(ReadScreen());
                    operation="Div";
                    operationContinue=1;
                }
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ReadScreen().equals("")){
                    firstValue=Float.valueOf(ReadScreen());
                    operation="Mult";
                    operationContinue=1;
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ReadScreen().equals("")){
                    firstValue=Float.valueOf(ReadScreen());
                    operation="Sub";
                    operationContinue=1;
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EqualAction();
            }
        });
    }

    public void NumberClick(View commonButton){
        TextView TxtScreen=(TextView) findViewById(R.id.textScreen);
        Button btnCommon=(Button) commonButton;
        TxtScreen.setText(ReadScreen()+btnCommon.getText().toString());
    }

    public void EqualAction(){
        TextView txtScreen= (TextView) findViewById(R.id.textScreen);
        try {
            if (!ReadScreen().equals("") && !operation.equals("")) {
                float secondValue=Float.parseFloat(ReadScreen()); // catch second number
                if (operation.equals("Sum")) {
                    result = firstValue + secondValue;
                }
                else if (operation.equals("Sub")) {
                    result = firstValue - secondValue;
                }
                else if (operation.equals("Mult")) {
                    result= firstValue * secondValue;
                }
                else if (operation.equals("Div")) {
                    result= firstValue / secondValue;
                }
                txtScreen.setText(String.valueOf(result).toString());
                operationContinue=1; // because use result for first value
                firstValue= (float) result;
                operationContinue=0;
                operationCompleted=1;
            }
        }
        catch (Exception err) {
               Log.e("Calculator",err.getMessage().toString());
        }
    }
    public String ReadScreen(){
        TextView txtScreen=(TextView) findViewById(R.id.textScreen);
        String screenNumber=txtScreen.getText().toString();
        if (screenNumber.equals("0"))
            return "";
        if (operationContinue==1) {
            screenNumber="";
            operationContinue=0; // operation completed
        }
        return screenNumber;
    }
}