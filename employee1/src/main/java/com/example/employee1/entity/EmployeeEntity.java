package com.example.employee1.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class EmployeeEntity {
    @Id
    private Integer eid;
    private String ename;
    private String eemail;
    @OneToMany( cascade = CascadeType.ALL,mappedBy = "employeeEntity")
    List<EmployeeAddressE> address;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employeeEntity")
    private List<EmployeeAttendenceE> attendence;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employeeEntity")
    private EmployeeSalaryE salary;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
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

    public List<EmployeeAddressE> getAddress() {
        return address;
    }

    public void setAddress(List<EmployeeAddressE> address) {
        this.address = address;
    }

    public List<EmployeeAttendenceE> getAttendence() {
        return attendence;
    }

    public void setAttendence(List<EmployeeAttendenceE> attendence) {
        this.attendence = attendence;
    }

    public EmployeeSalaryE getSalary() {
        return salary;
    }

    public void setSalary(EmployeeSalaryE salary) {
        this.salary = salary;
    }


}
