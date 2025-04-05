// package com.example.demo.model;


// import jakarta.persistence.*;
// import lombok.*;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Vehicle {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private String brand;
//     private Double pricePerDay;
//     private Boolean availability;
//     private Integer year;  // Kept as normal field

//     @Version  
//     private Integer version;  // Used for optimistic locking
// }







// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.util.List;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Vehicle {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private String brand;
//     private Double pricePerDay;
//     private Boolean availability;
//     private Integer year;  // Kept as normal field

//     @Version  
//     private Integer version;  // Used for optimistic locking

//     @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Booking> bookings; // One Vehicle can have multiple Bookings
// }








// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.util.List;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Vehicle {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private String brand;
//     private Double pricePerDay;
//     private Boolean availability;
//     private Integer year;  // Kept as normal field

//     @Version  
//     private Integer version;  // Used for optimistic locking

//     @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Booking> bookings; // One Vehicle can have multiple Bookings



//     @ManyToOne
//     @JoinColumn(name = "rental_company_id")
//     private RentalCompany rentalCompany;
// }









// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonBackReference;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Vehicle {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private String brand;
//     private Double pricePerDay;
//     private Boolean availability;
//     private Integer year;  // Kept as normal field

//     @Version  
//     private Integer version;  // Used for optimistic locking

//     @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Booking> bookings; // One Vehicle can have multiple Bookings

//     // ✅ Ensure this matches 'mappedBy = "rentalCompany"' in RentalCompany.java
//     @ManyToOne
//     @JoinColumn(name = "rental_company_id", nullable = false) 
//     @JsonBackReference
//     private RentalCompany rentalCompany;
// }







package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private Double pricePerDay;
    private Boolean availability;
    private Integer year;  // Kept as normal field

    @Version  
    private Integer version;  // Used for optimistic locking

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings; // One Vehicle can have multiple Bookings

    @ManyToOne
    @JoinColumn(name = "rental_company_id", nullable = false) 
    @JsonBackReference // Prevents infinite recursion
    private RentalCompany rentalCompany;
}
