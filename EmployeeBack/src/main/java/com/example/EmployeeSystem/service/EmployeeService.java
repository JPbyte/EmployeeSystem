package com.example.EmployeeSystem.service;

import com.example.EmployeeSystem.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO empDTO);


    EmployeeDTO getEmployeeById(Long empId);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updateEmp);

    void deleteEmployee(Long employeeId);
}
