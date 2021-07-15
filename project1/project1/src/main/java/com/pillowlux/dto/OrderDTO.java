package com.pillowlux.dto;

public class OrderDTO {
	
	private int customerID;
	private String comments;
	private String city;
	
	private ProductDTO[] products;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ProductDTO[] getProducts() {
		return products;
	}

	public void setProducts(ProductDTO[] products) {
		this.products = products;
	}
	
	
}
