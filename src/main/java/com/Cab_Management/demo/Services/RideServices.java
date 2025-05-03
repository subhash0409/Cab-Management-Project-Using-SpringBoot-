package com.Cab_Management.demo.Services;

import com.Cab_Management.demo.Employee.Employee;
import com.Cab_Management.demo.Repository.RideManagementRepository;
import com.Cab_Management.demo.Rides.Rides;
import com.Cab_Management.demo.Rides.Status;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class RideServices {

    @Autowired
    RideManagementRepository rideServices;

    @Autowired
    Gson gson;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public Rides addRide(Employee employee, String startLocation, String endLocation){
        Rides ride = new Rides();
        ride.setEmployee_Id(employee.getEmployee_Id());
        ride.setStartLocation(startLocation);
        ride.setEndLocation(endLocation);
        ride.setCabType(employee.getCabType());
        ride.setDistanceTravelled(employee.getDistanceFromOffice());
        ride.setCharges(employee.getDistanceFromOffice() * employee.getCabType().kmCharges);
        return rideServices.save(ride);
    }


    public Rides changeStatus(int rideId){
        var lastRide = rideServices.findById(rideId);
        lastRide.get().setStatus(Status.COMPLETED);
        String json = gson.toJson(lastRide.get());
        System.out.println(json);
        kafkaTemplate.send("RideInformation",json);
        return lastRide.get();
    }
}
//\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
//\bin\windows\kafka-server-start.bat .\config\server.properties