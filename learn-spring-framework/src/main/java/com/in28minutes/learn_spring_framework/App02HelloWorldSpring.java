package com.in28minutes.learn_spring_framework;
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
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("address2"));
		//System.out.println(context.getBean(Address.class));
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameter"));
	}

}
