package com.patterns.videoapp.primevideo;

import com.patterns.videoapp.ui.Series;
import com.patterns.videoapp.ui.SeriesPresenter;

public class PrimeVideoSeriesPresenter extends SeriesPresenter {
    @Override
    public Series getSeries(String name) {
        System.out.println("Getting series from Prime Video ---- ");
        return new Series(name, "10", "amazon prime series");
    }
}
