package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.HockeyBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HockeyBookingRepository extends JpaRepository<HockeyBooking, Long> {
    //fetch by table number
    List<HockeyBooking> findAllById(Long id);

    //fetch by start date
    List<HockeyBooking> findAllByStartDateTime(LocalDateTime startDateTime);
    //fetch by end date
    List<HockeyBooking> findAllByEndDateTime(LocalDateTime endDateTime);

    //fetch by customers first name
    List<HockeyBooking> findAllByCustomerFirstName(String customerFirstName);

    //fetch by customers last name
    List<HockeyBooking> findAllByCustomerLastName(String customerLastName);

    //fetch by customers phone number
    List<HockeyBooking> findAllByCustomer_PhoneNumber(String customer);

}
