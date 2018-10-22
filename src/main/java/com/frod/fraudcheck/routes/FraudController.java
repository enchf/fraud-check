package com.frod.fraudcheck.routes;

import com.frod.fraudcheck.config.YAMLConfiguration;
import com.frod.fraudcheck.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudController {

    @Autowired
    private YAMLConfiguration config;

    @GetMapping("/health")
    public String health() {
        return String.format("Up and running in %s environment...\n", config.getEnvironment());
    }

    @GetMapping("/fraud-check")
    public String fraudEvaluation(@RequestParam(value = "phone") String phone,
                                  @RequestParam(value = "email") String email) {
        return new User(phone, email).toString();
    }

}
