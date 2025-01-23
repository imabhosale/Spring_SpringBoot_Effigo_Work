package com.abhi.springboot.Learn_spring_boot;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	private CurrencyServiceConfiguration configuration;
	
	@GetMapping("/currency-configuration")
	public CurrencyServiceConfiguration retrieveAllCourses(){
		return configuration;
	}
}
