package com.patterns.videoapp.ui;

public abstract class SeriesPresenter implements ShowPresenter{
    @Override
    public void present(Show show) {
        play(getSeries(show.getTitle()));
    }

    private void play(Series series) {
        System.out.println("Playing series ---> " + series);
    }

    public abstract Series getSeries(String title);
}
