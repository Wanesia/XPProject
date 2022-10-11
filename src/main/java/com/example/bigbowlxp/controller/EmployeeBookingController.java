package com.example.bigbowlxp.controller;

import com.example.bigbowlxp.model.EmployeeBooking;
import com.example.bigbowlxp.service.EmployeeBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee-booking")
@CrossOrigin
public class EmployeeBookingController {
    private final EmployeeBookingService employeeBookingService;

    @Autowired
    public EmployeeBookingController(EmployeeBookingService employeeBookingService) {
        this.employeeBookingService = employeeBookingService;
    }

    @GetMapping
    public List<EmployeeBooking> getEmployeeBookings() {
        return employeeBookingService.getEmployeeBookings();
    }

    @PostMapping
    public void registerNewEmployeeBooking(@RequestBody EmployeeBooking employeeBooking) {
        employeeBookingService.addEmployeeBooking(employeeBooking);
    }

    @PutMapping(path = "{id}")
    public void updateEmployeeBooking(
            @PathVariable("id") Long id,
            @RequestParam(required = false)
            String position,
            @RequestParam(required = false)
            Boolean shiftTime) {
        employeeBookingService.updateEmployeeBooking(id, position, shiftTime);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployeeBooking(@PathVariable("id") Long id) {
        employeeBookingService.deleteHockeyBooking(id);
    }
}
