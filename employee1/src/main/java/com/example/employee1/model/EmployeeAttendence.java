package com.example.employee1.model;

public class EmployeeAttendence {

    private  Integer id;
    private String date;
    private  Boolean holiday;
    private String rfh;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(Boolean holiday) {
        this.holiday = holiday;
    }

    public String getRfh() {
        return rfh;
    }

    public void setRfh(String rfh) {
        this.rfh = rfh;
    }
}
