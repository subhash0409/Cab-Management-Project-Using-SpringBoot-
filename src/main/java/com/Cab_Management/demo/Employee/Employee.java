package com.Cab_Management.demo.Employee;

import com.Cab_Management.demo.Rides.CabTypes;
import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int employee_Id;
    private String name;
    private String address;
    private int distanceFromOffice;

    @Enumerated(EnumType.STRING)
    private CabTypes cabType;


    public Integer getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(Integer employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CabTypes getCabType() {
        return cabType;
    }

    public void setCabType(CabTypes type) {
        this.cabType = type;
    }

    public int getDistanceFromOffice() {
        return distanceFromOffice;
    }

    public void setDistanceFromOffice(int distanceFromOffice) {
        this.distanceFromOffice = distanceFromOffice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
