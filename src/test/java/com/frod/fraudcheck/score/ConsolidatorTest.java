package com.frod.fraudcheck.score;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ConsolidatorTest {
    private Consolidator<String> consolidator = new Consolidator<>();
    private static final double[] values = { 0.5, 0.25, 0.33 };

    @Before
    public void setup() throws Exception {
        Arrays.stream(values).forEach(val -> consolidator.getScorers().add(str -> val));
    }

    @Test
    public void consolidate() {
        assertThat(consolidator.score("")).isEqualTo(Arrays.stream(values).average().getAsDouble());
    }
}
