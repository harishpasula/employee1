package com.example.employee1.repository;

import com.example.employee1.entity.EmployeeAttendenceE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeAttendenceR extends JpaRepository<EmployeeAttendenceE,Integer> {
    @Query(value = "select * from EMPLOYEE_ATTENDENCEE where date is like %jan%",nativeQuery = true)
    List<EmployeeAttendenceE> getEmployee();
}
