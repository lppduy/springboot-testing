package com.lppduy.springboot.repository;

import com.lppduy.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmloyeeRepository extends JpaRepository<Employee, Long> {
}
