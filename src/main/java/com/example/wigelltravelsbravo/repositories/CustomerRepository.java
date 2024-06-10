package com.example.wigelltravelsbravo.repositories;

import com.example.wigelltravelsbravo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
