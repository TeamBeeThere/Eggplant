package com.emerald.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.dto.EmployeeDTO;
import com.emerald.model.Employee;
import com.emerald.repository.DepartmentRepository;
import com.emerald.repository.EmployeeRepository;
import com.emerald.repository.LocationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    // --- Dependencies (Fields) ---
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final LocationRepository locationRepository;

    // --- Constructor Injection ---
    /**
     * Constructor used by Spring to inject the required repository dependencies.
     */
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, LocationRepository locationRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
    }

    public Employee updateEmployeeInfo(int id, EmployeeDTO request) {
        // Fetch existing employee
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Employee not found!"));
        
        
        // department must exist
        locationRepository.findById(request.getId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid Location"));
        // location must exist

    }
}