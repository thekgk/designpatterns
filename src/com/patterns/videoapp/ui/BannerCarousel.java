package com.patterns.videoapp.ui;
import java.util.Iterator;

public class BannerCarousel {
    private final Iterator<Show> shows;

    public BannerCarousel(Iterator<Show> shows) {
        this.shows = shows;
    }

    public void displayBannersV2() {
        this.shows.forEachRemaining(s -> displayBanner(s.getBannerURL()));
    }

    private void displayBanner(String bannerURL) {
        System.out.println("Banner --- " + bannerURL);
    }
}