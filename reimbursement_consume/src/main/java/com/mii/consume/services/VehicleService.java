/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.consume.services;

import com.mii.consume.entities.Vehicle;
import com.mii.consume.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FIKRI-PC
 */
@Service
public class VehicleService {
        @Autowired
        VehicleRepository repository;

    public Iterable<Vehicle> getAll() {
        return repository.findAll();
    }

    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }
    public void delete(String id) {
        repository.deleteById(id);
        
    }
    public Vehicle getById(String vehicle) {
        return repository.findById(vehicle).get();
    }
}
