package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.Customer;
import com.example.bigbowlxp.model.DiningBooking;
import com.example.bigbowlxp.model.DiningTable;
import com.example.bigbowlxp.service.CustomerService;
import com.example.bigbowlxp.service.DiningBookingService;
import com.example.bigbowlxp.service.DiningTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1/dining-booking")
public class DiningBookingController {

    private final DiningBookingService diningBookingService;
    private final CustomerService customerService;
    private final DiningTableService diningTableService;

    @Autowired
    public DiningBookingController(DiningBookingService diningBookingService, CustomerService customerService, DiningTableService diningTableService) {
        this.diningBookingService = diningBookingService;
        this.customerService = customerService;
        this.diningTableService = diningTableService;
    }

    @GetMapping
    public List<DiningBooking> getDiningBookings() {
        return diningBookingService.getDiningBookings();
    }

    @PostMapping
    public DiningBooking postDiningBooking(@RequestBody DiningBooking booking) {
        Customer newCustomer = new Customer(booking.getCustomer().getFirstName(), booking.getCustomer().getLastName(), booking.getCustomer().getPhoneNumber());
        customerService.addCustomer(newCustomer);

        DiningBooking newBooking = new DiningBooking(booking.getStartDateTime(), booking.getEndDateTime(), newCustomer, booking.getDiningTable());

        diningBookingService.addDiningBooking(newBooking);

        return newBooking;
    }
}
