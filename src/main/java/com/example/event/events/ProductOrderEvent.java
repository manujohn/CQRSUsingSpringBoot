package com.example.event.events;

import org.springframework.stereotype.Component;

@Component
public class ProductOrderEvent {
	private String productOrderId;
	private long productId;
	private String productName;

	public String getProductOrderId() {
		return productOrderId;
	}

	public void setProductOrderId(String productOrderId) {
		this.productOrderId = productOrderId;
	}

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

	@Override
	public String toString() {
		return "ProductOrderEvent [productOrderId=" + productOrderId + ", productId=" + productId + ", productName="
				+ productName + "]";
	}
	
	
}
