package com.example.wigelltravelsbravo.repositories;

import com.example.wigelltravelsbravo.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
