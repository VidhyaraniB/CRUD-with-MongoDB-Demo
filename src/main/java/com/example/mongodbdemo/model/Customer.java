package com.example.mongodbdemo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "customers")                     //Maps this class to a MongoDB collection
public class Customer {
	
	@Id
	private Long id;
	
	@Field("customer_name")                           //- Maps a Java field to a specific MongoDB field name.	
	private String name;
	
	@Field("customer_age") 
	private Long age;
	public Customer() {
		super();
	}
	public Customer(Long id, String name, Long age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
	
	

}
