package com.abhi.MyfirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List< Todo > todos=new ArrayList<>();
	
	static {
		todos.add(new Todo(1,"abhishek","Learn java",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(2,"aniket","Learn aws",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(3,"piyush","Learn python",LocalDate.now().plusYears(3),false));

	}
	
	public List<Todo> findbyUserName(String username) {
		return todos;
	}

}
