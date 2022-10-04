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

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String category;

    // Constructors
    public Stock() {
    }





    public Stock(String name, Integer quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
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
    public String getCategory() {return category;}

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
    public void setCategory(String category) {this.category = category;}
}
