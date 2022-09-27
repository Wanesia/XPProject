package com.example.bigbowlxp.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String username;
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User(String username, String password, Employee employee) {
        this.username = username;
        this.password = password;
        this.employee = employee;
    }

    public User() {
    }

    public Integer getId() {
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