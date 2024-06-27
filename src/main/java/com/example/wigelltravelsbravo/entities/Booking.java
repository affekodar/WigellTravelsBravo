package com.example.wigelltravelsbravo.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bookings_travels")
public class Booking {

    @Column(name = "departure_date", length = 40)
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

    @Column(name = "hotel", length = 20)
    private String hotel;

    @Column(name = "total_price_sek")
    private double totalPriceSEK;


    @Column(name = "total_price_eur", nullable = true)
    private double totalPriceEUR;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public double getTotalPriceSEK() {
        return totalPriceSEK;
    }

    public void setTotalPriceSEK(double totalPriceSEK) {
        this.totalPriceSEK = totalPriceSEK;
    }

    public double getTotalPriceEUR() {
        return totalPriceEUR;
    }

    public void setTotalPriceEUR(double totalPriceEUR) {
        this.totalPriceEUR = totalPriceEUR;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
