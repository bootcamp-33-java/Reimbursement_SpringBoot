package com.mii.consume.repositories;

import com.mii.consume.entities.History;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends PagingAndSortingRepository<History, Integer> {
    List<History> findAll();
}
