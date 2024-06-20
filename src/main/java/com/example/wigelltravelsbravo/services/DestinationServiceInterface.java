package com.example.wigelltravelsbravo.services;

import com.example.wigelltravelsbravo.entities.Destination;

public interface DestinationServiceInterface {
    Destination addNewDestination(Destination destination);

    void deleteDestinationById(int id);

    Destination updateDestination(int id, Destination destination);

    Destination findDestinationById(int id);
}
