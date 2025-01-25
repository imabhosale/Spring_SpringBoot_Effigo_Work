package com.abhi.MyfirstWebApp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoControntroller {
	@Autowired
	private TodoService todoService;

	@RequestMapping("list-todos")
	public String getListTodo(ModelMap model) {
		
		List<Todo> todos= todoService.findbyUserName("aniket");
		model.addAttribute("todos",todos);
		return "listTodos";
	}
}
