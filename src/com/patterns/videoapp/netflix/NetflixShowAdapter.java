package com.patterns.videoapp.netflix;

import com.patterns.videoapp.ui.Show;

public class NetflixShowAdapter implements Show {
    private NetflixShow netflixShow;
    public NetflixShowAdapter(NetflixShow netflixShow){
        this.netflixShow = netflixShow;
    }

    @Override
    public String getTitle() {
        return netflixShow.getName();
    }

    @Override
    public String getBannerURL() {
        return netflixShow.getBanner();
    }

    @Override
    public String getType() {
        return netflixShow.getType();
    }

    @Override
    public String getSource() {
        return "netflix";
    }
}
