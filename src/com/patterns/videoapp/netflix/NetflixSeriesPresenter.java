package com.patterns.videoapp.netflix;

import com.patterns.videoapp.ui.Series;
import com.patterns.videoapp.ui.SeriesPresenter;

public class NetflixSeriesPresenter extends SeriesPresenter {

    @Override
    public Series getSeries(String name) {
        System.out.println("Getting series from Netflix ---- ");
        return new Series(name, "2", "Netflix series");
    }
}
