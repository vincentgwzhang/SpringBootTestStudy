package com.boraji.tutorial.springboot.service;

import com.boraji.tutorial.springboot.entity.Employee;
import com.boraji.tutorial.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}
