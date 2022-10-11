package com.example.bigbowlxp.service;

import com.example.bigbowlxp.model.HockeyBooking;
import com.example.bigbowlxp.repository.HockeyBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class HockeyBookingService {

    private final HockeyBookingRepository hockeyBookingRepository;

    @Autowired
    public HockeyBookingService(HockeyBookingRepository hockeyBookingRepository) {
        this.hockeyBookingRepository = hockeyBookingRepository;
    }

    public List<HockeyBooking> getHockeyBookings() {
        return hockeyBookingRepository.findAll();
    }

    public void addHockeyBooking(HockeyBooking hockeyBooking) {
        hockeyBookingRepository.save(hockeyBooking);
    }

    @Transactional
    public void updateHockeyBooking(Long id,
                                    LocalDateTime startDateTime,
                                    LocalDateTime endDateTime,
                                    String firstName,
                                    String lastName,
                                    String phoneNumber) {
        HockeyBooking hockeyBooking = hockeyBookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Hockey booking with ID " + id + " does not exist."));
        if (startDateTime != null
                && !Objects.equals(hockeyBooking.getStartDateTime(), startDateTime)
                && !startDateTime.isAfter(endDateTime)) {
            hockeyBooking.setStartDateTime(startDateTime);
        }
        if (endDateTime != null
                && !Objects.equals(hockeyBooking.getEndDateTime(), endDateTime)
                && !endDateTime.isBefore(Objects.requireNonNull(startDateTime))) {
           hockeyBooking.setEndDateTime(endDateTime);
        }
        if (firstName != null) {
            hockeyBooking.getCustomer().setFirstName(firstName);
        }
        if (lastName != null) {
            hockeyBooking.getCustomer().setLastName(lastName);
        }
        if (phoneNumber != null) {
            hockeyBooking.getCustomer().setPhoneNumber(phoneNumber);
        }
    }

    public void deleteHockeyBooking(Long id) {
        boolean exists = hockeyBookingRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Hockey booking with ID " + id + " does not exist.");
        }
        hockeyBookingRepository.deleteById(id);
    }

    public List<HockeyBooking> findBookingsByTableNumber(Long id){
        return hockeyBookingRepository.findAllById(id);
    }

    public List<HockeyBooking> findBookingsByCustomerFirstName(String customerFirstName){
        return hockeyBookingRepository.findAllByCustomerFirstName(customerFirstName);
    }
    public List<HockeyBooking> findBookingsByCustomerLastName(String customerLastName){
        return hockeyBookingRepository.findAllByCustomerLastName(customerLastName);
    }

    public List<HockeyBooking> findBookingsByCustomerPhoneNumber(String phoneNumber){
        return hockeyBookingRepository.findAllByCustomer_PhoneNumber(phoneNumber);
    }

   public List<HockeyBooking> findAllByStartDateTime(LocalDateTime startDateTime){
        return hockeyBookingRepository.findAllByStartDateTime(startDateTime);
   }
    //fetch by end date
   public List<HockeyBooking> findAllByEndDateTime(LocalDateTime endDateTime){
        return findAllByEndDateTime(endDateTime);
   }
}
