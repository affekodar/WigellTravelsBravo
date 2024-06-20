package com.example.wigelltravelsbravo.services;

import com.example.wigelltravelsbravo.entities.Trip;
import com.example.wigelltravelsbravo.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService implements TripServiceInterface {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> fetchAllTrips() {
        return tripRepository.findAll();
    }
}
