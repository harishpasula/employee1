package com.example.employee1.service;


import com.example.employee1.entity.EmployeeAddressE;
import com.example.employee1.entity.EmployeeAttendenceE;
import com.example.employee1.entity.EmployeeEntity;
import com.example.employee1.entity.EmployeeSalaryE;
import com.example.employee1.model.*;
import com.example.employee1.repository.EmployeeAddressR;
import com.example.employee1.repository.EmployeeAttendenceR;
import com.example.employee1.repository.EmployeeR;
import com.example.employee1.repository.EmployeeSalaryR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeR employeeR;
    @Autowired
    private EmployeeAddressR employeeAddressR;
    @Autowired
    private EmployeeAttendenceR employeeAttendenceR;
    @Autowired
    private EmployeeSalaryR employeeSalaryR;
    public void add(Employee employee)
    {
        EmployeeEntity employeeEntity=new EmployeeEntity();

        employeeEntity.setEid(employee.getEid());
        employeeEntity.setEname(employee.getEname());
        employeeEntity.setEemail(employee.getEemail());
        List<EmployeeAddressE> employeeAddressE=new ArrayList<>();
        employee.getAddress().stream().forEach(employee1->
        {  EmployeeAddressE employee2 =new EmployeeAddressE();
        employee2.setLine1(employee1.getLine1());
        employee2.setLine2(employee1.getLine2());
        employee2.setPhnNo(employee1.getPhnNo());
        employee2.setCity(employee1.getCity());
        employee2.setCountry(employee1.getCountry());
        employee2.setEmployeeEntity(employeeEntity);
        employeeAddressE.add(employeeAddressR.save(employee2));
        });
        employeeEntity.setAddress(employeeAddressE);
        List<EmployeeAttendenceE> employeeAttendenceE=new ArrayList<>();
        employee.getAttendence().stream().forEach(ea->{
            EmployeeAttendenceE employeeAttendenceE1 =new EmployeeAttendenceE();
            employeeAttendenceE1.setDate(ea.getDate());
            employeeAttendenceE1.setHoliday(ea.isHoliday());
            employeeAttendenceE1.setRfh(ea.getRfh());
            employeeAttendenceE1.setEmployeeEntity(employeeEntity);
            employeeAttendenceE.add(employeeAttendenceR.save(employeeAttendenceE1));

                });
        employeeEntity.setAttendence(employeeAttendenceE);

        EmployeeSalaryE employeeSalaryE=new EmployeeSalaryE();
        employeeSalaryE.setSalary(employee.getSalary().getSalary());
        employeeSalaryE.setPayable(employee.getSalary().getPayable());
        employeeSalaryE.setEmployeeEntity(employeeEntity);
        employeeSalaryR.save(employeeSalaryE);
        employeeEntity.setSalary(employeeSalaryE);
        
        employeeR.save(employeeEntity);
    }
    public Set<Employee> getEmployeeByCountry(String country){
        List<EmployeeAddressE> list = employeeAddressR.findByCountryIgnoreCase(country);
        Set<EmployeeEntity> list1 = list.stream().map(EmployeeAddressE::getEmployeeEntity).collect(Collectors.toSet());
        return  list1.stream().map(this::getEmployee).collect(Collectors.toSet());
    }
    public Employee getEmployee(EmployeeEntity employeeEntity){
        Employee employeeDetails = new Employee();
        employeeDetails.setEid(employeeEntity.getEid());
        employeeDetails.setEname(employeeEntity.getEname());
        employeeDetails.setEemail(employeeEntity.getEemail());
        EmployeeSalary employeeSalary = new EmployeeSalary();
        employeeSalary.setId(employeeEntity.getSalary().getId());
        employeeSalary.setSalary(employeeEntity.getSalary().getSalary());
        employeeSalary.setPayable(employeeEntity.getSalary().getPayable());
        employeeDetails.setSalary(employeeSalary);
        List<EmployeeAddress> employeeAddresses = new ArrayList<>();
        employeeEntity.getAddress().forEach(employeeAddressE -> {
            EmployeeAddress employeeAddress = new EmployeeAddress();
            employeeAddress.setLine1(employeeAddressE.getLine1());
            employeeAddress.setLine2(employeeAddressE.getLine2());
            employeeAddress.setId(employeeAddressE.getId());
            employeeAddress.setCity(employeeAddressE.getCity());
            employeeAddress.setCountry(employeeAddressE.getCountry());
            employeeAddress.setPhnNo(employeeAddressE.getPhnNo());
            employeeAddresses.add(employeeAddress);
        });
        employeeDetails.setAddress(employeeAddresses);
        List<EmployeeAttendence> employeeAttendances = new ArrayList<>();
        employeeEntity.getAttendence().forEach(employeeAttendanceEntity -> {
            EmployeeAttendence employeeAttendance = new EmployeeAttendence();
            employeeAttendance.setId(employeeAttendanceEntity.getId());
            employeeAttendance.setDate(employeeAttendanceEntity.getDate());
            employeeAttendance.setHoliday(employeeAttendanceEntity.isHoliday());
            employeeAttendance.setRfh(employeeAttendanceEntity.getRfh());
            employeeAttendances.add(employeeAttendance);
        });
        employeeDetails.setAttendence(employeeAttendances);
        return  employeeDetails;
    }
    public Set<Employee> getEmployeeByCity(String city1, String city2){
        List<EmployeeAddressE> list = employeeAddressR.findByCityOrCityIgnoreCase(city1,city2);
        Set<Integer> list1 = list.stream().map(EmployeeAddressE::getEmployeeEntity).map(EmployeeEntity::getEid).collect(Collectors.toSet());
        return   list1.stream().map(e -> employeeR.findById(e).orElse(null)).filter(Objects::nonNull).map(this::getEmployee).collect(Collectors.toSet());
    }
    public Set<Employee> getEmployeeByCityAndCountry(String city, String country){
        List<EmployeeAddressE> a = employeeAddressR.findByCityAndCountryIgnoreCase(city,country);
        return   a.stream().map(EmployeeAddressE::getEmployeeEntity).map(this::getEmployee).collect(Collectors.toSet());
    }
    public EmployeeReport getEmployeeWithSalary(EmployeeEntity employeeEntity)
    {
        return new EmployeeReport(
                employeeEntity.getEid(),employeeEntity.getEname(),employeeEntity.getEemail(),
                employeeEntity.getSalary().getSalary(),employeeEntity.getSalary().getPayable());
    }
    public List<EmployeeReport> getEmployeeSalaryDetails(){
        List<EmployeeEntity> empDetails = employeeR.findAll();
        return empDetails.stream().map(this::getEmployeeWithSalary).collect(Collectors.toList());
    }
    public List<EmployeeReport> getEmployeeSalaryDetails(String payable){

        List<EmployeeSalaryE> sal =employeeSalaryR.findByPayableIgnoreCase(payable);
        List<EmployeeEntity> emp = sal.stream().map(EmployeeSalaryE::getEmployeeEntity).collect(Collectors.toList());
        return emp.stream().map(this::getEmployeeWithSalary).collect(Collectors.toList());
    }
    public List<EmployeeCount> getEmployeeNoOfDays(String date){
        List<EmployeeAttendenceE> empAtd = employeeAttendenceR.findAll();
        Set<Integer> e1 = empAtd.stream().filter(e -> e.getDate().contains(date)).map(EmployeeAttendenceE::getEmployeeEntity).map(EmployeeEntity::getEid).collect(Collectors.toSet());
        List<Integer> size = new LinkedList<>();
        e1.forEach(e2 -> {List<EmployeeAttendenceE> e = empAtd.stream().filter(EmployeeAttendenceE::isHoliday).filter(empAtd1 -> empAtd1.getEmployeeEntity().getEid()==(e2)).collect(Collectors.toList()); size.add(e.size());});
        List<EmployeeAttendenceE> empAtt = empAtd.stream().filter(EmployeeAttendenceE::isHoliday).collect(Collectors.toList());
        System.out.println(empAtt);
        Set<EmployeeEntity> e = e1.stream().map(em -> employeeR.findById(em).orElse(null)).collect(Collectors.toSet());
        List<EmployeeCount> eCount = new ArrayList<>();
        AtomicInteger i =  new AtomicInteger();
        e.forEach(c-> {
            EmployeeCount employeeCount = new EmployeeCount(
                    c.getEid(), c.getEname(),
                    c.getAddress().stream().map(EmployeeAddressE::getPhnNo).collect(Collectors.toList()),
                    c.getSalary().getSalary(), size.get(i.getAndIncrement()));
            eCount.add(employeeCount);
        });
        return eCount;

    }
}
