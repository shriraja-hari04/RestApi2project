// // package com.example.demo.model;
// //using pagination and sorting and custom jpa
// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String firstName;
//     private String lastName;
//     private String email;
//     private String phoneNumber;

//     // Constructors
//     public User() {}

//     public User(String firstName, String lastName, String email, String phoneNumber) {
//         this.firstName = firstName;
//         this.lastName = lastName;
//         this.email = email;
//         this.phoneNumber = phoneNumber;
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getFirstName() { return firstName; }
//     public void setFirstName(String firstName) { this.firstName = firstName; }

//     public String getLastName() { return lastName; }
//     public void setLastName(String lastName) { this.lastName = lastName; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPhoneNumber() { return phoneNumber; }
//     public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
// }








// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;
// import java.util.List;

// @Entity
// @Table(name = "users")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String firstName;

//     @Column(nullable = false)
//     private String lastName;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false, unique = true)
//     private String phoneNumber;

//     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Booking> bookings; // One User can have multiple Bookings
// }






// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;
// import java.util.List;
// import java.util.Set;

// @Entity
// @Table(name = "users")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String firstName;

//     @Column(nullable = false)
//     private String lastName;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false, unique = true)
//     private String phoneNumber;

//     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Booking> bookings; // One User can have multiple Bookings

//     @ManyToMany
//     @JoinTable(
//         name = "user_rental_company",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "rental_company_id")
//     )
//     private Set<RentalCompany> rentalCompanies; // Many Users can be part of Many Rental Companies
// }














// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;
// import com.fasterxml.jackson.annotation.JsonIgnore;
// import java.util.List;

// @Entity
// @Table(name = "users")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String firstName;

//     @Column(nullable = false)
//     private String lastName;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false, unique = true)
//     private String phoneNumber;

//     // ✅ Add One-to-Many Mapping to Bookings (Bidirectional)
//     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//     @JsonIgnore  // Prevents infinite recursion
//     private List<Booking> bookings; // One User can have multiple Bookings

// }





// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;
// import com.fasterxml.jackson.annotation.JsonIgnore;
// import java.util.List;

// @Entity
// @Table(name = "users")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String firstName;

//     @Column(nullable = false)
//     private String lastName;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false, unique = true)
//     private String phoneNumber;

//     // ✅ One User can have multiple Bookings (Bidirectional)
//     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//     @JsonIgnore  // Prevents infinite recursion
//     private List<Booking> bookings; 

//     // ✅ Many Users can be associated with Many Rental Companies
//     @ManyToMany(mappedBy = "users") // Fix for the previous error
//     @JsonIgnore
//     private List<RentalCompany> rentalCompanies;
// }




package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    // ✅ Many Users can be part of Many Rental Companies
    @ManyToMany
    @JoinTable(
        name = "rental_company_users",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "rental_company_id")
    )
    @JsonManagedReference
    private Set<RentalCompany> rentalCompanies;
}
