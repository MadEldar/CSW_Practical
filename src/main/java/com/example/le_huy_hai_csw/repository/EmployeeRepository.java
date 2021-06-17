package com.example.le_huy_hai_csw.repository;

import com.example.le_huy_hai_csw.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
