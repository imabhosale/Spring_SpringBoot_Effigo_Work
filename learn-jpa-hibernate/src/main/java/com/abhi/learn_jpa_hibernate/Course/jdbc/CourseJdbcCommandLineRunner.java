package com.abhi.learn_jpa_hibernate.Course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.abhi.learn_jpa_hibernate.Course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository courseJdbcRepository;
	
	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert(new Course (1,"Java author","java1"));
		courseJdbcRepository.insert(new Course (2,"Java author2","java2"));
		courseJdbcRepository.insert(new Course (3,"Java author3","java3"));
		courseJdbcRepository.deleteCourse(2);
		System.out.println(courseJdbcRepository.findbyId(1));
//		System.out.println(courseJdbcRepository.findbyId(2));
		
	}

}
