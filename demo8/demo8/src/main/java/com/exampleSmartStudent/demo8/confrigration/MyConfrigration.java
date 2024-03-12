package com.exampleSmartStudent.demo8.confrigration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class MyConfrigration extends WebSecurityConfiguration{
	
	@Bean
	public UserDetailsService getUserDetailService() {
		return new UserDetailsSirviceImp();
	}

}
