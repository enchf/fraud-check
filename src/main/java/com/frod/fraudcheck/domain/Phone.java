package com.frod.fraudcheck.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Phone {
    private String countryCode;
    private String phoneNumber;
    private String rawNumber;
}
