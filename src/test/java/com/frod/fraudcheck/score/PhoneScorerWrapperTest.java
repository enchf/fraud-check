package com.frod.fraudcheck.score;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.frod.fraudcheck.TestHelper;
import com.frod.fraudcheck.config.PhoneConfiguration;
import com.frod.fraudcheck.config.YAMLConfiguration;
import com.frod.fraudcheck.domain.Phone;
import com.frod.fraudcheck.score.phone.PhoneScorerWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PhoneScorerWrapperTest implements TestHelper {

    private static final String PHONE_REGION = "MX";
    private static final double SCORE = 0.75;
    private static final double FAIL_SCORE = 0.0;

    @Mock
    private Consolidator<Phone> consolidator;

    @Mock
    private YAMLConfiguration yamlConfiguration;

    @InjectMocks
    private PhoneScorerWrapper phoneScorerWrapper;

    @Before
    public void setup() {
        PhoneConfiguration phoneConfiguration = new PhoneConfiguration(PHONE_REGION);
        when(yamlConfiguration.getPhoneConfiguration()).thenReturn(phoneConfiguration);
        when(consolidator.score(any(Phone.class))).thenReturn(SCORE);
    }

    @Test
    public void score() {
        assertThat(phoneScorerWrapper.score(faker().phoneNumber().cellPhone())).isEqualTo(SCORE);
    }

    @Test
    public void invalidPhone() {
        assertThat(phoneScorerWrapper.score(faker().chuckNorris().fact())).isEqualTo(FAIL_SCORE);
    }
}
