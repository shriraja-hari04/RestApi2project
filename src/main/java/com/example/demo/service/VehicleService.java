package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    // Constructor Injection (Recommended)
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Save a single vehicle
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Save multiple vehicles
    @Transactional
    public List<Vehicle> saveVehicles(List<Vehicle> vehicles) {
        return vehicleRepository.saveAll(vehicles);
    }

    // Get all vehicles with pagination
    public Page<Vehicle> getAllVehicles(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    // Get a vehicle by ID (Throws Exception If Not Found)
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vehicle not found with ID: " + id));
    }

    // Get available vehicles (Those not rented)
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findByAvailabilityTrue();
    }

    // Update an existing vehicle (Only updates non-null fields)
    @Transactional
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        updatedVehicle.setId(id);
        return vehicleRepository.save(updatedVehicle);
    }
    

    // Delete a vehicle by ID
    @Transactional
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new NoSuchElementException("Vehicle not found with ID: " + id);
        }
        vehicleRepository.deleteById(id);
    }
}
