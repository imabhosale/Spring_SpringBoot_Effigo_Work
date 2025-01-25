package com.abhi.learn_jpa_hibernate.Course.SpringDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.learn_jpa_hibernate.Course.Course;

public interface CourseSpringDataJpa extends JpaRepository<Course, Long>{
	List<Course>  findByAuthor(String author);
	
	List<Course> findByName(String name);
	

}
