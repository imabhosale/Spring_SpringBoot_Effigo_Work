package com.abhi.MyfirstWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoControntroller {
	@Autowired
	private TodoService todoService;
	

	@RequestMapping("list-todos")
	public String getListTodo(ModelMap model) {
		
		String userName=getLoggedInUsername(model);
		List<Todo> todos= todoService.findbyUserName(userName);
		model.addAttribute("todos",todos);
		return "listTodos";
	}
	
	@RequestMapping( value = "add-todo", method = RequestMethod.GET)
	public String ShowNewTodoPage(ModelMap model) {
		String userName=getLoggedInUsername(model);
		Todo todo=new Todo(0,userName,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}

	
	@RequestMapping( value = "add-todo", method = RequestMethod.POST)
	public String AddNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		todoService.addTodo(
				getLoggedInUsername(model),
				todo.getDescription(),todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//delete this todo
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		Todo todo= todoService.findById(id);
		//delete this todo
//		todoService.deleteById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	
	@RequestMapping( value = "update-todo", method = RequestMethod.POST)
	public String updateNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoService.updateTo(todo);
		return "redirect:list-todos";
	}
	

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
}
