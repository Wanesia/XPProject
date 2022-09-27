package com.example.bigbowlxp.model;

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

    // Constructors
    public BowlingLane(){}

    public BowlingLane(boolean isBooked, boolean isInOrder) {
        this.isBooked = isBooked;
        this.isInOrder = isInOrder;
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
}
