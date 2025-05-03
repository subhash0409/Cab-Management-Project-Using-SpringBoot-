package com.Cab_Management.demo.Controller;

import com.Cab_Management.demo.Employee.Employee;
import com.Cab_Management.demo.Employee.EmployeeRequest;
import com.Cab_Management.demo.Repository.RideManagementRepository;
import com.Cab_Management.demo.Rides.Rides;
import com.Cab_Management.demo.Services.Employee_Service;
import com.Cab_Management.demo.Services.RideServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    Employee_Service employeeService;
    @Autowired
    RideServices rideServices;
    @Autowired
    RideManagementRepository rideManagementRepository;


    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody EmployeeRequest emp){
        return employeeService.addEmployee(emp);
    }

    @GetMapping("/getEmployee")
    public Object getEmployee(@RequestParam int id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/clearAll")
    public void clearAll(){
        employeeService.clear();
    }

    @PutMapping("/changeCabType")
    public Employee changeCab(@RequestParam int id, @RequestParam String cabType){
        return employeeService.changeCab(id,cabType);
    }

    @PostMapping("/addRide")
    public Rides addRide(@RequestBody Employee employee, @RequestParam String startLocation, @RequestParam String endLocation){
        return rideServices.addRide(employee,startLocation,endLocation);
    }

    @GetMapping("/findByCab")
    public void findByCabType(@RequestParam String cabType){
        var list =  rideManagementRepository.findByCabType(cabType);
        System.out.println("total number of rides taken in cab type " + cabType + " :" + list.size());
    }

    @GetMapping("/findRidesByID")
    public void findByEmployeeId(@RequestParam int id){
        var list = rideManagementRepository.findByEmployeeId(id);
        System.out.println("total rides taken by employee "+ id+ " :" + list.size());
    }

    @GetMapping("/findAllRides")
    public List<Rides> findAllRides(){
        return rideManagementRepository.findAll();
    }

    @PutMapping("/changeStatus")
    public Rides changeStatus(@RequestParam int rideId){
        return rideServices.changeStatus(rideId);
    }
}
