package com.example.employee1.model;


import java.util.List;

public class EmployeeCount
{
    private Integer eid;
    private String ename;
    private List<Long> phnNo;
    private Double salary;
    private Integer noOffDays;

    public EmployeeCount(Integer eid, String ename, List<Long> phnNo, Double salary, Integer noOffDays)
    {
        this.eid = eid;
        this.ename = ename;
        this.phnNo = phnNo;
        this.salary = salary;
        this.noOffDays = noOffDays;
    }

    public Integer getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public List<Long> getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(List<Long> phnNo) {
        this.phnNo = phnNo;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getNoOffDays() {
        return noOffDays;
    }
}
