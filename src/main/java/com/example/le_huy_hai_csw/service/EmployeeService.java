package com.example.le_huy_hai_csw.service;

import com.example.le_huy_hai_csw.dto.EmployeeDto;
import com.example.le_huy_hai_csw.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity createEmployee(EmployeeEntity employeeEntity);
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity editEmployee(int id, EmployeeDto employeeDto);
}
