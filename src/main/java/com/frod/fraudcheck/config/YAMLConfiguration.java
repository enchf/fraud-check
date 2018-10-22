package com.frod.fraudcheck.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfiguration {
    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String environment;

    @Getter
    @Setter
    private List<String> acceptedDomains;
}
