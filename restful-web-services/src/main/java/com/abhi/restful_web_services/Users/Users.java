package com.abhi.restful_web_services.Users;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity(name="user_details")
public class Users {
	
	protected Users() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	//@JsonProperty("user_name")  //customize the elment filed for json
	private String name;
	
	@JsonProperty("birth_date")
	private LocalDate birthDate;
	
	
	@OneToMany(mappedBy = "users")
	private List<Post> posts;
	
	public Users(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
