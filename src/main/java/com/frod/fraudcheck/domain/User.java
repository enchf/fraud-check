package com.frod.fraudcheck.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class User {
    private String phone;
    private String email;
}
