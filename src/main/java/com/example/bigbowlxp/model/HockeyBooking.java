package com.example.bigbowlxp.model;

import javax.persistence.*;

@Entity
@Table(name = "hockeybookings")
public class HockeyBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



}
