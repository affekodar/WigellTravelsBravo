package com.example.wigelltravelsbravo.services;

import com.example.wigelltravelsbravo.entities.Customer;

import java.util.List;

public interface CustomerServiceInterface {
    List<Customer> fetchAllCustomers();
}
