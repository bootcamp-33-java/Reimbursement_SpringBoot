package com.mii.consume.repositories;

import com.mii.consume.entities.Reimburse;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReimburseRepository extends PagingAndSortingRepository<Reimburse, String> {
    List<Reimburse> findAll();

    Optional<Reimburse> findById(String id);
}
