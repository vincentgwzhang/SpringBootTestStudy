package com.boraji.tutorial.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.springboot.entity.Employee;
import com.boraji.tutorial.springboot.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		employeeService.initEmployees();
		return employeeService.getAllEmployees();
	}
	
}
