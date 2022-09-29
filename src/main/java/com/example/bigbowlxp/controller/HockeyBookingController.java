package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.HockeyBooking;
import com.example.bigbowlxp.service.HockeyBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/hockey-booking")
public class HockeyBookingController {

    private final HockeyBookingService hockeyBookingService;

    @Autowired
    public HockeyBookingController(HockeyBookingService hockeyBookingService) {
        this.hockeyBookingService = hockeyBookingService;
    }

    @GetMapping
    public List<HockeyBooking> getHockeyBookings() {
        return hockeyBookingService.getHockeyBookings();
    }
}
