package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static public String[] city={"Istanbul","Londro","Jerusalem","Paris","Berlin","Skopje","Bosna"};
    static public String[] infoCity={"Istanbul is big city in Turkey and have a many historical places.",
                                     "Londra is big city in England and same time most wonderful city in world.",
                                     "Jerusalem is a special places for many religion.",
                                     "Paris is a most beatiful city in world.",
                                     "Berlin is capital of Germany.",
                                     "Skopje is historical city in Makadonia.",
                                     "Bosna-Hersek is beatiful and friendly country."};
    static public String[] favoriteFood={"Kült Börek, Kebap, Çiğ Köfte, Islak Hamburger",
                                         "Fish & Chips",
                                         "Arabian Food, Lokma, Kadayıf",
                                         "Pasta, Cake, Desert",
                                         "Beer, Sauseges, Shnitzel, Pig meat,Patotes",
                                         "Künefe, Makedon Köfte",
                                         "Boşnak Mantı, Cevabi"};
    static public String [] favoritePlaces={"Galata Kule, Kız Kulesi, Bebek, Nişantaşı, Eminönü, Adalar, Kadıköy",
                                            "Times Bridge, Time Clock, Golden Gate",
                                            "Mescid-i Aksa",
                                            "Notre Dame, Eyfel Tower, Shanzalize, Museum of Louvre",
                                            "Berlin Wall, Brandenburg Gate, Catedral of Dom",
                                            "Skopje Çarşı, Stone Bridge",
                                            "Baş Çarşı, Şehitlik, Mostar"};


    protected  void updateList(Bundle savedInstanceState) {
        ListView cityList= (ListView) findViewById(R.id.cityListView);
        ArrayAdapter<String> cityAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, city);
        cityList.setAdapter(cityAdaptor);
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    SecondActivity.selectedCityIndex=position;
                    Intent secondFragment=new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(secondFragment);
            }
        });
    }
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addButton=(Button) findViewById(R.id.addButton);
        updateList(savedInstanceState);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdActivity=new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(thirdActivity);
            }
        });

    }
}