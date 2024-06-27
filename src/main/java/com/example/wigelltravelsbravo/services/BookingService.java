package com.example.wigelltravelsbravo.services;

import com.example.wigelltravelsbravo.VO.Observation;
import com.example.wigelltravelsbravo.entities.Booking;
import com.example.wigelltravelsbravo.exceptions.ResourceNotFoundException;
import com.example.wigelltravelsbravo.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BookingService implements BookingServiceInterface {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking addNewBooking(Booking booking) {
        booking.setTotalPriceEUR(priceInEuro(booking.getTotalPriceSEK()));
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
            updatedBooking.setTotalPriceSEK(booking.getTotalPriceSEK());
            updatedBooking.setTotalPriceEUR(priceInEuro(updatedBooking.getTotalPriceSEK()));

        return bookingRepository.save(updatedBooking);
    }

    @Override
    public List<Booking> fetchAllBookings() {
        return bookingRepository.findAll();
    }

    public double priceInEuro(double sekPrice) {
        double eurToSek = 0;
        RestTemplate restTemplate = new RestTemplate();
        Observation[] array = restTemplate.getForObject("https://api.riksbank.se/swea/v1/Observations/SEKEURPMI/" + DateTimeFormatter.ofPattern("yyyy-MM-dd").format(DAYS.addTo(LocalDateTime.now(), -7)), Observation[].class);
        if (array != null) {
            List<Observation> observations = Arrays.asList(array);
            eurToSek = observations.get(observations.size() - 1).getValue();
        }
        return Math.round((sekPrice / eurToSek) * 100.0) / 100.0;
    }
}
