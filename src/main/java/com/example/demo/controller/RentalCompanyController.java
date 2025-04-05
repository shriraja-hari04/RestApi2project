//  package com.example.demo.controller;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.RentalCompany;
// import com.example.demo.service.RentalCompanyService;

// @RestController
// @RequestMapping("/rental-companies")
// public class RentalCompanyController {

//     private final RentalCompanyService rentalCompanyService;

//     public RentalCompanyController(RentalCompanyService rentalCompanyService) {
//         this.rentalCompanyService = rentalCompanyService;
//     }

//     // ✅ Create a new rental company
//     @PostMapping("/post")
//     public ResponseEntity<RentalCompany> createRentalCompany(@RequestBody RentalCompany rentalCompany) {
//         return ResponseEntity.ok(rentalCompanyService.createRentalCompany(rentalCompany));
//     }

//     // ✅ Get all rental companies with pagination & sorting
//     @GetMapping
//     public ResponseEntity<Page<RentalCompany>> getAllRentalCompanies(Pageable pageable) {
//         return ResponseEntity.ok(rentalCompanyService.getAllRentalCompanies(pageable));
//     }

//     // ✅ Get a rental company by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<RentalCompany> getRentalCompanyById(@PathVariable Long id) {
//         return ResponseEntity.ok(rentalCompanyService.getRentalCompanyById(id));
//     }

//     // ✅ Update a rental company
//     @PutMapping("/put/{id}")
//     public ResponseEntity<RentalCompany> updateRentalCompany(@PathVariable Long id, @RequestBody RentalCompany rentalCompany) {
//         return ResponseEntity.ok(rentalCompanyService.updateRentalCompany(id, rentalCompany));
//     }

//     // ✅ Delete a rental company
//     @DeleteMapping("/delete/{id}")
//     public ResponseEntity<Void> deleteRentalCompany(@PathVariable Long id) {
//         rentalCompanyService.deleteRentalCompany(id);
//         return ResponseEntity.noContent().build();
//     }

//     // ✅ Get rental companies by location (pagination & sorting)
//     @GetMapping("/location/{location}")
//     public ResponseEntity<Page<RentalCompany>> getRentalCompaniesByLocation(@PathVariable String location, Pageable pageable) {
//         return ResponseEntity.ok(rentalCompanyService.getRentalCompaniesByLocation(location, pageable));
//     }
// }
package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//  import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RentalCompany;
import com.example.demo.service.RentalCompanyService;

import java.util.List;

@RestController
@RequestMapping("/rental-companies")
public class RentalCompanyController {

    private final RentalCompanyService rentalCompanyService;

    public RentalCompanyController(RentalCompanyService rentalCompanyService) {
        this.rentalCompanyService = rentalCompanyService;
    }

    // ✅ Create a new rental company
    @PostMapping
    public ResponseEntity<RentalCompany> createRentalCompany(@RequestBody RentalCompany rentalCompany) {
        return ResponseEntity.ok(rentalCompanyService.createRentalCompany(rentalCompany));
    }

    // ✅ Bulk insert rental companies
    @PostMapping("/post")
    public ResponseEntity<List<RentalCompany>> createMultipleRentalCompanies(@RequestBody List<RentalCompany> rentalCompanies) {
        return ResponseEntity.ok(rentalCompanyService.createMultipleRentalCompanies(rentalCompanies));
    }

    // ✅ Get all rental companies with pagination & sorting
    @GetMapping
    public ResponseEntity<Page<RentalCompany>> getAllRentalCompanies(Pageable pageable) {
        return ResponseEntity.ok(rentalCompanyService.getAllRentalCompanies(pageable));
    }

    // ✅ Get a rental company by ID
    @GetMapping("/{id}")
    public ResponseEntity<RentalCompany> getRentalCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(rentalCompanyService.getRentalCompanyById(id));
    }

    // ✅ Update a rental company
    @PutMapping("/{id}")
    public ResponseEntity<RentalCompany> updateRentalCompany(@PathVariable Long id, @RequestBody RentalCompany rentalCompany) {
        return ResponseEntity.ok(rentalCompanyService.updateRentalCompany(id, rentalCompany));
    }

    // ✅ Delete a rental company
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRentalCompany(@PathVariable Long id) {
        rentalCompanyService.deleteRentalCompany(id);
        return ResponseEntity.noContent().build();
    }

   

    


    // ✅ Get rental companies by location (pagination & sorting)
    @GetMapping("/location/{location}")
    public ResponseEntity<Page<RentalCompany>> getRentalCompaniesByLocation(@PathVariable String location, Pageable pageable) {
        return ResponseEntity.ok(rentalCompanyService.getRentalCompaniesByLocation(location, pageable));
    }
}

