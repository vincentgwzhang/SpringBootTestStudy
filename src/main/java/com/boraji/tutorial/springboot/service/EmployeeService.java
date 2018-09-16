package com.boraji.tutorial.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.springboot.entity.Employee;
import com.boraji.tutorial.springboot.repository.EmployeeRepository;
import com.google.common.collect.Lists;

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
	
	public void initEmployees() {
		Employee emp1 = new Employee("emp1");
		Employee emp2 = new Employee("emp2");
		
		employeeRepository.saveAll(Lists.newArrayList(emp1, emp2));
	}
}
