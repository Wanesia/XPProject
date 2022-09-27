package com.example.bigbowlxp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "hockey_bookings")
public class HockeyBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endDateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "hockey_tables_id")
    private HockeyTable hockeyTable;

    public HockeyBooking() {
    }

    public HockeyBooking(LocalDateTime startDateTime, LocalDateTime endDateTime, Customer customer, HockeyTable hockeyTable) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customer = customer;
        this.hockeyTable = hockeyTable;
    }

    public Integer getId() {
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
