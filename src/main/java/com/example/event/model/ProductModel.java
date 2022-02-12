package com.example.event.model;

import org.springframework.stereotype.Component;

@Component
public class ProductModel {
	private long productId;
	private String productName;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
