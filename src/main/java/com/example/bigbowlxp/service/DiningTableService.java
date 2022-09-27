package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.DiningTable;
import com.example.bigbowlxp.repository.DiningTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiningTableService {

    private final DiningTableRepository diningTableRepository;

    @Autowired
    public DiningTableService(DiningTableRepository diningTableRepository) {
        this.diningTableRepository = diningTableRepository;
    }

    public List<DiningTable> getDiningTables() {
        return diningTableRepository.findAll();
    }

    public void addDiningTable(DiningTable diningTable) {
        diningTableRepository.save(diningTable);
    }
}
