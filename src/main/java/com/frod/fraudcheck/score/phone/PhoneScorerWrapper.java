package com.frod.fraudcheck.score.phone;

import com.frod.fraudcheck.config.YAMLConfiguration;
import com.frod.fraudcheck.domain.Phone;
import com.frod.fraudcheck.score.Consolidator;
import com.frod.fraudcheck.score.Scorer;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Scorer for phone. Transforms the raw phone into a domain object to be validated.
 */
@Component
public class PhoneScorerWrapper implements Scorer<String> {

    @Autowired
    @Qualifier("phoneConsolidator")
    private Consolidator<Phone> consolidator;

    @Autowired
    private YAMLConfiguration configuration;

    @Override
    public double score(String phone) {
        try {
            Phonenumber.PhoneNumber phoneNumber = PhoneNumberUtil.getInstance()
                    .parse(phone, configuration.getPhoneConfiguration().getDefaultRegion());

            Phone phoneWrapper = new Phone(String.format("+%d", phoneNumber.getCountryCode()),
                                           String.valueOf(phoneNumber.getNationalNumber()),
                                           phone);
            return consolidator.score(phoneWrapper);
        } catch (NumberParseException ex) {
            return 0.0;
        }
    }
}
