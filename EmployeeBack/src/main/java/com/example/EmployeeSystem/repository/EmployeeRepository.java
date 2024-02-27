package com.example.EmployeeSystem.repository;

import com.example.EmployeeSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
