package com.pillowlux.controllers;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pillowlux.dto.OrderDTO;
import com.pillowlux.model.Order;
import com.pillowlux.model.Product;
import com.pillowlux.services.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	private static Logger Log = LoggerFactory.getLogger(OrderController.class);
	

	@PostMapping("/order")
	public ResponseEntity<Order> createOrder(@RequestBody OrderDTO o)  {
		Log.info(o.toString());
		Order result = orderService.makePurchase(o);
		return ResponseEntity.ok(result);
	}
	

	@GetMapping( "/admin/mostPurchasedItem")
	public ResponseEntity<Product> getMostPurchasedItem() {
		return ResponseEntity.ok(orderService.mostPurchasedItem());
	}
	
	
	@GetMapping( "/admin/leastPurchasedItem")
	public ResponseEntity<Product> getLeastPurchasedItem() {
		Product result = orderService.leastPurchasedItem();
		return ResponseEntity.ok(orderService.mostPurchasedItem());
	}
	@GetMapping("/admin/averageOrderPrice")
	public ResponseEntity<String> getAverageOrderPrice(){
		double result = orderService.averageOrderPrice();
	       DecimalFormat df = new DecimalFormat("0.00");
		return ResponseEntity.ok("$" + df.format(result));
	}
	

}
