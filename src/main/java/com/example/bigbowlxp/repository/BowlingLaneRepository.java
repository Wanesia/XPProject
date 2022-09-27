package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.BowlingLane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlingLaneRepository extends JpaRepository<BowlingLane, Integer> {
}
