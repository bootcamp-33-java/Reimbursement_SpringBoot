package com.mii.consume.services;

import com.mii.consume.entities.History;
import com.mii.consume.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    public void save(History history){
        historyRepository.save(history);
    }
}
