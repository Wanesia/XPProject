package com.example.bigbowlxp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hockey_tables")
public class HockeyTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean isBooked;

    private boolean IsInOrder;

    @OneToMany(mappedBy = "hockeyTable")
    private List<HockeyBooking> hockeyBookings;

    public HockeyTable() {
    }

    public HockeyTable(boolean isBooked, boolean isInOrder, List<HockeyBooking> hockeyBookings) {
        this.isBooked = isBooked;
        IsInOrder = isInOrder;
        this.hockeyBookings = hockeyBookings;
    }

    public Integer getId() {
        return id;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public boolean isInOrder() {
        return IsInOrder;
    }
    public List<HockeyBooking> getHockeyBookings() {
        return hockeyBookings;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    public void setInOrder(boolean inOrder) {
        IsInOrder = inOrder;
    }
    public void setHockeyBookings(List<HockeyBooking> hockeyBookings) {
        this.hockeyBookings = hockeyBookings;
    }
}
