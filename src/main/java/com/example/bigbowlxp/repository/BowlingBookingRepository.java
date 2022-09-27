package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.BowlingBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlingBookingRepository extends JpaRepository<BowlingBooking, Integer> {
}
