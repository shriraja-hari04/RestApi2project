









// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.util.List;
// import java.util.Set;

// import com.fasterxml.jackson.annotation.JsonManagedReference;

// @Entity
// @Table(name = "rental_companies")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// public class RentalCompany {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String name;

//     @Column(nullable = false)
//     private String location;

//     @Column(nullable = false)
//     private String contactNumber;

//     // ✅ Ensure this matches the "rentalCompany" field in Vehicle.java
//     @OneToMany(mappedBy = "rentalCompany", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Vehicle> vehicles; // One RentalCompany has many Vehicles

//     @ManyToMany(mappedBy = "rentalCompanies")
//     @JsonManagedReference
//     private Set<User> users; // Many Users can be part of Many Rental Companies
// }




package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "rental_companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String contactNumber;

    // ✅ Ensure this matches the "rentalCompany" field in Vehicle.java
    @OneToMany(mappedBy = "rentalCompany", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles; // One RentalCompany has many Vehicles

    // ✅ Fix @JsonBackReference (inverse side of @ManyToMany)
    @ManyToMany(mappedBy = "rentalCompanies")
    @JsonBackReference
    private Set<User> users; // Many Users can be part of Many Rental Companies
}




