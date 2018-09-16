package com.boraji.tutorial.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.boraji.tutorial.springboot.entity.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
		
		//give
		Employee alex = new Employee("alex");
		entityManager.persist(alex);
		entityManager.flush();
		
		//when
		Employee found = employeeRepository.findByName(alex.getName());
		
		assertThat(found.getName()).isEqualTo(alex.getName());
	}
	
}
