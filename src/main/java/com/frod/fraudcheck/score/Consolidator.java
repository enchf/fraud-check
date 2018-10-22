package com.frod.fraudcheck.score;

import java.util.List;

public class Consolidator<T> implements Scorer<T> {

    private List<Scorer<T>> scorers;
    private static final Double WITH_NO_SCORERS = 0.0;

    @Override
    public double score(T data) {
        return scorers.stream()
                      .mapToDouble(scorer -> scorer.score(data))
                      .average()
                      .orElse(WITH_NO_SCORERS);
    }
}
