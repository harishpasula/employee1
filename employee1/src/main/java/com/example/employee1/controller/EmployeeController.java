package com.example.employee1.controller;

import com.example.employee1.entity.EmployeeEntity;
import com.example.employee1.model.Employee;
import com.example.employee1.model.EmployeeCount;
import com.example.employee1.model.EmployeeReport;
import com.example.employee1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    private void add(@RequestBody Employee employee)
    {
        employeeService.add(employee);
    }
    @RequestMapping(value="/get/{country}",method =RequestMethod.GET)
    private Set<Employee> get(@PathVariable String country)
    {
         return employeeService.getEmployeeByCountry(country);

    }
    @RequestMapping(value="/get1/{city1}/{city2}",method =RequestMethod.GET)
    private Set<Employee> getEmployeeByCity(@PathVariable String city1,@PathVariable String city2)
    {
        return employeeService.getEmployeeByCity(city1,city2);

    }
    @RequestMapping(value="/get2/{city}/{country}",method =RequestMethod.GET)
    private Set<Employee> getEmployeeByCityAndCountry(@PathVariable String city,@PathVariable String country)
    {
        return employeeService.getEmployeeByCityAndCountry(city,country);

    }
    @RequestMapping(value="/get3/details",method =RequestMethod.GET)
    private List<EmployeeReport> getEmployeeSalary()
    {
        return employeeService.getEmployeeSalaryDetails();

    }
    @RequestMapping(value="/get4/details/{payable}",method =RequestMethod.GET)
    private List<EmployeeReport> getEmployeeSalary(@PathVariable String payable)
    {
        return employeeService.getEmployeeSalaryDetails(payable);

    }
    @RequestMapping(value="/get5/NoOfDays/{date}",method =RequestMethod.GET)
    private List<EmployeeCount> getEmployeeNoOfDays(@PathVariable String date)
    {
        return employeeService.getEmployeeNoOfDays(date);

    }





}
