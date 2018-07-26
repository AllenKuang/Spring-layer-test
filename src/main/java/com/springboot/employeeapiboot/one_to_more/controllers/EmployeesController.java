package com.springboot.employeeapiboot.one_to_more.controllers;

import com.springboot.employeeapiboot.one_to_more.entities.Employee;
import com.springboot.employeeapiboot.one_to_more.respositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employess")
public class EmployeesController {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeesController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @PostMapping("")
    public List<Employee> addEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return employeeRepository.findAll();
    }
}
