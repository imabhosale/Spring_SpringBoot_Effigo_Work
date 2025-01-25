package com.abhi.learn_jpa_hibernate.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.abhi.learn_jpa_hibernate.Course.Course;
import com.abhi.learn_jpa_hibernate.Course.CourseJpa.CourseJpaRepo;
import com.abhi.learn_jpa_hibernate.Course.SpringDataJpa.CourseSpringDataJpa;
import com.abhi.learn_jpa_hibernate.Course.jdbc.CourseJdbcRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;

//	@Autowired
//	private CourseJpaRepo courseJpaRepo;

	@Autowired
	private CourseSpringDataJpa springDataJpa;

	@Override
	public void run(String... args) throws Exception {
		springDataJpa.save(new Course(2,"Ani","raju"));
		springDataJpa.save(new Course(1,"Aniket","aj"));
		springDataJpa.save(new Course(3,"Rushi","Ok"));
		
//		System.out.println(springDataJpa.findAll());
//		springDataJpa.delete(new Course(3,"Rushi","Ok"));
//		springDataJpa.findByAuthor("ok");
		springDataJpa.findByAuthor(null);
//		System.out.println(springDataJpa.findAll());
		springDataJpa.findByName("Rushi");

	}

}
