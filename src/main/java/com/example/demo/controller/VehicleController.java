package com.example.demo.controller;

import com.example.demo.model.Vehicle;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.VehicleService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Save a single vehicle
    @PostMapping
    public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicle));
    }
//     @PostMapping("/vehicles/bulk")
// public ResponseEntity<?> addVehicles(@RequestBody List<Vehicle> vehicles) {
//     vehicleService.saveAll(vehicles);
//     return ResponseEntity.ok("Vehicles added successfully");
// }

    // Save multiple vehicles in bulk
    @PostMapping("/bulk")
    public ResponseEntity<List<Vehicle>> saveVehicles(@RequestBody List<Vehicle> vehicles) {
        return ResponseEntity.ok(vehicleService.saveVehicles(vehicles));
    }

    // Get all vehicles with pagination
    @GetMapping
    public ResponseEntity<Page<Vehicle>> getAllVehicles(Pageable pageable) {
        return ResponseEntity.ok(vehicleService.getAllVehicles(pageable));
    }

    // Get a vehicle by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    // Get available vehicles (those that are not rented)
    @GetMapping("/available")
    public ResponseEntity<List<Vehicle>> getAvailableVehicles() {
        return ResponseEntity.ok(vehicleService.getAvailableVehicles());
    }

    // Update an existing vehicle with Optimistic Locking handling
    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        try {
            return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicle));
        } catch (ObjectOptimisticLockingFailureException e) {
            return ResponseEntity.status(409).body("Conflict: Vehicle was modified by another user.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("Error: Vehicle not found.");
        }
    }

    // Delete a vehicle by its ID
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
    //     vehicleService.deleteVehicle(id);
    //     return ResponseEntity.noContent().build();
    // }
    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {
    vehicleService.deleteVehicle(id);
    return ResponseEntity.ok("Vehicle with ID " + id + " has been successfully deleted.");
}

}
