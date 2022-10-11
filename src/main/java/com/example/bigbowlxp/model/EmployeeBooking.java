package com.example.bigbowlxp.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_bookings")
public class EmployeeBooking {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Using a String here is dumb btw but it is what it is.
    @Column(name = "position")
    private String position;
    @Column(name = "shift_time")
    private Boolean shiftTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Constructors
    public EmployeeBooking() {
    }

    public EmployeeBooking(String position, Boolean shiftTime) {
        this.position = position;
        this.shiftTime = shiftTime;
    }

    public EmployeeBooking(String position, Boolean shiftTime, Employee employee) {
        this.position = position;
        this.shiftTime = shiftTime;
        this.employee = employee;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public Boolean getShiftTime() {
        return shiftTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setShiftTime(Boolean shiftTime) {
        this.shiftTime = shiftTime;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
