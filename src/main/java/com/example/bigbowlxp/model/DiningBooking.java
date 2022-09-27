package com.example.bigbowlxp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dining_bookings")
public class DiningBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime start_date_time;

    @Column(name = "end_date_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime end_date_time;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "dining_table_id")
    private DiningTable diningTable;

    public DiningBooking() {
    }

    public DiningBooking(LocalDateTime start_date_time, LocalDateTime end_date_time, Customer customer, DiningTable diningTable) {
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;
        this.customer = customer;
        this.diningTable = diningTable;
    }

    public DiningBooking(Long id, LocalDateTime start_date_time, LocalDateTime end_date_time, Customer customer, DiningTable diningTable) {
        this.id = id;
        this.start_date_time = start_date_time;
        this.end_date_time = end_date_time;
        this.customer = customer;
        this.diningTable = diningTable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart_date_time() {
        return start_date_time;
    }

    public void setStart_date_time(LocalDateTime start_date_time) {
        this.start_date_time = start_date_time;
    }

    public LocalDateTime getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(LocalDateTime end_date_time) {
        this.end_date_time = end_date_time;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DiningTable getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(DiningTable diningTable) {
        this.diningTable = diningTable;
    }
}
