package com.frod.fraudcheck.score;

import org.springframework.stereotype.Component;

@Component("emailConsolidator")
public class EmailScoreConsolidator implements Scorer<String> {

    @Override
    public double score(String data) {
        return 0;
    }
}
