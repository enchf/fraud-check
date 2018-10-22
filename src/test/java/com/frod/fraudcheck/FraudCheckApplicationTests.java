package com.frod.fraudcheck;

import static org.assertj.core.api.Assertions.assertThat;

import com.frod.fraudcheck.routes.FraudController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FraudCheckApplicationTests {

	@Autowired
    private FraudController fraudController;

	@Test
	public void contextLoads() {
        assertThat(fraudController).isNotNull();
	}
}
