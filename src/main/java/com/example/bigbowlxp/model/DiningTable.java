package com.example.bigbowlxp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dining_tables")
public class DiningTable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isBooked;

    // Constructors
    public DiningTable() {
    }

    public DiningTable(boolean isBooked) {
        this.isBooked = isBooked;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public boolean isBooked() {
        return isBooked;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setBooked(boolean booked) {
        isBooked = booked;
    }

}
