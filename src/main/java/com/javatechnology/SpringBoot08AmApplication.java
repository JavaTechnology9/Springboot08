package com.javatechnology;

import javax.persistence.EntityManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.javatechnology.exception.MyErrorViewResolver;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class,SecurityFilterAutoConfiguration.class })*/
//@EnableWebSecurity
//@ComponentScan("java.technology")
public class SpringBoot08AmApplication {

	public static void main(String[] args) {
		Logger logger=LogManager.getLogger(SpringBoot08AmApplication.class);
		logger.info("called SpringBoot08AmApplication main method ");
		ConfigurableApplicationContext run = SpringApplication.run(SpringBoot08AmApplication.class, args);
		/*
		 * for(String beanInfo:run.getBeanDefinitionNames()) {
		 * System.out.println("Bean Information.........> " + beanInfo); }
		 */
		/*
		 * for(String str:args) { System.out.println("main method arguments---> " +str);
		 * 
		 * }
		 */
		
	}
	/*@Bean
	public PropertySourcesPlaceholderConfigurer configurer() {
		PropertySourcesPlaceholderConfigurer configurer= new PropertySourcesPlaceholderConfigurer();
		Resource resource= new ClassPathResource("spring.properties");
		configurer.setLocation(resource);
		return configurer;
		
	}*/
	@Bean
	public ErrorViewResolver viewResolver() {
		return new MyErrorViewResolver();
	}
	/*@Bean
	public HibernateJpaSessionFactoryBean getSessionFactory(EntityManagerFactory entityManagerFactory) {
		HibernateJpaSessionFactoryBean factoryBean=new HibernateJpaSessionFactoryBean();
		factoryBean.setEntityManagerFactory(entityManagerFactory);
		return factoryBean;
		
	}*/
	
	
}
