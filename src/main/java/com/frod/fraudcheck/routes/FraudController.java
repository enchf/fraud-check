package com.frod.fraudcheck.routes;

import com.frod.fraudcheck.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudController {

    @GetMapping("/health")
    public String health() {
        return "Up and running...";
    }

    @GetMapping("/fraud-check")
    public String fraudEvaluation(@RequestParam(value = "phone") String phone,
                                  @RequestParam(value = "email") String email) {
        return new User(phone, email).toString();
    }

}
