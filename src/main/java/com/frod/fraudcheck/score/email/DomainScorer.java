package com.frod.fraudcheck.score.email;

import com.frod.fraudcheck.config.YAMLConfiguration;
import com.frod.fraudcheck.domain.Email;
import com.frod.fraudcheck.score.Scorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DomainScorer implements Scorer<Email> {

    @Autowired
    private YAMLConfiguration configuration;

    @Override
    public double score(Email email) {
        return configuration.getAcceptedDomains().contains(email.getDomain()) ? 1.0 : 0.0;
    }
}
