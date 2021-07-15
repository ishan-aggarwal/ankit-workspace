package com.pillowlux.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.pillowlux.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

//have spring create DAO for customer by giving this page the data type for the primary key field 
//and the name of the model class 
