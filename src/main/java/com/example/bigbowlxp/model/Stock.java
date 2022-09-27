package com.example.bigbowlxp.model;

import javax.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String name;

    @Column(columnDefinition = "INTEGER(10) NOT NULL")
    private Integer quantity;

    // Constructors
    public Stock() {
    }

    public Stock(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getQuantity() {
        return quantity;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
