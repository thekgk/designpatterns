package com.patterns.videoapp;

public class PrimeVideoPresenterFactory implements ShowPresenterFactory {

    private App app;

    public PrimeVideoPresenterFactory(App app) {
        this.app = app;
    }

    @Override
    public MoviePresenter moviePresenter() {
        return new PrimeVideoMoviePresenter();
    }

    @Override
    public SeriesPresenter seriesPresenter() {
        return new PrimeVideoSeriesPresenter();
    }
}
