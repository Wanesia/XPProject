package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.EmployeeBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeBookingRepository extends JpaRepository<EmployeeBooking, Long> {
}
