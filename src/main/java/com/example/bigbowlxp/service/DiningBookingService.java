package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.DiningBooking;
import com.example.bigbowlxp.repository.DiningBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public void updateDiningBooking(DiningBooking diningBooking)
    {
        diningBookingRepository.updateDiningBooking(diningBooking.getStartDateTime(), diningBooking.getId(), diningBooking.getEndDateTime());
    }

    public void deleteDiningBooking(DiningBooking diningBooking) {
        diningBookingRepository.delete(diningBooking);
    }
}
