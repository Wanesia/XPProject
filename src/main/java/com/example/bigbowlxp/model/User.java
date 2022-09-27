package com.example.bigbowlxp.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String username;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    // Constructors
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Employee employee) {
        this.username = username;
        this.password = password;
        this.employee = employee;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Employee getEmployee() {
        return employee;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}