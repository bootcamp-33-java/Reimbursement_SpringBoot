package com.mii.consume.repositories;

import com.mii.consume.entities.Reimburse;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimburseRepository extends PagingAndSortingRepository<Reimburse, String> {
    List<Reimburse> findAll();
}
