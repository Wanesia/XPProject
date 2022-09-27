package com.example.bigbowlxp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hockey_tables")
public class HockeyTable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isBooked;

    private boolean isInOrder;

    @OneToMany(mappedBy = "hockeyTable")
    private List<HockeyBooking> hockeyBookings;

    // Constructors
    public HockeyTable() {
    }

    public HockeyTable(boolean isBooked, boolean isInOrder) {
        this.isBooked = isBooked;
        this.isInOrder = isInOrder;
    }

    public HockeyTable(boolean isBooked, boolean isInOrder, List<HockeyBooking> hockeyBookings) {
        this.isBooked = isBooked;
        this.isInOrder = isInOrder;
        this.hockeyBookings = hockeyBookings;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public boolean isInOrder() {
        return isInOrder;
    }
    public List<HockeyBooking> getHockeyBookings() {
        return hockeyBookings;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    public void setInOrder(boolean inOrder) {
        isInOrder = inOrder;
    }
    public void setHockeyBookings(List<HockeyBooking> hockeyBookings) {
        this.hockeyBookings = hockeyBookings;
    }

}
