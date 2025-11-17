package com.anganwadi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired 
	private UserDetailsService userDetailsService;
	 
	public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth-> auth
					.requestMatchers("/login/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll()
					.requestMatchers("/login", "/error").permitAll()
					.requestMatchers("/WEB-INF/**").permitAll() 																																																	// LINE
					.requestMatchers("/teacher/dashboard").hasRole("TEACHER")
					.requestMatchers("/assistant/dashboard").hasRole("ASSISTANT")
					.anyRequest().authenticated()
				)
				.formLogin(form->form
					.loginPage("/login")
					.defaultSuccessUrl("/default", true)
					.failureUrl("/login?error=true")
					.permitAll()
				)
				.logout(logout -> logout
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				);
		return httpSecurity.build();
	}

	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	

}