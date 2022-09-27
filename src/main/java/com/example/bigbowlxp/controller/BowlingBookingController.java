package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.BowlingBooking;
import com.example.bigbowlxp.service.BowlingBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bowling-booking")
public class BowlingBookingController {

    private final BowlingBookingService bowlingBookingService;

    @Autowired
    public BowlingBookingController(BowlingBookingService bowlingBookingService) {
        this.bowlingBookingService = bowlingBookingService;
    }

    @GetMapping
    public List<BowlingBooking> getBowlingBookings() {
        return bowlingBookingService.getBowlingBookings();
    }

    @PostMapping
    public void registerNewBowlingBooking(@RequestBody BowlingBooking bowlingBooking) {
        bowlingBookingService.addNewBowlingBooking(bowlingBooking);
    }

    @PutMapping(path = "{id}")
    public void updateBowlingBooking(
            @PathVariable("id") Long id,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime startDateTime,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endDateTime) {
        bowlingBookingService.updateBowlingBooking(id, startDateTime, endDateTime);
    }

    @DeleteMapping(path = "{id}")
        public void deleteBowlingBooking(@PathVariable("id") Long id) {
            bowlingBookingService.deleteBowlingBooking(id);
        }
}
