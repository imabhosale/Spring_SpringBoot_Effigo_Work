package com.abhi.restful_web_services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
//	@RequestMapping(value = "/hello-world",method = RequestMethod.GET)
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello-World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloworldBeam() {
		return new HelloWorldBean("Hello-World");
	}
	
	@GetMapping("/hello-world/pathvariable/{name}")
	public HelloWorldBean helloworldPathvariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello-World ,%s",name));
	}
}
