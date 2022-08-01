package com.kit.pos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kit.pos.service.impl.UserServiceImpl;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired private UserServiceImpl userService;
	@Autowired private JwtRequestFilter jwtRequestFilter;
	@Autowired private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/api/kitpos/authenticate").permitAll();
		http.authorizeRequests().antMatchers("/api/kitpos/business/**").permitAll();
		http.authorizeRequests().antMatchers("/swagger-ui.html").permitAll();
		http.authorizeRequests().antMatchers("/webjars/**").permitAll();
		http.authorizeRequests().antMatchers("/swagger-resources/**").permitAll();
		http.authorizeRequests().antMatchers("/v2/api-docs/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}