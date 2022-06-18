package com.boraji.tutorial.springboot.controller;

import com.boraji.tutorial.springboot.utils.UtilTools;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.springboot.entity.Employee;
import com.boraji.tutorial.springboot.service.EmployeeService;

@RestController
@RequestMapping("emp")
@Slf4j
public class EmployeeRestController {

	@Autowired
	private UtilTools utilTools;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		log.info("utilTools.var1 = {}, utilTools.var2 = {}", utilTools.getVar1(), utilTools.getVar2());
		return employeeService.getAllEmployees();
	}

	@PostMapping
	public Employee insertEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
}
