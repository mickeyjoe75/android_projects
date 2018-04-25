package com.numerounoapps.mjm75.topmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TopMoviesAdapter extends ArrayAdapter<Movie> {

    public TopMoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, 0, movies);

    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.movie_list_item, parent, false);
        }

        Movie currentMovie = getItem(position);

        TextView ranking = listItemView.findViewById(R.id.rankingTextViewId);
        ranking.setText(currentMovie.getRanking().toString());

        TextView year = listItemView.findViewById(R.id.yearTextViewId);
        year.setText(currentMovie.getYear().toString());

        TextView title = listItemView.findViewById(R.id.titleTextViewId);
        title.setText(currentMovie.getTitle());


        listItemView.setTag(currentMovie);

        return listItemView;


    }



}
