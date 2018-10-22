package com.frod.fraudcheck.score;

import com.frod.fraudcheck.domain.Phone;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("phoneConsolidator")
public class PhoneScoreConsolidator extends Consolidator<String> {

    private List<Scorer<Phone>> emailScorers;
}
