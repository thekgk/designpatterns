package com.patterns.videoapp;

public class PrimeVideoMoviePresenter extends MoviePresenter {
    @Override
    public Movie getMovie(String name) {
        System.out.println("Getting movie from Prime Video ----- ");
        return new Movie(name, "90 min", "amazon prime movie");
    }
}
