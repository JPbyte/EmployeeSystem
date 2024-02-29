package com.example.EmployeeSystem.service.impl;

import com.example.EmployeeSystem.dto.EmployeeDTO;
import com.example.EmployeeSystem.entity.Employee;
import com.example.EmployeeSystem.mapper.EmployeeMapper;
import com.example.EmployeeSystem.repository.EmployeeRepository;
import com.example.EmployeeSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceIMPL  implements EmployeeService {
    private EmployeeRepository empRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO empDTO){
        Employee emp = EmployeeMapper.mapToEmployee(empDTO);
        Employee saveEmp = empRepository.save(emp);
        return EmployeeMapper.mapToEmployeeDTO(saveEmp);

    }
}