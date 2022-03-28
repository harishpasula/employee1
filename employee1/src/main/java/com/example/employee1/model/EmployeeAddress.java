package com.example.employee1.model;

public class EmployeeAddress {
    private Integer id;
    private String line1;
    private String line2;
    private Long phnNo;
    private String city;
    private String country;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public Long getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(Long phnNo) {
        this.phnNo = phnNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
