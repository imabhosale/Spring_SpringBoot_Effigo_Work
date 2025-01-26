package com.abhi.MyfirstWebApp.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails  user);
	
	@Bean
	public InMemoryUserDetailsManager createDetailsManager() {
		UserDetails userDetails = User.withDefaultPasswordEncoder()
		.username("abhishek")
		.password("123")
		.roles("USER","ADMIN")
		.build();
		
		return new InMemoryUserDetailsManager(userDetails);
	}

}
