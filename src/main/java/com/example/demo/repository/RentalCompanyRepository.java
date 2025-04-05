//  package com.example.demo.repository;





package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.RentalCompany;

@Repository
public interface RentalCompanyRepository extends JpaRepository<RentalCompany, Long> {

    // ✅ Find by location with pagination & sorting (Custom JPA Method)
    Page<RentalCompany> findByLocation(String location, Pageable pageable);

    // ✅ JPQL Query to fetch rental companies by location
    @Query("SELECT r FROM RentalCompany r WHERE r.location = :location")
    Page<RentalCompany> findRentalCompaniesByLocation(@Param("location") String location, Pageable pageable);
}
