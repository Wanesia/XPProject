package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.Customer;
import com.example.bigbowlxp.model.DiningBooking;
import com.example.bigbowlxp.model.DiningTable;
import com.example.bigbowlxp.service.CustomerService;
import com.example.bigbowlxp.service.DiningBookingService;
import com.example.bigbowlxp.service.DiningTableService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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
        List<Customer> list = customerService.getCustomers();
        Customer foundCustomer = null;
        for (Customer customer : list){
            if (customer.getPhoneNumber().equals(booking.getCustomer().getPhoneNumber())){
                foundCustomer = customer;
                break;
            }
        }

        if (foundCustomer == null){
            Customer newCustomer = new Customer(booking.getCustomer().getFirstName(), booking.getCustomer().getLastName(), booking.getCustomer().getPhoneNumber());
            customerService.addCustomer(newCustomer);
            foundCustomer = newCustomer;
        }

        DiningBooking newBooking = new DiningBooking(booking.getStartDateTime(), booking.getEndDateTime(), foundCustomer, booking.getDiningTable());

        diningBookingService.addDiningBooking(newBooking);

        return newBooking;
    }

    @PutMapping
    public ResponseEntity<String> editDiningBooking(@RequestBody DiningBooking diningBooking) {
        List<DiningBooking> bookingList = diningBookingService.getDiningBookings();

        for (DiningBooking db : bookingList) {
            if (!db.getId().equals(diningBooking.getId()) && db.getDiningTable().getId() == diningBooking.getDiningTable().getId() && diningBooking.getStartDateTime().isAfter(db.getStartDateTime()) && diningBooking.getStartDateTime().isBefore(db.getEndDateTime())) {
                return new ResponseEntity<>("Cannot book at this time", HttpStatus.BAD_REQUEST);
            }
        }
        diningBookingService.updateDiningBooking(diningBooking);
        return new ResponseEntity<>("Booking Saved", HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteDiningBooking(@RequestBody DiningBooking diningBooking) {
        diningBookingService.deleteDiningBooking(diningBooking);

        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
