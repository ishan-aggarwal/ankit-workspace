package com.pillowlux.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class CustomerPhonePk implements Serializable {
	//Adds UID for id
	
	private static final long serialVersionUID = 1L;
	@Column(name = "customer_id")
	private int id;
	
	@Column(name = "phone_number")
		private String phoneNbr;
	
	public CustomerPhonePk (int id, String phoneNbr) {
		this.id=id;
		this.phoneNbr=phoneNbr;
	}
	
	
	
	
	
}