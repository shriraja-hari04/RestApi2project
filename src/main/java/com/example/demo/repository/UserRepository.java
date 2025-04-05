// package com.example.demo.repository;
// import com.example.demo.model.*;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface UserRepository extends JpaRepository<User, Long> {
// }




//using pagination and sorting and custom jpa
// package com.example.demo.repository;

// import com.example.demo.model.User;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

// import java.util.List;

// public interface UserRepository extends JpaRepository<User, Long> {

//     // Custom JPA Query to find users by email
//     User findByEmail(String email);

//     // Custom JPQL query to search users by first name (case insensitive)
//     @Query("SELECT u FROM User u WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :name, '%'))")
//     List<User> searchByFirstName(String name);

//     // Pagination and Sorting support
//     Page<User> findAll(Pageable pageable);
// }


package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email
    Optional<User> findByEmail(String email);

    // Search users by first name (case insensitive) with pagination support
    @Query("SELECT u FROM User u WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<User> searchByFirstName(@Param("name") String name, Pageable pageable);
}
