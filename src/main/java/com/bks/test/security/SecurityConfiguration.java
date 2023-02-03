package com.bks.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
	@Autowired
	public void authConfig(AuthenticationManagerBuilder authBuilder, UserDetailsServiceImpl userDetailsService) throws Exception {

		authBuilder.userDetailsService(userDetailsService);
	}
}
