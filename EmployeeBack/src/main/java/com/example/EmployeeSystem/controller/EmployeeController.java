package com.example.EmployeeSystem.controller;

import com.example.EmployeeSystem.dto.EmployeeDTO;
import com.example.EmployeeSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService empService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO empDTO){
        EmployeeDTO savedEmp = empService.createEmployee(empDTO);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }
}
