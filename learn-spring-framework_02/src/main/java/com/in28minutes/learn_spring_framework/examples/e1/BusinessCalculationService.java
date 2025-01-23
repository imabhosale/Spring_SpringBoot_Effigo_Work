package com.in28minutes.learn_spring_framework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BusinessCalculationService {

	private DataService dataService;

	public BusinessCalculationService(@Qualifier("MysqlDataServiceQualifier") DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findMax() {

		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

	

}
