package com.numerounoapps.mjm75.topmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("movie");

        TextView movieTitleTextView = findViewById(R.id.movieTitleTextViewId);
        movieTitleTextView.setText(movie.getTitle());

    }
}
