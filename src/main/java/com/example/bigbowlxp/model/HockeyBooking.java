package com.example.bigbowlxp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hockey_bookings")
public class HockeyBooking {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "hockey_tables_id")
    private HockeyTable hockeyTable;

    // Constructors
    public HockeyBooking() {
    }

    public HockeyBooking(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public HockeyBooking(LocalDateTime startDateTime, LocalDateTime endDateTime, Customer customer, HockeyTable hockeyTable) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customer = customer;
        this.hockeyTable = hockeyTable;
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
    public HockeyTable getHockeyTable() {
        return hockeyTable;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setHockeyTable(HockeyTable hockeyTable) {
        this.hockeyTable = hockeyTable;
    }

}
