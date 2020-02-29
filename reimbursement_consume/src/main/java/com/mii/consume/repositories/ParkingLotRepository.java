package com.mii.consume.repositories;

import com.mii.consume.entities.ParkingLot;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotRepository extends PagingAndSortingRepository<ParkingLot, Integer> {
    List<ParkingLot> findAll();
}
