package com.example.mongodbdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodbdemo.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long> {

}
