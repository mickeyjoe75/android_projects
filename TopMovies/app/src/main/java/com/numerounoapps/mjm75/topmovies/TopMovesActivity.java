package com.numerounoapps.mjm75.topmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TopMovesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_moves);

//        String[] movies = {"Movie1", "Movie2", "Movie3"};
//        ArrayAdapter<String> moviesStringAdapter = new ArrayAdapter<>(this, R.layout.movies_textview, movies);
//


        TopMovies topMovies = new TopMovies();
        ArrayList<Movie> movieList = topMovies.getList();

        TopMoviesAdapter topMoviesAdapter = new TopMoviesAdapter(this, movieList);

        ListView moviesListView = findViewById(R.id.moviesListViewId);

        moviesListView.setAdapter(topMoviesAdapter);

    }

    public void onListItemClick(View listItem) {
        Movie movie = (Movie) listItem.getTag();
        Log.d("Movie Title: ", movie.getTitle());

        Intent intent = new Intent(this, FavouritesActivity.class);
        intent.putExtra("movie", movie);
        startActivity(intent);

    }
}
