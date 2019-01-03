/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright Benchmark	All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * DEC 17 2018		: BEC       : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.socratesrpt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
@PropertySource(value = "custom.properties", ignoreResourceNotFound = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Value("${socrates.api.user}")
    private String user;
    
    @Value("${socrates.api.password}")
    private String password;
    
    @Value("${socrates.api.admin}")
    private String admin;

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser(user).password(password).roles("USER").and()
				.withUser(admin).password(password).roles("USER","ADMIN");
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	    http
          .authorizeRequests()
          .antMatchers("/api/**").hasAnyRole("ADMIN","USER").and()
          .httpBasic()
          .and()
		  .csrf().disable();		   
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
