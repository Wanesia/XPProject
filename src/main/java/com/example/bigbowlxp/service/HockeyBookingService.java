package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.HockeyBooking;
import com.example.bigbowlxp.repository.HockeyBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
