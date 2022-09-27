package com.example.bigbowlxp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String firstName;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String lastName;

    @Column(columnDefinition = "VARCHAR(16) NOT NULL")
    private String telephone;

    @Column(name = "birth_date", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Constructors
    public Employee() {
    }

    public Employee(String firstName, String lastName, String telephone, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.birthDate = birthDate;
    }

    public Employee(String firstName, String lastName, String telephone, LocalDate birthDate, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.user = user;
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
    public String getTelephone() {
        return telephone;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public User getUser() {
        return user;
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
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setUser(User user) {
        this.user = user;
    }

}