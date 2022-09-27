package com.example.bigbowlxp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bowling_lane")
public class BowlingLane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean isBooked;

    private boolean IsInOrder;

    @OneToMany(mappedBy = "bowlingLane")
    private List<BowlingBooking> bowlingBookings;



    public BowlingLane(){}

    public BowlingLane(boolean isBooked, boolean isInOrder) {
        this.isBooked = isBooked;
        IsInOrder = isInOrder;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isInOrder() {
        return IsInOrder;
    }

    public void setInOrder(boolean inOrder) {
        IsInOrder = inOrder;
    }

    public List<BowlingBooking> getBowlingBookings() {
        return bowlingBookings;
    }

    public void setBowlingBookings(List<BowlingBooking> bowlingBookings) {
        this.bowlingBookings = bowlingBookings;
    }
}
