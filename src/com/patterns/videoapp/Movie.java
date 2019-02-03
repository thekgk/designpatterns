package com.patterns.videoapp;

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
        return this.name + "/ Length: " + this.length + "/ Desc: " + this.description;
    }
}
