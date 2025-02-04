package com.abhi.learn_sprin_security.resources;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityPlayResource {
	
	
	
	@GetMapping("/csrf-token")
	public CsrfToken retrieveCsrfTocken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
