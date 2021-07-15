package com.pillowlux.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class CustomerPhone {
	@EmbeddedId
    CustomerPhonePk customerPhonePk ;
	
	@Column(name = "private_comments")
	private String privateComments;

	
	
	
	
	
	
	


}
