package com.frod.fraudcheck.routes;

import com.frod.fraudcheck.FraudCheckApplication;
import com.frod.fraudcheck.TestHelper;
import com.frod.fraudcheck.score.Scorer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { FraudCheckApplication.class, FraudControllerTest.FraudControllerTestConfiguration.class })
public class FraudControllerTest implements TestHelper {

    private static final double SCORE_VALUE = 1.0;
    private static final Scorer<String> DEFAULT_SCORER = (str -> SCORE_VALUE);

    @Autowired
    private FraudController fraudController;

    @Test
    public void consolidatorsSet() {
        assertThat(fraudController).hasNoNullFieldsOrProperties();
    }

    @Test
    public void health() {
        String message = String.format(FraudController.UP_AND_RUNNING, environment());
        assertThat(fraudController.health()).isEqualTo(message);
    }

    @Test
    public void fraudEvaluation() {
        String phone = faker().phoneNumber().phoneNumber();
        String email = faker().internet().emailAddress();
        ScoreResponse response = new ScoreResponse(SCORE_VALUE, SCORE_VALUE);

        assertThat(fraudController.fraudEvaluation(phone, email)).isEqualTo(response);
    }

    @Configuration
    static class FraudControllerTestConfiguration {
        @Bean
        @Qualifier(FraudController.PHONE_SCORER_QUALIFIER)
        public Scorer<String> phoneScorer() {
            return DEFAULT_SCORER;
        }

        @Bean
        @Qualifier(FraudController.EMAIL_SCORER_QUALIFIER)
        public Scorer<String> emailScorer() {
            return DEFAULT_SCORER;
        }
    }
}
