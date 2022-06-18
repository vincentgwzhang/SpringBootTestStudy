package com.boraji.tutorial.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.boraji.tutorial.springboot.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class EmployeeRepositoryIntegrationTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Test
  void whenFindByName_thenReturnEmployee() {

    //give
    Employee alex = new Employee("alex");
    entityManager.persist(alex);
    entityManager.flush();

    //when
    Employee found = employeeRepository.findByName(alex.getName());

    assertThat(found.getName()).isEqualTo(alex.getName());
  }

}
