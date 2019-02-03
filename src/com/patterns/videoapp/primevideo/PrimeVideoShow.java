package com.patterns.videoapp.primevideo;

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
