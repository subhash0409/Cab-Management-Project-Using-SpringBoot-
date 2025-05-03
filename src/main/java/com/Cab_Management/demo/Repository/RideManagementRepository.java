package com.Cab_Management.demo.Repository;

import com.Cab_Management.demo.Rides.Rides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RideManagementRepository extends JpaRepository<Rides,Integer> {

    @Query(value = "SELECT * FROM Rides r WHERE r.\"cab type\" = :cabType", nativeQuery = true)
    List<Rides> findByCabType(String cabType);


    @Query(value = "SELECT * FROM Rides r WHERE r.\"employee_id\" = :employee_id", nativeQuery = true)
    List<Rides> findByEmployeeId(int employee_id);

}
