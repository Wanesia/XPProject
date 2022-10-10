package com.example.bigbowlxp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bowling_bookings")
public class BowlingBooking {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateTime;

    @ManyToOne(cascade = CascadeType.ALL)//this allows us to send a customer without id
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "bowling_lane_id")
    private BowlingLane bowlingLane;

    // Constructors
    public BowlingBooking(){}

    public BowlingBooking(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public BowlingBooking(LocalDateTime startDateTime, LocalDateTime endDateTime, Customer customer, BowlingLane bowlingLane) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customer = customer;
        this.bowlingLane = bowlingLane;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
    public Customer getCustomer() {
        return customer;
    }
    public BowlingLane getBowlingLane() {
        return bowlingLane;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setStartDateTime(LocalDateTime start_date_time) {
        this.startDateTime = start_date_time;
    }
    public void setEndDateTime(LocalDateTime end_date_time) {
        this.endDateTime = end_date_time;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setBowlingLane(BowlingLane bowlingLane) {
        this.bowlingLane = bowlingLane;
    }
}
