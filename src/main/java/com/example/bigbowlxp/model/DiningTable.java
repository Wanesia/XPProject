package com.example.bigbowlxp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dining_tables")
public class DiningTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isBooked;

    @OneToMany(mappedBy = "diningTable")
    private List<DiningBooking> diningBookings;

    public DiningTable() {
    }

    public DiningTable(boolean isBooked, List<DiningBooking> diningBookings) {
        this.isBooked = isBooked;
        this.diningBookings = diningBookings;
    }

    public DiningTable(Long id, boolean isBooked, List<DiningBooking> diningBookings) {
        this.id = id;
        this.isBooked = isBooked;
        this.diningBookings = diningBookings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public List<DiningBooking> getDiningBookings() {
        return diningBookings;
    }

    public void setDiningBookings(List<DiningBooking> diningBookings) {
        this.diningBookings = diningBookings;
    }
}
