package com.patterns.videoapp.primevideo;

import com.patterns.videoapp.ui.Movie;
import com.patterns.videoapp.ui.MoviePresenter;

public class PrimeVideoMoviePresenter extends MoviePresenter {
    @Override
    public Movie getMovie(String name) {
        System.out.println("Getting movie from Prime Video ----- ");
        return new Movie(name, "90 min", "amazon prime movie");
    }
}
