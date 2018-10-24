package com.frod.fraudcheck.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public @Data class YAMLConfiguration {

    private String name;
    private String environment;
    private List<String> acceptedDomains;

    @NestedConfigurationProperty
    private PhoneConfiguration phoneConfiguration;
}
