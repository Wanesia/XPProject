package com.example.bigbowlxp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false, length = 25)
    private String firstName;

    @Column(nullable = true, unique = false, length = 25)
    private String lastName;

    @Column(nullable = true, unique = false, length = 16)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<BowlingBooking> bowlingBookings;


    public Customer(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Customer(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BowlingBooking> getBowlingBookings() {
        return bowlingBookings;
    }

    public void setBowlingBookings(List<BowlingBooking> bowlingBookings) {
        this.bowlingBookings = bowlingBookings;
    }
}
