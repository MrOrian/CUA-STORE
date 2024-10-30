package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.Customer;

import java.util.List;

public interface CustomerRepositoryInterFace {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(long id);
    Customer getCustomerById(long id);
    List<Customer> getAllCustomers();
}
