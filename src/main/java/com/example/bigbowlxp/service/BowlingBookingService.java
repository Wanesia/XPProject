package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.BowlingBooking;
import com.example.bigbowlxp.repository.BowlingBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BowlingBookingService {

    private final BowlingBookingRepository bowlingBookingRepository;

    @Autowired
    public BowlingBookingService(BowlingBookingRepository bowlingBookingRepository) {
        this.bowlingBookingRepository = bowlingBookingRepository;
    }

    public List<BowlingBooking> getBowlingBookings() {
        return bowlingBookingRepository.findAll();
    }


    // Not final business logic, just an example
    public void addNewBowlingBooking(BowlingBooking bowlingBooking) {
//        Optional<BowlingBooking> bowlingBookingOptional = bowlingBookingRepository
//                .findBowlingBookingByBowlingLane_Booked(bowlingBooking.getBowlingLane().isBooked());
//        if (bowlingBookingOptional.isPresent()) {
//            throw new IllegalStateException("Bowling Lane not available");
//        }
        bowlingBookingRepository.save(bowlingBooking);
    }


    // Not final business logic, just a messy example
    @Transactional
    public void updateBowlingBooking(Long id, BowlingBooking updatedBowlingBooking) {
        BowlingBooking bowlingBooking = bowlingBookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Bowling booking with ID " + id + " does not exist."));
        bowlingBooking.setStartDateTime(updatedBowlingBooking.getStartDateTime());
        bowlingBooking.setEndDateTime(updatedBowlingBooking.getEndDateTime());
        bowlingBooking.setCustomer(updatedBowlingBooking.getCustomer());
        bowlingBooking.setBowlingLane(updatedBowlingBooking.getBowlingLane());
    }

    public void deleteBowlingBooking(Long id) {
        boolean exists = bowlingBookingRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Bowling booking with ID " + id + " does not exist.");
        }
        bowlingBookingRepository.deleteById(id);
    }
}
