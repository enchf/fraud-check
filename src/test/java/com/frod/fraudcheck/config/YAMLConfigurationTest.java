package com.frod.fraudcheck.config;

import static org.assertj.core.api.Assertions.assertThat;

import com.frod.fraudcheck.TestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YAMLConfigurationTest implements TestHelper {

    @Autowired
    private YAMLConfiguration configuration;

    @Test
    public void configurationSet() {
        assertThat(environment()).isNotNull();
        assertThat(configuration).isNotNull();
        assertThat(configuration.getEnvironment()).isEqualTo(environment());
        assertThat(configuration.getPhoneConfiguration()).isNotNull();
    }
}
