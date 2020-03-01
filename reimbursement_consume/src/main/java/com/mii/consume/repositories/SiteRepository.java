package com.mii.consume.repositories;

import com.mii.consume.entities.Site;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends PagingAndSortingRepository<Site, String> {
    List<Site> findAll();
}
