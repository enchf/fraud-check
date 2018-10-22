package com.frod.fraudcheck.score;

import org.springframework.stereotype.Component;

@Component("phoneConsolidator")
public class PhoneScoreConsolidator implements Scorer<String> {

    @Override
    public double score(String data) {
        return 0;
    }
}
