package com.mii.consume.repositories;

import com.mii.consume.entities.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {
    List<Employee> findAll();
}
