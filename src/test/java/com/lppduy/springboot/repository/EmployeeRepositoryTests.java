package com.lppduy.springboot.repository;

import com.lppduy.springboot.model.Employee;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmloyeeRepository emloyeeRepository;

    @DisplayName("JUnit test for saving employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {

        Employee employee = Employee.builder()
                .firstName("Duy")
                .lastName("Le")
                .email("lppduy@gmail.com")
                .build();

        Employee savedEmployee = emloyeeRepository.save(employee);

        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @DisplayName("JUnit test for get all employees operation")
    @Test
    public void givenEmployeeList_whenFindAll_thenEmployeeList() {

        // given
        Employee employee = Employee.builder()
                .firstName("Duy")
                .lastName("Le")
                .email("lppduy@gmail.com")
                .build();

        Employee employee1 = Employee.builder()
                .firstName("Luffy")
                .lastName("Monkey D.")
                .email("nika@gmail.com")
                .build();
        emloyeeRepository.save(employee);
        emloyeeRepository.save(employee1);

        // when
        List<Employee> employeeList = emloyeeRepository.findAll();

        // then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);

    }

    @DisplayName("JUnit test for get employee by id operation")
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnSavedEmployee() {
        // given
        Employee employee = Employee.builder()
                .firstName("Duy")
                .lastName("Le")
                .email("lppduy@gmail.com")
                .build();
        emloyeeRepository.save(employee);

        // when
        Employee employeeDB = emloyeeRepository.findById(employee.getId()).get();
        // then
        assertThat(employeeDB).isNotNull();
    }
}
