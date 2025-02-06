package com.abhi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"employees"})
public class ManagerDTO {
    private Long id;
    private String name;
    private String manId;
    private double salary;
    private String email;
    
    
}