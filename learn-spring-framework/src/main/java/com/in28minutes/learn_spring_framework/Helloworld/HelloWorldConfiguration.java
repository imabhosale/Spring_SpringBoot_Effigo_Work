package com.in28minutes.learn_spring_framework.Helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Abhishek";
	}

	@Bean
	public int age() {
		return 22;
	}

	@Bean
	public Person person() {
		var person = new Person("Aniket", 20, new Address("Bommanahlli shivani pg", "Bangalore"));
		// no need to define constructor, getters, setters , etc for record
		return person;
	}

	@Bean
	public Person person2MethodCall() { //method calls
		var person = new Person(name(), age(), address());
		return person;
	}

	@Bean  //by passing parameters
	public Person person3Parameter(String name, int age, Address address3) { // name, age, address2
		var person = new Person(name, age, address3);
		return person;
	}

	@Bean(name = "address2")
	public Address address() {
		var address = new Address("Bommanahlli shivani pg", "Bangalore");
		return address;
	}
	
	@Bean(name = "address3")
	@Primary
	public Address address2() {
		var address = new Address("alandi pune", "Pune");
		return address;
	}
}
