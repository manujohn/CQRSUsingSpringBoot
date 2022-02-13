package com.example.event.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.event.entity.Product;
import com.example.event.repository.ProductRepo;

@Component
public class ProductCreatedEventHandler {

	@Autowired
	public Product product;
	
	@Autowired
	public ProductRepo productRepo;
	
	@EventHandler
	public void on(ProductOrderEvent productOrderEvent) {
		
		BeanUtils.copyProperties(productOrderEvent, product);
				
		productRepo.save(product);
		
		
	}
}
