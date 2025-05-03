package com.Cab_Management.demo.Employee;


public class EmployeeRequest {
    private String name;
    private String cabType;
    private String address;
    private int distanceFromOffice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCabType() {
        return cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDistanceFromOffice() {
        return distanceFromOffice;
    }

    public void setDistanceFromOffice(int distanceFromOffice) {
        this.distanceFromOffice = distanceFromOffice;
    }
}
