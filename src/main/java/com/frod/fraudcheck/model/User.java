package com.frod.fraudcheck.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class User {
    private String phone;
    private String email;
}
