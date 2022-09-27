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


}
