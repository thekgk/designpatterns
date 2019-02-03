package com.patterns.videoapp.netflix;

import com.patterns.videoapp.App;
import com.patterns.videoapp.ui.MoviePresenter;
import com.patterns.videoapp.ui.SeriesPresenter;
import com.patterns.videoapp.ui.ShowPresenterFactory;

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
