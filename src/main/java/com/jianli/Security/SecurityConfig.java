package com.jianli.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@EnableWebSecurity
@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	public SecurityConfig() {
		super(true);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable().addFilterBefore(new StatelessCSRFFilter(), CsrfFilter.class);
		http
		.csrf().disable()
		.exceptionHandling().and()
		.anonymous().and()
		.servletApi().and()
		.headers().cacheControl().and()
		.authorizeRequests()
						
						
		//allow anonymous resource requests
		.antMatchers("/").permitAll()
		.antMatchers("/greetingPost").permitAll()
		.antMatchers("/favicon.ico").permitAll()
		.antMatchers("/resources/**").permitAll()
		.antMatchers(HttpMethod.GET, "/**").permitAll()
		.antMatchers(HttpMethod.POST, "/**").permitAll()
		.and()
		.addFilterBefore(new StatelessCSRFFilter(), CsrfFilter.class);
		
	}
}
