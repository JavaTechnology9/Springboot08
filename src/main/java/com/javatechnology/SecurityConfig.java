package com.javatechnology;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EnableWebMvcSecurity
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
	Logger logger=LogManager.getLogger(SpringBoot08AmApplication.class);
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("called SecurityConfig config method ");
		// TODO Auto-generated method stub
		//auth.inMemoryAuthentication().withUser("test").password(passwordEnCoder().encode("test")).roles("USER");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEnCoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//http.authorizeRequests().anyRequest().authenticated().and().formLogin();
		http.authorizeRequests().antMatchers("/me").hasAuthority("USER")
		.antMatchers("/admin").hasAnyRole("USER","ADMIN")
		.anyRequest().permitAll()
		.and().formLogin();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEnCoder() {
		return new BCryptPasswordEncoder();
	}
	 
}
