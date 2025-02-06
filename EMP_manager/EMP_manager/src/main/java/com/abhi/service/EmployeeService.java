package com.abhi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.dto.EmployeeDTO;
import com.abhi.exception.EmployeeNotFoundException;
import com.abhi.model.Employee;
import com.abhi.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        System.out.println("coming to add");
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
            .map(employee -> {
                System.out.println("Employee found: " + employee.getName());
                return modelMapper.map(employee, EmployeeDTO.class);
            })
            .orElseThrow(() -> {
                String errorMessage = "Error: Employee with ID " + id + " not found.";
                System.err.println(errorMessage);
                return new EmployeeNotFoundException(errorMessage);
            });
    }


    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
