package com.mii.consume.repositories;

import com.mii.consume.entities.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, String> {
    List<Vehicle> findAll();
}
