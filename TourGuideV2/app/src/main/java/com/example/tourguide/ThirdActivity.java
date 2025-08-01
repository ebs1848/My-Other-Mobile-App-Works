package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Arrays;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        EditText editTextcityName=(EditText) findViewById(R.id.editTextCityName);
        EditText editTextcityInfo=(EditText) findViewById(R.id.editTextCityInfo);
        EditText editTextFavFood=(EditText) findViewById(R.id.editTextFavFood);
        EditText editTextFavPlaces=(EditText) findViewById(R.id.editTextFavPlaces);
        Button buttonSave=(Button) findViewById(R.id.button_save);
        Button buttonBack=(Button) findViewById(R.id.button_back);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.copyOf(MainActivity.city, MainActivity.city.length +1);
                MainActivity.city[MainActivity.city.length] = String.valueOf(editTextcityName.getText());
                Arrays.copyOf(MainActivity.infoCity, MainActivity.infoCity.length +1);
                MainActivity.infoCity[MainActivity.infoCity.length] = String.valueOf(editTextcityInfo.getText());
                Arrays.copyOf(MainActivity.favoriteFood, MainActivity.favoriteFood.length +1);
                MainActivity.favoriteFood[MainActivity.favoriteFood.length] = String.valueOf(editTextFavFood.getText());
                Arrays.copyOf(MainActivity.favoritePlaces, MainActivity.favoritePlaces.length +1);
                MainActivity.favoritePlaces[MainActivity.favoritePlaces.length] = String.valueOf(editTextFavPlaces.getText());
                MainActivity mActiity = new MainActivity();
                mActiity.updateList(savedInstanceState);
                ThirdActivity.this.finish();
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdActivity.this.finish();
            }
        });
    }
}