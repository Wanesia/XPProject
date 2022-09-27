package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.DiningTable;
import com.example.bigbowlxp.service.DiningTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/dining-table")
public class DiningTableController {

    private final DiningTableService diningTableService;

    @Autowired
    public DiningTableController(DiningTableService diningTableService) {
        this.diningTableService = diningTableService;
    }

    @GetMapping
    public List<DiningTable> getDiningTables() {
        return diningTableService.getDiningTables();
    }
}
