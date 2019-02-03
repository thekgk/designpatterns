package com.patterns.videoapp;

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
