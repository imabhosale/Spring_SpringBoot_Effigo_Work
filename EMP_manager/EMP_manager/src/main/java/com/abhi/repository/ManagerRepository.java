package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}