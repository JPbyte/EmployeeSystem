package com.example.EmployeeSystem.mapper;

import com.example.EmployeeSystem.dto.EmployeeDTO;
import com.example.EmployeeSystem.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee emp){
        return new EmployeeDTO(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail()
        );
    }

    public static  Employee mapToEmployee(EmployeeDTO empDTO){
        return new Employee(
                empDTO.getId(),
                empDTO.getFirstName(),
                empDTO.getLastName(),
                empDTO.getEmail()
        );
    }
}
