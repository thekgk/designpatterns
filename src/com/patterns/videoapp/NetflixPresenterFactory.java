package com.patterns.videoapp;

public class NetflixPresenterFactory implements ShowPresenterFactory {

    private App app;

    public NetflixPresenterFactory(App app) {
        this.app = app;
    }

    @Override
    public MoviePresenter moviePresenter() {
        return new NetflixMoviePresenter();
    }

    @Override
    public SeriesPresenter seriesPresenter() {
        return new NetflixSeriesPresenter();
    }
}
