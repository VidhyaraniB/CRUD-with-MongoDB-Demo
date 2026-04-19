package com.example.mongodbdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodbdemo.model.Customer;
import com.example.mongodbdemo.repository.CustomerRepo;

@Service
public class CustomerServiceimpl implements CustomerService{
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customer=repo.findAll();
		return customer;
	}

	@Override
	public String addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		repo.save(customer);
		return "Customer Added Successfully";
	}

	@Override
	public String updateCustomers(Long id, Customer customer) {
		// TODO Auto-generated method stub
		  Optional<Customer> existingCustomerOpt = repo.findById(id);

		    if (existingCustomerOpt.isPresent()) {
		        Customer existingCustomer = existingCustomerOpt.get();

		        // Update fields explicitly
		        existingCustomer.setName(customer.getName());
		        existingCustomer.setAge(customer.getAge());
		        // add other fields as needed

		        repo.save(existingCustomer);
		        return "Customer Updated Successfully";
		    } else {
		        return "Customer with ID " + id + " not found";
		    }
	}

	@Override
	public String deleteCustomers(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Customer Deleted Successfully";
	}

}
