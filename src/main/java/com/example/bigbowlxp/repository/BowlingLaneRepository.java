package com.example.bigbowlxp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlingLaneRepository extends JpaRepository<BowlingLaneRepository, Integer> {
}
