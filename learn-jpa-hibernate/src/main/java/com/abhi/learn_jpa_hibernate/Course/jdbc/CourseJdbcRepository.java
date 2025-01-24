package com.abhi.learn_jpa_hibernate.Course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abhi.learn_jpa_hibernate.Course.Course;

@Repository
public class CourseJdbcRepository {
	

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String iNSERT_QUERRY = """

			insert into course (id, name, author) values (?,?,?);
						""";
	
	private static String Delete_QUERRY = """

			delete from course where id= ?;
						""";
	private static String Select_QUERRY = """

			select * from course where id = ?;
						""";

	public void insert(Course course) {
		springJdbcTemplate.update(iNSERT_QUERRY,
				course.getId(),course.getName(),course.getAuthor());
	}
	
	public void deleteCourse(long id) {
		springJdbcTemplate.update(Delete_QUERRY,id);
	}
	
	public Course findbyId(long id) {
	Course course=	springJdbcTemplate.queryForObject(Select_QUERRY,new BeanPropertyRowMapper<>(Course.class),id);
		//resultset -> bean mapping  ==> Row Mapper
	return course;
	}
}
