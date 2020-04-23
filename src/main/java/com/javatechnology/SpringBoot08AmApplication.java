package com.javatechnology;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import com.javatechnology.exception.MyErrorViewResolver;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class,SecurityFilterAutoConfiguration.class })*/
//@EnableWebSecurity
//@ComponentScan("java.technology")
@EnableJms
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
	@Bean
	public ActiveMQConnectionFactory getFactory () {
		ActiveMQConnectionFactory factory =new ActiveMQConnectionFactory();
		factory.setTrustAllPackages(true);
		return factory;
		
	}
	
}
