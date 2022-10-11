package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.HockeyTable;
import com.example.bigbowlxp.repository.HockeyTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HockeyTableService {

    private final HockeyTableRepository hockeyTableRepository;

    @Autowired
    public HockeyTableService(HockeyTableRepository hockeyTableRepository) {
        this.hockeyTableRepository = hockeyTableRepository;
    }

    public List<HockeyTable> getHockeyTables() {
        return hockeyTableRepository.findAll();
    }

    public void addHockeyTable(HockeyTable hockeyTable) {
        hockeyTableRepository.save(hockeyTable);
    }

    @Transactional
    public void updateHockeyTable(Long id, Boolean isBooked, Boolean inOrder) {
        HockeyTable hockeyTable = hockeyTableRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Hockey table with ID " + id + " does not exist."));
        if (isBooked!= null) {
            hockeyTable.setBooked(isBooked);
        }
        if (inOrder!= null) {
            hockeyTable.setInOrder(inOrder);
        }
    }

}
