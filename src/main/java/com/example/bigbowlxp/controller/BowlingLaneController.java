package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.BowlingLane;
import com.example.bigbowlxp.service.BowlingLaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/bowling-lane")
public class BowlingLaneController {

    private final BowlingLaneService bowlingLaneService;

    @Autowired
    public BowlingLaneController(BowlingLaneService bowlingLaneService) {
        this.bowlingLaneService = bowlingLaneService;
    }

    @GetMapping
    public List<BowlingLane> getBowlingLanes() {
        return bowlingLaneService.getBowlingLanes();
    }

    @PostMapping
    public void addNewBowlingLane(@RequestBody BowlingLane bowlingLane) {
        bowlingLaneService.addNewBowlingLane(bowlingLane);
    }
}
