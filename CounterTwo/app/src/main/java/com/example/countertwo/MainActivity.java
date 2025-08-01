package com.example.countertwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter1=0,counter2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtCounter1=(TextView) findViewById(R.id.textCounter1);
        TextView txtCounter2=(TextView) findViewById(R.id.textCounter2);
        Button buttonCounter=(Button) findViewById(R.id.buttonClick);
        buttonCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (counter1==5) {
                    counter1=0;
                    counter2++;
                }
                if (counter2==6) {
                    counter2=0;
                }
                counter1++;
                txtCounter1.setText(String.valueOf(counter1).toString());
                txtCounter2.setText(String.valueOf(counter2).toString());
            }
        });

    }
}