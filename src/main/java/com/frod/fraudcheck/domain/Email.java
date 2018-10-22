package com.frod.fraudcheck.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Email {
    private String email;
    private String domain;
    private String account;
}
