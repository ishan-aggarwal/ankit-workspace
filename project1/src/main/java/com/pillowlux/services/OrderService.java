package com.pillowlux.services;


import java.text.DateFormat;
import java.text.DecimalFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pillowlux.dto.OrderDTO;
import com.pillowlux.dto.ProductDTO;
import com.pillowlux.exceptions.CustomerNotFoundException;
import com.pillowlux.exceptions.ProductNotFoundException;
import com.pillowlux.model.Customer;
import com.pillowlux.model.Order;

import com.pillowlux.model.Product;
import com.pillowlux.repository.CustomerRepository;

import com.pillowlux.repository.OrderRepository;
import com.pillowlux.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderDAO;
	
	@Autowired
	private ProductRepository productDAO;
	
	@Autowired
	private CustomerRepository customerDAO;
	
	public DecimalFormat formatter = new DecimalFormat("0.00");

	public double averageAmountSpentPerOrder() {
		// get all the OrderProducts from DB
		// Create a key value map of OrderID -> List<ProductID>
		// For each order get the total amount and add that total amount to sum
		// Return the average amount
		return 0.0;
	}
	
	public Product mostPurchasedItem() {
		
		Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
		// get all the OrderProducts from DB
		List<Order> prods = orderDAO.findAll();
		if(prods.isEmpty()) {
			return null;
		}
		// Iterate through result list, grouping them by ProductID
		for(Order op : prods) {
			for(Product po: op.getProducts()) {
				Integer value = mapCount.get(po.getId());
				if(value == null) {
					mapCount.put(po.getId(), 1);
				}
				else {
					mapCount.put(po.getId(), value + 1);
				}
			}
			
		}
		// Iterate through the map to get the key with the highest value
		int id_of_highest_product = 0;
		int maximum = 0;
		for(Integer i : mapCount.keySet()) {
			if(mapCount.get(i) > maximum) {
				id_of_highest_product = i;
				maximum = mapCount.get(i);
			}
		}
		// Get the Product whose ID is that key and return
		Product product = productDAO.findById(id_of_highest_product).get();
		return product;
	}
	


	public Product leastPurchasedItem() {
		
		Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
		// get all the OrderProducts from DB
		List<Order> prods = orderDAO.findAll();
		if(prods.isEmpty()) {
			return null;
		}
		// Iterate through result list, grouping them by ProductID
		for(Order op : prods) {
			for(Product po: op.getProducts()) {
				Integer value = mapCount.get(po.getId());
				if(value == null) {
					mapCount.put(po.getId(), 1);
				}
				else {
					mapCount.put(po.getId(), value + 1);
				}
			}
			
		}
		// Iterate through the map to get the key with the highest value
		int id_of_lowest_product = 0;
		int minimum = Integer.MAX_VALUE;
		for(Integer i : mapCount.keySet()) {
			if(mapCount.get(i) < minimum) {
				id_of_lowest_product = i;
				minimum = mapCount.get(i);
			}
		}
		// Get the Product whose ID is that key and return
		Product product = productDAO.findById(id_of_lowest_product).get();
		return product;
	}
	
	
	public double averageOrderPrice() {
		System.out.println("In average order price, OrderService");
		List<Order> orders = orderDAO.findAll();
		if(orders.isEmpty()) {
			return 0;
		}
		System.out.println("found orders");
		float sum = 0;
		for(Order order : orders) {
			// FOr every order, find the OrderProduct objects belonging to that order
		
			for(Product product: order.getProducts()) {
				// fetch the product object
				
				if(product != null) {
					sum+=product.getPrice();
				}
			}
		}
		
		return sum/orders.size();
	}
	
	
	public Order makePurchase(OrderDTO orderDTO) {
		// confirm if customer exists
		System.out.println("Customer ID sought: " + orderDTO.getCustomerID());
		Customer cust = customerDAO.findById(orderDTO.getCustomerID()).get();
		System.out.println("Customer found " +cust);
		if(cust == null) {
			throw new CustomerNotFoundException("No customer found with id: " +orderDTO.getCustomerID());
		}
		
		// confirm if each product exists
		for(ProductDTO productID : orderDTO.getProducts()) {
			Product prod = productDAO.findById(productID.getProductID()).get();
			if(prod == null) {
				throw new ProductNotFoundException("No product found with id: "+ productID.getProductID());
			}
		}
		Calendar calendar = Calendar.getInstance();

		// 2) get a java.util.Date from the calendar instance.
//		    this date will represent the current instant, or "now".
		java.util.Date now = calendar.getTime();

		// 3) a java current time (now) instance
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		// if they both exist, create OrderProduct for each product in DTO and save them to DB
		// save Order to DB and get the ID
		Order order = new Order(orderDTO.getCustomerID(), currentTimestamp, orderDTO.getComments());
		// 1) create a java calendar instance
//		DateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
//		format.format(currentTimestamp);
		order.setDate(currentTimestamp);
		
		
		Set<Product> products= new HashSet<>();
		for(ProductDTO productID : orderDTO.getProducts()) {
			Product p = productDAO.findById(productID.getProductID()).get();
			
			products.add(p);	
		}
		order.setProducts(products);
		Order orderId = orderDAO.save(order);
		orderDAO.flush();
		return orderId;
		
	}
	
	

}
