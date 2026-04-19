package com.example.mongodbdemo.service;

import java.util.List;

import com.example.mongodbdemo.model.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	String addCustomer(Customer customer);

	String updateCustomers(Long id, Customer customer);

	String deleteCustomers(Long id);

}
