package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataWithMongoDbApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataWithMongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		System.out.println("Customers found with findAll():");
    	System.out.println("-------------------------------");
		for(Customer c : repository.findAll()){
			System.out.println(c);
		}
		System.out.println();

		System.out.println("Customer found with findByFirstName('Alice'):");
    	System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));
		
		System.out.println("Customer found with findByLastName('Smith'):");
    	System.out.println("--------------------------------");
		System.out.println(repository.findByLastName("Smith"));
	}

}
