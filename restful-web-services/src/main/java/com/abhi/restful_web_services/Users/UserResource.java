package com.abhi.restful_web_services.Users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	
	
	@Autowired
	private UserDaoService userDaoService;
	//Get/users
	
	@GetMapping("/users")
	public List<Users> retrievingAllUsers(){
		return userDaoService.findAll();
	}
	
	//hateoas--entityModel
	@GetMapping("/users/{id}")
	public EntityModel<Users> retrievingUsersById(@PathVariable int id){
		Users findById = userDaoService.findById(id);
		if(findById==null) {
			throw new UserNotFoundException("id:"+id);
		}
		
		EntityModel<Users> entityModel= EntityModel.of(findById);
		
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retrievingAllUsers());;
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUsersById(@PathVariable int id){
		 userDaoService.deleteById(id);
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Users> createUser(@Validated @RequestBody Users users) {
		Users savedUser= userDaoService.saveUser(users);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	
}
