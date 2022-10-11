package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.EmployeeBooking;
import com.example.bigbowlxp.repository.EmployeeBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeBookingService {

    private final EmployeeBookingRepository employeeBookingRepository;

    @Autowired
    public EmployeeBookingService(EmployeeBookingRepository employeeBookingRepository) {
        this.employeeBookingRepository = employeeBookingRepository;
    }

    public List<EmployeeBooking> getEmployeeBookings() {
        return employeeBookingRepository.findAll();
    }

    public void addEmployeeBooking(EmployeeBooking employeeBooking) {
        employeeBookingRepository.save(employeeBooking);
    }

    @Transactional
    public void updateEmployeeBooking(Long id,
                                    String position,
                                    Boolean shiftTime) {
        EmployeeBooking employeeBooking = employeeBookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Employee booking with ID " + id + " does not exist."));
        if (position != null
                && !Objects.equals(employeeBooking.getPosition(), position)) {
            employeeBooking.setPosition(position);
        }
        if (shiftTime != null
                && !Objects.equals(employeeBooking.getShiftTime(), shiftTime)) {
            employeeBooking.setShiftTime(shiftTime);
        }
    }

    public void deleteHockeyBooking(Long id) {
        boolean exists = employeeBookingRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Employee booking with ID " + id + " does not exist.");
        }
        employeeBookingRepository.deleteById(id);
    }
}
