package com.pillowlux.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "product", schema = "project0")
@Data @NoArgsConstructor @AllArgsConstructor 
@EqualsAndHashCode @ToString
@Entity
public class Product {
	@Id
	@Column(nullable=false)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String description;
	
	@Column(nullable=false)
	private String size;
	
	@Column(nullable=false)
	private int units;
	
	@Column
	private String comments;
	@Column (nullable=false)
	private float price;
	
	
	
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "orders")
	private Set<Order> orders = new HashSet<Order>();
	
	//@ManyToMany(mappedBy = "orders")
	//@JoinTable( name = "order_product", joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "order_id"))
	public Set<Order> getOrders(){
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders=orders;
	}

	//@ManyToMany
	   // Set<Products> likedCourses;
}