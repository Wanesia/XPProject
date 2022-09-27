package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.HockeyTable;
import com.example.bigbowlxp.repository.HockeyTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
