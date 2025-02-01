package com.abhi.restful_web_services.Users;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abhi.restful_web_services.jpa.UserRepository;

@RestController
public class UserJPAResource {
	
	@Autowired
	private UserRepository repository;
		
	//Get/users
	
	@GetMapping("/jpa/users")
	public List<Users> retrievingAllUsers(){
		System.out.println("comming here");
		return repository.findAll();
	}
	
	//hateoas--entityModel
	@GetMapping("/jpa/users/{id}")
	public EntityModel<Users> retrievingUsersById(@PathVariable int id){
		Optional<Users> findById = repository.findById(id);
		if(findById.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		
		EntityModel<Users> entityModel= EntityModel.of(findById.get());
		
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retrievingAllUsers());;
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUsersById(@PathVariable int id){
			repository.deleteById(id);
	}
	
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Users> createUser(@Validated @RequestBody Users users) {
		Users savedUser= repository.save(users);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	

	
}
