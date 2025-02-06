package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}