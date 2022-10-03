package com.example.bigbowlxp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "dining_bookings")
public class DiningBooking {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "dining_table_id")
    private DiningTable diningTable;

    // Constructors
    public DiningBooking() {
    }

    public DiningBooking(LocalDateTime startDateTime, LocalDateTime end_date_time, Customer customer) {
        this.startDateTime = startDateTime;
        this.endDateTime = end_date_time;
        this.customer = customer;
    }

    public DiningBooking(LocalDateTime startDateTime, LocalDateTime end_date_time, Customer customer, DiningTable diningTable) {
        this.startDateTime = startDateTime;
        this.endDateTime = end_date_time;
        this.customer = customer;
        this.diningTable = diningTable;
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
    public DiningTable getDiningTable() {
        return diningTable;
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
    public void setDiningTable(DiningTable diningTable) {
        this.diningTable = diningTable;
    }

}
