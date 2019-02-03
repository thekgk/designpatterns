package com.patterns.videoapp;

public class PrimeVideoSeriesPresenter extends SeriesPresenter {
    @Override
    public Series getSeries(String name) {
        System.out.println("Getting series from Prime Video ---- ");
        return new Series(name, "10", "amazon prime series");
    }
}
