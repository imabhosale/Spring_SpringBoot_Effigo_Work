package com.abhi.MyfirstWebApp.Security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SpringSecurityConfiguration {

//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails  user);

	@Bean
	public InMemoryUserDetailsManager createDetailsManager() {

		UserDetails userDetails1 = createNewUser("abhishek", "123");
		UserDetails userDetails2 = createNewUser("aniket", "123");

		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
				.roles("USER", "ADMIN").build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests(auth -> auth
	        .requestMatchers("/h2-console/**").permitAll() // Permit H2 console
	        .anyRequest().authenticated() // Protect all other endpoints
	    );

	    // Enable form-based login
	    http.formLogin(withDefaults());

	    // Disable CSRF and frame options for H2 console
	    http.csrf().disable();
	    http.headers().frameOptions().disable();

	    return http.build();
	}

}
