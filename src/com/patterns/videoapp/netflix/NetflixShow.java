package com.patterns.videoapp.netflix;

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
