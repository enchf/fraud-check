package com.frod.fraudcheck.score;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Consolidator<T> implements Scorer<T> {

    private static final Double WITH_NO_SCORERS = 0.0;

    @Getter
    @Autowired(required = false)
    private List<Scorer<T>> scorers = new ArrayList<>();

    @Override
    public double score(T data) {
        return scorers.stream()
                      .mapToDouble(scorer -> scorer.score(data))
                      .average()
                      .orElse(WITH_NO_SCORERS);
    }
}
