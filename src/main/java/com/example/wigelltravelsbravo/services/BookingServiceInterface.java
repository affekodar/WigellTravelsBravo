package com.example.wigelltravelsbravo.services;

import com.example.wigelltravelsbravo.entities.Booking;

import java.util.List;

public interface BookingServiceInterface {
    Booking addNewBooking(Booking booking);

    Booking updateBooking(int id, Booking booking);

    List<Booking> fetchAllBookings();
}
