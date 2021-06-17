package com.example.le_huy_hai_csw.dto;

import com.example.le_huy_hai_csw.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MapperDto {
    EmployeeEntity convertToEmployeeEntity(EmployeeDto employeeDto);

    EmployeeDto convertToEmployeeDto(EmployeeEntity employeeEntity);
}
