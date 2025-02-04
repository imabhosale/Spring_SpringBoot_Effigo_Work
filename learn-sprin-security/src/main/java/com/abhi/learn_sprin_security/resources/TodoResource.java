package com.abhi.learn_sprin_security.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class TodoResource {
	private Logger logger;
	
	private static final List<Todo> TODOS_LIST = List.of(new Todo("Learn AWS","It is nice aws course"),
			new Todo("Learn AWS","It is nice aws course"));


	@GetMapping("/todos")
	public List<Todo> retrieveAllTodos() {
		return TODOS_LIST;
	}
	
	
	@GetMapping("user/{username}/todos")
	public Todo helloWorld(@PathVariable String username) {
		return TODOS_LIST.get(0);
	}
	
	@PostMapping("user/{username}/todos")
	public void postmethod(@PathVariable String username,@RequestBody Todo todo) {
		logger.info("Create {} for {}",todo,username);
	}

}


record Todo(String username,String description){}
