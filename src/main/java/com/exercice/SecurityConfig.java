package com.exercice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder()); 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").hasAnyRole("USER","ADMIN")
				.antMatchers("/console/**").hasRole("ADMIN")
				.antMatchers("/registerpage").permitAll()
				.and()
				.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/userdb")
				.permitAll()
				.and()
				.csrf().ignoringAntMatchers("/console/**")
				.and()				
				.headers().frameOptions().sameOrigin().and().logout().permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/accessdenied");
	}

}
