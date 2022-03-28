package com.example.employee1.repository;

import com.example.employee1.entity.EmployeeAddressE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeAddressR extends JpaRepository<EmployeeAddressE,Integer> {
    List<EmployeeAddressE> findByCountryIgnoreCase(String country);

    List<EmployeeAddressE> findByCityOrCityIgnoreCase(String city1, String city2);

    List<EmployeeAddressE> findByCityAndCountryIgnoreCase(String city, String country);
}
