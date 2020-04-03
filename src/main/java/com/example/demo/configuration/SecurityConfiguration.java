package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.service.LoginValidation;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginValidation loginLValidation;

	public SecurityConfiguration(LoginValidation loginValidation) {
		this.loginLValidation = loginValidation;

	}
	 @Override protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception { // TODO Auto-generated method stub
	  auth.authenticationProvider(authenticationProvider());
	  
	  }
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 // TODO Auto-generated method stub
         //http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		 // http.authorizeRequests().antMatchers("/index1").hasRole("ADMIN").antMatchers("/index2").hasAnyRole("ADMIN","USER").and().httpBasic();
		http.authorizeRequests().antMatchers( "/addUser").permitAll().antMatchers("/getUsers","/getLoggedInUser").hasAuthority("ADMIN").and().httpBasic();

	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(loginLValidation);
		return authenticationProvider;
	
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

}
