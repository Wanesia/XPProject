package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
