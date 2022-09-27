package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.BowlingLane;
import com.example.bigbowlxp.repository.BowlingLaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BowlingLaneService {

    private final BowlingLaneRepository bowlingLaneRepository;

    @Autowired
    public BowlingLaneService(BowlingLaneRepository bowlingLaneRepository) {
        this.bowlingLaneRepository = bowlingLaneRepository;
    }

    public List<BowlingLane> getBowlingLanes() {
        return bowlingLaneRepository.findAll();
    }

    public void addNewBowlingLane(BowlingLane bowlingLane) {
        bowlingLaneRepository.save(bowlingLane);
    }
}
