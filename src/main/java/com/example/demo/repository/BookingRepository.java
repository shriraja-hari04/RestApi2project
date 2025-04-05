//  package com.example.demo.repository; 
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.example.demo.model.Booking;
// // import com.example.demo.repository.*; // Change to your actual package

// import java.time.LocalDateTime;
// import java.util.List;

// public interface BookingRepository extends JpaRepository<Booking, Long> {

//     // ✅ Pagination & Sorting: Get bookings for a user
//     Page<Booking> findByUserId(Long userId, Pageable pageable);

//     // ✅ Sorting: Find bookings for a vehicle and sort by start date
//     List<Booking> findByVehicleIdOrderByStartDateDesc(Long vehicleId);

//     // ✅ Custom JPA: Find confirmed bookings in a date range
//     @Query("SELECT b FROM Booking b WHERE b.status = 'CONFIRMED' AND b.startDate BETWEEN :start AND :end")
//     List<Booking> findConfirmedBookingsInRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

//     // ✅ Count bookings for a specific vehicle
//     long countByVehicleId(Long vehicleId);
// }




// package com.example.demo.repository;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import com.example.demo.model.Booking;

// import java.time.LocalDateTime;
// import java.util.List;

// public interface BookingRepository extends JpaRepository<Booking, Long> {

//     // ✅ Pagination & Sorting: Get bookings for a specific user
//     Page<Booking> findByUserId(@Param("userId") Long userId, Pageable pageable);

//     // ✅ Sorting: Find bookings for a vehicle and sort by start date (latest first)
//     List<Booking> findByVehicleIdOrderByStartDateDesc(@Param("vehicleId") Long vehicleId);

//     // ✅ Custom Query: Find confirmed bookings in a date range
//     @Query("SELECT b FROM Booking b WHERE b.status = 'CONFIRMED' AND b.startDate BETWEEN :start AND :end")
//     List<Booking> findConfirmedBookingsInRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

//     // ✅ Count total bookings for a specific vehicle
//     long countByVehicleId(@Param("vehicleId") Long vehicleId);
// }






package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Booking;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // ✅ Fetch bookings for a specific user with pagination
    Page<Booking> findByUserId(Long userId, Pageable pageable);

    // ✅ Fetch all bookings for a specific user (without pagination)
    List<Booking> findByUserId(Long userId);

    // ✅ Fetch bookings for a specific vehicle, sorted by start date (latest first)
    List<Booking> findByVehicleIdOrderByStartDateDesc(Long vehicleId);

    // ✅ Count total bookings for a specific vehicle
    long countByVehicleId(Long vehicleId);
}

