package com.example.wigelltravelsbravo.controller;

import com.example.wigelltravelsbravo.entities.Booking;
import com.example.wigelltravelsbravo.entities.Trip;
import com.example.wigelltravelsbravo.services.BookingService;
import com.example.wigelltravelsbravo.services.TripService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private TripService tripService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/trips")
    public ResponseEntity<List<Trip>> getTrips() {
        return ResponseEntity.ok(tripService.fetchAllTrips());
    }

    @PostMapping("/booktrip")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        logger.info("customer added booking to " + booking.getDestination().getCity() + ", " + booking.getDestination().getCountry());
       return ResponseEntity.ok(bookingService.addNewBooking(booking));
    }


    @PutMapping("/updatetrip/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        logger.info("customer updated booking with ID " + booking.getId());
        return ResponseEntity.ok(bookingService.updateBooking(id, booking));
    }


    @GetMapping("/mybookings")
    public ResponseEntity<List<Booking>> getBookings() {
        return ResponseEntity.ok(bookingService.fetchAllBookings());
    }
}
