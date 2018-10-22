package com.frod.fraudcheck.score.email;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailConsolidatorTest {

    @Autowired
    private EmailConsolidator emailConsolidator;

    @Test
    public void emailScorers() {
        assertThat(emailConsolidator.getScorers()).anySatisfy(scorer -> scorer.getClass().equals(DomainScorer.class));
    }
}
