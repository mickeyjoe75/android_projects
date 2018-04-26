package com.numerounoapps.mjm75.topmovies;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FavouritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        Movie newFavouriteMovie = (Movie) getIntent().getSerializableExtra("movie");


        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String favouriteMovie = sharedPreferences.getString("myFavouriteMovie", "");
        Log.d("myFavouriteMovie", favouriteMovie);
        Log.d("what", "what");

    }




}
