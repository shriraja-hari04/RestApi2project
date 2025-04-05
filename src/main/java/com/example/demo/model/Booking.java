//  package com.example.demo.model;
// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class Booking {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private Long userId;
//     private Long vehicleId;
//     private LocalDateTime startDate;
//     private LocalDateTime endDate;
//     private Double totalPrice;

//     @Enumerated(EnumType.STRING)
//     private BookingStatus status;

//     // Default Constructor
//     public Booking() {}

//     // Parameterized Constructor
//     public Booking(Long id, Long userId, Long vehicleId, LocalDateTime startDate, LocalDateTime endDate, Double totalPrice, BookingStatus status) {
//         this.id = id;
//         this.userId = userId;
//         this.vehicleId = vehicleId;
//         this.startDate = startDate;
//         this.endDate = endDate;
//         this.totalPrice = totalPrice;
//         this.status = status;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getUserId() {
//         return userId;
//     }

//     public void setUserId(Long userId) {
//         this.userId = userId;
//     }

//     public Long getVehicleId() {
//         return vehicleId;
//     }

//     public void setVehicleId(Long vehicleId) {
//         this.vehicleId = vehicleId;
//     }

//     public LocalDateTime getStartDate() {
//         return startDate;
//     }

//     public void setStartDate(LocalDateTime startDate) {
//         this.startDate = startDate;
//     }

//     public LocalDateTime getEndDate() {
//         return endDate;
//     }

//     public void setEndDate(LocalDateTime endDate) {
//         this.endDate = endDate;
//     }

//     public Double getTotalPrice() {
//         return totalPrice;
//     }

//     public void setTotalPrice(Double totalPrice) {
//         this.totalPrice = totalPrice;
//     }

//     public BookingStatus getStatus() {
//         return status;
//     }

//     public void setStatus(BookingStatus status) {
//         this.status = status;
//     }
// }







// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class Booking {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user; // Mapping to User entity

//     @ManyToOne
//     @JoinColumn(name = "vehicle_id", nullable = false)
//     private Vehicle vehicle; // Mapping to Vehicle entity

//     private LocalDateTime startDate;
//     private LocalDateTime endDate;
//     private Double totalPrice;

//     @Enumerated(EnumType.STRING)
//     private BookingStatus status;

//     // Default Constructor
//     public Booking() {}

//     // Parameterized Constructor
//     public Booking(Long id, User user, Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate, Double totalPrice, BookingStatus status) {
//         this.id = id;
//         this.user = user;
//         this.vehicle = vehicle;
//         this.startDate = startDate;
//         this.endDate = endDate;
//         this.totalPrice = totalPrice;
//         this.status = status;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public Vehicle getVehicle() {
//         return vehicle;
//     }

//     public void setVehicle(Vehicle vehicle) {
//         this.vehicle = vehicle;
//     }

//     public LocalDateTime getStartDate() {
//         return startDate;
//     }

//     public void setStartDate(LocalDateTime startDate) {
//         this.startDate = startDate;
//     }

//     public LocalDateTime getEndDate() {
//         return endDate;
//     }

//     public void setEndDate(LocalDateTime endDate) {
//         this.endDate = endDate;
//     }

//     public Double getTotalPrice() {
//         return totalPrice;
//     }

//     public void setTotalPrice(Double totalPrice) {
//         this.totalPrice = totalPrice;
//     }

//     public BookingStatus getStatus() {
//         return status;
//     }

//     public void setStatus(BookingStatus status) {
//         this.status = status;
//     }


// }










// package com.example.demo.model;

// import com.fasterxml.jackson.annotation.JsonFormat;
// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class Booking {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user; // Ensure User entity exists

//     @ManyToOne
//     @JoinColumn(name = "vehicle_id", nullable = false)
//     private Vehicle vehicle;

//     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//     private LocalDateTime startDate;

//     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//     private LocalDateTime endDate;

//     private Double totalPrice;

//     @Enumerated(EnumType.STRING)
//     private BookingStatus status;

//     // Default Constructor
//     public Booking() {}

//     // Parameterized Constructor
//     public Booking(Long id, User user, Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate, Double totalPrice, BookingStatus status) {
//         this.id = id;
//         this.user = user;
//         this.vehicle = vehicle;
//         this.startDate = startDate;
//         this.endDate = endDate;
//         this.totalPrice = totalPrice;
//         this.status = status;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public Vehicle getVehicle() {
//         return vehicle;
//     }

//     public void setVehicle(Vehicle vehicle) {
//         this.vehicle = vehicle;
//     }

//     public LocalDateTime getStartDate() {
//         return startDate;
//     }

//     public void setStartDate(LocalDateTime startDate) {
//         this.startDate = startDate;
//     }

//     public LocalDateTime getEndDate() {
//         return endDate;
//     }

//     public void setEndDate(LocalDateTime endDate) {
//         this.endDate = endDate;
//     }

//     public Double getTotalPrice() {
//         return totalPrice;
//     }

//     public void setTotalPrice(Double totalPrice) {
//         this.totalPrice = totalPrice;
//     }

//     public BookingStatus getStatus() {
//         return status;
//     }

//     public void setStatus(BookingStatus status) {
//         this.status = status;
//     }
// }











// package com.example.demo.model;

// import com.fasterxml.jackson.annotation.JsonFormat;
// import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// public class Booking {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     @JsonIgnore
//     private User user; // Ensure User entity exists

//     @ManyToOne
//     @JoinColumn(name = "vehicle_id", nullable = false)
//     @JsonIgnore
//     private Vehicle vehicle;

//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//     @Column(nullable = false)
//     private LocalDateTime startDate;

//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//     @Column(nullable = false)
//     private LocalDateTime endDate;

//     @Column(nullable = false)
//     private Double totalPrice;

//     @Enumerated(EnumType.STRING)
//     @Column(nullable = false)
//     private BookingStatus status;
// }








package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    @JsonIgnore
    private User user; // One User can have multiple Bookings

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    @JsonIgnore
    private Vehicle vehicle; // A Booking is linked to a specific Vehicle

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @Column(nullable = false)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;
}
