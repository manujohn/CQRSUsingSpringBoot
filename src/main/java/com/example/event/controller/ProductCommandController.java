package com.example.event.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.command.ProductCommand;
import com.example.event.model.ProductModel;

@RestController
@RequestMapping("/product")
public class ProductCommandController {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private ProductCommand productCommand;

	@PostMapping("/")
	public String orderProduct(@RequestBody ProductModel productModel) {

		productCommand.setProductOrderId(UUID.randomUUID().toString());
		productCommand.setProductId(productModel.getProductId());
		productCommand.setProductName(productModel.getProductName());

		return commandGateway.sendAndWait(productCommand);
	}
}
