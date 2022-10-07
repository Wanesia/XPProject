package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.HockeyTable;
import com.example.bigbowlxp.service.HockeyTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/hockey-table")
@CrossOrigin
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

    @PutMapping(path = "{id}")
    public void updateHockeyBooking(
            @PathVariable("id") Long id,
            @RequestParam(required = false)
            boolean booked,
            @RequestParam(required = false)
            boolean inOrder) {
        hockeyTableService.updateHockeyTable(id, booked, inOrder);
    }
}
