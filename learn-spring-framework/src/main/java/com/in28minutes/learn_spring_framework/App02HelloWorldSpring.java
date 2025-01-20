package com.in28minutes.learn_spring_framework;

import java.util.jar.Attributes.Name;

import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration.AnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	public static void main(String[] args) {
		// 01: launch a spring context

		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		// 02:  
		//Configure the things that we want to spring should manage
		// @Configuration Class
		//We created HelloWorldConfiguration class @Configuration
		//name @Bean
		
		//03 retrieving Bean
		System.out.println(context.getBean("name"));
	}

}
