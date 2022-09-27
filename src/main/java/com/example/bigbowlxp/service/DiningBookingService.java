package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.DiningBooking;
import com.example.bigbowlxp.repository.DiningBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiningBookingService {

    private final DiningBookingRepository diningBookingRepository;

    @Autowired
    public DiningBookingService(DiningBookingRepository diningBookingRepository) {
        this.diningBookingRepository = diningBookingRepository;
    }

    public List<DiningBooking> getDiningBookings() {
        return diningBookingRepository.findAll();
    }

    public void addDiningBooking(DiningBooking diningBooking) {
        diningBookingRepository.save(diningBooking);
    }
}
