package com.boraji.tutorial.springboot.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.boraji.tutorial.springboot.entity.Employee;
import com.boraji.tutorial.springboot.service.EmployeeService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EmployeeRestController.class)
public class EmployeeRestControllerMockTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private EmployeeService employeeService;

  @Test
  public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {
    Employee alex = new Employee("alex");

    List<Employee> allEmployees = Arrays.asList(alex);

    given(employeeService.getAllEmployees()).willReturn(allEmployees);

    mvc.perform(get("/emp").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].name", equalTo(alex.getName())));

    verify(employeeService).getAllEmployees();
  }

}
