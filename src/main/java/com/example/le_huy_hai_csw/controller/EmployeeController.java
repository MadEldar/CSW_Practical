package com.example.le_huy_hai_csw.controller;

import com.example.le_huy_hai_csw.dto.EmployeeDto;
import com.example.le_huy_hai_csw.dto.MapperDto;
import com.example.le_huy_hai_csw.entity.EmployeeEntity;
import com.example.le_huy_hai_csw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    MapperDto mapper;

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employees = employeeService.getAllEmployees();

        if (employees.isEmpty()) {
            employeeService.createEmployee(new EmployeeEntity("Le Huy Hai", "Software Engineer", "hhl@gmail.com", "0941688077", new Date(98, Calendar.JANUARY, 6)));
            employeeService.createEmployee(new EmployeeEntity("Truong Cong Vinh", "Software Engineer", "vtc@gmail.com", "0938139308", new Date(101, Calendar.FEBRUARY, 7)));
            employees = employeeService.getAllEmployees();
        }

        return employees.stream().map(emp -> mapper.convertToEmployeeDto(emp)).collect(Collectors.toList());
    }

    @PostMapping
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = mapper.convertToEmployeeEntity(employeeDto);

        EmployeeEntity createdEmployee = employeeService.createEmployee(employeeEntity);

        return mapper.convertToEmployeeDto(createdEmployee);
    }

    @PutMapping("{id}")
    public EmployeeDto editEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeService.editEmployee(id, employeeDto);

        return mapper.convertToEmployeeDto(employeeEntity);
    }
}
