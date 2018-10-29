package com.frod.fraudcheck.score.email;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.frod.fraudcheck.TestHelper;
import com.frod.fraudcheck.domain.Email;
import com.frod.fraudcheck.score.Consolidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmailScorerWrapperTest implements TestHelper {

    private static final double SCORE = 0.85;
    private static final double FAIL_SCORE = 0.0;

    @Mock
    private Consolidator<Email> consolidator;

    @InjectMocks
    private EmailScorerWrapper emailScorerWrapper;

    @Before
    public void setup() {
        when(consolidator.score(any(Email.class))).thenReturn(SCORE);
    }

    @Test
    public void score() {
        assertThat(emailScorerWrapper.score(faker().internet().emailAddress())).isEqualTo(SCORE);
    }

    @Test
    public void invalidEmail() {
        assertThat(emailScorerWrapper.score(faker().beer().malt())).isEqualTo(FAIL_SCORE);
    }
}
