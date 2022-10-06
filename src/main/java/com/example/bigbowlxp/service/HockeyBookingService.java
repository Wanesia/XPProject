package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.HockeyBooking;
import com.example.bigbowlxp.repository.HockeyBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class HockeyBookingService {

    private final HockeyBookingRepository hockeyBookingRepository;

    @Autowired
    public HockeyBookingService(HockeyBookingRepository hockeyBookingRepository) {
        this.hockeyBookingRepository = hockeyBookingRepository;
    }

    public List<HockeyBooking> getHockeyBookings() {
        return hockeyBookingRepository.findAll();
    }

    public void addHockeyBooking(HockeyBooking hockeyBooking) {
        hockeyBookingRepository.save(hockeyBooking);
    }

    @Transactional
    public void updateHockeyBooking(Long id,
                                     LocalDateTime startDateTime,
                                     LocalDateTime endDateTime) {
        HockeyBooking hockeyBooking = hockeyBookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Hockey booking with ID " + id + " does not exist."));
        if (startDateTime != null
                && !Objects.equals(hockeyBooking.getStartDateTime(), startDateTime)
                && !startDateTime.isAfter(endDateTime)) {
            hockeyBooking.setStartDateTime(startDateTime);
        }
        if (endDateTime != null
                && !Objects.equals(hockeyBooking.getEndDateTime(), endDateTime)
                && !endDateTime.isBefore(Objects.requireNonNull(startDateTime))) {
           hockeyBooking.setEndDateTime(endDateTime);
        }
    }

    public void deleteHockeyBooking(Long id) {
        boolean exists = hockeyBookingRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Hockey booking with ID " + id + " does not exist.");
        }
        hockeyBookingRepository.deleteById(id);
    }
}
