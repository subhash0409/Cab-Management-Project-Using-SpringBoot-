package com.Cab_Management.demo.Services;

import com.Cab_Management.demo.Employee.Employee;
import com.Cab_Management.demo.Repository.EmployeeRepository;
import com.Cab_Management.demo.Employee.EmployeeRequest;
import com.Cab_Management.demo.Rides.CabTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Employee_Service {

    @Autowired
    EmployeeRepository employeeService;

    public Employee addEmployee(EmployeeRequest emp) {

        if (emp.getCabType() == null) {
            throw new IllegalArgumentException("Cab type cannot be null");
        }

        Employee employee = new Employee();

        employee.setName(emp.getName());
        employee.setAddress(emp.getAddress());
        employee.setDistanceFromOffice(emp.getDistanceFromOffice());

        if (emp.getCabType().equalsIgnoreCase(CabTypes.NORMAL.name()))
            employee.setCabType(CabTypes.NORMAL);

        else if (emp.getCabType().equalsIgnoreCase(CabTypes.STANDARD.name()))
            employee.setCabType(CabTypes.STANDARD);

        else if (emp.getCabType().equalsIgnoreCase(CabTypes.PREMIUM.name()))
            employee.setCabType(CabTypes.PREMIUM);

        else
            throw new IllegalArgumentException("Invalid cab type: " + emp.getCabType());


        return employeeService.save(employee);
    }

    public Object getEmployee(int id) {
        return employeeService.findById(id);
    }

    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    public void clear() {
        employeeService.deleteAll();
    }

    public Employee changeCab(int employeeId, String cabType) {
        var employee = employeeService.findById(employeeId);

        if (employee.isEmpty()) {
            throw new IllegalArgumentException("Employee with ID " + employeeId + " not found.");
        }

        if (cabType.equalsIgnoreCase(CabTypes.NORMAL.name())) {
            employee.get().setCabType(CabTypes.NORMAL);
        } else if (cabType.equalsIgnoreCase(CabTypes.STANDARD.name())) {
            employee.get().setCabType(CabTypes.STANDARD);
        } else if (cabType.equalsIgnoreCase(CabTypes.PREMIUM.name())) {
            employee.get().setCabType(CabTypes.PREMIUM);
        } else {
            throw new IllegalArgumentException("Invalid cab type: " + cabType);
        }

        employeeService.save(employee.get());

        return employee.get();
    }


}
