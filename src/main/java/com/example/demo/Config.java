package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.example.demo.config.MyUserDetailService;


@Configuration
@EnableWebSecurity
public class Config {
	
	 @Autowired
	 private JwtFilter jwtFilter;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {
		
		return http.csrf(customizer -> customizer.disable())
		.authorizeHttpRequests(request -> request.
				requestMatchers("/register","/login").permitAll().anyRequest()
				.authenticated())
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		 .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
         .build();
	}
	
//	@Bean
//	public AuthenticationManager authenticationManager() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	    provider.setUserDetailsService(userDetailsService);
//	    provider.setPasswordEncoder(passwordEncoder);
//
//	    return new ProviderManager(provider);
//	}
	
//	  @Bean
//	    public AuthenticationProvider authenticationProvider() {
//	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//	        provider.setUserDetailsService(userDetailsService);
//
//
//	        return provider;
//	    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(12);
	}


	  
	@Bean
	public AuthenticationProvider authenticationProvider(
	        UserDetailsService userDetailsService,
	        PasswordEncoder passwordEncoder) {

	    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
	    provider.setPasswordEncoder(passwordEncoder);

	    return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(
	        AuthenticationConfiguration config) throws Exception {
	    return config.getAuthenticationManager();
	}


	



	
//	@Bean
//    public UserDetailsService userDetailsService() {
//		
//		UserDetails user1 = User.withDefaultPasswordEncoder().username("filip").password("12345").build();
//		UserDetails user2 = User.withDefaultPasswordEncoder().username("sohan").password("12345").build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
}
