package com.pillowlux.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Table(name = "orders", schema = "project0")
@Data @NoArgsConstructor @AllArgsConstructor 
@EqualsAndHashCode @ToString
@Entity
public class Order {
	@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false, unique = true, updatable = false)
		private int id;
	
	//@ManyToMany
   // Set<Products> likedCourses;
	@Column(name = "customer_id", nullable = false, updatable = false)
	private int customerId;
	
	@Basic
	@JsonFormat (pattern = "yyyy-MMM-dd")
	private Timestamp date;
	
	@Column(name = "comments")
	private String comments;
	
	

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(
	  name = "order_product", 
	 joinColumns = @JoinColumn(name = "order_id"), 
	 inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> purchasedProduct=new HashSet<>();
	
	
	public Set<Product> getProducts(){
		return this.purchasedProduct;
	}
	
	public void setProducts(Set<Product> products) {
		this.purchasedProduct=products;
	}
	
	public Order( int customerId, Timestamp date, String comments) {
		super();
		this.customerId = customerId;
		this.date = date;
		this.comments = comments;
	}
	
	

}
