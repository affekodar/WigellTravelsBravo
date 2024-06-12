package com.example.wigelltravelsbravo.controller;

import com.example.wigelltravelsbravo.entities.Customer;
import com.example.wigelltravelsbravo.entities.Destination;
import com.example.wigelltravelsbravo.services.CustomerService;
import com.example.wigelltravelsbravo.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class AdminController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/cusotmers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.fetchAllCustomers());
    }

    @PostMapping("/add-destination")
    public ResponseEntity<Destination> addNewDestination(Destination destination) {
        return ResponseEntity.ok(destinationService.addNewDestination(destination));
    }


    @DeleteMapping("/deletedestination/{id}")
    public void deleteDestination(@PathVariable int id) {
        destinationService.deleteDestinationById(id);
    }


    @PutMapping("/updatedestination/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable int id, @RequestBody Destination destination) {
        return ResponseEntity.ok(destinationService.updateDestination(id, destination));
    }
}
