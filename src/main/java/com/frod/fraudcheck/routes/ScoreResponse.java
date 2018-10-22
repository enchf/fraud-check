package com.frod.fraudcheck.routes;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class ScoreResponse {
    private double phoneScore;
    private double emailScore;
}
