package com.example.bigbowlxp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bowling_bookings")
public class BowlingBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime start_date_time;

    @Column(name = "end_date_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime end_date_time;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "bowling_lane_id")
    private BowlingLane bowlingLane;

    public BowlingBooking(){}

    public BowlingBooking(Customer customer, BowlingLane bowlingLane) {
        this.customer = customer;
        this.bowlingLane = bowlingLane;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BowlingLane getBowlingLane() {
        return bowlingLane;
    }

    public void setBowlingLane(BowlingLane bowlingLane) {
        this.bowlingLane = bowlingLane;
    }

}
