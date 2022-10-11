package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.HockeyBooking;
import com.example.bigbowlxp.service.HockeyBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/hockey-booking")
@CrossOrigin
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

    @PostMapping
    public void registerNewBowlingBooking(@RequestBody HockeyBooking hockeyBooking) {
        hockeyBookingService.addHockeyBooking(hockeyBooking);
    }

    @PutMapping(path = "{id}")
    public void updateHockeyBooking(
            @PathVariable("id") Long id,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime startDateTime,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endDateTime,
            @RequestParam(required = false)
            String firstName,
            @RequestParam(required = false)
            String lastName,
            @RequestParam(required = false)
            String phoneNumber) {
        hockeyBookingService.updateHockeyBooking(id, startDateTime, endDateTime, firstName, lastName, phoneNumber);
    }

    @DeleteMapping(path = "{id}")
    public void deleteHockeyBooking(@PathVariable("id") Long id) {
        hockeyBookingService.deleteHockeyBooking(id);
    }

    @GetMapping(path = "{id}")
    public List<HockeyBooking> findCustomerByTableNumber(@PathVariable("id") Long id){
        System.out.println(id);
       return hockeyBookingService.findBookingsByTableNumber(id);

    }
}
