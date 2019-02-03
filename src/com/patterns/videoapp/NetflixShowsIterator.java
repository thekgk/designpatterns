package com.patterns.videoapp;

import java.util.Iterator;
import java.util.Map;

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
