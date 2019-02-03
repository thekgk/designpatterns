package com.patterns.videoapp;

import com.patterns.videoapp.netflix.*;
import com.patterns.videoapp.primevideo.*;
import com.patterns.videoapp.ui.Show;
import com.patterns.videoapp.ui.ShowPresenter;
import com.patterns.videoapp.ui.ShowPresenterFactory;
import com.patterns.videoapp.ui.ShowPresenterFactoryImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.runV2();
    }

    public void runV1() {
        PrimeVideoShow[] shows = getPrimeVideoShows();
        displayBannersV1(shows);
    }

    public void runV2() {
        PrimeVideoShow[] primeVideoShows = getPrimeVideoShows();
        Iterator<Show> primeVideos = new PrimeVideoShowsIterator(primeVideoShows);
        displayBannersV2(primeVideos);

        Iterator<Show> netflixShows = new NetflixShowsIterator(getNetflixShows());
        displayBannersV2(netflixShows);

        System.out.println("Movie menu selected");

        displayBannersV2(
                new PrimeVideoShowTypeIterator(primeVideoShows, "movie"));

        //TODO:
        //write movie iterator, series iterator etc.
        presentShowDetailsV3(new PrimeVideoShowAdapter(primeVideoShows[0]));

        presentShowDetailsV3(new PrimeVideoShowAdapter(primeVideoShows[1]));
    }

    private void presentShowDetailsV1(Show show) {
        ShowPresenter presenter = null;
        if(show.getType().equals("movie")){
            if(show.getSource().equals("primeVideo"))
                presenter = new PrimeVideoMoviePresenter();
            else
                presenter = new NetflixMoviePresenter();
        }
        else if(show.getType().equals("series")){
            if(show.getSource().equals("primeVideo"))
                presenter = new PrimeVideoSeriesPresenter();
            else
                presenter = new NetflixSeriesPresenter();
        }
        presenter.present(show);
    }

    private void presentShowDetailsV2(Show show) {
        System.out.println("show "+ show.getTitle());

        ShowPresenterFactory factory = null;
        ShowPresenter presenter = null;
        if(show.getSource().equals("primeVideo")) {
            factory = new PrimeVideoPresenterFactory(this);
        }
        else if(show.getSource().equals("netflix")) {
            factory = new NetflixPresenterFactory(this);
        }
        else {
            throw new UnsupportedOperationException();
        }

        if(show.getType().equals("movie")){
            presenter = factory.moviePresenter();
        }
        else if(show.getType().equals("series")){
            presenter = factory.seriesPresenter();
        }
        presenter.present(show);
    }

    private void presentShowDetailsV3(Show show) {
        System.out.println("\nSelected show ---- "+ show.getTitle());
        ShowPresenterFactory factory = new ShowPresenterFactoryImpl(show.getSource());
        ShowPresenter presenter = null;
        if(show.getType().equals("movie")){
            presenter = factory.moviePresenter();
        }
        else if(show.getType().equals("series")){
            presenter = factory.seriesPresenter();
        }
        presenter.present(show);
    }

    public void displayBannersV1(PrimeVideoShow[] shows) {
        for(PrimeVideoShow show : shows){
            System.out.println(show.getBannerURL());
        }
    }

    public void displayBannersV2(Iterator<Show> shows){
        shows.forEachRemaining(s -> displayBanner(s.getBannerURL()));
    }

    private void displayBanner(String bannerURL) {
        System.out.println("Banner --- " + bannerURL);
    }

    public PrimeVideoShow[] getPrimeVideoShows(){
        PrimeVideoShow[] showsArray = new PrimeVideoShow[]{
                new PrimeVideoShow("Grand Tour", "gtBanner", "series"),
                new PrimeVideoShow("Prime Movie", "pmBanner", "movie")
        };
        return showsArray;
    }

    public Map<String, NetflixShow> getNetflixShows(){
        Map<String, NetflixShow> map = new HashMap<String, NetflixShow>();
        map.put("NFSeries1", new NetflixShow("NFSeries1", "nfSeries1Banner", "series"));
        map.put("NFMovie1", new NetflixShow("NFMovie1", "nfMovie1Banner", "movie"));
        return map;
    }

}
