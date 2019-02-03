package com.patterns.videoapp.primevideo;

import java.util.Arrays;

public class PrimeVideoShowTypeIterator extends PrimeVideoShowsIterator {
    public PrimeVideoShowTypeIterator(PrimeVideoShow[] shows, String type) {
        super(Arrays.stream(shows)
                .filter(s -> s.getType().equals(type))
                .toArray(PrimeVideoShow[]::new)
        );
    }
}
