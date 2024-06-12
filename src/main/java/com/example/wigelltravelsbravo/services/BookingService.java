package com.example.wigelltravelsbravo.services;

import com.example.wigelltravelsbravo.entities.Booking;
import com.example.wigelltravelsbravo.exceptions.ResourceNotFoundException;
import com.example.wigelltravelsbravo.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements BookingServiceInterface{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking addNewBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(int id, Booking booking) {
        Booking updatedBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "ID", id));
        if (booking.getDepartureDate() != null) {
            updatedBooking.setDepartureDate(booking.getDepartureDate());
        }
        if (booking.getDestination() != null) {
            updatedBooking.setDestination(booking.getDestination());
        }
        if (booking.getHotel() != null) {
            updatedBooking.setHotel(booking.getHotel());
        }
        return bookingRepository.save(updatedBooking);
    }

    @Override
    public List<Booking> fetchAllBookings() {
        return bookingRepository.findAll();
    }
}
