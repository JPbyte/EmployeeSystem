package com.example.EmployeeSystem.service.impl;

import com.example.EmployeeSystem.dto.EmployeeDTO;
import com.example.EmployeeSystem.entity.Employee;
import com.example.EmployeeSystem.exception.ResourceNotFoundExcepion;
import com.example.EmployeeSystem.mapper.EmployeeMapper;
import com.example.EmployeeSystem.repository.EmployeeRepository;
import com.example.EmployeeSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override       
    public EmployeeDTO getEmployeeById(Long empId) {
        Employee employee = empRepository.findById(empId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + empId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> emp = empRepository.findAll();
        return emp.stream().map(EmployeeMapper::mapToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updateEmp) {
        Employee emp = empRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        emp.setFirstName(updateEmp.getFirstName());
        emp.setLastName(updateEmp.getLastName());
        emp.setEmail(updateEmp.getEmail());

        Employee updateEmpObj = empRepository.save(emp);

        return EmployeeMapper.mapToEmployeeDTO(updateEmpObj);
    }


    @Override
    public void deleteEmployee(Long empId){

        Employee emp = empRepository.findById(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + empId)
        );

        empRepository.deleteById(empId);
    }
}
