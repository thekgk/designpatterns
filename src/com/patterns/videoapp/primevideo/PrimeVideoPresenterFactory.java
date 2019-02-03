package com.patterns.videoapp.primevideo;

import com.patterns.videoapp.App;
import com.patterns.videoapp.ui.MoviePresenter;
import com.patterns.videoapp.ui.SeriesPresenter;
import com.patterns.videoapp.ui.ShowPresenterFactory;

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
