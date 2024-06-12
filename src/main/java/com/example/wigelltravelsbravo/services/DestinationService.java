package com.example.wigelltravelsbravo.services;

import com.example.wigelltravelsbravo.entities.Destination;
import com.example.wigelltravelsbravo.exceptions.ResourceNotFoundException;
import com.example.wigelltravelsbravo.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinationService implements DestinationServiceInterface{

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public Destination addNewDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public void deleteDestinationById(int id) {
        destinationRepository.deleteById(id);
    }

    @Override
    public Destination updateDestination(int id, Destination destination) {
        Destination updatedDestination = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination", "ID", id));

        if (destination.getCity() != null) {
            updatedDestination.setCity(destination.getCity());
        }
        if (destination.getCountry() != null) {
            updatedDestination.setCountry(destination.getCountry());
        }
        return destinationRepository.save(updatedDestination);
    }
}
