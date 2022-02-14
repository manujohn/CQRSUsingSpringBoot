package com.example.event.events;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.event.entity.Product;
import com.example.event.repository.ProductRepo;

@Component
@ProcessingGroup("product")
public class ProductCreatedEventHandler {

	@Autowired
	public Product product;
	
	@Autowired
	public ProductRepo productRepo;
	
	@EventHandler
	public void on(ProductOrderEvent productOrderEvent) throws Exception{
		
		BeanUtils.copyProperties(productOrderEvent, product);
				
		productRepo.save(product);
		
		//throw new Exception("Error");
		
	}
	
	@ExceptionHandler
	public void handle(Exception exception) throws Exception {
		throw exception;
	}
}