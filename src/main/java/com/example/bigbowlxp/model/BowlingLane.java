package com.example.bigbowlxp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bowling_lane")
public class BowlingLane {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isBooked;

    private boolean isInOrder;

    @OneToMany(mappedBy = "bowlingLane")
    @JsonBackReference
    private List<BowlingBooking> bowlingBookings;

    // Constructors
    public BowlingLane(){}

    public BowlingLane(boolean isBooked, boolean isInOrder) {
        this.isBooked = isBooked;
        this.isInOrder = isInOrder;
    }

    public BowlingLane(boolean isBooked, boolean isInOrder, List<BowlingBooking> bowlingBookings) {
        this.isBooked = isBooked;
        this.isInOrder = isInOrder;
        this.bowlingBookings = bowlingBookings;
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
    public List<BowlingBooking> getBowlingBookings() {
        return bowlingBookings;
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
    public void setBowlingBookings(List<BowlingBooking> bowlingBookings) {
        this.bowlingBookings = bowlingBookings;
    }
}
