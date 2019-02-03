package com.patterns.videoapp;

import java.util.Iterator;

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
