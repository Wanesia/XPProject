package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.DiningBooking;
import com.example.bigbowlxp.service.DiningBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/dining-booking")
public class DiningBookingController {

    private final DiningBookingService diningBookingService;

    @Autowired
    public DiningBookingController(DiningBookingService diningBookingService) {
        this.diningBookingService = diningBookingService;
    }

    @GetMapping
    public List<DiningBooking> getDiningBookings() {
        return diningBookingService.getDiningBookings();
    }
}
