package com.example.le_huy_hai_csw.service;

import com.example.le_huy_hai_csw.dto.EmployeeDto;
import com.example.le_huy_hai_csw.entity.EmployeeEntity;
import com.example.le_huy_hai_csw.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity editEmployee(int id, EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);

        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setPosition(employeeDto.getPosition());
        employeeEntity.setEmail(employeeDto.getEmail());
        employeeEntity.setPhone(employeeDto.getPhone());
        employeeEntity.setDob(employeeDto.getDob());

        return employeeRepository.save(employeeEntity);
    }
}
