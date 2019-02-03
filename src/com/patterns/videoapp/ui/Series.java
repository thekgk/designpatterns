package com.patterns.videoapp.ui;

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
        return this.name + "/ Seasons: " + this.seasons + "/ Desc:/ " + this.description;
    }
}
