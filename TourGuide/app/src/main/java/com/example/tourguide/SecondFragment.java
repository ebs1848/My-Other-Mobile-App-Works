package com.example.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tourguide.databinding.FragmentSecondBinding;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    static public int selectedCityIndex=0;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textcityName=(TextView) binding.textCityName;
        TextView textInfoCity=(TextView) binding.textInfoCity;
        TextView textFavFood=(TextView) binding.textInfoFavFood;
        TextView textFavPlaces=(TextView) binding.textInfoPlaces;
        textcityName.setText(MainActivity.city[selectedCityIndex]);
        textInfoCity.setText(MainActivity.infoCity[selectedCityIndex]);
        textFavFood.setText(MainActivity.favoriteFood[selectedCityIndex]);
        textFavPlaces.setText(MainActivity.favoritePlaces[selectedCityIndex]);
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDestroyView();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}