package com.example.wigelltravelsbravo.controller;
import com.example.wigelltravelsbravo.entities.Customer;
import com.example.wigelltravelsbravo.entities.Destination;
import com.example.wigelltravelsbravo.services.CustomerService;
import com.example.wigelltravelsbravo.services.DestinationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v2")
public class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.fetchAllCustomers());
    }

    @PostMapping("/add-destination")
    public ResponseEntity<Destination> addNewDestination(@RequestBody Destination destination) {
        logger.info("admin added destination " + destination.getCity() + ", " + destination.getCountry());
        return ResponseEntity.ok(destinationService.addNewDestination(destination));
    }


    @DeleteMapping("/deletedestination/{id}")
    public void deleteDestination(@PathVariable int id) {
        Destination destination = destinationService.findDestinationById(id);
        logger.info("admin deleted destination " + destination.getCity() + ", " + destination.getCountry());
        destinationService.deleteDestinationById(id);
    }


    @PutMapping("/updatedestination/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable int id, @RequestBody Destination destination) {
        logger.info("admin updated destination with ID " + id);
        return ResponseEntity.ok(destinationService.updateDestination(id, destination));
    }
}
