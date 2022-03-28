package com.example.employee1.model;

public class EmployeeReport
{
    private int eid;
    private String ename;
    private String eemail;
    private double salary;
    private String payable;

    public EmployeeReport(int eid, String ename, String eemail, double salary, String payable) {
        this.eid = eid;
        this.ename = ename;
        this.eemail = eemail;
        this.salary = salary;
        this.payable = payable;
    }

    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public String getEemail() {
        return eemail;
    }

    public double getSalary() {
        return salary;
    }

    public String getPayable() {
        return payable;
    }
}
