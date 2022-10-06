package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.HockeyBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HockeyBookingRepository extends JpaRepository<HockeyBooking, Long> {
}
