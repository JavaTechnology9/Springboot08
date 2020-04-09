package com.javatechnology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class,SecurityFilterAutoConfiguration.class })*/
@EnableWebSecurity
//@ComponentScan("java.technology")
public class SpringBoot08AmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot08AmApplication.class, args);
	}

}
