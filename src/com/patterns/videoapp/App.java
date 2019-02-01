package com.patterns.videoapp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.startV2();
    }

    public void startV1() {
        PrimeVideoShow[] shows = getPrimeVideoShows();
        displayBannersV1(shows);
    }

    public void startV2() {
        PrimeVideoShow[] primeVideoShows = getPrimeVideoShows();
        Iterator<Show> primeVideos = new PrimeVideoShowsIterator(primeVideoShows);
        displayBannersV2(primeVideos);

        Iterator<Show> netflixShows = new NetflixShowsIterator(getNetflixShows());
        displayBannersV2(netflixShows);

        //TODO:
        //write movie iterator, series iterator etc.

        presentShowDetailsV3(new PrimeVideoShowAdapter(primeVideoShows[0]));
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
            factory = new PrimeVideoPresenterFactory();
        }
        else if(show.getSource().equals("netflix")) {
            factory = new NetflixPresenterFactory();
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
        System.out.println("show "+ show.getTitle());
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

    public interface Show {
        String getTitle();
        String getBannerURL();
        String getType();
        String getSource();
    }

    public class PrimeVideoShow {
        private String title;
        private String bannerURL;
        private String type;

        public PrimeVideoShow(String title, String bannerURL, String type){
            this.title = title;
            this.bannerURL = bannerURL;
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public String getBannerURL() {
            return bannerURL;
        }

        public String getType() {
            return type;
        }
    }

    public class NetflixShow {
        private String name;
        private String banner;
        private String type;

        public NetflixShow(String name, String banner, String type) {
            this.name = name;
            this.banner = banner;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getBanner() {
            return banner;
        }

        public String getType() {
            return type;
        }
    }

    public class PrimeVideoShowAdapter implements Show {
        private PrimeVideoShow primeVideoShow;

        public PrimeVideoShowAdapter(PrimeVideoShow show){
            this.primeVideoShow = show;
        }

        @Override
        public String getTitle() {
            return primeVideoShow.getTitle();
        }

        @Override
        public String getBannerURL() {
            return primeVideoShow.getBannerURL();
        }

        @Override
        public String getType() {
            return primeVideoShow.getType();
        }

        @Override
        public String getSource() {
            return "primeVideo";
        }
    }

    public class NetflixShowAdapter implements Show {
        private NetflixShow netflixShow;
        public NetflixShowAdapter(NetflixShow netflixShow){
            this.netflixShow = netflixShow;
        }

        @Override
        public String getTitle() {
            return netflixShow.name;
        }

        @Override
        public String getBannerURL() {
            return netflixShow.banner;
        }

        @Override
        public String getType() {
            return netflixShow.type;
        }

        @Override
        public String getSource() {
            return "netflix";
        }
    }

    public void displayBannersV1(PrimeVideoShow[] shows) {
        for(PrimeVideoShow show : shows){
            System.out.println(show.getBannerURL());
        }
    }

    public void displayBannersV2(Iterator<Show> shows){
        while (shows.hasNext()){
            System.out.println(shows.next().getBannerURL());
        }
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

    public class PrimeVideoShowsIterator implements Iterator<Show> {
        private PrimeVideoShow[] shows;
        private int position = 0;

        public PrimeVideoShowsIterator(PrimeVideoShow[] shows){
            this.shows = shows;
        }

        @Override
        public boolean hasNext() {
            if(position >= shows.length || shows[position] == null){
                return false;
            }
            else {
                return true;
            }
        }

        @Override
        public Show next() {
            PrimeVideoShow show = shows[position];
            position = position + 1;
            return new PrimeVideoShowAdapter(show);
        }
    }

    public class NetflixShowsIterator implements Iterator<Show> {
        private Iterator<NetflixShow> showsIterator;

        public NetflixShowsIterator(Map<String, NetflixShow> shows) {
            this.showsIterator = shows.values().iterator();
        }
        @Override
        public boolean hasNext() {
            return this.showsIterator.hasNext();
        }

        @Override
        public Show next() {
            return new NetflixShowAdapter (this.showsIterator.next());
        }
    }

    public interface ShowPresenter {
        void present(Show show);
    }

    public abstract class MoviePresenter implements ShowPresenter{
        @Override
        public void present(Show show) {
            play(getMovie(show.getTitle()));
        }

        private void play(Movie movie) {
            System.out.println("Playing movie" + movie);
        }

        public abstract Movie getMovie(String title);
    }

    public abstract class SeriesPresenter implements ShowPresenter{
        @Override
        public void present(Show show) {
            play(getSeries(show.getTitle()));
        }

        private void play(Series series) {
            System.out.println("Playing series" + series);
        }

        public abstract Series getSeries(String title);
    }

    public interface ShowPresenterFactory {
        MoviePresenter moviePresenter();
        SeriesPresenter seriesPresenter();
    }

    public class ShowPresenterFactoryImpl implements ShowPresenterFactory{
        private ShowPresenterFactory factory;
        @Override
        public MoviePresenter moviePresenter() {
            return factory.moviePresenter();
        }

        @Override
        public SeriesPresenter seriesPresenter() {
            return factory.seriesPresenter();
        }

        public ShowPresenterFactoryImpl(String source){
            if(source.equals("primeVideo")) {
                factory = new PrimeVideoPresenterFactory();
            }
            else if(source.equals("netflix")) {
                factory = new NetflixPresenterFactory();
            }
            else {
                throw new UnsupportedOperationException();
            }
        }
    }

    public class PrimeVideoPresenterFactory implements ShowPresenterFactory {

        @Override
        public MoviePresenter moviePresenter() {
            return new PrimeVideoMoviePresenter();
        }

        @Override
        public SeriesPresenter seriesPresenter() {
            return new PrimeVideoSeriesPresenter();
        }
    }

    public class PrimeVideoMoviePresenter extends MoviePresenter {

        @Override
        public Movie getMovie(String name) {
            System.out.println("getting movie from Prime Video");
            return new Movie(name, "90 min", "amazon prime movie");
        }
    }

    public class PrimeVideoSeriesPresenter extends SeriesPresenter {

        @Override
        public Series getSeries(String name) {
            System.out.println("getting series from Prime Video");
            return new Series(name, "10", "amazon prime series");
        }
    }

    public class NetflixPresenterFactory implements ShowPresenterFactory {

        @Override
        public MoviePresenter moviePresenter() {
            return new NetflixMoviePresenter();
        }

        @Override
        public SeriesPresenter seriesPresenter() {
            return new NetflixSeriesPresenter();
        }
    }

    public class NetflixMoviePresenter extends MoviePresenter {

        @Override
        public Movie getMovie(String name) {
            System.out.println("getting movie from Netflix");
            return new Movie(name, "120 min", "netflix movie");
        }
    }

    public class NetflixSeriesPresenter extends SeriesPresenter {

        @Override
        public Series getSeries(String name) {
            System.out.println("getting series from Netflix");
            return new Series(name, "2", "Netflix series");
        }
    }

    public class Movie {
        private String name;
        private String length;
        private String description;

        public Movie(String name, String length, String description) {
            this.name = name;
            this.length = length;
            this.description = description;
        }

        @Override
        public String toString() {
            return this.name + "/Length: " + this.length + "/Desc: " + this.description;
        }
    }

    public class Series {
        private String name;
        private String seasons;
        private String description;

        public Series(String name, String seasons, String description) {
            this.name = name;
            this.seasons = seasons;
            this.description = description;
        }

        @Override
        public String toString(){
            return this.name + "/Seasons: " + this.seasons + "Desc:/ " + this.description;
        }
    }
}
