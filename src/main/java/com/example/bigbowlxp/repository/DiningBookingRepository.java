package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.DiningBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface DiningBookingRepository extends JpaRepository<DiningBooking, Long> {
    @Modifying
    @Query("UPDATE  DiningBooking db SET db.startDateTime = :startDateTime, db.endDateTime = :endDateTime WHERE db.id = :id")
    public void updateDiningBooking(@Param(value = "startDateTime") LocalDateTime startDateTime, @Param(value = "id") Long id, @Param(value = "endDateTime")LocalDateTime endDateTime);
}
