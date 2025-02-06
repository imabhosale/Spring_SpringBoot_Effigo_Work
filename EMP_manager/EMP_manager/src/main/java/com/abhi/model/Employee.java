package com.abhi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String password;
    private String empId;
    private double salary;
    private String email;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonBackReference  // Prevents infinite recursion
    private Manager manager;
}