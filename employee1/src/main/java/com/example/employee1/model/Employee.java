package com.example.employee1.model;

import javax.persistence.OneToMany;
import java.util.List;


public class Employee {
    private Integer eid;
    private String ename;
    private String eemail;
    private List<EmployeeAddress> address;
    private List<EmployeeAttendence> attendence;
    private EmployeeSalary salary;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEemail() {
        return eemail;
    }

    public void setEemail(String eemail) {
        this.eemail = eemail;
    }

    public List<EmployeeAddress> getAddress() {
        return address;
    }

    public void setAddress(List<EmployeeAddress> address) {
        this.address = address;
    }

    public List<EmployeeAttendence> getAttendence() {
        return attendence;
    }

    public void setAttendence(List<EmployeeAttendence> attendence) {
        this.attendence = attendence;
    }

    public EmployeeSalary getSalary() {
        return salary;
    }

    public void setSalary(EmployeeSalary salary) {
        this.salary = salary;
    }
}
