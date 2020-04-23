package com.javatechnology;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(args = "app.test=one")
class SpringBoot08AmApplicationTests {
	@Autowired
	private ApplicationArguments arguments;

	@Test
	void contextLoads() {
		assertThat(arguments.getOptionNames().contains("app.test"));
		assertThat(arguments.getNonOptionArgs().contains("app"));
	}

}
