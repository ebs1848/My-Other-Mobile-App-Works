package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    static public int selectedCityIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textcityName=(TextView) findViewById(R.id.textCityName);
        TextView textInfoCity=(TextView) findViewById(R.id.textInfoCity);
        TextView textFavFood=(TextView) findViewById(R.id.textInfoFavFood);
        TextView textFavPlaces=(TextView) findViewById(R.id.textInfoPlaces);
        textcityName.setText(MainActivity.city[selectedCityIndex]);
        textInfoCity.setText(MainActivity.infoCity[selectedCityIndex]);
        textFavFood.setText(MainActivity.favoriteFood[selectedCityIndex]);
        textFavPlaces.setText(MainActivity.favoritePlaces[selectedCityIndex]);
        Button btnBack=(Button) findViewById(R.id.button_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.this.finish();
            }
        });
    }
}