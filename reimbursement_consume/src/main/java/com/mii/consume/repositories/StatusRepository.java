package com.mii.consume.repositories;

import com.mii.consume.entities.Status;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends PagingAndSortingRepository<Status,Integer > {
    List<Status> findAll();
}
