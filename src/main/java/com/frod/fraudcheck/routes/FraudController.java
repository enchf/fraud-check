package com.frod.fraudcheck.routes;

import com.frod.fraudcheck.config.YAMLConfiguration;
import com.frod.fraudcheck.domain.User;
import com.frod.fraudcheck.score.Scorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main controller that helps to test the scoring system.
 */
@RestController
public class FraudController {

    public static final String UP_AND_RUNNING = "Up and running in %s environment...\n";
    public static final String PHONE_SCORER_QUALIFIER = "phoneScorerWrapper";
    public static final String EMAIL_SCORER_QUALIFIER = "emailScorerWrapper";

    @Autowired
    @Qualifier(PHONE_SCORER_QUALIFIER)
    private Scorer<String> phoneScorer;

    @Autowired
    @Qualifier(EMAIL_SCORER_QUALIFIER)
    private Scorer<String> emailScorer;

    @Autowired
    private YAMLConfiguration config;

    @GetMapping("/health")
    public String health() {
        return String.format(UP_AND_RUNNING, config.getEnvironment());
    }

    @GetMapping(value = "/fraud-check", produces = "application/json")
    public ScoreResponse fraudEvaluation(@RequestParam(value = "phone") String phone,
                                         @RequestParam(value = "email") String email) {
        return new ScoreResponse(phoneScorer.score(phone), emailScorer.score(email));
    }

}
