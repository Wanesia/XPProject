package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.HockeyBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HockeyBookingRepository extends JpaRepository<HockeyBooking, Integer> {
}
