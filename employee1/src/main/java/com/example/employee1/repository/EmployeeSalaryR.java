package com.example.employee1.repository;

import com.example.employee1.entity.EmployeeSalaryE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSalaryR extends JpaRepository<EmployeeSalaryE,Integer> {
    List<EmployeeSalaryE> findByPayableIgnoreCase(String payable);
}
