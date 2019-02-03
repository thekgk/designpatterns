package com.patterns.videoapp;

public abstract class MoviePresenter implements ShowPresenter{
    @Override
    public void present(Show show) {
        play(getMovie(show.getTitle()));
    }

    private void play(Movie movie) {
        System.out.println("Playing movie ---> " + movie);
    }

    public abstract Movie getMovie(String title);
}
