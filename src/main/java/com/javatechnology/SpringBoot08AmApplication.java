package com.javatechnology;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class,SecurityFilterAutoConfiguration.class })*/
@EnableWebSecurity
//@ComponentScan("java.technology")
public class SpringBoot08AmApplication {

	public static void main(String[] args) {
		Logger logger=LogManager.getLogger(SpringBoot08AmApplication.class);
		logger.info("called SpringBoot08AmApplication main method ");
		ConfigurableApplicationContext run = SpringApplication.run(SpringBoot08AmApplication.class, args);
		for(String beanInfo:run.getBeanDefinitionNames()) {
			System.out.println("Bean Information.........> " + beanInfo);
		}
		for(String str:args) {
			System.out.println("main method arguments---> " +str);
		
		}
		
	}

}
