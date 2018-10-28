package com.frod.fraudcheck;

import com.github.javafaker.Faker;

public interface TestHelper {

    String SPRING_PROFILE = "spring.profiles.active";

    Faker FAKER = new Faker();

    default String environment() {
        return System.getProperty(SPRING_PROFILE);
    }

    default Faker faker() {
        return FAKER;
    }
}
