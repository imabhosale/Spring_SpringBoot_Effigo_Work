package com.abhi.restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.restful_web_services.Users.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
