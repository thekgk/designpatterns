package com.patterns.videoapp;

public class ShowPresenterFactoryImpl implements ShowPresenterFactory{
    private String source;

    public ShowPresenterFactoryImpl(String source){
        this.source = source;
    }

    @Override
    public ShowPresenter moviePresenter() {
        if(source.equals("primeVideo")) {
            return new LoggingShowPresenter(new PrimeVideoMoviePresenter());
        }
        else  if(source.equals("netflix")) {
            return new NetflixMoviePresenter();
        }
        else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public ShowPresenter seriesPresenter() {
        if(source.equals("primeVideo")) {
            return new PrimeVideoSeriesPresenter();
        }
        else if(source.equals("netflix")) {
            return new NetflixSeriesPresenter();
        }
        else {
            throw new UnsupportedOperationException();
        }
    }
}
