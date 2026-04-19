package com.example.mongodbdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbdemo.model.Customer;
import com.example.mongodbdemo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getCustomers()
	{
		List<Customer> customers=service.getCustomers();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addCustomers(@RequestBody Customer customer)
	{
		 return  new ResponseEntity<>(service.addCustomer(customer),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateCustomers(@PathVariable Long id,@RequestBody Customer customer) {
		return new ResponseEntity<>(service.updateCustomers(id,customer),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomers(@PathVariable Long id)
	{
		return new ResponseEntity<>(service.deleteCustomers(id),HttpStatus.OK);
	}

}
