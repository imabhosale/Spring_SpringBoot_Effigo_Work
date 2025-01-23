package com.abhi.springboot.Learn_spring_boot;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@GetMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(new Course(1,"Learn AWS","Abhishek"),
				new Course(2,"Learn Java","aniket"),
				new Course(3,"Learn DevOps","kunal"),
				new Course(2,"Learn Azure","virat"));
	}
}
