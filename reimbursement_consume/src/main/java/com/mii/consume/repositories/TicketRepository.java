package com.mii.consume.repositories;

import com.mii.consume.entities.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Integer> {
    List<Ticket> findAll();

    Optional<Ticket> findById(Integer id);
}
