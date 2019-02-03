package com.patterns.videoapp;

public class NetflixSeriesPresenter extends SeriesPresenter {

    @Override
    public Series getSeries(String name) {
        System.out.println("Getting series from Netflix ---- ");
        return new Series(name, "2", "Netflix series");
    }
}
