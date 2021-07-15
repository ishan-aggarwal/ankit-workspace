package com.pillowlux.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.pillowlux.model.CustomerPhone;
@Repository
public interface CustomerPhoneRepository extends JpaRepository <CustomerPhone, Integer> {

}
