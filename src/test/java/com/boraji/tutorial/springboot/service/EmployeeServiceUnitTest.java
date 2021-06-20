package com.boraji.tutorial.springboot.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.boraji.tutorial.springboot.entity.Employee;
import com.boraji.tutorial.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class EmployeeServiceUnitTest {

  @Autowired
  private EmployeeService employeeService;

  @MockBean
  private EmployeeRepository employeeRepository;

  private final String employeeName = "alex";

  @BeforeEach
  public void setUp() {
    Employee alex = new Employee(employeeName);
    Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
  }

  @Test
  public void whenValidName_thenEmployeeShouldBeFound() {
    Employee found = employeeService.getEmployeeByName(employeeName);
    assertThat(found.getName()).isEqualTo(employeeName);
  }
}
