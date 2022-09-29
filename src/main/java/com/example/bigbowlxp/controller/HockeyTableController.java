package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.HockeyTable;
import com.example.bigbowlxp.service.HockeyTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/hockey-table")
public class HockeyTableController {

    private final HockeyTableService hockeyTableService;

    @Autowired
    public HockeyTableController(HockeyTableService hockeyTableService) {
        this.hockeyTableService = hockeyTableService;
    }

    @GetMapping
    public List<HockeyTable> getHockeyTables() {
        return hockeyTableService.getHockeyTables();
    }
}
