package com.example.bigbowlxp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false, length = 25)
    private String firstName;

    @Column(nullable = true, unique = false, length = 25)
    private String lastName;

    @Column(nullable = true, unique = false, length = 16)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<BowlingBooking> bowlingBookings;

    // Constructors
    public Customer(){}

    public Customer(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName, String phoneNumber, List<BowlingBooking> bowlingBookings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.bowlingBookings = bowlingBookings;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public List<BowlingBooking> getBowlingBookings() {
        return bowlingBookings;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setBowlingBookings(List<BowlingBooking> bowlingBookings) {
        this.bowlingBookings = bowlingBookings;
    }

}
