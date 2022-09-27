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

    @OneToMany(mappedBy = "diningTable")
    private List<DiningBooking> diningBookings;


    // Constructors
    public DiningTable() {
    }

    public DiningTable(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public DiningTable(boolean isBooked, List<DiningBooking> diningBookings) {
        this.isBooked = isBooked;
        this.diningBookings = diningBookings;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public List<DiningBooking> getDiningBookings() {
        return diningBookings;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    public void setDiningBookings(List<DiningBooking> diningBookings) {
        this.diningBookings = diningBookings;
    }

}
