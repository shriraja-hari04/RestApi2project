// package com.example.demo.repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.Vehicle;
// import java.util.List;

// @Repository
// public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
//     // Find all available vehicles (availability = true)
//     List<Vehicle> findByAvailabilityTrue();
// }



package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Vehicle;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    // ✅ Find all available vehicles (availability = true) - Custom JPA
    List<Vehicle> findByAvailabilityTrue();

    // ✅ JPQL Query to find available vehicles
    @Query("SELECT v FROM Vehicle v WHERE v.availability = true")
    List<Vehicle> findAvailableVehicles();
}

