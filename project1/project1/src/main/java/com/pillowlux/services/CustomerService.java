package com.pillowlux.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pillowlux.dto.CustomerDTO;
import com.pillowlux.model.Customer;
import com.pillowlux.repository.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerDAO;	

	public Customer find(int id) {
		System.out.println("In find service");
		Optional<Customer> cust = customerDAO.findById(id);
		if(!cust.isEmpty()) {
			return cust.get();
		}
		else {
			return new Customer();
		}
	
	}
	public Customer create(CustomerDTO customer) {
		Customer cc = new Customer();
		cc.setAddress(customer.getAddress());
		cc.setCity(customer.getCity());
		cc.setDob(customer.getDob());
		cc.setEmail(customer.getEmail());
		cc.setFName(customer.getfName());
		cc.setLName(customer.getlName());
		cc.setPassword(customer.getPassword());
		cc.setState(customer.getState());
		cc.setDateOfBirth(LocalDate.now());
		System.out.println("In create service");
		return customerDAO.save(cc); 
	}
}
	