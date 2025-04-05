package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.RentalCompany;
import com.example.demo.repository.RentalCompanyRepository;

import java.util.List;

@Service
public class RentalCompanyService {

    private final RentalCompanyRepository rentalCompanyRepository;

    public RentalCompanyService(RentalCompanyRepository rentalCompanyRepository) {
        this.rentalCompanyRepository = rentalCompanyRepository;
    }

    // ✅ Create a new rental company
    public RentalCompany createRentalCompany(RentalCompany rentalCompany) {
        return rentalCompanyRepository.save(rentalCompany);
    }

    // ✅ Bulk insert rental companies
    public List<RentalCompany> createMultipleRentalCompanies(List<RentalCompany> rentalCompanies) {
        return rentalCompanyRepository.saveAll(rentalCompanies);
    }

    // ✅ Get all rental companies (with pagination & sorting)
    public Page<RentalCompany> getAllRentalCompanies(Pageable pageable) {
        return rentalCompanyRepository.findAll(pageable);
    }

    // ✅ Get a rental company by ID
    public RentalCompany getRentalCompanyById(Long id) {
        return rentalCompanyRepository.findById(id).orElse(null);
    }

    // ✅ Update a rental company
    public RentalCompany updateRentalCompany(Long id, RentalCompany rentalCompany) {
        rentalCompany.setId(id);
        return rentalCompanyRepository.save(rentalCompany);
    }

    // ✅ Delete a rental company
    public void deleteRentalCompany(Long id) {
        rentalCompanyRepository.deleteById(id);
    }

    // ✅ Get rental companies by location (with pagination & sorting)
    public Page<RentalCompany> getRentalCompaniesByLocation(String location, Pageable pageable) {
        return rentalCompanyRepository.findByLocation(location, pageable);
    }
}
