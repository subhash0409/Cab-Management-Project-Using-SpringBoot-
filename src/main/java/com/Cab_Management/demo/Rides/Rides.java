package com.Cab_Management.demo.Rides;

import com.Cab_Management.demo.Employee.Employee;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Rides {
    @Id
    @GeneratedValue
    private int ride_Id;

    private int employee_Id;
    @Column(name = "Start Location")
    private String startLocation;
    @Column(name = "End Location")
    private String endLocation;
    @Enumerated(EnumType.STRING)
    @Column(name = "Cab Type")
    private CabTypes cabType;
    private int distanceTravelled;
    private int charges;
    @Enumerated(EnumType.STRING)
    private Status status = Status.STARTED;
    @CreatedDate
    private Date createdAt;

    @ManyToOne
    private Employee employee;

    @Override
    public String toString() {
        return "Rides{" +
                "ride_Id=" + ride_Id +
                ", employee_Id=" + employee_Id +
                ", startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", cabType=" + cabType +
                ", charges=" + charges +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public void setEmployee_Id(int employee_Id) {
        this.employee_Id = employee_Id;
    }

    public CabTypes getCabType() {
        return cabType;
    }

    public void setCabType(CabTypes cabType) {
        this.cabType = cabType;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public int getRide_Id() {
        return ride_Id;
    }

    public void setRide_Id(int ride_Id) {
        this.ride_Id = ride_Id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }
}
