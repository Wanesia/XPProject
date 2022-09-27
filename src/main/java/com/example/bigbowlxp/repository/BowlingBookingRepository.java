package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.BowlingBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BowlingBookingRepository extends JpaRepository<BowlingBooking, Long> {
    @Query("SELECT b FROM BowlingBooking b JOIN BowlingLane l ON b.id = l.id WHERE l.isBooked = ?1")
    Optional<BowlingBooking> findBowlingBookingByBowlingLane_Booked(boolean booked);
}
