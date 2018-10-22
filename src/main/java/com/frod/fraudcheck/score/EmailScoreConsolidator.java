package com.frod.fraudcheck.score;

import com.frod.fraudcheck.domain.Email;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("emailConsolidator")
public class EmailScoreConsolidator extends Consolidator<String> {

    private List<Scorer<Email>> emailScorers;
}
