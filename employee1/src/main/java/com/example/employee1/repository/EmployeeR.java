package com.example.employee1.repository;

import com.example.employee1.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeR extends JpaRepository<EmployeeEntity,Integer> {
}
