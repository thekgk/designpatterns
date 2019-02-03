package com.patterns.videoapp;

public class NetflixMoviePresenter extends MoviePresenter {

    @Override
    public Movie getMovie(String name) {
        System.out.println("Getting movie from Netflix ---- ");
        return new Movie(name, "120 min", "netflix movie");
    }
}
