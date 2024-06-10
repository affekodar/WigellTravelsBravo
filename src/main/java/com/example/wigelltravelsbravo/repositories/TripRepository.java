package com.example.wigelltravelsbravo.repositories;

import com.example.wigelltravelsbravo.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
