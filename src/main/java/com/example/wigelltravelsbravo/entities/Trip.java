package com.example.wigelltravelsbravo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price_weekly")
    private double pricePerWeek;

    @Column(name = "hotel")
    private String hotel;


    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
