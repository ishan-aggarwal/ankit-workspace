package com.pillowlux.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pillowlux.dto.CustomerDTO;
import com.pillowlux.model.Customer;
import com.pillowlux.services.CustomerService;

@RestController
public class CustomerController  {
	private static Logger Log = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;
	public CustomerController() {
		Log.info("Started customer controller");
	}
	
	@GetMapping("/admin/customers/{id}")
	public ResponseEntity<Customer> getSingleCustomer (@PathVariable int id){
		
		Log.info("In getSingleCustomer handler");
		
		
		MDC.put("CustomerId", "" +id);
		
		Log.info("Fetching user");
		Customer retrievedCustomer = customerService.find(id);
		Log.info("User found: {}",retrievedCustomer.toString());
		
		MDC.clear();
		MDC.remove("CustomerId");
		return ResponseEntity.ok(retrievedCustomer);
	}

	@PostMapping("/customers")		
		public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO c){
			System.out.print(c);
			return ResponseEntity.ok(customerService.create(c)); 
	}
	
	
}
