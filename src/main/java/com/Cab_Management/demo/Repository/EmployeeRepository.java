package com.Cab_Management.demo.Repository;

import com.Cab_Management.demo.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
