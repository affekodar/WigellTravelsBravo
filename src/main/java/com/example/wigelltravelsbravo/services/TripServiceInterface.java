package com.example.wigelltravelsbravo.services;

import com.example.wigelltravelsbravo.entities.Trip;

import java.util.List;

public interface TripServiceInterface {
    List<Trip> fetchAllTrips();
}
