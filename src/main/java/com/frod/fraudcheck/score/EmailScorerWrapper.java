package com.frod.fraudcheck.score;

import com.frod.fraudcheck.domain.Email;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailScorerWrapper implements Scorer<String> {

    @Autowired
    @Qualifier("emailConsolidator")
    private Consolidator<Email> consolidator;

    @Override
    public double score(String email) {
        double score;
        int atIndex;
        Email emailWrapper;

        if (EmailValidator.getInstance().isValid(email)) {
            atIndex = email.indexOf('@');
            emailWrapper = new Email(email, email.substring(atIndex + 1), email.substring(0, atIndex));
            score = consolidator.score(emailWrapper);
        } else {
            score = 0.0;
        }

        return score;
    }
}
